package ioc.collection;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Concepts.xml"});

        ComplexObject complexObject = context.getBean("moreComplexObject", ComplexObject.class);

        //TODO : List
        List<Object> values = complexObject.getSomeList();
        for (Object val : values) {
            if (val instanceof String)
                System.out.println(":::::::::List Value::::::::: " + ((String) val).toLowerCase());
            if (val instanceof BasicDataSource) {
                BasicDataSource dataSource = (BasicDataSource) val;
                System.out.println(dataSource.getDriverClassName());
                System.out.println(dataSource.getUsername());
                System.out.println(dataSource.getPassword());
            }
        }

        //TODO : Map
        Map<String, Object> values_ = complexObject.getSomeMap();
        for (Map.Entry<String, Object> val : values_.entrySet()) {
            if (val.getValue() instanceof String)
                System.out.println(":::::::Map Value:::::::  " + ((String) val.getValue()).toLowerCase());
            if (val.getValue() instanceof BasicDataSource) {
                BasicDataSource dataSource = (BasicDataSource) val.getValue();
                System.out.println(dataSource.getDriverClassName());
                System.out.println(dataSource.getUsername());
                System.out.println(dataSource.getPassword());
            }

        }
        System.out.println("Value :- " + values_.get("an entry").toString());

        //TODO : Properties
        Properties properties = complexObject.getAdminEmails();
        System.out.println(properties.get("administrator"));


        //TODO :XML shortcut with the p-namespace
        StrongTypedCollection namespace = context.getBean("p-namespace", StrongTypedCollection.class);
        System.out.println(namespace.getValue());

        //TODO:
    }
}
