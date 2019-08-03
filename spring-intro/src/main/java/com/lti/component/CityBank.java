package com.lti.component;

import org.springframework.stereotype.Component;

@Component("cb")
public class CityBank implements Bnk {
	
	public void communicate(int amount) {
		System.out.println("comm successful");
	}

}
