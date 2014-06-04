/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly;

/**
 *
 * @author moulinal
 */
public class CarteArgentSpecial extends Carte{
    private int montant;
   
    public CarteArgentSpecial(int num, Famille typ, Monopoly monop, String desc,int montant) {
        super(num, typ, monop, desc);
        setMontant(montant);
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    @Override
    public void applyEffect(Joueur jou){
        int i=0;
        for(Joueur j : this.getMonopoly().getJoueurs()){
            if(!j.equals(jou)){
                if(j.getCash()-getMontant()>=0){
                    j.setCash(j.getCash()-getMontant());
                }
                else{
                    j.faillite();
                }
            i++;
            }
        }
        jou.setCash(jou.getCash()+(i*getMontant()));
    }
}
