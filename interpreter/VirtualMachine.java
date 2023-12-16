package interpreter;

import java.util.Stack;

import interpreter.bytecode.ByteCode;
import interpreter.loader.Program;

public class VirtualMachine {
  private int pc;
  protected Stack<Integer> returnAddresses;
  private boolean isRunning;
  private boolean isDumping;
  protected Program program;
  protected RuntimeStack runStack;

  public VirtualMachine(Program program) {
    this.program = program;
    this.returnAddresses = new Stack<>();
    this.runStack = new RuntimeStack();
    this.isDumping = false;
  }

  public VirtualMachine(Program program, Stack<Integer> returnAddresses, RuntimeStack runStack) {
    this.program = program;
    this.returnAddresses = returnAddresses;
    this.runStack = runStack;
    this.isDumping = false;
  }

  public int getPC() {
    return this.pc;
  }

  public boolean getIsRunning() {
    return this.isRunning;
  }

  public boolean getIsDumping() {
    return this.isDumping;
  }

  public void setIsDumping(boolean dmpState){
    this.isDumping = dmpState;
  }

  public RuntimeStack getRunStack(){
    return this.runStack;
  }

  public void setPC (int targetAddress){
    pc = targetAddress;
  }

  public Stack<Integer> getReturnAddresses(){
    return this.returnAddresses;
  }

  public void setIsRunning(boolean isRunning){
    this.isRunning = isRunning;
  }

  public void executeProgram() {
    this.pc = 0;
    this.isRunning = true;

    

    while (this.isRunning) {
      ByteCode code = this.program.getCode(this.pc);
      code.execute(this);

      // This is where the DMP output should happen if DMP is on

      System.out.println(code.toString());

      if(isDumping){
        System.out.println(this.runStack.toString());
      }


      this.pc++;
    }
  }
}
