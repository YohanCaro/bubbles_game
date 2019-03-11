package co.uptc.bubbles.persistence;

import co.uptc.bubbles.model.Entity.User;

public class BSTFile<T> {
	
	private long rootIndex;
	private String nameFile;
	private String masterFile;
	
	public BSTFile() {
		
	}
	
	public void add(T t) {
		//Adicionar el usuario en un espacio disponible de data - master
		//Agregar el arbol filename va a ser un archivo de objetos de treenodeFile (index)
	}
	
	public void delete(T t) {
		//Eliminar del master
		//Eliminar del arbol ( index)
	}
	
	public T search() { //Entra cualquier dato para buscar el usuario
		return null;
	}
	
	/*
	 * Implementar el arbol en persistencia
	 */

}
