package org.pythonsogood;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.pythonsogood.interfaces.BinaryOperation;
import org.pythonsogood.operations.Add;
import org.pythonsogood.operations.Subtract;

public class Main {
	static HashMap<String, BinaryOperation> OPERATIONS = new HashMap<>(Map.of(
		"+", new Add(),
		"-", new Subtract()
	));

	static String OPERATIONS_PRETTY = String.join(", ", List.of("+", "-"));

	// https://stackoverflow.com/questions/14189162/get-name-of-running-jar-or-exe
	private static String getJarName() {
		return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getName();
	}

    public static void main(String[] args) {
		double initialValue = 0;

		if (args.length > 0) {
			if (args[0].equals("--help")) {
				System.out.println(String.format("Usage: java -jar %s initial_value\nWhere initial_value is an optional number.", getJarName()));
				return;
			} else {
				try {
					initialValue = Double.parseDouble(args[0]);
				} catch (NumberFormatException error) {
					System.out.println(String.format("Invalid initial value passed! Run to see help window:\njava -jar %s --help", getJarName()));
					return;
				}
			}
		}

        Calculator calculator = new Calculator(initialValue);

		Scanner scanner = new Scanner(System.in);
		System.out.println(String.format("Choose an operation:", Main.OPERATIONS_PRETTY));
		System.out.println("or type .exit to close program.");

		String userAction = scanner.nextLine();
		while (!userAction.equals(".exit")) {}
    }
}