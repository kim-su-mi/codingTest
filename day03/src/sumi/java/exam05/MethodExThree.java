package sumi.java.exam05;
/**
 * 자바 자료 - 6강 객체지향 프로그래밍
 * Q2.) 전역변수,지역변수 이름 같을 때 어떻게 구분? 
 * 		-> this사용 (이클 day3 - exam12참고)
 *
 */
public class MethodExThree {
	int var; // var: 전역변수
	public void setVar(int var){  // var: 지역변수
		var = var; // 문제 발생
//		this.var = var => 해결: this.var-전역변수 / var: 지역변수
		}
	public int getVar(){
		return var;
		}
	public static void main(String[] ar){
		MethodExThree me = new MethodExThree();
		me.setVar(1000);
		System.out.println("var : "+ me.getVar());
	}

}
