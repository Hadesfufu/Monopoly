package monopoly;

import monopoly.CarreauAction;

public class CarreauArgent extends CarreauAction {
	private int montant;

	public CarreauArgent(int aNumero, String aNomCase, int aMontant, Monopoly m) {
            super(aNumero,aNomCase,m);
            setMontant(aMontant);
	}

    public int getMontant() {
        return montant;
    }

    private void setMontant(int montant) {
        this.montant = montant;
    }
    
        @Override
    public void execute(Joueur jou) {
        jou.setCash(jou.getCash()+montant);
        if(jou.getCash() < 0){jou.faillite();}
    }
}