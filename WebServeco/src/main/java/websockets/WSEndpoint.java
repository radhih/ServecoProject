package websockets;
 
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


 
//@ServerEndpoint("/example")
public class WSEndpoint {
	Logger log = Logger.getGlobal();
 
	@OnMessage
	public String receiveMessage(String message, Session session) {
		log.info("Received : "+ message + ", session:" + session.getId());
		return "Response from the server";
	}
	
	@OnOpen
	public void open(Session session) {
		log.info("Open session:" + session.getId());		 
	}
	
	@OnClose
	public void close(Session session, CloseReason c) {
		log.info("Closing:" + session.getId());
	}
}