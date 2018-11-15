package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.model.TypeQuestion;
import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.helper.*;

public class AjouterQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) throws AjouterQuestionException {
		int questionNumbers = 0;
		List<String> propositions = new ArrayList<String>();
		int goodAnswer = 0;
		String intitule = "";
		
		System.out.println("Veuillez saisir l'intitulé de la question :");
		intitule = scanner.nextLine();
		System.out.println("Veuillez saisir le nombre de questions : (exemple : 3)");
		
		try {
			questionNumbers = LineHelper.getNextInt(scanner);
		} catch (NumberFormatException e) {
			throw new AjouterQuestionException("Veuillez entrer un nombre.");
		}
		
		if (questionNumbers < 2) {
			throw new AjouterQuestionException("Au moins deux réponses sont nécessaires.");
		}
		
		for (int i = 0 ; i < questionNumbers ; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°" + (i+1));
			propositions.add(scanner.nextLine());
		}
		
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et " + questionNumbers + " )");
		try {
			goodAnswer = LineHelper.getNextInt(scanner);
		} catch (NumberFormatException e) {
			throw new AjouterQuestionException("Veuillez mettre un numéro entre 1 et " + questionNumbers + ".");
		}
		
		if (goodAnswer < 1 || goodAnswer > questionNumbers) {
			throw new AjouterQuestionException("Veuillez mettre un numéro entre 1 et " + questionNumbers + ".");
		}
		
		System.out.println("Cette question est-elle simple ou bonus ?");
		String bonusQuestion = scanner.nextLine();
		
		Question newQuestion = new Question(intitule, questionNumbers);
		
		try {
			newQuestion.setType(TypeQuestion.valueOf(bonusQuestion.toUpperCase()));
		} catch (IllegalArgumentException e) {
			throw new AjouterQuestionException("Veuillez répondre par simple ou bonus");
		}
		
		newQuestion.setPropositions(propositions);
		newQuestion.setBonneReponse(propositions.get(goodAnswer - 1));
		
		dao.save(newQuestion);
	}
}
