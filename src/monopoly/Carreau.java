package monopoly;

public abstract class Carreau {
	private int numero;
	private String nomCase;
        private Monopoly monopoly;

	public Carreau(int aNumero, String aNomCase, Monopoly m) {
		setNumero(aNumero);
                setNomCase(aNomCase);
                monopoly = m;
	}

    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomCase() {
        return nomCase;
    }

    private void setNomCase(String nomCase) {
        this.nomCase = nomCase;
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }
    
    public void execute(Joueur jou) {
        
    }
        
        
}