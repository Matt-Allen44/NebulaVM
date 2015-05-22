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
        program[4] = IS.PUSH;
        program[5] = 3;
        program[6] = IS.PUSH;
        program[7] = 3;
        program[8] = IS.PUSH;
        program[9] = 3;

        program[10] = IS.ADD;
        program[11] = IS.ADD;
        program[12] = IS.ADD;
        program[13] = IS.ADD;
        program[14] = IS.IPRNT;

        program[15] = IS.PUSH;
        program[16] = 3;

		debug = new Debug(program);

		debug.log("Initialising new CPU instance...");
		debug.log("Executing current program...");
		debug.log("Executing program --> " + nUtil.arrayToString(program));

		long delta = System.currentTimeMillis();
		execute(program);

		long execTime = System.currentTimeMillis()-delta;
		System.out.println("Execution completed in " + execTime + "ms...");
	}
	
	int sp = -1; //sp - stack pointer
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
                    //sp++;
                    stack[++sp] = program[++pp];
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
                    stack[sp-1] = stack[sp] / stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.MLT:
                    stack[sp-1] = stack[sp] * stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.ADD:
                    stack[sp-1] = stack[sp] + stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.SUB:
                    stack[sp-1] = stack[sp] - stack[--sp];
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
            debug.tracemem(stack, sp, register, program[pp]);
			pp++;
		}
	}


	public static void main(String[] args){
		CPU nebula = new CPU();
	}
}
