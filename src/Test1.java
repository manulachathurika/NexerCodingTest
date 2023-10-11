public class Test1 {

    private static int consecutiveCount = 4;

    public static String txt =
                    "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"+
                    "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"+
                    "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"+
                    "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"+
                    "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"+
                    "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"+
                    "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"+
                    "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"+
                    "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"+
                    "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"+
                    "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"+
                    "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"+
                    "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"+
                    "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"+
                    "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"+
                    "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"+
                    "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"+
                    "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"+
                    "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"+
                    "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
    public static void main(String[] args) {
        System.out.println("Coding Test 1:\n");

        if (consecutiveCount <= 3) {
            System.out.println("Minimun consecutive count number should be 4");
            return;
        }

        // Create a two-dimensional array to store the numbers
        int twoDArray[][] = createTwoDArray(txt);

        int maxProductInRows = findMaxProductsInRows(twoDArray, consecutiveCount);
        int maxProductInCols = findMaxProductsInCols(twoDArray, consecutiveCount);
        int maxProductInDiagonals = findMaxProductsInDiagonals(twoDArray, consecutiveCount);

        System.out.println("\nHighest possible product you can get from 4 numbers that are next to each other, either\n" +
                "in a row, column, diagonal or anti-diagonal for the given string is : " +
                Math.max(maxProductInRows, Math.max(maxProductInCols, maxProductInDiagonals)));
    }

    private static int findMaxProductsInDiagonals(int[][] twoDArray, int consecutiveCount) {

        int maxProduct = Integer.MIN_VALUE;

        // Iterate through diagonals from top-left to bottom-right
        for (int row = 0; row <= twoDArray.length - consecutiveCount; row++) {
            for (int col = 0; col <= twoDArray[0].length - consecutiveCount; col++) {
                int product = 1;
                for (int i = 0; i < consecutiveCount; i++) {
                    product *= twoDArray[row + i][col + i];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }

        // Iterate through diagonals from top-right to bottom-left
        for (int row = 0; row <= twoDArray.length - consecutiveCount; row++) {
            for (int col = twoDArray[0].length - 1; col >= consecutiveCount - 1; col--) {
                int product = 1;
                for (int i = 0; i < consecutiveCount; i++) {
                    product *= twoDArray[row + i][col - i];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }

        System.out.println("Maximum product of four consecutive numbers in diagonals: " + maxProduct);
        return maxProduct;
    }

    private static int findMaxProductsInCols(int[][] twoDArray, int consecutiveCount) {

        int maxProduct = Integer.MIN_VALUE;

        // Iterate through columns
        for (int col = 0; col < twoDArray[0].length; col++) {
            // Iterate through rows
            for (int row = 0; row <= twoDArray.length - consecutiveCount; row++) {
                int product = 1;
                for (int i = 0; i < consecutiveCount; i++) {
                    product *= twoDArray[row + i][col];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }

        System.out.println("Maximum product of four consecutive numbers in columns: " + maxProduct);
        return maxProduct;
    }

    private static int findMaxProductsInRows(int[][] twoDArray, int consecutiveCount) {

        int maxProduct = Integer.MIN_VALUE;

        for (int row = 0; row < twoDArray.length; row++) {
            for (int col = 0; col <= twoDArray[row].length - consecutiveCount; col++) {
                int product = twoDArray[row][col] * twoDArray[row][col + 1] * twoDArray[row][col + 2] * twoDArray[row][col + 3];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        System.out.println("Maximum product of four consecutive numbers in rows: " + maxProduct);
        return maxProduct;
    }

    private static int[][] createTwoDArray(String inputString) {

        // Split the input string into rows
        String[] rows = txt.split("\n");

        // Get the number of rows and columns
        int numRows = rows.length;
        int numCols = rows[0].split(" ").length;

        // Create a two-dimensional array to store the numbers
        int[][] twoDArray = new int[numCols][numCols];

        // Populate the two-dimensional array with the parsed numbers
        for (int i = 0; i < numRows; i++) {
            String[] rowValues = rows[i].split(" ");
            for (int j = 0; j < numCols; j++) {
                twoDArray[i][j] = Integer.parseInt(rowValues[j]);
            }
        }

        return  twoDArray;
    }
}
