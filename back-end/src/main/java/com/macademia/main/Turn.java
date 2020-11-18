package com.macademia.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Turn {
    private LocalDateTime Start;
    private LocalDateTime End;
    public static DateTimeFormatter Format = DateTimeFormatter.ofPattern("M/d/yyyy' 'H:m");

    /**
     * Receives a turntext from the database and converts it into a turn
     * @param TurnText MM/DD/YYYY HH:mm-MM/DD/YYYY HH:m
     */
    public Turn(String TurnText){
    	String TurnTextSplit[]= TurnText.split("-");
    	if(TurnTextSplit.length!=2) {throw new IllegalArgumentException("Turn text not formatted correctly");}
    	
    	//now go:
    	try {
        	Start=LocalDateTime.parse(TurnTextSplit[0],Format);
        	End=LocalDateTime.parse(TurnTextSplit[1],Format);	        
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Turn text not formatted correctly");
		}
    	
    	//Now test
    	if(Start.isAfter(End)) {throw new IllegalArgumentException("Turn cannot start after it ends.");}
    	
    }
    
    public Turn(LocalDateTime Start, LocalDateTime End) {
    	this.Start=Start;
    	this.End=End;
    	
    	//Now test
    	if(Start.isAfter(End)) {throw new IllegalArgumentException("Turn cannot start after it ends.");}
    }

    public LocalDateTime getStart() {return Start;}
    public LocalDateTime getEnd() {return End;}
    
    /**
     * Verifies it is time for this turn
     * @return TRUE if and only if the current time is AFTER the start of this turn, and if the time is BEFORE the end of this turn.
     */
    public boolean isTime() {
    	LocalDateTime TheTimeAtTheCurrentMomentOhMyGodMyBrainIsMeltingOopsie = LocalDateTime.now(); 
    	
    	return TheTimeAtTheCurrentMomentOhMyGodMyBrainIsMeltingOopsie.isAfter(Start) && 
    			TheTimeAtTheCurrentMomentOhMyGodMyBrainIsMeltingOopsie.isBefore(End);
    	
    }
    
    /**
     * Returns a savable string.
     */
    public String toString() {return Start.format(Format) + "-" + End.format(Format); }
    
}