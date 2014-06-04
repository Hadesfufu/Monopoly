package monopoly;


public class Main {

	public static void main(String[] args) {
		// attention : bien pr�ciser tout le chemin d'acc�s au fichier case.data
		Monopoly m = new Monopoly("C:\\Users\\Hades\\Documents\\NetBeansProjects\\Monopoly\\src\\monopoly\\cases.data", "C:\\Users\\Hades\\Documents\\NetBeansProjects\\Monopoly\\src\\monopoly\\cartes.data", false);
                while(!m.fini()){
                m.Jouer();
                }
	}

}
