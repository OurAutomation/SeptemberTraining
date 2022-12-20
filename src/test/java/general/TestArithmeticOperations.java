package general;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.training.arithmeticFunctions.ArithmeticFunctions;

public class TestArithmeticOperations {
    @Test
    public void add() {
        int add = ArithmeticFunctions.add(1, 2);
        Assert.assertEquals(add,3);
    }
}
