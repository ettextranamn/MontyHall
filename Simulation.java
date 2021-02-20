//Kod skriven av William Hellberg
import java.util.concurrent.ThreadLocalRandom;

public class Simulation {
	//Det går att ändra på antalet pris, men då behöver man tolka resultaten annorlunda.
	//Därför är NUMBER_OF_PRIZES satt till 1, medan numberOfBoxes går att ändra via val av konstruktor.
	private static final int NUMBER_OF_PRIZES=1;
	private int numberOfBoxes;
	
	public Simulation(){
		//Standardantagandet är 3 lådor. 
		numberOfBoxes=3;
	}
	public Simulation(int boxes){
		//Om man vill testa med annat antal lådor.
		//Då antas att "Monty" öppnar (antalet lådor -2) lådor efter din gissning.
		numberOfBoxes=boxes;
	}
	
	public boolean shouldISwitch()
	{
		int guess=ThreadLocalRandom.current().nextInt(numberOfBoxes);
		//guess: Vår slumpmässiga gissning, representeras som ett heltal mellan 0 och antalet lådor-1
		//Då gissningen är slumpmässig kan vi anta att "0" representerar priset vi letar efter.
		if (guess<NUMBER_OF_PRIZES){
			return false;
			//Om vi har gissat rätt så är det sämre att byta.
		} else {
			return true;
			//Om vi har gissat fel så är det bättre att byta.
		}
	}

}
