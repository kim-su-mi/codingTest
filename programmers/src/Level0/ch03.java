package Level0;

public class ch03 {

	public static void main(String[] args) {
		int a=91;
		int b=9;
		
		StringBuffer sbf1 = new StringBuffer();
        StringBuffer sbf2 = new StringBuffer();
        sbf1.append(a);
        sbf1.append(b);
        sbf2.append(b);
        sbf2.append(a);
        String num1 = (a+"")+(b+"");
        String num2 = (b+"")+(a+"");
        System.out.println(Integer.parseInt(num1)>Integer.parseInt(num2)?num1:num2);

	}

}
