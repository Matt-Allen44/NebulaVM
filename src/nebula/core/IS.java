package nebula.core;

public class IS {
//Class declaring the NIS (Nebula Instruction Set)
	
	public static final int HALT = 0;
	public static final int PUSH = 1;
	public static final int POP = 2;
	public static final int CLR = 3;
	public static final int SPUSH = 4;
	public static final int RPOP = 5;
	public static final int RCOP = 6;
	public static final int RPUSH = 7;
	public static final int DIV = 8;
	public static final int MLT = 9;
	public static final int ADD = 10;
	public static final int SUB = 11;
	public static final int CPRNT = 12;
	public static final int IPRNT = 13;
	public static final int GOTO = 14;
	public static final int GIE = 15;
	public static final int GIL = 16;
	public static final int GIG = 17;

	public static final String[] names = {"HALT", "PUSH", "POP", "CLR", "SPUSH", "RPOP", "RCOP", "RPUSH", "DIV", "MLT", "ADD", "SUB", "CPRNT", "IPRNT", "GOTO", "GIE", "GIL", "GIG"};
	public static final int[] args = {0,1,0,0,1,1,1,2,0,0,0,0,0,0,1,1,1,1};
}
