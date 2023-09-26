package visibility.datahub.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import visibility.datahub.model.rcv.train.TrainTrackingData;

public interface TrainTrackingDataRepository extends MongoRepository<TrainTrackingData, String> {

}
