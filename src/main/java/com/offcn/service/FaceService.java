package com.offcn.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.offcn.domain.FaceAccessToken;
import com.offcn.domain.FaceIdentifyBean;
import com.offcn.domain.FaceRegisterBean;
import com.offcn.domain.FaceUpdateBean;

@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public interface FaceService {
	
	/**
	 * 得到AccessToken
	 */
	@GET
	@Path("/getAccessToken/{client_id}/{client_secret}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public FaceAccessToken getAccessToken(@PathParam("client_id") String client_id, @PathParam("client_secret") String client_secret);

	/**
	 * 
	 * @TODO: 人脸注册
	 * @param faceRegisterBean
	 * @return FaceRegisterBean
	 */
	@POST
	@Path("/addFace")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public FaceRegisterBean addFace(FaceRegisterBean faceRegisterBean);
	
	/**
	 * 
	 * @TODO: 人脸识别
	 * @param faceIdentifyBean
	 * @return FaceIdentifyBean
	 */
	@POST
	@Path("/identifyFace")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public FaceIdentifyBean identifyFace(FaceIdentifyBean faceIdentifyBean);
	
	/**
	 * 
	 * @TODO: 人脸更新
	 * @param faceUpdateBean
	 * @return FaceUpdateBean
	 */
	@POST
	@Path("/updateFace")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public FaceUpdateBean updateFace(FaceUpdateBean faceUpdateBean);
}
