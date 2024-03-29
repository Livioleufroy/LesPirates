package pions;

public enum Nom {
JILL("Jill jambe de bois", "Il"),JACK("Jack le borgne", "Il");
	
	private String nom;
	private String pronom;
	private Nom(String nom, String pronom) {
	this.nom = nom;
	this.pronom=pronom;
	}

	public String getNom() {
	return nom;
	}
	
	public String getPronom() {
		return pronom;
	}
}
