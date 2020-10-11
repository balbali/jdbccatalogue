package metier;

import java.util.List;

public interface IMetier {
	//Ajouter une categorie
public void addCategorie(Categorie c);
//insérrer un produit en connaissant son idCategorie
public void addProduit(Produit p, int idCategorie);
//Liste des produits en fonction d'un mot clé
public List<Produit> getProduitsParMC(String mc);
//Liste des produits sachant l'id catégorie
public List<Produit> getProduitsParIDcategorie (int idCategorie);
public List<Categorie> getAllCategorie();// méthode qui retourne toutes les catégories
public Categorie getCategorie(int idCategorie);//méthode qui retourne une catégorie sachant l'id catégorie
// ça c'est très important, il faut bien concevoir et réaliser l'interface pour ne pas faire des retours.
//cette interface traduit le diagramme de cas d'utilisation.
}
