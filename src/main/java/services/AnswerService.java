package services;

import javax.ws.rs.Path;

@Path("/answerservice")
public class AnswerService {

//	admin
	@Path("/add")
	public String addAnswer() {
		return "";
	}
	
//	admin
	@Path("/update")
	public String updateAnswer() {
		return "";
	}
	
//	admin
	@Path("/delete")
	public String deleteAnswer() {
		return "";
	}
	
//	public
	@Path("/read")
	public String readAnswer() {
		return "";
	}
	
//	public
	@Path("/readall")
	public String readAllAnswer() {
		return "";
	}
}
