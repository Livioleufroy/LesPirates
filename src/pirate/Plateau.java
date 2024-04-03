package pirate;

public class Plateau {
    // Méthode pour obtenir le nom d'une case spéciale
    public static String nomCaseSpeciale(int position) {
        switch (position) {
            case 5:
                return "Case Piege";
            case 8:
            case 12:
            case 22:
            case 27:
                return "Case Canon";
            case 10:
            case 20:
                return "Case Pouvoir";
            case 15:
                return "Case Reset";
            case 18:
                return "Case Versus";
            default:
                return "";
        }
    }

    // Méthode pour vérifier si une case est spéciale
    public static boolean estCaseSpeciale(int position) {
        int[] casesSpeciales = {5, 8, 10, 12, 15, 18, 20, 22, 27};
        for (int caseSpeciale : casesSpeciales) {
            if (caseSpeciale == position)
                return true;
        }
        return false;
    }

    // Méthode pour obtenir l'effet d'une case spéciale
    public static String effetCaseSpeciale(int position) {
        switch (position) {
            case 5:
            case 11:
            case 29:
                return "Le joueur reste sur cette case jusqu'à obtenir un 6 avec le dé.";
            case 8:
            case 12:
            case 22:
            case 27:
                return "Le joueur perd 1 PV.";
            case 10:
            case 20:
                return "Le joueur gagne 1 PV et est immunisé de tous les effets spéciaux pendant 3 tours.";
            case 15:
                return "Les joueurs sont ramenés à la case départ.";
            case 18:
                return "Les joueurs s'affrontent. Le joueur avec le numéro de dé le plus bas perd 1 PV.";
            default:
                return "";
        }
    }
}




