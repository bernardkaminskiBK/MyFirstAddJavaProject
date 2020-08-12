package sk.bernardkaminski.LotoKonzolApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LotoController {

	private Scanner vstup = new Scanner(System.in);
	private Set<Integer> selectedNumbers;
	private ArrayList<Integer> userNumbers;

	private static final int MAX = 90;
	private static final int MIN = 1;
	private static final String WIN_0 = "Tento raz ti to nevyšlo.";
	private static final String WIN_1 = "Máš 1 na lote, ale bohužial to nič neznamená.";
	private static final String WIN_2 = "Máš 2 na lote, ale bohužial stačí to iba na úsmev.";
	private static final String WIN_3 = "Máš 3 na lote, to už je niečo !";
	private static final String WIN_4 = "Máš 4 na lote, buď na seba hrdý !";
	private static final String WIN_5 = "Gratulujeme ! Máš 5 na lote.";
	private String genCisla;
	private String vysledokLosovania;

	private int selNum1;
	private int selNum2;
	private int selNum3;
	private int selNum4;
	private int selNum5;

	private int genNum1;
	private int genNum2;
	private int genNum3;
	private int genNum4;
	private int genNum5;

	public LotoController() {

	}

	public void Calculate() {
		try {
			System.out.println("           Loto");
			System.out.println("Zadaj 5 cisel medzi 1 a 90 !");
			selNum1 = vstup.nextInt();
			selNum2 = vstup.nextInt();
			selNum3 = vstup.nextInt();
			selNum4 = vstup.nextInt();
			selNum5 = vstup.nextInt();

			genNum1 = getRandomNumber();
			genNum2 = getRandomNumber();
			genNum3 = getRandomNumber();
			genNum4 = getRandomNumber();
			genNum5 = getRandomNumber();

			selectedNumbers = new HashSet<>();
			selectedNumbers.add(selNum1);
			selectedNumbers.add(selNum2);
			selectedNumbers.add(selNum3);
			selectedNumbers.add(selNum4);
			selectedNumbers.add(selNum5);

			if (selectedNumbers.size() < 5) {
				alert("Zadané čísla musia byť rozdielné !");
				genCisla = " ";
				return;
			} else {
				userNumbers = new ArrayList<Integer>(selectedNumbers);
				for (Integer number : userNumbers) {
					if (number < MIN || number > MAX) {
						alert("Všetky čísla musia byť v rozpäti medzi " + MIN + " a " + MAX + " !");
						vysledokLosovania = " ";
						return;
					}
				}
				resultCheck(userNumbers);
				genCisla = genNum1 + " " + genNum2 + " " + genNum3 + " " + genNum4 + " " + genNum5;
				System.out.println(genCisla);
			}
		} catch (Exception e) {
			alert("Zadal si nespravne cislo !");
		}
	}

	private void resultCheck(ArrayList<Integer> userNumbers) {
		int result = 0;
		for (int i = 0; i < userNumbers.size(); i++) {
			if (userNumbers.get(i) == genNum1 || userNumbers.get(i) == genNum2 || userNumbers.get(i) == genNum3
					|| userNumbers.get(i) == genNum4 || userNumbers.get(i) == genNum5) {
				result++;
			}
		}
		switch (result) {
		case 0:
			vysledokLosovania = WIN_0;
			break;
		case 1:
			vysledokLosovania = WIN_1;
			break;
		case 2:
			vysledokLosovania = WIN_2;
			break;
		case 3:
			vysledokLosovania = WIN_3;
			break;
		case 4:
			vysledokLosovania = WIN_4;
			break;
		case 5:
			vysledokLosovania = WIN_5;
			break;
		}
		System.out.println(vysledokLosovania);
	}

	private void alert(String text) {
		System.out.println(text);

	}

	private int getRandomNumber() {
		int random = (int) (Math.random() * MAX) + MIN;
		if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5) {
			return random;
		}
		return random;
	}

}
