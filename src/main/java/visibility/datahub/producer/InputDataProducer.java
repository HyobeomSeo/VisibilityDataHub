package visibility.datahub.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import visibility.datahub.domain.InputData;

@Component
public class InputDataProducer {
	
	@Autowired
	private KafkaTemplate<String, InputData> inputDataKaTemplate;
	
	@Value(value = "${topic.name.datainput}")
	private String topicName;
	
	
	public void publishData(InputData inputData) {
		this.inputDataKaTemplate.send(topicName, inputData);
	}
}
