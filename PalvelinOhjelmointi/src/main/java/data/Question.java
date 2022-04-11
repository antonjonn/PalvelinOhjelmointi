package data;

public class Question {
	private int kysymys_id;
	private String kysymys;
	private int kysjar;

	
	public Question(int kysjar, String kysymys) {
		this.kysjar=kysjar;
		this.kysymys=kysymys;
	}
	public Question(String kysymys) {
		this.kysymys=kysymys;
	}
	
	
	public Question(int kysymys_id, String kysymys, int kysjar) {
		this.kysymys_id=kysymys_id;
		this.kysymys=kysymys;
		this.kysjar = kysjar;
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
	
	public int getKysjar() {
		return kysjar;
	}
	public void setKysjar(int kysjar) {
		this.kysjar = kysjar;
	}
	
}
