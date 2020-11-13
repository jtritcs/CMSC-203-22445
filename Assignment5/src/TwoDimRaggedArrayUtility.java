import jdk.jshell.SourceCodeAnalysis;

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
    /**
     * Returns the average of the elements in the two dimensional array
     */
    public static double getAverage(double[][] data) {
        double sum = 0;
        int totalLength = 0;
        for (double[] row : data) {
            for (double i : row) {
                sum += i;
                totalLength++;
            }
        }
        return sum / totalLength;
    }

    /**
     *  Returns the total of the selected column in the two dimensional array index 0 refers to the first column.
     */
    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;
        for (double[] row : data) {
            if (col >= row.length) continue;
            sum += row[col];
        }
        return sum;
    }

    /**
     * Returns the largest element in the two dimensional array
     */
    public static double getHighestInArray(double[][] data) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data)
            for (double i : row)
                if (i > highest) highest = i;
        return highest;
    }

    /**
     * Returns the largest element of the selected column in
     * the two dimensional array index 0 refers to the first column.
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) {
            if (col >= row.length) continue;
            if (row[col] > highest) highest = row[col];
        }
        return highest;
    }

    /**
     * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
     */
    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        for (double i : data[row]) {
            if (i > highest) highest = i;
        }
        return highest;
    }

    /**
     * Returns the smallest element in the two dimensional array
     */
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data)
            for (double i : row)
                if (i < lowest) lowest = i;
        return lowest;
    }

    /**
     * Returns the smallest element of the selected column in the two dimensional array
     * index 0 refers to the first column.
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data) {
            if (col >= row.length) continue;
            if (row[col] < lowest) lowest = row[col];
        }
        return lowest;
    }

    /**
     * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
     */
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.MAX_VALUE;
        for (double i : data[row]) {
            if (i < lowest) lowest = i;
        }
        return lowest;
    }

    /**
     * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
     */
    public static double getRowTotal(double[][] data, int row) {
        double sum = 0;
        for (double i : data[row]) {
            sum += i;
        }
        return sum;
    }

    /**
     * Returns the total of all the elements of the two dimensional array
     */
    public static double getTotal(double[][] data) {
        double sum = 0;
        for (double[] row : data)
            for (double i : row)
                sum += i;
        return sum;
    }

    /**
     *  Returns index of the largest element of the selected
     *  column in the two dimensional array index 0 refers to the first column.
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            double[] row = data[i];
            if (row[col] > highest) {
                highest = row[col];
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns the largest element of the selected row in
     * the two dimensional array index 0 refers to the first row.
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = -1;
        double highest = Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            double rowValue = data[row][i];
            if (rowValue > highest) {
                highest = rowValue;
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns the index of the smallest element of the selected row in
     * the two dimensional array index 0 refers to the first row.
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = -1;
        double lowest = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            double rowValue = data[row][i];
            if (rowValue < lowest) {
                lowest = rowValue;
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns the index of the smallest element of the selected column in
     * the two dimensional array index 0 refers to the first column.
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            double[] row = data[i];
            if (col >= row.length) continue;
            if (i == 0) lowest = data[i][col];
            if (row[col] < lowest) {
                lowest = row[col];
                index = i;
            }
        }
        return index;
    }

    /**
     * Reads from a file and returns a ragged array of doubles The maximum rows is 10
     * and the maximum columns for each row is 10 Each row in the file is separated by
     * a new line Each element in the row is separated by a space
     */
    public static double[][] readFile(java.io.File file) {
        double[][] data = new double[0][0];
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));

            String[][] stringValueArray = new String[10][10];
            int lineIndex = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                // Can be replaced with System.arrayCopy
                for (int i = 0; i < line.length; i++) {
                    String stringValue = line[i];
                    stringValueArray[lineIndex][i] = stringValue;
                }
                lineIndex++;
            }

            int rows = 0;
            for (String[] row : stringValueArray) {
                if (row[0] != null) rows++;
            }

            data = new double[rows][];

            int dataRow = 0;
            for (String[] row : stringValueArray) {
                int cols = 0;
                for (String nonNull : row) {
                    if (nonNull != null)
                        cols++;
                    else
                        break; // Stop loop here
                }

                double[] rowValues = new double[cols];
                for (int i = 0; i < cols; i++) {
                    rowValues[i] = Double.parseDouble(row[i]);
                }

                if (data.length > dataRow)
                    data[dataRow] = rowValues;
                dataRow++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Writes the ragged array of doubles into the file.
     */
    public static void writeToFile(double[][] data, java.io.File outputFile) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(outputFile);
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            boolean isFirst = true;
            for (double col : row) {
                if (isFirst) sb.append(col);
                else sb.append(" ").append(col);
                isFirst = false;
            }

            sb.append("\n");
        }

        printWriter.write(sb.toString());
        printWriter.close();
    }


}
