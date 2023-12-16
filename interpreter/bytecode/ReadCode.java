package interpreter.bytecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import interpreter.VirtualMachine;

public class ReadCode extends ByteCode{

	public ReadCode(List<String> byteCodeLine) {
		super(byteCodeLine);

	}

	@Override
	public void execute(VirtualMachine vm) {
		
		System.out.println("Please enter an integer: ");

		try {
			BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
			String line = input.readLine();
			vm.getRunStack().push(Integer.parseInt(line));		
		} catch (IOException e) {
			
		}
	}
	
}
