package counterApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Partita;

public class PartitaTurnoTabelloneTest {

	@Test
	public void testPartitaTurnoTabellone() {
		Partita partita = new Partita();

		partita.turnoBase(0, 5, 3);

		int[] tabellone = partita.getTabellone();
		assertNotNull(tabellone);
		assertEquals(5 + 3, tabellone[0]);

		// Aggiungiamo un altro turno base e verifichiamo il calcolo del punteggio
		partita.turnoBase(1, 4, 2);
		assertEquals(5 + 3 + 4 + 2, tabellone[0] + tabellone[1]);

		// Aggiungiamo uno strike e verifichiamo il calcolo del punteggio
		partita.strike(10, 2);
		assertEquals(5 + 3 + 4 + 2 + 10, tabellone[0] + tabellone[1] + tabellone[2]);

		// Aggiungiamo uno spare e verifichiamo il calcolo del punteggio
		partita.turnoBase(3, 5, 5);
		assertEquals(5 + 3 + 4 + 2 + 10 + 5 + 5 + 5 + 5, tabellone[0] + tabellone[1] + tabellone[2] + tabellone[3]);
	}

}
