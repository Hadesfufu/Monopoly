/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly;

import java.util.Scanner;

/**
 *
 * @author moulinal
 */
public class CarteGoToPrison extends Carte{
    public CarteGoToPrison(int num, Famille typ, Monopoly monop, String desc) {
        super(num, typ, monop, desc);
    }
    
    @Override
    public void applyEffect(Joueur jou){
        jou.setPositionCourante(super.getMonopoly().getCarreau(11));
        jou.setToursPrison(4);
        if(jou.getLiberationPrison()){
            Scanner sc = new Scanner(System.in);
            System.out.printf("Vous possédez une carte Libération de Prison. Voulez-vous l'utiliser ? (y/n)");
            String reponse = sc.nextLine();
                if(reponse == "y"){
                    jou.setLiberationPrison(false);
                    jou.setToursPrison(0);
                }
                else if(reponse == "n"){
        
                }
                else{
                System.out.printf("Reponse invalide");
                }
    }
}
}
