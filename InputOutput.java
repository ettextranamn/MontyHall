//Kod skriven av William Hellberg
import java.util.Scanner;

public class InputOutput {
	
	public void runInputOutput(){
		//Koden b�rjar med att fr�ga anv�ndaren om den vill anv�nda ett GUI eller inte.
		Scanner myObj = new Scanner(System.in);
	    String useGUI;
	    System.out.println("Do you want to use a GUI: y/n"); 
	    useGUI = myObj.nextLine();
	    if (useGUI.equalsIgnoreCase("y")){
	    	new GUI();
	    	//Om anv�ndaren vill anv�nda ett GUI s� tar GUI klassen �ver.
	    } else {
	    	if(useGUI.equalsIgnoreCase("n")==false){
	    		System.out.println("That was not y or n, defaulting to no GUI");
	    		//Om anv�ndaren inte skriver n�got som k�nns igen s� �r standarden att inte anv�nda ett GUI.
	    	}
	    	//Om vi inte anv�nder ett GUI s� blir n�sta fr�ga hur m�nga simuleringar som anv�ndaren vill att koden ska k�ra.
	    	long iter=100;
	    	System.out.println("Number of simulations:");
	    	try {
	    		iter = Long.parseUnsignedLong(myObj.nextLine());
	    	} catch (Exception e){
	    		System.out.println("That was not an unsigned integer, defaulting to "+iter);
	    		//Om anv�ndaren inte skriver n�got som k�nns igen s� �r standarden att k�ra 100 simuleringar.
	    	}
	    	noGUI(iter);
	    	}
	    myObj.close();
	}

	
	public void noGUI(long i){
		//SimulationManager klassens funktion simulateSwitchRate(x) ser till att vi k�r x stycken simuleringar.
		//Utfallet fr�n dessa, samt antalet simuleringar, skickas vidare f�r att uttryckas som ett resultat.
		SimulationManager mySM=new SimulationManager();
		noGUIResults(mySM.simulateSwitchRate(i),i);
	}
	public void noGUIResults(long sSR,long simulations){
		//H�r skriver koden ut hur m�nga simuleringar som k�rdes och vilka resultat som dessa fick.
		//Detta uttrycks i antalet g�nger det var b�ttre att byta respektive stanna kvar vid den ursprungliga gissningen.
		long cases=simulations;
		long change=sSR;
		long remain=cases-change;
		System.out.println("Out of "+cases+" simulations");
		System.out.println("It was favorable to change your mind in "+change+" cases");
		System.out.println("While it was unfavorable to change your mind in "+remain+" cases");
		if (change>remain){
			System.out.println("Overall it was more favorable to change your mind");
		}else if(change==remain) {
			System.out.println("Overall changing your mind didn't change the result");
		}else{
			System.out.println("Overall it was less favorable to change your mind");
		}
		
		
	}
}
