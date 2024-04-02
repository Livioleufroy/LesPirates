package jeu;

import java.util.Random;
import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public class CasePiege extends CasesSpeciales {

    private Map map;

    public CasePiege(Map map) {
        super(Effet.Piege);
        this.map = map;
    }

    @Override
    public void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu fenetreDeJeu) {
        System.out.println("C'est une case Piège ! " + personnage.getNom().getNom() + " est piégé et ne peut pas avancer tant qu'il n'a pas fait un 6.");
        personnage.infligerDegat(1); // Le joueur subit 1 point de dégât en rencontrant cette case
        
        // Attendre que le joueur fasse un 6 avant de pouvoir avancer
        while (true) {
            int de = De.lanceDe(random); // Lancer le dé
            fenetreDeJeu.lancerDe(personnage, de); // Afficher le résultat du lancer de dé
            
            if (de == 6) {
                fenetreDeJeu.appuieSurEntree(); // Attendre l'entrée utilisateur
                break; // Sortir de la boucle si le joueur fait un 6
            } else {
                System.out.println(personnage.getNom().getNom() + " ne peut pas avancer. Il doit obtenir un 6."); // Afficher que le déplacement est impossible
            }
        }
    }
}


