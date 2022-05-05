package services;
import data.Ehdokkaat;

@Path("/editcandidate")
public class EditCandidate {
	
	@POST
	@Path("/edit")
	@Consumes("application/x-www-form-urlencoded")
	public Ehdokkaat editCandidate(@FormParam("sukunimi") String sukunimi, @FormParam("etunimi") String etunimi, @FormParam("puolue") String puolue, @FormParam("paikkakunta") String paikkakunta, 
			@FormParam("ika") String ika, @FormParam("miksi_eduskuntaan") String miksi_eduskuntaan, @FormParam("mita_edistaa") String mita_edistaa, @FormParam("ammatti") String ammatti) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		em.getTransaction().commit();
	}
	
	
}
