package aws.lambda.practice;

import aws.lambda.practice.api.FunctionImpl;
import aws.lambda.practice.model.train.Train;
import aws.lambda.practice.repository.TrainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        FunctionImpl functionImpl = new FunctionImpl();
        logger.info("Application is started");
        functionImpl.getAllTrains().get().forEach(System.out::println);
    }
}
