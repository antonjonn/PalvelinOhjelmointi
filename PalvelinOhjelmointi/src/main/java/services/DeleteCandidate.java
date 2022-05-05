package services;
import data.Ehdokkaat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
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
	public void CandidateDeletion(int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat poistettavaEhdokas = em.find(Ehdokkaat.class, id);
		if (poistettavaEhdokas != null) {
			em.remove(poistettavaEhdokas);
			//System.out.println("erroooooooooor");
		}
		em.getTransaction().commit();
	}
}
