package com.weixin.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.weixin.pojo.SNSUserInfo;
import com.weixin.pojo.WinxinOauth2Token;

public class AdvancedUtil {
	
	/**
	 * 通过网页授权获取用户信息
	 * @param accessToken 网页授权接口调用凭证
	 * @param openId 用户标识
	 * @return SNSUserInfo
	 */
	public static SNSUserInfo getSNSUserInfo(String accessToken,String openId){
		SNSUserInfo sui = null;
		
		//拼接请求地址
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		url = url .replace("ACCESS_TOKEN", accessToken);
		url = url.replace("OPENID", openId);
		
		//通过网页授权获取用户信息
		
		JSONObject jb = CommonUtil.httpsRequest(url, "GET", null);
		
		if(null != jb) {
			try {
				
				sui = new SNSUserInfo();
				sui.setOpenId(jb.getString("openid"));
				sui.setNickname(jb.getString("nickname"));
				sui.setSex(jb.getInt("sex"));
				sui.setProvince(jb.getString("province"));
				sui.setCity(jb.getString("city"));
				sui.setCountry(jb.getString("country"));
				sui.setHeadImgUrl(jb.getString("headimgurl"));
				sui.setPrivilegeList(JSONArray.toList(jb.getJSONArray("privilege"),List.class));
				
			} catch (Exception e) {
				sui = null;
				System.out.println(jb.toString());
			}
		}
		
		return sui;
	}
	
	/**
	 * 刷新网页授权凭证
	 * 
	 * @param appId
	 * @param refreshToken
	 * @return
	 */

	public static WinxinOauth2Token refreshOauth2Acesstoken(String appId,
			String refreshToken) {

		WinxinOauth2Token wat = null;

		// 拼接请求地址
		String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?"
				+ "appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		url = url.replace("APPID", appId);
		url = url.replace("REFRESH_TOKEN", refreshToken);

		// 刷新F网页授权凭证

		JSONObject jb = CommonUtil.httpsRequest(url, "GET", null);
		if (null != jb) {
			try {
				wat = new WinxinOauth2Token();
				wat.setAccessToken(jb.getString("access_token"));
				wat.setExpiresIn(jb.getInt("expires_in"));
				wat.setOpenId(jb.getString("openid"));
				wat.setRefreshToken(jb.getString("refresh_token"));
				wat.setScope(jb.getString("scope"));
			} catch (Exception e) {
				wat = null;
				System.out.println(jb.toString());
			}

		}

		return wat;

	}

	/**
	 * 获取网页授权凭证
	 * 
	 * @param appid
	 *            公众号唯一标识
	 * @param appSecret
	 *            公众号的秘钥
	 * @param code
	 * @return
	 */

	public static WinxinOauth2Token getOauth2AcessToken(String appid,
			String appSecret, String code) {

		WinxinOauth2Token wat = null;

		// 拼接请求地址
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
				+ "appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		url = url.replace("APPID", appid);
		url = url.replace("SECRET", appSecret);
		url = url.replace("CODE", code);

		// 获取网页授权凭证

		JSONObject jb = CommonUtil.httpsRequest(url, "GET", null);
		if (null != jb) {
			try {
				wat = new WinxinOauth2Token();
				wat.setAccessToken(jb.getString("access_token"));
				wat.setExpiresIn(jb.getInt("expires_in"));
				wat.setOpenId(jb.getString("openid"));
				wat.setRefreshToken(jb.getString("refresh_token"));
				wat.setScope(jb.getString("scope"));
			} catch (Exception e) {
				wat = null;
				System.out.println(jb.toString());
			}

		}

		return wat;
	}

}
