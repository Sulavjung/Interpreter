package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class DmpCode extends ByteCode{

	private String dmpState; 

	public DmpCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		if(byteCodeLine.size() > 1){
			dmpState = byteCodeLine.get(1);
		}
	}

	@Override
	public void execute(VirtualMachine vm) {
		switch (dmpState) {
			case "-":
				vm.setIsDumping(false);
				return;
			
			case "+":
				vm.setIsDumping(true);
				return;

			default:
				throw new UnsupportedOperationException("Not a Valid Dump State");
		}
	}

	@Override
	public String toString() {
		return "DMP " + dmpState;
	}
	
}
