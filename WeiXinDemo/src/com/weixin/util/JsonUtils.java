package com.weixin.util;

import java.util.ArrayList;
import java.util.List;

import com.weixin.model.Data;
import com.weixin.model.ModelMessage;

public class JsonUtils {
	
	/**
	 * 生成模板消息的message
	 */
	
	
	public static String getJson(ModelMessage mm){
		
		StringBuilder sb = new StringBuilder();
		
		
		if(mm != null) {
			sb.append("{");
			sb.append("\"touser\":\"").append(mm.getTouser()).append("\",");
			sb.append("\"template_id\":\"").append(mm.getTemplate_id()).append("\",");
			sb.append("\"url\":\"").append(mm.getUrl()).append("\",");
			sb.append("\"topcolor\":\"").append(mm.getTopcolor()).append("\",");
			sb.append("\"data\":").append("{");
			for(Data data:mm.getData()){
				sb.append("\""+data.getName()+"\":");
				sb.append("{");
				sb.append("\"value\":\"").append(data.getValue()).append("\",");
				sb.append("\"color\":\"").append(data.getColor());
				sb.append("\"},");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}}");
			
		}
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ModelMessage mm = new ModelMessage();
		mm.setTouser("nnn");
		mm.setTemplate_id("ZTEv4LPt3zCD-OZ1Go88cdGbZwlZ7SzAtJymZPhLcWM");
		mm.setUrl("http://www.baidu.com");
		mm.setTopcolor("#FF0000");
		List<Data> list = new ArrayList<Data>();
		Data data = new Data();
		data.setName("first");
		data.setValue("您好，您的智能设备已被成功绑定");
		data.setColor("#173177");
		list.add(data);
		data = new Data();
		data.setName("keyword1");
		data.setValue("0001");
		data.setColor("#173177");
		list.add(data);
		data = new Data();
		data.setName("keyword2");
		data.setValue("2014年7月21日 18:36");
		data.setColor("#173177");
		list.add(data);
		data = new Data();
		data.setName("keyword3");
		data.setValue("2");
		data.setColor("#173177");
		list.add(data);
		data = new Data();
		data.setName("remark");
		data.setValue("请认真核实绑定用户数量，及时更改绑定密码。");
		data.setColor("#173177");
		list.add(data);
		
		mm.setData(list);
		System.out.println(getJson(mm));
	}

}
