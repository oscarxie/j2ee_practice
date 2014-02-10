

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingLister {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	static JTextField l = new JTextField(20);

	public static void main(String[] args) {
		JFrame jf = new JFrame("测试程序");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		jf.setContentPane(contentPane);
		JButton b = new JButton("清空文本框中的信息");
		contentPane.add(l, "North");
		contentPane.add(b, "South");
		ActionListener ac = new ActionHandler();// 创建一个事件监听器
		b.addActionListener(ac); // 向事件源注册
	}
}

// 定义实现事件监听类
class ActionHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		new SwingLister().l.setText("");
	}
}
