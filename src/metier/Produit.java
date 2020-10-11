package metier;

public class Produit {
	private String idProduit;
	private String designationProduit;
	private double prix;
	private int quantite;
	private Categorie categorie;
	public Produit(String idProduit, String nomProduit, double prix, int quantite) {
	
		this.idProduit = idProduit;
		this.designationProduit = nomProduit;
		this.prix = prix;
		this.quantite = quantite;
	
	}
	public Produit() {
	
	}
	public Produit(String id, String designationProduit, double prix, int quantite, Categorie c) {

		this.idProduit = idProduit;
		this.designationProduit = designationProduit;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie=c;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	public String getdesignationProduit() {
		return designationProduit;
	}
	public void setdesignationProduit(String nomProduit) {
		this.designationProduit = nomProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + designationProduit + ", prix=" + prix + ", quantite="
				+ quantite + ", categorie=" + categorie + "]";
	}
	

}
