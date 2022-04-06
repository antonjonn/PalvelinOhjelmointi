package data;

public class Answer {
	private int ehdokas_id;
	private int kysymys_id;
	private int vastaus;
	private String kommentti;
	
	public Answer(int ehdokas_id, int kysymys_id, int vastaus, String kommentti) {
		this.kysymys_id=kysymys_id;
		this.ehdokas_id=ehdokas_id;
		this.vastaus=vastaus;
		this.kommentti=kommentti;
	}
	public Answer() {
		// TODO el constructor
	}
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int Kysymys_id) {
		this.kysymys_id = Kysymys_id;
	}
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	public String getKommentti() {
		return kommentti;
	}
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}
	
	
}
