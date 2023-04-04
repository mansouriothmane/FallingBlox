package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.*;

public class FallingBloxVersion1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Falling Blox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        Puits puits = new Puits();
        puits.setPieceSuivante(UsineDePiece.genererPiece());

        VuePuits vuePuits = new VuePuits(puits);
        frame.add(vuePuits, BorderLayout.CENTER);

        PanneauInformation panneauInformation = new PanneauInformation(puits);
        frame.add(panneauInformation, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
