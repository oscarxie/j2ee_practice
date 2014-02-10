

import java.io.IOException;

public class UDPServer {
	public static void main(String args[]) throws IOException {
		System.out.println("服务器端启动...");
		// 初始化ServerBean对象
		ServerBean server = new ServerBean();
		// 开启监听程序
		server.listenClient();
	}
}
