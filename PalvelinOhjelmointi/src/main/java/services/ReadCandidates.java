package services;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Candidate;

@Path ("/read")

public class ReadCandidates {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	//EntityManager em=emf.createEntityManager();
	@GET
	@Path("/candidates")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidate> readCandidates() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List <Candidate> list=em.createQuery("select a from ehdokkaat a").getResultList();
		em.getTransaction().commit();
		return list;
	}
}
