package sumi.java.exam15;

import java.io.*;

public class FileCopyEx1 {
	public static void main(String[] args) {
		System.out.println("파일복사 시작");
		long start = System.currentTimeMillis();
		FileInputStream src = null;
		FileOutputStream dest = null;
		try {
//원본 파일을 읽기 위한 FileInputStream 객체 생성
			src = new FileInputStream(new File("c:/src.zip"));
//복사본 파일을 생성하기 위한 FileOutputStream 객체생성
			dest = new FileOutputStream(new File("c:/myProject/dest.zip"));
//FileInputStream을 통해서 읽어들인 값을 저장할 변수
			int readValue = 0;
//FileInputStream의 read()메소드를 통해서 읽어들인 값을
// readValue에 저장
			while ((readValue = src.read()) != -1) {
//readValue에 저장된 값을 FileOutputStread의 write()
//메소드를 통해서 파일에 기록
				dest.write(readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dest != null) {
					dest.close();
				}
			} catch (IOException e) {
			}
			try {
				if (src != null) {
					src.close();
				}
			} catch (IOException e) {
			}
		}
		long end = System.currentTimeMillis();
		long copyTime = (end - start);
		System.out.println("걸린 시간 : " + copyTime + " 밀리 초");
	}
}
