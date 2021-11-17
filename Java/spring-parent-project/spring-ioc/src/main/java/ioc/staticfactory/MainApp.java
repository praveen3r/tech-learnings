package ioc.staticfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String str[]) {

        //TODO : Example @1
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Static.xml"} );
        System.out.println((context.getBean("computer", Computer.class).getName()));
        System.out.println((context.getBean("processor", Computer.Processor.class).getName()));

        Computer.Processor _processor = context.getBean("processor", Computer.Processor.class);
        System.out.println(_processor.getName());
        // can't access the static properties through bean instance & it won't be visible outside.
        System.out.println(Computer.Processor.getModelNo());

        //TODO : Example @2
        //Static Factory Method
        // Not required to create the object through below statement.
        ClientService clientService = context.getBean("clientService", ClientService.class);

        if (ClientService.createInstance() != null) {
            System.out.println("Object Created through Static Factory Method!!!!!!!");
        }

    }
}
