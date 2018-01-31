package com.beacon.imchat;

import com.beacon.imchat.listener.LoaderListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@MapperScan("com.beacon.imchat")
public class ImchatApplication {
	@RequestMapping("/")
	String index() {
		return "IMChat API Server";
	}

	//注册监听器，启动定时任务
	/*@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
		servletListenerRegistrationBean.setListener(new LoaderListener());
		return servletListenerRegistrationBean;
	}*/


	public static void main(String[] args) {
		SpringApplication.run(ImchatApplication.class, args);
	}

}
