package main;

import BubbleSort.FaseBubblesort;
import InsertionSort.FaseInsertionsort;
import SelectionSort.FaseSelectionsort;
import Quicksort.FaseQuicksort;
import MergeSort.FaseMergesort;
import HeapSort.FaseHeapsort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String arquivoEntrada = "entrada.txt";
        String arquivoSaida = "saida.txt";

        try {
            Scanner scanner = new Scanner(new File(arquivoEntrada));

            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
             //vetor com as notas
            int[] notas = new int[n];
            int notaCorte = notas[k - 1];
            //lendo o vetor
            for (int i = 0; i < n; i++) {
                notas[i] = scanner.nextInt();
            }
            scanner.close();


            // =========================
            // CÓPIAS PARA CADA ALGORITMO
            // =========================

            int[] bubble = Arrays.copyOf(notas, n);
            int[] insertion = Arrays.copyOf(notas, n);
            int[] selection = Arrays.copyOf(notas, n);
            int[] quick = Arrays.copyOf(notas, n);
            int[] merge = Arrays.copyOf(notas, n);
            int[] heap = Arrays.copyOf(notas, n);


            // =========================
            // ORDENAÇÃO
            // =========================

            FaseBubblesort.ordenarVetor(bubble, 0, n - 1);
            FaseInsertionsort.ordenarVetor(insertion, 0, n - 1);
            FaseSelectionsort.ordenarVetor(selection, 0, n - 1);
            FaseQuicksort.ordenarVetor(quick, 0, n - 1);
            FaseMergesort.ordenarVetor(merge, 0, n - 1);
            FaseHeapsort.ordenarVetor(heap, 0, n - 1);


            int totalClassificados = k;

            //se houver empate com a nota do k-ésimo, todos coom a mesma nota se classificam.
            for (int i = k; i < n; i++) {
                if (notas[i] == notaCorte) {
                    totalClassificados++;
                } else {
                    break; 
                }
            }

            PrintWriter writer = new PrintWriter(new FileWriter(arquivoSaida));
            writer.println("BUBBLESORT");
            writer.println(totalClassificados);

            writer.println();

            writer.println("INSERTIONSORT");
            writer.println(totalClassificados);

            writer.println();

            writer.println("SELECTIONSORT");
            writer.println(totalClassificados);

            writer.println();

            writer.println("QUICKSORT");
            writer.println(totalClassificados);

            writer.println();

            writer.println("MERGESORT");
            writer.println(totalClassificados);

            writer.println();

            writer.println("HEAPSORT");
            writer.println(totalClassificados);

            writer.close();

        
            System.out.println("Resultados gravados em " + arquivoSaida);

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
}