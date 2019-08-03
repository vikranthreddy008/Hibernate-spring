package com.lti.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.Calculator;
import com.lti.component.CurrencyConverter;
import com.lti.component.CurrentBill;
import com.lti.component.HelloWorld;
import com.lti.component.Mul;
import com.lti.component.SbiAtm;
import com.lti.component.TextEditor;

public class IoCTest {
@Test
public void test() {      //loading ioc container of spring
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//accessing one of the bean
	
	for(int i=0;i<5; i++) {
		
HelloWorld h=(HelloWorld) context.getBean("hw");   //bean id
System.out.println(h.sayHello("Naveen"));
	}

    }
@Test
public void test1() {      //loading ioc container of spring
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//accessing one of the bean
	Calculator c=(Calculator) context.getBean("cal");
System.out.println(c.add(5, 4));
System.out.println(c.sub(9,5));

}
@Test
public void test3() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	CurrencyConverter cc=(CurrencyConverter)context.getBean("cc");
	System.out.println(cc.convertDollarsToRupees(5));
	
}

@Test
public void test4() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	for(int i=0;i<5; i++) {
	Mul ml=(Mul)context.getBean("ml");
	System.out.println(ml.mul(5, 500,10));}
}
@Test
public void test5() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	CurrentBill bl=(CurrentBill)context.getBean("bl");
	System.out.println(bl.bill(50));
	}
@Test
public void test6() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
   TextEditor te=(TextEditor) context.getBean("te");
		 te.load("abc.txt");
}
@Test
public void test7() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
   SbiAtm sa=(SbiAtm) context.getBean("sa");
   sa.withdraw();
}
}





