package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sa")
public class SbiAtm implements HdfcAtm {
	
	@Autowired
	private CityBank cb;
	
	public void  withdraw() {
		
	cb.communicate(500);
	}

}
