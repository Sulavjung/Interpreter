package interpreter.loader;

import java.util.ArrayList;
import java.util.HashMap;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.CallCode;
import interpreter.bytecode.FalsebranchCode;
import interpreter.bytecode.GotoCode;
import interpreter.bytecode.LabelCode;

public class Program {

  private ArrayList<ByteCode> program;
  private static HashMap<String, Integer> labels = new HashMap<String, Integer>();

  
  public Program() {
    program = new ArrayList<ByteCode>();
  }

  public void addCode(ByteCode code) {

    if(code instanceof LabelCode){
      LabelCode label = (LabelCode)code;
      labels.put(label.getLabel(), program.size());
    }
    program.add(code);

  }

  public ByteCode getCode(int pc) {
    return program.get(pc);
  }

  public void resolveSymbolicAddresses() {

    Integer jumpAddress;

    for (int i = 0; i < program.size(); i++){
      if(program.get(i) instanceof CallCode){
        CallCode temporary = (CallCode)program.get(i);
        jumpAddress = labels.get(temporary.getLabel());
        temporary.setTargetAddress(jumpAddress.intValue());
      }
      if(program.get(i) instanceof GotoCode){
        GotoCode temporary = (GotoCode)program.get(i);
        jumpAddress = labels.get(temporary.getLabel());
        temporary.setTargetAddress(jumpAddress.intValue());
      }
      if(program.get(i) instanceof FalsebranchCode){
        FalsebranchCode temporary = (FalsebranchCode)program.get(i);
        jumpAddress = labels.get(temporary.getLabel());
        temporary.setTargetAddress(jumpAddress.intValue());
      }
    }
  }
}
