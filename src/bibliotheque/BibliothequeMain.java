package bibliotheque;

import bibliotheque.config.DatabaseConnection;
import bibliotheque.model.Auteur;
import bibliotheque.model.Livre;
import bibliotheque.model.Utilisateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Classe principale du système de gestion de bibliothèque
 * Contient des erreurs intentionnelles pour démonstration SonarQube
 */
public class BibliothequeMain {

    // Variables globales (mauvaise pratique - bug potentiel)
    public static List<Livre> tousLesLivres = new ArrayList<>();
    public static List<Utilisateur> tousLesUtilisateurs = new ArrayList<>();

    // Duplication de code (violation)
    private static final String PASSWORD = "admin123"; // Credential hardcodé (vulnérabilité)

    public static void main(String[] args) {
        System.out.println("Démarrage du système de bibliothèque...");

        // Initialisation avec des données en dur
        initialiserDonnees();

        // Code mort (violation)
        if (false) {
            System.out.println("Ce code ne sera jamais exécuté");
        }

        // Complexité cyclomatique excessive (violation)
        processAllBooks();

        // Utilisation risquée de null (code smell)
        Livre livre = null;
        try {
            livre.getTitre(); // NullPointerException
        } catch (Exception e) {
            // Catch générique (mauvaise pratique)
            e.printStackTrace(); // Mauvaise gestion des exceptions
        }

        // Fuite de ressources (bug)
        DatabaseConnection db = new DatabaseConnection();
        db.connect();
        // Oubli de fermer la connexion

        System.out.println("Fin du programme");
    }

    // Méthode avec complexité cyclomatique excessive (violation)
    private static void processAllBooks() {
        for (Livre livre : tousLesLivres) {
            if (livre.getDisponible()) {
                if (livre.getCategorie().equals("Roman")) {
                    if (livre.getAnneePublication() > 2000) {
                        if (livre.getNombrePages() > 200) {
                            System.out.println("Livre moderne trouvé: " + livre.getTitre());
                            if (livre.getAuteur().getPays().equals("France")) {
                                System.out.println("Auteur français");
                                if (livre.getNombreEmprunts() > 10) {
                                    System.out.println("Livre populaire");
                                    if (livre.getNote() > 4) {
                                        System.out.println("Livre très bien noté");
                                        // Continuation de nested ifs (mauvaise pratique)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Duplication de code (violation) - similaire à processAllBooks
    private static void processAllBooksAgain() {
        for (Livre livre : tousLesLivres) {
            if (livre.getDisponible()) {
                if (livre.getCategorie().equals("Roman")) {
                    if (livre.getAnneePublication() > 2000) {
                        if (livre.getNombrePages() > 200) {
                            System.out.println("Livre moderne trouvé: " + livre.getTitre());
                            if (livre.getAuteur().getPays().equals("France")) {
                                System.out.println("Auteur français");
                                if (livre.getNombreEmprunts() > 10) {
                                    System.out.println("Livre populaire");
                                    if (livre.getNote() > 4) {
                                        System.out.println("Livre très bien noté");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Méthode trop longue (code smell)
    private static void initialiserDonnees() {
        // Création d'auteurs
        Auteur auteur1 = new Auteur("Victor Hugo", new Date(), "France");
        Auteur auteur2 = new Auteur("Albert Camus", new Date(), "France");
        Auteur auteur3 = new Auteur("J.K. Rowling", new Date(), "Royaume-Uni");

        // Création de livres
        Livre livre1 = new Livre("Les Misérables", auteur1, 1862, 1500, "Roman");
        livre1.setDisponible(true);
        livre1.setNote(4.8);
        livre1.setNombreEmprunts(150);

        Livre livre2 = new Livre("L'Étranger", auteur2, 1942, 159, "Roman");
        livre2.setDisponible(false);
        livre2.setNote(4.5);
        livre2.setNombreEmprunts(120);

        Livre livre3 = new Livre("Harry Potter à l'école des sorciers", auteur3, 1997, 309, "Fantasy");
        livre3.setDisponible(true);
        livre3.setNote(4.7);
        livre3.setNombreEmprunts(200);

        // Ajout des livres à la liste
        tousLesLivres.add(livre1);
        tousLesLivres.add(livre2);
        tousLesLivres.add(livre3);

        // Bug potentiel - on répète l'ajout du même livre (duplication de données)
        tousLesLivres.add(livre1);

        // Création d'utilisateurs
        Utilisateur user1 = new Utilisateur("Jean Dupont", "jean@example.com");
        Utilisateur user2 = new Utilisateur("Marie Martin", "marie@example.com");

        // Ajout des utilisateurs à la liste
        tousLesUtilisateurs.add(user1);
        tousLesUtilisateurs.add(user2);

        // Code inutile/inefficace (code smell)
        for (int i = 0; i < 1000; i++) {
            // Calcul inutile
            double unused = Math.random() * i;
        }

        // Problème de sécurité: génération de nombres aléatoires prévisibles (vulnérabilité)
        Random random = new Random(123); // Seed fixe
        int randomNumber = random.nextInt();

        // Utilisation incorrecte d'égalité pour les flottants (bug)
        double a = 0.1 + 0.2;
        if (a == 0.3) { // Problème de précision des flottants
            System.out.println("Égalité correcte");
        }

        // Utilisation inefficace des collections (code smell)
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("élément" + i);
        }

        // Recherche inefficace (performance)
        boolean found = false;
        for (String item : list) {
            if (item.equals("élément50")) {
                found = true;
                break;
            }
        }
    }

    // Méthode avec trop de paramètres (code smell)
    public static void ajouterLivre(String titre, String auteurNom, String auteurPays,
                                    Date auteurDateNaissance, int anneePublication,
                                    int nombrePages, String categorie, boolean disponible,
                                    double note, int nombreEmprunts, String editeur,
                                    String isbn, String langue, int edition) {
        // Corps de la méthode
    }

    // Classe interne avec responsabilités multiples (violation SRP)
    static class UtilitaireBibliotheque {
        // Méthode avec variable inutilisée (code smell)
        public void calculerAmende(Utilisateur utilisateur, Livre livre, int joursRetard) {
            double montantBase = 0.5;
            double tauxJournalier = 0.1; // Variable non utilisée

            double amende = montantBase * joursRetard;
            System.out.println("Amende calculée: " + amende + "€");
        }

        // Violation de l'encapsulation (code smell)
        public void modifierUtilisateur(Utilisateur user) {
            user.nom = "Nouveau nom"; // Accès direct aux attributs
            user.email = "nouveau@example.com"; // Accès direct aux attributs
        }

        // Switch statement qui pourrait utiliser le polymorphisme (code smell)
        public double calculerPrix(String typeUtilisateur) {
            switch(typeUtilisateur) {
                case "Étudiant":
                    return 10.0;
                case "Professeur":
                    return 8.0;
                case "Retraité":
                    return 7.0;
                case "Enfant":
                    return 5.0;
                default:
                    return 15.0;
            }
        }
    }
}
