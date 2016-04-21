package lista;

import java.util.Iterator;

public class IndexdLL<T> implements IndexedList<T> {
	private T[] list = (T[]) new Object[1];      
	private int n = 0;
	
	private boolean checkPosition(int i) {  
		return (i < 0 || i > n );   
	}
	
	

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(list, n);
	}

	@Override
	public boolean isEmpty(int i) {
		if (checkPosition(i)) {
			throw new IndexNotV("indice non valido");
		}
		return list[i] == null;
	}

	@Override
	public void addItem(T e, int i) {
	
		if(isEmpty(i)) {
			
			for (int j = n; j > i; j--) {
				list[j] = list[j - 1];
			}
			
			list[i] = e;
			n++;
			
			if(list.length == n) {
				T[] temp = (T[]) new Object[list.length * 2];
				System.arraycopy(list, 0, temp, 0, n);
				list = temp;
			}
			
			
		} else {
			throw new ItemAlreadyPresent("Posizione già occupata");
		}
		
	}

	@Override
	public void delItem(int i) {
		if (!isEmpty(i)) {
			
			for (int j = i; j < list.length - 1; j++) {
				list[j] = list[j + 1];
			}
			
			n--;
			
			if (n > 1 && n == (list.length / 4) ) {
				T[] temp = (T[]) new Object[list.length / 2];
				System.arraycopy(list, 0, temp, 0, n);
				list = temp;
			}
		} else {
			throw new ItemNotPresent("Elemento non presente");
		}
		
	}

	@Override
	public T getItem(int i) {
		if (!isEmpty(i)) {
			return list[i];
		} else {
			throw new ItemNotPresent("Elemento non presente");
		}
	}

	@Override
	public int numberItems() {
		return n;
	}
	
	
	private class ListIterator<E> implements Iterator<E> {
		E[] lista;
		int n;
		int pos;
		
		public ListIterator(E[] list, int n) {
			lista = list;
			this.n = n;
		}
		
		@Override
		public boolean hasNext() {
			return pos < n ;
		}

		@Override
		public E next() {
			pos++;
			return (E) list[pos - 1];
		}
		
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
	}

	
	public static void main(String[] args) {
		IndexdLL<String> s = new IndexdLL<String>();
		/**
		s.addItem("pos0", 0);
		s.addItem("pos1", 1);
		s.addItem("pos2", 2);
		s.addItem("pos3", 3);
		s.addItem("pos4", 4);
		s.addItem("pos5", 5);
		s.addItem("pos6", 6);
		
		s.delItem(3);
		s.delItem(3);
		
		System.out.println(s.getItem(3));
		System.out.println(s.numberItems());
		System.out.println();
		
		for(String elem : s) {
			System.out.println(elem);
		}
		
		System.out.println("________" + s.getItem(s.numberItems() - 1));
		System.out.println();
		**/
		s.addItem("3", 1);
		
	}
	
	

}
