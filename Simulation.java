//Kod skriven av William Hellberg
import java.util.concurrent.ThreadLocalRandom;

public class Simulation {
	//Det g�r att �ndra p� antalet pris, men d� beh�ver man tolka resultaten annorlunda.
	//D�rf�r �r NUMBER_OF_PRIZES satt till 1, medan numberOfBoxes g�r att �ndra via val av konstruktor.
	private static final int NUMBER_OF_PRIZES=1;
	private int numberOfBoxes;
	
	public Simulation(){
		//Standardantagandet �r 3 l�dor. 
		numberOfBoxes=3;
	}
	public Simulation(int boxes){
		//Om man vill testa med annat antal l�dor.
		//D� antas att "Monty" �ppnar (antalet l�dor -2) l�dor efter din gissning.
		numberOfBoxes=boxes;
	}
	
	public boolean shouldISwitch()
	{
		int guess=ThreadLocalRandom.current().nextInt(numberOfBoxes);
		//guess: V�r slumpm�ssiga gissning, representeras som ett heltal mellan 0 och antalet l�dor-1
		//D� gissningen �r slumpm�ssig kan vi anta att "0" representerar priset vi letar efter.
		if (guess<NUMBER_OF_PRIZES){
			return false;
			//Om vi har gissat r�tt s� �r det s�mre att byta.
		} else {
			return true;
			//Om vi har gissat fel s� �r det b�ttre att byta.
		}
	}

}
