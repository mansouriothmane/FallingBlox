package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Instant;

public class VuePuits extends JPanel implements PropertyChangeListener {
    public static final int TAILLE_PAR_DEFAUT = 20;
    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    public VuePuits(Puits puits) {
        this.puits = puits;
        this.taille = TAILLE_PAR_DEFAUT;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        puits.addPropertyChangeListener(this);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        puits.addPropertyChangeListener(this);
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g.create();
        g2D.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < getWidth(); x += taille) {
            for (int y = 0; y < getHeight(); y += taille) {
                g2D.drawRect(x, y, taille, taille);
            }
        }
        if (vuePiece != null) vuePiece.afficherPiece(g2D);
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            System.out.println("MODIFICATION_PIECE_ACTUELLE " + Instant.now());
            setVuePiece(new VuePiece((Piece) event.getNewValue()));
        }
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            System.out.println("MODIFICATION_PIECE_SUIVANTE " + Instant.now());
            setVuePiece(new VuePiece((Piece) event.getNewValue()));
        }
    }
}