package com.restful;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/*")
public class FirstClass {
	private static final String version="00.17.00";
	
	@Path("/status")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<h1>Java Web Service</h1>";
	}
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnversion(){
		return "<h1>Rest version:</h1>" + version;
	}
}
