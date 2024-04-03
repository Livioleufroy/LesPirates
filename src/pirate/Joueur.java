package pirate;

public class Joueur {
    private String nom;
    private int pv;
    private int position;

    public Joueur(String nom) {
        this.nom = nom;
        this.pv = 5;
        this.position = 1; // Case départ
    }

    // Méthode pour avancer le joueur sur le plateau
    public void avancer(int de) {
        position += de;
        if (position > 30) // Dépassement de la case d'arrivée
            position = 30;
    }

    // Méthode pour déterminer si le joueur est toujours en jeu
    public boolean estEnJeu() {
        return pv > 0 && position < 30;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


