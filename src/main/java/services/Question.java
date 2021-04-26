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

@Path("/questionservice")
public class Question {

	@Path("/add")
	public String addQuestion() {
		return "";
	}

	@Path("/update")
	public String updateQuestion() {
		return "";
	}

	@Path("/delete")
	public String deleteQuestion() {
		return "";
	}

	@Path("/read")
	public String readQuestion() {
		return "";
	}

	@Path("/readall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> readAllQuestion() {
		System.out.println("Welcome");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vaalikone");
		EntityManager em = emf.createEntityManager();

		List<Question> list = em.createQuery("select a from Question a").getResultList();
		return list;
	}

}
