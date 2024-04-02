package interface_de_jeu;

import jeu.Case;
import pions.Personnage;

public interface Affichage {
    void contexte(Personnage[] listePersonnage);

    void aQuiTour(Personnage personnage);

    void lancerDe(Personnage personnage, int de);

    void deplacement(Personnage personnage, int de, int nbCases);

    void descCase(Personnage personnage, Case caseActuelle);

    void appliquerEffetReset(Personnage personnage);

    void appliquerActionCasePiege(Personnage personnage);

    void appliquerActionCaseVS(Personnage joueur1, Personnage joueur2, int deJoueur1, int deJoueur2);

    void appliquerActionCasePouvoir(Personnage personnage);

    void appliquerActionCaseCanon(Personnage personnage);
}
