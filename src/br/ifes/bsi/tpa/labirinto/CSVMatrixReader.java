package br.ifes.bsi.tpa.labirinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVMatrixReader {

    private int[][] matrix;
    private int rows;
    private int cols;

    public CSVMatrixReader(String filePath) throws IOException {
        readCSV(filePath);
    }

    private void readCSV(String filePath) throws IOException {
        List<int[]> matrixList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int[] row = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                row[i] = Integer.parseInt(values[i].trim());
            }
            matrixList.add(row);
        }

        br.close();

        // Convert List to 2D array
        rows = matrixList.size();
        cols = matrixList.get(0).length;
        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = matrixList.get(i);
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
