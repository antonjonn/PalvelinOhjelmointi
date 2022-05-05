package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;

@Path ("/showcandidate")
public class CandidatePage {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	
	//@Consumes("application/x-www-form-urlencoded")
	@GET
	@Path("/candidate/{p1}")
	@Produces(MediaType.APPLICATION_JSON)
	public  Ehdokkaat readEhdokas(@PathParam("p1") int p1) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		//List<Ehdokkaat> list=em.createQuery("SELECT a FROM Ehdokkaat a WHERE ehdokas_id =" + p1).getResultList();
		Ehdokkaat ehdokas = em.find(Ehdokkaat.class, p1);
		em.getTransaction().commit();
		return ehdokas;
		
	}
	
	
}
