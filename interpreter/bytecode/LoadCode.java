package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode{

	private int offset;
	private String id;

	public LoadCode(List<String> byteCodeLine) {
		super(byteCodeLine);
		if(byteCodeLine.size() > 1){
			this.offset = Integer.parseInt(byteCodeLine.get(1));
		}

		if(byteCodeLine.size() > 2){
			this.id = byteCodeLine.get(2);		
		}
	}

	@Override
	public void execute(VirtualMachine vm) {

		vm.getRunStack().load(offset);
	}

	@Override
	public String toString() {
		return String.format("%-25s%s", "LOAD " + offset + " " + id, "<load " + id + ">");
	}
	
}
