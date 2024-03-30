package jeu;

import java.util.Random;
import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public class CaseReset extends CasesSpeciales {
    public CaseReset() {
        super(ActionCase.Reset);
    }

    @Override
    protected void appliquerActionCase(Personnage personnage, Map map, Random random, FenetreDeJeu fenetredejeu) {
        // Appliquer l'effet de réinitialisation pour chaque joueur
        for (Personnage joueur : map.getListePersonnage()) {
            // Vérifier si le joueur n'est pas déjà sur la case de départ
            if (joueur.getPosition() != 1) {
                // Calculer le nombre de cases à reculer
                int de = joueur.getPosition() - 1;
                // Afficher le déplacement
                fenetredejeu.deplacement(joueur, -de, map.getNbCases());
                // Déplacer le joueur à la case de départ
                joueur.deplacerPirate(1, -de);
                // Afficher la case sur laquelle le joueur est revenu
                fenetredejeu.descCase(joueur, map.getListeCases()[0]);
            }
        }
    }
}
