package org.example;

//import org.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
//    ExampleCalculator exampleCalculator;

    public static void main(String[] args) {

//        this.init();
//        exampleCalculator = new ExampleCalculator();


        System.out.println("--------------------------------");
        System.out.println("Hello Kafka...");
        System.out.println(ExampleCalculator.sum(1, 2));
//        System.out.println("Consuming topic: [" + SOURCE_TOPIC + "] DLQ: [" + DLQ_TOPIC + "]");
        System.out.println("--------------------------------");
        for (int i = 1; i < 20 ; i++) {
            logger.debug("Debugging stuff... ");
            logger.info("Application started! (INFO)");
            logger.warn("This is a warning.");
            logger.error("This is an error message.");
        }
    }

//    private void init() {
//        exampleCalculator = new ExampleCalculator();
//
//    }

}
