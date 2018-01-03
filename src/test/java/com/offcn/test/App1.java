package com.offcn.test;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.Before;
import org.junit.Test;

import com.offcn.domain.FaceAccessToken;
import com.offcn.domain.FaceIdentifyBean;
import com.offcn.domain.FaceUpdateBean;
import com.offcn.enums.FaceConstant;
import com.offcn.service.FaceService;
import com.offcn.utils.FileUtils;

public class App1 {

	FaceService fs = null;

	@Before
	public void init() {

		System.out.println("open cxf-service success");

		fs = JAXRSClientFactory.create("http://localhost:8089/service/faceService", FaceService.class);

		System.out.println(fs.getClass());
	}

	@Test
	public void test1() {

		FaceIdentifyBean faceIdentifyBean = new FaceIdentifyBean();

		faceIdentifyBean.setAccess_token(FaceConstant.access_token.getVal());

		faceIdentifyBean.setGroup_id("java0815");
		faceIdentifyBean.setImages(FileUtils.getPicStrByImages("D:/BaiduYunDownload/001.jpg"));

		FaceIdentifyBean identifyFace = fs.identifyFace(faceIdentifyBean);
		
		System.out.println("客户端接收服务器返回的javabean："+identifyFace);
		
		System.out.println("result："+ identifyFace.getResultBean().getScores()[0]);
		
		//result:[{"uid":"java0815001","scores":[76.297119140625],"group_id":"java0815","user_info":""}]
	
		//json串：{"result":result}
		/*String jsonStr = "{\"result\":" + identifyFace.getResult() +"}";
		
		System.out.println("json串："+jsonStr);
		
		JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
		
		JsonArray jsonArray = jsonObject.getAsJsonArray("result");
		
		Gson gson = new Gson();
		
		for (JsonElement resultBean : jsonArray) {
			
			ResultBean bean = gson.fromJson(resultBean, ResultBean.class);
			
			System.out.println("geoglejson："+bean.getScores()[0]);
		}
		
		System.out.println("#############################################");
		
		JSONObject jsonObject2 = JSON.parseObject(jsonStr);
		
		JSONArray jsonArray2 = jsonObject2.getJSONArray("result");
		
		for (int i = 0; i < jsonArray2.size(); i++) {
			
			ResultBean resultBean = jsonArray2.getObject(i, ResultBean.class);
			
			for (double score : resultBean.getScores()) {
				
				System.out.println("验证分数："+score);
			}
		}*/
	}

	@Test
	public void test2() {

		String client_id = "zw99HIZ00fCIq2Avvac69f2G";
		String client_secret = "U5AeVa0xuFc32hwur8bX5QH8V8Xron7d";

		FaceAccessToken accessToken = fs.getAccessToken(client_id, client_secret);

		System.out.println(accessToken);
	}

	/*
	 * @Test public void test3(){
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * FaceIdentifyBean faceIdentifyBean = new FaceIdentifyBean();
	 * 
	 * faceIdentifyBean.setAccess_token(FaceConstant.access_token.getVal());
	 * 
	 * faceIdentifyBean.setGroup_id("java0815");
	 * 
	 * faceIdentifyBean.setImages(FileUtils.getPicStrByImages(
	 * "D:/BaiduYunDownload/001.jpg"));
	 * 
	 * String url = "http://localhost:8089/service/faceService/identifyFace";
	 * 
	 * FaceIdentifyBean identifyBean = restTemplate.postForObject(url ,
	 * faceIdentifyBean, FaceIdentifyBean.class);
	 * 
	 * System.out.println(identifyBean); }
	 */

	@Test
	public void test4() {

		FaceUpdateBean faceUpdateBean = new FaceUpdateBean();

		faceUpdateBean.setAccess_token(FaceConstant.access_token.getVal());

		faceUpdateBean.setUid("java0815001");
		faceUpdateBean.setImages(FileUtils.getPicStrByImages("D:/BaiduYunDownload/002.jpg"));

		FaceUpdateBean updateFace = fs.updateFace(faceUpdateBean);

		System.out.println(updateFace);
	}

}
