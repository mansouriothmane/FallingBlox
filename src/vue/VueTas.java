package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

import java.awt.*;

public class VueTas {
    private final Tas tas;
    private static double MULTIPLIER_NUANCE = 0.5;
    private VuePuits vuePuits;

    public VueTas(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.tas = vuePuits.getPuits().getTas();
    }

    public Color nuance(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();
        int rr = (int)(r  * (1 - MULTIPLIER_NUANCE));
        int gg = (int)(g * (1 - MULTIPLIER_NUANCE));
        int bb = (int)(b * (1 - MULTIPLIER_NUANCE));
        return new Color(rr, gg, bb);
    }

    public void afficher(Graphics2D g2D) {
        for (int i = 0; i < tas.getElements()[0].length; i++) {
            for (int j = 0; j < tas.getElements().length; j++) {
                if (tas.getElements()[i][j] != null) {
                    g2D.setColor(nuance(tas.getElements()[i][j].getCouleur().getCouleurPourAffichage()));
                    g2D.fill3DRect(tas.getElements()[i][j].getCoordonnees().getAbscisse() * vuePuits.getTaille(),
                            tas.getElements()[i][j].getCoordonnees().getOrdonnee() * vuePuits.getTaille(),
                            vuePuits.getTaille(), vuePuits.getTaille(), true);
                }
            }
        }
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }
}
