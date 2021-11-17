package annotations.xml.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import project.IdolCompetition.Performer.Performer;

/**
 * Reference
 * https://www.baeldung.com/spring-expression-language
 */
@ImportResource("")
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring_IdolCompetition.xml");
        Performer performer = (Performer) ctx.getBean("eddie");
        performer.perform();

        Car car = new Car();
        car.setMake("Good manufacturer");
//        car.setModel("Model 3");
//        car.setYearOfProduction(2014);

        CarPark carPark = new CarPark();
        carPark.getCars().add(car);

        StandardEvaluationContext context = new StandardEvaluationContext(carPark);

        ExpressionParser expressionParser = new SpelExpressionParser();
        expressionParser.parseExpression("cars[0].model").setValue(context, "Other model");
        //

        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        StandardEvaluationContext context1 = new StandardEvaluationContext(carPark);

        ExpressionParser expressionParser1 = new SpelExpressionParser(config);
        expressionParser1.parseExpression("cars[0]").setValue(context1, car);

        Car result = carPark.getCars().get(0);
        System.out.println(result);
    }
}

