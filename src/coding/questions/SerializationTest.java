package coding.questions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BaseClass b=new BaseClass(10, 20);
		System.out.println("i:"+b.i);
		System.out.println("j:"+b.j);
		
		FileOutputStream fos= new FileOutputStream("abc.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(b);
		oos.close();
		fos.close();
		
		FileInputStream fis=new FileInputStream("abc.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		BaseClass b1=(BaseClass) ois.readObject();
		ois.close();
		fis.close();
		
		System.out.println("i:"+b1.i);
		System.out.println("j:"+b1.j);

	}

}

class SuperClass{
	int i;
	public SuperClass(int i) {
		this.i=i;
	}
	
	public SuperClass() {
		
	}
}

class BaseClass extends SuperClass implements Serializable{
	int j;
	public BaseClass(int i,int j) {
		super(i);
		this.j=j;
	}
}
