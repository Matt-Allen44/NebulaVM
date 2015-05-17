package nebula.core;

public class IS {
//Class declaring the NIS (Nebula Instruction Set)
	
	public static final int HALT = 0;  //Exit
	public static final int PUSH = 1;  //Push to current place in Stack
	public static final int POP = 2;   //Drop value at top  of stack
	public static final int ADD = 3;   //Add top 2 values, and returning to top
	public static final int PRINT = 4; //Print value at top of stakc
}
