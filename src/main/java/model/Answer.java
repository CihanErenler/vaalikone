package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String answer;

	//bi-directional many-to-one association to Candidate
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference(value="candidate-obj")
	@JoinColumn(name="can_id")
	private Candidate candidate;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonBackReference(value="question-obj")
	private Question question;

	public Answer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}