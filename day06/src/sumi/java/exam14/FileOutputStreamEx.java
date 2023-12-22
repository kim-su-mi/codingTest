package sumi.java.exam14;

import java.io.*;

public class FileOutputStreamEx {
	public static void main(String arg[]) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("c:\\myProject\\fileout.txt");
			String message = "Hello FileOutputStream!!";
			fos.write(message.getBytes());
			fos.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}