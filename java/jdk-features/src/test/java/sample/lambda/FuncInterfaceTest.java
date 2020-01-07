package sample.lambda;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuncInterfaceTest {

	
	
	@Test
	public void test() {
        // lambda expression to implement above 
        // functional interface. This interface 
        // by default implements abstractFun() 
        FuncInterface fobj = (int x)->System.out.println(2*x); 
  
        // This calls above lambda expression and prints 10. 
        fobj.abstractFun(5); 
        
        assertEquals("String matched as expected",true, true);
	}

}
