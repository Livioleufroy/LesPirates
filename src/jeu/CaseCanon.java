package jeu;

import java.util.Random;
import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public class CaseCanon extends Case {
    public CaseCanon() {
        super(Effet.Canon);
    }

    @Override
    public void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu fenetreDeJeu) {
        System.out.println("C'est une case Canon ! " + personnage.getNom().getNom() + " est touché par un boulet de canon et perd un point de vie !");
        personnage.setPv(personnage.getPv() - 1); // Le joueur perd un point de vie
        fenetreDeJeu.appuieSurEntree(); // Attendre l'entrée utilisateur après l'application de l'effet
    }
}

