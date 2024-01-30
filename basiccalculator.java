package basiccalculator;
import java.util.Scanner;

		public class basiccalculator {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            try {
		                System.out.print("Enter first number: ");
		                double num1 = scanner.nextDouble();

		                System.out.print("Enter operator (-, +, *, /): ");
		                char operator = scanner.next().charAt(0);

		                System.out.print("Enter second number: ");
		                double num2 = scanner.nextDouble();

		                double result;

		                switch (operator) {
		                    case '+':
		                        result = add(num1, num2);
		                        break;
		                    case '-':
		                        result = subtract(num1, num2);
		                        break;
		                    case '*':
		                        result = multiply(num1, num2);
		                        break;
		                    case '/':
		                        result = divide(num1, num2);
		                        break;
		                    default:
		                        System.out.println("Invalid operator");
		                        continue; 
		                }

		                System.out.println("Result: " + result);

		            } catch (Exception e) {
		                System.out.println("Error: " + e.getMessage());
		                scanner.nextLine();
		            }

		            System.out.print("Do you want to perform another calculation? (yes/no): ");
		            String anotherCalculation = scanner.next().toLowerCase();
		            if (!anotherCalculation.equals("yes")) {
		                break;
		            }
		        }

		        scanner.close();
		    }

		    private static double add(double x, double y) {
		        return x + y;
		    }

		    private static double subtract(double x, double y) {
		        return x - y;
		    }

		    private static double multiply(double x, double y) {
		        return x * y;
		    }

		    private static double divide(double x, double y) {
		        if (y != 0) {
		            return x / y;
		        } else {
		            System.out.println("Cannot divide by zero");
		            return Double.NaN; 		        }
		    }
	}

