package counterApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Partita;

public class PartitaTest {

	@Test
	public void testTurnoBase() {
		Partita partita = new Partita();
		partita.turnoBase(0, 5, 5);

		assertEquals(10, partita.getTabellone()[0]);
		assertEquals(5, partita.getPartita()[0].getPrimoTiro());
		assertEquals(5, partita.getPartita()[0].getSecondoTiro());
		assertTrue(partita.getPartita()[0].isSpare());
	}

	@Test
	public void testStrike() {
		Partita partita = new Partita();
		partita.strike(10, 0);
		assertEquals(10, partita.getTabellone()[0]);
		assertEquals(10, partita.getPartita()[0].getPrimoTiro());
		assertEquals(0, partita.getPartita()[0].getSecondoTiro());
		assertTrue(partita.getPartita()[0].isStrike());
	}

}
