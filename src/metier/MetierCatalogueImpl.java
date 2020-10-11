package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierCatalogueImpl implements IMetier{

	@Override
	public void addCategorie(Categorie c) {
		Connection conn=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("insert into categorie (nomCategorie) values(?)");
			ps.setString(1,c.getNomCategorie());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addProduit(Produit p, int idCategorie) {
	Connection conn=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("insert into produit values(?,?,?,?,?)");
			ps.setString(1,p.getIdProduit());
			ps.setString(2,p.getdesignationProduit());
			ps.setDouble(3,p.getPrix());
			ps.setInt(5,p.getQuantite());
			ps.setInt(4,idCategorie);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> getProduitsParMC(String mc) {
		// cette fois ci on va faire des select
		List<Produit>produits=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Select * from produit where designationProduit like ?");
			ps.setString(1,"%"+mc+"%");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
				 Produit p=new Produit();
				 p.setIdProduit(rs.getString("idProduit"));
				 p.setdesignationProduit(rs.getString("designationProduit"));
				 p.setPrix(rs.getDouble("prix"));
				 p.setQuantite(rs.getInt("quantite"));
				 int idCategorie=rs.getInt("idCategorie");
				 PreparedStatement ps2=conn.prepareStatement("Select * from categorie where idCategorie = ?");
				 ps2.setInt(1,idCategorie);
				 ResultSet rs2=ps2.executeQuery();
				 if(rs2.next()) {
					 Categorie cat=new Categorie();
					 cat.setIdCategorie(rs2.getInt("idCategorie"));
					 cat.setNomCategorie(rs2.getString("nomCategorie"));
					 p.setCategorie(cat);
				 }
				 produits.add(p);
				ps2.close(); //ce n'est pas obligatoire de fermer le ps dans les selects
			 }
			 ps.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
	@Override
	public List<Produit> getProduitsParIDcategorie(int idCategorie) {
		List<Produit>produits=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Select * from produit where idCategorie = ?");
			ps.setInt(1,idCategorie);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
				 Produit p=new Produit();
				 p.setIdProduit(rs.getString("idProduit"));
				 p.setdesignationProduit(rs.getString("designationProduit"));
				 p.setPrix(rs.getDouble("prix"));
				 p.setQuantite(rs.getInt("quantite"));
				 idCategorie=rs.getInt("idCategorie");
				 PreparedStatement ps2=conn.prepareStatement("Select * from categorie where idCategorie = ?");
				 ps2.setInt(1, idCategorie);
				 ResultSet rs2=ps2.executeQuery();
				 if(rs2.next()) {
					 Categorie cat=new Categorie();
					 cat.setIdCategorie(rs2.getInt("idCategorie"));
					 cat.setNomCategorie(rs2.getString("nomCategorie"));
					 p.setCategorie(cat);
				 }
				 produits.add(p);
				ps2.close(); //ce n'est pas obligatoire de fermer le ps dans les selects
			 }
			 ps.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
	@Override
	public List<Categorie> getAllCategorie() {
		List<Categorie>categories=new ArrayList<Categorie>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Select * from categorie");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
				 Categorie c=new Categorie();
				 c.setIdCategorie(rs.getInt("idCategorie"));
				 c.setNomCategorie(rs.getString("nomCategorie"));
				 categories.add(c);				
			 }
			 ps.close();			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return categories;
	}
	

	@Override
	public Categorie getCategorie(int idCategorie) {
		//List<Categorie>categories=new ArrayList<Categorie>();
		Categorie cat = null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Select * from idCategorie=?");
			ps.setInt(1,idCategorie);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()){
				 cat=new Categorie();
				 cat.setIdCategorie(rs.getInt("idCategorie"));
				 cat.setNomCategorie(rs.getString("nomCategorie"));
				 List<Produit>produits=this.getProduitsParIDcategorie(idCategorie);
				 cat.setProduits(produits);
			}
			 ps.close();			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return cat;
	}
	

}
