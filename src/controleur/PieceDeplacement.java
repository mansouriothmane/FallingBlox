package fr.eseo.e3.poo.projet.blox.controleur;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PieceDeplacement extends KeyAdapter {

    private VuePuits vuePuits;
    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (vuePuits.getPuits().getPieceActuelle() != null) {

        }
    }
}
