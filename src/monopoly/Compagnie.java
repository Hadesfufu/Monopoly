package monopoly;


import java.util.Scanner;
import monopoly.CarreauPropriete;

public class Compagnie extends CarreauPropriete {

	public Compagnie(int aNumero, String aNomCase, int aPrixAchat, Monopoly m) {
            super(aNumero,aNomCase,4,aPrixAchat, m);
        }
        
        public void execute(Joueur jou){  
           Joueur proprio = this.getProprietaire();
           if(proprio == null){
           Scanner sc = new Scanner(System.in);
                if(this.getLoyerBase() <= jou.getCash()){
                    System.out.println("Voulez-vous acheter cette compagnie : y/n Cela vous coutera : "  + getPrixAchat() + "(toute autre réponses sont considerer comme 'n')");
                    String Answer = sc.nextLine();
                    if("y".equals(Answer)){
                        jou.addCompagnie(this);
                        jou.setCash(jou.getCash() - getPrixAchat());
                        this.setProprietaire(jou);
                        System.out.println("Achat effectué !\n");
                    }
                    else {
                        System.out.println("Vous n'achetez pas !");
                    }
                }
                else{
                     System.out.println("Vous ne pouvez pas acheter ce terrain, trop cher !");
                }
           }
           else if(jou.equals(proprio)){return;}
           else{
               int nbComp= proprio.getNbCompagnies();
               int aDebiter=0;
               if(nbComp==1){
               int [] buff = jou.getDes();
               for(int i=0;i<buff.length;i++){
                   aDebiter = aDebiter+buff[i];
               }
               aDebiter=aDebiter*4;
               }
           
           if(nbComp==2){
               int [] buff = jou.getDes();
               for(int i=0;i<buff.length;i++){
                   aDebiter = aDebiter+buff[i];
               }
               aDebiter=aDebiter*10;
           }
           jou.setCash(jou.getCash()-aDebiter);
           }
       }
           
           
}