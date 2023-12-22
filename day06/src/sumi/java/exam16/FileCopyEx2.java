package sumi.java.exam16;

import java.io.*;

public class FileCopyEx2 {
	public static void main(String[] args) {
		System.out.println("파일복사 시작");
		long start = System.currentTimeMillis();
		FileInputStream src = null;
		FileOutputStream dest = null;
		try {
			src = new FileInputStream("c:/src.zip");
			dest = new FileOutputStream("c:/myProject/dest.zip");
			//임시저장소에 저장된 data의 전체갯수를 저장할 변수
			int length = 0;
			//임시저장소로 사용될 byte[]배열 선언
			byte[] buffer = new byte[1024 * 8];
			//inputstream을 통해서 읽어들인 data를 임시저장소에
			//쌓고 저장된 data의 갯수를 length에 저장한다. 
			while ((length = src.read(buffer)) != -1) {
				//outputStream을 통해서 임시저장소에 쌓여있는
				//data을 length만큼 파일에 기록한다. 
				dest.write(buffer, 0, length);
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
		long copyTime = (end - start) ;
		System.out.println("걸린 시간 : " + copyTime + " 밀리 초");
	}
}
