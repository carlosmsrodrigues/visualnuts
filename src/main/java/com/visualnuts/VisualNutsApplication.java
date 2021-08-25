package com.visualnuts;

import java.util.Scanner;

/**
 * @author carlosrodrigues
 */
public class VisualNutsApplication {

	public static void main(String[] args) {

		menu();

		final Scanner input = new Scanner(System.in);

		int selection = input.nextInt();

		if (selection == 1) {

			final Exercise1 exercise1 = new Exercise1();
			exercise1.execute();

		} else if (selection == 2) {

			final Exercise2 exercise2 = new Exercise2();
			exercise2.execute();

		} else {

			System.out.println("Invalid option. Please insert valid values between 1 or 2");
		}
	}

	private static void menu() {

		System.out.println("Enter 1 to run exercise 1");
		System.out.println("Enter 2 to run exercise 2");
	}


}
