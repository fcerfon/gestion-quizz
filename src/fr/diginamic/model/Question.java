package fr.diginamic.model;

import java.util.List;

public class Question {
	private int id;
	private String intitule;
	private List<String> propositions;
	private String bonneReponse;
	
	public Question(String question, int numberPossibleAnswers) {
		
		this.intitule = question;
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
		propositions.add(newProposition);
		id++;
	}
	
	public String getIntitule() {
		return intitule;
	}
	
	public List<String> getPropositions() {
		return propositions;
	}
	
	public void setPropositions(List<String> propositions) {
		this.propositions = propositions;
	}
}
