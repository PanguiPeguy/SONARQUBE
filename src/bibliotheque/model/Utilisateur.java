package bibliotheque.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilisateur {
    // Violation d'encapsulation - attributs publics (code smell)
    public String nom;
    public String email;
    private List<Livre> livresEmpruntes;

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
        this.livresEmpruntes = new ArrayList<>();
    }

    // Méthode avec gestion incorrecte des exceptions (bug)
    public void emprunterLivre(Livre livre) {
        try {
            if (livre.getDisponible()) {
                livresEmpruntes.add(livre);
                livre.setDisponible(false);
                System.out.println(nom + " a emprunté " + livre.getTitre());
            } else {
                throw new Exception("Livre non disponible");
            }
        } catch (Exception e) {
            // Empty catch block (bug)
        }
    }

    // Méthode avec fuite mémoire potentielle (bug)
    public void analyserHistoriqueEmprunts() {
        Map<String, Integer> stats = new HashMap<>();
        // La map grandit indéfiniment sans contrôle
        for (Livre livre : livresEmpruntes) {
            stats.put(livre.getTitre() + System.currentTimeMillis(), livre.getNombrePages());
        }
    }
}
