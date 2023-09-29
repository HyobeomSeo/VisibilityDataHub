package visibility.datahub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import visibility.datahub.model.rcv.train.TrainTrackingData;
import visibility.datahub.service.rcv.TrainTrackingDataRcvService;

@RestController
@RequestMapping(value = "/rcv")
public class TrackingDataRcvController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TrainTrackingDataRcvService trainTrackingDataRcvService;

	@RequestMapping(value = "/train", method=RequestMethod.POST)
	@Operation(summary = "Vibility Data Hub Train Data Receive", description="철송 Evnet 데이터를 수신 후 물류시스템내 필요한 데이터 처리")
	@ApiResponses({
         @ApiResponse(responseCode = "OK", description = "데이처 처리 성공"),
         @ApiResponse(responseCode = "FAIL", description = "데이터 처리 중 실패  발생")
     })
	public String doInputdata(@RequestBody final TrainTrackingData trackingData) {
		String result = "OK";
		
		try {
			trainTrackingDataRcvService.rcvData(trackingData);
		} catch(Exception e) {			
			logger.error("Error", e);
			result = "FAIL";
		}
		
		return result;
	}
}