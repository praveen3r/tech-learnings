package com.skills.test.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyCustomRule implements TestRule {
    private Statement base;
    private Description description;

    public Statement apply(Statement base, Description description) {
        this.base = base;
        this.description = description;
        return new MyStatement(base);
    }

    public class MyStatement extends Statement {
        private final Statement base;

        public MyStatement(Statement base) {
            this.base = base;
        }

        @Override
        public void evaluate() throws Throwable {
            System.out.println("MyCustomRule "+description.getMethodName()+" started");
            try {
                base.evaluate();
            } finally {
            	System.out.println("MyCustomRule "+description.getMethodName()+" stopped");
            }
        }
    }

}
