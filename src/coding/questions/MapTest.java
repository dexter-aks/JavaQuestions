package coding.questions;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String,String> m=new HashMap<>();
		m.put("a", "1");
		m.put("b", "2");
		m.put("c", "3");
		m.put(null, null);
		
		Map<String,String> n=new Hashtable<>();
		n.put(null, null);
		n.put("x", null);
		
		System.out.println(n.keySet());
		
		for(Map.Entry<String, String> k:m.entrySet()) {
			System.out.print(k.getKey()+k.getValue());
		}
		System.out.println();
		System.out.println(m.keySet());
		System.out.println(m.values());

	}

}
