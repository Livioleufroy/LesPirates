package jeu;

import java.util.Random;
import Pions.Couleur;
import Pions.Nom;
import Pions.Personnages;

public class Jeu {
	private int nbJoueurs=2;
	private Personnages[] listePirates;
	private map map=new map();
	private Random random=new Random();
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	
	public Jeu(int nbJoueurs){
		this.nbJoueurs=nbJoueurs;
		listePirates=new Personnages[nbJoueurs];
	}
	public Jeu() {
		listePirates=new Personnages[nbJoueurs];
	}
	
	public Personnages[] getListePirates() {
		return listePirates;
	}
	
	public map getMap() {
		return map;
	}
	
	public void start() {
		boolean plusDeUnEnVie=true;
		boolean arrivee=false;
		int indexReac;
		
		
		while (plusDeUnEnVie && !arrivee) {
			
			for (int i=0; i<listePirates.length && (!arrivee && plusDeUnEnVie);i++) {
				
				Pirate[] listeReac=new Pirate[nbJoueurs-1];
				
				// Tour d'un pirate
					tour1Pirate(listePirates[i]);
					
					arrivee=gagnantBarque(listePirates[i]);
				
			if (!plusDeUnEnVie) {
				gagnantDuel();
				}
				
			}
	}
	
	private Pirate[] remplissageListePirate() {
		
		for (int i=0; i<nbJoueurs;i++) {
			listePirates[i]=new Pirate(Identite.values()[i], Couleur.values()[i]);
		}
		return listePirates;
		
	}
	
	
	private void tour1Pirate(Pirate pirate) {
		
		int de;
	
		if (pirate.getPv()>0) {
			journal.aQuiTour(pirate);
			
			de=De.lanceDe(random);
			journal.lancerDe(pirate, de);
			
			journal.deplacement(pirate, de, plateau.getNbCases());
			
			pirate.deplacerPirate(plateau.getNbCases(), de);
			
			journal.descCase(pirate, plateau.getListeCases()[pirate.getPosition()-1]);
			if (plateau.getListeCases()[pirate.getPosition()-1].isCaseSpeciale()) {
				((CaseSpeciale) plateau.getListeCases()[pirate.getPosition()-1]).appliquerEffet(pirate, plateau, random, journal);
			}
			else {
				journal.appuieSurEntree();
			}
		}
	}
	
	
	
	private int checkDuel(Pirate initiateur, Pirate[] listeReac) {
		int indexReac=-1;
		if (initiateur.getPv()>0) {
			for (int j=0; j<listePirates.length;j++) {
				if (!initiateur.equals(listePirates[j]) && listePirates[j].getPv()>0 && Math.abs(initiateur.getPosition()-listePirates[j].getPosition())<4) {
					
					indexReac++;	
					listeReac[indexReac]=listePirates[j];
							
				}
			}
		}
		return indexReac;
				
		
	
	}
	
	private boolean gagnantBarque(Personnages personnages) {
		boolean arrivee=false;
		if (personnages.getPosition()==map.getNbCases()) {
			journal.gagnantBarque(personnages);
			arrivee=true;
		}
		return arrivee;
}
}
