package interpreter.bytecode;

import java.util.List;


import interpreter.VirtualMachine;

public class LitCode extends ByteCode{

	private int value;
	private String id; 

	public LitCode(List<String> byteCodeLine){
		super(byteCodeLine);

		if(byteCodeLine.size() > 1){
			this.value = Integer.parseInt(byteCodeLine.get(1));	
		}

		if(byteCodeLine.size() > 2){
			this.id = byteCodeLine.get(2);
		}
	}



	@Override
	public void execute(VirtualMachine vm) {

		vm.getRunStack().push(value);
	}



	@Override
public String toString() {
	if (id != null) {
		return String.format("%-25s%s",
            "LIT"+
            " " + value + " " + id,
            "int " + id + " = " + value);
	} else {
		return String.format("%-25s%s", "LIT" + " " + value , "int " + value);
	}
    
}

	
	
}
