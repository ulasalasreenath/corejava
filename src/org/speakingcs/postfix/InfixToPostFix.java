package org.speakingcs.postfix;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {

	public static void main(String[] args)
	{
		String infix = "";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter infix expression : ");
		infix = scanner.nextLine();
		
		String postfix = infixToPostFix(infix);
		System.out.println("Postfix expression is: " + postfix);
		
		System.out.println("Value of expression: " + evaluatePostfix(postfix));
		
		scanner.close();
		
	}

	private static int evaluatePostfix(String postfix) {

		Stack<Integer> aStack = new Stack<Integer>();
		
		int x, y;
		for(int i =0; i < postfix.length(); i++)
		{
			if(Character.isDigit(postfix.charAt(i))) 
			{
				aStack.push(Character.getNumericValue(postfix.charAt(i)));
			} else
			{
				x = aStack.pop();
				y = aStack.pop();
				
				switch(postfix.charAt(i)) {
				case '+' :
					aStack.push(x+y);
					break;
				case '-' :
					aStack.push(x-y);
					break;
				case '*' :
					aStack.push(x*y);
					break;
				case '%' :
					aStack.push(x%y);
					break;
				case '^' :
					aStack.push((int)Math.pow(x, y));
					break;
				}
				
			}
		}
		
		
		return aStack.pop();
	}

	private static String infixToPostFix(String infix) {
		
		String postfix = new String();
		
		Stack<Character> st = new Stack<Character>();
		Character next, symbol;
		
		for(int i = 0; i < infix.length(); i++)
		{
			
			symbol = infix.charAt(i);
			
			if(symbol == ' ' || symbol == '\t') {
				continue;
			}
			
			switch(symbol)
			{
			case '(' :
				st.push(symbol);
				break;
			case ')':
				while((next = st.pop()) != '(')
				{
					postfix = postfix + next;
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while(!st.isEmpty() && precedence(st.peek()) >= precedence(symbol)){
					postfix = postfix + st.pop();
				}
				st.push(symbol);
				break;
			default:
				postfix = postfix + st.pop();
			}
			
		}
		while(!st.isEmpty()){
			postfix = postfix + st.pop();
		}
		return postfix;
	}

	private static int precedence(Character symbol) {
		
		switch(symbol)
		{
		case '(':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '^':
			return 3;
		default :
			return 0;
		
		}
	}

}
