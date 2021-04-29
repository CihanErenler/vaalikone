package services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * 
 * @author rhexa
 * Authentication and authorization services
 */
@Path("/auth")
public class Auth {

	@POST
	@Path("/login")
	public Response doLogin() {
		
		return Response.ok().build();
	}
	
	@Path("/fetch")
	public String updateToken() {
		return "";
	}
}
