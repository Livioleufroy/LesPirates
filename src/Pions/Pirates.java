package Pions;

public class Pirates {
	private int pv=5;
	private Nom nom;
	private Couleur couleur;
	private int position=1;
	
	public Pirates(Nom nom, Couleur couleur) {
		this.nom=nom;
		this.couleur=couleur;
	}
	

	public int getPv() {
		return pv;
	}
	public Nom getNom() {
		return nom;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPv(int pv) {
		this.pv=pv;
	}
	
	public void deplacerPirate(int nbCases, int valeurDe) {
		int Num;
		if (valeurDe<0) {
			Num=getPosition()-Math.abs(valeurDe);
			
			 if (Num<1) {
				Num=1;
			}
		}
		else {
			Num= position+valeurDe;
			
			// Depasse la case arrivee
			if (Num>nbCases) {
				Num=nbCases-(nvNum-nbCases);
			}
		}
		
		position=Num;
	}
	
	
	public int calculerDegat(int difference) {
		int degat;
		if (difference>=10) {
			degat=3;
		}
		else if (difference>=5) {
			degat=2;
		}
		else {
			degat=1;
		}
		return degat;
	}
	
	public void infligerDegat(int difference) {
		int nvPv;
		
		nvPv=pv-calculerDegat(difference);
		if (nvPv<0) {
			nvPv=0;
		}
		pv=nvPv;
	}
}


