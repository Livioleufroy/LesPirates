package jeu;

import jeu.case_speciale;
import jeu.CaseVS;
import Pions.Personnages;
import java.util.Scanner;

public class Fenetre_de_jeu implements IAffichage {
	private static Scanner reader = new Scanner(System.in);


	public void contexte(Personnages[] listePersonnages) {
		StringBuilder texte = new StringBuilder();
		for (int i = 0; i < listePersonnages.length - 2; i++) {
			texte.append(listePersonnages[i].getNom().getNom() + ", ");
		}
		texte.append(listePersonnages[listePersonnages.length - 2].getNom().getNom() + " et "
				+ listePersonnages[listePersonnages.length - 1].getNom().getNom());
		texte.append(" sont " + (listePersonnages.length)
				+ "  "
				+ "Le premier a trouver la barque pourra revenir au navire et ainsi devenir le seul et unique capitaine !\n");
		System.out.println(texte.toString());
	}

	public void aQuiTour(Personnages personnages) {
		System.out.println("C'est au tour de " + Personnages.getNom().getNom() + ". " + Personnages.getNom().getPronom()
				+ " a " + Personnages.getPv() + " PV.");
		System.out.println("(Pour lancer des appuyer sur Entree)");
		reader.nextLine();
	}

	public void lancerDe(Personnages pirate, int de) {
		System.out.println(pirate.getNom().getNom() + " lances les des et fait " + de + ".");
	}

	public void deplacement(Personnages pirate, int de, int nbCases) {
		StringBuilder texte = new StringBuilder();
		int nvNum = pirate.getPosition() + de;

		texte.append(pirate.getNom().getNom());
		if (de < 0) {
			texte.append(" recule");
		} else if (nvNum > nbCases) {
			texte.append(" avance de " + (de - (nvNum - nbCases)));
			texte.append(accorderCase(de));

			texte.append(" et recule de " + (nvNum - nbCases));
			texte.append(accorderCase(de));
		}

		else {
			texte.append(" avance");
		}
		texte.append(". ");

		System.out.print(texte.toString());
	}
	
	public void descCase(Personnages personnages, Case caseActuelle) {
		System.out.println(Personnages.getIdentite().getPronom() + " tombe sur la case " + caseActuelle.getNumero()+".");
	}

	
	public void appuieSurEntree() {

		System.out.println("(Appuyer sur Entree)");
		reader.nextLine();

	}
	
	public void appliquerPouvoir(Personnages pirate) {

		System.out.println ("C'est une case Pouvoir! " + pirate.getNom().getNom() + " reçoit une incroyable force incoonue.");
		appuieSurEntree();

	}
	
	public void appliquerEffetReset(CaseReset caseActuelle, Personnages personnages) {

		System.out.print("C'est une case Arme! " + pirate.getIdentite().getNom()+" y trouve un " + caseActuelle.getArme().getNom() + " de force "
				+ caseActuelle.getArme().getForce() + ".\n");
		if (caseActuelle.getArme().getForce() > Personnages.getArme().getForce()) {
			System.out.println(pirate.getIdentite().getNom() + " l'a prend.");
		} else {
			System.out.println(Personnages.getNom().getNom() + " en a deja une meilleure.");
		}
		appuieSurEntree();

	}
	


	public void debutDuel(Personnages personnagesI, Personnages personnagesJ, int deI, int deJ) {
		System.out.println("\n"+
				pirateI.getIdentite().getNom() + " et " + personnagesJ.getIdentite().getNom() + " se battent en duel!");
		System.out.println("(Pour lancer les dees appuyer sur Entree)");
		reader.nextLine();

		lancerDe(pirateI, deI);
		System.out.println(pirateI.getIdentite().getPronom() + " donne un coup de force "
				+ (deI + pirateI.getArme().getForce()) + "\n");
		lancerDe(pirateJ, deJ);
		System.out.println(pirateJ.getIdentite().getPronom() + " donne un coup de force "
				+ (deJ + pirateJ.getArme().getForce()) + "\n");

	}

	public void finDuel(Pirate gagnant, Pirate perdant, int degat) {
		
		System.out.print(gagnant.getIdentite().getNom() + " gagne le duel et inflige " + degat);
		if (degat == 1) {
			System.out.print(" point ");
		} else {
			System.out.print(" points ");
		}
		System.out.println("de degat a " + perdant.getIdentite().getNom()+".");

		aPeri(perdant);

		appuieSurEntree();
	}

	public void finDuelEgalite(Pirate pirateI, Pirate pirateJ) {
		System.out.println("Egalite! " + pirateI.getIdentite().getNom() + " inflige 1 point de degat a "
				+ pirateJ.getIdentite().getNom() + " et " + pirateJ.getIdentite().getNom()
				+ " lui en inflige aussi 1.");
		
		aPeri(pirateI);
		aPeri(pirateJ);
		
		appuieSurEntree();
	}
	

	public void gagnantBarque(Pirate pirate) {
		System.out.println(pirate.getIdentite().getNom() + " touve la barge! " + pirate.getIdentite().getNom() + " est le nouveau capitaine!");
	}

	public void gagnantParDuel(Pirate pirate) {
		System.out.print(pirate.getIdentite().getNom() + " est ");
		if (pirate.getIdentite().getPronom().equals("Elle")) {
			System.out.print("la derniere");
		} else {
			System.out.print("le dernier");
		}
		System.out.println(" debout! " + pirate.getIdentite().getNom() + " est le nouveau capitaine!");
	}
	
	public void tousMort() {
		System.out.println("Tout les pirates sont morts, le capitaine ne sera pas l'un d'entre eux!");
	}
	
	public void aPeri(Pirate pirate) {
		if (pirate.getPv() == 0) {
			System.out.println(pirate.getIdentite().getNom() + " a peri!");
		}
	}
	
	private String accorderCase(int de) {
		String texte;
		if (Math.abs(de) == 1) {
			texte = " case";
		} else {
			texte = " cases";
		}
		return texte;
	}
}

