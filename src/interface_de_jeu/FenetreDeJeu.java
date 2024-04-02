package interface_de_jeu;

import pions.Personnage;
import jeu.Case;

public interface FenetreDeJeu {
    void contexte(Personnage[] listePersonnage);
    void aQuiTour(Personnage personnage);
    void lancerDe(Personnage personnage, int de);
    void immuniteActivée(Personnage personnage);
    void appuieSurEntree();
    void deplacement(Personnage personnage, int de, int nbCases);
    void descCase(Personnage personnage, Personnage personnage2);
    void gagnantBarque(Personnage personnage);
    void descCase(Personnage personnage, Case caseActuelle);
}




	


	
