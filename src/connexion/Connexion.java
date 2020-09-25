package connexion;
import java.sql.*;
import java.util.ArrayList;

public class Connexion {
	
	/*private static Connexion instance;
	
	private Connexion() {}
	
	public static Connexion getInstance() {
		
	if (instance==null) {
		
	instance = new Connexion();
	}
	return instance;
	}
	
	/*public static Connection fermeConnexion()
	{
		
	}*/
	
	public static Connection creeConnexion() 
	{
		
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/furet3u_cpoaTD1?serverTimezone=Europe/Paris";
		String login = "furet3u_appli";
		String pwd = "sknAWi#0";
		
		
		/*String url = "jdbc:mysql://localhost/azancoth1u_cpoatd1?serverTimezone=Europe/Paris";
		String login = "root";
		String pwd = "root"; 
		*/
		Connection maConnexion = null;
		try { 
			maConnexion = DriverManager.getConnection(url, login, pwd);
			} catch (SQLException sqle) 
		{
			System.out.println("Erreur connexion " + sqle.getMessage());
		}
		return maConnexion;
		}
}
