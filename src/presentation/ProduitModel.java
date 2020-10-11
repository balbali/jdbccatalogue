package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Produit;

//le model de Jtable est une classe qui hérite d'abstract table Model
public class ProduitModel extends AbstractTableModel{
private String [] nomColonnes=new String[]{"REF","NOM","PRIX","Quantite","Catégorie"};
private Vector<String[]> rows=new Vector<String[]>();


	@Override
	public int getColumnCount() {
		
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return rows.get(rowIndex)[columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return nomColonnes[column];
		
	}
	public void loadData(List<Produit>produits) {
		rows= new Vector<String[]>();
		for(Produit p:produits) {
			rows.add(new String [] {p.getIdProduit(),p.getdesignationProduit(),String.valueOf(p.getPrix()),String.valueOf(p.getQuantite()),p.getCategorie().getNomCategorie()});
		}
		fireTableChanged(null);
	}

}
