package fr.diginamic.model;

import java.util.List;
import java.util.ArrayList;

import fr.diginamic.model.QuestionDao;

public class QuestionMemDao implements QuestionDao {
	
	private List<Question> questions;
	
	public QuestionMemDao() {
		questions = new ArrayList<Question>();
	}
	
	public List<Question> findAll() {
		return questions;
	};
	public void save(Question question) {
		questions.add(question);
	};
	public void delete(Question question) {
		questions.remove(question);
	};
}
