/**
 * 
 * @author myria
 *
 */


public class MyList {

	private Cell ref_premiere = null ; 
	private int size; 

	
	public MyList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Permet d'ajouter un contenu dans une cellule à la première position
	 * de la liste
	 *
	 */
	public void add(String contenu) {
		Cell cellule_suiv = new Cell(contenu , ref_premiere);
		ref_premiere = cellule_suiv; 
		size++;
	}
	
	/**
	 * 
	 * @return Taille de la liste ml
	 *
	 */
	public int size() {
		/*int size = 0; 
		while (premiere != null) {
			size ++;
			premiere = premiere.getCellule(); 
		}*/
		
		return size -1;
	}
	

	/**
	 * Ajouter nouvelle cellule à la fin de la liste 
	 * @param contenu
	 */
	public void addLast(String contenu) {
		Cell NewCell = new Cell(contenu,null);
		
		// Si il est en dernier adresse de ref_premiere = null
		// Si la reférence de la cellule 1 est vide, on ajoute la nouvelle cellule au debut
		if(ref_premiere == null) {
			ref_premiere = NewCell;
			size++;
			}
		
		/*
		 * Il cherche la cellule qui a pour reference la ref de la premier cellule
		 * La liste est circulaire ce qui veut dire que le dernier élément contient l'adresse du PREMIER
		 */
		Cell dernier = ref_premiere;
		for(int i=0; i < size-1 ; ++i) {
			dernier = dernier.getCellule_suiv();
		}
		
		dernier.setCellule_suiv(NewCell);
		size++;

	}

	public void add(String contenu, int indice) {
		Cell NewCell = new Cell(contenu,null);
		for (int i = 0; i < indice ; i++) {
			ref_premiere = ref_premiere.getCellule_suiv();	
		}
		ref_premiere.setCellule_suiv(NewCell);
		size++;

	}
	
	public String get(int index) {
		if (index <0 || index > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		Cell it = ref_premiere;
		for (int i = 0; i < index ; i++) {
			it = it.getCellule_suiv();	
			}
		return it.getContenu();
		
	}
	
	
	public int sumLetters() {
		Cell temp = this.ref_premiere;
		int sum =0;
		while (temp != null) {
			sum += temp.getContenu().length();
			temp = temp.getCellule_suiv();
		}
		return sum;
	} 
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
	    sb.append("Elements de la liste : ");
	    while(ref_premiere != null){
			sb.append(ref_premiere.getContenu()).append(",");
			ref_premiere = ref_premiere.getCellule_suiv();
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
		
		MyList ml = new MyList();
		ml.addLast("tatu");
		ml.add("toto");
		ml.add("titi");
		ml.addLast("tutu");
		//ml.add("test",2);
		System.out.println("Taille de la liste : " + ml.size());
		System.out.println("Somme des lettres: " + ml.sumLetters());

		System.out.println(ml.toString());
		


	}

}
