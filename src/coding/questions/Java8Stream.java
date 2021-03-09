package coding.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Stream {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(3);
		list.add(2);
		Map<Integer, Long> counted = list.stream()
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(counted);
		
		List<Integer> number = Arrays.asList(2,3,4,5);
		
		int sum = number.stream().reduce(0, Integer::sum);
		System.out.println(sum);
		
		int sumOfEven = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i); 
			  
		System.out.println(sumOfEven); 

	}
	
	

}
