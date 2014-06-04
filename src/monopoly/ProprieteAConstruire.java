package monopoly;

import java.util.Scanner;

public class ProprieteAConstruire extends CarreauPropriete {
	private int ranking = 0;
	private Groupe groupePropriete;
        private int[] prix;

	public ProprieteAConstruire(int aNumero, String aNomCase, int aLoyerBase,int maison1,int maison2,int maison3,int maison4,int hotel, int aPrixAchat, Groupe aGroupe ,  Monopoly m) {
        super(aNumero,aNomCase,aLoyerBase,aPrixAchat, m);
        prix=new int[6];
            
        setMaison1(maison1);
        setMaison2(maison2);
        setMaison3(maison3);
        setMaison4(maison4);
        setHotel(hotel);
        setGroupePropriete(aGroupe);
        groupePropriete.addPropriete(this);        
	}

    public int getLoyerAPayer(){
        if(getRanking() == 0){
            return super.getLoyerBase();
        }
        else{
            return prix[getRanking()];
        }
    }
    
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

        
    public Groupe getGroupePropriete() {
        return groupePropriete;
    }

    public void setGroupePropriete(Groupe groupePropriete) {
        this.groupePropriete = groupePropriete;
    }

    public int getMaison1() {
        return prix[1];
    }

    private void setMaison1(int maison1) {
        this.prix[1] = maison1;
    }

    public int getMaison2() {
        return prix[2];
    }

    private void setMaison2(int maison2) {
        this.prix[2] = maison2;
    }

    public int getMaison3() {
        return prix[3];
    }

    private void setMaison3(int maison3) {
        this.prix[3] = maison3;
    }

    public int getMaison4() {
        return prix[4];
    }

    private void setMaison4(int maison4) {
        this.prix[4] = maison4;
    }

    public int getHotel() {
        return prix[5];
    }

    private void setHotel(int hotel) {
        this.prix[5] = hotel;
    }
    
    @Override
    public void execute(Joueur jou){
            Joueur proprio = this.getProprietaire();
            if(proprio == null){
                propositionAchat(jou);
                }
            else if(proprio == jou && getRanking() < 5 && jou.possede(this.groupePropriete)){
                propositionAmelioration(jou);
            }
            else if(proprio != jou)
            {
                if(getLoyerAPayer() <= jou.getCash()){
                    jou.setCash(jou.getCash() - getLoyerAPayer());
                    proprio.setCash(proprio.getCash() + getLoyerAPayer());
                }
                else{
                    proprio.setCash(proprio.getCash() + jou.getCash());
                    jou.faillite();}
            }
            else{return;}
    }
    
    private void propositionAmelioration(Joueur jou){
                Scanner sc = new Scanner(System.in);
            if(getGroupePropriete().getPrixAchatMaison() <= jou.getCash()){
                System.out.println("Voulez-vous ameliorer cette propriété : y/n. Cela vous coutera : "  + getGroupePropriete().getPrixAchatMaison() + "(toute autre réponses sont considerer comme 'n')");
                String Answer = sc.nextLine();
                if("y".equals(Answer)){
                    setRanking(getRanking()+1);
                    jou.setCash(jou.getCash() - getGroupePropriete().getPrixAchatMaison());
                }
                else{
                    System.out.println("Vous n'ameliorer pas !");
                }
            }
            else{
                System.out.println("Vous ne pouvez pas acheter cette propriété, trop cher !");
                }
        }
        
        private void propositionAchat( Joueur jou){
                Scanner sc = new Scanner(System.in);
                if(this.getPrixAchat() <= jou.getCash()){
                    System.out.println("Voulez-vous acheter cette propriété : y/n Cela vous coutera : "  + getPrixAchat() + "(toute autre réponses sont considerer comme 'n')");
                    String Answer = sc.nextLine();
                    if("y".equals(Answer)){
                        jou.addProprietesAConstruire(this);
                        jou.setCash(jou.getCash() - getPrixAchat());
                        this.setProprietaire(jou);
                        System.out.println("Achat effectué !\n");
                    }
                    else {
                        System.out.println("Vous n'achetez pas !\n");
                    }
                }
                else{
                     System.out.println("Vous ne pouvez pas acheter ce terrain, trop cher !\n");
                }
        }
        
        
}