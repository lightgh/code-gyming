package com.chinakalight.oraclepractice.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 05/11/2020
 */
public class ScanInt1 {
    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("You typed the integer value: " + consoleScanner.nextInt());
    }
}

class ScanInt2 {
    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");
        Scanner consoleScanner = new Scanner(System.in);
        try {
            System.out.println("You typed the integer value: " + consoleScanner.nextInt());
        } catch (InputMismatchException ime) {
            System.out.println("Error: You typed some text that is not an integer value...");
        }
    }
}

class ScanInt3 {
    public static void main(String[] args) {
        String integerStr = "";
        System.out.println("The string to scan integer from it is: " + integerStr);
        Scanner consoleScanner = new Scanner(integerStr);

        try {
            System.out.println("The integer value scanned from string is: " +
                    consoleScanner.nextInt());
        } catch (InputMismatchException ime) {
            System.out.println("Error: Cannot scan an integer from the given string");
        }
    }
}

class ScanInt4 {
    public static void main(String[] args) {
        String integerStr = "";
        System.out.println("The string to scan integer from it is: " + integerStr);
        Scanner consoleScanner = new Scanner(integerStr);
        consoleScanner.close();
        try {
            System.out.println("The integer value scanned from string is: " + consoleScanner.nextInt());
        } catch (InputMismatchException ime) {
            System.out.println("Error: Cannot scan an integer from the given string");
        } catch (NoSuchElementException nsee) {
            System.out.println("Error: Cannot scan an integer from the given string");
        } catch (IllegalStateException ise) {
            System.out.println("Error: nextInt() called on a closed Scanner object");
        }
    }
}

class ScanInt5 {
    public static void main(String[] args) {
        String integerStr = "";
        System.out.println("The string to scan integer from it is: " + integerStr);
        Scanner consoleScanner = new Scanner(integerStr);

        try {
            System.out.println("The integer value scanned from string is: " +
                    consoleScanner.nextInt());
        } catch (NoSuchElementException | IllegalStateException multie) {
            System.out.println("Error: An error occured while attempting to scan the integer");
        }
    }
}

class ScanInt6 {
    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");
        Scanner consoleScanner = new Scanner(System.in);
        try {
            System.out.println("You typed the integer value: " + consoleScanner.nextInt());
            System.out.println("Done reading the text... closing the Scanner");
            consoleScanner.close();
        } catch (Exception e) {
            System.out.println("Error: Encountered an exception and could not read an integer from the console...");
            System.out.println("Exiting the program - restart and try the program again!");
        }
    }
}

class ScanInt7 {
    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");
        Scanner consoleScanner = new Scanner(System.in);

        try {
            System.out.println("You typed integer value: " + consoleScanner.nextInt());
        } catch (Exception e) {
            System.out.println("Error: Encountered an exception and could not read an integer from the console...");
            System.out.println("Exiting the program - restart and try the program again!");
        } finally {
            System.out.println("Done reading the integer... closing the Scanner");
            consoleScanner.close();
        }

        System.out.println("VALUE: " + returnTest());
    }

    static boolean returnTest() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}

class ThrowClause1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Reading an integer from the file 'integer.txt'");
        Scanner consoleScanner = new Scanner(new File("integer.txt"));
        System.out.println("You typed the integer value: " + consoleScanner.nextInt());
    }

}

class ThrowClause2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Reading an integer from the file 'integer.txt'");
        Scanner consoleScanner = new Scanner(new File("integer.txt"));
        System.out.println("You typed the integer value: " + consoleScanner.nextInt());
    }

}

class ThrowClause3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Reading an integer from the file 'integer.txt'");
        System.out.println("You typed the integer value: " + new ThrowClause3().readIntFromFile());
    }

    private int readIntFromFile() throws FileNotFoundException {
        Scanner consoleScanner = new Scanner(new File("integer.txt"));
        return consoleScanner.nextInt();
    }
}

interface IntReader {
    int readIntFromFile() throws IOException;
}


class ThrowClause4 implements IntReader {
    public int readIntFromFile() throws FileNotFoundException {
        Scanner consoleScanner = new Scanner(new File("integer.txt"));
        return consoleScanner.nextInt();
    }

    public static void main0(String[] args) throws FileNotFoundException {
        System.out.println("Reading an integer from the file 'integer.txt'");
        System.out.println("You typed the integer value: " + new ThrowClause4().readIntFromFile());
    }

    public static void main(String[] args) {
        System.out.println(iscontainNumbersOnly("1"));
        System.out.println(iscontainNumbersOnlyDup("1"));
    }

    public static boolean iscontainNumbersOnly(String source) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^[0-9]+.*[0-9]+"); //correct pattern for both float and integer.
//        pattern = Pattern.compile("\\d+.\\d+"); //correct pattern for both float and integer.

        result = pattern.matcher(source).matches();
        return result;
    }

    public static boolean iscontainNumbersOnlyDup(String source) {
        boolean result = false;
        result = source.matches("^[0-9]+.*[0-9]+");
        return result;
    }
}


