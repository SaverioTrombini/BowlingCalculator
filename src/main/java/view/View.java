package view;

public class View {
	public View() {
	}
	
	public void stampaTurno(int turnoAttuale) {
		System.out.println("turno:" + turnoAttuale);
	}

	public void stampaTiroBonus() {
		System.out.println("tiro bonus");
	}

	public void stampaTabellone(int[] tabellone, int turnoAttuale) {
	    int sum = 0;
	    System.out.print("TABELLONE -> ");
	    for (int i = 0; i < tabellone.length; i++) {
	        if (turnoAttuale >= i) {
	            sum += tabellone[i];
	            System.out.print(sum);
	            
	            if (i <= turnoAttuale - 1) {
	                System.out.print(" - ");
	            }
	        }
	    }
	    System.out.println();
	}
}
