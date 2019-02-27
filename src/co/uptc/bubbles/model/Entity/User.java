package co.uptc.bubbles.model.Entity;

import java.awt.Image;

public class User {
	
	private String nickName;
	private String password;
	private Image icon;
	
	public User(String nickName, String password, Image icon) {
		this.nickName = nickName;
		this.password = password;
		this.icon = icon;
	}
	
	

}
