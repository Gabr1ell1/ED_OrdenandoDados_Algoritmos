package SelectionSort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FaseSelectionsort {
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
            writer.println("SELECTIONSORT");
            writer.println(totalClassificados);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
    
    public static void ordenarVetor(int[] vetor, int esq, int dir) {
    // O laço externo percorre o vetor até o penúltimo elemento do intervalo
    for (int i = esq; i < dir; i++) {
        int max_idx = i; // Assume inicialmente que o atual é o maior
        
        // O laço interno busca o maior elemento no restante do vetor
        for (int j = i + 1; j <= dir; j++) {
            // Para ordem DECRESCENTE: verificamos se o elemento atual é MAIOR que o nosso máximo salvo
            if (vetor[j] > vetor[max_idx]) {
                max_idx = j; // Atualiza o índice do maior elemento encontrado
            }
        }
        
        // Realiza a troca (swap) do maior elemento encontrado com a posição i
        int temp = vetor[max_idx];
        vetor[max_idx] = vetor[i];
        vetor[i] = temp;
    }
}
    
    
    
    
    
    
    
    
    
    
}
