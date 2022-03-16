import utils.Jeton;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Analyseur {

    public static Optional<String> analyser(Grille grille) {

        Optional<String> processRowResult = processData(grille.getLignes());
        if (processRowResult.isPresent())
            return processRowResult;
        return processData(grille.getColonnes());
    }


    private static Optional<String> processData(List<char[]> data) {
        for (char[] ligne : data) {
            String row = String.valueOf(ligne);
            if (row.contains(String.join("", Collections.nCopies(4, Jeton.O.toString()))))
                return Optional.of(Jeton.O.toString());
            if (row.contains(String.join("", Collections.nCopies(4, Jeton.X.toString()))))
                return Optional.of(Jeton.X.toString());
        }
        return Optional.empty();
    }


}