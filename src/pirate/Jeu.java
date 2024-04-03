package pirate;

import java.util.Random;
import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sélection du personnage pour le joueur 1
        System.out.println("Choisissez votre personnage pour le Joueur 1 :");
        System.out.println("1. Bill Jambe de bois");
        System.out.println("2. Jack le borgne");
        int choixJoueur1 = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante

        Joueur joueur1;
        if (choixJoueur1 == 1) {
            joueur1 = new Joueur("Bill Jambe de bois");
        } else {
            joueur1 = new Joueur("Jack le borgne");
        }

        // Sélection du personnage pour le joueur 2
        System.out.println("Choisissez votre personnage pour le Joueur 2 :");
        System.out.println("1. Bill Jambe de bois");
        System.out.println("2. Jack le borgne");
        int choixJoueur2 = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante

        Joueur joueur2;
        if (choixJoueur2 == 1) {
            joueur2 = new Joueur("Bill Jambe de bois");
        } else {
            joueur2 = new Joueur("Jack le borgne");
        }

        Joueur joueurCourant = joueur1;

        int tour = 1;
        Random rand = new Random();
        while (joueur1.getPosition() < 30 && joueur2.getPosition() < 30) {
            Affichage.afficherInfos(joueur1, joueur2, tour);

            System.out.println("Appuyez sur Entrée pour lancer le dé...");
            scanner.nextLine();

            int de = rand.nextInt(6) + 1;
            System.out.println(joueurCourant.getNom() + " lance le dé et obtient " + de);
            scanner.nextLine();

            joueurCourant.avancer(de);

            int position = joueurCourant.getPosition();
            if (Plateau.estCaseSpeciale(position)) {
                EffetCase effet = Plateau.getEffetCaseSpeciale(position);
                System.out.println(joueurCourant.getNom() + " est sur la " + effet.getNom() + " : " + effet.getDescription());
                Plateau.appliquerEffetCaseSpeciale(joueurCourant, joueur1, joueur2, position);


                scanner.nextLine();
            }

            if (joueurCourant == joueur1)
                joueurCourant = joueur2;
            else
                joueurCourant = joueur1;

            tour++;
        }

        Joueur gagnant = joueur1.getPosition() >= 30 ? joueur1 : joueur2;
        Affichage.afficherGagnant(gagnant);

        scanner.close();
    }
}







