package fr.diginamic.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.helper.*;

public class ExecuterQuizzService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) {

		int answer = 0;
		int score = 0;
		String answerStr = "";
		List<String> propositions;
		
		for (Question quest : dao.findAll()) {
			System.out.println(quest.getIntitule() + "\n");
			propositions = quest.getPropositions();
			for (int i = 0 ; i < propositions.size() ; i++) {
				System.out.println("\t -  " + propositions.get(i));
			}
			answer = LineHelper.getNextInt(scanner) - 1;
			System.out.println(propositions.get(answer));
			if (quest.verifierReponse(propositions.get(answer)) == true) {
				System.out.println("Bonne réponse");
				score++;
			}
			else {
				System.out.println("Mauvaise réponse");
			}
		}
		
		System.out.println("Fin du quiz\nVotre score : " + score);
	}
}
