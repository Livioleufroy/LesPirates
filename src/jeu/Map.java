package jeu;

public class Map {
    public static void main(String[] args) {
        int[][] spiralArray = generateSpiralArray(6, 5);
        printColoredSpiralArray(spiralArray);
    }

    // Générer le tableau enroulé en spirale
    public static int[][] generateSpiralArray(int numRows, int numCols) {
        int[][] spiralArray = new int[numRows][numCols];
        int rowStart = 0;
        int rowEnd = numRows - 1;
        int colStart = 0;
        int colEnd = numCols - 1;
        int num = 1;

        while (num <= numRows * numCols) {
            for (int i = colStart; i <= colEnd; ++i) {
                spiralArray[rowStart][i] = num++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; ++i) {
                spiralArray[i][colEnd] = num++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; --i) {
                spiralArray[rowEnd][i] = num++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; --i) {
                spiralArray[i][colStart] = num++;
            }
            colStart++;
        }
        return spiralArray;
    }

    // Afficher le tableau en couleur selon les spécifications
    public static void printColoredSpiralArray(int[][] spiralArray) {
        for (int i = 0; i < spiralArray.length; i++) {
            for (int j = 0; j < spiralArray[i].length; j++) {
                int num = spiralArray[i][j];
                if (num == 1)
                    System.out.print("\u001B[32m"); // Vert
                else if (num == 10 || num == 20)
                    System.out.print("\u001B[31m"); // Rouge
                else if (num == 8 || num == 15 || num == 28)
                    System.out.print("\u001B[37m"); // Gris
                else if (num == 25)
                    System.out.print("\u001B[35m"); // Rose
                else if (num == 30)
                    System.out.print("\u001B[33m"); // Jaune
                else
                    System.out.print("\u001B[0m"); // Réinitialiser la couleur

                // Affichage de la valeur de la case
                System.out.printf("%2d ", num);
            }
            System.out.println();
        }
        // Réinitialiser la couleur après l'affichage du tableau
        System.out.print("\u001B[0m");
    }
}
