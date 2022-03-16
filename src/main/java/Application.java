import utils.Jeton;

public class Application {

    Grille grille;
    Vue vue;
    Analyseur analyseur;


    public Application(Vue vue, Analyseur analyseur, Grille grille) {
        this.vue = vue;
        this.analyseur = analyseur;
        this.grille = grille;
    }

    public void run() {

        while (true) {
            vue.displayMessage(grille, Jeton.X.asChar());
            Integer column = vue.getColumnFromUser();
            grille.addJeton(Jeton.X.asChar(), column);
        }
    }
}
