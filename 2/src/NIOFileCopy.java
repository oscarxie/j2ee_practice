

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class NIOFileCopy {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String infile = "C:\\hello.txt";
		String outfile = "C:\\hellocopy.txt";
		// 获取源文件和目标文件的输入输出流
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(infile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			NewFile();
			AddIntoFile();
			fin = new FileInputStream(infile);
		}
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(outfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取输入输出通道
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			// clear方法重设缓冲区，使它可以接受读入的数据
			buffer.clear();
			// 从输入通道中将数据读到缓冲区
			int r = fcin.read(buffer);
			// read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
			if (r == -1) {
				break;
			}
			// flip方法让缓冲区可以将新读入的数据写入另一个通道
			buffer.flip();
			// 从输出通道中将数据写入缓冲区
			fcout.write(buffer);
		}

	}
	public static void NewFile(){
		File f=new File("c:\\hello.txt");
        try{
            f.createNewFile();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("could not create the file.");
        }
        finally
        {
        	f = null;
        }
		
	}
	
	public static void AddIntoFile() throws FileNotFoundException{
		String fileName = "c:" + File.separator + "hello.txt";
		File f = new File(fileName);
		OutputStream out = new FileOutputStream(f);
		String str = "你好";
		byte[] b = str.getBytes();
		try {
			out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
