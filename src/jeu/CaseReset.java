package jeu;

import java.util.Random;

import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public  abstract class CaseReset extends CasesSpeciales {

    private Map map;

    public CaseReset(Map map) {
        super(Effet.Reset);
        this.map = map;
    }

    @Override
    protected abstract void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu FenetreDeJeu) {
        // Réinitialisation de la position de chaque joueur à la case départ
        for (Personnage joueur : map.getListeCases()) {
            joueur.setPosition(1); // Ramener chaque joueur à la case départ
            fenetredejeu.descCase(joueur, map.getListeCases()[0]); // Afficher la description de la case départ pour chaque joueur
        }
        fenetredejeu.appuieSurEntree(); // Attendre l'entrée utilisateur après la réinitialisation
    }
}