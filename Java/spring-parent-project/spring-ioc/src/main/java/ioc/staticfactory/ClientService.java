package ioc.staticfactory;

public class ClientService {



    private static ClientService clientService = new ClientService();

    private ClientService() {
    }

    public static ClientService createInstance() {
        System.out.print("createInstance !!!!!!!!!");
        return clientService;
    }
}