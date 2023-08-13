package model;

	public class Partita {
		private Turno[] partita;
		private int[] tabellone;
		private int turnoAttuale;

		public Partita() {
			partita = new Turno[11];
			tabellone = new int[11];
			turnoAttuale=0;
		}

		public void turnoBase(int turnoAttuale, int primoTiro, int secondoTiro) {
			partita[turnoAttuale] = new Turno();
			partita[turnoAttuale].setPrimoTiro(primoTiro);
				partita[turnoAttuale].setSecondoTiro(secondoTiro);
				if (primoTiro + secondoTiro == 10) {
					partita[turnoAttuale].setSpare(true);
				}
			aggiornaPunteggio(partita[turnoAttuale].getPrimoTiro(), partita[turnoAttuale].getSecondoTiro());
			aggiungiBonus(turnoAttuale);
		}


		private void aggiungiBonus(int turnoAttuale) {
			aggiungiBonusStrike(turnoAttuale);
			aggiungiBonusSpare(turnoAttuale);
			aggiungiBonusDoppioStrike(turnoAttuale);
		}		

		public void strike(int primoTiro, int turnoAttuale) {
			partita[turnoAttuale] = new Turno();
			partita[turnoAttuale].setPrimoTiro(primoTiro);
			partita[turnoAttuale].setSecondoTiro(0);
			partita[turnoAttuale].setStrike(true);
			aggiornaPunteggio(partita[turnoAttuale].getPrimoTiro(), partita[turnoAttuale].getSecondoTiro());
			aggiungiBonus(turnoAttuale);
		}

		private void aggiungiBonusDoppioStrike(int turnoAttuale) {
			if (turnoAttuale > 1 && partita[(turnoAttuale - 1)].isStrike() && partita[(turnoAttuale - 2)].isStrike()) {
				tabellone[turnoAttuale - 2] += partita[turnoAttuale].getPrimoTiro();
			}
		}

		private void aggiungiBonusSpare(int turnoAttuale) {
			if (turnoAttuale > 0 && partita[(turnoAttuale - 1)].isSpare()) {
				tabellone[turnoAttuale - 1] += partita[turnoAttuale].getPrimoTiro();
			}
		}

		private void aggiungiBonusStrike(int turnoAttuale) {
			if (turnoAttuale > 0 && partita[(turnoAttuale - 1)].isStrike()) {
				tabellone[turnoAttuale - 1] += partita[turnoAttuale].getPrimoTiro()
						+ partita[turnoAttuale].getSecondoTiro();
			}
		}

		public void spareUltimoTiro(int turnoAttuale, int primoTiro) {
			turnoAttuale++;
			partita[turnoAttuale] = new Turno();
			partita[turnoAttuale].setPrimoTiro(primoTiro);
			aggiornaPunteggio(partita[turnoAttuale].getPrimoTiro(), partita[turnoAttuale].getSecondoTiro());
			aggiungiBonus(turnoAttuale);			
		}

		private void aggiornaPunteggio(int primoTiro, int secondoTiro) {
			tabellone[turnoAttuale] += primoTiro + secondoTiro;
		}

		public Turno[] getPartita() {
			return partita;
		}

		public int[] getTabellone() {
			return tabellone;
		}

		public int getTurnoAttuale() {
			return turnoAttuale;
		}

		public void setTurnoAttuale(int turnoAttuale) {
			this.turnoAttuale = turnoAttuale;
		}	
		
}
