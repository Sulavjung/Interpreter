package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class FalsebranchCode extends ByteCode{

	private String label;
	private int targetAddress;

	public FalsebranchCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		
		label = byteCodeLine.get(1);
	}

	@Override
	public void execute(VirtualMachine vm) {
		if(vm.getRunStack().pop() == 0){
			vm.setPC(targetAddress);
		}
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
		return "FALSEBRANCH " + label;
	}

	
}
