package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;
@Path ("/candidatecreation")
public class CreateCandidate {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	
		@POST
		@Path("/new")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes("application/x-www-form-urlencoded")
		public  Ehdokkaat createEhdokas(@FormParam("sukunimi") String sukunimi, @FormParam("etunimi") String etunimi, @FormParam("puolue") String puolue,
				@FormParam("paikkakunta") String paikkakunta,@FormParam("ika") String ika,@FormParam("miksi_eduskuntaan") String miksi_eduskuntaan,
				@FormParam("mita_edistaa") String mita_edistaa, @FormParam("ammatti") String ammatti)  {
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			int id = 0;
			Ehdokkaat newEhdokas= new Ehdokkaat(id, sukunimi, etunimi, puolue, paikkakunta, ika, miksi_eduskuntaan, mita_edistaa, ammatti);
			em.persist(newEhdokas);
			em.getTransaction().commit();
			return newEhdokas;
		}
	
}
