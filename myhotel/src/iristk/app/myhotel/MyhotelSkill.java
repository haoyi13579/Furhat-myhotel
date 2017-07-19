package iristk.app.myhotel;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;

import iristk.cfg.ListGrammar;
import iristk.cfg.SRGSGrammar;
import iristk.furhat.server.Display;
import iristk.furhat.skill.FileResource;
import iristk.furhat.skill.FlowResource;
import iristk.furhat.skill.Skill;
import iristk.furhat.skill.SkillHandler;
import iristk.furhat.skill.TextFileResource;
import iristk.furhat.skill.FormFileResource;
import iristk.furhat.skill.XmlResource;
import iristk.furhat.util.Localizer;
import iristk.furhat.skill.SkillRequirements;
import iristk.furhat.skill.SkillResource;
import iristk.speech.OpenVocabularyContext;
import iristk.speech.SemanticGrammarContext;
import iristk.speech.SpeechGrammarContext;
import iristk.system.IrisUtils;
import iristk.util.Language;
import iristk.util.Record;

public class MyhotelSkill extends Skill  {

	private static final String RECOGNIZER_GRAMMAR = "grammar";
	private static final String RECOGNIZER_OPEN = "open";
	
	private static Logger logger = IrisUtils.getLogger(MyhotelSkill.class); 
	
	private MyhotelFlow flow;
	private File propertiesFile;
	private String name = "MyhotelSkill";
	private Language language = Language.ENGLISH_US;
	private String recognizer = "grammar";
	
	public MyhotelSkill() {
		
		this.propertiesFile = getPackageFile("skill.properties");
		try {
			Record config = Record.fromProperties(propertiesFile);
			name = config.getString("name", name);
			language = new Language(config.getString("language", language.getCode()));

			recognizer = config.getString("recognizer", recognizer);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		//Adds these resources as links in FurhatOS webserver.
		addResource(new TextFileResource(this, "Properties", propertiesFile));
		addResource(new FlowResource(this, "Flow", getSrcFile("MyhotelFlow.xml")));
		addResource(new XmlResource(this, "Grammar", getPackageFile("MyhotelGrammar.xml")));
		
		//Sets up requirements for this class.
		SkillRequirements requirements = getRequirements();
		requirements.setLanguage(language);
		requirements.setSpeechGrammar(recognizer.equals(RECOGNIZER_GRAMMAR));
		requirements.setOpenVocabulary(recognizer.equals(RECOGNIZER_OPEN));
		addEntriesFromFlow(MyhotelFlow.class, () -> flow);
		
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void init() throws Exception {
		
		SkillHandler handler = getSkillHandler();
		if (recognizer.equals(RECOGNIZER_GRAMMAR))  {
			
//			SRGSGrammar myhotel = new SRGSGrammar(getPackageFile("MyhotelGrammar.xml"));
//			myhotel.addRules(new ListGrammar(getPackageFile("attr_name.txt"), language, "ATTR"));
//			handler.loadContext("default", new SpeechGrammarContext(myhotel));
			handler.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(getPackageFile("MyhotelGrammar.xml"))));
			handler.setDefaultContext("default");
		} else if (recognizer.equals(RECOGNIZER_OPEN)) {
			
			SRGSGrammar myhotel = new SRGSGrammar(getPackageFile("MyhotelGrammar.xml"));
//			myhotel.addRules(new ListGrammar(getPackageFile("attr_name.txt"), language, "ATTR"));
			handler.loadContext("default", new OpenVocabularyContext(language));
//			handler.loadContext("default", new SemanticGrammarContext(myhotel));		
			handler.loadContext("default", new SemanticGrammarContext(new SRGSGrammar(getPackageFile("MyhotelGrammar.xml"))));
			handler.setDefaultContext("default");
		} 
		Information information = new Information();
		Weather weather = new Weather();
		flow = new MyhotelFlow(handler.getSystemAgentFlow(), information, weather);
		
	}

	@Override
	public void stop() throws Exception {
	}
	
	

}
