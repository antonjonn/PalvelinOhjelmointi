package data;

public class Candidate {

	private int id;
	private String breed;
	public Candidate(String ehdokas_id, String sukunimi, String etunimi, String puolue, String kotipaikkakunta, String ika, String miksi_eduskuntaan, String mita_edistaa, String ammatti) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.breed=breed;
	}
	public Candidate() {
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
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
}
