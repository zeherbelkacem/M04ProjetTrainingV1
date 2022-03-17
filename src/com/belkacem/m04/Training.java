package com.belkacem.m04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * @author Stagiaires11P
 *
 */

public class Training {
	/**	Training data structure **/
	private static Map<Integer, List<String>> trainings = new HashMap<Integer, List<String>>();
	/**	Bucket data structure **/
	private static Map<List<String>, Integer> bucket = new HashMap<List<String>, Integer>();
	/** I/O Streams */
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		insertDataInTrainingMap();
		/** Welcome store app message */
		System.out.print(ConsoleColors.BLACK_BOLD);
		System.out.println("                     Hello and welcome to my FullTrainings app");
		System.out.println("          We will offer you a list of training courses currently available");
		System.out.print(ConsoleColors.RESET);
		displayAllTrainingList();
		storeMenu();
		scanner.close();
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
	 */
	public static void displayAllTrainingList() {
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
		for (Entry<Integer, List<String>> map : trainings.entrySet()) {
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
	public static void displayAllTrainingListV2() {
		for (int i = 0; i < 120; i++)
			System.out.print("-");
		System.out.println();
		System.out.print(ConsoleColors.RED_BOLD);
		System.out.print(String.format("|%-18s|", "COURSE"));
		System.out.print(String.format("%-10s|", "DAYS/NB"));
		System.out.print(String.format("%-41s|", "DESCRIPTION"));
		System.out.print(String.format("%-10s|", "PRICE (€)"));
		System.out.print(String.format("%-35s|", "Buy traing?"));
		System.out.println();
		for (int i = 0; i < 120; i++)
			System.out.print("-");
		System.out.println(ConsoleColors.RESET);
		for (Map.Entry<Integer, List<String>> entry : trainings.entrySet()) {
			System.out.print(String.format("|%-18s|", entry.getValue().get(0)));
			System.out.print(String.format("%-10s|", entry.getValue().get(1)));
			System.out.print(String.format("%-41s|", entry.getValue().get(2)));
			System.out.print(String.format("%-10s|", entry.getValue().get(3)));
			System.out.print(ConsoleColors.GREEN);
			System.out.print(String.format("%-35s|", "To select this training, enter (" + entry.getKey() + ")"));
			System.out.print(ConsoleColors.RESET);
			System.out.println();
			for (int i = 0; i < 120; i++)
				System.out.print("-");
			System.out.println();
		}

	}

	/**
	 * 
	 */
	private static void storeMenu() {
		int menuChoice = -1;
		while (menuChoice != 0) {
			System.out.print(ConsoleColors.BLACK_BOLD);
			System.out.println("--------------------- STORE MENU --------------------");
			System.out.print(ConsoleColors.RESET);
			System.out.println("To view all the available trainings,        enter (1)");
			System.out.println("To add training to bucket,                  enter (2)");
			System.out.println("To show bucket,                             enter (3)");
			System.out.println("To remove product from bucket,              enter (4)");
			System.out.println("To exit,                                    enter (0)");
			System.out.println("-----------------------------------------------------");

			menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				displayAllTrainingList();
				break;
			case 2:
				addTrainingToBucket();
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				menuChoice = 0;
				break;
			default:
				System.out.println("Wrong entry, make a right choice!");
				;
			}

		}
	}

	/**
	 * 
	 */
	private static void addTrainingToBucket() {
		int quantity = 0;
		List<String> bucketList = new ArrayList<String>();
		displayAllTrainingListV2();
		System.out.println("Enter the  training's number please!");
		Integer choice = scanner.nextInt();
		System.out.println("choose the quantity for this training: ? 1,2,3,..");
		quantity += scanner.nextInt();
		bucketList.add(choice.toString());
		bucketList.addAll(trainings.get(choice));
		System.out.println(bucketList);
		if (bucket.containsKey(bucketList)) {
			bucket.put(bucketList, quantity+bucket.get(bucketList));
		}
		else {
			bucket.put(bucketList, quantity);
		}
		
		showBucket(bucket, choice);
		
	}

	/**
	 * 
	 * @param bucket2
	 */
	private static void showBucket(Map<List<String>, Integer> bucket2, int choice) {
		
		for (Entry<List<String>, Integer> entry : bucket2.entrySet()) {
			System.out.print(ConsoleColors.BLUE_BOLD);
			System.out.print("Product N°: "+entry.getKey().get(0)+" -> ");
			System.out.print(ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN);
			System.out.print(String.format("[%-60s]", entry.getKey().get(1)+", "+entry.getKey().get(2)+", "+entry.getKey().get(3)+", "+entry.getKey().get(4)));
			System.out.print(String.format("[%-15s]", " Qunatity -> (" + entry.getValue() + ")"));
			System.out.println(ConsoleColors.RESET);
			
		}
	}
}
