package com.belkacem.m04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * 
 * @author Stagiaires11P
 *
 */

public class Training {
	/**
	 * 
	 */
	private static Map<Integer, List<String>> trainings = new HashMap<Integer, List<String>>();

	/** I/O Streams */

	public static void main(String[] args) {
		insertDataInTrainingMap();
		/** Welcome store app message */
		System.out.print(ConsoleColors.BLACK_BOLD);
		System.out.println("                     Hello and welcome to my FullTrainings app");
		System.out.println("          We will offer you a list of training courses currently available");
		System.out.print(ConsoleColors.RESET);
		displayAllTrainingList(trainings);
	}

	/**
	 * 
	 */
	private static void insertDataInTrainingMap() {
		String[] training1Array = { "JAVA", "20", "Java SE 8: sysntax, oop", "100" };
		String[] training2Array = { "ADVANCED JAVA", "20", "Exceptions, files, thread, jcdb...", "100" };
		String[] training3Array = { "C#", "15", "DotNet Core", "200" };
		String[] training4Array = { "SPRING", "15", "Spring core/mvc/security", "300" };
		String[] training5Array = { "PHP FRAMEWORKS", "20", "Symphony", "150" };
		trainings.put(1, Arrays.asList(training1Array));
		trainings.put(2, Arrays.asList(training2Array));
		trainings.put(3, Arrays.asList(training3Array));
		trainings.put(4, Arrays.asList(training4Array));
		trainings.put(5, Arrays.asList(training5Array));

	}

	/**
	 * 
	 * @param training
	 */
	public static void displayAllTrainingList(Map<Integer, List<String>> training) {
		/*
		 * Define the table header elements (box sizes, box titles)
		 */
		// 1- Boxes sizes
		String courseHeader = new String("COURSE             ");
		String daysNumberHeader = new String("DAYS/NB  ");
		String desciptionHeader = new String("DESCRIPTION                               ");
		String priceHeader = new String("PRICE (€) ");
		int[] headerColumnsSize = { courseHeader.length(), daysNumberHeader.length(), desciptionHeader.length(),
				priceHeader.length() };

		// Dipslay the table header
		int headerLength = courseHeader.length() + daysNumberHeader.length() + desciptionHeader.length()
				+ priceHeader.length() + 5; // 5 is the number of the table columns + 1
		System.out.print(ConsoleColors.RED_BOLD);
		for (int i = 0; i < headerLength; i++)
			System.out.print("-");
		System.out.println();
		System.out.println(
				"|" + courseHeader + "|" + daysNumberHeader + "|" + desciptionHeader + "|" + priceHeader + "|");
		for (int i = 0; i < headerLength; i++)
			System.out.print("-");
		System.out.print(ConsoleColors.RESET);//
		System.out.println();

		/*
		 * Display the table body
		 */
		// Browse the training HashMap
		for (Entry<Integer, List<String>> map : training.entrySet()) {
			System.out.print("|");
			// Browse HashMap Value
			for (int i = 0; i < map.getValue().size(); i++) {
				System.out.print(map.getValue().get(i));
				for (int j = 0; j < headerColumnsSize[i] - map.getValue().get(i).length(); j++)
					System.out.print(" "); // fill column ????
				System.out.print("|"); // Draw next column border
			}

			System.out.println();
			for (int i = 0; i < headerLength; i++)
				System.out.print("-");// Draw next line
			System.out.println();
		}
	}

	/**
	 * 
	 * @param researchePlanes
	 */
	public static void displayAllTrainingList2(Map<Integer, List<String>> trainings) {
		for (int i = 0; i < 83; i++)
			System.out.print("-");
		System.out.println();
		System.out.print(ConsoleColors.RED_BOLD);
		System.out.print(String.format("|%-18s|", "COURSE"));
		System.out.print(String.format("%-10s|", "DAYS/NB"));
		System.out.print(String.format("%-41s|", "DESCRIPTION"));
		System.out.print(String.format("%-10s|", "PRICE (€)"));
		System.out.println();
		for (int i = 0; i < 83; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		for (Map.Entry<Integer, List<String>> entry : trainings.entrySet()) {
			System.out.print(String.format("|%-18s|", entry.getValue().get(0)));
			System.out.print(String.format("%-10s|", entry.getValue().get(1)));
			System.out.print(String.format("%-41s|", entry.getValue().get(2)));
			System.out.print(String.format("%-10s|", entry.getValue().get(3)));
			System.out.println();
			for (int i = 0; i < 83; i++)
				System.out.print("-");
			System.out.println();
		}

	}

}
