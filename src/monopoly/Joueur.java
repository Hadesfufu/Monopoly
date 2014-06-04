package monopoly;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private Monopoly monopoly;
	private ArrayList<Compagnie> compagnies = new ArrayList<Compagnie>();
	private ArrayList<Gare> gares = new ArrayList<Gare>();
	private Carreau positionCourante;
	private ArrayList<ProprieteAConstruire> proprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        private int toursPrison =0;
        private boolean liberationPrison;
        private int[] des;
        
    public Joueur(String nomJoueur, Monopoly mono) {
		this.monopoly = mono;
                this.nomJoueur = nomJoueur;
                this.positionCourante = this.monopoly.getCarreau(1);
                this.des=new int[3];
	}
    public int[] lancerDé(){
            int[] buff = new int[3];
            buff[0] = (int)(Math.random() * 5)+1 ;
            buff[1] = (int)(Math.random() * 5)+1 ;
            buff[2] = buff[0] + buff[1];
            setDes(buff);
            return buff;
       } 
    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }
    public ArrayList<ProprieteAConstruire> getProprietesAConstruire() {
        return proprietesAConstruire;
    }
    

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        System.out.print( this.nomJoueur + " Cash : " + this.cash );
        this.cash = cash;
        System.out.println("-->" + this.cash + "\n");
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }

    public Carreau getPositionCourante() {
        return positionCourante;
    }

    public void setPositionCourante(Carreau positionCourante) {
        this.positionCourante = positionCourante;
    }

    public int getToursPrison() {
        return toursPrison;
    }

    public void setToursPrison(int toursPrison) {
        this.toursPrison = toursPrison;
    }
        
    private boolean isEnPrison(){
        if(getToursPrison()>0){
            setToursPrison(getToursPrison()-1);
             if(getToursPrison()==0){
                this.setCash(this.getCash()-50);
            }
            if(getDes()[0]==getDes()[1]){
                setToursPrison(0);
                return false;
            }
        System.out.println("nombre de tours en prison restants : " + (getToursPrison()));
        return true;
        }
        return false;
    }

    public void addProprietesAConstruire(ProprieteAConstruire p) {
        this.proprietesAConstruire.add(p);
    }
    public void addGare(Gare g){
        this.gares.add(g);
    }
    public void addCompagnie(Compagnie c){
        this.compagnies.add(c);
    }
        
    public void faillite(){
        for(Compagnie c : this.compagnies){
        c.setProprietaire(null);
        }
        for(Gare g : this.gares){
        g.setProprietaire(null);
        }
        for(ProprieteAConstruire p : this.proprietesAConstruire){
        p.setProprietaire(null);
        }
        this.getMonopoly().exclusion(this);
    }
    
    public boolean possede(Groupe g){
        boolean possession = true;
        boolean proprieteposseder = false;
        for(ProprieteAConstruire pg : g.getProprietes()){
            proprieteposseder = false;
            for(ProprieteAConstruire pj : this.proprietesAConstruire){
                if(pg.equals(pj)){ proprieteposseder = true;}
            }
            if(possession == false || proprieteposseder == false){
                possession = false;
            }
        }
        return possession;
    }
    
    public int getNbGare(){
    return this.gares.size();
    } 
    public int getNbCompagnies(){
    return this.compagnies.size();
    } 

    public int[] getDes() {
        return des;
    }

    public void setDes(int[] des) {
        this.des = des;
    }
    
    public boolean isLiberationPrison() {
        return liberationPrison;
    }

    public void setLiberationPrison(boolean liberationPrison) {
        this.liberationPrison = liberationPrison;
    }
    
    public boolean getLiberationPrison(){
        return liberationPrison;
    }
    
    public void avancer(){
                des = this.lancerDé();
                if(!isEnPrison()){
                move();
                }
    }
    
    private void move(){
         Carreau np = getMonopoly().getCarreau(((this.getPositionCourante().getNumero() + des[2])%40)+1);
         if(np.getNumero() - this.getPositionCourante().getNumero() < 0){this.setCash(this.getCash()+200);}
         this.setPositionCourante(np);
    }
}
