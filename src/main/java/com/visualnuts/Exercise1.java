package com.visualnuts;

/**
 * @author carlosrodrigues
 */
public final class Exercise1 {

	public void execute() {

		loopNumbersUntilMaxRange();
	}

	private void loopNumbersUntilMaxRange() {

		for (int i = 1; i <= 100; i++) {

			if (i % 3 == 0 && i % 5 == 0) {

				System.out.println("Visual Nuts");

			} else if (i % 3 == 0) {

				System.out.println("Nuts");

			} else if (i % 5 == 0) {

				System.out.println("Visual");

			} else {

				System.out.println(i);
			}
		}
	}
}
