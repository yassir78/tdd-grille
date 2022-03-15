import java.util.Arrays;

public class Grille {

    private static final int COLONNES = 7;
    private static final int LIGNES = 6;
    private char[][] matrice;

    public char[][] getMatrice() {
        return matrice;
    }


    public Grille() {
        this.matrice = new char[LIGNES][COLONNES];
        this.populate();

    }

    public int getNombreColonne() {
        return matrice[0] == null ? 0 : matrice[0].length;
    }

    public int getNombreLigne() {
        return matrice.length;
    }

    public boolean isEmpty() {
        boolean hasDot = true;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] != '.') {
                    hasDot = false;
                    break;
                }
            }
        }
        return hasDot;
    }

    private void populate() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                this.matrice[i][j] = '.';
            }
        }
    }

    public int getCountJetonsInColumns(int colonne) {
        int count = 0;
        for (int i = 0; i < LIGNES; i++) {
            if (matrice[i][colonne] != '.') {
                count++;
            }
        }
        return count;
    }

    public int countJetonInGrille() {
        int count = 0;
        for (int i = 0; i < COLONNES; i++)
            count += getCountJetonsInColumns(i);
        return count;
    }

    public void addJeton(char x, int column) {
        if (column > COLONNES || column < 0)
            throw new IllegalArgumentException("Le numéro de colonne est incorrect");

        int rowToInsert = getCountJetonsInColumns(column);
        if (rowToInsert >= LIGNES)
            throw new IllegalArgumentException("La colonne est pleine");
        matrice[rowToInsert][column] = x;
    }

    public int getElement(int ligne, int colonne) {
        return matrice[ligne][colonne];
    }

    public void afficher() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : matrice) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void reset() {
        for (char[] chars : matrice) {
            Arrays.fill(chars, '.');
        }
    }
}
