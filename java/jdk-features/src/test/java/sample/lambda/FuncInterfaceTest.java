package sample.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FuncInterfaceTest {

	
	
	@Test
	public void testLamdaExpressionSimple() {
        // lambda expression to implement above 
        // functional interface. This interface 
        // by default implements abstractFun() 
        FuncInterface fobj = (int x)-> {return x*x; }; 
  
        // This calls above lambda expression and prints 10. 
        assertEquals("Lambda Expression match",25, fobj.abstractFun(5));
	}

}
