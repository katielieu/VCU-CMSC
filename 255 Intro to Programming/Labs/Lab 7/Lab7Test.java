package Labs.Lab7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;



import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab7Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


	private Class classCheck(String newClass) {
		Class success = null;
		String trimedClass = newClass.substring(newClass.lastIndexOf(".") + 1).trim();
		try {
			success = Class.forName(newClass);
		} catch (ClassNotFoundException noClass) {
			fail(trimedClass + ".java not found. Did you name your file correctly?");
		}
		return success;
	}

	/**
	 * Invokes the main method of an unspecified class
	 * @param c the class to invoke main on
	 * @param args the list of arguments you wish to pass to the method
	 */
	@SuppressWarnings({"unchecked"})
	private void runStaticMethod(Class c, String methodName, Object ...args) {
		String className = c.getName();
		className = className.substring(className.lastIndexOf(".") + 1).trim();
		try {
			Class[] classes = new Class[args.length];
			for(int i = 0; i < classes.length; i++) {
				classes[i] = args[i].getClass();
			}
			c.getDeclaredMethod(methodName, classes).invoke(null, args);
		} catch (InvocationTargetException e) {
			fail("Method " + methodName + " did not compile correctly. Please double check your code.");
		} catch (Exception other) {
			//catch (NoSuchMethodException e)
			//catch (IllegalAccessException e)
			fail("Unanticipated error in your code. Please contact instructor before submitting again");
		}
	}

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void greetingTest() {
		Lab7.greeting("Prof.", "Zach", "Whitten");
		String rawOutput = outContent.toString();
		String[] outputLines = rawOutput.split("\r?\n");
		assertEquals("", outputLines[0]);
		assertEquals("Dear Prof. Zach Whitten,", outputLines[1]);
	}

	@Test
	public void max10and2Test() {
		int max = Lab7.max(10, 2);
		assertEquals(10, max);
	}

	@Test
	public void max2and10Test() {
		int max = Lab7.max(2, 10);
		assertEquals(10, max);
	}

	@Test
	public void max50and50Test() {
		int max = Lab7.max(50, 50);
		assertEquals(50, max);
	}

	@Test
	public void maxMinus10andMinus2Test() {
		int max = Lab7.max(-10, -2);
		assertEquals(-2, max);
	}

	@Test
	public void maxMinus2andMinus10Test() {
		int max = Lab7.max(-2, -10);
		assertEquals(-2, max);
	}

	@Test
	public void max0and0Test() {
		int max = Lab7.max(0, 0);
		assertEquals(0, max);
	}

	@Test
	public void sumTo2and10Test() {
		int max = Lab7.sumTo(2, 10);
		assertEquals(54, max);
	}

	@Test
	public void sumTo10and2Test() {
		int max = Lab7.sumTo(10, 2);
		assertEquals(54, max);
	}

	@Test
	public void sumTo50and50Test() {
		int max = Lab7.sumTo(50, 50);
		assertEquals(50, max);
	}

	@Test
	public void sumToMinus10andMinus2Test() {
		int max = Lab7.sumTo(-10, -2);
		assertEquals(-54, max);
	}

	@Test
	public void sumToMinus2andMinus10Test() {
		int max = Lab7.sumTo(-2, -10);
		assertEquals(-54, max);
	}

	@Test
	public void sumTo0and0Test() {
		int max = Lab7.sumTo(0, 0);
		assertEquals(0, max);
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}
}
