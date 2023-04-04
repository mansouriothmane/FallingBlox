package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

    private Puits puits;
    private VuePiece vuePiece;

    public PanneauInformation(Puits puits) {
        this.puits = puits;
        this.puits.addPropertyChangeListener(this);
        setPreferredSize(new Dimension(70, 70));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("MODIFICATION_PIECE_SUIVANTE")) {
            setVuePiece(new VuePiece((Piece)evt.getNewValue(), 15));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (vuePiece != null) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D)g.create();
            vuePiece.afficherPiece(g2D);
            g2D.dispose();
        }
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
        this.repaint();
    }
}
