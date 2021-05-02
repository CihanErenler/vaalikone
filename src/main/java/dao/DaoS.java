package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;

import model.Candidate;
import model.Question;

public class DaoS {
	private final EntityManagerFactory emf;
	private final EntityManager em;

	public DaoS() {
		emf = Persistence.createEntityManagerFactory("Vaalikone");
		em = emf.createEntityManager();
	}

//	Question Start
	public Response addQuestion(Question q) {
		em.getTransaction().begin();
		em.persist(q);// The actual insertion line
		em.getTransaction().commit();
		if (q.equals(em.find(Question.class, q.getId()))) {
			return Response.ok().build();
		} else {
			return Response.status(409).build();
		}
	}

	public Response updateQuestion(Question q) {
		Question que = em.find(Question.class, q.getId());
		if (que != null) {
			em.getTransaction().begin();
			em.merge(q);
			em.getTransaction().commit();
			return Response.ok().build();
		}
		return Response.status(409).build();
	}

	public Response deleteQuestion(int id) {
		em.getTransaction().begin();
		Question q = em.find(Question.class, id);
		if (q != null) {
			em.remove(q);// The actual delete
			em.getTransaction().commit();
			return Response.ok().build();
		}
		em.getTransaction().commit();
		return Response.status(409).build();
	}

	public Response readQuestion(int id) {
		em.getTransaction().begin();
		Question q = em.find(Question.class, id);
		em.getTransaction().commit();
		if (q != null) {
			return Response.ok(q).build();
		}
		return Response.status(409).build();
	}

	public Response readAllQuestion() {
		List<Question> list = em.createQuery("select a from Question a").getResultList();

		if (list == null) {
			return Response.status(404).build();
		}
		return Response.ok(list).build();
	}
// Question End
	
	
	
//	Candidate Start
	
	public Response addCandidate(Candidate c) {
		em.getTransaction().begin();
		em.persist(c);// The actual insertion line
		em.getTransaction().commit();
		if (c.equals(em.find(Candidate.class, c.getId()))) {
			return Response.ok().build();
		} else {
			return Response.status(409).build();
		}
	}

	public Response updateCandidate(Candidate c) {
		Candidate can = em.find(Candidate.class, c.getId());
		if (can != null) {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			return Response.ok().build();
		}
		return Response.status(409).build();
	}

	public Response deleteCandidate(int id) {
		em.getTransaction().begin();
		Candidate c = em.find(Candidate.class, id);
		if (c != null) {
			em.remove(c);// The actual delete
			em.getTransaction().commit();
			return Response.ok().build();
		}
		em.getTransaction().commit();
		return Response.status(409).build();
	}

	public Response readCandidate(int id) {
		em.getTransaction().begin();
		Candidate c = em.find(Candidate.class, id);
		em.getTransaction().commit();
		if (c != null) {
			return Response.ok(c).build();
		}
		return Response.status(409).build();
	}

	public Response readAllCandidate() {
		List<Candidate> list = em.createQuery("select a from Candidate a").getResultList();

		if (list == null) {
			return Response.status(404).build();
		}
		return Response.ok(list).build();
	}
	
//	Candidate End
	
}
