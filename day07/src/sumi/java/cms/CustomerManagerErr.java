package sumi.java.cms;
/**
 * 내가 다시 짜본 1차 과제 - 종합예제
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomerManagerErr {
	// 멤버필드
	private boolean isStop;
	private BufferedReader br;
	private ArrayList<Customer> data;
	private int position;
	private File file;
	
	// 생성자
	public CustomerManagerErr() {
		isStop = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		data = new ArrayList<Customer>();
		position = -1;
		file = null;
	}
	
	
	// 메서드
	public void start() throws IOException {
		int menu = -1;
		
		while(!isStop) {
			System.out.println("1. 고객정보 등록");
			System.out.println("2. 고객정보 검색");
			System.out.println("3. 고객정보 수정");
			System.out.println("4. 고객정보 삭제");
			System.out.println("5. 전체 목록보기");
			System.out.println("6. 새파일");
			System.out.println("7. 불러오기");
			System.out.println("8. 저장하기");
			System.out.println("9. 새 이름으로 저장하기");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
			
			try {
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				menu = -1;
			}
			
			switch(menu) {
			case 1: addCustomer(); break;
			case 2: searchCustomer(); break;
			case 3: updateCustomer(); break;
			case 4: deleteCustomer(); break;
			case 5: display(); break;
			case 6: newFile(); break;
			case 7: openfile(); break;
			case 8: saveFile(); break;
			case 9: saveAsFile(); break;
			case 0: stop(); break;
			default : 
				System.err.println("/n메뉴 입력 오류 : 확인하시고 메뉴를 다시 입력해주세요.");
				break;
			}
		
		
		}// end while
	} //end start()
	
	public void saveAsFile() throws IOException {
		System.out.println();
		System.out.println("저장할 파일명 = ");
		String fileName = br.readLine();
		if(fileName.length() == 0) {
			System.err.println("파일명은 반드시 입력해야합니다.");
			return; // 파일명 입력안했으므로 더이상 진행하면 안돼서 리턴
		}
		file = new File(fileName);	
		saveData();
	}
	


	public void saveFile() throws IOException {
		System.out.println();
		if (file == null) {
			System.out.println("저장할 파일명 = ");
			String fileName = br.readLine();
			if(fileName.length() == 0) {
				System.err.println("파일명은 반드시 입력해야합니다.");
				return; // 파일명 입력안했으므로 더이상 진행하면 안돼서 리턴
			}
			file = new File(fileName);	
		}
		saveData();
	}


	private void saveData() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);
			for(int i = 0; i<data.size(); i++) {
				Customer myCustomer = data.get(i);
				StringBuffer sb = new StringBuffer();
				sb.append(myCustomer.getName()); sb.append("/");
				sb.append(myCustomer.getAge()); sb.append("/");
				sb.append(myCustomer.getPhone()); sb.append("/");
				sb.append(myCustomer.getAddress());	
				pw.println(sb.toString());
			}
			System.out.println("파일에 성공적으로 저장하였습니다.");
		} catch(FileNotFoundException fnfe) {
			System.err.println("경로 입력이 잘못되었습니다.");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if(pw != null) pw.close();  // 연거 다시 닫아줌, 이건 예외 안생겨서 예외처리 안함
			try { if(bw != null) bw.close(); } catch(IOException ioe) {}
			try { if(fw != null) fw.close(); } catch(IOException ioe) {}
		}
	}


	public void openfile() throws IOException {
		System.out.println();
		System.out.println("불러올 파일명은 = ");
		String fileName = br.readLine();
		if(fileName.length() == 0) {
			System.err.println("파일명은 반드시 입력해야합니다.");
			return; // 파일명 입력안했으므로 더이상 진행하면 안돼서 리턴
		}
		file = new File(fileName);  // 파일객체 생성
		openData();
	}


	private void openData() {
		data.clear();
		position = -1;
		
		FileReader fr = null;
		BufferedReader brr = null;
		try {
			fr = new FileReader(file);
			brr = new BufferedReader(fr);
			String mydata = "";
			while((mydata = brr.readLine()) != null ) {
				String[] imsi = mydata.split("/"); // 데이터를 /기준으로 잘라서 배열에 담음
				Customer myCustomer = new Customer(imsi[0], Integer.parseInt(imsi[1]),imsi[2],imsi[3]);
				data.add(myCustomer);
			}
			System.out.println("성공적으로 데이터를 로딩했습니다");
					
		}catch(FileNotFoundException fnfe) {
			System.err.println("경로 또는 파일명에 오류가 있습니다");
		}catch(IOException ioe) {
			ioe.printStackTrace();
			
		}finally {
			try {if(brr != null) brr.close(); } catch(IOException ioe) {}
			try {if(fr != null) fr.close(); } catch(IOException ioe) {}
		}
			
	}


	public void newFile() {
		System.out.println();
		data.clear();
		position = -1;
		file = null;
		System.out.println("새로운 파일로 초기화됐습니다. ");
	}


	// 2번째
	public void addCustomer() throws IOException {
		System.out.println();
		
		System.out.println("고객이름 : ");
		String name = br.readLine();
		System.out.println("나이 : ");
		int age = Integer.parseInt(br.readLine());
		System.out.println("전화번호 : ");
		String phone = br.readLine();
		System.out.println("주소 : ");
		String address = br.readLine();
		
		Customer myCustomer = new Customer(name,age,phone,address);
		data.add(myCustomer);
		System.out.println("성공적으로 고객정보를 저장했습니다.");
	}

	// 4번째
	public void searchCustomer() throws IOException {
		System.out.println();
		position = -1;
		System.out.println("찾으시는 고객 이름은? : ");
		String name = br.readLine();
		for(int i=0; i<data.size(); i++) {
			Customer myCustomer = data.get(i);
			if(myCustomer.getName().equals(name)){
				System.out.println(name+"님의 고객 정보 검색을 성공했습니다");
				position = i;
			}
		}
		if (position<0) {
			System.out.println(name+"님은 저희 고객이 아닙니다. 고객정보를 등록하세요.");
		}
	}

	//6번째
	public void updateCustomer() throws IOException {
		System.out.println();
		if(position<0) {
			System.out.println("고객정보검색을 먼저 수행해주세요");
			return;
		}
		
		Customer myCustomer = data.get(position);
		boolean isLoop = true;
		int menu = -1;
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
			switch (menu) {
			case 1: 
				System.out.println("수정할 전화 번호 = ");
				String imsiphone = br.readLine();
				myCustomer.setPhone(imsiphone);
				System.out.println("전화번호를 성공적으로 수정했습니다.");
				isLoop = false;
				break;   // 여기에 브레이크 안써주면 2번으로 감 1번에서 끝내게 하려고 break씀
			case 2: 
				System.out.println("수정할 주소 = ");
				String imsiAddress = br.readLine();
				myCustomer.setAddress(imsiAddress);
				System.out.println("주소를 성공적으로 수정했습니다.");
				isLoop = false;
				break;
			case 0: 	
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
		}
	}

	// 5번째
	public void deleteCustomer() throws IOException {
		System.out.println();
		if(position<0) {
			System.out.println("고객정보 검색을 먼저 수행하셔야합니다.");
			return;  // delete메서드를 호출한게 start/ 리턴하므로써 딜리트 메서드 긑났으므로 딜리트를 호출한 start()의 와일문으로 감
		}
		Customer myCustomer = data.get(position);
		System.out.println(myCustomer.getName()+"님의 정보를 정말로 삭제하시겠습니까? (y/n)");
		String result = br.readLine();
		if(result.equals("Y") || result.equals("y")) {
			System.out.println(myCustomer.getName()+"님의 정보를 삭제합니다");
			data.remove(position);
			position = -1;
		} else {
			System.out.println(myCustomer.getName()+"님의 정보 삭제를 취소하였습니다.");
		}
	}

	// 3번째
	public void display() {
		System.out.println();
		for(int i = 0; i<data.size(); i++ ) {
			Customer myCustomer = data.get(i);
			System.out.println(myCustomer.toString());
		}
		System.out.println();
	}

	// 1번째
	public void stop() throws IOException {
		System.out.println();
		System.out.println("정말로 종료하시겠습니까? (y/n)");
		String result = br.readLine();
		if(result.equals("Y") || result.equals("y")) {
			System.out.println("프로그램을 종료합니다");
		}
		System.out.println();
		isStop = true;  // 끝나면 다시 start()로 돌아가는데 isStop값 지금 트루 while문의 (!isStop)만나면 false로 바껴서 종료
		
	} // end stop()


	public static void main(String[] args) {
		CustomerManagerErr manager = new CustomerManagerErr();
		try {
			manager.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}