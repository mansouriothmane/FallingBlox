package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class Gravite implements ActionListener {
    private static final Logger logger = Logger.getLogger(PieceDeplacement.class.getName());
    private Timer timer;
    private int periodicite = 200;
    private final VuePuits vuePuits;
    private final Puits puits;

    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.timer = new Timer(periodicite, this);
        this.timer.start();
    }

    public int getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        puits.gravite();
        vuePuits.repaint();
    }
}
