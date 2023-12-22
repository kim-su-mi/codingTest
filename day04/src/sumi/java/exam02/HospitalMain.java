package sumi.java.exam02;
/**
 * 
 * 부모 애니멀 클래스를 통해서 자식 클래스의 울음소리 통제
 * 만약 다형성 이용 안했다면 동물 소리 다르게 하기 위해 Hospital에서 울음소리 다 오버로딩 해줘야함
 *
 */
public class HospitalMain {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal tiger = new Tiger();
		hospital.inject(dog);
		hospital.inject(cat);
		hospital.inject(tiger);
		

	}

}
