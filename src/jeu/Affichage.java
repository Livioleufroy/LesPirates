package jeu;

public class Affichage {
	public static void main(String[] args) {
        // Déclaration et initialisation du tableau
        int[][] spiralArray = new int[6][5];

        // Initialisation des variables pour la spirale
        int rowStart = 0;
        int rowEnd = spiralArray.length - 1;
        int colStart = 0;
        int colEnd = spiralArray[0].length - 1;
        int num = 1;

        // Remplissage du tableau enroulé en spirale
        while (num <= spiralArray.length * spiralArray[0].length) {
            // Déplacement de gauche à droite
            for (int i = colStart; i <= colEnd; ++i) {
                spiralArray[rowStart][i] = num++;
            }
            rowStart++;

            // Déplacement de haut en bas
            for (int i = rowStart; i <= rowEnd; ++i) {
                spiralArray[i][colEnd] = num++;
            }
            colEnd--;

            // Déplacement de droite à gauche
            for (int i = colEnd; i >= colStart; --i) {
                spiralArray[rowEnd][i] = num++;
            }
            rowEnd--;

            // Déplacement de bas en haut
            for (int i = rowEnd; i >= rowStart; --i) {
                spiralArray[i][colStart] = num++;
            }
            colStart++;
        }

        // Affichage du tableau avec les numéros des cases et les couleurs
        for (int i = 0; i < spiralArray.length; i++) {
            for (int j = 0; j < spiralArray[i].length; j++) {
                // Appliquer la couleur verte pour la case 1 et jaune pour la case 30
                if (spiralArray[i][j] == 1) {
                    System.out.print("\u001B[32m"); // Vert
                } else if (spiralArray[i][j] == 30) {
                    System.out.print("\u001B[33m"); // Jaune
                } else {
                    System.out.print("\u001B[0m"); // Réinitialiser la couleur
                }

                // Afficher la valeur de la case avec un espacement de 2 caractères
                System.out.printf("%2d ", spiralArray[i][j]);
            }
            // Aller à la ligne pour la prochaine rangée
            System.out.println();
        }
        // Réinitialiser la couleur après l'affichage du tableau
        System.out.print("\u001B[0m");
    }
}
