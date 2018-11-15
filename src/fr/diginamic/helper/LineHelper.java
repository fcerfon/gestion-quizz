package fr.diginamic.helper;

import java.util.Scanner;

public class LineHelper {
	
	public static int getNextInt(Scanner scanner) {
		String inputUser = scanner.nextLine();
		return Integer.parseInt(inputUser);
	}
}
