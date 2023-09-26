package visibility.datahub.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import visibility.datahub.model.rcv.std.StandardTrackingData;

@Component
public class TrackingAggregateConsumer {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@KafkaListener(topics = "StandardTrackingData", containerFactory = "aggregateConsumerListenerContainerFactory")
	public void inputDataListener(StandardTrackingData data, Acknowledgment ack) {
		
		
		try {
            logger.debug("TrackingAggregateConsumer consume data");
            logger.debug("Data {}", data.toString());
            
            // offset commit
            ack.acknowledge();
        } catch (Exception e) {
            // 에러 처리
            // 임의의 슬립 처리
            // ack.nack(1000 * 5);
        }
	}
}
