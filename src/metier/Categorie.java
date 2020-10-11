package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categorie implements Serializable {
private int idCategorie;
private String nomCategorie;
private List <Produit> produits;
public Categorie(String nomCategorie) {
	
	
	this.nomCategorie = nomCategorie;
	produits=new ArrayList<Produit>();
}

public Categorie() {
	
}

public int getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(int idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNomCategorie() {
	return nomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	this.nomCategorie = nomCategorie;
}
public List<Produit> getProduits() {
	return produits;
}
public void setProduits(List<Produit> produits) {
	this.produits = produits;
}
@Override
public String toString() {
	return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", produits=" + produits + "]";
}


}
