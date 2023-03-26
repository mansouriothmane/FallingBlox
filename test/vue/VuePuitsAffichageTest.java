package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits() {
                // Créer une instance de Puits
                Puits puits = new Puits();

                // Créer une instance de VuePuits avec le puits
                VuePuits vuePuits = new VuePuits(puits);

                // Créer une JFrame avec la vuePuits
                JFrame frame = new JFrame("Puits");
                frame.getContentPane().add(vuePuits);

                // Définir la taille de la fenêtre en fonction de la vuePuits
                frame.pack();

                // Centrer la fenêtre sur l'écran
                frame.setLocationRelativeTo(null);

                // Fermer l'application quand la fenêtre est fermée
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void testConstructeurPuitsTaille() {
                // Créer une instance de Puits
                Puits puits = new Puits();

                // Créer une instance de VuePuits avec le puits et une taille de 100
                VuePuits vuePuits = new VuePuits(puits, 100);

                // Créer une JFrame avec la vuePuits
                JFrame frame = new JFrame("Puits et taille");
                frame.getContentPane().add(vuePuits);

                // Définir la taille de la fenêtre en fonction de la vuePuits
                frame.pack();

                // Centrer la fenêtre sur l'écran
                frame.setLocationRelativeTo(null);

                // Fermer l'application quand la fenêtre est fermée
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new VuePuitsAffichageTest();
            }
        });
    }
}