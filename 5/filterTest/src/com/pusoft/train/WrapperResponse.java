package com.pusoft.train;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WrapperResponse extends HttpServletResponseWrapper {
	public static final int OT_NONE = 0, OT_WRITER = 1, OT_STREAM = 2;
	private int outputType = OT_NONE;
	private ServletOutputStream output = null;
	private PrintWriter writer = null;
	private ByteArrayOutputStream buffer = null;

	public WrapperResponse(HttpServletResponse response) {
		super(response);
		buffer = new ByteArrayOutputStream();
	}

	public PrintWriter getWriter() throws IOException {
		if (outputType == OT_STREAM)
			throw new IllegalStateException(); // 已经用了OutputStream流          
		else if (outputType == OT_WRITER)
			return writer;
		else {
			outputType = OT_WRITER;
			writer = new PrintWriter(new OutputStreamWriter(buffer,
					getCharacterEncoding()));
		}
		return writer;
	}

	public void flushBuffer() throws IOException {
		if (outputType == OT_WRITER)
			writer.flush();
		if (outputType == OT_STREAM)
			output.flush();
	}

	public void reset() {
		outputType = OT_NONE;
		buffer.reset();
	}

	public String getResponseData() throws IOException {
		flushBuffer();
		return new String(buffer.toByteArray());
	}

	class WrappedOutputStream extends ServletOutputStream {
		private ByteArrayOutputStream buffer;

		public WrappedOutputStream(ByteArrayOutputStream buffer) {
			this.buffer = buffer;
		}

		@Override
		public void write(int b) throws IOException {
			buffer.write(b);
		}

		public byte[] toByteArray() {
			return buffer.toByteArray();
		}
	}

	// 得到字节输出流
	public ServletOutputStream getOutputStream() throws IOException {
		if (outputType == OT_WRITER)
			throw new IllegalStateException();
		// 已经用了Writer流
		else if (outputType == OT_STREAM)
			return output;
		else {
			outputType = OT_STREAM;
			output = new WrappedOutputStream(buffer);
		}
		return output;
	}

}
