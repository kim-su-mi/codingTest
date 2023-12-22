package sumi.java.exam19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CustomerManager {
	// 멤버필드
	// 멤버필드에서는 변수 선언만 한다.
	private boolean isStop;
	private BufferedReader br;
	private ArrayList<Customer> data;
	private int position;
	
	// 생성자
	// 변수 초기화는 생성자에서 작업
	public CustomerManager() {
		isStop = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		data = new ArrayList<Customer>();
		position = -1;
	}
	
	// 메서드
	// 시작 메서드
	public void start() throws IOException {
		int menu = -1;
		
		// isStop이 true일 동안 메뉴를 뿌려줌
		while(!isStop) {
			System.out.println("1. 고객가입");
			System.out.println("2. 고객검색");
			System.out.println("3. 고객수정");
			System.out.println("4. 고객탈퇴");
			System.out.println("5. 전체목록");
			System.out.println("0. 프로그램종료");
			System.out.print("메뉴선택 : ");
			
			// 사용자한테 입력 받은 메뉴를 숫자로 형변환해서 menu변수에 저장
			try {
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				menu = -1;
			} 
			
			// 메뉴의 각 기능은 메서드로 뺌
			// 정해진 메뉴 숫자외에 다른 숫자 입력시 오류 메세지 출력
			// break문 써준 이유 : 선택한 메뉴에 해당하는 기능만 수행하게 하려고
			// 만약 break문이 없다면 case1수행후 case2수행-> case3수행 이렇게 끝까지 감
			switch(menu) {
			case 1: addCustomer(); break;
			case 2: searchCustomer(); break;
			case 3: updateCustomer(); break;
			case 4: deleteCustomer(); break;
			case 5: display(); break;
			case 0: stop(); break;
			default: 
				System.err.println("\n메뉴입력오류 : 확인하시고 다시 입력해주세요."); 
				break;
			}
			System.out.println();
		}//end while
	}
	
	// 1.종료 메서드
	// 종료 선택시 y/n 사용자 입력 받아서 result변수에 저장
	// result가 String타입이라 ==비교가 아니라 .equals로 비교
	// 사용자가 대,소문자로 입력할 수 있으니까 두 가지 경우 모두 생각해서 or연산자 사용
	// 입력값이 y나Y면 프로그램 종료 메세지 출력하고 for문 돌려서
	// 0.5초 간격으로 점 하나씩 10개 출력
	// isStop을 true로 바꿔 다시 start()메서드로 돌아갔을 때
	// while문의 (!isStop)만나면 false로 바껴서 while문 종료해서 프로그램 끝남
	public void stop() throws IOException {
		System.out.println();
		System.out.print("정말로 프로그램을 종료하시겠습니까? (y/n) : ");
		String result = br.readLine();
		if(result.equals("Y") || result.equals("y")) {
			System.out.print("프로그램을 종료합니다.");
			for(int i=0; i<10; i++) {
				try {
					Thread.sleep(500);
					System.out.print(".");
				} catch (InterruptedException e) {
				}
			}
			System.out.println();
			isStop = true;
		}
	}
	
	// 3. 전체 회원목록 조회
	// ArrayList에 저장된 모든 회원정보를 data의 크기만큼 for문 돌면서 
	// myCustomer에 저장한다음 문자열로 바꿔서 출력
	public void display() {
		System.out.println();
		for(int i=0; i<data.size(); i++) {
			Customer myCustomer = data.get(i);
			System.out.println((i+1)+"번째 고객정보");
			System.out.println(myCustomer.toString());
		}
	}
	// 2.회원 등록 메서드
	// 이름,나이,전화번호,주소 입력 받아서 각 변수에 저장
	// 고객 클래스 만들고 고객객체 생성해서 ArrayList에 고객 정보 저장
	// 마지막으로 고객정보 저장했다는 메세지 출력
	public void addCustomer() throws IOException {
		System.out.println();
		
		System.out.print("고객이름 : ");
		String name = br.readLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(br.readLine());
		System.out.print("전화번호 : ");
		String phone = br.readLine();
		System.out.print("주소 : ");
		String address = br.readLine();
		
		Customer myCustomer = new Customer(name, age, phone, address);
		data.add(myCustomer);
		System.out.println("성공적으로 가입하였습니다.");		
	}
	
	// 5.회원 삭제 메서드
	// position이 0보다 작으면 회원 검색을 하지않은 것이므로 고객정보 검색 먼저하라고 메세지 출력
	// 고객정보 검색이 선행되었다면 position이 그 고객이 저장된 번호로 바뀌었을 것이기에
	// 그 위치의 고객 이름을 가져와 정말 삭제할거냐고 한번 더 확인
	// Y or y입력하면 그 고객의 정보 삭제했다는 메세지 출력하고 그 위치의 고객을 data에서 삭제한다음
	// 다시 position을 -1로 초기화해줌
	public void deleteCustomer() throws IOException {
		System.out.println();
		if(position < 0) {
			System.out.println("고객정보검색을 먼저 수행하셔야 합니다.");
			return;
		}
		
		Customer myCustomer = data.get(position);
		System.out.print(myCustomer.getName() + "님의 정보를 정말로 삭제하시겠습니까? (y/n) : ");
		String result = br.readLine();
		if(result.equals("Y") || result.equals("y")) {
			System.out.println(myCustomer.getName() + "님의 고객정보 삭제 성공.");
			data.remove(position);
			position = -1;
		}else {
			System.out.println(myCustomer.getName() + "님의 고객정보 삭제 취소.");
		}
	}
	
	// 6. 회원정보 수정 메서드 
	// position이 0보다 작으면 회원 검색을 하지않은 것이므로 고객정보 검색 먼저하라고 메세지 출력
	// 수정 옵션이 2개라서 다시 작은 선택 메뉴 뿌려줌
	// 고른 메뉴 값  menu변수에 담아 int로 형변환
	// 고른 메뉴에 따라 switch문으로 처리
	public void updateCustomer() throws IOException {
		System.out.println();
		if(position < 0) {
			System.out.println("고객정보검색을 먼저 수행하셔야 합니다.");
			return;
		}
		Customer myCustomer = data.get(position);
		
		boolean isLoop = true; int menu = -1;
		while(isLoop) {
			System.out.println(myCustomer.getName() + "님의 고객정보수정");
			System.out.println("1. 전화번호수정");
			System.out.println("2. 주소수정");
			System.out.println("0. 수정취소");
			System.out.print("메뉴선택 : ");
			
			try {
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				menu = -1;
			} 
			
			System.out.println();
			switch(menu) {
			case 1 :
				System.out.print("수정할 전화번호 = ");
				String imsiPhone = br.readLine();
				myCustomer.setPhone(imsiPhone);
				System.out.println("성공적으로 전화번호를 수정하였습니다.");
				isLoop = false;
				break;
			case 2 :
				System.out.print("수정할 주소 = ");
				String imsiAddresss = br.readLine();
				myCustomer.setAddress(imsiAddresss);
				System.out.println("성공적으로 주소를 수정하였습니다.");
				isLoop = false;
				break;
			case 0 :
				System.out.print(myCustomer.getName() + "님의 정보수정을 취소하시겠습니까? (y/n) : ");
				String result = br.readLine();
				if(result.equals("Y") || result.equals("y")) {
					System.out.println(myCustomer.getName() + "님의 고객정보수정을 취소합니다.");
					isLoop = false;
				}
				break;
			default :
				System.err.println("\n메뉴입력오류 : 확인하시고 다시 입력해주세요."); 
				break;
			}
			System.out.println();
		}//end while
	}
	// 4. 회원 1면 정보 검색
	// 찾으려는 고객 이름 입력받고 data의 0번째부터 data배열의 크기만큼 
	// 저장된 정보를 myCustomer변수에 담아 그 이름이 입력받은 이름이랑 같으면
	// 고객정보 검색 성공이라는 메세지 출력하고 몇 번째인지 position을 기억
	// 만약 position이 -1그대로로 0보다 작다면 고객정보에 일치하는 이름이 
	// 없는 것이므로 고객이 아니라는 메세지 출력
	private void searchCustomer() throws IOException {
		System.out.println();
		position = -1;
		System.out.print("찾으시는 고객 이름 = ");
		String name = br.readLine();
		for(int i=0; i<data.size(); i++) {
			Customer myCustomer = data.get(i);
			if(myCustomer.getName().equals(name)) {
				System.out.println("검색에 성공하였습니다.");
				position = i;
			}
		}
		if(position < 0) {
			System.out.println(name + "님의 저의 고객이 아닙니다. 고객정보를 등록하세요.");
		}
	}
	
	public static void main(String[] args) {
		CustomerManager manager = new CustomerManager();
		try {
			manager.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
