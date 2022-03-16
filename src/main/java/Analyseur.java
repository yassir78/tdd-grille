import utils.Jeton;

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
            if (row.contains(Jeton.O.toString().concat(Jeton.O.toString().concat(Jeton.O.toString().concat(Jeton.O.toString())))))
                return Optional.of(Jeton.O.toString());
            if (row.contains(Jeton.X.toString().concat(Jeton.X.toString().concat(Jeton.X.toString().concat(Jeton.X.toString())))))
                return Optional.of(Jeton.X.toString());
        }
        return Optional.empty();
    }


}