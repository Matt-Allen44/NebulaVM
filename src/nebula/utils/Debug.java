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
	public Boolean shouldLog = false;
	
	public NebulaUtils nUtils = new NebulaUtils();

    private String traceString = "";
	public void traceop(int[] stack, int[] register, int opCode){
		if(shouldTrace){
			traceString += ("[Trace] " + IS.names[opCode] + " (" + opCode + ")");
		}
	}

	public void tracemem(int[] stack, int sp, int[] register, int opCode){
		if(shouldTrace){
			System.out.println(traceString + "\t\t --> Stack [" + sp + "]: " + nUtils.arrayToString(stack) + " \t\t --> Register: " + nUtils.arrayToString(register));
            traceString = "";
		}
	}
}
