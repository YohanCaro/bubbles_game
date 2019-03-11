package co.uptc.bubbles.comunications;

import java.net.Socket;

import co.uptc.bubbles.model.Entity.User;

public class Conection extends Socket implements Runnable {
	
	private User user;

	public Conection() {
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
