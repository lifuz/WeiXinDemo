package com.weixin.menu;


/**
 * 复合型按钮
 * @author 半夏微凉
 *
 */
public class ComplexButtom extends Button {
	
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	

}
