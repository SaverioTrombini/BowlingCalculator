package controller;

import model.Partita;
import util.InserimentoDati;
import view.View;

public class Controller {

	Partita game = new Partita();
	View view = new View();
	public Controller() {}

	public void start() {

		for (int turno = 0; turno < game.getPartita().length - 1; turno++) {
			game.setTurnoAttuale(turno);
			view.stampaTurno(game.getTurnoAttuale() + 1);
			int primoTiro = InserimentoDati.richiestaValorePrimoTiro();
			gestisciTurno(game.getTurnoAttuale(), primoTiro);

			if (game.getTurnoAttuale() == game.getPartita().length - 2 && game.getPartita()[game.getTurnoAttuale() - 1].isStrike()) {
				int ultimoTiro = InserimentoDati.richiestaValorePrimoTiro();
				view.stampaTurno(game.getTurnoAttuale() + 2);
				game.setTurnoAttuale(game.getTurnoAttuale()+ 1);
				gestisciTurno(game.getTurnoAttuale(), ultimoTiro);
			}

			if (game.getTurnoAttuale() == game.getPartita().length - 2 && game.getPartita()[game.getTurnoAttuale()].isSpare()) {
				int tiro = InserimentoDati.richiestaValorePrimoTiro();
				view.stampaTurno(game.getTurnoAttuale() + 2);
				game.spareUltimoTiro(game.getTurnoAttuale(), tiro);
				view.stampaTabellone(game.getTabellone(), game.getTurnoAttuale());
			}
		}
	}

	private void gestisciTurno(int turnoAttuale, int ultimoTiro) {
		if (ultimoTiro != 10 && turnoAttuale <= game.getPartita().length) {
			int secondoTiro = InserimentoDati.richiestaValoreSecondoTiro();
			game.turnoBase(turnoAttuale, ultimoTiro, secondoTiro);

		} else if (ultimoTiro == 10) {
			game.strike(ultimoTiro, turnoAttuale);
		}
		view.stampaTabellone(game.getTabellone(), turnoAttuale);
	}

}
