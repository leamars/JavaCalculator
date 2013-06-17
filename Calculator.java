package testScores;

import java.io.*;

public class Calculator {

  
	static boolean isInteger(char ch) {

		return Character.getNumericValue(ch) > 0;
	}
	
	public static void main (String[] args) {
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		
		try {
			String equation = br.readLine();
			char[] tokens = equation.toCharArray();
			int eqLength = equation.length();
			char[] operands = new char[500];
			int[] numbers = new int[500];
			
			int n = 0;
			int o = 0;
			String number = "";
			
			for (int j = 0; j < eqLength; j++) {

				if (isInteger(equation.charAt(j))){
				while (j < eqLength && isInteger(equation.charAt(j))) {
					number = number + equation.charAt(j);
					j++;
				}
					numbers[n] = Integer.parseInt(number);
					n++;
					j = j - 1;
					number = "";
				}
			
				else {
					operands[o] = tokens[j];
					o++;
				}
			}
			
			int num = numbers[0];
			int nextNum = numbers[1];
			
			
			for (int j = 0; j < operands.length; j++) {
				
				int k = j;
				
				switch(operands[j]) {
				case '+':
					num = num + nextNum;
					break;
				case '-':
					num = num - nextNum;
					break;
				case '*':
					if (nextNum == 0) {
						num = num * 1;
					}
					else {
						num = num * nextNum;
					}
					break;
				case '/':
					if (nextNum == 0) {
						num = num / 1;
					}
					else {
					num = num / nextNum;
					}
					break;
				default:
					break;
				}
				
				if (k+2 < numbers.length) {
				nextNum = numbers[k+2];
				}
				
			}
			
			System.out.println(num);
		} catch (IOException e) {
			System.out.println("Error");
		}
		
	}
}
