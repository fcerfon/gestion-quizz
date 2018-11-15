package fr.diginamic.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;

public class ListerQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) {
		List<Question> questions;
		List<String> propositions;
		Question question;
		
		questions = dao.findAll();
		for (int i = 0; i < questions.size() ; i++) {
			
			question = questions.get(i);
			
			System.out.println((i + 1) + ") ");
			System.out.println(question.getIntitule() + "\n");
			
			propositions = question.getPropositions();
			for (int j = 0 ; j < propositions.size() ; j++) {
				System.out.println("\t - \t" + propositions.get(j));
			}
			i++;
		}
	}
}
