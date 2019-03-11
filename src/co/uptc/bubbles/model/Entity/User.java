package co.uptc.bubbles.model.Entity;

import java.awt.Image;
import java.io.Serializable;

/**
 * Clase User usuario
 * Fecha 01/03/2019
 * @author Yohan Caro
 * @version 1.0
 */
public class User implements Serializable {
	public static final int RECORD_SIZE = 90;
	private String nickName; //40
	private String password; //40
	private long iDIcon; //8
	
	public User(String nickName, String password, long icon) {
		this.nickName = nickName;
		this.password = password;
		this.iDIcon = icon;
	}

	public static int getRecordSize() {
		return RECORD_SIZE;
	}

	public String getNickName() {
		return nickName;
	}

	public String getPassword() {
		return password;
	}

	public long getiDIcon() {
		return iDIcon;
	}

}
