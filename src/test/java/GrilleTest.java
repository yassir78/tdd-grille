import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import utils.Jeton;

import static org.junit.jupiter.api.Assertions.*;


class GrilleTest {

    private Grille grille;

    @BeforeEach
    public void initEach() {
        grille = new Grille();
    }

    @Test
    void shouldHave7ColumnsWhenCreated() {
        assertEquals(7, grille.getNombreColonne());
    }

    @Test
    void shouldHave6RowsWhenCreated() {
        assertEquals(6, grille.getNombreLigne());
    }

    @Test
    void shouldHaveDotsWhenCreated() {
        assertTrue(grille.isEmpty());
    }

    @Test
    void shouldAddJetonToFirstLineWhenAddedToFirstEmptyColumn() {
        grille.addJeton(Jeton.X.asChar(), 0);
        assertEquals(1, grille.countJetonInGrille());
        assertEquals('X', grille.getElement(0, 0));
    }

    @Test
    void shouldAddJetonToFirstLineWhenAddedToFirstEmptyColumn2() {
        grille.addJeton(Jeton.O.asChar(), 1);
        assertEquals(1, grille.countJetonInGrille());
        assertEquals('O', grille.getElement(0, 1));
    }

    @Test
    void shouldThrowExceptionWhenAddingJetonToColumn8() {
        Executable executable = () -> grille.addJeton(Jeton.O.asChar(), 8);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Le numéro de colonne est incorrect", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAddingJetonToColumnHigherThan7() {
        Executable executable = () -> grille.addJeton(Jeton.O.asChar(), 12);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Le numéro de colonne est incorrect", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAddingJetonToColumnLowerThan0() {
        Executable executable = () -> grille.addJeton(Jeton.O.asChar(), -1);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Le numéro de colonne est incorrect", exception.getMessage());
    }

    @Test
    void shouldAddJetonToSecondRowWhenAddedToFirstColumnWithAnExistingJeton() {
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.X.asChar(), 0);
        assertEquals(Jeton.X.asChar(), grille.getElement(1, 0));
    }

    @Test
    void shouldThrowExceptionWhenAddingJetonToColumnWith6Rown() {
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.O.asChar(), 0);
        Executable executable = () -> grille.addJeton(Jeton.O.asChar(), 0);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("La colonne est pleine", exception.getMessage());
    }

    @Test
    void shouldReturnEmptyGrilleWhenResettingTheGrille() {
        populateWithRandomValues(grille);
        grille.afficher();
        assertTrue(grille.isEmpty());
    }


    @Test
    void shouldDisplayGrilleIfEmpty() {
        String result = ".......\n.......\n.......\n.......\n.......\n.......\n";
        assertEquals(result, grille.toString());
    }

    @Test
    void shouldDisplayGrilleIfPopulated() {
        populateWithRandomValues(grille);
        String result = "OOOO...\nXXXX...\nOOOO...\n.......\n.......\n.......\n";
        assertEquals(result, grille.toString());
    }


    private void populateWithRandomValues(Grille grille) {
        grille.addJeton(Jeton.O.asChar(), 0);
        grille.addJeton(Jeton.X.asChar(), 0);
        grille.addJeton(Jeton.O.asChar(), 0);


        grille.addJeton(Jeton.O.asChar(), 1);
        grille.addJeton(Jeton.X.asChar(), 1);
        grille.addJeton(Jeton.O.asChar(), 1);

        grille.addJeton(Jeton.O.asChar(), 2);
        grille.addJeton(Jeton.X.asChar(), 2);
        grille.addJeton(Jeton.O.asChar(), 2);


        grille.addJeton(Jeton.O.asChar(), 3);
        grille.addJeton(Jeton.X.asChar(), 3);
        grille.addJeton(Jeton.O.asChar(), 3);

    }


}