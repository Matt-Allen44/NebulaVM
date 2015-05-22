package nebula.utils;

import nebula.core.IS;

public class Debug {

    private String logPrefix = "Nebula";
    private int[] program;

	public Debug(int[] p){
        program = p;
    }

    public void log(String s){
		if(shouldLog){
			System.out.println("[" + logPrefix + "] " + s);
		}
	}
	
	public Boolean shouldTrace = true;
	public Boolean shouldLog = true;
	
	public NebulaUtils nUtils = new NebulaUtils();
	
	public void traceop(int[] stack, int[] register, int opCode){
		if(shouldTrace){
			System.out.print("[Trace] " + IS.names[opCode] + " (" + opCode + ")");
		}
	}

	public void tracemem(int[] stack, int[] register, int opCode){
		if(shouldTrace){
			System.out.println("\t\t --> Stack: " + nUtils.arrayToString(stack) + " \t\t --> Register: " + nUtils.arrayToString(register));
		}
	}
}
