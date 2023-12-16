package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode{

	private int argsValue;

	public ArgsCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		
		if(byteCodeLine.size()>1){
			argsValue = Integer.parseInt(byteCodeLine.get(1));
		}
	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.getRunStack().newFrameAt(argsValue);
	}

	@Override
	public String toString() {
		return "ARGS " + argsValue;
	}
	
}
