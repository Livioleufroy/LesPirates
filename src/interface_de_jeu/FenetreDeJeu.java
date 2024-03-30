package interface_de_jeu;

import pions.Personnage;
import java.util.Scanner;
import jeu.Case;


public class FenetreDeJeu implements Affichage {
	private static Scanner reader = new Scanner(System.in);


	public void contexte(Personnage[] listePersonnage) {
		StringBuilder texte = new StringBuilder();
		for (int i = 0; i < listePersonnage.length - 2; i++) {
			texte.append(listePersonnage[i].getNom().getNom() + ", ");
		}
		texte.append(listePersonnage[listePersonnage.length - 2].getNom().getNom() + " et "
				+ listePersonnage[listePersonnage.length - 1].getNom().getNom());
		texte.append(" sont " + (listePersonnage.length)
				+ "  "
				+ "Le premier a trouver la barque pourra revenir au navire et ainsi devenir le seul et unique capitaine !\n");
		System.out.println(texte.toString());
	}

	public void aQuiTour(Personnage personnage) {
		System.out.println("C'est au tour de " + Personnage.getNom().getNom() + ". " + Personnage.getNom().getPronom()
				+ " a " + Personnage.getPv() + " PV.");
		System.out.println("(Pour lancer des appuyer sur Entree)");
		reader.nextLine();
	}

	public void lancerDe(Personnage personnage, int de) {
		System.out.println(personnage.getNom().getNom() + " lances les des et fait " + de + ".");
	}

	public void deplacement(Personnage personnage, int de, int nbCases) {
		StringBuilder texte = new StringBuilder();
		int nvNum = personnage.getPosition() + de;

		texte.append(personnage.getNom().getNom());
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
	
	public void descCase(Personnage personnage, Case caseActuelle) {
		System.out.println(Personnage.getNom().getPronom() + " tombe sur la case " + caseActuelle.getNumero()+".");
	}

	
	public void appuieSurEntree() {

		System.out.println("(Appuyer sur Entree)");
		reader.nextLine();

	}
	
	public void appliquerPouvoir(Personnage personnage) {

		System.out.println ("C'est une case Pouvoir! " + personnage.getNom().getNom() + " reçoit une incroyable force inconnue.");
		appuieSurEntree();

	}
	
	public void appliquerEffetReset(CaseReset caseActuelle, Personnage personnage) {
		System.out.println ("C'est une case Reset! " + personnage.getNom().getNom() + " attire l'attention des natifs de l'ile, tous les joueurs reviennent au départ... et bah bravo !");
		appuieSurEntree();
		
	}

	}
	


	
