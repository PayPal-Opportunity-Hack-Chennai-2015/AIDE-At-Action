import static org.junit.Assert.*;

import java.util.Random;

public class Test {

  @org.junit.Test
  public void test() {
//    Random rand= new Random();
    int pick = new Random().nextInt(900) + 100;
    System.out.println(pick);
  }

}
