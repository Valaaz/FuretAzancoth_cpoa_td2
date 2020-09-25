package menu;

import requetes.RequetesCategorie;

public class MenuCategorie {
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
			RequetesCategorie.AjouterCategorie(id, titre, visuel);		//Appel de la méthode en fonction du cas choisi
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
			System.out.println("Rentrez respectivement le numéro de la catégorie à modifier, le nouveau numéro, le titre et le visuel :");
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
			System.out.print("Rentrez le numéro de la catégorie à supprimer : ");
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
			System.out.print("Veuillez entrer un numéro valide : ");
		}	
	}while(choixMenu != 2);
	}
}