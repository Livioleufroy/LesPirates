package Jeu;

import processing.core.PApplet;

public class Affichage extends PApplet {
    int[][] spiralArray;
    int cellSize = 40;

    public void settings() {
        size(6 * cellSize, 5 * cellSize);
    }

    public void setup() {
        spiralArray = generateSpiralArray(6, 5);
    }

    public void draw() {
        background(255);

        // Affichage du tableau avec les numéros des cases et les couleurs
        for (int i = 0; i < spiralArray.length; i++) {
            for (int j = 0; j < spiralArray[i].length; j++) {
                // Appliquer la couleur verte pour la case 1 et jaune pour la case 30
                if (spiralArray[i][j] == 1) {
                    fill(0, 255, 0); // Vert
                } else if (spiralArray[i][j] == 30) {
                    fill(255, 255, 0); // Jaune
                } else {
                    fill(0); // Couleur par défaut
                }

                // Dessiner le rectangle représentant la case
                rect(j * cellSize, i * cellSize, cellSize, cellSize);

                // Afficher la valeur de la case au centre
                fill(0);
                textAlign(CENTER, CENTER);
                text(spiralArray[i][j], j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);
            }
        }
    }

    // Générer le tableau enroulé en spirale
    int[][] generateSpiralArray(int numRows, int numCols) {
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

    public static void main(String[] args) {
        PApplet.main("Jeu.Affichage");
    }
}

