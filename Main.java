import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.*;

public class Main {

    private static int coefficient;
    private static int exponent;

    private static String equationVariable;

    private static char operator;
    private static ArrayList<Character> expression = new ArrayList();
    public static Scanner scnr = new Scanner(System.in);
    private static boolean continueExpression = true;
    private static int operatorIndex = 0;

    private static ArrayList<Term> singleTerm = new ArrayList<>();
    private static int termLength = 0;


    public static void main(String[] args) {
       // System.out.println("How many terms are the expression?");
        System.out.println("Enter your expression");
                termInput();

        }
  //  }
    /*
    public static void coefficientInput(){ // takes input of coefficient
        System.out.println("Enter the coefficient: ");
        coefficient = scnr.nextInt();
    }
    public static void exponentInput(){ // takes input of exponent
        System.out.println("Enter the exponent: ");
        char exponentOperator = scnr.next().charAt(0); // checks to see if ^ symbol is ued
        if (exponentOperator == '^') {
            System.out.println("test");
            exponent = scnr.nextInt();
        } else {
            exponent = 1;
            operator = exponentOperator; // if user doesn't use exponent and opts to use other operator, it will bypass step
        }
    }
    public static void variableInput(){ //variable input method
        System.out.println("Enter the variable: ");
        scnr.nextLine();
        equationVariable = scnr.nextLine();
        boolean loopBreak = true;
        while(loopBreak == true) {
            try { // checks for letter variable
                int testInt = Integer.parseInt(equationVariable);
                System.out.println("Enter a letter variable");
                equationVariable = scnr.nextLine();
            } catch (NumberFormatException numEx) {
                loopBreak = false;
            }
        }
    }

     */
    public static boolean operatorInput(ArrayList<Character> expression){

        for (int i = 0; i < expression.size(); i++) {
            if(expression.get(i) == '+'){
                operatorIndex = i;
                System.out.println(operatorIndex);
                break;
            } else if(expression.get(i) == '='){
                continueExpression = false;
                System.out.println("false");
                break;
            } else{

            }
        }
        return true;
        /*
        operator = expression.get(operatorIndex);
        if (operator == '+' || operator == '-') {
            return true;
        } else {
            return false;
        }

         */


    }

    public static void termInput(){
        coefficient = 0;
        expression.add('0'); // null value for initial term
        String userInput = scnr.nextLine();
        ArrayList<String> coefficientString = new ArrayList(); // arraylist for multiple digit coefficients
        coefficientString.add(""); // adds null value to coefficient arraylist
        boolean largeCoefficient = false;
        int variableIndex = 0;
        int startingIndex = 0;


        for (int i = startingIndex; i < userInput.length(); i++) { // parses through user input string and then adds each character to expression arraylist
            expression.add(userInput.charAt(i));
            if(userInput.charAt(i) == '+'){ // stops parsing through string when it finds the plus sign
                startingIndex = i+1;
                continueExpression = true;
                break;
            } else if (userInput.charAt(i) == '='){
                System.out.println("end");
                continueExpression = false;
            }
        }
        System.out.println(startingIndex);
            for (int i = 1; i < expression.size(); i++) { // takes the input of the variable
                if (expression.get(i) >= 'a' && expression.get(i) <= 'z') {
                    variableIndex = i;
                    break;
                }
            }
            for (int i = 1; i < expression.size(); i++) { //iterates through term and assigns to variables
                if (isDigit(expression.get(i)) && (expression.get(i - 1) != '^')) { // checks for coefficient
                    if (coefficient == 0) {
                        coefficient = getNumericValue(expression.get(i));
                    } else {
                        largeCoefficient = true;
                    }
                } else if (!isDigit(expression.get(i)) && isLetter(expression.get(i))) { // checks for variable
                    equationVariable = String.valueOf(expression.get(i));
                } else if (isDigit(expression.get(i)) && !(expression.get(i) == '=' || expression.get(i) == '+')) {
                    exponent = getNumericValue(expression.get(i));
                }
            }
            if (coefficient == 0) { // if no coefficient is inputted, 1 will automatically be assigned
                coefficient = 1;
            }
            if (largeCoefficient == true) { // if multiple digits in coefficient
                for (int j = 1; j < variableIndex; j++) {
                    String multipleDigits = String.valueOf(getNumericValue(expression.get(j)));
                    coefficientString.add(multipleDigits);
                }
                String stringCoefficient = "";
                for (int i = 1; i < coefficientString.size(); i++) {

                    stringCoefficient += (coefficientString.get(i));
                }
                coefficient = Integer.valueOf(stringCoefficient);
            } // final step in term, checks for operator, terminates if equal sign input

            Term derivTerm = new Term(coefficient, equationVariable, exponent);
            singleTerm.add(derivTerm);
            System.out.println(singleTerm.get(0).getCoefficient());
            termLength = singleTerm.size();


        System.out.println(coefficient);
        System.out.println(exponent);
            System.out.println(coefficient);
            System.out.println(exponent);
            System.out.println(derivTerm);
            derivTerm.display(derivTerm);
            derivTerm.createNewDerivative(derivTerm);



        /*
        coefficientInput();
        variableInput();
        exponentInput();
        operatorInput();
         */
    }

}

// try maybe creating a new array list for each separate term? that might be easier. so like it'll go up until the first
// operator, then it'll create an arraylist featuring all of those characters which the derivative can then be made from