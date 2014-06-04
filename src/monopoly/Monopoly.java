package monopoly;


import monopoly.Carreau;
import monopoly.ProprieteAConstruire;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Monopoly {
    	private int nbMaisons = 32;
	private int nbHotels = 12;
	private ArrayList<Carte> cartes = new ArrayList<Carte>();
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private HashMap<Integer,Carreau> carreaux = new HashMap<Integer,Carreau>();
        private Scanner sc = new Scanner(System.in);
        
	public Monopoly(String dataFilename, String dataCartename){
                buildGamePlateau(dataFilename);
                buildCartes(dataCartename);
		inscrireJoueurs();
	}
	
	private void buildGamePlateau(String dataFilename)
	{
            HashMap<CouleurPropriete,Groupe> groups = new HashMap<>();
            groups.put(CouleurPropriete.bleuCiel,new Groupe(CouleurPropriete.bleuCiel,50));
            groups.put(CouleurPropriete.bleuFonce,new Groupe(CouleurPropriete.bleuFonce,200));
            groups.put(CouleurPropriete.jaune,new Groupe(CouleurPropriete.jaune,150));
            groups.put(CouleurPropriete.mauve,new Groupe(CouleurPropriete.mauve,50));
            groups.put(CouleurPropriete.orange,new Groupe(CouleurPropriete.orange,100));
            groups.put(CouleurPropriete.rouge,new Groupe(CouleurPropriete.rouge,150));
            groups.put(CouleurPropriete.vert,new Groupe(CouleurPropriete.vert,200));
            groups.put(CouleurPropriete.violet,new Groupe(CouleurPropriete.violet,100));
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriete :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]); 
                                        carreaux.put((i+1), new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[5]),Integer.parseInt(data.get(i)[6]),Integer.parseInt(data.get(i)[7]),Integer.parseInt(data.get(i)[8]),Integer.parseInt(data.get(i)[9]),Integer.parseInt(data.get(i)[10]),Integer.parseInt(data.get(i)[4]),groups.get(CouleurPropriete.valueOf(data.get(i)[3])), this));
                                        System.out.println(data.get(i)[1]+" "+data.get(i)[2]+" "+data.get(i)[5]+" "+data.get(i)[6]+" "+data.get(i)[7]+" "+data.get(i)[8]+" "+data.get(i)[9]+" "+data.get(i)[10]+" "+data.get(i)[4]+" "+groups.get(CouleurPropriete.valueOf(data.get(i)[3])));
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put((i+1),new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]),this));
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Companie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put((i+1),new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]),this));
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put((i+1),new CarreauTirage(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Famille.valueOf(data.get(i)[2]),this));
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put((i+1),new CarreauArgent(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]),this));
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put((i+1),new CarreauMouvement(Integer.parseInt(data.get(i)[1]),data.get(i)[2],11,this));
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
        
             private void buildCartes(String dataFilename){
            try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
                            	String carteFamille = data.get(i)[0];
				String carteType = data.get(i)[1];
                                if(carteFamille.compareTo("c")==0){
                                    if(carteType.compareTo("LP") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CartePrison(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3]));
                                    }
                                    else if(carteType.compareTo("MR") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteMouvementRelatif(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3],Integer.parseInt(data.get(i)[4])));
                                    }
                                    else if(carteType.compareTo("AR") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteArgentRelatif(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3],Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5])));
                                    }
                                    else if(carteType.compareTo("AA") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteArgentAbsolu(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3],Integer.parseInt(data.get(i)[4])));
                                    }
                                    else if(carteType.compareTo("P") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add (new CarteGoToPrison(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3]));
                                    }
                                    else if(carteType.compareTo("MA") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteMouvementAbsolu(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3],getCarreau(Integer.parseInt(data.get(i)[4]))));
                                    }
                                     
                                    else if(carteType.compareTo("AS") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteArgentSpecial(Integer.parseInt(data.get(i)[2]),Famille.Chance,this,data.get(i)[3],Integer.parseInt(data.get(i)[4])));
                                    }
                                    else
					System.err.println("[buildCartes()] : Invalid CardData type");
			
                                }
                                else if(carteFamille.compareTo("cc")==0){
                                    if(carteType.compareTo("LP") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CartePrison(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3]));
                                    }
                                    else if(carteType.compareTo("MR") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteMouvementRelatif(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3],Integer.parseInt(data.get(i)[4])));
                                    }
                                    else if(carteType.compareTo("AR") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteArgentRelatif(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3],Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5])));
                                    }
                                    else if(carteType.compareTo("AA") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteArgentAbsolu(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3],Integer.parseInt(data.get(i)[4])));
                                    }
                                    else if(carteType.compareTo("P") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add (new CarteGoToPrison(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3]));
                                    }
                                    else if(carteType.compareTo("MA") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteMouvementAbsolu(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3],this.getCarreau(Integer.parseInt(data.get(i)[4]))));
                                    }
                                     
                                    else if(carteType.compareTo("AS") == 0){
					System.out.println("Description :\t" + data.get(i)[3]+"numero :\t" + data.get(i)[2]);
                                        cartes.add(new CarteArgentSpecial(Integer.parseInt(data.get(i)[2]),Famille.Communaute,this,data.get(i)[3],Integer.parseInt(data.get(i)[4])));
                                    }
                                    else
					System.err.println("[buildCartes()] : Invalid CardData type");
                               	
                                }
				
				else
					System.err.println("[buildCartes()] : Invalid CardData type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildCartes()] : CardFile is not found!");
		}
		catch(IOException e){
			System.err.println("[buildCartes()] : Error while reading CardFile!");
		}
        }
       
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
        
             public void inscrireJoueurs() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez le nombre de joueurs :");
            int NbJoueurs = sc.nextInt();
            if(NbJoueurs < 2){NbJoueurs = 2;}
            else if(NbJoueurs > 8){NbJoueurs = 8;}
            sc.nextLine();
            Joueur j;
            for(int i = 0; i < NbJoueurs; i++){
                System.out.println("Entrez le nom du joueur " + (i+1) );
                j = new Joueur(sc.nextLine(), this);
                this.joueurs.add(j);
                System.out.println("Lancé : " + j.lancerDé()[2]);
            }
            
            Collections.sort(this.joueurs, new Comparator<Joueur>(){
                public int compare(Joueur j1, Joueur j2){
                    return j2.getDes()[2] - j1.getDes()[2];
                }
            });
            
	}
             
        private void swap(Integer a, Integer b){
            int c = a;
            a = b;
            b = a;
        }
        
        private void swapJoueurs(Joueur j1, Joueur j2){
        Joueur j = j1;
        j1 = j2;
        j2 = j;
        }

	public void addJoueurs(Joueur jou) {
		this.joueurs.add(jou);
	}

	public Carreau getCarreau(int n) {
            return this.carreaux.get(n);
	}

	public void Jouer() {
            System.out.println("========================== Nouveau Tour ==========================");
            afficherInfos();  
            for(Joueur j : this.joueurs){ 
                int nbdoble=0;
                
                j.avancer();
                System.out.println("Tour de " + j.getNomJoueur() + ":" + 
                        "\nLancé : " + j.getDes()[2] + "(" + j.getDes()[0] + "+" + j.getDes()[1] + ")" +
                        "\nPosition : "+ j.getPositionCourante().getNomCase()+ "(" + j.getPositionCourante().getNumero() + ")" + "\n");
                    j.getPositionCourante().execute(j);
                while(j.getDes()[0]==j.getDes()[1] && nbdoble<3){
                    j.avancer();
                    System.out.println("Tour de " + j.getNomJoueur() + ":" + 
                        "\nLancé : " + j.getDes()[2] + "(" + j.getDes()[0] + "+" + j.getDes()[1] + ")" +
                        "\nPosition : "+ j.getPositionCourante().getNomCase()+ "(" + j.getPositionCourante().getNumero() + ")" + "\n");
                    nbdoble++;
                    j.getPositionCourante().execute(j);
                }
                if(nbdoble==3){
                    j.setPositionCourante(getCarreau(11));
                    j.setToursPrison(4);
                    if(j.getLiberationPrison()){
                        Scanner sc = new Scanner(System.in);
                        System.out.printf("Vous possédez une carte Libération de Prison. Voulez-vous l'utiliser ? (y/n)");
                        String reponse = sc.nextLine();
                    if( "y".equals(reponse)){
                        j.setLiberationPrison(false);
                        j.setToursPrison(0);
                    }
                    else if("n".equals(reponse)){
        
                    }
                    else{
                        System.out.printf("Reponse invalide");
                    }
                    }
                }
                
            }
            System.out.println("=========================== Continuer ? (y/n) ======================= (else = y)");
            if("n".equals(sc.nextLine())){
            this.joueurs.clear();
            }
	}
        
        public void ordreJoueur(){
            int i = 1;
            System.out.println("\nOrdre :");
            for(Joueur j : this.joueurs){
                System.out.println(j.getNomJoueur() + "\n");
                i++;
            }
        }

	public void afficherInfos() {
            int i = 1;
            for(Joueur j : this.joueurs){
               System.out.println("Joueur : " + j.getNomJoueur() +
               "\nCash : " + j.getCash() +
               "\nPosition : " + j.getPositionCourante().getNomCase() + "\n");
                    i++;   
                }                        
            }
	
        
        public void exclusion(Joueur jou){
        System.out.println("le Joueur : "+ jou.getNomJoueur() + " a fait faillite");
        this.joueurs.remove(jou);
        }
        
        public boolean fini(){
        return this.joueurs.size() < 2;
        }
        
        public ArrayList<Carte> getCartesFamille(Famille f){
            ArrayList<Carte> listc = new ArrayList<Carte>();
            for(Carte c : this.cartes){
            if(c.getType() == f){
                listc.add(c);
                }
            }
            return listc;
        }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
        
        
}