package bibliotheque.model;

import java.util.Date;

public class Auteur {
    private String nom;
    private Date dateNaissance;
    private String pays;

    public Auteur(String nom, Date dateNaissance, String pays) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.pays = pays;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    // Bug de comparaison de dates (bug)
    public boolean estPlusAgeQue(Auteur autreAuteur) {
        return this.dateNaissance.before(autreAuteur.dateNaissance);
    }
}
