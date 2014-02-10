

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerBean {
	// 描述UDP通讯的DatagramSocket对象
	private DatagramSocket ds;
	// 用来封装通讯字符串
	private byte buffer[];
	// 客户端的端口号
	private int clientport;
	// 服务器端的端口号
	private int serverport;
	// 通讯内容
	private String content;
	// 描述通讯地址
	private InetAddress ia;

	// 以下是各属性的Get和Set类型方法
	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public int getClientport() {
		return clientport;
	}

	public void setClientport(int clientport) {
		this.clientport = clientport;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DatagramSocket getDs() {
		return ds;
	}

	public void setDs(DatagramSocket ds) {
		this.ds = ds;
	}

	public InetAddress getIa() {
		return ia;
	}

	public void setIa(InetAddress ia) {
		this.ia = ia;
	}

	public int getServerport() {
		return serverport;
	}

	public void setServerport(int serverport) {
		this.serverport = serverport;
	}

	public ServerBean() throws SocketException, UnknownHostException {
		buffer = new byte[1024];
		clientport = 1985;
		serverport = 1986;
		content = "";
		ds = new DatagramSocket(serverport);
		ia = InetAddress.getByName("localhost");
	}

	public void listenClient() throws IOException {
		// 在循环体里接收消息
		while (true) {
			// 初始化DatagramPacket类型的变量
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			// 接收消息，并把消息通过dp参数返回
			ds.receive(dp);
			content = new String(dp.getData(), 0, dp.getLength());
			// 打印消息
			print();
		}
	}

	public void print() {
		System.out.println(content);
	}

}
