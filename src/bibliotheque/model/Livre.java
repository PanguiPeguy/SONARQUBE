package bibliotheque.model;

public class Livre {
    private String titre;
    private Auteur auteur;
    private int anneePublication;
    private int nombrePages;
    private String categorie;
    private boolean disponible;
    private double note;
    private int nombreEmprunts;

    // Constructeur avec trop de paramètres (code smell)
    public Livre(String titre, Auteur auteur, int anneePublication, int nombrePages, String categorie) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.nombrePages = nombrePages;
        this.categorie = categorie;
        this.disponible = true;
        this.note = 0.0;
        this.nombreEmprunts = 0;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getNombreEmprunts() {
        return nombreEmprunts;
    }

    public void setNombreEmprunts(int nombreEmprunts) {
        this.nombreEmprunts = nombreEmprunts;
    }

    // Méthode toString() avec une chaîne de concaténation inefficace (code smell)
    @Override
    public String toString() {
        String result = "";
        result = result + "Titre: " + titre;
        result = result + ", Auteur: " + auteur.getNom();
        result = result + ", Année: " + anneePublication;
        result = result + ", Pages: " + nombrePages;
        result = result + ", Catégorie: " + categorie;
        result = result + ", Disponible: " + disponible;
        return result;
    }
}