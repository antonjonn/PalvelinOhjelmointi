package services;
import data.Ehdokkaat;
import dao.Dao;
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
	
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "salasana");
	}
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	
	@DELETE
	@Path("/deletecandidate")
	@Consumes(MediaType.APPLICATION_JSON)
	public void CandidateDeletion(Ehdokkaat ehdokas) {
		int poistettavaid = ehdokas.getEhdokas_id();
		if (dao.getConnection()) {
			dao.deleteCandidate(poistettavaid);
		}
	}
}
