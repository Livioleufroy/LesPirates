package jeu;

import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

import java.util.Random;

public class Case {
    private Effet effet;

    public Case(Effet effet) {
        this.effet = effet;
    }

    public Effet getEffet() {
        return effet;
    }

    public void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu FenetreDeJeu) {
        // Cette méthode est vide par défaut dans la classe de base.
        // Elle sera redéfinie dans les classes dérivées pour implémenter des comportements spécifiques aux cases.
    }

    private static int compteur = 0;
    private int numero;

    public Case() {
        compteur++;
        numero = compteur;
    }

    public int getNumero() {
        return numero;
    }

    protected boolean isCaseSpeciale() {
        return false;
    }
}

