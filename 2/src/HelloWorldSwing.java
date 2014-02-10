

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorldSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("测试窗口");// 创建顶层容器
		JPanel pane = new JPanel();// 创建中间容器
		frame.setContentPane(pane);// 将中间容器依托在顶层容器内
		JButton button = new JButton("这是一个测试按钮");// 创建一个基本组件
		pane.add(button);// 将基本组件依托在中间容器内
		frame.setVisible(true);
	}

}
