# MontyHall
Monty Hall Simulation

Koden simulerar Monty Hall-problemet upprepade gånger och presenterar resultaten. Användaren väljer hur många simuleringar som ska köras. 


Installationskrav: Java SE Development Kit
Valfritt: Valfri IDE

Installation: Ladda ned de fem .java filerna.

Användning:

Antingen kompilera filerna (i stilen javac filnamn.java) följt av kommandot java Main
Eller kör Main.java via valfri IDE.

När koden körs får användaren frågan om de vill använda ett GUI för simuleringarna. 

Med GUI: 
Om användaren svarade ja skapas ett nytt fönster där användaren kan be programmet köra simuleringar och se resultaten. 
För att köra simuleringar så skriver användaren in det önskade antalet simuleringar i fältet högst upp i mitten, och trycker sedan på knappen ”Simulate”. 
Programmet kör då det angivna antalet simuleringar och presenterar resultaten.
Så länge fönstret är öppet kan användaren be programmet att köra nya simuleringar. 

Utan GUI:
Om användaren valde att inte använda ett GUI är nästa fråga hur många simuleringar de vill köra. Efter att programmet simulerat det angivna antalet simuleringar och skrivit ut resultatet är det färdigt.

Struktur: 
Programmet består av 5 filer:

Main: Anropas för att starta programmet. 

Simulation: Hanterar enskilda simuleringar.

SimulationManager: Hanterar stora antal simuleringar med hjälp av ”Simulation”.

InputOutput: Hanterar text till användaren och att fånga upp svar från användaren innan/utan GUI.

GUI: Används bara om användaren väljer att använda GUI. Hanterar det grafiska användargränssnittets utseende, användarens efterfrågan efter simuleringar samt presentation av resultaten från simuleringarna. 

Se även de individuella filerna för mer information.

Credits/Medverkande: William Hellberg
