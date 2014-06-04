/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly;

import java.util.ArrayList;

/**
 *
 * @author moulinal
 */
public class CarteArgentRelatif extends Carte{
    private int montantMaison;
    private int montantHotel;
    
    public CarteArgentRelatif(int num, Famille typ, Monopoly monop, String desc,int montant1,int montant2) {
        super(num, typ, monop, desc);
        setMontantMaison(montant1);
        setMontantHotel(montant2);
    }

    public int getMontantMaison() {
        return montantMaison;
    }

    public void setMontantMaison(int montantMaison) {
        this.montantMaison = montantMaison;
    }
    
    public int getMontantHotel() {
        return montantHotel;
    }

    public void setMontantHotel(int montantHotel) {
        this.montantHotel = montantHotel;
    }
    
    @Override
    public void applyEffect(Joueur jou){
            ArrayList<ProprieteAConstruire> props = new ArrayList<ProprieteAConstruire>();
            props= jou.getProprietesAConstruire();
            for(ProprieteAConstruire p : props){
              if(p.getRanking()==5){
                 if(jou.getCash()-getMontantHotel()>=0){
                   jou.setCash(jou.getCash()-getMontantHotel());
                 }
                 else{
                   jou.faillite();
                 }
              }
            else{
                if(jou.getCash()-getMontantMaison()*p.getRanking()>=0){
                   jou.setCash(jou.getCash()-getMontantMaison()*p.getRanking());
                }
                else{
                jou.faillite();
                }
            }
        }
        
    }
    
}
