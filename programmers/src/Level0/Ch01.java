package Level0;

public class Ch01 {
	public static void main(String[] args) {
//		int sum=0;
//		String num_str = "123456789";
//		
//		 for(int i=0; i<num_str.length(); i++){
//	           sum += num_str.charAt(i) - '0';
//	       }
//		 
//		 System.out.println(sum);
		String my_string = "He11oWor1d";
		String overwrite_string = "lloWorld";
		System.out.println(my_string.substring(0,2));
		System.out.println("치환문자열 길이"+overwrite_string.length());
		//String str = my_string.substring(0,2);
		System.out.println(my_string.substring(0,2)+overwrite_string);
	}
//	public static void main(String[] args) {
//		String str = "12345";
//		int sum = 0;
//		
//		for(int i=0; i<str.length(); i++) {
//			sum += str.charAt(i) - '0';
//		}
//		System.out.println("sum = " + sum);
//	}//main

}
