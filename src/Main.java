import java.sql.*;
import java.util.Scanner;

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
				choixTable = sc.nextInt();		//Récupération du choix de l'utilisateur (choix de la table à modifier)
				if(choixTable < 1 || choixTable > 3)		//On s'assure que l'utilisateur rentre un chiffre valide
				{
					System.out.print("Veuillez rentrer un entier entre 1 et 3 : ");
				}
			}while(choixTable < 1  || choixTable > 3);
			
			if(choixTable == 1) {
				//Table Catégorie
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) une catégorie ou obtenir la liste de toutes les catégorie existantes(4) ? (Entrez le numéro correspondant à votre choix)");
					int choix = sc.nextInt(); 	//Récupération du choix de l'utilisateur (choix de quel méthode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le numéro de la catégorie, le titre et le visuel :");
						int id = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titre = sc.nextLine();
						String visuel = sc.nextLine();
						Connexion.AjouterCategorie(id, titre, visuel);		//Appel de la méthode en fonction du cas choisi
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Récupération du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numéro de la catégorie à modifier, le nouveau numéro, le titre et le visuel :");
						int idModif = sc.nextInt();
						int nouvId = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String titreModif = sc.nextLine();
						String visuelModif = sc.nextLine();
						Connexion.ModifierCategorie(idModif, nouvId, titreModif, visuelModif);
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
						System.out.print("Rentrez le numéro de la catégorie à supprimer : ");
						int idSupp = sc.nextInt();
						Connexion.SupprimerCategorie(idSupp);
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
						Connexion.listeCategorie();
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
						System.out.print("Veuillez entrer un numéro valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 2) {
				//Table Client
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) un client ou obtenir la liste de toutes les clients existants(4) ? (Entrez le numéro correspondant à votre choix)");
					int choix = sc.nextInt(); 	//Récupération du choix de l'utilisateur (choix de quel méthode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le numéro du client, le nom et le prenom :");
						int id = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String prenom = sc.nextLine();
						Connexion.AjouterClient(id, nom, prenom);		//Appel de la méthode en fonction du cas choisi
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Récupération du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numéro du client à modifier, le nouveau numéro, le nom et le prenom :");
						int idModif = sc.nextInt();
						int nouvId = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nomModif = sc.nextLine();
						String prenomModif = sc.nextLine();
						Connexion.ModifierClient(idModif, nouvId, nomModif, prenomModif);
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
						System.out.print("Rentrez le numéro du client à supprimer : ");
						int idSupp = sc.nextInt();
						Connexion.SupprimerClient(idSupp);
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
						Connexion.listeClient();
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
						System.out.print("Veuillez entrer un numéro valide : ");
					}	
				}while(choixMenu != 2);	
				
			}
			else if(choixTable == 3) {
				//Table Produit
				do
				{
					System.out.println("Souhaitez-vous Ajouter(1), Modifier(2), Supprimer(3) un produit ou obtenir la liste de toutes les produits existants(4) ? (Entrez le numéro correspondant à votre choix)");
					int choix = sc.nextInt(); 	//Récupération du choix de l'utilisateur (choix de quel méthode appeler)
					switch(choix)
					{
					case 1:
						System.out.println("Rentrez respectivement le numéro du produit, le nom, la description, le tarif, le visuel et l'id de la categorie :");
						int id = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nom = sc.nextLine();
						String desc = sc.nextLine();
						double tarif = sc.nextDouble();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String visuel = sc.nextLine();
						int idCateg = sc.nextInt();
						Connexion.AjouterProduit(id, nom, desc, tarif, visuel, idCateg);		//Appel de la méthode en fonction du cas choisi
						System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

						do
						{
							choixMenu = sc.nextInt();		//Récupération du choix de l'utilisateur (choix de continuer ou quitter)
							if(choixMenu < 1 || choixMenu > 2)		//On s'assure que l'utilisateur rentre un chiffre valide
							{
								System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
							}
						}while(choixMenu < 1  || choixMenu > 2);
						
						break;
						
					case 2:
						System.out.println("Rentrez respectivement le numéro du produit à modifier, le nouveau numéro, le nom, la description, le tarif, le visuel et l'id de la categorie :");
						int idModif = sc.nextInt();
						int nouvId = sc.nextInt();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String nomModif = sc.nextLine();
						String descModif = sc.nextLine();
						double tarifModif = sc.nextDouble();
						sc.nextLine();		//On vide la ligne pour pouvoir en lire une autre
						String visuelModif = sc.nextLine();
						int idCategModif = sc.nextInt();
						Connexion.ModifierProduit(idModif, nouvId, nomModif, descModif, tarifModif, visuelModif, idCategModif);
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
						System.out.print("Rentrez le numéro du produit à supprimer : ");
						int idSupp = sc.nextInt();
						Connexion.SupprimerProduit(idSupp);
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
						Connexion.listeProduit();
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
						System.out.print("Veuillez entrer un numéro valide : ");
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
	}
		
}


