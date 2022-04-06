package com.demo.stack;

public class ValidParanthesis {

	public static void main(String[] args) {

		boolean isValid = isValidParanthesis("{{}[]}");
		System.out.println(isValid);
	}
	
	private static boolean isValidParanthesis(String input) {
		CustomStack<Character> customStack = new CustomStack<>();
		char[] charArr = input.toCharArray();
		for(int i=0; i<charArr.length;i++){
			char ch = charArr[i];
			if(ch == '{' || ch == '[' || ch == '(') {
				customStack.push(ch);
			}else {
				if(!customStack.isEmpty()) {
					char top = customStack.peek();
					if((ch == '}' && top=='{')  || (ch == ']' && top=='[') || (ch == ']' && top=='(')) {
						customStack.pop();
					}
				}else {
					return false;
				}
			}
		}
		return customStack.isEmpty();
	}

}
