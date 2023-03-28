package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

public class VuePuits extends JPanel {
    public static final int TAILLE_PAR_DEFAUT = 20;
    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    public VuePuits(Puits puits) {
        this.puits = puits;
        this.taille = TAILLE_PAR_DEFAUT;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
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

    public void setVuePiece(VuePiece vuePiece) {
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
        vuePiece.afficherPiece(g2D);
        g2D.dispose();
    }
}
