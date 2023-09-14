package visibility.datahub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import visibility.datahub.domain.InputData;
import visibility.datahub.service.InputDataService;

@RestController
@RequestMapping(value = "/datahub")
public class InputDataController {

	@Autowired
	private InputDataService inputDataService;
	
	@RequestMapping(value = "/inputdata", method=RequestMethod.POST)
	public String doInputdata(@RequestBody final InputData inputData) throws Exception {
		return inputDataService.doInputData(inputData);
	}
}
