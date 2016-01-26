import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Developed by Manas Rawat (Cyource)
public class Codebreaker {

    public static void main(String[] args) {
        List<String> randomList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            Integer randInt;
            if (i == 0) {
                randInt = rand.nextInt(9) + 1;
            } else {
                randInt = rand.nextInt(9);
            }
            String conv = randInt.toString();
            randomList.add(conv);
        }
        System.out.println("CYOURCE/CODEBREAKER\nPlease enter a 4 digit number and attempt to CRACK THE CODE."
                + "\nYou only have 12 chances.");
        Scanner scanner = new Scanner(System.in);
        boolean matcher = false;
        for (int j = 1; j <= 12; j++) {
            Integer integer = scanner.nextInt();
            String to = integer.toString();
            List<String> inputList = new ArrayList<>();
            if (integer.toString().matches("[0-9][0-9][0-9][0-9]")) {

                for (int i = 0; i < 4; i++) {
                    String it = to.substring(i, i + 1);
                    inputList.add(it);
                }
                Integer count = 0;
                String result;
                String string = "";
                if (randomList.equals(inputList)) {
                    result = null;
                    matcher = true;
                } else if (!Collections.disjoint(randomList, inputList)) {
                    for (int k = 0; k <= 3; k++) {
                        if (randomList.contains(inputList.get(k))) {
                            count++;
                        }
                    }
                    string = count.toString();
                    String print = " entered matching the digits in code";
                    if (count == 1) {
                        result = " digit" + print;
                    } else {
                        result = " digits" + print;
                    }
                } else {
                    result = "No digits matching.";
                }
                if (!matcher) {
                    System.out.println(string + result);
                    if (j < 11) {
                        System.out.println((12 - j) + " chances left.");
                    } else if (j == 11){
                        System.out.println((12 - j) + " chance left.");
                    } else {
                        System.out.println("No chances left");
                    }
                } else {
                    System.out.println("CODE CRACKED");
                    j = 12;
                }

            } else {
                System.out.println("Four-digit number not entered. " + (12 - j) + " chances left.");
            }
        }
        scanner.close();
        System.out.println("GAME OVER");
    }

}
