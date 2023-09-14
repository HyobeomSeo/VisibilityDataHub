package visibility.datahub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import visibility.datahub.domain.InputData;
import visibility.datahub.producer.InputDataProducer;

@Component
public class InputDataService {

	@Autowired
	private InputDataProducer inputDataProducer;
	
	public String doInputData(InputData inputData) throws Exception {
		inputDataProducer.publishData(inputData);
		
		return "Success";
	}
}
