package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode{

	private int storeOffset;
	private String id;
	private int returnedValue;
	public StoreCode(List<String> byteCodeLine) {
		super(byteCodeLine);

		if(byteCodeLine.size() > 1){
			this.storeOffset = Integer.parseInt(byteCodeLine.get(1));
		}

		if(byteCodeLine.size() > 2){
			this.id = byteCodeLine.get(2);
		}
	}

	@Override
	public void execute(VirtualMachine vm) {
		returnedValue = vm.getRunStack().store(storeOffset);	
	}

	@Override
	public String toString(){
		return String.format("%-25s%s", "STORE " + storeOffset + " " + id, id + " = " + returnedValue );
	}
	
}
