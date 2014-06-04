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
public class CarteMouvementRelatif extends Carte{
    private int nbCases;

    public CarteMouvementRelatif(int num, Famille typ, Monopoly monop, String desc,int nbc) {
        super(num, typ, monop, desc);
        setNbCases(nbc);
    }

    public int getNbCases() {
        return nbCases;
    }

    public void setNbCases(int nbCases) {
        this.nbCases = nbCases;
    }
    
    
    
    @Override
    public void applyEffect(Joueur jou){
        int i = jou.getPositionCourante().getNumero()+getNbCases();
        jou.setPositionCourante(super.getMonopoly().getCarreau(i));
        super.getMonopoly().getCarreau(i).execute(jou);
    }
}
