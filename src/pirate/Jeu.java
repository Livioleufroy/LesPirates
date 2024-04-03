package pirate;

import java.util.Random;
import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander au joueur de choisir son personnage
        System.out.println("Choisissez votre personnage (1 pour Bill Jambe de bois, 2 pour Jack le borgne): ");
        int choix = scanner.nextInt();
        Joueur joueur1, joueur2;
        if (choix == 1) {
            joueur1 = new Joueur("Bill Jambe de bois");
            joueur2 = new Joueur("Jack le borgne");
        } else {
            joueur1 = new Joueur("Jack le borgne");
            joueur2 = new Joueur("Bill Jambe de bois");
        }

        // Choix du joueur initial (ici joueur1)
        Joueur joueurCourant = joueur1;

        // Déroulement du jeu
        int tour = 1;
        Random rand = new Random();
        while (joueur1.estEnJeu() && joueur2.estEnJeu()) {
            // Affichage des informations
            Affichage.afficherInfos(joueur1, joueur2, tour);

            // Attente de l'appui sur Entrée pour lancer le dé
            System.out.println("Appuyez sur Entrée pour lancer le dé...");
            scanner.nextLine(); // Consommer la nouvelle ligne restante après le choix du joueur
            scanner.nextLine(); // Attendre l'appui sur Entrée

            // Lancer du dé
            int de = rand.nextInt(6) + 1;
            System.out.println(joueurCourant.getNom() + " lance le dé et obtient " + de);

            // Avancer le joueur
            joueurCourant.avancer(de);

            // Vérifier s'il est sur une case spéciale
            int position = joueurCourant.getPosition();
            if (Plateau.estCaseSpeciale(position)) {
                String nomCase = Plateau.nomCaseSpeciale(position);
                String effetCase = Plateau.effetCaseSpeciale(position);
                System.out.println(joueurCourant.getNom() + " est sur la " + nomCase + " : " + effetCase);
            }

            // Passer au joueur suivant
            if (joueurCourant == joueur1)
                joueurCourant = joueur2;
            else
                joueurCourant = joueur1;

            tour++;
        }

        // Affichage du gagnant
        Joueur gagnant = joueur1.estEnJeu() ? joueur1 : joueur2;
        Affichage.afficherGagnant(gagnant);

        scanner.close(); // Fermer le scanner à la fin du jeu
    }
}



