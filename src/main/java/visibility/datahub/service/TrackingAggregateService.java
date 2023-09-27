package visibility.datahub.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import visibility.datahub.model.rcv.std.StandardTrackingData;

@Service
public class TrackingAggregateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void doAggregate(StandardTrackingData data) throws InterruptedException {
		logger.info("Start aggregate ");
		//Thread.sleep(500); // Log 부하 대체
		logger.info("End aggregate ");
	}
}
