package com.weixin.util;

import net.sf.json.JSONObject;

import com.weixin.pojo.WinxinOauth2Token;

public class AdvancedUtil {
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
