package HeapSort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FaseHeapsort {
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
            writer.println("HEAPSORT");
            writer.println(totalClassificados);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
    
    public static void ordenarVetor(int[] a, int esq, int dir) {
    int n = dir - esq + 1; // Tamanho do intervalo
    int i = n / 2, pai, filho, t;

    while (true) {
        if (i > 0) {
            i--;
            t = a[esq + i];
        } else {
            n--;
            if (n <= 0) return;
            t = a[esq + n];
            a[esq + n] = a[esq]; // Move o menor para o fim do intervalo atual
        }

        pai = i;
        filho = i * 2 + 1;

        // Lógica de "afundar" o elemento (Heapify)
        while (filho < n) {
            // Para ordem DECRESCENTE: buscamos o MENOR filho para trocar
            if ((filho + 1 < n) && (a[esq + filho + 1] < a[esq + filho])) {
                filho++;
            }
            // Se o filho for menor que o elemento 't', ele sobe na árvore
            if (a[esq + filho] < t) {
                a[esq + pai] = a[esq + filho];
                pai = filho;
                filho = pai * 2 + 1;
            } else {
                break;
            }
        }
        a[esq + pai] = t;
        }
    }
}
