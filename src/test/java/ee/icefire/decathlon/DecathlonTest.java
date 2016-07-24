package ee.icefire.decathlon;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DecathlonTest {

	private Decathlon decathlon;

	@Before
	public void setUp() {
		decathlon = new Decathlon();
	}

	@Test
	public void testGetResultsOfAthletesFromFile() {

		decathlon.setFileName("");
		decathlon.getResultsOfAthletesFromFile();
		assertFalse(decathlon.isReadFromFileSuccess());

		String name = "RYyFajDbpjuP.csv";
		File file = new File(name);
		if (notExists(file)) {
			decathlon.setFileName(name);
			decathlon.getResultsOfAthletesFromFile();
			assertFalse(decathlon.isReadFromFileSuccess());
		}

		decathlon.setFileName("results.csv");
		decathlon.getResultsOfAthletesFromFile();
		assertTrue(decathlon.isReadFromFileSuccess());
	}

	@Test
	public void testNoResultFound() {
		String name = "ZZNw45kuurzX.csv";
		File file = new File(name);
		if (notExists(file)) {
			decathlon.setFileName(name);
			decathlon.getResultsOfAthletesFromFile();
			boolean noResultsFould = decathlon.getAthletes().size() == 0;
			assertTrue(noResultsFould);
		}
	}

	private boolean notExists(File file) {
		return !file.exists() || file.isDirectory();
	}

}
