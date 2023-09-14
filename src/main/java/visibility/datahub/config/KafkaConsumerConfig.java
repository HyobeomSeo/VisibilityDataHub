package visibility.datahub.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import visibility.datahub.domain.InputData;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${consumer.group.transform}")
	private String groupIdTransform;
	
	@Value(value = "${consumer.group.aggregate}")
	private String aggregate;

	public ConsumerFactory<String, InputData> inputDataConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdTransform);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		// KafkaListener autocommit disable
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(InputData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, InputData> inputDataKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, InputData> factory = new ConcurrentKafkaListenerContainerFactory<String, InputData>();

		factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

		factory.setConsumerFactory(inputDataConsumerFactory());
		// 필터 사용 시
		// factory.setRecordFilterStrategy(record -> record.value().contains("World"));
		
		return factory;
	}
	
	public ConsumerFactory<String, InputData> inputDataConsumerFactory2() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, aggregate);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		// KafkaListener autocommit disable
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(InputData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, InputData> inputDataKafkaListenerContainerFactory2() {
		ConcurrentKafkaListenerContainerFactory<String, InputData> factory = new ConcurrentKafkaListenerContainerFactory<String, InputData>();

		factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

		factory.setConsumerFactory(inputDataConsumerFactory2());
		// 필터 사용 시
		// factory.setRecordFilterStrategy(record -> record.value().contains("World"));
		
		return factory;
	}
}
