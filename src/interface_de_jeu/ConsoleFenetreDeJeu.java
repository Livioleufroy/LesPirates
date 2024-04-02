package interface_de_jeu;

import java.util.Scanner;
import interface_de_jeu.FenetreDeJeu;
import jeu.Case;
import pions.Personnage;

public class ConsoleFenetreDeJeu implements FenetreDeJeu {
    private static Scanner reader = new Scanner(System.in);

    public void contexte(Personnage[] listePersonnage) {
        StringBuilder texte = new StringBuilder();
        for (int i = 0; i < listePersonnage.length - 1; i++) {
            texte.append(listePersonnage[i].getNom().getNom()).append(", ");
        }
        texte.append(listePersonnage[listePersonnage.length - 1].getNom().getNom());
        texte.append(" sont ").append(listePersonnage.length);
        texte.append("  Le premier à trouver la barque pourra revenir au navire et ainsi devenir le seul et unique capitaine !\n");
        System.out.println(texte.toString());
    }

    public void aQuiTour(Personnage personnage) {
        System.out.println("C'est au tour de " + personnage.getNom().getNom() + ". " + personnage.getNom().getPronom()
                + " a " + personnage.getPv() + " PV.");
        System.out.println("(Pour lancer, appuyez sur Entrée)");
        reader.nextLine();
    }

    public void lancerDe(Personnage personnage, int de) {
        System.out.println(personnage.getNom().getNom() + " lance les dés et fait " + de + ".");
    }

    public void immuniteActivée(Personnage personnage) {
        System.out.println(personnage.getNom().getNom() + " est immunisé des effets des autres cases pour 3 tours !");
    }

    public void appuieSurEntree() {
        System.out.println("(Appuyez sur Entrée)");
        reader.nextLine();
    }

    public void deplacement(Personnage personnage, int de, int nbCases) {
        // Implémentez cette méthode si nécessaire
    }

    public void descCase(Personnage personnage, Personnage personnage2) {
        // Implémentez cette méthode si nécessaire
    }

    public void gagnantBarque(Personnage personnage) {
        // Implémentez cette méthode si nécessaire
    }

    public void descCase(Personnage personnage, Case caseActuelle) {
        // Implémentez cette méthode si nécessaire
    }
}

