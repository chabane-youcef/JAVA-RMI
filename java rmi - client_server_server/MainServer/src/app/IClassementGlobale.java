package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClassementGlobale extends Remote{
	public Equipe ClassementGlobale(String equipe) throws RemoteException;
}
