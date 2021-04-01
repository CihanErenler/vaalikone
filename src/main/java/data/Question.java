package data;

public class Question {
	private int id;
	private String text;
	public Question(String id, String text) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.text=text;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}