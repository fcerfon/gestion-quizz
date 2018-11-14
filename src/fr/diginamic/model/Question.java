package fr.diginamic.model;

public class Question {
	private int id;
	private String intitule;
	private String[] propositions;
	private String bonneReponse;
	
	public Question(String question, int numberPossibleAnswers) {
		
		this.intitule = question;
		propositions = new String [numberPossibleAnswers];
	}
	
	public boolean verifierReponse(String answer) {
		if (bonneReponse == answer) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void addProposition(String newProposition) {
		propositions[id] = newProposition;
		id++;
	}
}
