package services;

import javax.ws.rs.Path;


/**
 * 
 * @author rhexa
 * Authentication and authorization services
 */
@Path("/auth")
public class Auth {

	@Path("/login")
	public String doLogin() {
		return "";
	}
	
	@Path("/fetch")
	public String updateToken() {
		return "";
	}
}
