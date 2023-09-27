package visibility.datahub.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import visibility.datahub.model.rcv.std.StandardTrackingData;

@Service
public class TrackingDeployService {
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void doDeploy(StandardTrackingData data) throws InterruptedException {
		logger.info("Start deploy ");
		//Thread.sleep(500); // Log 부하 대체
		logger.info("end deploy ");
	}

}
