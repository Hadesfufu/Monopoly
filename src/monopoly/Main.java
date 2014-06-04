package monopoly;


public class Main {

	public static void main(String[] args) {
		// attention : bien pr�ciser tout le chemin d'acc�s au fichier case.data
		Monopoly m = new Monopoly("/users/info/etu-s2/massonyo/Monopoly/Monopoly-master/src/monopoly/cases.data", "//users/info/etu-s2/massonyo/Monopoly/Monopoly-master/src/monopoly/cartes.data");
                while(!m.fini()){
                m.Jouer();
                }
	}

}
