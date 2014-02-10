package com.training;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Myfont extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4032723669260137667L;

	private String bgColor = "#ffffff";
	private String color = "#000000";
	private String align = "CENTER";
	private String fontSize = "3";
	private String border = "0";
	private String width = null;
	private String bordercolor = "#000000";

	public void setBgColor(String newBgColor) {
		bgColor = newBgColor;
	}

	public void setColor(String newColor) {
		color = newColor;
	}

	public void setAlign(String newAlign) {
		align = newAlign;
	}

	public void setFontSize(String newFontSize) {
		fontSize = newFontSize;
	}

	public void setBorder(String newBorder) {
		border = newBorder;
	}

	public void setWidth(String newWidth) {
		width = newWidth;
	}

	public void setBorderColor(String newBordercolor) {
		bordercolor = newBordercolor;
	}

	@Override
	public int doEndTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.print("</td></tr></table>");
		}catch(Exception e){
			System.out.println("Error in doEndTag!" + e);
		}
		return(EVAL_PAGE);

	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<table border = " + border + " bordercolor = "
					+ bordercolor);
			if (width != null) {
				out.print("WIDTH = \"" + width + "\">");
			}
			out.print("<tr><TD bgcolor = " + bgColor + ">");
			out.print("<div align = " + align + "><font size = " + fontSize
					+ " color = " + color + ">");
		} catch (Exception e) {
			System.out.println("Error in doStartTag!" + e);
		}
		return (EVAL_BODY_INCLUDE);
	}

}
