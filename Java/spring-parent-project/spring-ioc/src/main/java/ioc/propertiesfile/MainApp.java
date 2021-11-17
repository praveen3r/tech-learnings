package ioc.propertiesfile;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainApp {

    public static void main(String a[]) {

        String confFile = "SpringBeans_Concepts.xml";
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(confFile);
        //TODO : Spring
        MyDBConfig dbConfig = (MyDBConfig) context.getBean("dbConfig");
        System.out.println(dbConfig.toString());
        context.close();

        //TODO : Spring
        System.out.println("Fetching Manually : - ");
        System.out.println(fetchProperties());
        System.out.println("URL -->" + fetchProperties().getProperty("db.host.url"));
    }

    public static Properties fetchProperties() {
        Properties properties = new Properties();
        try {
            File file = ResourceUtils.getFile("classpath:database.properties");
            InputStream in = new FileInputStream(file);
            properties.load(in);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties;
    }
}
