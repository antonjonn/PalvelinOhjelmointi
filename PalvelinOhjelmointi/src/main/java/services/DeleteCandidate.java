package services;
import data.Ehdokkaat;
import dao.Dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/delete")


public class DeleteCandidate {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	
	@DELETE
	@Path("/deletecandidate")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteCandidate(Ehdokkaat ehdokas) {
		int poistettavaid = ehdokas.ehdokas_id;
		deleteCandidate(poistettavaid);
	}
}
