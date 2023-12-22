package Level1;

public class ch3 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index =5;
		
		String result = "";
		char ch;
		
		for(int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			for(int j=0; j<index; j++) {
				ch++;
				if(ch>'z') { ch -= ('z'-'a'+1); }
				if(skip.contains(String.valueOf(ch))) { j--; }
			}
			result += ch;
		}
		System.out.println(result);
	}

}
