package WebService;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import entities.Categorie;
import entities.Supplier;

@Remote
@WebService(name="Serveco",targetNamespace="http://serveco.esprit.tn")
public interface AuthenticationRemote {
	@WebMethod(operationName="Authentication")
	public boolean Auth(@WebParam(name="login")String login,@WebParam(name="password")String passwd);
	@WebMethod(operationName="AllServices")
	public List<Categorie> afficher();
	@WebMethod(operationName="long")
	public List<Float> getLong();
	@WebMethod(operationName="lat")
	public List<Float> getLat();
	@WebMethod(operationName="info")
	public List<Supplier> getInfo();
	@WebMethod(operationName="send")
	public boolean sendMessage(@WebParam(name="msg")String msg,@WebParam(name="login")String client);
	@WebMethod(operationName="sign")
	public boolean signUp(@WebParam(name="first")String first,@WebParam(name="last")String last,@WebParam(name="mail")String mail,@WebParam(name="login")String login,@WebParam(name="passwd")String passwd,@WebParam(name="phone")String phone,@WebParam(name="age")int age);

}
