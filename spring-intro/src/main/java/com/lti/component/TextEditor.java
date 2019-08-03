package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("te")

public class TextEditor {
	
	@Autowired //DI
	private SpellChecker sp;
	
 public void load(String doc) {
	 
	 System.out.println("Loaded "+ doc);
	// SpellChecker sp=new SpellChecker();
	 sp.checkSpellingMistakes(doc);
    }
 
}
