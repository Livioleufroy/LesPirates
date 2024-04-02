package jeu;

import java.util.Random;
import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public class CaseVS extends CasesSpeciales {

    private Map map;

    public CaseVS(Map map) {
        super(Effet.VS);
        this.map = map;
    }

    @Override
    public void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu fenetreDeJeu) {
        Personnage adversaire = choisirAdversaire(personnage);
        int deJoueur1 = De.lanceDe(random); // Lancer le dé pour le joueur 1
        int deJoueur2 = De.lanceDe(random); // Lancer le dé pour le joueur 2

        fenetreDeJeu.lancerDe(personnage, deJoueur1);
        fenetreDeJeu.lancerDe(adversaire, deJoueur2);

        if (deJoueur1 < deJoueur2) {
            adversaire.infligerDegat(deJoueur2 - deJoueur1); // Si le joueur 1 perd, infliger des dégâts à l'adversaire
        } else if (deJoueur2 < deJoueur1) {
            personnage.infligerDegat(deJoueur1 - deJoueur2); // Si le joueur 2 perd, infliger des dégâts au joueur 1
        }

        fenetreDeJeu.appuieSurEntree(); // Attendre l'entrée utilisateur
    }

    // Choisir l'adversaire pour le joueur 
    private Personnage choisirAdversaire(Personnage joueur) {
        Personnage[] listeJoueurs = map.getListeCases();

        // Trouver l'autre joueur
        for (Personnage adversaire : listeJoueurs) {
            if (adversaire != joueur) {
                return adversaire;
            }
        }

        return null; // Retourner null si aucun autre joueur n'est trouvé
    }
}


