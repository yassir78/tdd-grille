import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.Jeton;

class ApplicationTest {

    Vue vue;
    Analyseur analyseur;
    Grille grille;
    Application application;

    @BeforeEach
    void setUp() {
        vue = Mockito.mock(Vue.class);
        analyseur = Mockito.mock(Analyseur.class);
        grille = Mockito.mock(Grille.class);
        application = new Application(vue, analyseur, grille);
    }

    @Test
    void applicationShouldDisplayAWelcomeMessageAndAskTheFirstPlayerToChooseAColumn() {
        application.run();
        Mockito.verify(vue, Mockito.times(1)).displayMessage(grille, Jeton.X.asChar());
    }

    @Test
    void applicationShouldInsertTheTokenInTheCorrectColumnIndicatedByThePlayer() {
        Mockito.when(vue.getColumnFromUser()).thenReturn(1);
        application.run();
        Mockito.verify(vue, Mockito.times(1)).getColumnFromUser();
        Mockito.verify(grille, Mockito.times(1)).addJeton(Jeton.X.asChar(), 1);
    }

    @Test
    void applicationShouldAskNextPlayerToChooseAColumnWhenTheGameIsStillGoing(){
        application.run();
        Mockito.verify(vue, Mockito.times(1)).displayMessage(grille, Jeton.O.asChar());
    }

}