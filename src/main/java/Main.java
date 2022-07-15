import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class loopAgain {
    public static boolean bool;
}

public class Main {
    public static void main(String[] args) throws IOException {
        // Ask user if they want to restore list of ppl from file.

        loopAgain.bool = true;
        Scanner scanner = new Scanner(System.in);
        // This is where I store my newly created people
        List<Person> personList = new ArrayList<>();
        // This is where I'm gonna store my stringified people
        StringBuffer stringBufferPeople = new StringBuffer();
        while (loopAgain.bool == true) {

            // We are asking user if they want to restore data file
            Logger.getInstance().log("Restore or nah?");
            // 1 -> read from data file to fill container
            // 2 -> reinitialize data file (Making a new file)

            Logger.getInstance().log(
                    "Choose one of three options: \n 1. Add a person to the list. \n 2. Print a list of current persons. \n 3. Exit the program.");
            int response = scanner.nextInt();
            scanner.nextLine();

            switch (response) {
                case 1:
                    Logger.getInstance().log("What is the person's first name?");
                    String inputFirstName = scanner.nextLine();
                    Logger.getInstance().log("What is the person's last name?");
                    String inputLastName = scanner.nextLine();
                    Logger.getInstance().log("What is the person's birth year?");
                    int inputBirthYear = scanner.nextInt();
                    Logger.getInstance().log("What is the person's birth month?");
                    int inputBirthMonth = scanner.nextInt();
                    Logger.getInstance().log("What is the person's birth day?");
                    int inputBirthDay = scanner.nextInt();

                    Person createdPerson = createPerson(inputFirstName, inputLastName, inputBirthYear, inputBirthMonth, inputBirthDay);

                    personList.add(createdPerson);

            }

            for (Person person : personList) {
                stringBufferPeople.append(person.toString() + "\n");
            }

            Logger.getInstance().log(stringBufferPeople.toString());
            writeToFile("peopleList.data", stringBufferPeople.toString());

            // Logger.getInstance().log(readFromFile("peopleList.data",true));

        }
    }

    // Make a person from user input

    public static Person createPerson(String inputFirstName, String inputLastName, int inputBirthYear,
            int inputBirthMonth, int inputBirthDay) {
        Person customPerson = new Person(inputFirstName, inputLastName, inputBirthYear, inputBirthMonth, inputBirthDay);
        return customPerson;
    }

    static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null)
                fileWriter.close();
        }
    }

    static String readFromFile(String fileName, boolean addNewLine) throws IOException {
        String returnString = new String();
        Scanner fileReader = null;
        try {
            File myFile = new File(fileName);
            fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine()) {
                returnString += fileReader.nextLine();
                if (addNewLine)
                    returnString += "\n";
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileReader != null)
                fileReader.close();
        }

        return returnString;
    }

    // public String
    // Printing list of current persons
    // Print person info for each person on ur current list
    // return user to 3 options

    // Exist program; on exist save all persons on your list to your file
}
