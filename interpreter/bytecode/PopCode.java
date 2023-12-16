package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode{
	private int value; 

	public PopCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		
		if(byteCodeLine.size() > 1){
			value = Integer.parseInt(byteCodeLine.get(1));
		}
	}

	@Override
	public void execute(VirtualMachine vm) {

		for(int i = 0; i < value; i++){
			vm.getRunStack().pop();
		}
	}

	@Override
	public String toString() {
		return "POP " + value;
	}

	
}
