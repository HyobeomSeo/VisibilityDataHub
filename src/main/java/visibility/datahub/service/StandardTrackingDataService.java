package visibility.datahub.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import visibility.datahub.mapper.StandardTrackingDataMapper;
import visibility.datahub.mapper.StandardTrackingEventMapper;
import visibility.datahub.mapper.StandardTrackingInfoMapper;
import visibility.datahub.model.rcv.std.StandardTrackingData;
import visibility.datahub.model.rcv.std.StandardTrackingEvent;
import visibility.datahub.model.rcv.std.StandardTrackingInfo;

@Service
public class StandardTrackingDataService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StandardTrackingDataMapper standardTrackingDataMapper;
	
	@Autowired
	private StandardTrackingEventMapper standardTrackingEventMapper;
	
	@Autowired
	private StandardTrackingInfoMapper standardTrackingInfoMapper;
	
	public void saveTrackingData(StandardTrackingData data) {
	
		String trackingDataNo = data.getTrackingDataNo();
		
		StandardTrackingData dataVo = standardTrackingDataMapper.findByTrackingDataNo(trackingDataNo);
		
		if(dataVo == null) {
			logger.debug("standard_tracking_data Insert");
			standardTrackingDataMapper.insert(data);
		}else {
			logger.debug("standard_tracking_data Update");
			standardTrackingDataMapper.update(data);
		}
		
		List<StandardTrackingEvent> trackingEvent = data.getTrackingEvent();
		
		for(StandardTrackingEvent eventData : trackingEvent) {
			logger.debug("standard_tracking_event Insert");
			eventData.setTrackingDataNo(data.getTrackingDataNo());
			standardTrackingEventMapper.insert(eventData);
		}
		
		List<StandardTrackingInfo> trackingInfo = data.getTrackingInfo();
		
		for(StandardTrackingInfo infoData : trackingInfo) {
			logger.debug("standard_tracking_info Insert");
			infoData.setTrackingDataNo(data.getTrackingDataNo());
			standardTrackingInfoMapper.insert(infoData);
		}
		
	}
	
}
