package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode{

	public WriteCode(List<String> byteCodeLine) {
		super(byteCodeLine);

	}

	@Override
	public void execute(VirtualMachine vm) {
		System.out.println(vm.getRunStack().peek());
	}

	@Override
	public String toString() {
		return "WRITE";
	}
	
}
