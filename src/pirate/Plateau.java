package pirate;

public class Plateau {
    public static EffetCase getEffetCaseSpeciale(int position) {
        switch (position) {
            case 5:
            case 13:
            case 27:
                return new EffetCase("Case Piege", "Reste immobile jusqu'à l'obtention d'un 6");
            case 8:
            case 12:
            case 22:
            case 24:
                return new EffetCase("Case Canon", "Perd 1 PV");
            case 10:
            case 20:
            case 1:
                return new EffetCase("Case Pouvoir", "Gagne 1 PV et immunisé contre les effets spéciaux pendant 3 tours");
            case 7:
            case 25:
                return new EffetCase("Case Reset", "Retourne à la case de départ");
            case 18:
            case 3:
            case 28:
                return new EffetCase("Case Versus", "S'affronte avec un autre joueur");
            default:
                return null;
        }
    }

    public static void appliquerEffetCaseSpeciale(Joueur joueur, Joueur joueur1, Joueur joueur2, int position) {
        EffetCase effet = getEffetCaseSpeciale(position);
        if (effet != null) {
            effet.appliquerEffet(joueur, joueur1, joueur2);
        }
    }

    public static boolean estCaseSpeciale(int position) {
        return getEffetCaseSpeciale(position) != null;
    }

    public static void afficherInfos(Joueur joueur1, Joueur joueur2, int tour) {
        // Afficher les informations sur les joueurs
        System.out.println("Plateau de jeu :");
        Affichage.afficherPlateauSpirale();
        System.out.println("Tour " + tour + ":");
        System.out.println(joueur1.getNom() + " (PV: " + joueur1.getPv() + ", Position: " + joueur1.getPosition() + ")");
        System.out.println(joueur2.getNom() + " (PV: " + joueur2.getPv() + ", Position: " + joueur2.getPosition() + ")");
    }
}





