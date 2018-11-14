package fr.diginamic.console;

import java.util.Scanner;
import fr.diginamic.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizzAdminConsoleApp {
	
	Scanner inputUser;
	ArrayList<Question> quiz;
	
	private QuizzAdminConsoleApp() {
		this.inputUser = new Scanner(System.in);
		quiz = new ArrayList<Question>();
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
	
	private void showListQuestion() {
		int i = 1;
		System.out.println(quiz.size());
		for (Question question : quiz) {
			System.out.println(i + ") ");
			System.out.println(question.getIntitule() + "\n");
			ArrayList<String> propositions = (ArrayList)question.getPropositions();
			for (String proposition : propositions) {
				System.out.println("\t - \t" + proposition);
			}
			i++;
		}
	}
	
	private String getNextLine()
	{
		return this.inputUser.nextLine();
	}
	
	private int getNextInt() {
		String inputUser = getNextLine();
		return Integer.parseInt(inputUser);
	}
	
	private void addQuestion() {
		
		int questionNumbers = 0;
		List<String> propositions = new ArrayList<String>();
		int goodAnswer = 0;
		String intitule = "";
		
		System.out.println("Veuillez saisir l'intitulé de la question :");
		intitule = this.inputUser.nextLine();
		System.out.println("Veuillez saisir le nombre de questions : (exemple : 3)");
		questionNumbers = Integer.parseInt(this.inputUser.nextLine());
		
		for (int i = 0 ; i < questionNumbers ; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°" + (i+1));
			propositions.add(getNextLine());
		}
		
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et 3)");
		goodAnswer = getNextInt();
		
		Question newQuestion = new Question(intitule, questionNumbers);
		quiz.add(newQuestion);
		newQuestion.setPropositions(propositions);
	}
	
	private void printAnswer(int inputtedAnswer) {
		switch (inputtedAnswer) {
			case 1 :
				showListQuestion();
				break;
			case 2 :
				addQuestion();
				break;
			case 3 :
				System.out.println("Suppression d'une question");
				break;
			case 4 :
				System.out.println("Exécution du quizz");
				break;
		}
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