package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.List;

public class LabelCode extends ByteCode {
    private String label;

    public LabelCode(List<String> byteCodeLine) {
        super(byteCodeLine);

        if (byteCodeLine.size() > 1) {
            label = byteCodeLine.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        // Labels do not perform any action during execution
        // They are used as markers for branching instructions
    }

    

    @Override
    public String toString() {
        return "LABEL " + label;
    }

	public String getLabel() {
		return label;
	}

}