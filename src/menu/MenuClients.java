/*package menu;

import requetes.RequetesClients;

public class MenuClients {

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
			RequetesClients.AjouterClient(id, nom, prenom);		//Appel de la méthode en fonction du cas choisi
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
			System.out.println("Rentrez respectivement le numéro du client à modifier, le nouveau numéro, le nom et le prenom :");
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
			System.out.print("Rentrez le numéro du client à supprimer : ");
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
			System.out.print("Veuillez entrer un numéro valide : ");
		}	
	}while(choixMenu != 2);	
	}
}*/