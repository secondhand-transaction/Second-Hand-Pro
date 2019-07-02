package entity;

public class Announcement {
	private int ID;
	private String content;
	public Announcement()
	{
	}
	public Announcement(int iD, String content) {
		super();
		ID = iD;
		this.content = content;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
