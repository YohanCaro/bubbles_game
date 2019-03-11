package co.uptc.bubbles.persistence;

import co.uptc.bubbles.model.Entity.User;

public class UserFile implements IFileData<User> {

	@Override
	public int getRecordSize() {
		return 90;
	}

	@Override
	public byte[] getBytes(User data) {
		return null;
	}

	@Override
	public User getData(byte[] b) {
		return null;
	}

}
