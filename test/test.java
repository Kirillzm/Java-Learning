package test;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        int[][] matrix = new int[height][width];

        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        matrix[0][3] = 1;

        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;

        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        matrix[2][3] = 1;


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    res.add(matrix[i]);
                    break;
                }
            }
        }

        while (res.size()<width-1) {
            res.add(0, new int[width]);
        }

        matrix = res.toArray(new int [height][width]);

        System.out.println("AFTER: ");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
