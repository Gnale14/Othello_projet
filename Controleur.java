package Modele;
import Vue.Ihm;

public class Controleur {

    private Ihm ihm;
    private Joueur joueurA;
    private Joueur joueurB;
    private Joueur joueurActuel;
    private Grille grille;
    private String nom;
    private int numJoueur;
    private int nbPartieGagnee;

    public Controleur(Ihm ihm) {
        this.ihm = ihm;
        ihm.setControleur(this);
        joueurA = new Joueur(1);
        joueurB = new Joueur(2);
        joueurActuel = joueurA;
    }

    /*public Joueur getJoueurA() {
        return joueurA;
    }

    public Joueur getJoueurB() {
        return joueurB;
    }
    public void Joueur(int numJoueur) {
        this.numJoueur = numJoueur;
        this.nbPartieGagnee=0;
    }*/

    public void commencerJeu(){
        boolean jouer = true;
        while (jouer){
          ihm.lancerPartie();
        }
        ihm.lancerPartie();
       // ihm.finDuJeu(joueurA.getNom(), joueurA.getNbPartieGagnee(), joueurB.getNom(), joueurB.getNbPartieGagnee());
    }

    static int DeplacementValide (char[][]plateau, int I,int c,int dL,int dC, char iJA, int action) {
        int nDT = 1;
        int nDL = 0;
        int nDC = 0;
        char icone ,autreIcone ;
        if(iJA=='X'){
            icone = 'X';
            autreIcone = 'O';
        }
        else {
            icone = 'O';
            autreIcone = 'X';
        }
        if (plateau[I][c]=='.'){
            while (I+2*dL + nDL >= 0 && I +2*dL + nDL <=7 && c + 2*dC + nDC >=0 && c + 2*dC + nDC <= 7 && plateau[I+dL+nDL][c+dC+nDC]==autreIcone){
                nDL = dL + nDL ;
                nDC = dC + nDC ;
                nDT = nDT + 1;
                if (plateau [I+dL+nDL][c+dC+nDC]== icone ){
                    if (action == 2){
                        for (int k = 0 ;k <=nDT ; k++){
                            plateau [I+dL*k][c+dC*k]= icone ;
                        }
                        return 1 ;
                    }
                }
            }

        }
        return 0;
    }
    public static int Jouabilite(char[][] plateau, char iconeJoueurActuel) {
        int nDV = 0;
        for (int i =0 ; i<8; i++){
            for (int j = 0; j<8;j++){
                nDV = DeplacementValide(plateau,i,j,1,0,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,0,1,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,1,1,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,-1,0,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,0,-1,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,-1,-1,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,1,-1,iconeJoueurActuel,1)+nDV ;
                nDV = DeplacementValide(plateau,i,j,-1,1,iconeJoueurActuel,1)+nDV ;
            }
        }
        if (nDV !=0){
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int ModificationSiValide(char[][] plateau, int I, int c, char iconeJoueurActuel) {
        int validite ;
        validite= DeplacementValide(plateau,I,c,1,0,iconeJoueurActuel,2);
        if (validite == 1){
            return 1 ;
        }
        validite = DeplacementValide(plateau,I,c,0,1,iconeJoueurActuel,2);
        if (validite == 1){
            return 1;
        }
        validite = DeplacementValide(plateau,I,c,1,1,iconeJoueurActuel,2);
        if (validite == 1){
            return 1;
        }
        validite = DeplacementValide(plateau,I,c,-1,0,iconeJoueurActuel,2);
        if (validite == 1){
            return 1;
        }
        validite = DeplacementValide(plateau,I,c,0,-1,iconeJoueurActuel,2);
        if (validite == 1){
            return 1;
        }
        validite = DeplacementValide(plateau,I,c,1,-1,iconeJoueurActuel,2);
        if (validite == 1){
            return 1;
        }
        validite = DeplacementValide(plateau,I,c,-1,1,iconeJoueurActuel,2);
        if (validite == 1){
            return 1 ;
        }
        validite = DeplacementValide(plateau,I,c,-1,-1,iconeJoueurActuel,2);
        if (validite == 1){
            return 1 ;
        }
        return 0 ;
    }



}