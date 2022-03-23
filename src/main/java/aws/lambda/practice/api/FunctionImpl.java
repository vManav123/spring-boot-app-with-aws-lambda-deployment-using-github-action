package aws.lambda.practice.api;

import aws.lambda.practice.model.train.Train;
import aws.lambda.practice.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Configuration
public class FunctionImpl {


    @Autowired
    private TrainRepository trainRepository;

    @Bean
    public Supplier<String> healthCheck()
    {
        return () -> "You Application is Up and Running \n{\n \"Status\" : \"UP\"  \n}";
    }

    /*
        This Function will return all the trains run on the weekends
     */
    @Bean
    public Supplier<List<Train>> getAllTrains_Running_On_Weekends() {
        return () -> trainRepository
                .findAll()
                .stream()
                .filter(p -> p.getRun_days().containsAll(Arrays.asList("SUN", "SAT")))
                .collect(Collectors.toList());
    }

    @Bean
    public Supplier<List<Train>> getAllTrains() {
        return () -> trainRepository.findAll();
    }

    @Bean
    public Supplier<List<Train>> getAllTrains_Today() {
        return () -> trainRepository
                .findAll()
                .parallelStream()
                .filter(p -> p.getRun_days()
                        .contains(LocalDate.MAX.getDayOfWeek()
                                .toString()
                                .toUpperCase()
                                .substring(0, 3))
                )
                .collect(Collectors.toList());
    }
}
