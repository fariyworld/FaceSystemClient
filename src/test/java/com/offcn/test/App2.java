package com.offcn.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.domain.FaceIdentifyBean;
import com.offcn.enums.FaceConstant;
import com.offcn.service.FaceService;
import com.offcn.utils.FileUtils;

public class App2 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
	
		FaceService faceService = (FaceService) context.getBean("faceService");
		
		FaceIdentifyBean faceIdentifyBean = new FaceIdentifyBean();

		faceIdentifyBean.setAccess_token(FaceConstant.access_token.getVal());

		faceIdentifyBean.setGroup_id("java0815");
		
		faceIdentifyBean.setImages(FileUtils.getPicStrByImages("D:/BaiduYunDownload/001.jpg"));
		
		FaceIdentifyBean identifyFace = faceService.identifyFace(faceIdentifyBean);
		
		System.out.println(identifyFace);
	}
}
