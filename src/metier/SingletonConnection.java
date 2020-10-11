package metier;

import java.sql.Connection;
import java.sql.DriverManager;

//un design pattern est un patron de conception
public class SingletonConnection {
private static Connection connection;
//cette variable connection on va l'initialiser au chargement de la classe dans la mémoire tous ce que vous mettez dans 
// le bloc static va être executer lors du chargement de la classe dans la mémoire ça veut dire qu'il va s'executer une fois.
//
static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost/catalogue1","root","");
		System.out.println("création d'une connexion");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static Connection getConnection() {
	return connection;
	
}
}
