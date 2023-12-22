package sumi.java.exam11;
/**
 * c드라이브에 있는 모근 파일 목록 출력
 */
import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("c:/");
		if (directory.exists()) {
			if (directory.isDirectory()) {
				//현재 디렉토리내의 모든 파일 디렉토리의 이름 얻기
				String[] fileNameList = directory.list();
				for (String fileName : fileNameList) {
					File myFile = new File(directory, fileName);
					if(myFile.isFile())
					System.out.println("파일 이름 : " + myFile.getName() +
							", 파일크기 : " + myFile.length() + "byte");
					else
						System.out.println("폴더이름: " + myFile.getName());
				}
			}
		}
	}
}
