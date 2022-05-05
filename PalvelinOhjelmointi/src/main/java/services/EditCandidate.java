package services;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;

@Path("/editcandidate")
public class EditCandidate {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	
	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editEhdokas(Ehdokkaat ehdokas)  {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat paivitaehdokas=em.find(Ehdokkaat.class, ehdokas.getEhdokas_id());
		if (paivitaehdokas!=null) {
		em.merge(ehdokas);
		}
		em.getTransaction().commit();
		//return newEhdokas;
		
	}
	
	
}
