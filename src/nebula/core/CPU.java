package nebula.core;

import nebula.utils.Debug;
import nebula.utils.NebulaUtils;

public class CPU {
	Debug debug;
	NebulaUtils nUtil = new NebulaUtils();
	public CPU(){
		int[] program = new int[64];
        program[0] = IS.PUSH;
        program[1] = 17;
        program[2] = IS.PUSH;
        program[3] = 3;
        program[4] = IS.DIV;
        program[5] = IS.IPRNT;

		debug = new Debug(program);

		debug.log("Initialising new CPU instance...");
		debug.log("Executing current program...");
		debug.log("Executing program --> " + nUtil.arrayToString(program));

		long delta = System.currentTimeMillis();
		execute(program);

		long execTime = System.currentTimeMillis()-delta;
		debug.log("Execution completed in " + execTime + "ms...");
	}
	
	int sp = -1; //sp - stack pointer
	int rp = 0; //rp - register pointer
	int pp = 0; //pp - program pointer

	//Size of each int # of Integers
	int maxStackSize = 32;
	int maxRegisterSize = 32;

	int stack[] = new int[maxStackSize];
	int register[] = new int[maxRegisterSize];
	
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

                //ARITHMETIC IS DONE USING REVERSE POLISH NOTATION
                case IS.DIV:
                    int val1 = stack[sp];
                    int val2 = stack[--sp];

                    stack[sp] = val2/val1;
                    stack[sp+1] = 0;
                    break;

                case IS.MLT:
                    //NO VAL DECLARATIONS NEEDED AS MULTIPLICATION DOES NOT DEPEND ON ORDER
                    //USING VAL VARS WOULD BE SLOWER
                    stack[sp-1] = stack[sp] * stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.ADD:
                    //NO VAL DECLARATIONS NEEDED AS ADDITION DOES NOT DEPEND ON ORDER
                    //USING VAL VARS WOULD BE SLOWER
                    stack[sp-1] = stack[sp] + stack[--sp];
                    stack[sp+1] = 0;
                    break;

                case IS.SUB:
                    val1 = stack[sp];
                    val2 = stack[--sp];

                    stack[sp] = val2 - val1;
                    stack[sp+1] = 0;
                    break;

                case IS.CPRNT:
                    //NOTE: CHARS WILL NOT PRINT ON NEW LINE - USE ASCII
                    System.out.print((char)stack[sp]);
                    break;

                case IS.IPRNT:
                    //NOTE: INTEGERS WILL ALWAYS PRINT ON NEW LINE
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
