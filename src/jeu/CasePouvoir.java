package jeu;

import java.util.Random;
import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public class CasePouvoir extends CasesSpeciales {

    private Map map;

    public CasePouvoir(Map map) {
        super(Effet.Pouvoir);
        this.map = map;
    }

    @Override
    public void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu fenetreDeJeu) {
        System.out.println("C'est une case Pouvoir ! " + personnage.getNom().getNom() + " reçoit une incroyable force inconnue.");

        // Si les points de vie du joueur sont inférieurs à 5, il gagne un point de vie
        if (personnage.getPv() < 5) {
            personnage.setPv(personnage.getPv() + 1);
            System.out.println(personnage.getNom().getNom() + " a gagné un point de vie !"); // Afficher le gain de point de vie
        }

        // Le joueur est immunisé des effets des autres cases pendant 3 tours
        personnage.setImmunite(true);
        System.out.println(personnage.getNom().getNom() + " est immunisé contre les effets des autres cases pendant 3 tours."); // Afficher que l'immunité est activée

        // Attendre 3 tours
        for (int i = 0; i < 3; i++) {
            System.out.println("Tour d'immunité " + (i + 1) + " pour " + personnage.getNom().getNom()); // Afficher le tour d'immunité actuel
            fenetreDeJeu.appuieSurEntree(); // Attendre l'entrée utilisateur pour passer au tour suivant
        }

        // Désactiver l'immunité après 3 tours
        personnage.setImmunite(false);
        System.out.println(personnage.getNom().getNom() + " n'est plus immunisé contre les effets des autres cases."); // Afficher que l'immunité est désactivée
    }
}


