package com.spring.spring;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.spring.config.WebConfig;

public class DataSourceTest {
	public static void main(String[] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(WebConfig.class);
		DataSource ds = app.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if (conn != null)
				System.out.println("접속 성공^^");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
