package fr.diginamic.console;

import java.util.Scanner;

public class QuizzAdminConsoleApp {
	
	Scanner inputUser;
	
	private QuizzAdminConsoleApp() {
		this.inputUser = new Scanner(System.in);
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
		switch (inputtedAnswer) {
			case 1 :
				System.out.println("Liste des questions");
			case 2 :
				System.out.println("Ajout d'une nouvelle question");
			case 3 :
				System.out.println("Suppression d'une question");
			case 4 :
				System.out.println("Exécution du quizz");
		}
	}
	
	private int getUserInput() {
		int inputtedAnswer = 0;
		Scanner scan = new Scanner(System.in);
		inputtedAnswer = this.inputUser.nextInt();
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