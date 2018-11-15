package fr.diginamic.services;

import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;

import java.util.Scanner;

abstract public class MenuService {
	public abstract void executeUC(Scanner scanner, QuestionDao dao);
}
