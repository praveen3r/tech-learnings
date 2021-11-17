package pureannotations.concepts.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

//Example 01 - get bean by name as ClassName
//@Component

//Example 03
//@Component("FirstLetter")


@Component
public class ATest implements Alphabet {
    //    @Autowired(required = false)

    Case aCase;

    public Case getaCase() {
        return aCase;
    }

    @Autowired
    @Required
    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }

    //    @Autowired(required = true)
    public ATest(@Autowired Case aCase) {
        this.aCase = aCase;
    }

    @Value("Fist Letter")
    String name;

    @Autowired
    //Way 01 by class default name which defined as @Component
//    @Qualifier(value = "ATest")
//    @Qualifier(value = "BTest")

            //Way 02 by reading the class from AppConfig file using method name
            //@Qualifier(value = "getC2")
            // Alphabet alphabet;
            Alphabet getC1;

    //            Way 03
//            Alphabet getB;
//    Alphabet alphabet;

    //    @Autowired
    @Inject
    Number number;

    @Autowired
    @Required
    public void displayCase(Case aCase) {
        System.out.println("Autowired by Method Parameter : - " + aCase.getType());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Default value of ATest Class - " + getName();
    }
}
