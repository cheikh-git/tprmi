package tprmi.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Definition de l'interface qui doit implementer la classe contenant l'objet distant

public interface ReceiveMessageInterface extends Remote{
	String receiveMessage(String x) throws RemoteException; 

}
