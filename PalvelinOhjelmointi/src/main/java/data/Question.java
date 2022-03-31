package data;

public class Question {
	private int kysymys_id;
	private String kysymys;
	
	public Question(int kysymys_id, String kysymys) {
		this.kysymys_id=kysymys_id;
		this.kysymys=kysymys;
	}
	public Question() {
		// TODO el constructor
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int Kysymys_id) {
		this.kysymys_id = Kysymys_id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	
}
