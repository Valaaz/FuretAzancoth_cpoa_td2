import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.factory.DAOFactory;
import metier.Categorie;
import metier.Client;
import metier.Commande;
import metier.LigneCommande;
import metier.Produit;

///!\ FICHIER TEMPORAIRE

public class MenuListeMemoire {
	
	public static void menuListeMemoire() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choixTable = 0;
		int choixMenu = 0;
		int choixQuitter = 0;
		
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Debut");	//aide pour se situer dans le programme
		
		do {
			System.out.println("Sur quelle table voulez vous travaillez ?");
			System.out.println("Categorie(1), Client(2), Produit(3), Commande(4), LigneCommande(5)");
			do
			{
				choixTable = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de la table a modifier)
				if(choixTable < 1 || choixTable > 5)		//On s'assure que l'utilisateur rentre un chiffre valide
				{
					System.out.print("Veuillez rentrer un entier entre 1 et 5 : ");
				}
			}while(choixTable < 1 || choixTable > 5);
			
			if(choixTable == 1) {
				//Table categorie
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3), Voir(4) une categorie ou obtenir la liste de toutes les categorie existantes(5) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le titre et le visuel :");
						
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titre = sc.nextLine();
						String visuel = sc.nextLine();
						
						Categorie categAjout = new Categorie(titre, visuel);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCategorieDAO().create(categAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero de la categorie a modifier, le titre et le visuel :");
						
						int idModif = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titreModif = sc.nextLine();
						String visuelModif = sc.nextLine();
						
						Categorie categModif = new Categorie(idModif, titreModif, visuelModif);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCategorieDAO().update(categModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero de la categorie a supprimer : ");
						
						int idSupp = sc.nextInt();
						
						Categorie categSupp = new Categorie(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCategorieDAO().delete(categSupp);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 4:
						System.out.print("Rentrez l'id de la categorie que vous voulez voir : ");
						
						int idCateg = sc.nextInt();
						
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCategorieDAO().getById(idCateg));
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 5:
						System.out.println("Affichage de toutes les categories :");
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCategorieDAO().findAll());
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
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
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3), Voir(4) un client ou obtenir la liste de toutes les clients existants(5) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le nom et le prenom :");
						
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String prenom = sc.nextLine();

						Client clientAjout = new Client(nom, prenom);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getClientDAO().create(clientAjout);
						
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
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getClientDAO().update(clientModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero du client a supprimer : ");
						
						int idSupp = sc.nextInt();
						
						Client clientSupp = new Client(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getClientDAO().delete(clientSupp);

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
						System.out.print("Rentrez l'id du client que vous voulez voir : ");
						
						int idClient = sc.nextInt();
						
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getClientDAO().getById(idClient));
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 5:
						System.out.println("Affichage de tous les clients :");
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getClientDAO().findAll());
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
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
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3), Voir(4) un produit ou obtenir la liste de toutes les produits existants(5) ? (Entrez le numero correspondant a votre choix)");
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
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getProduitDAO().create(produitAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
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
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getProduitDAO().update(produitModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero du produit a supprimer : ");
						
						int idSupp = sc.nextInt();

						Produit produitSupp = new Produit(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getProduitDAO().delete(produitSupp);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 4:
						System.out.print("Rentrez l'id du produit que vous voulez voir : ");
						
						int idProduit = sc.nextInt();
						
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getProduitDAO().getById(idProduit));
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 5:
						System.out.println("Affichage de tous les produits :");
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getProduitDAO().findAll());
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 4) {
				//Table commande
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3), Voir(4) une commande ou obtenir la liste de toutes les commandes existantes(5) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement la date de commande et l'id du client :");
						
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String stringCommandeAjout = sc.nextLine();
						LocalDate dateCommandeAjout = LocalDate.parse(stringCommandeAjout, formatage);
						int idClientAjout = sc.nextInt();
						
						Commande commandeAjout = new Commande(dateCommandeAjout, idClientAjout, null);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCommandeDAO().create(commandeAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numero de la commande a modifier, la date de commande et le l'id du client :");
						
						int idModif = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String stringCommandeModif = sc.nextLine();
						LocalDate dateCommandeModif = LocalDate.parse(stringCommandeModif, formatage);
						int idClientModif = sc.nextInt();
						
						Commande commandeModif = new Commande(idModif, dateCommandeModif, idClientModif, null);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCommandeDAO().update(commandeModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero de la commande a supprimer : ");
						
						int idSupp = sc.nextInt();
						
						Commande commandeSupp = new Commande(idSupp);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCommandeDAO().delete(commandeSupp);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 4:
						System.out.print("Rentrez l'id de la commande que vous voulez voir : ");
						
						int idCommande = sc.nextInt();
						
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCommandeDAO().getById(idCommande));
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 5:
						System.out.println("Affichage de toutes les commandes :");
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getCommandeDAO().findAll());
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					default:
						System.out.print("Veuillez entrer un numero valide : ");
					}	
				}while(choixMenu != 2);
			}
			else if(choixTable == 5) {
				//Table ligne de commande
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3), Voir(4) une ligne de commande ou obtenir la liste de toutes les lignes de commandes existantes(5) ? (Entrez le numero correspondant a votre choix)");
					int choix = sc.nextInt(); 	//Recuperation du choix de l'utilisateur (choix de quel methode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement l'id de la commande, l'id du produit, la quantite et le tarif unitaire :");
						
						int idCommandeAjout = sc.nextInt();
						int idProduitAjout = sc.nextInt();
						int quantiteAjout = sc.nextInt();
						double idClientAjout = sc.nextDouble();
						
						LigneCommande ligneCommandeAjout = new LigneCommande(idCommandeAjout, idProduitAjout, quantiteAjout, idClientAjout);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getLigneCommandeDAO().create(ligneCommandeAjout);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Recuperation du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement l'id de la commande et l'id du produit a modifier, la quantite et le tarif unitaire :");
						
						int idCommandeModif = sc.nextInt();
						int idProduitModif = sc.nextInt();
						int quantiteModif = sc.nextInt();
						double idClientModif = sc.nextDouble();
						
						LigneCommande ligneCommandeModif = new LigneCommande(idCommandeModif, idProduitModif, quantiteModif, idClientModif);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getLigneCommandeDAO().update(ligneCommandeModif);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 3:
						System.out.print("Rentrez le numero de la commande et le numero du produit a supprimer : ");
						
						int idCommandeSupp = sc.nextInt();
						int idProduitSupp = sc.nextInt();
						
						LigneCommande ligneCommandeSupp = new LigneCommande(idCommandeSupp, idProduitSupp);
						DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getLigneCommandeDAO().delete(ligneCommandeSupp);
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
						
					case 4:
						System.out.print("Rentrez l'id de la ligne de commande et l'id du produit que vous voulez voir : ");
						
						int idCommande = sc.nextInt();
						int idProduit = sc.nextInt();
						
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getLigneCommandeDAO().getById(idCommande, idProduit));
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
						break;
					
					case 5:
						System.out.println("Affichage de toutes les lignes de commande");
						System.out.println(DAOFactory.getDAOFactory(dao.Persistance.ListeMemoire).getLigneCommandeDAO().findAll());
						
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");
						
						do
						{
							choixMenu = sc.nextInt();
							if(choixMenu < 1 || choixMenu > 2)
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1 || choixMenu > 2);
						
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
			}while(choixQuitter < 1 || choixQuitter > 2);
			
		}while(choixQuitter != 2);
		
		System.out.println("Fin");	//Aide pour se situer dans le programme
	}

}
