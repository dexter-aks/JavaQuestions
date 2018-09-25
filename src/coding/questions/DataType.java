package coding.questions;

import java.util.HashMap;
import java.util.Map;

class Type{
	public int a=10;
}
class Type2{
	Type t1=new Type();
	public void changeType() {
		t1.a=110;
	}
}
public class DataType{
	static int m=1;
	static{
		m=m+4;
	}

	public static void main(String[] args) {
		String sub="abcdefg";
		System.out.println(sub.substring(3));
		Type2 t2=new Type2();
		t2.changeType();
		Type t=new Type();
		System.out.println("K:"+t.a);
		System.out.println(m);
		String s="One"+1+2+"Two"+"Three"+3+4+"Four"+"Five"+5;
		System.out.println(s);
		int i=10+ +11 - -12;
		System.out.println(i);
		String s1="abc";
		String s2=s1;
		if(s1.equals(s2)) {
			System.out.println("abc");
		}else {
			System.out.println("!abc");
		}
		final class T{
			public final static String name="a";
		}
		Integer i1=-129;
		Integer i2=-129;
		System.out.println(i1==i2);
		/*double a1=2.15;
		double a2=1.10;
		System.out.println("double diff:"+(a1-a2));
		
		BigDecimal a3=new BigDecimal("2.15");
		BigDecimal a4=new BigDecimal("1.10");
		System.out.println("double diff:"+(a3.subtract(a4)));*/
		/*C c=new C();
		B b=new B();
		b= c;
		B b1=new C();
		C c1=(C) b1;
		System.out.println(c1);*/
		
		byte a=127;
		byte b=127;
		b= (byte) (a+b);
		System.out.println(b);
		
		int a1=2147483647;
		int a2=2147483647;
		a2=a1+a2;
		System.out.println(a2);
		
		long l1=1000*60*60*24*365L;
		System.out.println(l1);
		long l2=1000*60*60*24*365;
		System.out.println(l2);
		
		Map<String,String> map=new HashMap<>();
		map.put("name", "Amit");
		map.put("age", "27");
		
		for(Map.Entry<String, String> m:map.entrySet()) {
			System.out.println(m.getKey()+":"+m.getValue());
		}
	}

}
class A{}
class B extends A{}
class C extends B{}