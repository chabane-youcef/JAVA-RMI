package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String [] args) {
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			ClassementEquipeImpl ObjClient = new ClassementEquipeImpl();
			
			IClassementEquipe stub = (IClassementEquipe) UnicastRemoteObject.exportObject(ObjClient,0);
			
			Registry ClientRegistry = LocateRegistry.createRegistry(1099);
			
			ClientRegistry.rebind("classementLocale", ObjClient);
			System.out.println("demarrage de server");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
