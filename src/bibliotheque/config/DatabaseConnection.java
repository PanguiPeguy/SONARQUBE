package bibliotheque.config;

public class DatabaseConnection {
    private boolean connected = false;

    public void connect() {
        // Simulation d'une connexion à une base de données
        System.out.println("Connexion à la base de données...");
        connected = true;
    }

    // Méthode qui devrait être appelée mais qui est souvent oubliée
    public void close() {
        if (connected) {
            System.out.println("Fermeture de la connexion à la base de données");
            connected = false;
        }
    }

    // Finaliseur déconseillé (code smell)
    @Override
    protected void finalize() {
        if (connected) {
            System.out.println("Warning: connexion non fermée correctement");
            close();
        }
    }
}
