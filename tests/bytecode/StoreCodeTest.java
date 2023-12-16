package tests.bytecode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;


import interpreter.bytecode.StoreCode;

public class StoreCodeTest {
  @Test
  public void testToStringWithIdentifier() {
    StoreCode code = new StoreCode(List.of("Store", "0", "zEd"));

    String expected = String.format("%-25s%s", "STORE 0 zEd", "zEd = 0");
    assertEquals(expected, code.toString());
  }

}
