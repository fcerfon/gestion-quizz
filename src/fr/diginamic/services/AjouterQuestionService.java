package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.helper.*;

public class AjouterQuestionService extends MenuService {

	
	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) {
		int questionNumbers = 0;
		List<String> propositions = new ArrayList<String>();
		int goodAnswer = 0;
		String intitule = "";
		
		System.out.println("Veuillez saisir l'intitulé de la question :");
		intitule = scanner.nextLine();
		System.out.println("Veuillez saisir le nombre de questions : (exemple : 3)");
		questionNumbers = LineHelper.getNextInt(scanner);
		
		for (int i = 0 ; i < questionNumbers ; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°" + (i+1));
			propositions.add(scanner.nextLine());
		}
		
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et " + questionNumbers + " )");
		goodAnswer = LineHelper.getNextInt(scanner) - 1;
		
		Question newQuestion = new Question(intitule, questionNumbers);
		newQuestion.setPropositions(propositions);
		newQuestion.setBonneReponse(propositions.get(goodAnswer));
		
		dao.save(newQuestion);
	}
}
