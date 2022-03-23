package aws.lambda.practice.repository;


import aws.lambda.practice.model.train.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrainRepository extends MongoRepository<Train, String> {
}
