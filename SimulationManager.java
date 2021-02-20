//Kod skriven av William Hellberg
public class SimulationManager {
	
	private long simulations;
	private long switchOutcomes;
	Simulation mySimulation;
	
	public SimulationManager() {
		mySimulation= new Simulation();
	}
	
	public long simulateSwitchRate(long numberOfSimulations){
		//simulateSwitchRate: Anropas med antalet efterfr�gade simuleringar som argument.
		//Funktionen anropar mySimulation.shouldISwitch() det antalet g�nger.
		//Antalet g�nger som det var f�rdelaktigt att byta returneras.
		simulations=numberOfSimulations;
		switchOutcomes=0;
		for (long i=0; i<simulations; i++){
			if(mySimulation.shouldISwitch()){
				switchOutcomes++;
			}
		}
		return switchOutcomes;
	}
}
