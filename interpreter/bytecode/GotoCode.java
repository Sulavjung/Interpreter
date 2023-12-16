package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class GotoCode extends ByteCode{

	private String label;
	private int targetAddress;

	public GotoCode(List<String> byteCodeLine) {
		super(byteCodeLine);

		label = byteCodeLine.get(1);
	}

	@Override
	public void execute(VirtualMachine vm) {
	
		vm.setPC(targetAddress);

	}
	


	public int getTargetAddress() {
		return targetAddress;
	}
	

	public void setTargetAddress(int targetAddress) {
		this.targetAddress = targetAddress;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return "GOTO " + label;
	}
	
}
