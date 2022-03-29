import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTestCase {

	@Test
	void test() {
		String input = IOTestHelper.getTestData("test_data_3.in.txt");
		
		String output = IOTestHelper.captureOutput(() -> JSpreadsheetMain.main(new String[] {}), input);
		
		String expected = IOTestHelper.getTestData("test_data_3.out.txt");
		
		assertEquals(expected, output);
	}

}
