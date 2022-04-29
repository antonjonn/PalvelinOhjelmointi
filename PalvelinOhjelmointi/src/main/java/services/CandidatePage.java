package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path ("/showcandidate")
public class CandidatePage {

	//@GET
	//@POST
	//@Consumes("application/x-www-form-urlencoded")
	@Path("/candidatepage")
	public String alku() {
		return "jotain";
	}
	
	
}
