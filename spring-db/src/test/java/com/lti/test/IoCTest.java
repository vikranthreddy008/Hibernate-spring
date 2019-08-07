package com.lti.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartsInventory;

public class IoCTest {
	@Test
	public void test() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpv=
				(CarPartsInventory) context.getBean("carParts1");
		CarPart cp=new CarPart();
		cp.setPartNo(222);
		cp.setName("Nut&Bolt");
		cp.setQuantity(100);
		cp.setCarModel("Audi A6");
		cpv.addNewPart(cp);
	}
	@Test
	public void test1() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpv=
				(CarPartsInventory) context.getBean("carParts2");
		CarPart cp=new CarPart();
		cp.setPartNo(777);
		cp.setName("car doors");
		cp.setQuantity(10);
		cp.setCarModel("jaguar");
		cpv.addNewPart(cp);
}
	@Test
	public void test2() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpv=
				(CarPartsInventory) context.getBean("carParts3");
		CarPart cp=new CarPart();
		cp.setPartNo(999);
		cp.setName("ac");
		cp.setQuantity(30);
		cp.setCarModel("kia");
		cpv.addNewPart(cp);
	
      }
	@Test
	public void test3() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpv=
				(CarPartsInventory) context.getBean("carParts4");
		CarPart cp=new CarPart();
		cp.setPartNo(111);
		cp.setName("aaa");
		cp.setQuantity(30);
		cp.setCarModel("vvv");
		cpv.addNewPart(cp);
	
	
	}
	
}
