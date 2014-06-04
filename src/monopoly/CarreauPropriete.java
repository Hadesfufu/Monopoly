package monopoly;


import monopoly.Carreau;

public abstract class CarreauPropriete extends Carreau {
	private int loyerBase;
	private int prixAchat;
	private Joueur proprietaire;

    public CarreauPropriete(int aNumero, String aNomCase, int aLoyerBase, int aPrixPropriete, Monopoly m) {
        super(aNumero, aNomCase, m);
        setLoyerBase(aLoyerBase);
        setPrixAchat(aPrixPropriete);
    }

    public int getLoyerBase() {
        return loyerBase;
    }

    private void setLoyerBase(int loyerBase) {
        this.loyerBase = loyerBase;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    private void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    @Override
    public void execute(Joueur jou) {
        
    }
    
}