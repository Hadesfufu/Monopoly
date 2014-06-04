package monopoly;


import java.util.ArrayList;
import java.util.Scanner;
import monopoly.CarreauAction;
import monopoly.Famille;

public class CarreauTirage extends CarreauAction {
	private Famille familleCase;

	public CarreauTirage(int aNumero, String aNomCase, Famille aFamilleCase, Monopoly m) {
            super(aNumero,aNomCase, m);
            setFamilleCase(aFamilleCase);
	}

    public Famille getFamilleCase() {
        return familleCase;
    }

    private void setFamilleCase(Famille familleCase) {
        this.familleCase = familleCase;
    }
    
    private Carte TirerCarte(){
        ArrayList<Carte> listc = this.getMonopoly().getCartesFamille(familleCase);
        int i;
        if(getMonopoly().isDetermine()){
        System.out.println("N° Carte:");
        i = getMonopoly().getSc().nextInt();
        }
        else{i = (int) (Math.random()*(listc.size()-1));}
        System.out.println("Une Carte est Tirée ! C'est une carte :" + listc.get(i).getType().name() + "Effet :" + listc.get(i).getDescription());
        return listc.get(i);
    }
    
    
    @Override
    public void execute(Joueur jou) {
        TirerCarte().applyEffect(jou);
    }
}