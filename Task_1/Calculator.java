package Task_1;

import java.util.Scanner;

public class Calculator {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean run = true;
        int choice = 8;
        while (run == true) {
            System.out.println(
                    "\nCalculator CLI:\nSelect the operation\n1] Addition\n2] Subtraction\n3] Division\n4] Multiplication\n5] Modulus\n6] Square of Number\n7] Square root of Number\n8] Exit Program");

            try {
                System.out.print("Enter the Operation Number: ");
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Enter the Operation number.");
                break;
            }

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    subtract();
                    break;
                case 3:
                    devide();
                    break;
                case 4:
                    multiply();
                    break;
                case 5:
                    modulus();
                    break;
                case 6:
                    squareOfNumber();
                    break;
                case 7:
                    squareRootOfNumber();
                    break;
                case 8:
                    run = false;
                    System.out.println("Bye!");
                    break;

                default:
                    break;
            }

        }


    }

    private static void squareRootOfNumber() {
        System.out.print("Enter Number : ");
        double num1 = Double.parseDouble(input.nextLine());

        System.out.println("Square Root of " + num1 + " is: " + (Math.sqrt(num1)) );
    }

    private static void squareOfNumber() {
        System.out.print("Enter Number : ");
        double num1 = Double.parseDouble(input.nextLine());

        System.out.println("Square of " + num1 + " is: " + (num1*num1) );
    }

    private static void modulus() {
        System.out.print("Enter Number 1: ");
        double num1 = Double.parseDouble(input.nextLine());
        System.out.print("Enter Number 2: ");
        double num2 = Double.parseDouble(input.nextLine());

        System.out.println("Modulus -> " + (num1%num2) );
    }

    private static void multiply() {
                
        System.out.print("Enter Number 1: ");
        double num1 = Double.parseDouble(input.nextLine());
        System.out.print("Enter Number 2: ");
        double num2 = Double.parseDouble(input.nextLine());

        System.out.println("Division-> " + (num1*num2) );
    }

    private static void devide() {
        System.out.print("Enter Dividend: ");
        double num1 = Double.parseDouble(input.nextLine());
        System.out.print("Enter Divisor: ");
        double num2 = Double.parseDouble(input.nextLine());

        if(num2 == 0) {
            System.out.println("Divisor should not be Zero!!");
            devide();
        }else{
            System.out.println("Division-> " + (num1/num2) );
        }

    }

    private static void subtract() {
        
        System.out.print("Enter numbers 1: ");
        double num1 = Double.parseDouble(input.nextLine());;
        System.out.print("Enter numbers 2: ");
        double num2 = Double.parseDouble(input.nextLine());

        System.out.println("Subtraction -> " + (num1-num2) );
    }

    private static void add() {
        System.out.print("total numbers to add: ");
        int numbersToAdd = Integer.parseInt(input.nextLine().trim());
        
        int i = 0;
        double[] nums = new double[numbersToAdd];
        while (i < numbersToAdd) {
            System.out.print("Enter the number " + (i + 1) + " : ");
            nums[i] = Double.parseDouble(input.nextLine());
            i++;
        }

        double sum = 0.0;
        for (double j : nums) {
            sum += j;
        }

        System.out.println("Addition -> " + sum);

    }

}
