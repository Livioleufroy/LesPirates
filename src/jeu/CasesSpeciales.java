package jeu;

import java.util.Random;

import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public abstract class CasesSpeciales extends Case {

	private Effet Effet;
	
	protected CasesSpeciales(Effet effet) {
		super();
		this.Effet=effet;
	}

	public Effet getEffet() {
		return Effet;
	}
	
	protected abstract void appliquerEffet(Personnage personnage, Map map, Random random, FenetreDeJeu FenetreDeJeu);

	@Override
	protected boolean isCaseSpeciale() {
		
		return true;
	}
}
