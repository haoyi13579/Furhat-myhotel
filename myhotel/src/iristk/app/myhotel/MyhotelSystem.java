/*******************************************************************************
 * Copyright (c) 2014 Gabriel Skantze.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gabriel Skantze - initial API and implementation
 ******************************************************************************/
package iristk.app.myhotel;

import iristk.situated.SituatedDialogSystem;
import iristk.situated.SystemAgentFlow;
import iristk.speech.OpenVocabularyContext;
import iristk.speech.SemanticGrammarContext;
import iristk.speech.SpeechGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.nuancecloud.NuanceCloudRecognizerFactory;
import iristk.speech.windows.WindowsRecognizerFactory;
import iristk.speech.windows.WindowsSynthesizer;
import iristk.system.IrisUtils;
import iristk.system.SimpleDialogSystem;
import iristk.util.Language;
import iristk.cfg.ListGrammar;
import iristk.cfg.SRGSGrammar;
import iristk.flow.FlowModule;

public class MyhotelSystem {
		
	public MyhotelSystem() throws Exception {
		SituatedDialogSystem system = new SituatedDialogSystem(this.getClass());
		SystemAgentFlow systemAgentFlow = system.addSystemAgent();
//		SimpleDialogSystem system1 = new SimpleDialogSystem(this.getClass());
	
		system.setLanguage(Language.ENGLISH_US);
	
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		system.setupGUI();
		
		// Add the recognizer to the system
//		system1.setupRecognizer(new NuanceCloudRecognizerFactory());
		
		//system.setupKinect();
		
		//system.setupMonoMicrophone(new WindowsRecognizerFactory());
		system.setupMonoMicrophone(new NuanceCloudRecognizerFactory());
		//system.setupKinectMicrophone(new KinectRecognizerFactory());
				
		//system.connectToBroker("furhat", "127.0.0.1");
		system.setupFace(new WindowsSynthesizer(), Gender.FEMALE);
		
		Information information = new Information();
		system.addModule(new FlowModule(new MyhotelFlow(systemAgentFlow, information)));
//		system.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(system.getPackageFile("MyhotelGrammar.xml"))));
		// Load a grammar in the recognizer
		system.loadContext("default", new OpenVocabularyContext(system.getLanguage()));
		system.loadContext("default", new SemanticGrammarContext(new SRGSGrammar(system.getPackageFile("MyhotelGrammar.xml"))));
		
		// Add new grammer
		SRGSGrammar attrGrammar = new SRGSGrammar(system.getPackageFile("MyhotelGrammar.xml"));
		attrGrammar.addRules(new ListGrammar(system.getPackageFile("attractions.txt"), Language.ENGLISH_US, "attrname"));
		
		system.loadPositions(system.getPackageFile("situation.properties"));		
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new MyhotelSystem();
	}

}
