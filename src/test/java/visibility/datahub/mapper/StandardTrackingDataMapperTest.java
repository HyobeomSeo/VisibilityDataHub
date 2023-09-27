package visibility.datahub.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import visibility.datahub.model.rcv.std.StandardTrackingInfo;

@SpringBootTest
public class StandardTrackingDataMapperTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StandardTrackingDataMapper standardTrackingDataMapper;
	
	@Autowired
	private StandardTrackingEventMapper standardTrackingEventMapper;
	
	@Autowired
	private StandardTrackingInfoMapper standardTrackingInfoMapper;
	
	@Test
	public void test() throws Exception{
		/*
		StandardTrackingData standardTrackingData = new StandardTrackingData();
		standardTrackingData.setTrackingDataNo("TrackingDataNo5");
		standardTrackingData.setTransMode("TransMod");
		
		standardTrackingDataMapper.insert(standardTrackingData);
		*/
		
		/*
		StandardTrackingEvent event = new StandardTrackingEvent();
		
		event.setTrackingDataNo("TrackingDataNo5");
		event.setEventNo("1");
		event.setLatitude(1231);
		event.setLongitude(-120);
		
		standardTrackingEventMapper.insert(event);
		
		event.setEventNo("2");
		event.setLatitude(22);
		event.setLongitude(-22);
		standardTrackingEventMapper.insert(event);
		
		List<StandardTrackingEvent> list = standardTrackingEventMapper.findByTrackingDataNo("TrackingDataNo5");
		
		for(StandardTrackingEvent ee : list) {
			logger.debug(ee.toString());
		}
		*/
		
		StandardTrackingInfo aa = new StandardTrackingInfo();
		
		aa.setTrackingDataNo("TrackingDataNo5");
		aa.setInfoType("T1");
		
		standardTrackingInfoMapper.insert(aa);
		
		aa.setInfoType("T2");
		standardTrackingInfoMapper.insert(aa);
		
		List<StandardTrackingInfo> list = standardTrackingInfoMapper.findByTrackingDataNo("TrackingDataNo5");
		
		for(StandardTrackingInfo ee : list) {
			logger.debug(ee.toString());
		}
		
		
	}
}
