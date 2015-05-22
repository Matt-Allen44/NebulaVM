#NebulaVM
Stack Machine written in Java

#Contributing
To Contribute to NebulaVM send a pull request either implementing new features, or fixing issues.
Please see the documents within NebulaResources for a guide on how to develop for NebulaVM and what needs implementing.

#Building
NebulaVM has No Dependencies 
Build as you would any other Java application.

#Running
```
$ java -jar nebulavm.jar --program [YourProgram]
```
The [YourProgram] Variable must be a series of integers representing the Nebula Instruction Set.

#Examples Programs
###Push & Add
```
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
```

###Division Example
```
        program[0] = IS.PUSH;
        program[1] = 17;
        program[2] = IS.PUSH;
        program[3] = 3;
        program[4] = IS.DIV;
        program[5] = IS.IPRNT;
```

###Hello World
```
        program[0] = IS.PUSH;
        program[1] = 72;
        program[2] = IS.CPRNT;
        program[3] = IS.PUSH;
        program[4] = 69;
        program[5] = IS.CPRNT;
        program[6] = IS.PUSH;
        program[7] = 76;
        program[8] = IS.CPRNT;
        program[9] = IS.PUSH;
        program[10] = 76;
        program[11] = IS.CPRNT;
        program[12] = IS.PUSH;
        program[13] = 79;
        program[14] = IS.CPRNT;

        program[15] = IS.PUSH;
        program[16] = 32;
        program[17] = IS.CPRNT;

        program[18] = IS.PUSH;
        program[19] = 87;
        program[20] = IS.CPRNT;
        program[21] = IS.PUSH;
        program[22] = 79;
        program[23] = IS.CPRNT;
        program[24] = IS.PUSH;
        program[25] = 82;
        program[26] = IS.PUSH;
        program[27] = 82;
        program[28] = IS.CPRNT;
        program[29] = IS.PUSH;
        program[30] = 76;
        program[31] = IS.CPRNT;
        program[32] = IS.PUSH;
        program[33] = 68;
        program[34] = IS.CPRNT;
        program[35] = IS.PUSH;
        program[36] = 10;
        program[37] = IS.CPRNT;
```
=======
<table width="100%">
      <tr>
      <td align="left">
            <img  src="https://raw.githubusercontent.com/Matt-Allen44/NebulaVM/master/NebulaResources/NebulaLogo100pxLossy.png"
                  height="64">
            </a>
      </td>
      <td>
      NebulaVM
      </td>
      </tr>
</table>
>>>>>>> 6af9173ddcd968e805161d05fcbf4c0f7daa1a98


