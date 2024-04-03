package pirate;

public class Affichage {
    public static void afficherInfos(Joueur joueur1, Joueur joueur2, int tour) {
        System.out.println("Plateau de jeu :");
        afficherPlateauSpirale();
        System.out.println("Tour " + tour + ":");
        System.out.println(joueur1.getNom() + " (PV: " + joueur1.getPv() + ", Position: " + joueur1.getPosition() + ")");
        System.out.println(joueur2.getNom() + " (PV: " + joueur2.getPv() + ", Position: " + joueur2.getPosition() + ")");
    }

    public static void afficherGagnant(Joueur joueur) {
        System.out.println("Le joueur " + joueur.getNom() + " est arrivé à la barque en premier, il devient donc le seul et incontesté capitaine de l'équipage !");
    }

    public static void afficherPlateauSpirale() {
        int[][] plateau = new int[5][6];
        int nombre = 1;

        int i, ligneDebut = 0, colonneDebut = 0;
        int ligneFin = 4, colonneFin = 5;

        while (ligneDebut <= ligneFin && colonneDebut <= colonneFin) {
            for (i = colonneDebut; i <= colonneFin; ++i) {
                plateau[ligneDebut][i] = nombre++;
            }
            ligneDebut++;

            for (i = ligneDebut; i <= ligneFin; ++i) {
                plateau[i][colonneFin] = nombre++;
            }
            colonneFin--;

            if (ligneDebut <= ligneFin) {
                for (i = colonneFin; i >= colonneDebut; --i) {
                    plateau[ligneFin][i] = nombre++;
                }
                ligneFin--;
            }

            if (colonneDebut <= colonneFin) {
                for (i = ligneFin; i >= ligneDebut; --i) {
                    plateau[i][colonneDebut] = nombre++;
                }
                colonneDebut++;
            }
        }

        for (int ligne = 0; ligne < 5; ligne++) {
            for (int colonne = 0; colonne < 6; colonne++) {
                System.out.print(plateau[ligne][colonne] + "\t");
            }
            System.out.println();
        }
    }
}




