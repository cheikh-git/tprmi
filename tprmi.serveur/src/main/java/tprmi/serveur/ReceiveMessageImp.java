package tprmi.serveur;
import java.rmi.RemoteException;

import tprmi.serveur.ReceiveMessageInterface;

//definition de la classe qui implemente l'interface

public class ReceiveMessageImp extends java.rmi.server.UnicastRemoteObject implements ReceiveMessageInterface{
	
	protected ReceiveMessageImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 7683221993606090701L;
    private long count = 0;
    
   
   
    //@Override
	public String receiveMessage(String x) throws RemoteException {
		
		System.out.println("On server ["+ (++count) +"]:");
		System.out.println(x.toUpperCase());
		return x.toUpperCase();
	}
	//definition de la security manager
	
	public static void main(String args[]){
		try{
			System.out.println("Mise en place d'un Security Manager...");
			System.setSecurityManager(new java.rmi.RMISecurityManager());
			new RMIServer();
			
		} catch (Exception e){
			e.printStackTrace();
			System.exit(1);
			
		}
	}
	

}
