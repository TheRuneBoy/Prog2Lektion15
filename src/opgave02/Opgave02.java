package opgave02;

import java.util.Stack;

public class Opgave02 {
    public static void main(String[] args) {
        System.out.println(checkParantes("(3+{5{99{*}}[23[{67}67]]})"));
        System.out.println(checkParantes("(}){"));

    }
    public static boolean checkParantes(String s){
        Stack<Character> stack = new Stack<>();

        for (char karakter : s.toCharArray()){
            if (karakter == '(' || karakter == '{' || karakter == '['){
                stack.push(karakter);
            } else if (karakter == ')' || karakter == '}' || karakter == ']') {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, karakter)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
