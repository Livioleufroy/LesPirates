package pirate;

import java.util.Random;

public class EffetCase {
    private String nom;
    private String description;

    public EffetCase(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void appliquerEffet(Joueur joueur, Joueur joueur1, Joueur joueur2) {
        switch (this.nom) {
            case "Case Piege":
                // Le joueur reste immobile jusqu'à l'obtention d'un 6 ou jusqu'à la fin du tour
                boolean aFaitUnSix = false;
                while (!aFaitUnSix) {
                    int de = new Random().nextInt(6) + 1;
                    System.out.println(joueur.getNom() + " lance le dé et obtient " + de);
                    if (de == 6) {
                        System.out.println(joueur.getNom() + " a obtenu un 6 ! Il peut avancer.");
                        aFaitUnSix = true;
                    } else {
                        System.out.println(joueur.getNom() + " n'a pas obtenu un 6. Il reste immobile pour ce tour.");
                        // Changer de joueur pour lancer le dé
                        joueur = (joueur == joueur1) ? joueur2 : joueur1;
                        System.out.println("C'est maintenant au tour de " + joueur.getNom() + ".");
                    }
                }
                break;
            // Les autres cas restent inchangés
            case "Case Canon":
                joueur.setPv(joueur.getPv() - 1);
                break;
            case "Case Pouvoir":
                if (joueur.getPv() < 5) {
                    joueur.setPv(joueur.getPv() + 1);
                }
                // Effet d'immunité pendant 3 tours
                joueur.activerImmunite();
                break;
            case "Case Reset":
                joueur.setPosition(1);
                break;
            case "Case Versus":
                // Affrontement entre les deux joueurs
                int deJoueur1 = new Random().nextInt(6) + 1;
                int deJoueur2 = new Random().nextInt(6) + 1;

                System.out.println("Le joueur " + joueur.getNom() + " lance le dé et obtient " + deJoueur1);
                System.out.println("Le joueur affronté lance le dé et obtient " + deJoueur2);

                if (deJoueur1 < deJoueur2) {
                    System.out.println("Le joueur " + joueur.getNom() + " perd l'affrontement et perd 1 PV !");
                    joueur.setPv(joueur.getPv() - 1);
                } else if (deJoueur1 > deJoueur2) {
                    System.out.println("Le joueur " + joueur.getNom() + " remporte l'affrontement !");
                } else {
                    System.out.println("Égalité ! Aucun joueur ne perd de PV.");
                }
                break;
        }
    }

	
		
	}





