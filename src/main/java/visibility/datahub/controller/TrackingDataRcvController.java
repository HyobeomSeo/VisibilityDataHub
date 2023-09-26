package visibility.datahub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import visibility.datahub.model.rcv.train.TrainTrackingData;
import visibility.datahub.service.rcv.TrainTrackingDataRcvService;

@RestController
@RequestMapping(value = "/rcv")
public class TrackingDataRcvController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TrainTrackingDataRcvService trainTrackingDataRcvService;

	@RequestMapping(value = "/train", method=RequestMethod.POST)
	public String doInputdata(@RequestBody final TrainTrackingData trackingData) {
		String result = "OK";
		
		try {
			trainTrackingDataRcvService.rcvData(trackingData);
		} catch(Exception e) {			
			logger.error("Error", e);
			result = "Fail";
		}
		
		return result;
	}
}
