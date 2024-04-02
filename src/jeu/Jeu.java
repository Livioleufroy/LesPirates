package jeu;

import java.util.Random;
import interface_de_jeu.ConsoleFenetreDeJeu;
import pions.Couleur;
import pions.Nom;
import pions.Personnage;

public class Jeu {
    private int nbJoueurs;
    private Personnage[] listePersonnage;
    private Map map;
    private ConsoleFenetreDeJeu fenetredejeu;
    private Random random;

    public Jeu(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
        this.listePersonnage = new Personnage[nbJoueurs];
        this.map = new Map();
        this.fenetredejeu = new ConsoleFenetreDeJeu(); // Correction ici
        this.random = new Random();
        remplissageListePersonnage();
    }

    private void remplissageListePersonnage() {
        for (int i = 0; i < nbJoueurs; i++) {
            listePersonnage[i] = new Personnage(Nom.values()[i], Couleur.values()[i]);
        }
    }

    public void start() {
        boolean plusDeUnEnVie = true;
        boolean arrivee = false;

        while (plusDeUnEnVie && !arrivee) {
            for (Personnage personnage : listePersonnage) {
                tour1Personnage(personnage);
                arrivee = gagnantBarque(personnage);
            }
        }
    }

    private boolean gagnantBarque(Personnage personnage) {
		
		return false;
	}

	private void tour1Personnage(Personnage personnage) {
        int de;

        if (personnage.getPv() > 0) {
            fenetredejeu.aQuiTour(personnage);
            de = De.lanceDe(random);
            fenetredejeu.lancerDe(personnage, de);
            fenetredejeu.deplacement(personnage, de, map.getNbCases(6, 5));
            
            Case caseActuelle = null;
            for (Case c : map.getListeCases(30)) {
                if (c.getNumero() == personnage.getPosition()) {
                    caseActuelle = c;
                    break;
                }
            }

            if (caseActuelle != null && caseActuelle.isCaseSpeciale() && caseActuelle instanceof CasesSpeciales) {
                ((CasesSpeciales) caseActuelle).appliquerEffet(personnage, map, random, fenetredejeu);
            } else {
                fenetredejeu.descCase(personnage, caseActuelle);
            }

            fenetredejeu.appuieSurEntree();
        } else {
            fenetredejeu.appuieSurEntree();
        }
    }
}



