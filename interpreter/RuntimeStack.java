package interpreter;

import java.util.Stack;
import java.util.Vector;

public class RuntimeStack {

  private Stack<Integer> framePointers;
  private Vector<Integer> runStack;

  public RuntimeStack() {
    this.framePointers = new Stack<>();
    this.framePointers.push(0);
    this.runStack = new Vector<>();
  }

  

  public RuntimeStack(Stack<Integer> framePointers, Vector<Integer> runStack) {
    this.framePointers = framePointers;
    this.framePointers.push(0);
    this.runStack = runStack;
  }



  public int peek() {
    if(!runStack.isEmpty()){
      return runStack.lastElement();
    }
    throw new RuntimeException("Runtime runStack is empty");
  }

  public int pop() {
    if(!runStack.isEmpty()){
      return runStack.remove(runStack.size()-1);
    }
    throw new RuntimeException("Runtime runStack is empty");
  }

  public int push(int value) {
    runStack.add(value);
    return value;
  }

  public Integer push(Integer value) {
    runStack.add(value);
    return value;
  }

  public void newFrameAt(int offset) {
    framePointers.push(runStack.size() - offset);
  }

  public void popFrame() {
    if (!framePointers.isEmpty()) {
        int frameStart = framePointers.pop();

        while (runStack.size() > frameStart) {
            runStack.remove(runStack.size() - 1);
        }
    } else {
        throw new RuntimeException("Runtime framePointers is empty.");
    }
}


  public int store(int offset) {

    if(!runStack.isEmpty()){
      int value = pop();
      runStack.set(framePointers.peek() + offset, value);
      return value;
    }

    throw new RuntimeException("Runtime runstack is empty. ");
    
  }

  public int load(int offset) {

    if(!runStack.isEmpty()){
      int value = runStack.get(framePointers.peek() + offset);
      push(value);
      return value;
    }
    throw new RuntimeException("Runtime runstack is empty.");
  }



  @Override
  public String toString() {
    String result = "";

    for (int i = 0; i < framePointers.size(); i++) {
        int start = framePointers.get(i);
        int end = (i < framePointers.size() - 1) ? framePointers.get(i + 1) : runStack.size();

        result += "[";
        
        for (int j = start; j < end; j++) {
            result += runStack.get(j);
            if (j < end - 1) {
                result += ",";
            }
        }

        result += "]";

        if (i < framePointers.size() - 1) {
          result += " ";
      }
    }


    return result;
}

  

  
}
