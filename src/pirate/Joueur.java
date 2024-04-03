package pirate;

public class Joueur {
    private String nom;
    private int pv;
    private int position;
    private boolean immunite;

    public Joueur(String nom) {
        this.nom = nom;
        this.pv = 5;
        this.position = 1; // Case départ
        this.immunite = false;
    }

    public void avancer(int de) {
        if (position + de > 30) {
            int depassement = (position + de) - 30;
            position = 30 - depassement;
        } else {
            position += de;
        }
    }

    public boolean estEnJeu() {
        return pv > 0 && position < 30;
    }

    public void activerImmunite() {
        this.immunite = true;
    }

    public boolean estImmunise() {
        return immunite;
    }

    public void desactiverImmunite() {
        this.immunite = false;
    }

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



