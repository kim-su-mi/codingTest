package sumi.java.exam08;

public class VariableEx {
	public void argTest(String ... n){
		for(int i = 0 ; i < n.length ; i++)
		System.out.println("n["+i+"]:"+n[i]);
		System.out.println("--------------------------");
		}

	public static void main(String[] args) {
		VariableEx ve = new VariableEx();
		ve.argTest("Varargs", "Test");
		ve.argTest("100", "600", "900", "1000");
		

	}

}
