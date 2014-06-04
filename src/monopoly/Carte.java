package monopoly;

public abstract class Carte {
	private Famille type;
	private Monopoly monopoly;
        private String description;
        private int numCarte;
        
        public Carte(int num,Famille typ, Monopoly monop,String desc){
            setMonopoly(monop);
            setType(typ);
            setDescription(desc);
            setNumCarte(num);
        }

    public Famille getType() {
        return type;
    }

    public void setType(Famille type) {
        this.type = type;
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(int numCarte) {
        this.numCarte = numCarte;
    }
    
    public void applyEffect(Joueur jou){
        
    }
        
}