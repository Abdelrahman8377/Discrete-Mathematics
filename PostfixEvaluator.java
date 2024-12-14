public class PostfixEvaluator {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char token : expression.toCharArray()) {
            if (Character.isDigit(token)) {
                // If token is a digit, convert it to integer and push onto stack
                stack.push(token - '0');
            } else if (isOperator(token)) {
                // If token is an operator, pop two operands and perform operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(token, operand1, operand2);
                stack.push(result);
            }
        }

        // The stack should now contain only one element, which is the final result
        return stack.pop();
    }

    private static boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    private static int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "52+3*5";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);  // Output: 5
    }
}
