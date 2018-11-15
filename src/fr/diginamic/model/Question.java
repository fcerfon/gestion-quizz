package fr.diginamic.model;

import fr.diginamic.model.TypeQuestion;
import java.util.List;

public class Question {
	private int id;
	private String intitule;
	private List<String> propositions;
	private String bonneReponse;
	private TypeQuestion type;
	
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
	
	public void setBonneReponse(String answer) {
		this.bonneReponse = answer;
	}
	
	public TypeQuestion getType() {
		return type;
	}
	
	public void setType(TypeQuestion type) {
		this.type = type;
	}
}
