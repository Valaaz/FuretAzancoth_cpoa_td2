import java.sql.SQLException;
import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////
////// Pour des problèmes familiaux, on a pas pu travailler ce week-end////
////// ce qui fait que l'on a pas pu améliorer le menu et gérer certaines//
////// erreurs et exceptions. Mais cela aurait du être normalement fait et/
////// sera fait pour les prochains TD ////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

public class Main {

    public static void main(String[] args) throws SQLException {
        
        int choixPersistance = 0;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("MySQL(1), Persistance(2)");
        
        do
        {
            choixPersistance = sc.nextInt();        //Recuperation du choix de l'utilisateur (choix de la Persistance a modifier)
            if(choixPersistance < 1 || choixPersistance > 2)        //On s'assure que l'utilisateur rentre un chiffre valide
            {
                System.out.print("Veuillez rentrer un entier entre 1 et 2 : ");
            }
        }while(choixPersistance < 1 || choixPersistance > 2);
        
        if(choixPersistance == 1) {
            System.out.println("MySQL");
            MenuMYSQL.menuMysql();
        }
        else if(choixPersistance == 2) {
            System.out.println("Liste mémoire");
            MenuListeMemoire.menuListeMemoire();
        }
        
    }
    
}