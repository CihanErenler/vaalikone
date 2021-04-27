package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import model.Question;

@Path("/questionservice")
public class QuestionService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vaalikone");
//	private
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addQuestion(Question q) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(q);//The actual insertion line
		em.getTransaction().commit();
		System.out.println("This is our parameter: " + q.getQuestionRef());
		return readAllQuestion();
	}

//	private
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestion(Question q) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Question que=em.find(Question.class, q.getId());
		if (que != null) {
			em.merge(q);
		}
		em.getTransaction().commit();
		return readAllQuestion();
	}

//	private	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response deleteQuestion(@PathParam("id") int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Question q=em.find(Question.class, id);
		if (q!=null) {
			em.remove(q);//The actual delete
		}
		em.getTransaction().commit();
		return Response.ok().build();
	}

//	public
	@GET
	@Path("/read/{id}")
	public Response readQuestion(@PathParam("id") String id) {
		EntityManager em = emf.createEntityManager();
		
		return Response.ok().build();
	}

//	public
	@Path("/readall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAllQuestion() {
		EntityManager em = emf.createEntityManager();

		List<Question> list = em.createQuery("select a from Question a").getResultList();
		
		ArrayList<Question> questionList = new ArrayList<Question>();
		for (Question q : list) {
			Question question = new Question();
			question.setQuestion(q.getQuestion());
			question.setId(q.getId());
			question.setQuestionRef(q.getQuestionRef());
			questionList.add(question);
		}
		
		ResponseBuilder builder;
		if (list == null) {
			builder = Response.status(404);
		}
		else {
			builder = Response.ok(questionList);
		}
		
		return builder.build();
	}

}
