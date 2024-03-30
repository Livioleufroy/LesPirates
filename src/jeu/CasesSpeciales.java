package jeu;

import java.util.Random;

import interface_de_jeu.FenetreDeJeu;
import pions.Personnage;

public abstract class CasesSpeciales extends Case {

	private ActionCase ActionCase;
	
	protected CasesSpeciales(ActionCase actioncase) {
		super();
		this.ActionCase=actioncase;
	}

	public ActionCase getActionCase() {
		return ActionCase;
	}
	
	protected abstract void appliquerActionCase(Personnage personnage, Map map, Random random, FenetreDeJeu FenetreDeJeu);

	@Override
	protected boolean isCaseSpeciale() {
		
		return true;
	}
}
