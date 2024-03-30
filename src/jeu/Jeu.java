package jeu;

import java.util.Random;

import interface_de_jeu.Affichage;
import pions.Couleur;
import pions.Nom;
import pions.Personnage;

public class Jeu {
	private int nbJoueurs=2;
	private Personnage[] listePersonnage;
	private Map map=new Map();
	private Random random=new Random();
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	
	public Jeu(int nbJoueurs){
		this.nbJoueurs=nbJoueurs;
		listePersonnage=new Personnage[nbJoueurs];
	}
	public Jeu() {
		listePersonnage=new Personnage[nbJoueurs];
	}
	
	public Personnage[] getListePersonnage() {
		return listePersonnage;
	}
	
	public Map getMap() {
		return map;
	}
	
	public void start() {
		boolean plusDeUnEnVie=true;
		boolean arrivee=false;
		int indexReac;
		
		
		while (plusDeUnEnVie && !arrivee) {
			
			for (int i=0; i<listePersonnage.length && (!arrivee && plusDeUnEnVie);i++) {
				
				Personnage[] listeReac=new Personnage[nbJoueurs-1];
				
				// Tour d'un pirate
					tour1Personnage(listePersonnage[i]);
					
					arrivee=gagnantBarque(listePersonnage[i]);
				
			if (!plusDeUnEnVie) {
				gagnantDuel();
				}
				
			}
	}
	
	private Personnage[] remplissageListePirate() {
		
		for (int i=0; i<nbJoueurs;i++) {
			listePersonnage[i]=new Personnage(Nom.values()[i], Couleur.values()[i]);
		}
		return listePersonnage;
		
	}
	
	
	private void tour1Personnage(Personnage Personnage) {
		
		int de;
	
		if (Personnage.getPv()>0) {
			fenetredejeu.aQuiTour(Personnage);
			
			de=De.lanceDe(random);
			fenetredejeu.lancerDe(Personnage, de);
			
			fenetredejeu.deplacement(Personnage, de, Affichage.getNbCases());
			
			Personnage.deplacerPirate(Affichage.getNbCases(), de);
			
			fenetredejeu.descCase(Personnage, Affichage.getListeCases()[Personnage.getPosition()-1]);
			if (Affichage.getListeCases()[Personnage.getPosition()-1].isCaseSpeciale()) {
				((CaseSpeciale) Affichage.getListeCases()[Personnage.getPosition()-1]).appliquerEffet(Personnage, Affichage, random, fenetredejeu);
			}
			else {
				fenetredejeu.appuieSurEntree();
			}
		}
	}
	
	
	
	private int checkDuel(Personnage initiateur, Personnage[] listeReac) {
		int indexReac=-1;
		if (initiateur.getPv()>0) {
			for (int j=0; j<listePersonnage.length;j++) {
				if (!initiateur.equals(listePersonnage[j]) && listePersonnage[j].getPv()>0 && Math.abs(initiateur.getPosition()-listePersonnage[j].getPosition())<4) {
					
					indexReac++;	
					listeReac[indexReac]=listePersonnage[j];
							
				}
			}
		}
		return indexReac;
				
		
	
	}
	
	private boolean gagnantBarque(Personnage personnage) {
		boolean arrivee=false;
		if (personnage.getPosition()==map.getNbCases()) {
			fenetredejeu.gagnantBarque(personnage);
			arrivee=true;
		}
		return arrivee;
}
}
