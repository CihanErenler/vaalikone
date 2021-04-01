package data;

public class Answer {
	
	String id;
	String can_id;
	String question_id;
	String answer;
	String answer_text;
	String answer_value;
	
	public Answer(String id, String can_id, String question_id, String answer, String answer_text) {
		setId(id);
		this.can_id = can_id;
		this.question_id = question_id;
		this.answer = answer;
		this.answer_text = answer_text;
		setAnswer_value(this.answer);
	}


	public String getAnswer_text() {
		return answer_text;
	}


	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
	}


	public String getAnswer_value() {
		return answer_value;
	}


	public void setAnswer_value(String answer_value) {
		switch(answer_value) {
		case "1": this.answer_value = "Strongly Disagree"; break;
		case "2": this.answer_value = "Disagree"; break;
		case "3": this.answer_value = "Neutral"; break;
		case "4": this.answer_value = "Agree"; break;
		case "5": this.answer_value = "Strongly Agree"; break;
		}
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCan_id() {
		return can_id;
	}


	public void setCan_id(String can_id) {
		this.can_id = can_id;
	}


	public String getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
