package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String [] args) {
		
		try {
			ClassementGlobaleImpl ObjServeur = new ClassementGlobaleImpl();
			IClassementGlobale stubServeur = (IClassementGlobale) UnicastRemoteObject.exportObject(ObjServeur,0);
			
			Registry ServerRegistry = LocateRegistry.createRegistry(1098);
			
			ServerRegistry.rebind("ClassementGlobale", ObjServeur);
			
			System.out.println("Server Globale a demmare");
			
		}catch(Exception e) {
			
		}
		
		
	}
}
