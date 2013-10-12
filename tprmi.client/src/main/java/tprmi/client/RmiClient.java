package tprmi.client;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tprmi.serveur.ReceiveMessageInterface;

public class RmiClient {
	
	 static void main(String args[]){
		
		System.setSecurityManager(new RMISecurityManager());
		ReceiveMessageInterface rmiServer;
		Registry registry;
		String serverAddress="127.0.0.1";
		String serverPort="3232";
		String text="Middleware";
		System.out.println("sending" +text+ "to"+serverAddress+"."+serverPort);
		try{
			registry=LocateRegistry.getRegistry(serverAddress,(new Integer(serverPort)).intValue());
			rmiServer=(ReceiveMessageInterface)(registry.lookup("rmiServer"));
			
			//appel de la methode distante
			System.err.println(rmiServer.receiveMessage(text));
			
		}catch (RemoteException e){
			e.printStackTrace();
		} catch (NotBoundException e){
			e.printStackTrace();
		}
		
	}

}
