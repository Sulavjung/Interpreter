package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode{

	public HaltCode(List<String> byteCodeLine) {
		super(byteCodeLine);

	}


	@Override
	public void execute(VirtualMachine vm) {
		vm.setIsRunning(false);
		vm.getRunStack().popFrame();
	}

	@Override
	public String toString() {
		return "HALT";
	}
	
}
