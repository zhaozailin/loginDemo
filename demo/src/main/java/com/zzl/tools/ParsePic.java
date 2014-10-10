package com.zzl.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsePic {
	
	

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		initDB(getUrls("G:/pic.txt"));
	}

	/**
	 * 获取图片url
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String> getUrls(String path) throws IOException {
		
		// 定义正则匹配
		Pattern pattern = Pattern.compile("http://sh.yun.ftn.qq.com.*size=");
		
		// url集合
		List<String> urls = new LinkedList<String>();

		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String temp = null;
		while ((temp = br.readLine()) != null) {
			Matcher m = pattern.matcher(temp);
			while (m.find()) {
				urls.add(m.group());
			}
		}
		
		br.close();
		
		return urls;
	}
	
	/**
	 * 将url集合初始化到数据库
	 * @param urls
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void initDB(List<String> urls) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://115.29.18.82:3306/zlmx", "root", "lingLIN2014");
		
		// 加入批处理
		for (String url : urls) {
			String sql = "insert into picture(url, type) values(?, 1)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, url);
			stat.execute();
		}
		
		conn.commit();
	}
}
