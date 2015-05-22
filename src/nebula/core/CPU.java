package nebula.core;

import nebula.utils.Debug;
import nebula.utils.NebulaUtils;

public class CPU {
	Debug debug = new Debug();
	NebulaUtils nUtil = new NebulaUtils();
	public CPU(){
		debug.log("Initialising new CPU instance...");
		debug.log("Executing current program...");
		
		int[] program = new int[64];
		program[0] = IS.PUSH;
		program[1] = 12;
		program[2] = IS.PUSH;
		program[3] = 3;
		program[4] = IS.ADD;
		program[5] = IS.IPRNT;

		System.out.println("Executing program" + nUtil.arrayToString(program));
		execute(program);
		debug.log("Execution completed...");
	}
	
	int sp = 0; //sp - stack pointer
	int hp = 0; //hp - heap pointer
	int pp = 0; //pp - program pointer

	//Size of each int # of Integers
	int maxStackSize = 128;
	int maxHeapSize = 128;

	int stack[] = new int[maxStackSize];
	int heap[] = new int[maxHeapSize];
	
	public void execute(int program[]){
		while(pp < program.length) {
			switch (program[pp]) {
			case IS.HALT:
				return;
			case IS.PUSH:
				pp++;
				stack[sp++] = program[pp]; 
				break;
			case IS.ADD:
				stack[sp-2] = stack[--sp] + stack[--sp];
				stack[sp+1] = 0;
				break;
			case IS.IPRNT:
				System.out.println(stack[sp]);
				break;
			}
			
			debug.trace(stack, heap, program[pp]);
			pp++;
		}
	}
	
	public static void main(String[] args){
		CPU nebula = new CPU();
	}
}
