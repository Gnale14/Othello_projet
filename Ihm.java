package Vue;
import Modele.Controleur;
import java.util.Scanner;

import static Modele.Controleur.Jouabilite;
import static Modele.Controleur.ModificationSiValide;

public class Ihm {
    Controleur controleur;
    Scanner sc;


    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
        sc = new Scanner(System.in);
    }


    static void Affichage (char[][]plateau){
        System.out.println (" ");
        System.out.println("-------REVERSI-------");
        System.out.println (" ");
        System.out.println ("|_1_|_2_|_3_|_4_|_5_|_6_|_7_|_8_|");
        for (int i=0 ; i<8; i++){ //   Colonne
            System.out.println(" ");
            for (int j=0; j<8 ; j++){
                System.out.print("|");
                System.out.print(" ");
                System.out.print (plateau [i][j]+" ");
            }
            System.out.println ("|_"+(i+1)+"_|");
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    static void Score(char[][] plateau, String joueurA, String joueurB) {
        int noir = 0, blanc = 0;
        for (int i = 0; i < 8; i++) {
            int j;
            for (j = 0; j < 8; j++) {
                if (plateau[i][j] == 'X') {
                    noir = noir + 1;
                }
                if (plateau[i][j] == 'O') {
                    blanc = blanc + 1;
                }
            }
        }
        System.out.println("le Score est de :" + noir + "pour" + joueurA + "et" + blanc + "pour" + joueurB + ".");

    }
    public void lancerPartie() {
            int partieGagneeA=0 , partieGagneeB=0 , rejouer , quiJou ,ligne,colonne,scoreA=0,scoreB=0
                    , finDePartie=0,avis;
            String joueurA, joueurB,joueurActuel;
            char[][]plateau ;
            char iconeJoueurActuel ;
            plateau= new char [8][8];
            System.out.println ("---BIENVENUE SUR REVERSI---");
            System.out.println();
            System.out.println("Premier joueur,entrer votre nom:");
        Scanner in = NewScanner(System.in);
        joueurA = in.nextLine();
            System.out.println("Deuxi�me joueur,entrer votre nom:");
            joueurB= in.nextLine() ;
            System.out.println();
            do{
                avis=1;
                quiJou= 1;
                for (int i = 0;i<8;i++){
                    for(int j=0; j<8;j++){
                        plateau[i][j] ='.';
                    }
                }
                plateau[3][3]=plateau[4][3]='X';
                plateau[3][4]=plateau[4][4]='O';
                Affichage(plateau);
                while (avis==1){
                    if(quiJou%2!=0){joueurActuel=joueurA;
                        iconeJoueurActuel='X';
                    }
                    else{
                        joueurActuel=joueurB;
                        iconeJoueurActuel='O';
                    }
                    quiJou=quiJou+1;

                    avis= Jouabilite(plateau,iconeJoueurActuel);
                    if (avis==1){
                        finDePartie=0;
                        do{
                            do{
                                System.out.println(joueurActuel+"entrer le numero de ligne d'une case valide:");
                                ligne=in.nextInt();
                                System.out.println(joueurActuel+"entrer le numero de colonne d'une case valide:");
                                colonne=in.nextInt();
                            }
                            while(ligne>8||ligne<1||colonne>8||colonne<1);
                            colonne=colonne-1;
                            ligne=ligne-1;
                            avis = ModificationSiValide(plateau,ligne,colonne,iconeJoueurActuel);
                            if(avis==1){
                                System.out.println();
                                Affichage(plateau);
                                System.out.println();

                                Score(plateau,joueurA,joueurB);
                            }
                            else {
                                System.out.println("La case choisie est invalide! Recommence. ");
                            }
                        }
                        while(avis==0);
                    }
                    else{
                        System.out.println(joueurActuel+"il y a aucun emplacement valide, au suivant");
                        finDePartie=finDePartie+1;
                    }
                    avis=1;
                    if(finDePartie==2){
                        avis =0;
                    }
                }
                Affichage(plateau);
                System.out.println();
                System.out.println("Fin De La Partie!");

                Score(plateau,joueurA,joueurB);
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if(plateau[i][j]=='X'){
                            scoreA=scoreA+1;
                        }
                        if(plateau[i][j]=='O'){
                            scoreB=scoreB+1;
                        }
                    }
                }
                if(scoreA<scoreB){
                    partieGagneeB=partieGagneeB+1;
                }
                if (scoreB<scoreA){
                    partieGagneeA=partieGagneeA+1;
                }
                System.out.println("le nombre de partie gagne est de :"+partieGagneeA+"pour"+joueurA+"et de"+partieGagneeB+"pour"+joueurB);
                do {
                    System.out.println("Pour rejouer taper 1");
                    System.out.println("Pour quitter taper 2");
                    rejouer=in.nextInt();
                }
                while(rejouer!=1&&rejouer!=2);
            }
            while(rejouer==1);
            System.out.println("Au revoir !");
        }
    }

