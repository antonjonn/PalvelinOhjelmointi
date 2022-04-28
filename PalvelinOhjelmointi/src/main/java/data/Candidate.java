package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int EHDOKAS_ID;
	private String SUKUNIMI;
	private String ETUNIMI;
	private String PUOLUE;
	private String KOTIPAIKKAKUNTA;
	private String IKA;
	private String MIKSI_EDUSKUNTAAN;
	private String MITA_ASIOITA_HALUAT_EDISTAA;
	private String AMMATTI;
	public Candidate(int EHDOKAS_ID, String SUKUNIMI, String ETUNIMI, String PUOLUE, String KOTIPAIKKAKUNTA, String IKA, String MIKSI_EDUSKUNTAAN, String MITA_ASIOITA_HALUAT_EDISTAA, String AMMATTI) {
		// TODO Auto-generated constructor stub
		setEHDOKAS_ID(EHDOKAS_ID);
		this.SUKUNIMI=SUKUNIMI;
		this.ETUNIMI=ETUNIMI;
		this.PUOLUE=PUOLUE;
		this.KOTIPAIKKAKUNTA=KOTIPAIKKAKUNTA;
		this.IKA=IKA;
		this.MIKSI_EDUSKUNTAAN=MIKSI_EDUSKUNTAAN;
		this.MITA_ASIOITA_HALUAT_EDISTAA=MITA_ASIOITA_HALUAT_EDISTAA;
		this.AMMATTI=AMMATTI;
	}
	public int getEHDOKAS_ID() {
		return EHDOKAS_ID;
	}
	public void setEHDOKAS_ID(int EHDOKAS_ID) {
		this.EHDOKAS_ID = EHDOKAS_ID;
	}
	public String getSUKUNIMI() {
		return SUKUNIMI;
	}
	public void setSUKUNIMI(String SUKUNIMI) {
		this.SUKUNIMI = SUKUNIMI;
	}
	public String getETUNIMI() {
		return ETUNIMI;
	}
	public void setETUNIMI(String ETUNIMI) {
		this.ETUNIMI = ETUNIMI;
	}
	public String getPUOLUE() {
		return PUOLUE;
	}
	public void setPUOLUE(String PUOLUE) {
		this.PUOLUE = PUOLUE;
	}
	public String getKOTIPAIKKAKUNTA() {
		return KOTIPAIKKAKUNTA;
	}
	public void setKOTIPAIKKAKUNTA(String KOTIPAIKKAKUNTA) {
		this.KOTIPAIKKAKUNTA = KOTIPAIKKAKUNTA;
	}
	public String getIKA() {
		return IKA;
	}
	public void setIKA(String IKA) {
		this.IKA = IKA;
	}
	public String getMIKSI_EDUSKUNTAAN() {
		return MIKSI_EDUSKUNTAAN;
	}
	public void setMIKSI_EDUSKUNTAAN(String MIKSI_EDUSKUNTAAN) {
		this.MIKSI_EDUSKUNTAAN = MIKSI_EDUSKUNTAAN;
	}
	public String getMITA_ASIOITA_HALUAT_EDISTAA() {
		return MITA_ASIOITA_HALUAT_EDISTAA;
	}
	public void setMITA_ASIOITA_HALUAT_EDISTAA(String MITA_ASIOITA_HALUAT_EDISTAA) {
		this.MITA_ASIOITA_HALUAT_EDISTAA = MITA_ASIOITA_HALUAT_EDISTAA;
	}
	public String getAMMATTI() {
		return AMMATTI;
	}
	public void setAMMATTI(String AMMATTI) {
		this.AMMATTI = AMMATTI;
	}
	public Candidate() {
		// TODO Auto-generated constructor stub
	}
	

}
