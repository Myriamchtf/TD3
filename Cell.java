public class Cell {

	private String contenu;
	private Cell cellule_suiv;

	public Cell(String contenu, Cell cellule_suiv) {
		// TODO Auto-generated constructor stub
		this.contenu = contenu; 
		this.cellule_suiv = cellule_suiv;
	}

	public String getContenu() {
		return contenu;
	}

	public Cell getCellule_suiv() {
		return cellule_suiv;
	}

	public void setCellule_suiv(Cell cellule_suiv) {
		this.cellule_suiv = cellule_suiv;
	}
	
}
