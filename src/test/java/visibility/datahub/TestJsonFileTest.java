package visibility.datahub;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import visibility.datahub.model.rcv.train.TrainTrackingData;
import visibility.datahub.model.rcv.train.TrainTrackingLocation;

public class TestJsonFileTest {

	static Random random = new Random();
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		for(int i=1; i<=1500; i++) {
			TrainTrackingData data = TestJsonFileTest.getRandomData();
			data.setIfId("IF" + String.format("%04d", i));
			System.out.println(data.toString());
			
			// JSON 데이터를 파일로 저장
            objectMapper.writeValue(new File("D:\\Cloud\\Test\\T" + String.format("%06d", i) + ".txt"), data);
		}

	}

	
	
	public static TrainTrackingData getRandomData() {
		TrainTrackingData data = new TrainTrackingData();
		
		data.setDocNo("DOC" + String.format("%03d", random.nextInt(100)));
		data.setTrainNo("T" + String.format("%03d", random.nextInt(100)));
		data.setFromStation("FROM" + String.format("%02d", random.nextInt(10)));
		data.setToStation("TO" + String.format("%02d", random.nextInt(10)));
		data.setDepartureDate("2023-09-" + String.format("%02d", random.nextInt(30)));
		data.setDepartureTime(String.format("%02d", random.nextInt(23)) + ":" + String.format("%02d", random.nextInt(59)) + ":" + String.format("%02d", random.nextInt(59)));
		data.setArrivalDate("2023-10-" + String.format("%02d", random.nextInt(30)));
		data.setArrivalTime(String.format("%02d", random.nextInt(23)) + ":" + String.format("%02d", random.nextInt(59)) + ":" + String.format("%02d", random.nextInt(59)));
		
		int loopCnt = random.nextInt(9);
		
		List<TrainTrackingLocation> tranEventList = new ArrayList<TrainTrackingLocation>();
		for(int i=1; i<=loopCnt; i++) {
			TrainTrackingLocation tranEvent = new TrainTrackingLocation();
			tranEvent.setLatitude(Math.round(random.nextDouble(-100, 100) * 1000) / 1000.0);
			tranEvent.setLongitude(Math.round(random.nextDouble(-100, 100) * 1000) / 1000.0);
			tranEventList.add(tranEvent);
		}
		
		data.setTranEvent(tranEventList);
		
		return data;
	}
}
