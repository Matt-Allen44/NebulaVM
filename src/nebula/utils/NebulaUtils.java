package nebula.utils;

public class NebulaUtils {
	public String arrayToString(int[] pArray){
		String s = "";
		for(int i = 0; i < pArray.length; i++){
			//Break when end (0) is reached
			if(pArray[i] == 0 && i != 0){
				break;
			}
			
			s += pArray[i] + " ";
		}
		return s;
	}
}
