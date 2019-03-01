package co.uptc.structures.simple_list;

import java.util.Iterator;

/**
 * Clase que maneja el cursor que se va a mover en la lista!
 * Fecha 31/08/2018
 * @author Yohan Caro
 */
public class Cursor<T> extends MySimpleList<T> implements Iterator<T> {
    
    private Node<T> cursor;

    public Cursor(MySimpleList<T> simpleList) {
        super(simpleList);
        this.cursor = this.head;
    }
    
    public boolean isOut() {
        return this.cursor == null;
    }
    
    public void reset() {
        this.cursor = this.head;
    }
    
    public boolean isLast() {
        return this.cursor.next == null;
    }
    
    public T getInfo() {
        return this.cursor.info;
    }
    
    public void nextElement() {
        this.cursor = cursor.next;
    }
    
    public T nextAndGetInfo() {
        T aux = cursor.info;
        this.cursor = cursor.next;
        return aux;
    }

	@Override
	public boolean hasNext() {
		return this.cursor.next == null;
	}

	@Override
	public T next() {
		T aux = cursor.info;
        this.cursor = cursor.next;
        return aux;
	}
    
}
