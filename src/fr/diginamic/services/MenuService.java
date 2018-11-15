package fr.diginamic.services;

import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;

import fr.diginamic.exception.StockageException;

import java.util.Scanner;

abstract public class MenuService {
	public abstract void executeUC(Scanner scanner, QuestionDao dao) throws StockageException;
}
