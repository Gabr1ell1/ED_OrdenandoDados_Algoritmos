package Quicksort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FaseQuicksort {
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

            // Ordenação usando QuickSort (Ordem Decrescente)
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
            writer.println("QUICKSORT");
            writer.println(totalClassificados);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }

    //ordem DECRESCENNTE
    public static void ordenarVetor(int[] notas, int esq, int dir) {
        if (esq < dir) {
            int pivoIndice = particionar(notas, esq, dir);
            ordenarVetor(notas, esq, pivoIndice);
            ordenarVetor(notas, pivoIndice + 1, dir);
        }
    }

    private static int particionar(int[] notas, int esq, int dir) {
        // Escolha do pivô (elemento principal) é sempre o do meio porque reparti de forma mais equilibrada
        int pivo = notas[(esq + dir) / 2];
        int i = esq - 1;
        int j = dir + 1;

        while (true) {
            // Para ordem DECRESCENTE, invertemos a comparação:
            // Procuramos elementos menores que o pivô à esquerda
            do { i++; } while (notas[i] > pivo);
            // Procuramos elementos maiores que o pivô à direita
            do { j--; } while (notas[j] < pivo);
            if (i >= j) return j;

          
            int temp = notas[i]; 
            notas[i] = notas[j];
            notas[j] = temp;
        }
    }
}