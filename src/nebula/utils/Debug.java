package nebula.utils;

public class Debug {
	private String logPrefix = "Nebula";
	public void log(String s){
		if(shouldLog){
			System.err.println("[" + logPrefix + "] " + s);
		}
	}
	
	public Boolean shouldTrace = false;
	public Boolean shouldLog = false;
	
	public NebulaUtils nUtils = new NebulaUtils();
	
	public void trace(int[] stack, int[] heap, int opCode){
		if(shouldTrace){
			System.err.println("[Trace] OP: " + opCode + "\t Stack:" + nUtils.arrayToString(stack) + "\t Heap:" + nUtils.arrayToString(heap));
		}
	}
}
