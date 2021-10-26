public class Cell2<T> {

	public Cell2(T contenu, Cell2<T> cellule_suiv) {
		// TODO Auto-generated constructor stub
		this.contenu = contenu; 
		this.cellule_suiv = cellule_suiv;
	}

	private T contenu;
	private Cell2<T> cellule_suiv;

	public T getContenu() {
		return contenu;
	}

	public Cell2<T> getCellule_suiv() {
		return cellule_suiv;
	}

	public void setCellule_suiv(Cell2<T> cellule_suiv) {
		this.cellule_suiv = cellule_suiv;
	}
}
