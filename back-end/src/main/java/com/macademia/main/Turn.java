package com.macademia.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Turn {
    private LocalDate Start;
    private LocalDate End;
    private static DateTimeFormatter Format = DateTimeFormatter.ofPattern("MM/DD/YYYY HH:mm");

    /**
     * Receives a turntext from the database and converts it into a turn
     * @param TurnText MM/DD/YYYY HH:mm-MM/DD/YYYY HH:mm
     */
    public Turn(String TurnText){
    	String TurnTextSplit[]= TurnText.split("-");
    	if(TurnTextSplit.length!=2) {throw new IllegalArgumentException("Turn text not formatted correctly");}
    	
    	//now go:
    	try {
        	Start=LocalDate.parse(TurnTextSplit[0],Format);
        	End=LocalDate.parse(TurnTextSplit[1],Format);			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Turn text not formatted correctly");
		}
    	
    }

    public LocalDate getStart() {return Start;}
    public LocalDate getEnd() {return End;}
    
    /**
     * Verifies it is time for this turn
     * @return TRUE if and only if the current time is AFTER the start of this turn, and if the time is BEFORE the end of this turn.
     */
    public boolean isTime() {
    	LocalDate TheTimeAtTheCurrentMomentOhMyGodMyBrainIsMeltingOopsie = LocalDate.now(); 
    	
    	return TheTimeAtTheCurrentMomentOhMyGodMyBrainIsMeltingOopsie.isAfter(Start) && 
    			TheTimeAtTheCurrentMomentOhMyGodMyBrainIsMeltingOopsie.isBefore(End);
    	
    }
    
}