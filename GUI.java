//Kod skriven av William Hellberg
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//klassen har 3 uppgifter och dessa har varsin funktion.
//1: Skapa ett GUI, konstruktorn GUI() hanterar detta.
//2: Reagera när användaren ber om simuleringar, funktionen actionPerformed(...) hanterar detta.
//3: Visa resultaten av simuleringarna, funktionen resultOutput(...) hanterar detta.
//Den tredje uppgiften är beroende på den andra, och både den andra och tredje är beroende av GUI:et. 

public class GUI implements ActionListener{
	JFrame f;
	JMenuBar menuBar;
	JTextField tF1;
	JTextArea textArea;
	JScrollPane jSP;
	JPanel jP1;
	JButton b1;
	JLabel jL1;
	SimulationManager mySM;
	
	public GUI(){
		//här skapas de olika delarna av GUI:et 
		mySM=new SimulationManager();
		menuBar=new JMenuBar();
		b1=new JButton("Simulate");
		tF1=new JTextField();
		jL1=new JLabel("Enter number of simulations:");
		textArea = new JTextArea();
		textArea.setColumns(50);
        textArea.setLineWrap(true);
        textArea.setRows(32);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        jSP = new JScrollPane(textArea);
        jP1=new JPanel();
        jP1.setBorder(BorderFactory.createEtchedBorder());
        jP1.add(jSP);
        menuBar.add(new JSeparator());
		menuBar.add(jL1);
		menuBar.add(tF1);
		menuBar.add(b1);
		
		// Här lägger vi till en actionListener till "Simulate" knappen, så att programmet märker när någon trycker på knappen. 
		b1.addActionListener(this);
        
		//Här sammanställer vi alla delarna i en JFrame.
		f = new JFrame("Monty Hall Simulations");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add("Center", jP1);
        f.pack();
        f.setSize(new Dimension(600,600));
        f.setVisible(true);
        f.setJMenuBar(menuBar);
	}
	public void resultOutput(long sSR,long simulations){
		//Här skriver koden ut hur många simuleringar som kördes och vilka resultat som dessa fick.
		//Detta uttrycks i antalet gånger det var bättre att byta respektive stanna kvar vid den ursprungliga gissningen.
		long cases=simulations;
		long change=sSR;
		long remain=cases-change;
		textArea.append("Out of "+cases+" simulations"+System.lineSeparator());
		textArea.append("It was favorable to change your mind in "+change+" cases"+System.lineSeparator());
		textArea.append("While it was unfavorable to change your mind in "+remain+" cases"+System.lineSeparator());
		if (change>remain){
			textArea.append("Overall it was more favorable to change your mind"+System.lineSeparator());
		}else if(change==remain) {
			textArea.append("Overall changing your mind didn't change the result"+System.lineSeparator());
		}else{
			textArea.append("Overall it was less favorable to change your mind"+System.lineSeparator());
		}
		textArea.append(""+System.lineSeparator());
	}
	
	public void actionPerformed(ActionEvent aE){
		if (aE.getSource()==b1){
			//Här reagerar programmet om någon trycker på knappen "Simulate".
			long iter=100;
			try {
	    		iter = Long.parseUnsignedLong(tF1.getText());
	    		//Vi kollar då om användaren har skrivit in antalet simuleringar i textfältet bredvid knappen.
	    	} catch (Exception e){
	    		System.out.println("That was not an unsigned integer, defaulting to "+iter);
	    		//Om användaren inte skriver något som känns igen så är standarden att köra 100 simuleringar.
	    	}
			//SimulationManager klassens funktion simulateSwitchRate(x) ser till att vi kör x stycken simuleringar.
			//Utfallet från dessa, samt antalet simuleringar, skickas vidare för att uttryckas som ett resultat.
			resultOutput(mySM.simulateSwitchRate(iter),iter);
		}
	}
}
