package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.*;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.*;

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
                puits.setPieceSuivante(UsineDePiece.genererPiece());
                puits.setPieceSuivante(UsineDePiece.genererPiece());

                // Créer une JFrame avec la vuePuits
                JFrame frame = new JFrame("Puits");
                frame.add(vuePuits);

                // Définir la taille de la fenêtre en fonction de la vuePuits
                frame.pack();

                // Centrer la fenêtre sur l'écran
                frame.setLocationRelativeTo(null);

                // Fermer l'application quand la fenêtre est fermée
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
                // Créer une instance de Puits
                Puits puits = new Puits();

                // Créer une instance de VuePuits avec le puits et une taille de 100
                VuePuits vuePuits = new VuePuits(puits, 20);
                puits.setPieceSuivante(UsineDePiece.genererPiece());
                puits.setPieceSuivante(UsineDePiece.genererPiece());

                // Créer une JFrame avec la vuePuits
                JFrame frame = new JFrame("Puits et taille");
                frame.add(vuePuits);

                // Définir la taille de la fenêtre en fonction de la vuePuits
                frame.pack();

                // Centrer la fenêtre sur l'écran
                frame.setLocationRelativeTo(null);

                // Fermer l'application quand la fenêtre est fermée
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
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