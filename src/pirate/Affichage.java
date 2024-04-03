package pirate;

public class Affichage {
    // Méthode pour afficher le plateau sous forme de tableau numéroté en spirale
    public static void afficherPlateauSpirale() {
        int[][] plateau = new int[5][6]; // Plateau de jeu avec 5 lignes et 6 colonnes
        int nombre = 1; // Numéro de la case

        int i, ligneDebut = 0, colonneDebut = 0;
        int ligneFin = 4, colonneFin = 5;

        // Construction du plateau en spirale
        while (ligneDebut <= ligneFin && colonneDebut <= colonneFin) {
            // Imprimer la première ligne de la plage restante
            for (i = colonneDebut; i <= colonneFin; ++i) {
                plateau[ligneDebut][i] = nombre++;
            }
            ligneDebut++;

            // Imprimer la dernière colonne de la plage restante
            for (i = ligneDebut; i <= ligneFin; ++i) {
                plateau[i][colonneFin] = nombre++;
            }
            colonneFin--;

            // Imprimer la dernière ligne de la plage restante, de droite à gauche
            if (ligneDebut <= ligneFin) {
                for (i = colonneFin; i >= colonneDebut; --i) {
                    plateau[ligneFin][i] = nombre++;
                }
                ligneFin--;
            }

            // Imprimer la première colonne de la plage restante, de bas en haut
            if (colonneDebut <= colonneFin) {
                for (i = ligneFin; i >= ligneDebut; --i) {
                    plateau[i][colonneDebut] = nombre++;
                }
                colonneDebut++;
            }
        }

        // Afficher le plateau
        for (int ligne = 0; ligne < 5; ligne++) {
            for (int colonne = 0; colonne < 6; colonne++) {
                System.out.print(plateau[ligne][colonne] + "\t");
            }
            System.out.println();
        }
    }

    // Méthode pour afficher les informations sur le joueur et le plateau
    public static void afficherInfos(Joueur joueur1, Joueur joueur2, int tour) {
        System.out.println("Plateau de jeu :");
        afficherPlateauSpirale();
        System.out.println("Tour " + tour + ":");
        System.out.println(joueur1.getNom() + " (PV: " + joueur1.getPv() + ", Position: " + joueur1.getPosition() + ")");
        System.out.println(joueur2.getNom() + " (PV: " + joueur2.getPv() + ", Position: " + joueur2.getPosition() + ")");
    }

    // Méthode pour afficher l'effet d'une case spéciale
    public static void afficherEffetCaseSpeciale(int position) {
        String nomCase = Plateau.nomCaseSpeciale(position);
        String effetCase = Plateau.effetCaseSpeciale(position);
        System.out.println("Effet de la case " + position + " (" + nomCase + "): " + effetCase);
    }

    // Méthode pour afficher le gagnant
    public static void afficherGagnant(Joueur joueur) {
        System.out.println("Le joueur " + joueur.getNom() + " a gagné !");
    }
}

