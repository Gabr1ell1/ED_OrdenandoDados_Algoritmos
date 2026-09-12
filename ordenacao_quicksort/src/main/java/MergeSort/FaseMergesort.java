package MergeSort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//TEMP = TEMPORÁRIO = AUX
public class FaseMergesort {
    public static void main(String[] args) {
        String arquivoEntrada = "entrada.txt";
        String arquivo = "saida.txt";

        try {
            Scanner scanner = new Scanner(new File(arquivoEntrada));
            if (!scanner.hasNextInt()) return;
            
            int n = scanner.nextInt(); 
            int k = scanner.nextInt(); 
            
            //vetor com as notas
            int[] notas = new int[n];

            //lendo o vetor
            for (int i = 0; i < n; i++) {
                notas[i] = scanner.nextInt();
            }
            scanner.close();

            ordenarVetor(notas, 0, n - 1);

            int notaCorte = notas[k - 1];
            int totalClassificados = k;

            for (int i = k; i < n; i++) {
                if (notas[i] == notaCorte) {
                    totalClassificados++;
                } else {
                    break; 
                }
            }

            PrintWriter writer = new PrintWriter(new FileWriter(arquivo));
            writer.println("MERGESORT");
            writer.println(totalClassificados);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
    
    
    public static void ordenarVetor(int[] vetor, int esq, int dir) {
    if (esq < dir) {
        // Divide o vetor ao meio
        int meio = (esq + dir) / 2; 

        // Conquista: ordena as duas metades recursivamente
        ordenarVetor(vetor, esq, meio);
        ordenarVetor(vetor, meio + 1, dir);

        // Combina: intercala as duas metades ordenadas
        intercalar(vetor, esq, meio, dir); 
    }
}

private static void intercalar(int[] vetor, int esq, int meio, int dir) {
    // Vetor temporário para auxiliar na mesclagem 
    int[] vetorTemp = new int[dir - esq + 1];
    int i = esq;      // Índice da primeira metade
    int j = meio + 1; // Índice da segunda metade
    int k = 0;        // Índice do vetor temporário

    // Enquanto houver elementos em ambas as metades
    while (i <= meio && j <= dir) {
        // Para ordem DECRESCENTE: escolhemos o MAIOR elemento primeiro
        if (vetor[i] >= vetor[j]) {
            vetorTemp[k] = vetor[i];
            i++;
        } else {
            vetorTemp[k] = vetor[j];
            j++;
        }
        k++;
    }

    // Copia os elementos restantes da primeira metade, se houver
    while (i <= meio) {
        vetorTemp[k++] = vetor[i++];
    }

    // Copia os elementos restantes da segunda metade, se houver
    while (j <= dir) {
        vetorTemp[k++] = vetor[j++];
    }

    // Copia os dados do vetor temporário de volta para o original 
    for (i = 0; i < vetorTemp.length; i++) {
        vetor[esq + i] = vetorTemp[i];
    }
}
}
