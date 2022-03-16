package utils;

import java.util.List;

public class AnalyseurConstantes {

    public static final List<char[]> FAKE_CONSTANTES_COLONNE = List.of(
            new char[]{'.', '.', Jeton.O.asChar(), Jeton.O.asChar(), Jeton.O.asChar(), Jeton.O.asChar()},
            new char[]{'.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.'}
    );

    public static final List<char[]> FAKE_CONSTANTES_LIGNE = List.of(
            new char[]{'.', '.', '.', Jeton.O.asChar(), Jeton.O.asChar(), Jeton.O.asChar(), Jeton.O.asChar()},
            new char[]{'.', '.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.', '.'},
            new char[]{'.', '.', '.', '.', '.', '.', '.'}
    );
}
