package fr.eseo.e3.poo.projet.blox.controleur;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public class PieceDeplacement extends KeyAdapter {
    private static final Logger logger = Logger.getLogger(PieceDeplacement.class.getName());
    private VuePuits vuePuits;
    private Puits puits;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //TODO use getPieceActuelle
        Piece piece = puits.getPieceSuivante();
        if (piece == null) return;
        int keyCode = e.getKeyCode();
        try {
            switch (keyCode) {
                case KeyEvent.VK_LEFT -> {
                    if (e.isControlDown()) piece.tourner(true);
                    else piece.deplacerDe(-1, 0);
                }
                case KeyEvent.VK_RIGHT -> {
                    if (e.isControlDown()) piece.tourner(false);
                    else piece.deplacerDe(1, 0);
                }
                case KeyEvent.VK_UP -> {
                    piece.deplacerDe(0, -1);
                }
                case KeyEvent.VK_DOWN -> {
                    piece.deplacerDe(0, 1);
                }
            }
        }
        catch (BloxException ignored) {}
        // Repaint the VuePuits component
        vuePuits.repaint();
    }
}