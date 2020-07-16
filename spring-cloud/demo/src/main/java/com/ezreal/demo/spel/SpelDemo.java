package com.ezreal.demo.spel;

import com.ezreal.demo.dto.Car;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by tao.mao on 2020/7/2.
 */
public class SpelDemo {

    public static void main(String[] args) {
        Car car = new Car("123", "BMW");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("car", car);
        ((StandardEvaluationContext) context).setRootObject(car);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'HelloWorld'.concat('!').replaceAll('o','')");
        Expression exp1 = parser.parseExpression("#car.name");
        Expression exp2 = parser.parseExpression("#root");

        Expression exp3 = parser.parseExpression("systemProperties");



        System.out.println(exp.getValue());
        System.out.println(exp1.getValue(context));
        System.out.println(exp2.getValue(context));

        System.out.println(exp3.getValue());


    }
}
