//package test;
//
//import java.sql.Connection;
//import java.util.List;
//
//import metier.Categorie;
//import metier.MetierCatalogueImpl;
//import metier.Produit;
//import metier.SingletonConnection;
//
//public class Test {
//
//	public static void main(String[] args) {
//		//Lorsque j'appelle la connexion la première fois elle va être charger dans la mémoire
//		Connection conn=SingletonConnection.getConnection();
////		//la deuxième fois, quand j'appelle la connexion, je récupère la référence c'est à dire l'adresse mémoire de la même connexion crée la première fois
////		Connection conn1=SingletonConnection.getConnection();
////		Connection conn2=SingletonConnection.getConnection();
////		Connection conn3=SingletonConnection.getConnection();
////		Connection conn4=SingletonConnection.getConnection();
////		Connection conn5=SingletonConnection.getConnection();
////		Connection conn6=SingletonConnection.getConnection();
////		Connection conn7=SingletonConnection.getConnection();
////		Connection conn8=SingletonConnection.getConnection();
//		//on test MetierCatalogueImpl.java
//		MetierCatalogueImpl metier=new MetierCatalogueImpl();
////		metier.addCategorie(new Categorie("Serveur"));
////		metier.addCategorie(new Categorie("CD"));
////		metier.addCategorie(new Categorie("Clavier"));
//	//je vais ajouter un produit
////		metier.addProduit(new Produit("PP1","Dell",2000,33), 1);
////		metier.addProduit(new Produit("IP1","Gell",2000,36), 2);
////		metier.addProduit(new Produit("CP1","Lell",2000,38), 3);
////		metier.addProduit(new Produit("GP1","Xell",2000,39), 4);
////		List<Categorie>cat=metier.getAllCategorie();
////		for(Categorie c:cat) {
////			System.out.println(c.getNomCategorie());
////		}
//		//on veudra chercher les produits d'une catégoire
////		List<Produit> produits=metier.getProduitsParIDcategorie(1);
////        for(Produit p:produits) {
////    System.out.println(p.getdesignationProduit());
////        }
//        System.out.println("----------------------------------");
//        List<Produit>prods=metier.getProduitsParMC("Dell");
//        for(Produit p:prods) {
//        	System.out.println("le produit est :"+p.getdesignationProduit()+" appartenant à la catégorie: "+p.getCategorie().getNomCategorie());
//        }
//	}
//
//}
