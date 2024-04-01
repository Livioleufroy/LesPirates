package jeu;

import java.util.Random;
import interface_de_jeu.FenetreDeJeu;
import pions.Couleur;
import pions.Nom;
import pions.Personnage;

public class Jeu {
    private int nbJoueurs;
    private Personnage[] listePersonnage;
    private Map map;
    private FenetreDeJeu fenetredejeu;
    private Random random;

    public Jeu(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
        this.listePersonnage = new Personnage[nbJoueurs];
        this.map = new Map();
        this.fenetredejeu = new FenetreDeJeu();
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
    

    private void tour1Personnage(Personnage personnage) {
        int de;

        if (personnage.getPv() > 0) {
            fenetredejeu.aQuiTour(personnage);
            de = De.lanceDe(random);
            fenetredejeu.lancerDe(personnage, de);
            fenetredejeu.deplacement(personnage, de, map.getNbCases());
            fenetredejeu.descCase(personnage, map.getListeCases()[personnage.getPosition() - 1]);
            Case caseActuelle = map.getListeCases()[personnage.getPosition() - 1];
            if (caseActuelle.isCaseSpeciale() && caseActuelle instanceof CasesSpeciales) {
                ((CasesSpeciales) caseActuelle).appliquerActionCase(personnage, map, random, fenetredejeu);
            } else {
                fenetredejeu.appuieSurEntree();
            }
        }
    }

    private boolean gagnantBarque(Personnage personnage) {
        boolean arrivee = false;
        if (personnage.getPosition() == map.getNbCases(6, 5)) {
            fenetredejeu.gagnantBarque(personnage); // Appel de la méthode gagnantBarque
            arrivee = true;
        }
        return arrivee;
    }
}

