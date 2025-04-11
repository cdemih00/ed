package ule.ed.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayEDList<T> implements EDList<T> {
	//private final int DEFAULT_CAPACITY=100; 
    private T[] data;
	private int count;
	
	public ArrayEDList() {
		count = 0;
		data = (T[]) (new Object[5]);
	}
	
	public ArrayEDList(int initialCapacity) {
		count = 0;
		data = (T[]) (new Object[initialCapacity]);
	}
	
	@SuppressWarnings("hiding")
private class ArrayListIterator<T> implements Iterator<T> {
		
		private int count;
		private T[] data;
		
		public ArrayListIterator(T[] data){
			
			this.data=data;
			this.count=0;
	//TODO
	}
		
		@Override
		public boolean hasNext() {
			//TODO
			return count < data.length && data[count] != null;
	
	}

		@Override
		public T next() { //esto s�lo es una prueba
			if (!hasNext()) {
	            throw new NoSuchElementException();
	        }
	        return data[count++];
	}	
	}
	
//////FIN ITERATOR
/// AÑADIR TANTAS CLASES DE ITERADORES COMO MÉTODOS DE ITERADOR HAYA EN EL INTERFACE


	@SuppressWarnings("hiding")
	private class ArrayListOddIterator<T> implements Iterator<T> {
		
		private int count;
		private T[] data;
		
		public ArrayListOddIterator(T[] data){
			//TODO
			
			this.data = data;
	        this.count = 0; 
	}
		
		@Override
		public boolean hasNext() {
			//TODO
			 while (count < data.length && data[count] == null) {
		            count += 2; 
		     }
		     return count < data.length;
	}

		@Override
		public T next() {
			if (!hasNext()) {
	            throw new NoSuchElementException();
	        }
	        T element = data[count];
	        count += 2; 
	        return element;
	    
	}	
	}
	
	@SuppressWarnings("hiding")
	private class ArrayListEvenIterator<T> implements Iterator<T> {
	    
	    private int index;
	    private T[] data;

	    public ArrayListEvenIterator(T[] data) {
	        this.data = data;
	        this.index = 1; 
	    }

	    @Override
	    public boolean hasNext() {
	        return index < ArrayEDList.this.count && data[index] != null;
	    }

	    @Override
	    public T next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException();
	        }
	        T element = data[index];
	        index += 2; 
	        return element;
	    }
	}
	
	
	
	

	@Override
	public int size() {
	//TODO
		return this.count;

	}

	@Override
	public boolean isEmpty() {
		//TODO
		boolean vacio=true;
		if(this.count==0) {
			vacio=false;
		}
		return vacio;

	}

	@Override
	public void clear() {
		//TODO
		for(int i=0;i<this.count;i++) {
			data[i]=null;
			this.count=0;
		}

	}

	@Override
	public void addFirst(T elem) {
		//TODO
		if (elem == null) {
	        throw new NullPointerException("El elemento no puede ser null");
	    }
		
		if(this.count==this.data.length) {
			
			T[] data2=(T[]) new Object[data.length + 1];//expandimos
			for (int i = 0; i < this.count; i++) {
	            data2[i + 1] = this.data[i];
	        }
	        this.data = data2;
		}
		
		for(int i=count;i>0;i--) {
			this.data[i]=this.data[i-1];
			
		}
		this.data[0]=elem;
		
		this.count++;
		

		
	}

	@Override
	public void addLast(T elem) {
		//TODO
		if (elem == null) {
	        throw new NullPointerException("El elemento no puede ser null");
	    }	
		if(this.count==this.data.length) {
			
			T[] data2=(T[]) new Object[data.length + 1];//expandimos
			for (int i = 0; i < this.count; i++) {
	            data2[i] = this.data[i];
	        }
	        this.data = data2;
		}
		
		this.data[this.count]=elem;
		this.count++;
		
	}

	@Override
	public void addPenult(T elem) {
		//TODO
		if (elem == null) {
	        throw new NullPointerException("El elemento no puede ser null");
	    }
		if (this.count == 0) {
	        addLast(elem);
	        return;
	    }
		if(this.count==this.data.length) {
			
			T[] data2=(T[]) new Object[data.length + 1];//expandimos
			for (int i = 0; i < this.count; i++) {
	            data2[i] = this.data[i];
	        }
	        this.data = data2;
		}
		
		for (int i = this.count; i > this.count - 1; i--) {
		    this.data[i] = this.data[i - 1];
		}
		this.data[this.count-1]=elem;
		this.count++;
		
	}
		
	

	@Override
	public void addPos(T elem, int position) {
		//TODO
		if (elem == null) {
	        throw new NullPointerException("El elemento no puede ser null");
	    }
		if(position<=0) {
			throw new IllegalArgumentException();
		}
		if(position>this.size()) {
			this.addLast(elem);
			return;
		}
		
		if(this.count==this.data.length) {
			T[] data2=(T[]) new Object[data.length + 1];//expandimos
			for (int i = 0; i < this.count; i++) {
	            data2[i] = this.data[i];
	        }
	        this.data = data2;
		}
		for(int i=this.count;i>=position;i--) {
			this.data[i]=this.data[i-1];	
		}
		this.data[position-1]=elem;
		count++;
		
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		if(this.count==0) {
			throw new EmptyCollectionException("No hay elementos en la lista");
		}
		T dato=this.data[0];
		for(int i=1;i<this.count;i++) {
			this.data[i-1]=this.data[i];
		}
		
		this.data[this.count-1]=null;
		this.count--;
		return dato;
		//TODO
		
	}

	@Override
	public T removelast() throws EmptyCollectionException {
	//TODO
		if(this.count==0) {
			throw new EmptyCollectionException("No hay elementos en la lista");
		}
		T dato=this.data[this.count-1];
		this.data[this.count-1]=null;
		this.count--;
		return dato;
}

	@Override
	public T removePenult() throws EmptyCollectionException {
	//TODO
		if(this.count==0) {
			throw new EmptyCollectionException("No hay elementos en la lista");
		}
		if(this.count==1) {
			throw new NoSuchElementException("Solo hay un elemento en la lista");
		}
		T dato=this.data[this.count-2];
		this.data[this.count-2]=this.data[this.count-1];
		this.data[this.count - 1] = null;
		this.count--;
		return dato;
	}

	@Override
	public T removeElem(T elem) throws EmptyCollectionException {
	//TODO
		
		if(this.count==0) {
			throw new EmptyCollectionException("No hay elementos en la lista");
		}
		
		int posicion=0, i=0;
		boolean found=false;
		T dato=null;
		while(i<this.count&&!found) {
			
			if(elem.equals(this.data[i])) {
				dato=this.data[i];
				found=true;
				posicion=i;
			}
			i++;	
		}
		if(!found) {
			throw new NoSuchElementException("No existe ese elemento");
		}
		for(i=posicion;i<this.count-1;i++) {
			this.data[i]=this.data[i+1];
		}
		this.data[this.count-1]=null;
		return dato;
	}

	@Override
	public T getElemPos(int position) {
		//TODO
		
		if(position<1||position>=this.count) {
			throw new IllegalArgumentException("La posicion que has marcado no es correcta");
		}
		
		
		return this.data[position+1];
	}

	@Override
	public int getPosFirst(T elem) {
	//TODO
		if(elem==null) {
			throw new NullPointerException("El elemento no puede ser nulo");
		}
		
		boolean encontrado=false;
		int i=0, posicion=-1;
		while(i<this.count&&!encontrado) {
			if(elem.equals(this.data[i])) {
				encontrado=true;
				posicion=i;
			}
			i++;
		}
		if(!encontrado) {
			throw new NoSuchElementException("El elemento no esta en la lista");
		}
		
		return posicion+1;
		
	}


	@Override
	public int getPosLast(T elem) {
	//TODO
		if(elem==null) {
			throw new NullPointerException("El elemento no puede ser nulo");
		}
		
		boolean encontrado=false;
		int i=this.count-1, posicion=-1;
		while(i>=0&&!encontrado) {
			if(elem.equals(this.data[i])) {
				encontrado=true;
				posicion=i;
			}
			i--;
		}
		if(!encontrado) {
			throw new NoSuchElementException("El elemento no esta en la lista");
		}
		
		return posicion+1;
		
	}

	

	@Override
	public EDList<T> reverse() {
		//TODO
		ArrayEDList<T> reversedList = new ArrayEDList<T>(this.count);		
		for(int i=this.count-1;i>=0;i--) {			
			reversedList.addFirst(this.data[i]);
		}
		return reversedList;
	}

	
	
	public String toString() {
		//TODO
		StringBuilder sb=new StringBuilder();
		sb.append("(");
		for(int i=0;i<this.count;i++) {
			sb.append(this.data[1]);
			if(i<this.count-1) {
				sb.append(" ");
			}
		}
		sb.append(")");
		return sb.toString();

	}

	@Override
	public Iterator<T> iterator() {
		//TODO
		return new ArrayListIterator<>(this.data);

	}

	@Override
	public Iterator<T> evenPositionsIterator() {
		//TODO
		return new ArrayListEvenIterator<>(this.data);

	}

	@Override
	public Iterator<T> oddPositionsIterator() {
		//TODO
		return new ArrayListOddIterator<>(this.data);
	}



	@Override
	public int removeLastElem(T elem) throws EmptyCollectionException {
		//TODO
		if(this.count==0) {
			throw new EmptyCollectionException("Lista vacia");
		}
		int i=this.count-1,posicion=-1;
		boolean encontrado=false;
		
		while(i>=0&&!encontrado) {
			if(this.data[i].equals(elem)) {
				encontrado=true;
				posicion=i-1;
				
			}
		}
		if(!encontrado) {
			throw new NoSuchElementException("No se encontro el elemento");
		}
		return posicion;
	}

	@Override
	public int removeN(T elem, int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T mostFrequent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T leastFrequent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> repeatNiterator(int n) {
		// TODO Auto-generated method stub
		return null;
	}



}
