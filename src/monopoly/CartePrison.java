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
public class CartePrison extends Carte{
    public Joueur proprio;

    public CartePrison(int num, Famille typ, Monopoly monop, String desc) {
        super(num, typ, monop, desc);
    }

    public Joueur getProprio() {
        return proprio;
    }

    public void setProprio(Joueur proprio) {
        this.proprio = proprio;
    }
    
    
    @Override
    public void applyEffect(Joueur jou){
        jou.setLiberationPrison(true);
    }
    
}
