package metier;

import java.util.List;

public interface IMetier {
	//Ajouter une categorie
public void addCategorie(Categorie c);
//ins�rrer un produit en connaissant son idCategorie
public void addProduit(Produit p, int idCategorie);
//Liste des produits en fonction d'un mot cl�
public List<Produit> getProduitsParMC(String mc);
//Liste des produits sachant l'id cat�gorie
public List<Produit> getProduitsParIDcategorie (int idCategorie);
public List<Categorie> getAllCategorie();// m�thode qui retourne toutes les cat�gories
public Categorie getCategorie(int idCategorie);//m�thode qui retourne une cat�gorie sachant l'id cat�gorie
// �a c'est tr�s important, il faut bien concevoir et r�aliser l'interface pour ne pas faire des retours.
//cette interface traduit le diagramme de cas d'utilisation.
}
