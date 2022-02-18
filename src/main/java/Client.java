import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1087);

            System.out.println("enter string of digits");
            var scanner = new Scanner(System.in);
            var string = scanner.nextLine();

            Sum stub = (Sum) registry.lookup("Sum");

            System.out.println("sum of digits : " + stub.countSum(string));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
