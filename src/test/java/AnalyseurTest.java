import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.AnalyseurConstantes;
import utils.Jeton;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalyseurTest {

    private Grille grille;

    @BeforeEach
    void setUp() {
        grille = Mockito.mock(Grille.class);
    }

    @Test
    void ShouldReturnAWinnerWhenGivenAGridWithFirstRowFilledWith4ConsecutiveSimilarTokens() {
        Mockito.when(grille.getLignes()).thenReturn(AnalyseurConstantes.FAKE_CONSTANTES_LIGNE);
        assertEquals(String.valueOf(Jeton.O.asChar()), Analyseur.analyser(grille).get());
    }

    @Test
    void ShouldReturnAWinnerWhenGivenAGridWithFirstColumnFilledWith4ConsecutiveSimilarTokens() {
        Mockito.when(grille.getColonnes()).thenReturn(AnalyseurConstantes.FAKE_CONSTANTES_COLONNE);
        assertEquals(String.valueOf(Jeton.O.asChar()), Analyseur.analyser(grille).get());
    }
}