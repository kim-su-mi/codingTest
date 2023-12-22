package sumi.java.exam24;

import java.io.*;

public class PrintWriterEx {
	public static void main(String arg[]) {
		PrintWriter pw = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("c:\\myProject\\printWriter.txt");
			bos = new BufferedOutputStream(fos);
			pw = new PrintWriter(bos, true);
			pw.println("안녕하세여!!");
			pw.println("또 만났네요.");
			pw.println(100.0);
			pw.println(Boolean.valueOf(true));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
			try {
				if (bos != null)
					bos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}