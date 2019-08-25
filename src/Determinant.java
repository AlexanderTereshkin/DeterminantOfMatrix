public class Determinant {
    // Minimal and maximum value of range of values, which will be randomly fill the array.
    private int min;
    private int max;

    private int size; // Size of a square matrix

    private int[][] array;

    public Determinant(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
        array = new int[size][size];

        /**
         * Fill the matrix with random value in th range of min and max values
         */
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = min + (int) (Math.random()*(max - min + 1));
            }
        }
    }

    public int[][] getArray() {
        return array;
    }

    public void displayMatrix() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public long countDeterminant(int array[][]) {
        long det;
        if(array.length == 2) {
            det = getSimpleDeterminant(array);
        } else {
            det = 0;
            for (int j = 0; j < array.length; j++) {
                if (j % 2 == 0) {
                    det += array[0][j] * countDeterminant(getMinor(array, j));
                } else {
                    det -= array[0][j] * countDeterminant(getMinor(array, j));
                }
            }
        }
        return det;
    }

    // Private method for finding minor of current element in first row in matrix array[][], and present column)
    private int[][] getMinor(int array[][], int column) {
        int minor[][] = new int[array.length - 1][array.length - 1];
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int rowMinor = i - 1;
                int columnMinor;
                if (j > column) {
                    columnMinor = j - 1;
                } else {
                    columnMinor = j;
                }
                if (j != column) {
                    minor[rowMinor][columnMinor] = array[i][j];
                }
            }
        }
        return minor;
    }

    // Calculate determinant of matrix 2х2 (This method private, because it must be used only inside Class Determinant)
    private int getSimpleDeterminant(int array[][]) {
        return (array[0][0] * array[1][1] - array[0][1] * array[1][0]);
    }
}
