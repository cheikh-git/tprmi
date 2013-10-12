package tprmi.serveur;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
	int thisPort;
	String thisAddress;
	Registry registry;
	
	public RMIServer() throws RemoteException{
		ReceiveMessageInterface obj=new ReceiveMessageImp();
		try{
			thisAddress=(InetAddress.getLocalHost().toString());
			
		} catch (Exception e){
			throw new RemoteException("l'adresse est irrecuperable");
		}
		thisPort=3232;
		System.out.println("Votre adresse est :" +thisAddress+  "et le port associe est " +thisPort);
		try{
			registry=LocateRegistry.createRegistry(thisPort);
			registry.rebind("rmiServer", obj);
		} catch(RemoteException e){
			throw e;
		}
	}

}
