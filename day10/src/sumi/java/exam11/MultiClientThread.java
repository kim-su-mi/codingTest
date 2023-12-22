package sumi.java.exam11;

public class MultiClientThread extends Thread {
	private MultiClient mc;

	public MultiClientThread(MultiClient mc) {
		this.mc = mc;
	}

	public void run() {
		String message = null;
		String[] receivedMsg = null;
		boolean isStop = false;
		while (!isStop) {
			try {
				message = (String) mc.getOis().readObject();
				receivedMsg = message.split("#"); // '#' 문자를 기준으로 메시지 분리
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receivedMsg[0] + "," + receivedMsg[1]);
			if (receivedMsg[1].equals("exit")) {
				if (receivedMsg[0].equals(mc.getId())) { // 클라이언트 자신의 종료 메시지인 경우
					mc.exit();
				} else { // 다른 클라이언트의 종료 메시지인 경우
					mc.getJta().append(receivedMsg[0] + "님이 종료 하셨습니다." + System.getProperty("line.separator"));
					mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
					// 종료 메시지를 메시지 출력 영역에 추가하고 스크롤바를 아래로 이동
				}
			} else {

				mc.getJta().append(receivedMsg[0] + " : " + receivedMsg[1] + System.getProperty("line.separator"));
				mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
				// 일반 메시지를 메시지 출력 영역에 추가하고 스크롤바를 아래로 이동
			}
		}
	}
}