package coding.questions;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestStream {

	public static void main(String[] args) {
		Integer[] a= {3,1,2,4,2,6,5,7};
		System.out.println(Arrays.asList(a));
		Integer[] temp=a;
		Arrays.sort(temp);
		List al = Arrays.asList(temp);
		System.out.println(al);
		getKthLargest(a,3);

	}
	
	public static void getKthLargest(Integer[] a,int k) {
		PriorityQueue<Integer> p=new PriorityQueue<>(k);
		p.add(1);
		p.add(2);
		p.offer(3);
		
		
		/*for(int i:a) {
			p.offer(i);
			if(p.size()>k) {
				p.poll();
			}
		}*/
		System.out.println(p.size());
		System.out.println(p.poll());
	}

}
