package fr.diginamic.services;

import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.helper.*;

public class SupprimerQuestionService extends MenuService{
	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) {
		Question questionToDelete;
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer.");
		int questionNbToDelete = LineHelper.getNextInt(scanner) - 1;
		questionToDelete = dao.findAll().get(questionNbToDelete);
		dao.delete(questionToDelete);		
	}
}
