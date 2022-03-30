package data;

public class Candidate {

	private int id;
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotipaikkakunta;
	private String ika;
	private String miksi_eduskuntaan;
	private String mita_edistaa;
	private String ammatti;
	public Candidate(int id, String sukunimi, String etunimi, String puolue, String kotipaikkakunta, String ika, String miksi_eduskuntaan, String mita_edistaa, String ammatti) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		this.puolue=puolue;
		this.kotipaikkakunta=kotipaikkakunta;
		this.ika=ika;
		this.miksi_eduskuntaan=miksi_eduskuntaan;
		this.mita_edistaa=mita_edistaa;
		this.ammatti=ammatti;
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
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}
	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	public String getIka() {
		return ika;
	}
	public void setIka(String ika) {
		this.ika = ika;
	}
	public String getMiksi_eduskuntaan() {
		return miksi_eduskuntaan;
	}
	public void setMiksi_eduskuntaan(String miksi_eduskuntaan) {
		this.miksi_eduskuntaan = miksi_eduskuntaan;
	}
	public String getMita_edistaa() {
		return mita_edistaa;
	}
	public void setMita_edistaa(String mita_edistaa) {
		this.mita_edistaa = mita_edistaa;
	}
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}

}
