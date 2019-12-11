package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	public static void main(String [] args) {
		Registry registry;
		
		try {
			registry = LocateRegistry.getRegistry(1099);
			
			IClassementEquipe clientObj = (IClassementEquipe) registry.lookup("classementLocale");
			Scanner sc = new Scanner(System.in);
			String reponse;
			
			do {
				System.out.println("svp entrer l'equipe");
			
				String equipe = sc.nextLine();
				
				System.out.println("classement de "+equipe+" : "+clientObj.Classement(equipe));
				
				System.out.println("voulez vous entrer une autre equipe ? (y / n");
				reponse = sc.nextLine();
			}while(reponse.equals("y"));
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
