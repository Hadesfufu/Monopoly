package monopoly;

import java.util.ArrayList;

public class Groupe {
	private CouleurPropriete couleur;
	private int prixAchatMaison;
	private ArrayList<ProprieteAConstruire> proprietes = new ArrayList<ProprieteAConstruire>();
        
        public Groupe(CouleurPropriete aCouleur, int aPrixAchatMaison) {
            setCouleur(aCouleur);
            setPrixAchatMaison(aPrixAchatMaison);
	}

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }

    public int getPrixAchatMaison() {
        return prixAchatMaison;
    }

    public void setPrixAchatMaison(int prixAchatMaison) {
        this.prixAchatMaison = prixAchatMaison;
    }

    public ArrayList<ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<ProprieteAConstruire> proprietes) {
        this.proprietes = proprietes;
    }
        
        
}