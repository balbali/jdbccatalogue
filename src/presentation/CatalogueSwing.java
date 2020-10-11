package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.Categorie;
import metier.MetierCatalogueImpl;
import metier.Produit;
import metier.SingletonConnection;

public class CatalogueSwing extends JFrame{
	private JLabel jLabelMC=new JLabel("Mot clé: ");
	private JTextField jTextFieldMC=new JTextField(12);
	private JTextField jTextFieldid=new JTextField(12);
	private JTextField jTextFieldnom=new JTextField(12);
	private JTextField jTextFieldprix=new JTextField(12);
	private JTextField jTextFieldqtte=new JTextField(12);
	private JTextField jTextFieldcat=new JTextField(12);
	private JButton jButtonOK=new JButton("OK");
	private JButton jButtonOK2=new JButton("OK2");
	private JTable jTable;
	private ProduitModel produitModel;
	private MetierCatalogueImpl metier =new MetierCatalogueImpl();
	public CatalogueSwing() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel jPanelN=new JPanel();
		jPanelN.setLayout(new FlowLayout());
		jPanelN.add(jLabelMC);jPanelN.add(jTextFieldMC);jPanelN.add(jButtonOK);
		jPanelN.add(jTextFieldid);jPanelN.add(jTextFieldnom);jPanelN.add(jTextFieldprix);jPanelN.add(jTextFieldqtte);jPanelN.add(jTextFieldcat);jPanelN.add(jButtonOK2);
		this.add(jPanelN,BorderLayout.NORTH);
		 produitModel = new ProduitModel();
		 jTable=new JTable(produitModel);
		 JScrollPane jscrollPane=new JScrollPane(jTable);
		 this.add(jscrollPane,BorderLayout.CENTER);
		 this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		 this.setVisible(true);
	jButtonOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String mc=jTextFieldMC.getText();
			List<Produit> produits=metier.getProduitsParMC(mc);
			produitModel.loadData(produits);
			
			
		}
	});
		 
jButtonOK2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Produit p=new Produit();
				p.setIdProduit(jTextFieldid.getText());
				p.setdesignationProduit(jTextFieldnom.getText());
				p.setPrix(Double.parseDouble(jTextFieldprix.getText()));
				p.setQuantite(Integer.parseInt(jTextFieldqtte.getText()));
				String nomCategorie=jTextFieldcat.getText();
				
				Connection conn=SingletonConnection.getConnection();
			PreparedStatement ps;
				ps = conn.prepareStatement("Select c.idCategorie from categorie c join produit a on c.idCategorie=a.idCategorie where c.nomCategorie like ?");
				ps.setString(1, nomCategorie);
				ResultSet rs=ps.executeQuery();	
				while(rs.next()) {
				Categorie c=new Categorie();	
				p.setCategorie(c);
                 c.setIdCategorie((rs.getInt("idCategorie")));	
//					int idCategorie=rs.getInt("idCategorie");
				//int idCategorie=p.getCategorie().getIdCategorie();
//			Connection conn=SingletonConnection.getConnection();
//			PreparedStatement ps;
//				ps = conn.prepareStatement("Select c.idCategorie from categorie c join produit p on c.idCategorie=p.idCategorie where c.nomCategorie like ?");
//				ps.setString(1, nomC);
//				ResultSet rs=ps.executeQuery();	
//
//				
//				int idCategorie=rs.getInt("idCategorie");
				//Categorie c=new Categorie(nomC);
				
				metier.addProduit(p, p.getCategorie().getIdCategorie());	
				//p.setCategorie(c);
				//metier.addCategorie(c);
				}
			
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			//produitModel.loadData(p);
			
			
		}
	});

	}
public static void main(String[] args) {
	new CatalogueSwing();
}
}
