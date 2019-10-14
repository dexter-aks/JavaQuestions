package coding.questions;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		
//		ArrayList
		List<Integer> arr=Arrays.asList(1,2,3,4);
		
		arr.forEach((Integer value)->System.out.print(value+" "));
		System.out.println();
		arr.forEach(value->System.out.print(value+" "));
		System.out.println();
		arr.forEach(System.out::print);
		System.out.println();
		
		int total =arr.stream().mapToInt(value->value).sum();
		System.out.println(total);
		
//		Map
		

	}

}
