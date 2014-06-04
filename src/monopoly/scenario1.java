package monopoly;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class scenario1 {

	public static void main(String[] args) {
		// attention : bien pr�ciser tout le chemin d'acc�s au fichier case.data
		Monopoly m = new Monopoly("C:\\Users\\Hades\\Documents\\NetBeansProjects\\Monopoly\\src\\monopoly\\cases.data", "C:\\Users\\Hades\\Documents\\NetBeansProjects\\Monopoly\\src\\monopoly\\cartes.data", true);
                Joueur j1 = m.getJoueurs().get(0);
                Joueur j2 = m.getJoueurs().get(1);
                Joueur j3 = m.getJoueurs().get(2);
                Joueur j4 = m.getJoueurs().get(3);
                ProprieteAConstruire pAC = (ProprieteAConstruire) m.getCarreau(2);
                
                j1.setCash(500);
                j1.setPositionCourante(m.getCarreau(39));
                pAC.setRanking(5);
                j1.addProprietesAConstruire(pAC);
                j1.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(4));
                j1.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(7));
                j1.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(9));
                j1.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(10));
                j1.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(20));
                
                j2.setCash(300);
                j2.setPositionCourante(m.getCarreau(12));
                pAC = (ProprieteAConstruire) m.getCarreau(28);
                pAC.setRanking(2);
                j2.addProprietesAConstruire(pAC);
                j2.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(27));
                j2.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(30));
                
                j3.setCash(800);
                j3.setPositionCourante(m.getCarreau(32));
                j3.addGare((Gare) m.getCarreau(6));
                j3.addGare((Gare) m.getCarreau(16));
                pAC = (ProprieteAConstruire) m.getCarreau(38);
                pAC.setRanking(4);
                j3.addProprietesAConstruire(pAC);
                pAC = (ProprieteAConstruire) m.getCarreau(40);
                pAC.setRanking(4);
                j3.addProprietesAConstruire(pAC);
                
                j4.setCash(1000);
                j4.setPositionCourante(m.getCarreau(21));
                j4.addCompagnie((Compagnie) m.getCarreau(13));
                j4.addCompagnie((Compagnie) m.getCarreau(29));
                j4.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(22));
                j4.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(24));
                j4.addProprietesAConstruire((ProprieteAConstruire) m.getCarreau(25));
                         
                while(!m.fini()){
                m.Jouer();
                }
	}

}
