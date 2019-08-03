package com.lti.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ml")
@Scope("prototype")
public class Mul {
	
	public int mul(int a,int b, int c) {
		
		return (a*b*c);
	}

}
