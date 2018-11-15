package fr.diginamic.console;

import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.model.Question;
import fr.diginamic.services.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class QuizzAdminConsoleApp {
	
	Scanner inputUser;
	MenuService[] menu;
	Scanner scanner;
	QuestionMemDao dao;
	
	private QuizzAdminConsoleApp() {
		this.inputUser = new Scanner(System.in);
		dao = new QuestionMemDao();
		scanner = new Scanner(System.in);
		
		menu = new MenuService[4];
		menu[0] = new ListerQuestionsService();
		menu[1] = new AjouterQuestionService();
		menu[2] = new SupprimerQuestionService();
		menu[3] = new ExecuterQuizzService();
	}
	
	private void printMenu() {
		System.out.println(
				"***** Quizz Administration *****\n" + 
				"1. Lister les questions\n" + 
				"2. Ajouter une nouvelle question\n" + 
				"3. Supprimer une question\n" + 
				"4. Exécuter le quizz\n" + 
				"99. Sortir"
		);
	}
	
	private void exit() {
		System.out.println("Au revoir");
	}
	
	private void printAnswer(int inputtedAnswer) {
		if (inputtedAnswer >= 1 && inputtedAnswer <= 4)
		menu[inputtedAnswer - 1].executeUC(scanner, dao);
	}
	
	private int getUserInput() {
		int inputtedAnswer = 0;
		Scanner scan = new Scanner(System.in);
		inputtedAnswer = Integer.parseInt(this.inputUser.nextLine());
		return inputtedAnswer;
	}
	
	public static void main(String[] args) {
		
		QuizzAdminConsoleApp quizz = new QuizzAdminConsoleApp();
		int inputedAnswer = 0;
		
		do {
			quizz.printMenu();
			inputedAnswer = quizz.getUserInput();
			quizz.printAnswer(inputedAnswer);
		} while (inputedAnswer != 99);
		
		quizz.exit();
	}
}