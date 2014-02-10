

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UDPClient extends Thread {
	public static String content;
	public static ClientBean client;

	public void run() {
		try {
			client.setContent(content);
			client.sendToServer();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}// end of run

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		client = new ClientBean();
		System.out.println("客户端启动...");
		while (true) {
			// 接收用户输入
			content = br.readLine();
			// 如果是end或空,退出循环
			if (content == null || content.equalsIgnoreCase("end")
					|| content.equalsIgnoreCase("")) {
				break;
			}
			// 开启新线程，发送消息
			new Thread(new UDPClient()).start();
		}
	}
}
