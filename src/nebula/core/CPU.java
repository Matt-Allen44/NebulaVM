package nebula.core;

import nebula.utils.Debug;
import nebula.utils.NebulaUtils;

public class CPU {
	Debug debug;
	NebulaUtils nUtil = new NebulaUtils();
	public CPU(){
		int[] program = new int[64];
		program[0] = IS.PUSH;
		program[1] = 12;
		program[2] = IS.PUSH;
		program[3] = 3;
		program[4] = IS.ADD;
		program[5] = IS.IPRNT;

		debug = new Debug(program);

		debug.log("Initialising new CPU instance...");
		debug.log("Executing current program...");
		debug.log("Executing program --> " + nUtil.arrayToString(program));

		long delta = System.currentTimeMillis();
		execute(program);

		long execTime = System.currentTimeMillis()-delta;
		System.out.println("Execution completed in " + execTime + "ms...");
	}
	
	int sp = 0; //sp - stack pointer
	int rp = 0; //rp - register pointer
	int pp = 0; //pp - program pointer

	//Size of each int # of Integers
	int maxStackSize = 128;
	int maxHeapSize = 128;

	int stack[] = new int[maxStackSize];
	int register[] = new int[maxHeapSize];
	
	public void execute(int program[]){
		while(pp < program.length) {

			debug.traceop(stack, register, program[pp]);
			switch (program[pp]) {
                case IS.HALT:
                    return;

                case IS.PUSH:
                    stack[sp++] = program[++pp];
                    break;

                case IS.POP:
                    stack[sp--] = 0;
                    break;

                case IS.CLR:
                    for(int i = stack.length; i > 0; --i){
                        stack[i] = 0;
                    }
                    break;

                case IS.SPUSH:
                    stack[sp++] = register[program[++pp]];
                    break;

                case IS.RPOP:
                    register[program[++pp]] = 0;
                    break;

                case IS.RCOP:
                    register[program[++pp]] = stack[sp];
                    break;

                case IS.RPUSH:
                    register[program[++pp]] = program[++pp];
                    break;

                case IS.DIV:
                    stack[sp-2] = stack[--sp] / stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.MLT:
                    stack[sp-2] = stack[--sp] * stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.ADD:
                    stack[sp-2] = stack[--sp] + stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.SUB:
                    stack[sp-2] = stack[--sp] - stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.CPRNT:
                    System.out.println((char)stack[sp]);
                    break;

                case IS.IPRNT:
                    System.out.println(stack[sp]);
                    break;

                //IMPLEMENT FLOW COMMANDS HERE
            }
			debug.tracemem(stack, register, program[pp]);
			pp++;
		}
	}


	public static void main(String[] args){
		CPU nebula = new CPU();
	}
}
