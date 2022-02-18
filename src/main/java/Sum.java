import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sum extends Remote {
    int countSum(String string) throws RemoteException;
}
