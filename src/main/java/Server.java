import java.rmi.registry.Registry;
        import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
public class Server implements Sum {
    public Server() {}

    @Override
    public int countSum(String string) {
        int sum = 0;
        for (var letter:
             string.toCharArray())
            try {
                sum += Integer.parseInt(String.valueOf(letter));
            } catch (NumberFormatException e) {

            }
        return sum;
    }

    public static void main(String args[]) {
        try {

            Server obj = new Server();
            Sum stub =(Sum) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1087);
            registry.bind("Sum", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
