package nebula.utils;

import nebula.core.IS;

public class Debug {

    public NebulaUtils nUtils = new NebulaUtils();
    private String logPrefix = "Nebula";
    private int[] program;

    public Boolean shouldTrace = true;
    public Boolean shouldLog = true;

	public Debug(int[] p){
        program = p;
    }

    public void log(String s){
		if(shouldLog){
			System.out.println("[" + logPrefix + "] " + s);
		}
	}

    private String traceString = "";
	public void traceop(int[] stack, int[] register, int opCode, int pp){
			traceString += (pp + " [Trace] " + IS.names[opCode] + " (" + opCode + ")");
	}

	public void tracemem(int[] stack, int sp, int[] register, int opCode){
		if(shouldTrace){

            for(int i = traceString.length(); i < 30; i++){
                traceString += " ";
            }

			traceString += "\t\t --> Stack [" + sp + "]: " + nUtils.arrayToString(stack);

            for(int i = traceString.length(); i < 30 + stack.length*3; i++){
                traceString += " ";
            }
            traceString += " \t\t --> Register: " + nUtils.arrayToString(register);

            System.out.println(traceString);
            traceString = "";
		}
	}
}
