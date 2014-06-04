package monopoly;


import java.util.Scanner;
import monopoly.CarreauPropriete;

public class Gare extends CarreauPropriete {

       
    public Gare(int aNumero, String aNomCase, int aPrixAchat,  Monopoly m) {
		super(aNumero,aNomCase,25,aPrixAchat, m);
       }
       @Override
       public void execute(Joueur jou) {
           Joueur proprio = this.getProprietaire();
           if(proprio == null){
           Scanner sc = new Scanner(System.in);
                if(this.getLoyerBase() <= jou.getCash()){
                    System.out.println("Voulez-vous acheter cette gare : y/n Cela vous coutera : "  + getPrixAchat() + "(toute autre réponses sont considerer comme 'n')");
                    String Answer = sc.nextLine();
                    if("y".equals(Answer)){
                        jou.addGare(this);
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
           int aDebiter = getLoyerBase() * proprio.getNbGare();
           jou.setCash(jou.getCash() - aDebiter);
           proprio.setCash(proprio.getCash() + aDebiter);
           }
       }
}