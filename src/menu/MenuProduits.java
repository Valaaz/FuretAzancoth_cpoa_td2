package menu;

import requetes.RequetesProduits;

public class MenuProduits {
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
			RequetesProduits.AjouterProduit(id, nom, desc, tarif, visuel, idCateg);		//Appel de la méthode en fonction du cas choisi
			System.out.print("Voulez vous continuer(1) ou quitter(2) ? ");

			do
			{
				choixMenu = sc.nextInt();		//Récupération du choix de l'utilisateur (choix de continuer ou quitter)
				
				// Remplacer par une fonction verification x8
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
			System.out.print("Rentrez le numéro du produit à supprimer : ");
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
			System.out.print("Veuillez entrer un numéro valide : ");
		}	
	}while(choixMenu != 2);	

	}
}
