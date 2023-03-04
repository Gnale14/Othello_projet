package Modele;

public class Grille {
    private int[][] plateau;
    private int nbLigne;
    private int nbColonne;

    public Grille() {
        plateau= new int [8][8];
        for (int i = 0;i<8;i++){
            for(int j=0; j<8;j++){
                plateau[i][j] = 0;
            }
        }
        plateau[3][3]=plateau[4][4]=1;
        plateau[3][4]=plateau[4][3]=2;
        nbLigne =8;
        nbColonne = 8;
    }
}
