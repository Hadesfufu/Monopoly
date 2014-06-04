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
public class CarteMouvementAbsolu extends Carte{
    private Carreau caseDest;

    public CarteMouvementAbsolu(int num, Famille typ, Monopoly monop, String desc,Carreau cased) {
        super(num, typ, monop, desc);
        setCaseDest(cased);
    }

    public Carreau getCaseDest() {
        return caseDest;
    }

    public void setCaseDest(Carreau caseDest) {
        this.caseDest = caseDest;
    }
    
    @Override
    public void applyEffect(Joueur jou){
        if(jou.getPositionCourante().getNumero() < getCaseDest().getNumero() && this.getNumCarte() != 21 ){jou.setCash(jou.getCash()+200);}
        jou.setPositionCourante(getCaseDest());
        getCaseDest().execute(jou);
    }
    
}
