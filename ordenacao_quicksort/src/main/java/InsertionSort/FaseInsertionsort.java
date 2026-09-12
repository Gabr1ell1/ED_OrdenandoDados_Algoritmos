package InsertionSort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FaseInsertionsort {
    public static void main(String[] args) {
        String arquivoEntrada = "entrada.txt";
        String arquivo = "saida.txt";

        try {
            Scanner scanner = new Scanner(new File(arquivoEntrada));
            if (!scanner.hasNextInt()) return;
            
            int n = scanner.nextInt(); 
            int k = scanner.nextInt(); 
            int[] notas = new int[n];

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
            writer.println("INSERTIONSORT");
            writer.println(totalClassificados);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }

    
    public static void ordenarVetor(int[] vetor, int esq, int dir) {
    int i, j, chave;
    // O algoritmo começa a partir do segundo elemento do intervalo [1]
    for (j = esq + 1; j <= dir; j++) {
        chave = vetor[j]; // O elemento que queremos posicionar [3]
        i = j - 1;

        // Desloca os elementos para a direita para abrir espaço [1]
        // Para ordem DECRESCENTE: movemos quem for MENOR que a chave
        while ((i >= esq) && (vetor[i] < chave)) {
            vetor[i + 1] = vetor[i];
            i--;
        }
        // Insere a chave na posição correta encontrada [3]
        vetor[i + 1] = chave;
    }
}
    
    
    
    
    
    
}
