package services;

import java.util.ArrayList;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import model.Question;

@Path("/questionservice")
public class QuestionService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vaalikone");
//	private
	@Path("/add")
	public Response addQuestion() {
		
		return Response.ok().build();
	}

//	private
	@POST
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
	@Path("/delete")
	public Response deleteQuestion() {
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
