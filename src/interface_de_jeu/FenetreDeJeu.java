package interface_de_jeu;

import pions.Personnage;
import jeu.Case;
import jeu.CaseReset; // Import de la classe CaseReset
import java.util.Scanner;

public class FenetreDeJeu implements Affichage {
    private static Scanner reader = new Scanner(System.in);
    
    public void gagnantBarque(Personnage personnage) {
        System.out.println(personnage.getNom().getNom() + " a trouvé la barque et devient le seul et unique capitaine !");
    }

    public void contexte(Personnage[] listePersonnage) {
        StringBuilder texte = new StringBuilder();
        for (int i = 0; i < listePersonnage.length - 1; i++) { 
            texte.append(listePersonnage[i].getNom().getNom()).append(", ");
        }
        texte.append(listePersonnage[listePersonnage.length - 1].getNom().getNom()); 
        texte.append(" sont ").append(listePersonnage.length)
                .append("  Le premier à trouver la barque pourra revenir au navire et ainsi devenir le seul et unique capitaine !\n");
        System.out.println(texte.toString());
    }

    public void aQuiTour(Personnage personnage) {
        System.out.println("C'est au tour de " + personnage.getNom().getNom() + ". " + personnage.getNom().getPronom()
                + " a " + personnage.getPv() + " PV."); 
        System.out.println("(Pour lancer, appuyez sur Entrée)");
        reader.nextLine();
    }

    public void lancerDe(Personnage personnage, int de) {
        System.out.println(personnage.getNom().getNom() + " lance les dés et fait " + de + "."); 
    }

    public void deplacement(Personnage personnage, int de, int nbCases) {
        StringBuilder texte = new StringBuilder();
        int nvNum = personnage.getPosition() + de;

        texte.append(personnage.getNom().getNom());
        if (de < 0) {
            texte.append(" recule");
        } else if (nvNum > nbCases) {
            texte.append(" avance de ").append(de - (nvNum - nbCases));
            texte.append(" et recule de ").append(nvNum - nbCases);
        } else {
            texte.append(" avance");
        }
        texte.append(". ");

        System.out.println(texte.toString());
    }

    public void descCase(Personnage personnage, Case caseActuelle) {
        System.out.println(personnage.getNom().getPronom() + " tombe sur la case " + caseActuelle.getNumero() + ".");
    }

    public void appuieSurEntree() {
        System.out.println("(Appuyez sur Entrée)");
        reader.nextLine();
    }

    public void appliquerPouvoir(Personnage personnage) {
        System.out.println("C'est une case Pouvoir ! " + personnage.getNom().getNom() + " reçoit une incroyable force inconnue.");
        appuieSurEntree();
    }

    public void appliquerEffetReset(CaseReset caseActuelle, Personnage personnage) {
        System.out.println("C'est une case Reset ! " + personnage.getNom().getNom() + " attire l'attention des natifs de l'île, tous les joueurs reviennent au départ... et bah bravo !");
        appuieSurEntree();
    }
    public void appliquerActionCaseReset(Personnage personnage) {
        System.out.println("C'est une case Reset! " + personnage.getNom().getNom() + " attire l'attention des natifs de l'ile, tous les joueurs reviennent au départ... et bah bravo !");
        appuieSurEntree();
    }
}

	


	
