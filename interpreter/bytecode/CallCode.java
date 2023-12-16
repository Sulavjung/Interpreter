package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class CallCode extends ByteCode{

	private String label;
	private int targetAddress;
	private int value;

	public CallCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		label = byteCodeLine.get(1);
	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.getReturnAddresses().push(vm.getPC());
		vm.setPC(targetAddress);
		value = vm.getRunStack().peek();
	}

	public String getLabel() {
		return label;
	}

	public void setFunctionName(String functionName) {
		this.label = functionName;
	}

	public int getTargetAddress() {
		return targetAddress;
	}

	public void setTargetAddress(int targetAddress) {
		this.targetAddress = targetAddress;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String baseId;
		String number;
    	if (label != null) {
			String[] labelParts = label.split("<<");
			
			baseId = (labelParts.length > 1) ? labelParts[0] : label;

			number = (labelParts.length > 1) ? labelParts[1].replace(">>", "") : " ";

    	} else {
    		 number = " ";
			 baseId = " ";
    	}

		return String.format("%-25s%s", "CALL " + label , baseId + "(" + value + "," + number + ")");
	}

	
}
