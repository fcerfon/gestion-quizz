package fr.diginamic.services;

import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.helper.*;
import fr.diginamic.exception.SupprimerQuestionException;

public class SupprimerQuestionService extends MenuService{
	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) throws SupprimerQuestionException {
		Question questionToDelete;
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer.");
		int questionNbToDelete = LineHelper.getNextInt(scanner) - 1;
		questionToDelete = dao.findAll().get(questionNbToDelete);
		if (questionToDelete == null) {
			throw new SupprimerQuestionException("Le numéro doit être comprit entre 1 et " + dao.findAll().size());
		}
		dao.delete(questionToDelete);		
	}
}
