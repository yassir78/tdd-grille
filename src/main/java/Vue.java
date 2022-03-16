import java.util.Random;

public class Vue {

    private static final Random random = new Random();

    static void printGrid(Grille grille) {
        grille.afficher();
    }

    public  Integer getColumnFromUser() {
        return 1 + random.nextInt(7);
    }

    public void displayMessage(Grille grille, char jeton) {
        System.out.println("Bienvenue dans le jeu :  Puissance4 !");
        // affichage de la grille
        // affichage du nom du joueur 1
    }


}
