package co.uptc.bubbles.persistence;

public interface IFileData<T> {

	public int getRecordSize();
	public byte[] getBytes(T t);
	public T getData(byte[] b);
	
}
