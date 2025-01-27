package org.example;

import org.apache.commons.math3.complex.Complex;

public class Main {
    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 3},
                {4, 6},
                {8}
        };

        int[] columnSizes = new int[array.length];

        for(int i = 0; i < array.length; i++){
            columnSizes[i] = array[i].length;
        }

        for (int col = 0; col < array[0].length; col++) {
            int colSum = 0;
            for (int row = 0; row < array.length; row++) {
                colSum += array[row][col];
            }
            System.out.println(colSum);

        }




    }

    private static void transpose(int[][] array) {
        int[][] transpose = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                transpose[j][i] = array[i][j];
            }
        }

        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] > max) {
                    max = array[row][col];
                }
            }
        }
        System.out.println(max);
    }

    private static void sum2dArray(int[][] array) {
        int sum = 0;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                sum += array[row][col];
            }
        }

        System.out.println(sum);
    }

}