package interpreter.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;


import interpreter.bytecode.ByteCode;



public class ByteCodeLoader {


  Program program = new Program();
  private BufferedReader byteCodeFileReader;

  public ByteCodeLoader(String byteCodeFilePath) throws IOException {
   byteCodeFileReader = new BufferedReader(new FileReader(byteCodeFilePath));
  }

  public Program loadCodes() throws ByteCodeLoaderException {
    try  {
      ArrayList<String> codeLine = new ArrayList<String>();
      String code = byteCodeFileReader.readLine();


      while (code != null) {

        codeLine.clear();

        StringTokenizer tokeniser = new StringTokenizer(code);

        String saveToken = tokeniser.nextToken();


        if(saveToken != null){
          String classIdentifier = CodeTable.get(saveToken);

          codeLine.add(saveToken);

          while (tokeniser.hasMoreTokens()) {
            codeLine.add(tokeniser.nextToken());
          }



          
            if(classIdentifier != null){
              Class<?> codeClass = Class.forName(classIdentifier);

              Constructor<?> constructor = codeClass.getConstructor(List.class);
              
              ByteCode byteCodeClass = (ByteCode) constructor.newInstance(codeLine);


              if(byteCodeClass instanceof ByteCode){
                program.addCode(byteCodeClass);
              }
            }
              code = byteCodeFileReader.readLine();
            
        }
      }
      
    } catch (Exception e) {
      throw new ByteCodeLoaderException("Line");
    }
    program.resolveSymbolicAddresses();
    return program;
  }
}
