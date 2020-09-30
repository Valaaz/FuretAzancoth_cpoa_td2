import java.sql.SQLException;
import java.util.Scanner;

import dao.factory.DAOFactory;
import metier.Categorie;
import metier.Client;
import metier.Produit;
import requetes.RequetesCategorie;
import requetes.RequetesClients;
import requetes.RequetesProduits;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choixTable = 0;
		int choixMenu = 0;
		int choixQuitter = 0;
		
		System.out.println("Debut");	//aide pour se situer dans le programme
		
		do {
			System.out.println("Sur quelle table voulez vous travaillez ?");
			System.out.println("Categorie(1), Client(2), Produit(3)");
			do
			{
				choixTable = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de la table a modifier)
				if(choixTable < 1 || choixTable > 3)		//On s'assure que l'utilisateur rentre un chiffre valide
				{
					System.out.print("Veuillez rentrer un entier entre 1 et 3 : ");
				}
			}while(choixTable < 1  || choixTable > 3);
			
			if(choixTable == 1) {
				//Table categorie
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) une categorie ou obtenir la liste de toutes les categorie existantes(4) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le titre et le visuel :");
						
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titre = sc.nextLine();
						String visuel = sc.nextLine();
						
						Categorie categAjout = new Categorie(titre, visuel);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getCategorieDAO().create(categAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero de la categorie a modifier, le titre et le visuel :");
						
						int idModif = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titreModif = sc.nextLine();
						String visuelModif = sc.nextLine();
						
						Categorie categModif = new Categorie(idModif, titreModif, visuelModif);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getCategorieDAO().update(categModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero de la categorie a supprimer : ");
						
						int idSupp = sc.nextInt();
						
						Categorie categSupp = new Categorie(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getCategorieDAO().delete(categSupp);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 4:
						RequetesCategorie.listeCategorie();
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 2) {
				//Table Client
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) un client ou obtenir la liste de toutes les clients existants(4) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le nom et le prenom :");
						
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String prenom = sc.nextLine();

						Client clientAjout = new Client(nom, prenom);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getClientDAO().create(clientAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero du client a modifier, le nom et le prenom :");
						
						int idModif = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nomModif = sc.nextLine();
						String prenomModif = sc.nextLine();

						Client clientModif = new Client(idModif, nomModif, prenomModif);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getClientDAO().update(clientModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero du client a supprimer : ");
						
						int idSupp = sc.nextInt();
						
						Client clientSupp = new Client(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getClientDAO().delete(clientSupp);

						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 4:
						RequetesClients.listeClient();
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 3) {
				//Table Produit
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) un produit ou obtenir la liste de toutes les produits existants(4) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le nom, la description, le tarif, le visuel et l'id de la categorie :");
						
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String desc = sc.nextLine();
						double tarif = sc.nextDouble();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String visuel = sc.nextLine();
						int idCateg = sc.nextInt();
						
						Produit produitAjout = new Produit(nom, desc, tarif, visuel, idCateg);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getProduitDAO().create(produitAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero du produit a modifier, le nom, la description, le tarif, le visuel et l'id de la categorie :");
						
						int idModif = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nomModif = sc.nextLine();
						String descModif = sc.nextLine();
						double tarifModif = sc.nextDouble();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String visuelModif = sc.nextLine();
						int idCategModif = sc.nextInt();

						Produit produitModif = new Produit(idModif, nomModif, descModif, tarifModif, visuelModif, idCategModif);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getProduitDAO().update(produitModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero du produit a supprimer : ");
						
						int idSupp = sc.nextInt();

						Produit produitSupp = new Produit(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.MYSQL).getProduitDAO().delete(produitSupp);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 4:
						RequetesProduits.listeProduit();
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			
			System.out.print("Voulez vous passer sur une autre table(1) ou quitter(2) ? ");		// 1 : l'utilisateur passe sur une autre table
			do																					// 2 : quitte et met fin au programme
			{
				choixQuitter = sc.nextInt();
				if(choixQuitter < 1 || choixQuitter > 2)
				{
					System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
				}
			}while(choixQuitter < 1  || choixQuitter > 2);
			
		}while(choixQuitter != 2);
		
		System.out.println("Fin");	//Aide pour se situer dans le programme
		
		
		/*
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choixTable = 0;
		int choixMenu = 0;
		int choixQuitter = 0;
		
		System.out.println("Debut");	//aide pour se situer dans le programme
		
		do {
			System.out.println("Sur quelle table voulez vous travaillez ?");
			System.out.println("Categorie(1), Client(2), Produit(3)");
			do
			{
				choixTable = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de la table a modifier)
				if(choixTable < 1 || choixTable > 3)		//On s'assure que l'utilisateur rentre un chiffre valide
				{
					System.out.print("Veuillez rentrer un entier entre 1 et 3 : ");
				}
			}while(choixTable < 1  || choixTable > 3);
			
			if(choixTable == 1) {
				//Table categorie
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) une categorie ou obtenir la liste de toutes les categorie existantes(4) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le numero de la categorie, le titre et le visuel :");
						int id = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titre = sc.nextLine();
						String visuel = sc.nextLine();
						RequetesCategorie.AjouterCategorie(id, titre, visuel);		//Appel de la methode en fonction du cas choisi
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero de la categorie a modifier, le nouveau numero, le titre et le visuel :");
						int idModif = sc.nextInt();
						int nouvId = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titreModif = sc.nextLine();
						String visuelModif = sc.nextLine();
						RequetesCategorie.ModifierCategorie(idModif, nouvId, titreModif, visuelModif);
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero de la categorie a supprimer : ");
						int idSupp = sc.nextInt();
						RequetesCategorie.SupprimerCategorie(idSupp);
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 4:
						RequetesCategorie.listeCategorie();
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 2) {
				//Table Client
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) un client ou obtenir la liste de toutes les clients existants(4) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le numero du client, le nom et le prenom :");
						int id = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String prenom = sc.nextLine();
						RequetesClients.AjouterClient(id, nom, prenom);		//Appel de la methode en fonction du cas choisi
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero du client a modifier, le nouveau numero, le nom et le prenom :");
						int idModif = sc.nextInt();
						int nouvId = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nomModif = sc.nextLine();
						String prenomModif = sc.nextLine();
						RequetesClients.ModifierClient(idModif, nouvId, nomModif, prenomModif);
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero du client a supprimer : ");
						int idSupp = sc.nextInt();
						RequetesClients.SupprimerClient(idSupp);
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 4:
						RequetesClients.listeClient();
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 3) {
				//Table Produit
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) un produit ou obtenir la liste de toutes les produits existants(4) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le numero du produit, le nom, la description, le tarif, le visuel et l'id de la categorie :");
						int id = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String desc = sc.nextLine();
						double tarif = sc.nextDouble();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String visuel = sc.nextLine();
						int idCateg = sc.nextInt();
						RequetesProduits.AjouterProduit(id, nom, desc, tarif, visuel, idCateg);		//Appel de la methode en fonction du cas choisi
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero du produit a modifier, le nouveau numero, le nom, la description, le tarif, le visuel et l'id de la categorie :");
						int idModif = sc.nextInt();
						int nouvId = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nomModif = sc.nextLine();
						String descModif = sc.nextLine();
						double tarifModif = sc.nextDouble();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String visuelModif = sc.nextLine();
						int idCategModif = sc.nextInt();
						RequetesProduits.ModifierProduit(idModif, nouvId, nomModif, descModif, tarifModif, visuelModif, idCategModif);
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero du produit a supprimer : ");
						int idSupp = sc.nextInt();
						RequetesProduits.SupprimerProduit(idSupp);
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 4:
						RequetesProduits.listeProduit();
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			
			System.out.print("Voulez vous passer sur une autre table(1) ou quitter(2) ? ");		// 1 : l'utilisateur passe sur une autre table
			do																					// 2 : quitte et met fin au programme
			{
				choixQuitter = sc.nextInt();
				if(choixQuitter < 1 || choixQuitter > 2)
				{
					System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
				}
			}while(choixQuitter < 1  || choixQuitter > 2);
			
		}while(choixQuitter != 2);
		
		System.out.println("Fin");	//Aide pour se situer dans le programme
		
	*/
	}
	
}


