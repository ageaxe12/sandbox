package leetcode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrintImmutableLinkedListReverseTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@Before
	public void setUpStreams() {
	    //System.setOut(new PrintStream(outContent));
	    //System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    //System.setOut(originalOut);
	    //System.setErr(originalErr);
	}
	@Test
	public void printReverseTest() {
		List<Integer> list = new ArrayList<Integer>(); 
		for(int i = 0; i< 20; i++ ) {
			list.add(i);
			System.out.print(MessageFormat.format("[{0}]-->", i));
		}	
	
		System.out.println("NULL");
		
		ImmutableListNode<Integer> node = new ImmutableListNodeImpl<Integer>().createImmutableList(list);
		
		
		new PrintImmutableLinkedListReverse().printLinkedListInReverse(node);

		System.out.println("NULL");
		
	
	}

}
