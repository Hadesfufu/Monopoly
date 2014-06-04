package monopoly;

import java.util.Scanner;

public class CarreauMouvement extends CarreauAction {
	private int caseDest;

	public CarreauMouvement(int aNumero, String aNomCase, int aCaseDest, Monopoly m) {
            super(aNumero,aNomCase, m);
            setCaseDest(aCaseDest);
	}

    public int getCaseDest() {
        return caseDest;
    }

    private void setCaseDest(int caseDest) {
        this.caseDest = caseDest;
    }
    
    public void execute(Joueur jou){
    jou.setPositionCourante(super.getMonopoly().getCarreau(caseDest));
    if(this.getNumero() == 31){jou .setToursPrison(4);}
        if(jou.getLiberationPrison()){
            Scanner sc = new Scanner(System.in);
            System.out.printf("Vous possédez une carte Libération de Prison. Voulez-vous l'utiliser ? (y/n)");
            String reponse = sc.nextLine();
                if("y".equals(reponse)){
                    jou.setLiberationPrison(false);
                    jou.setToursPrison(0);
                }
                else if("n".equals(reponse)){
        
                }
                else{
                System.out.printf("Saisie incorrecte");
                }
            
            
        }
    }
    
    
}