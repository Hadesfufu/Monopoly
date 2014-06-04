package monopoly;


import monopoly.Carreau;

public abstract class CarreauAction extends Carreau {

    public CarreauAction(int aNumero, String aNomCase, Monopoly m) {
        super(aNumero, aNomCase, m);
    }
    @Override
    public void execute(Joueur jou) {
        
    }
}