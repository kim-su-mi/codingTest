package sumi.java.cms;
/**
 * 
 * 6. 새파일 / 7. 불러오기 / 8. 저장하기 / 9. 새 이름으로 저장하기
 * 추가 메서드 작업
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomerManager {
	// 멤버필드
	private boolean isStop;
	private BufferedReader br;
	private ArrayList<Customer> data;
	private int position;
	private File file;
	
	// 생성자
	public CustomerManager() {
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
			System.out.println("1. 고객정보등록");
			System.out.println("2. 고객정보검색");
			System.out.println("3. 고객정보수정");
			System.out.println("4. 고객정보삭제");
			System.out.println("5. 전체목록보기");
			System.out.println("6. 새파일");
			System.out.println("7. 불러오기");
			System.out.println("8. 저장하기");  // 저장하기 처음에는 새이름으로 저장하기 수정후 다시 저장하면 원래 있던 파일에 덮어씀 
			System.out.println("9. 새 이름으로 저장하기"); // 원래 있던 파일 그대로 두고 항상 다른 이름으로 새로 저장
			System.out.println("0. 프로그램종료");
			System.out.print("메뉴선택 : ");
			
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
			case 7: openFile(); break;
			case 8: saveFile(); break;
			case 9: saveAsFile(); break;
			case 0: stop(); break;
			default: 
				System.err.println("\n메뉴입력오류 : 확인하시고 다시 입력해주세요."); 
				break;
			}
			System.out.println();
		}//end while
	}
	
	//3.
	public void saveAsFile() throws IOException {  // 저장하기랑 똑같은데 항상 파일명 물어봐야함
		System.out.println();
		System.out.println("저장할 파일명은 = ");
		String fileName = br.readLine();  
		// 여기서 파일명 입력안하고 그냥 엔터치면 문제 생겨서 처리해줌
		if(fileName.length() == 0) {
			System.err.println("파일명은 반드시 입력해야합니다.");  // err로하면 빨간색으로 나옴
			return; // 파일명 입력안했으므로 더이상 진행하면 안돼서 리턴
		}
		file = new File(fileName);
//		saveData();
		saveObject();
	}
	
	//1. 저장먼저 작업 
	public void saveFile() throws IOException { 
		// 이미 파일명 알고 있음 = 이미 파일 존재하면 저장해줌
		System.out.println();
		if (file == null) {  // file변수 생성/ 만약 아직 파일이 없으면 저장할 파일명 물어서 파일 객체 만들어 저장
			System.out.println("저장할 파일명은 = ");
			String fileName = br.readLine(); 
			// 여기서 파일명 입력안하고 그냥 엔터치면 문제 생겨서 처리해줌
			if(fileName.length() == 0) {
				System.err.println("파일명은 반드시 입력해야합니다.");
				return; // 파일명 입력안했으므로 더이상 진행하면 안돼서 리턴
			}
			file = new File(fileName);
		}
//		saveData(); // 저장해주는 기능은 메서드로 뺌
		saveObject();
	}
	
	// 새로추가 1
	public void saveObject() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			for (int i =0; i<data.size(); i++) {
				Customer myCustomer = data.get(i);
				oos.writeObject(myCustomer);
			}
			System.out.println("성공적으로 파일에 저장했습니다.");
		}catch(FileNotFoundException fnfe) {
			System.err.println("경로 또는 파일명에 오류가 있습니다");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {if(oos != null) oos.close(); } catch(IOException ioe) {}
			try {if(fos != null) fos.close(); } catch(IOException ioe) {}
		}
		
	}

	// 4.
	public void openFile() throws IOException { 
		System.out.println();
		System.out.println("불러올 파일명은 = ");
		String fileName = br.readLine(); 
		// 여기서 파일명 입력안하고 그냥 엔터치면 문제 생겨서 처리해줌
		if(fileName.length() == 0) {
			System.err.println("파일명은 반드시 입력해야합니다.");
			return; // 파일명 입력안했으므로 더이상 진행하면 안돼서 리턴
		}
		file = new File(fileName);  // 파일객체 생성
//		openData();  // 기능 메서드로 뺌
		loadObject();
	}
	
//	새로추가 2
	public void loadObject() {
		data.clear();
		position = -1;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			while(true) {
				Customer myCustomer = (Customer) ois.readObject();
				data.add(myCustomer);
			}
		}catch(EOFException eofe) {
			System.out.println("파일의 끝까지 데이터를 로딩하였습니다");
		} catch(ClassNotFoundException cnfe){
			System.err.println("해당 객체를 찾을 수 없습니다");
		}catch(FileNotFoundException fnfe) {
			System.err.println("경로 또는 파일명에 오류가 있습니다");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {if(ois != null) ois.close(); } catch(IOException ioe) {}
			try {if(fis != null) fis.close(); } catch(IOException ioe) {}
		}
	}

	// 6.
	public void newFile() {  // 기존에 있던 데이터 다 날림
		System.out.println();
		data.clear();
		position = -1;
		file = null;
		System.out.println("새로운 파일로 초기화됐습니다. ");
	}
	
	//5.
	public void openData() {  // 파일에서 데이터 불러오는 메서드
		
		//기존에 있던 데이터 지움 = 초기화필요! / 7번 누르고 5번보고 다시 7번 누르고 5번 보면 똑같은게 2번 반복 그래서 초기화 필요
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
	// 2.
	public void saveData() { // 파일에 저장
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);  // true옵션주면 outo flash하겠다는 뜻
			for(int i =0; i<data.size(); i++) {
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

	public void display() {
		System.out.println();
		for(int i=0; i<data.size(); i++) {
			Customer myCustomer = data.get(i);
			System.out.println(myCustomer.toString());
		}
	}

	public void addCustomer() throws IOException {
		System.out.println();
		
		System.out.print("고객이름 = ");
		String name = br.readLine();
		System.out.print("나이 = ");
		int age = Integer.parseInt(br.readLine());
		System.out.print("전화번호 = ");
		String phone = br.readLine();
		System.out.print("주소 = ");
		String address = br.readLine();
		
		Customer myCustomer = new Customer(name, age, phone, address);
		data.add(myCustomer);
		System.out.println("성공적으로 고객정보를 저장하였습니다.");		
	}

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

	private void searchCustomer() throws IOException {
		System.out.println();
		position = -1;
		System.out.print("찾으시는 고객 이름 = ");
		String name = br.readLine();
		for(int i=0; i<data.size(); i++) {
			Customer myCustomer = data.get(i);
			if(myCustomer.getName().equals(name)) {
				System.out.println(name + "님의 고객정보 검색 성공");
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
