class TreeElem<T extends Comparable<T>> {
	T elem;
	TreeElem<T> left;
	TreeElem<T> right;
	
	
	TreeElem(T elem)
	{
		this.elem = elem;
		left = null;
		right = null;
	}
  	
	public String toString() { 
		return elem.toString(); 
	}
}
/**
 * klasa tworzaca nowe drzewo poszukiwan
 * 
 * @author Damian
 *
 * @param <T> typ drzewa
 */
public class Tree<T extends Comparable<T>> {
	/**
	 * korzen drzewa
	 */
	private TreeElem<T> root;
	
	/**
	 * konstruktor korzenia
	 */
	public Tree() { 
		root = null; 
	}
	/**
	 * publiczna metoda dodajaca wezel
	 * @param elem - dodawany wezel
	 * 
	 */
	public void insert(T elem) { 
		root = ins(elem, root); 
	}
	
	/**
	 * prywatna metoda dodajaca wezel
	 * @param elem - dodawany wezel
	 * @param w - tymczasowy korzen (naddrzewo wezla)
	 * @return w - drzewo
	 */
	
	private TreeElem<T> ins(T elem, TreeElem<T> w) {
    
		if( w==null ) return new TreeElem<T>(elem);
		if( elem.compareTo(w.elem)<0 ) w.left = ins(elem, w.left);
		else if( elem.compareTo(w.elem)>0)	w.right = ins(elem, w.right);
		return w;
	}
	
	/**
	 * publiczna metoda poszukujaca elementu
	 * @param elem  poszukiwany element
	 * @return metoda isElem wywolana z poszukiwanym elementem i korzeniem drzewa
	 */
  
	public boolean isElement(T elem) {
		return isElem(elem,root); 
	}
	
	/**
	 * prywatna metoda poszukujaca elementu
	 * @param elem poszukiwany element
	 * @param w poddrzewo w
	 * @return true, gdy element=tymczasowy korzen, false gdy nie ma tymczasowego korzenia, lub te metode znowu wywolana z elementem poszukiwanym i poddrzewem tymczasowego korzenia
	 */
	
	private boolean isElem(T elem, TreeElem<T> w) {
    
		if( w==null ) return false;
		if( elem.compareTo(w.elem)==0 ) return true;
		if( elem.compareTo(w.elem)<0) return isElem(elem, w.left);
		else return isElem(elem, w.right);
	}
	
	/**
	 * metoda usuwajaca element
	 * @param elem usuwany element
	 */
	public void delete(T elem) {
		root = del(elem, root);
	}
	
	/**
	 * 
	 * @param elem usuwany element
	 * @param w poddrzewo w 
	 * @return w - drzewo
	 */
	private TreeElem<T> del(T elem, TreeElem<T> w) {
		 if (w == null)  throw new RuntimeException("nie mo¿na usun¹æ.");
	      else
	      if (elem.compareTo(w.elem) < 0)
	      w.left = del(elem, w.left);
	      else
	      if (elem.compareTo(w.elem)  > 0)
	      w.right = del(elem, w.right);
	      else
	      {
	         if (w.left == null) return w.right;
	         else
	         if (w.right == null) return w.left;
	         else
	         {

	            w.elem = retrieveData(w.left);

	            w.left =  del(w.elem, w.left) ;
	         }
	      }
	      return w;
	}
	/**
	 * metoda zwracajaca najprawszy element
	 * @param w 
	 * @return
	 */
	private T retrieveData(TreeElem<T> w)
	{
		while (w.right != null) w = w.right;

		return w.elem;
	}
	/**
	 * metoda zapisujaca drzewo
	 */
	public String toString() { 
		return toS(root); 
	}
  
	/**
	 * metoda zapisujaca drzewo
	 * @param w 
	 * @return 
	 */
	private String toS(TreeElem<T> w) { 
    
		if( w!=null ) return "("+w.elem+":"+toS(w.left)+":"+toS(w.right)+")";
    return "()";
  }
}
