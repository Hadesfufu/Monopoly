package monopoly;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moulinal
 */
public class CarteArgentAbsolu extends Carte{

    private int montant;
    
    public CarteArgentAbsolu(int num, Famille typ, Monopoly monop, String desc,int montant) {
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
        if(jou.getCash()+montant>=0){
            jou.setCash(jou.getCash()+montant);
        }
        else{
            jou.faillite();
        }
    }
    
    
}
