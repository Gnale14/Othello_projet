package Modele;

public class Joueur {
    private String nom;
    private int numJoueur;
    private int nbPartieGagnee;

    public Joueur(int numJoueur) {
        this.numJoueur = numJoueur;
        this.nbPartieGagnee=0;
    }

    public void gagnePartie(){
        nbPartieGagnee++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public int getNbPartieGagnee() {
        return nbPartieGagnee;
    }
}
