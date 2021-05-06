package dao;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Answer;
import model.Candidate;
import model.Question;

public class DaoC {
	private final String uploadPath;
	private final String root;

	public DaoC() {
		this.uploadPath = "C:\\Users\\rhexa\\git\\vaalikone\\src\\main\\webapp\\img\\";
		root = "http://localhost:8080/rest";
	}
	
	public String getUploadPath() {
		return uploadPath;
	}
	
//	Candidate Start
	
	public boolean addCandidate(Candidate can) {
		String url = root+"/candidateservice/add";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		
		Response res = b.post(Entity.entity(can, MediaType.APPLICATION_JSON));
		if (res.getStatus() == 200) {
			return true;			
		}
		return false;
	}
	
	public boolean updateCandidate(Candidate can) {
		String url = root+"/candidateservice/update";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		
		Response res = b.put(Entity.entity(can, MediaType.APPLICATION_JSON));
		if (res.getStatus() == 200) {
			return true;			
		}
		return false;
	}
	
	public boolean deleteCandidate(Candidate c) 
	{
		String url = root+"/candidateservice/delete";
		Client cl = ClientBuilder.newClient();
		WebTarget wt = cl.target(url).path(String.valueOf(c.getId()));
		Builder b = wt.request();
		Response res = b.delete();

		if (res.getStatus() == 200) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	public Candidate readCandidate(String id) {
		String url = root+"/candidateservice/read";
		Client cl = ClientBuilder.newClient();
		WebTarget wt = cl.target(url).path(id);
		Builder b = wt.request();
		Response res = b.get();
		
		return res.readEntity(Candidate.class);
	}
	
	public Candidate readCandidateByRef(String ref) {
		String url = root+"/candidateservice/readbyref";
		Client cl = ClientBuilder.newClient();
		WebTarget wt = cl.target(url).path(ref);
		Builder b = wt.request();
		Response res = b.get();
		
		return res.readEntity(Candidate.class);
	}
	
	public ArrayList<Candidate> readAllCandidate() {
		String url = root+"/candidateservice/readall";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		
		Response res = b.get();
		return res.readEntity(new GenericType<ArrayList<Candidate>>() {});
	}
	// Candidate end
	
	// Question Start
	
	public boolean updateQuestion(Question q) {
		String url = root+"/questionservice/update";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();

		Response res = b.put(Entity.entity(q, MediaType.APPLICATION_JSON));
		if (res.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addQuestion(Question q) {
		String url = root+"/questionservice/add";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		Entity e = Entity.entity(q, MediaType.APPLICATION_JSON);
		Response res = b.post(e);
		
		if (res.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean deleteQuestion(Question q) {
		String url = root+"/questionservice/delete";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url).path(String.valueOf(q.getId()));
		Builder b = wt.request();
		Response res = b.delete();

		if (res.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Question> readAllQuestion(){
		String url = "http://localhost:8080/rest/questionservice/readall";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
				
		return b.get(new GenericType<ArrayList<Question>>() {});
	}
	
	public Question readQuestion(int id) {
		String url = "http://localhost:8080/rest/questionservice/read";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url).path(String.valueOf(id));
		Builder b = wt.request();
		Response res = b.get();
		
		return res.readEntity(Question.class);
	}
	
	public Question readQuestionByAnswerID(int id) {
		String url = "http://localhost:8080/rest/questionservice/readbyanswerid";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url).path(String.valueOf(id));
		Builder b = wt.request();
		Response res = b.get();
		
		return res.readEntity(Question.class);
	}

//	Answer Start
	public boolean addAnswer(Answer a) {
		String url = root+"/answerservice/add";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		
		Response res = b.post(Entity.entity(a, MediaType.APPLICATION_JSON));
		if (res.getStatus() == 200) {
			return true;			
		}
		return false;
	}
}
