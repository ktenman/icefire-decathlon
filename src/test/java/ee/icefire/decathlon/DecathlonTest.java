package ee.icefire.decathlon;

import ee.icefire.decathlon.objects.Athlete;
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

		File file = new File("RYyFajDbpjuP.csv");
		if (!fileExists(file)) {
			decathlon.setFileName("RYyFajDbpjuP.csv");
			decathlon.getResultsOfAthletesFromFile();
			assertFalse(decathlon.isReadFromFileSuccess());
		}

		decathlon.setFileName("results.csv");
		decathlon.getResultsOfAthletesFromFile();
		assertTrue(decathlon.isReadFromFileSuccess());
	}

	@Test
	public void testNoResultFound() {
		String name = "results.csv";
		File file = new File(name);
		for (Athlete athlete : decathlon.getAthletes()) {
			System.out.println(athlete);
		}
		//if (notExists(file)) {
			decathlon.setFileName(name);
			decathlon.getResultsOfAthletesFromFile();
			boolean noResultsFould = decathlon.getAthletes().size() == 0;
			assertTrue(noResultsFould);
		//}
	}

	private boolean fileExists(File file) {
		return file.exists();
	}

}
