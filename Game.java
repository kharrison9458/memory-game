import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Game { //referenced youtube channel Debug Agent 
    private static final String WORD = "LYMPH";
    private static final String[] DICTIONARY = {"CRATE", "USING", "LYMPH", "LUMPS", "LOOMS"};
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("WordleDictionary.txt");
        Scanner wordleDictionary;  //reference Stack OverFlow
        //thinking: getting Strings from txt file and putting in array. 
        try {
            wordleDictionary = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String data = " ";
        while (wordleDictionary.hasNextLine()) {
            data += wordleDictionary.nextLine();
        }

        String[] dataArray = data.split(",");

        String[] array = new String[dataArray.length];

        for (int i = 0; i < dataArray.length; i++) {
            array[i] = dataArray[i];
        }


        System.out.println("Write a guess:");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        for(String line = scanner.nextLine() ; line != null ; line = scanner.nextLine()) {
            if(line.length() != 5) {
                System.out.println("5 characters only... Please try again:");
                continue;
            }
            line = line.toUpperCase();
            if(line.equals(WORD)) {
                System.out.println("Success!!!");
                return;
            }
            if(!isInDictionary(line)) {
                System.out.println("Word not in dictionary... Try again:");
            } else {
                attempts++;
                printWordResult(line);
                if(attempts > 7) {
                    //System.out.println("Game over! The word was" + );
                    return;
                }
            }
        }

    }

    private static void printWordResult(String word) {
        for(int iter = 0 ; iter < word.length() ; iter++) {
            char currentChar = word.charAt(iter);
            if(currentChar == WORD.charAt(iter)) {
                System.out.print("G"); // Green
                continue;
            }
            if(WORD.indexOf(currentChar) > -1) {
                System.out.print("Y"); // Yellow
                continue;
            }
            System.out.print("B"); // Black
        }
        System.out.println();
    }

    private static boolean isInDictionary(String word) {
        for(String current : wordleDictionary) {
            if(current.equals(word)) {
                return true;
            }
        }
        return false;
    }
}