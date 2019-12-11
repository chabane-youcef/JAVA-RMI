package app;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClassementGlobaleImpl implements IClassementGlobale, Serializable{

	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Equipe> ListEquipesGlobale = new ArrayList<>();
	
	protected ClassementGlobaleImpl() throws RemoteException {
		ListEquipesGlobale.add(new Equipe("madrid",1));
		ListEquipesGlobale.add(new Equipe("barca",2));
		ListEquipesGlobale.add(new Equipe("juventuse",3));
		ListEquipesGlobale.add(new Equipe("psg",4));
		ListEquipesGlobale.add(new Equipe("inter",5));
		ListEquipesGlobale.add(new Equipe("manchester",6));
		ListEquipesGlobale.add(new Equipe("ayax",7));
		ListEquipesGlobale.add(new Equipe("valencia",8));
		ListEquipesGlobale.add(new Equipe("liverpool",9));
		ListEquipesGlobale.add(new Equipe("crb",10));
	}
	
	@Override
	public Equipe ClassementGlobale(String equipe) throws RemoteException {
		
		Equipe eq = new Equipe();
		for(Equipe x : ListEquipesGlobale) {
			if(equipe.equals(x.getEquipe())) {
				eq.setEquipe(equipe);
				eq.setClassement(x.getClassement());
				System.out.println("classement Globale has been found");
			}
		}
		
		return eq;
	}

}
