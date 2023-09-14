package visibility.datahub.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import visibility.datahub.domain.InputData;

@Component
public class InputDataConsumer2 {

	@KafkaListener(topics = "${topic.name.datainput}", containerFactory = "inputDataKafkaListenerContainerFactory2")
	public void inputDataListener(InputData inputData, Acknowledgment ack) {
		
		try {
            System.out.println("[InputDataConsumer2] Recieved inputData: " + inputData.toString());
            // 여기에서 Service Layer를 호출 합니다.

//            if (1 < 0) {
//                throw new Exception("예제를 위한 에러 발생");
//            }
            
            // offset commit
            ack.acknowledge();
        } catch (Exception e) {
            // 에러 처리
            // 임의의 슬립 처리
            // ack.nack(1000 * 5);
        }
	}
}
