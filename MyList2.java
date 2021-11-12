package dauphine;

public class MyList2<T> {

	public MyList2() {
		// TODO Auto-generated constructor stub
	}
	
	private Cell2<T> ref_premiere = null ; 
	private int size; 

	/**
	 * 
	 * Permet d'ajouter un contenu dans une cellule à la première position
	 * de la liste
	 *
	 */
	public void add(T contenu) {
		Cell2<T> cellule_suiv = new Cell2<T>(contenu , ref_premiere);
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
		
		return size;
	}
	

	/**
	 * Ajouter nouvelle cellule à la fin de la liste 
	 * @param contenu
	 */
	public void addLast(T contenu) {
		Cell2<T> NewCell = new Cell2<T>(contenu,null);
		
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
		Cell2<T> dernier = ref_premiere;
		for(int i=0; i < size-1 ; ++i) {
			dernier = dernier.getCellule_suiv();
		}
		
		dernier.setCellule_suiv(NewCell);
		size++;

	}

	public void add(T contenu, int indice) {
		Cell2<T> NewCell = new Cell2<T>(contenu,null);
		for (int i = 0; i < indice ; i++) {
			ref_premiere = ref_premiere.getCellule_suiv();	
		}
		ref_premiere.setCellule_suiv(NewCell);
		size++;

	}
	
	public T get(int index) {
		for (int i = 0; i < index ; i++) {
			ref_premiere = ref_premiere.getCellule_suiv();	
			}
		return ref_premiere.getContenu();
		
	}
	
	
	public int sumLetters() {
		Cell2<T> temp = this.ref_premiere;
		int sum =0;
		while (temp != null) {
			sum += ((String) temp.getContenu()).length();
			temp = temp.getCellule_suiv();
		}
		return sum;
	} 
	
	
	public boolean contains(T object) {
		if(ref_premiere.getCellule_suiv().equals(object)) {
			return true;
			
		}
		return false;
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
		
		MyList2<Object> ml = new MyList2<>();
		ml.addLast("tatu");
		ml.add("toto");
		ml.add("titi");
		ml.addLast("tutu");
		//ml.add("test",2);
		ml.add(4);
		System.out.println("Taille de la liste : " + ml.size());
		System.out.println(ml.toString());

	}

	

}
