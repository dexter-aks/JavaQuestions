package coding.questions;

import java.util.Arrays;
import java.util.List;

public class StringTest {

	public static void main(String[] args) {
		/*String input = "34 56 34";
		if(!input.matches("^[^\\d\\s]+$")) {
		  System.out.println("Integer");
		} else {
			System.out.println("String");
		}*/
		String[] split = "abc 43 34".split(" ", 2);
		String s1=split[0];
		String s2=split[1];
		if(s2.matches("^[a-zA-Z\\s]*$")) {
			  System.out.println("String:"+s2);
			} else {
				System.out.println("Integer: "+s2);
			}
		//System.out.println(""+split1[0]+"--"+split1[1]);
		
		
		
		

	}

	/*public List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {

		Arrays.sort(boxList, (box1, box2) -> {
			String[] split1 = box1.split(" ", 2);
			String[] split2 = box2.split(" ", 2);

			boolean isNumber1 = Character.isDigit(split1[1].chatAt(0));
			boolean isNumber2 = Character.isDigit(split2[1].chatAt(0));

			if (!isNumber1 && !isNumber2) {
				int cmp = split1[1].compareTo(split2[1]);
				if (cmp != 0)
					return cmp;
				return split1[0].compareTo(split2[0]);
			}
			return isNumber1 ? (isNumber2 ? 0 : 1) : -1;

		});
		return boxList;
	}
	*/

}
