package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import model.Candidate;

@Path("/candidateservice")
public class CandidateService 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vaalikone");	
//	private
	@Path("/add")
	public String addCandidate() 
	{
		return "";
	}
	
//	private
	@Path("/update")
	public String updateCandidate() 
	{
		return "";
	}
	
//	private
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response deleteCandidate(@PathParam("id") int id) 
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Candidate c = em.find(Candidate.class, id);
		if (c!=null) 
		{
			em.remove(c);//The actual delete
		}
		em.getTransaction().commit();
		return Response.ok().build();
	}
	
//	public
	@Path("/read/{id}")
	public Response readCandidate (@PathParam("id") String id) 
	{
		EntityManager em = emf.createEntityManager();

		return Response.ok().build();
	}
	
//	public
	@Path("/readalladmin")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAllCandidateAdmin() 
	{
		EntityManager em = emf.createEntityManager();

		List<Candidate> list = em.createQuery("select a from Candidate a").getResultList();
		
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		for (Candidate c : list) 
		{
			Candidate candidate = new Candidate();
			candidate.setId(c.getId());
			candidate.setAbout(c.getAbout());
			candidate.setAge(c.getAge());
			candidate.setCity(c.getCity());
			candidate.setFname(c.getFname());
			candidate.setLname(c.getLname());
			candidate.setPoliticalParty(c.getPoliticalParty());
			candidate.setProfilePic(c.getProfilePic());
			candidateList.add(candidate);
		}
		
		ResponseBuilder builder;
		if (list == null) 
		{
			builder = Response.status(404);
		}
		else 
		{
			builder = Response.ok(candidateList);
		}
		
		return builder.build();
	}
	
	
//	public
	@Path("/readall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAllCandidate() 
	{
		return readAllCandidateAdmin();
	}
}
