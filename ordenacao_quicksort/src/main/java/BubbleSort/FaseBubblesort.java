package BubbleSort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FaseBubblesort {
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

            //se houver empate com a nota do k-ésimo, todos com a mesma nota se classificam.
            for (int i = k; i < n; i++) {
                if (notas[i] == notaCorte) {
                    totalClassificados++;
                } else {
                    break; 
                }
            }

            PrintWriter writer = new PrintWriter(new FileWriter(arquivo));
            writer.println("BUBBLESORT");
            writer.println(totalClassificados);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }

     public static void ordenarVetor(int v[], int esq, int dir) {
    // n é o número de elementos no intervalo a ser ordenado
    int n = dir - esq + 1; 
    
    // Laço externo controla as passagens (iterações) [3, 5]
    for (int i = n; i >= 1; i--) {
        // Laço interno compara elementos adjacentes [1, 2]
        for (int j = 1; j < i; j++) {
            // Para ordem DECRESCENTE: se o anterior for MENOR que o próximo, troca
            if (v[j - 1] < v[j]) { 
                int aux = v[j];
                v[j] = v[j - 1];
                v[j - 1] = aux; // Realiza a troca (swap) [3, 4]
            }
        }
    }
}

     
}
