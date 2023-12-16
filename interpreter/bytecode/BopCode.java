package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode{

	private String operator; 

	public BopCode(List<String> byteCodeLine) {
		super(byteCodeLine);

		if(byteCodeLine.size() > 1){
			operator = byteCodeLine.get(1);
		}

	}

	@Override
	public void execute(VirtualMachine vm) {

		int operand2 = vm.getRunStack().pop();
		int operand1 = vm.getRunStack().pop();


		int result = performBinaryOperation(operand1, operand2, operator);

		vm.getRunStack().push(result);
	}

	public int performBinaryOperation(int operand1, int operand2, String operator){
		switch (operator) {
			case "+":
				return operand1 + operand2;
			case "-":
				return operand1 - operand2;
			case "*":
				return operand1 * operand2;
			case "/":
				if(operand2 != 0){
					return operand1 / operand2;
				} else {
					throw new ArithmeticException("Division by zero");
				}

			case "==":
				return operand1 == operand2 ? 1 : 0;
			
			case "!=":
				return operand1 != operand2 ? 1 : 0;

			case "<=":
				return operand1 <= operand2 ? 1 : 0;

			case "<":
				return operand1 < operand2 ? 1 : 0;

			case ">":
				return operand1 > operand2 ? 1 : 0;
			case ">=":
				return operand1 >= operand2 ? 1 : 0;

			case "|":
				return operand1 | operand2;
			
			case "&":
				return operand1 & operand2;
			default:
				throw new UnsupportedOperationException("Unsupported binary exception");
		}
	}

	@Override
	public String toString() {
		return "BOP " + operator;
	}
	
}
