package interpreter.loader;

import java.util.HashMap;
import java.util.Map;

public class CodeTable {

  private static Map<String, String> codes = new HashMap<>();

  static {
    codes.put("LIT", "interpreter.bytecode.LitCode");
    codes.put("STORE", "interpreter.bytecode.StoreCode");
    codes.put("LOAD", "interpreter.bytecode.LoadCode");
    codes.put("POP", "interpreter.bytecode.PopCode");
    codes.put("BOP", "interpreter.bytecode.BopCode");
    codes.put("LABEL", "interpreter.bytecode.LabelCode");
    codes.put("GOTO", "interpreter.bytecode.GotoCode");
    codes.put("FALSEBRANCH", "interpreter.bytecode.FalsebranchCode");
    codes.put("ARGS", "interpreter.bytecode.ArgsCode");
    codes.put("CALL", "interpreter.bytecode.CallCode");
    codes.put("RETURN", "interpreter.bytecode.ReturnCode");
    codes.put("READ", "interpreter.bytecode.ReadCode");
    codes.put("WRITE", "interpreter.bytecode.WriteCode"); 
    codes.put("HALT", "interpreter.bytecode.HaltCode");
    codes.put("DMP", "interpreter.bytecode.DmpCode");
  }

  public static String get(String byteCode) {
    return codes.get(byteCode);
  }
}
