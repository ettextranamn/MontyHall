//Kod skriven av William Hellberg
import java.util.Scanner;

public class InputOutput {
	
	public void runInputOutput(){
		//Koden börjar med att fråga användaren om den vill använda ett GUI eller inte.
		Scanner myObj = new Scanner(System.in);
	    String useGUI;
	    System.out.println("Do you want to use a GUI: y/n"); 
	    useGUI = myObj.nextLine();
	    if (useGUI.equalsIgnoreCase("y")){
	    	new GUI();
	    	//Om användaren vill använda ett GUI så tar GUI klassen över.
	    } else {
	    	if(useGUI.equalsIgnoreCase("n")==false){
	    		System.out.println("That was not y or n, defaulting to no GUI");
	    		//Om användaren inte skriver något som känns igen så är standarden att inte använda ett GUI.
	    	}
	    	//Om vi inte använder ett GUI så blir nästa fråga hur många simuleringar som användaren vill att koden ska köra.
	    	long iter=100;
	    	System.out.println("Number of simulations:");
	    	try {
	    		iter = Long.parseUnsignedLong(myObj.nextLine());
	    	} catch (Exception e){
	    		System.out.println("That was not an unsigned integer, defaulting to "+iter);
	    		//Om användaren inte skriver något som känns igen så är standarden att köra 100 simuleringar.
	    	}
	    	noGUI(iter);
	    	}
	    myObj.close();
	}

	
	public void noGUI(long i){
		//SimulationManager klassens funktion simulateSwitchRate(x) ser till att vi kör x stycken simuleringar.
		//Utfallet från dessa, samt antalet simuleringar, skickas vidare för att uttryckas som ett resultat.
		SimulationManager mySM=new SimulationManager();
		noGUIResults(mySM.simulateSwitchRate(i),i);
	}
	public void noGUIResults(long sSR,long simulations){
		//Här skriver koden ut hur många simuleringar som kördes och vilka resultat som dessa fick.
		//Detta uttrycks i antalet gånger det var bättre att byta respektive stanna kvar vid den ursprungliga gissningen.
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
