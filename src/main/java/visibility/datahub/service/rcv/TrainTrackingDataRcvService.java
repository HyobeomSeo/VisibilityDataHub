package visibility.datahub.service.rcv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import visibility.datahub.model.rcv.std.StandardTrackingData;
import visibility.datahub.model.rcv.std.StandardTrackingEvent;
import visibility.datahub.model.rcv.std.StandardTrackingInfo;
import visibility.datahub.model.rcv.train.TrainTrackingData;
import visibility.datahub.model.rcv.train.TrainTrackingLocation;
import visibility.datahub.repo.TrainTrackingDataRepository;

@Service
public class TrainTrackingDataRcvService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private TrainTrackingDataRepository trainTrackingDataRepository;
	
	@Autowired
	private KafkaTemplate<String, StandardTrackingData> standardTrackingDataProducer;
	
	
	public void rcvData(TrainTrackingData data) {
		logger.debug("Rcv TrainTrackingData = {}", data.toString());
		
		this.saveData(data);
		
		StandardTrackingData standardTrackingData = this.transFormData(data);
		
		this.publishData(standardTrackingData);
	}
	
	private void saveData(TrainTrackingData data) {
		logger.debug("Save to MongoDB");
		trainTrackingDataRepository.save(data);
	}
	
	private StandardTrackingData transFormData(TrainTrackingData data) {
		StandardTrackingData standardTrackingData = new StandardTrackingData();
		
		standardTrackingData.setTrackingDataNo(data.getDocNo());
		standardTrackingData.setTransMode("RAIL");
		standardTrackingData.setTransStatus("INIT");
		standardTrackingData.setRefDocType("TRAIN");
		standardTrackingData.setRefDocNo(data.getIfId());
		standardTrackingData.setTransMethodNo(data.getTrainNo());
		standardTrackingData.setFromLocation(data.getFromStation());
		standardTrackingData.setToLocation(data.getToStation());
		standardTrackingData.setFromDate(data.getDepartureDate());
		standardTrackingData.setFromTime(data.getDepartureTime());
		standardTrackingData.setToDate(data.getArrivalDate());
		standardTrackingData.setToTime(data.getArrivalTime());
		
		
		List<StandardTrackingEvent> trackingEvent = new ArrayList<StandardTrackingEvent>();
		
		List<TrainTrackingLocation> dataLocation = data.getTranEvent();
		for(int i=0; i<dataLocation.size(); i++) {			
			StandardTrackingEvent event = new StandardTrackingEvent();
			event.setTrackingDataNo(data.getDocNo());
			event.setEventNo(Integer.toString(i+1));
			event.setEventTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			event.setLatitude(dataLocation.get(i).getLatitude());
			event.setLongitude(dataLocation.get(i).getLongitude());
			event.setEventType("NONE");
			trackingEvent.add(event);
		}
		
		standardTrackingData.setTrackingEvent(trackingEvent);
		
		
		List<StandardTrackingInfo> trackingInfo = new ArrayList<StandardTrackingInfo>();
		
		StandardTrackingInfo info1 = new StandardTrackingInfo();
		info1.setTrackingDataNo(data.getDocNo());
		info1.setInfoType("ADD");
		info1.setInfoContent(data.getDocNo() + "_" + data.getIfId());
		trackingInfo.add(info1);
		
		standardTrackingData.setTrackingInfo(trackingInfo);
		
		logger.debug("Trans data {}", standardTrackingData.toString());
		
		return standardTrackingData;
	}
	
	public void publishData(StandardTrackingData data) {
		logger.debug("Publish StandardTrackingData");
		standardTrackingDataProducer.send("StandardTrackingData", data);
	}
	
}