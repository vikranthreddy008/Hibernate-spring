package com.lti.component;

import org.springframework.stereotype.Component;

@Component("bl")
public class CurrentBill {
	
	public int bill(int a) {
		
		return(a*50);
	}

}
