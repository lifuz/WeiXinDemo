package com.prd.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prd.connect.MySqlConnection;
import com.weixin.model.Data;
import com.weixin.model.ModelMessage;
import com.weixin.pojo.Token;
import com.weixin.util.CommonUtil;
import com.weixin.util.JsonUtils;

public class TestWendu {

	public static void main(String[] args) throws Exception {
		Connection conn = MySqlConnection.getConnection();
		while(true){
			Thread.sleep(5000);
			String sql ="select * from tes order by time desc";
			PreparedStatement pt = null;
			pt = conn.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			rs.next();
			String wendu = rs.getString(2);
			int cardid = rs.getInt(4);
			
			if(Integer.parseInt(wendu) > 30) {
				sql ="select * from query_terminal where cardId = ?";
				pt = conn.prepareStatement(sql);
				pt.setInt(1, cardid);
				rs = pt.executeQuery();
				rs.next();
				Token token = CommonUtil.getToken("wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2");
				
				String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
				
				url = url.replace("ACCESS_TOKEN", token.getAccessToken());
				
				ModelMessage mm = new ModelMessage();
				
				mm.setTouser(rs.getString(4));
				mm.setTemplate_id("rhc3ErrSVxhz0eR3IazQlCKpWmwUfK9xlECZkRhJw9s");
				mm.setUrl("http://www.baidu.com");
				mm.setTopcolor("#FF0000");
				List<Data> list = new ArrayList<Data>();
				Data data = new Data();
				data.setName("first");
				data.setValue("设备监控警告");
				data.setColor("#173177");
				list.add(data);
				data = new Data();
				data.setName("content");
				data.setValue(rs.getInt(7)+"号设备温度过高，当前温度：" + wendu);
				data.setColor("#173177");
				list.add(data);
				data = new Data();
				data.setName("occurtime");
				data.setValue(new Date().toString());
				data.setColor("#173177");
				list.add(data);
				
				data = new Data();
				data.setName("remark");
				data.setValue("请尽快处理（您可以点击这里参考告警类型说明及处理建议）.");
				data.setColor("#173177");
				list.add(data);
				
				mm.setData(list);
				String json = JsonUtils.getJson(mm);
				CommonUtil.httpsRequest(url, "POST", json);
				
			}
		}
		
	}
	
}
