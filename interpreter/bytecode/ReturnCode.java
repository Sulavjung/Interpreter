package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode{
	private String label;
	private int returnValue;

	public ReturnCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		if(byteCodeLine.size() > 1){
			label = byteCodeLine.get(1);
		}
	}

	@Override
	public void execute(VirtualMachine vm) {
		returnValue = vm.getRunStack().peek();
		vm.getRunStack().popFrame();
		vm.getRunStack().push(returnValue);
		vm.setPC(vm.getReturnAddresses().pop());
	}

	@Override
	public String toString() {
		String baseId;
		String labelValue;
    	if (label != null && !label.isEmpty()) {
			String[] labelParts = label.split("<<");
			baseId = (labelParts.length > 1) ? labelParts[0] : label;
			labelValue = label;
    	} else {
    		 labelValue = " ";
			 baseId = " ";
    	}


		return String.format("%-25s%s", "RETURN " + labelValue , "end " + baseId + ": " + returnValue);
	}
	
}
