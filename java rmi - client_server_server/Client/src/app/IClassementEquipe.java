package app;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClassementEquipe extends Remote{
	public int Classement(String equipe) throws RemoteException;
}
