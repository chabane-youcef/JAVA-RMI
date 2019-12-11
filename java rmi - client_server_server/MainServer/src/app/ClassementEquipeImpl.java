package app;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class ClassementEquipeImpl implements IClassementEquipe, Serializable{
	private static final long serialVersionUID = 1L;
	public static ArrayList<Equipe> ListEquipes = new ArrayList<>();
	
	protected ClassementEquipeImpl() throws RemoteException {
		ListEquipes.add(new Equipe("barca",2));
		ListEquipes.add(new Equipe("inter",5));
	}
	
	@Override
	public int Classement(String equipe) throws RemoteException {
		int classement = 0;
		Equipe eq = new Equipe();
		for(Equipe x : ListEquipes) {
			if(equipe.equals(x.getEquipe())){
				classement = x.getClassement();
			}
		}
		
		if(classement == 0) {
			try {
				Registry RegistryGlobale = LocateRegistry.getRegistry(1098);
				IClassementGlobale ServerObj = (IClassementGlobale) RegistryGlobale.lookup("ClassementGlobale");
				eq = ServerObj.ClassementGlobale(equipe);

				if(eq.getClassement() == 0) {
					System.out.println("classement lost");
				}else {
					System.out.println("classement recieved");
					ListEquipes.add(eq);
				}			
				classement = eq.getClassement();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return classement;
	}
}
