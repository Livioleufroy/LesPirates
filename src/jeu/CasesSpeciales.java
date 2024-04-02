package jeu;

import java.util.Random;

import interface_de_jeu.ConsoleFenetreDeJeu;
import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public abstract class CasesSpeciales extends Case {

    private Effet effet;

    protected CasesSpeciales(Effet effet) {
        super();
        this.effet = effet;
    }

    public Effet getEffet() {
        return effet;
    }

    public abstract void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu FenetreDeJeu);

    @Override
    protected boolean isCaseSpeciale() {
        return true;
    }

	public void appliquerEffet(Personnage personnage, Map map, Random random, ConsoleFenetreDeJeu fenetredejeu) {
		
		
	}
}

