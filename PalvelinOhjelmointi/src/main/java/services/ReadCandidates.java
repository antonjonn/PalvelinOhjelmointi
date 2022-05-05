package services;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;

@Path ("/read")

public class ReadCandidates {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	
	@GET
	@Path("/candidates")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> readCandidates() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokkaat> list=em.createQuery("SELECT a FROM Ehdokkaat a").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
//	 @GET
//	 @Path("/test")
//	 @Produces(MediaType.TEXT_HTML)
//	public void readCandidates(PrintWriter out) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		List<Ehdokkaat> list=em.createQuery("SELECT a FROM Ehdokkaat a").getResultList();
//		em.getTransaction().commit();
//		printCandidates(out, list);
//		
//	}
//	private void printCandidates(PrintWriter out, List<Ehdokkaat> list) {
//		// TODO Auto-generated method stub
//		for (int i=0;list!=null && i<list.size();i++) {
//			Ehdokkaat k=list.get(i);
//			out.println(k+"<br>");
//			
//		}
//	}
	
}
