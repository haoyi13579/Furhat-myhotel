package iristk.app.myhotel;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class MyhotelFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private Information info;
	private Weather weather;
	private Mandarin mandarin;
	private Record call;
	private iristk.situated.SystemAgent system;
	private Integer number;
	private String lang;
	private Object attrnamepass;

	private void initVariables() {
		call = asRecord(new Record());
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		lang = asString("en");
	}

	public Record getCall() {
		return this.call;
	}

	public void setCall(Record value) {
		this.call = value;
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer value) {
		this.number = value;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String value) {
		this.lang = value;
	}

	public Object getAttrnamepass() {
		return this.attrnamepass;
	}

	public void setAttrnamepass(Object value) {
		this.attrnamepass = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	public Information getInfo() {
		return this.info;
	}

	public Weather getWeather() {
		return this.weather;
	}

	public Mandarin getMandarin() {
		return this.mandarin;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("call")) return this.call;
		if (name.equals("system")) return this.system;
		if (name.equals("number")) return this.number;
		if (name.equals("lang")) return this.lang;
		if (name.equals("attrnamepass")) return this.attrnamepass;
		if (name.equals("agent")) return this.agent;
		if (name.equals("info")) return this.info;
		if (name.equals("weather")) return this.weather;
		if (name.equals("mandarin")) return this.mandarin;
		return null;
	}


	public MyhotelFlow(iristk.situated.SystemAgentFlow agent, Information info, Weather weather, Mandarin mandarin) {
		this.agent = agent;
		this.info = info;
		this.weather = weather;
		this.mandarin = mandarin;
		initVariables();
	}

	@Override
	public State getInitialState() {return new Idle();}


	public class Idle extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 24
			try {
				EXECUTION: {
					int count = getCount(1550551761) + 1;
					incrCount(1550551761);
					// Line: 25
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 25, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 27
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 27, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 28
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 25, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 24, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 32
			try {
				count = getCount(928733787) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(928733787);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 32, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 34
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 34, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 32, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Greeting extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 39
			try {
				EXECUTION: {
					int count = getCount(1495090578) + 1;
					incrCount(1495090578);
					// Line: 40
					Event sendEvent5 = new Event("action.voice");
					sendEvent5.putIfNotNull("name", "David");
					flowRunner.sendEvent(sendEvent5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 49)));
					iristk.situated.SystemAgentFlow.prompt state6 = agent.new prompt();
					StringCreator string7 = new StringCreator();
					string7.append("Hi there, Do you want me to speak English or Chinese?");
					state6.setText(string7.toString());
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 39, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 42
					Start state8 = new Start();
					flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 42, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 39, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 44
			try {
				count = getCount(16183982) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:english")) {
						incrCount(16183982);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 45
							lang = "en";
							// Line: 46
							Event sendEvent9 = new Event("action.context.default");
							sendEvent9.putIfNotNull("context", "English");
							flowRunner.sendEvent(sendEvent9, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 46, 65)));
							// Line: 47
							Event sendEvent10 = new Event("action.voice");
							sendEvent10.putIfNotNull("name", "David");
							flowRunner.sendEvent(sendEvent10, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 47, 51)));
							// Line: 48
							Start state11 = new Start();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 48, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 44, 62));
			}
			// Line: 50
			try {
				count = getCount(1378169639) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1378169639);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 51
						String s = event.get("text").toString(); int value=mandarin.language(s);
						// Line: 52
						if (value==2) {
							// Line: 53
							lang = "zh";
							// Line: 54
							Event sendEvent12 = new Event("action.context.default");
							sendEvent12.putIfNotNull("context", "Chinese");
							flowRunner.sendEvent(sendEvent12, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 54, 66)));
							// Line: 55
							Event sendEvent13 = new Event("action.voice");
							sendEvent13.putIfNotNull("name", "HuiHui");
							flowRunner.sendEvent(sendEvent13, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 55, 51)));
							// Line: 56
							Start_CN state14 = new Start_CN();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 56, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 57
						} else {
							iristk.situated.SystemAgentFlow.say state15 = agent.new say();
							StringCreator string16 = new StringCreator();
							string16.append("Sorry, I didn't get that.");
							state15.setText(string16.toString());
							if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 52, 24)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 59
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 59, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 50, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 65
			try {
				EXECUTION: {
					int count = getCount(1814052972) + 1;
					incrCount(1814052972);
					iristk.situated.SystemAgentFlow.prompt state17 = agent.new prompt();
					StringCreator string18 = new StringCreator();
					string18.append("What can I do for you?");
					state17.setText(string18.toString());
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 65, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 65, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 73
			try {
				count = getCount(332781410) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(332781410);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 75
							if (event.has("sem:natural")) {
								// Line: 76
								Nature state19 = new Nature();
								flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 76, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 77
							} else if (event.has("sem:historical")) {
								// Line: 78
								History state20 = new History();
								flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 78, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 79
							} else if (event.has("sem:popular")) {
								// Line: 80
								Popular state21 = new Popular();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 80, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 81
							} else {
								// Line: 82
								QueryAttr state22 = new QueryAttr();
								flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 82, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 73, 68));
			}
			// Line: 86
			try {
				count = getCount(1085178189) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1085178189);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 87
							if (event.has("sem:attrname")) {
								iristk.situated.SystemAgentFlow.say state23 = agent.new say();
								state23.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
								if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 87, 35)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 89
								CheckAgain state24 = new CheckAgain();
								flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 89, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 90
							} else {
								// Line: 91
								QueryTrans state25 = new QueryTrans();
								flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 91, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 86, 71));
			}
			// Line: 95
			try {
				count = getCount(867985463) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(867985463);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 97
							QueryRoom state26 = new QueryRoom();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 97, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 95, 62));
			}
			// Line: 100
			try {
				count = getCount(2088524975) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(2088524975);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 101
							QueryWeather state27 = new QueryWeather();
							flowThread.gotoState(state27, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 101, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 100, 62));
			}
			// Line: 104
			try {
				count = getCount(1745769731) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(1745769731);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 105
							MorningCall state28 = new MorningCall();
							flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 105, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 104, 59));
			}
			// Line: 108
			try {
				count = getCount(514180735) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(514180735);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state29 = agent.new say();
							StringCreator string30 = new StringCreator();
							string30.append("Okay");
							state29.setText(string30.toString());
							if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 108, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 110
							Goodbye state31 = new Goodbye();
							flowThread.gotoState(state31, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 110, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 108, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Goodbye extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 118
			try {
				EXECUTION: {
					int count = getCount(881367094) + 1;
					incrCount(881367094);
					iristk.situated.SystemAgentFlow.say state32 = agent.new say();
					StringCreator string33 = new StringCreator();
					string33.append("Goodbye.");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state34 = agent.new say();
					StringCreator string35 = new StringCreator();
					string35.append("Please leave the detection area");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 121
					iristk.flow.DialogFlow.wait waitState36 = new iristk.flow.DialogFlow.wait();
					waitState36.setMsec(2000);
					if (!flowThread.callState(waitState36, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 121, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 122
					Idle state37 = new Idle();
					flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 122, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 118, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryAttr extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 129
			try {
				EXECUTION: {
					int count = getCount(154262056) + 1;
					incrCount(154262056);
					iristk.situated.SystemAgentFlow.prompt state38 = agent.new prompt();
					StringCreator string39 = new StringCreator();
					string39.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state38.setText(string39.toString());
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 129, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 129, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 134
			try {
				count = getCount(2094912766) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(2094912766);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 135
							Nature state40 = new Nature();
							flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 135, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 134, 68));
			}
			// Line: 137
			try {
				count = getCount(1982375487) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(1982375487);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 138
							History state41 = new History();
							flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 138, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 137, 71));
			}
			// Line: 140
			try {
				count = getCount(1663537851) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(1663537851);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 141
							Popular state42 = new Popular();
							flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 141, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 140, 66));
			}
			// Line: 143
			try {
				count = getCount(2126553203) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2126553203);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 144
							CheckAgain state43 = new CheckAgain();
							flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 144, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 143, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Nature extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 149
			try {
				EXECUTION: {
					int count = getCount(880417492) + 1;
					incrCount(880417492);
					iristk.situated.SystemAgentFlow.say state44 = agent.new say();
					state44.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 149, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 151
					Attrdetial state45 = new Attrdetial();
					flowThread.gotoState(state45, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 151, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 149, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class History extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 156
			try {
				EXECUTION: {
					int count = getCount(2141806179) + 1;
					incrCount(2141806179);
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					state46.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 156, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 158
					Attrdetial state47 = new Attrdetial();
					flowThread.gotoState(state47, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 158, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 156, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Popular extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 163
			try {
				EXECUTION: {
					int count = getCount(1651261557) + 1;
					incrCount(1651261557);
					iristk.situated.SystemAgentFlow.say state48 = agent.new say();
					state48.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 163, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 165
					Attrdetial state49 = new Attrdetial();
					flowThread.gotoState(state49, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 165, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 163, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Attrdetial extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 170
			try {
				EXECUTION: {
					int count = getCount(521750137) + 1;
					incrCount(521750137);
					iristk.situated.SystemAgentFlow.prompt state50 = agent.new prompt();
					StringCreator string51 = new StringCreator();
					string51.append("If you want more details for attractions,please say the name.");
					state50.setText(string51.toString());
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 170, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 170, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 173
			try {
				count = getCount(536269319) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(536269319);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 174
							attrnamepass=event.get("sem:attrname");
							iristk.situated.SystemAgentFlow.say state52 = agent.new say();
							state52.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 173, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 176
							iristk.flow.DialogFlow.wait waitState53 = new iristk.flow.DialogFlow.wait();
							waitState53.setMsec(800);
							if (!flowThread.callState(waitState53, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 176, 28)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 177
							Attrtrans state54 = new Attrtrans();
							flowThread.gotoState(state54, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 177, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 173, 69));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Attrtrans extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 183
			try {
				EXECUTION: {
					int count = getCount(495018214) + 1;
					incrCount(495018214);
					iristk.situated.SystemAgentFlow.say state55 = agent.new say();
					StringCreator string56 = new StringCreator();
					string56.append("Do you want to know how to get there?");
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 183, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state57 = agent.new listen();
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 183, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 183, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 187
			try {
				count = getCount(416694831) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(416694831);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state58 = agent.new say();
							state58.setText(info.transdetail(info.readtrans(),attrnamepass));
							if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 187, 62)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 189
							CheckAgain state59 = new CheckAgain();
							flowThread.gotoState(state59, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 189, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 187, 62));
			}
			// Line: 191
			try {
				count = getCount(1292537486) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1292537486);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 192
							CheckAgain state60 = new CheckAgain();
							flowThread.gotoState(state60, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 191, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryTrans extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 198
			try {
				EXECUTION: {
					int count = getCount(1750649327) + 1;
					incrCount(1750649327);
					iristk.situated.SystemAgentFlow.prompt state61 = agent.new prompt();
					StringCreator string62 = new StringCreator();
					string62.append("Where do you want to go?");
					state61.setText(string62.toString());
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 198, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 198, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 201
			try {
				count = getCount(1908364436) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1908364436);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state63 = agent.new say();
							state63.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 201, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 203
							CheckAgain state64 = new CheckAgain();
							flowThread.gotoState(state64, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 203, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 201, 65));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryRoom extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 209
			try {
				EXECUTION: {
					int count = getCount(446524765) + 1;
					incrCount(446524765);
					iristk.situated.SystemAgentFlow.prompt state65 = agent.new prompt();
					StringCreator string66 = new StringCreator();
					string66.append("Which room do you want to find?");
					state65.setText(string66.toString());
					if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 209, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 209, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 212
			try {
				count = getCount(286101870) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(286101870);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state67 = agent.new say();
							StringCreator string68 = new StringCreator();
							string68.append("It is on the first floor");
							state67.setText(string68.toString());
							if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 212, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 214
							CheckAgain state69 = new CheckAgain();
							flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 214, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 212, 70));
			}
			// Line: 216
			try {
				count = getCount(2099573676) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(2099573676);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 217
						String ss = event.get("text").toString();
						// Line: 218
						if (eq("Sorry",info.findroom(ss))) {
							iristk.situated.SystemAgentFlow.say state70 = agent.new say();
							StringCreator string71 = new StringCreator();
							string71.append("Sorry, I didn't get that.");
							state70.setText(string71.toString());
							if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 220
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 220, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 221
						} else {
							iristk.situated.SystemAgentFlow.say state72 = agent.new say();
							state72.setText(info.findroom(ss));
							if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 223
							CheckAgain state73 = new CheckAgain();
							flowThread.gotoState(state73, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 223, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 216, 42));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryWeather extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 230
			try {
				EXECUTION: {
					int count = getCount(1653392524) + 1;
					incrCount(1653392524);
					iristk.situated.SystemAgentFlow.say state74 = agent.new say();
					state74.setText(weather.getweather());
					if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 230, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 232
					CheckAgain state75 = new CheckAgain();
					flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 232, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 230, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class MorningCall extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 238
			try {
				EXECUTION: {
					int count = getCount(1693923104) + 1;
					incrCount(1693923104);
					// Line: 239
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state76 = agent.new prompt();
					StringCreator string77 = new StringCreator();
					string77.append("When do you want to awake?");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 238, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 238, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 243
			try {
				count = getCount(381544396) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") && event.has("sem:number")) {
						incrCount(381544396);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 244
							call.putIfNotNull("minute", 0);
							// Line: 245
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 246
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state78 = agent.new say();
								StringCreator string79 = new StringCreator();
								string79.append("Sorry the time is invalid.");
								state78.setText(string79.toString());
								if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 246, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 248
							} else if (num > 12) {
								// Line: 249
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 251
							} else {
								// Line: 252
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 253
								if (event.has("sem:apm")) {
									// Line: 254
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 257
							if (event.has("sem:date")) {
								// Line: 258
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 260
							checkcall state80 = new checkcall();
							flowThread.gotoState(state80, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 260, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 243, 82));
			}
			// Line: 263
			try {
				count = getCount(324868411) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(324868411);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 264
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 265
							call.putIfNotNull("minute", 30);
							// Line: 266
							if (event.has("sem:past")) {
								// Line: 267
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state81 = agent.new say();
									StringCreator string82 = new StringCreator();
									string82.append("Sorry the time is invalid.");
									state81.setText(string82.toString());
									if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 267, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 269
								} else if (num > 11) {
									// Line: 270
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 271
								} else {
									// Line: 272
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 273
									if (event.has("sem:apm")) {
										// Line: 274
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 277
								if (event.has("sem:date")) {
									// Line: 278
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 280
								checkcall state83 = new checkcall();
								flowThread.gotoState(state83, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 280, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 283
							if (event.has("sem:to")) {
								// Line: 284
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state84 = agent.new say();
									StringCreator string85 = new StringCreator();
									string85.append("Sorry the time is invalid.");
									state84.setText(string85.toString());
									if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 284, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 286
								} else if (num > 12) {
									// Line: 287
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 288
								} else {
									// Line: 289
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 290
									if (event.has("sem:apm")) {
										// Line: 291
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 294
								if (event.has("sem:date")) {
									// Line: 295
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 297
								checkcall state86 = new checkcall();
								flowThread.gotoState(state86, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 297, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 263, 81));
			}
			// Line: 301
			try {
				count = getCount(148788170) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:noon")) {
						incrCount(148788170);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 302
							call.putIfNotNull("hour", 12); call.putIfNotNull("minute", 0); call.putIfNotNull("apm", "am");
							// Line: 303
							if (event.has("sem:date")) {
								// Line: 304
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 306
							checkcall state87 = new checkcall();
							flowThread.gotoState(state87, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 306, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 301, 59));
			}
			// Line: 309
			try {
				count = getCount(105804138) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:midnight")) {
						incrCount(105804138);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 310
							call.putIfNotNull("hour", 0); call.putIfNotNull("minute", 0); call.putIfNotNull("apm", "am");
							// Line: 311
							if (event.has("sem:date")) {
								// Line: 312
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 314
							checkcall state88 = new checkcall();
							flowThread.gotoState(state88, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 314, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 309, 63));
			}
			// Line: 317
			try {
				count = getCount(478023204) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(478023204);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 318
							CheckAgain state89 = new CheckAgain();
							flowThread.gotoState(state89, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 318, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 317, 57));
			}
			// Line: 321
			try {
				count = getCount(1743923454) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1743923454);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 322
							checkcall state90 = new checkcall();
							flowThread.gotoState(state90, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 322, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 321, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class checkcall extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 328
			try {
				EXECUTION: {
					int count = getCount(1728061172) + 1;
					incrCount(1728061172);
					// Line: 329
					if (!call.has("hour")) {
						// Line: 330
						askhour state91 = new askhour();
						flowThread.gotoState(state91, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 330, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 331
					} else if (!call.has("minute")) {
						// Line: 332
						askminute state92 = new askminute();
						flowThread.gotoState(state92, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 332, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 333
					} else if (!call.has("apm")) {
						// Line: 334
						askapm state93 = new askapm();
						flowThread.gotoState(state93, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 334, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 335
					} else if (!call.has("date")) {
						// Line: 336
						askdate state94 = new askdate();
						flowThread.gotoState(state94, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 336, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 337
					} else {
						// Line: 338
						calldone state95 = new calldone();
						flowThread.gotoState(state95, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 338, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 328, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askhour extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 344
			try {
				EXECUTION: {
					int count = getCount(964266011) + 1;
					incrCount(964266011);
					iristk.situated.SystemAgentFlow.prompt state96 = agent.new prompt();
					StringCreator string97 = new StringCreator();
					string97.append("Please say the hour of the morning call.");
					state96.setText(string97.toString());
					if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 344, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 344, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 347
			try {
				count = getCount(515429323) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(515429323);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 348
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 349
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state98 = agent.new say();
								StringCreator string99 = new StringCreator();
								string99.append("Sorry the time is invalid.");
								state98.setText(string99.toString());
								if (!flowThread.callState(state98, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 349, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 351
							} else if ( num > 11 ) {
								// Line: 352
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 353
							} else {
								// Line: 354
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 356
							checkcall state100 = new checkcall();
							flowThread.gotoState(state100, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 356, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 347, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askminute extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 361
			try {
				EXECUTION: {
					int count = getCount(2121218821) + 1;
					incrCount(2121218821);
					iristk.situated.SystemAgentFlow.prompt state101 = agent.new prompt();
					StringCreator string102 = new StringCreator();
					string102.append("Please say the minute of the morning call.");
					state101.setText(string102.toString());
					if (!flowThread.callState(state101, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 361, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 361, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 364
			try {
				count = getCount(1767292405) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1767292405);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 365
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 366
							checkcall state103 = new checkcall();
							flowThread.gotoState(state103, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 366, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 364, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askapm extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 371
			try {
				EXECUTION: {
					int count = getCount(684394010) + 1;
					incrCount(684394010);
					iristk.situated.SystemAgentFlow.prompt state104 = agent.new prompt();
					StringCreator string105 = new StringCreator();
					string105.append("Is it a.m. or p.m.?");
					state104.setText(string105.toString());
					if (!flowThread.callState(state104, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 371, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 371, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 374
			try {
				count = getCount(1902224399) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1902224399);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 375
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 376
							checkcall state106 = new checkcall();
							flowThread.gotoState(state106, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 376, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 374, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askdate extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 381
			try {
				EXECUTION: {
					int count = getCount(2134272779) + 1;
					incrCount(2134272779);
					iristk.situated.SystemAgentFlow.prompt state107 = agent.new prompt();
					StringCreator string108 = new StringCreator();
					string108.append("Do we need to call you at today or tomorrow?");
					state107.setText(string108.toString());
					if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 381, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 381, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 384
			try {
				count = getCount(1845464360) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1845464360);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 385
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 386
							checkcall state109 = new checkcall();
							flowThread.gotoState(state109, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 386, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 384, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class calldone extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 391
			try {
				EXECUTION: {
					int count = getCount(426072485) + 1;
					incrCount(426072485);
					// Line: 392
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state110 = agent.new prompt();
					state110.setText(info.timeconfirm(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state110, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 391, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 391, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 396
			try {
				count = getCount(1440198141) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1440198141);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 397
							callroom state111 = new callroom();
							flowThread.gotoState(state111, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 397, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 396, 58));
			}
			// Line: 399
			try {
				count = getCount(2116873370) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2116873370);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 400
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 401
							MorningCall state112 = new MorningCall();
							flowThread.gotoState(state112, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 401, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 399, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class callroom extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 406
			try {
				EXECUTION: {
					int count = getCount(1530492415) + 1;
					incrCount(1530492415);
					iristk.situated.SystemAgentFlow.prompt state113 = agent.new prompt();
					StringCreator string114 = new StringCreator();
					string114.append("Which room do you live in?");
					state113.setText(string114.toString());
					if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 406, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 406, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 409
			try {
				count = getCount(1672744575) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1672744575);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 410
						String sss = event.get("text").toString();
						// Line: 411
						if (eq("Sorry",info.callroom(sss))) {
							iristk.situated.SystemAgentFlow.say state115 = agent.new say();
							StringCreator string116 = new StringCreator();
							string116.append("Sorry, I didn't get that.");
							state115.setText(string116.toString());
							if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 411, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 413
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 413, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 414
						} else {
							iristk.situated.SystemAgentFlow.say state117 = agent.new say();
							state117.setText(info.callroom(sss));
							if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 411, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 416
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 417
							roomconfirm state118 = new roomconfirm();
							flowThread.gotoState(state118, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 417, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 409, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class roomconfirm extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 423
			try {
				EXECUTION: {
					int count = getCount(294965745) + 1;
					incrCount(294965745);
					iristk.situated.SystemAgentFlow.listen state119 = agent.new listen();
					if (!flowThread.callState(state119, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 423, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 423, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 426
			try {
				count = getCount(1827756245) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1827756245);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 427
							call.remove("room");
							// Line: 428
							callroom state120 = new callroom();
							flowThread.gotoState(state120, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 428, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 426, 57));
			}
			// Line: 430
			try {
				count = getCount(1793089587) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1793089587);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 431
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 434
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 435
							CheckAgain state121 = new CheckAgain();
							flowThread.gotoState(state121, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 435, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 430, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 443
			try {
				EXECUTION: {
					int count = getCount(435997478) + 1;
					incrCount(435997478);
					iristk.situated.SystemAgentFlow.prompt state122 = agent.new prompt();
					StringCreator string123 = new StringCreator();
					string123.append("Do you need other help?");
					state122.setText(string123.toString());
					if (!flowThread.callState(state122, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 443, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 443, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 446
			try {
				count = getCount(738171448) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(738171448);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state124 = agent.new say();
							StringCreator string125 = new StringCreator();
							string125.append("Okay");
							state124.setText(string125.toString());
							if (!flowThread.callState(state124, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 446, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 448
							Start state126 = new Start();
							flowThread.gotoState(state126, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 448, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 446, 58));
			}
			// Line: 450
			try {
				count = getCount(48360178) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(48360178);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state127 = agent.new say();
							StringCreator string128 = new StringCreator();
							string128.append("Okay");
							state127.setText(string128.toString());
							if (!flowThread.callState(state127, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 450, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 452
							Goodbye state129 = new Goodbye();
							flowThread.gotoState(state129, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 452, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 450, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 457
			try {
				count = getCount(716953495) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(716953495);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state130 = agent.new gesture();
							state130.setName("smile");
							if (!flowThread.callState(state130, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 457, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 457, 102));
			}
			// Line: 460
			try {
				count = getCount(654319176) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(654319176);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state131 = agent.new say();
						StringCreator string132 = new StringCreator();
						string132.append("Sorry, I didn't get that.");
						state131.setText(string132.toString());
						if (!flowThread.callState(state131, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 460, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 462
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 462, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 460, 36));
			}
			// Line: 464
			try {
				count = getCount(1002176089) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:exit")) {
						incrCount(1002176089);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 465
							Greeting state133 = new Greeting();
							flowThread.gotoState(state133, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 465, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 464, 59));
			}
			// Line: 467
			try {
				count = getCount(1755128873) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1755128873);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state134 = agent.new say();
						StringCreator string135 = new StringCreator();
						string135.append("Sorry, I didn't hear anything.");
						state134.setText(string135.toString());
						if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 467, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 469
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 469, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 467, 38));
			}
			// Line: 471
			try {
				count = getCount(1245289206) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1245289206);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state136 = agent.new say();
							StringCreator string137 = new StringCreator();
							string137.append("Goodbye");
							state136.setText(string137.toString());
							if (!flowThread.callState(state136, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 471, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 477
							Idle state138 = new Idle();
							flowThread.gotoState(state138, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 477, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 471, 69));
			}
			// Line: 480
			try {
				count = getCount(1078541373) + 1;
				if (event.triggers("repeat")) {
					incrCount(1078541373);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 481
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 481, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 480, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 493
			try {
				EXECUTION: {
					int count = getCount(697228372) + 1;
					incrCount(697228372);
					iristk.situated.SystemAgentFlow.prompt state139 = agent.new prompt();
					StringCreator string140 = new StringCreator();
					string140.append("请问有什么可以帮到您的？");
					state139.setText(string140.toString());
					if (!flowThread.callState(state139, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 493, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 493, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 501
			try {
				count = getCount(539993484) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(539993484);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 502
						String s = event.get("text").toString();
						// Line: 503
						int value=mandarin.attraction(s);
						// Line: 504
						int value3=mandarin.nature(s);
						// Line: 505
						int value4=mandarin.history(s);
						// Line: 506
						int value5=mandarin.popular(s);
						// Line: 507
						if (value==2) {
							// Line: 508
							QueryAttr_CN state141 = new QueryAttr_CN();
							flowThread.gotoState(state141, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 508, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 509
						} else if (value3==3) {
							// Line: 510
							Nature_CN state142 = new Nature_CN();
							flowThread.gotoState(state142, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 510, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 511
						} else if (value4==4) {
							// Line: 512
							History_CN state143 = new History_CN();
							flowThread.gotoState(state143, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 512, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 513
						} else if (value5==5) {
							// Line: 514
							Popular_CN state144 = new Popular_CN();
							flowThread.gotoState(state144, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 514, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 515
						} else {
							iristk.situated.SystemAgentFlow.say state145 = agent.new say();
							StringCreator string146 = new StringCreator();
							string146.append("抱歉，我没有理解您说的话。");
							state145.setText(string146.toString());
							if (!flowThread.callState(state145, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 507, 24)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 501, 38));
			}
			// Line: 520
			try {
				count = getCount(100417368) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(100417368);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 521
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state147 = agent.new say();
								state147.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state147, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 521, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 523
								CheckAgain_CN state148 = new CheckAgain_CN();
								flowThread.gotoState(state148, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 523, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 524
							} else {
								// Line: 525
								QueryTrans_CN state149 = new QueryTrans_CN();
								flowThread.gotoState(state149, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 525, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 520, 71));
			}
			// Line: 529
			try {
				count = getCount(558830667) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(558830667);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 530
							QueryRoom_CN state150 = new QueryRoom_CN();
							flowThread.gotoState(state150, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 530, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 529, 62));
			}
			// Line: 533
			try {
				count = getCount(916541184) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(916541184);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 534
							QueryWeather_CN state151 = new QueryWeather_CN();
							flowThread.gotoState(state151, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 534, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 533, 62));
			}
			// Line: 537
			try {
				count = getCount(612648264) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(612648264);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 538
							MorningCall_CN state152 = new MorningCall_CN();
							flowThread.gotoState(state152, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 538, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 537, 59));
			}
			// Line: 541
			try {
				count = getCount(472908822) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(472908822);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state153 = agent.new say();
							StringCreator string154 = new StringCreator();
							string154.append("好的");
							state153.setText(string154.toString());
							if (!flowThread.callState(state153, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 541, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 543
							Goodbye_CN state155 = new Goodbye_CN();
							flowThread.gotoState(state155, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 543, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 541, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Goodbye_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 550
			try {
				EXECUTION: {
					int count = getCount(1818663199) + 1;
					incrCount(1818663199);
					iristk.situated.SystemAgentFlow.say state156 = agent.new say();
					StringCreator string157 = new StringCreator();
					string157.append("再见。");
					state156.setText(string157.toString());
					if (!flowThread.callState(state156, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 550, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state158 = agent.new say();
					StringCreator string159 = new StringCreator();
					string159.append("请离开感应区域");
					state158.setText(string159.toString());
					if (!flowThread.callState(state158, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 550, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 553
					iristk.flow.DialogFlow.wait waitState160 = new iristk.flow.DialogFlow.wait();
					waitState160.setMsec(2000);
					if (!flowThread.callState(waitState160, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 553, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 554
					Idle state161 = new Idle();
					flowThread.gotoState(state161, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 554, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 550, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryAttr_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 561
			try {
				EXECUTION: {
					int count = getCount(1800080328) + 1;
					incrCount(1800080328);
					iristk.situated.SystemAgentFlow.prompt state162 = agent.new prompt();
					StringCreator string163 = new StringCreator();
					string163.append("您想参观哪种景点？自然景点，历史景点还是热门景点？");
					state162.setText(string163.toString());
					if (!flowThread.callState(state162, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 561, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 561, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 566
			try {
				count = getCount(1250018616) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(1250018616);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 567
							Nature_CN state164 = new Nature_CN();
							flowThread.gotoState(state164, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 567, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 566, 68));
			}
			// Line: 569
			try {
				count = getCount(1703613987) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(1703613987);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 570
							History_CN state165 = new History_CN();
							flowThread.gotoState(state165, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 570, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 569, 71));
			}
			// Line: 572
			try {
				count = getCount(314696697) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(314696697);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 573
							Popular_CN state166 = new Popular_CN();
							flowThread.gotoState(state166, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 573, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 572, 66));
			}
			// Line: 575
			try {
				count = getCount(2020175198) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2020175198);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 576
							CheckAgain_CN state167 = new CheckAgain_CN();
							flowThread.gotoState(state167, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 576, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 575, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Nature_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 581
			try {
				EXECUTION: {
					int count = getCount(1850508427) + 1;
					incrCount(1850508427);
					iristk.situated.SystemAgentFlow.say state168 = agent.new say();
					state168.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state168, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 581, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 583
					Attrdetial_CN state169 = new Attrdetial_CN();
					flowThread.gotoState(state169, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 583, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 581, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class History_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 588
			try {
				EXECUTION: {
					int count = getCount(1599540181) + 1;
					incrCount(1599540181);
					iristk.situated.SystemAgentFlow.say state170 = agent.new say();
					state170.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state170, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 588, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 590
					Attrdetial_CN state171 = new Attrdetial_CN();
					flowThread.gotoState(state171, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 590, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 588, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Popular_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 595
			try {
				EXECUTION: {
					int count = getCount(1545506217) + 1;
					incrCount(1545506217);
					iristk.situated.SystemAgentFlow.say state172 = agent.new say();
					state172.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state172, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 595, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 597
					Attrdetial_CN state173 = new Attrdetial_CN();
					flowThread.gotoState(state173, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 597, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 595, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Attrdetial_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 602
			try {
				EXECUTION: {
					int count = getCount(1827889916) + 1;
					incrCount(1827889916);
					iristk.situated.SystemAgentFlow.prompt state174 = agent.new prompt();
					StringCreator string175 = new StringCreator();
					string175.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state174.setText(string175.toString());
					if (!flowThread.callState(state174, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 602, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 602, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 605
			try {
				count = getCount(1143527694) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1143527694);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 606
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state176 = agent.new say();
							state176.setText(info.detail_CN(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state176, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 605, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 608
							CheckAgain_CN state177 = new CheckAgain_CN();
							flowThread.gotoState(state177, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 608, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 605, 69));
			}
			// Line: 610
			try {
				count = getCount(1022723422) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1022723422);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 611
							CheckAgain_CN state178 = new CheckAgain_CN();
							flowThread.gotoState(state178, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 611, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 610, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryTrans_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 617
			try {
				EXECUTION: {
					int count = getCount(954058029) + 1;
					incrCount(954058029);
					iristk.situated.SystemAgentFlow.prompt state179 = agent.new prompt();
					StringCreator string180 = new StringCreator();
					string180.append("您打算去哪里？");
					state179.setText(string180.toString());
					if (!flowThread.callState(state179, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 617, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 617, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 620
			try {
				count = getCount(680687645) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attrname")) {
						incrCount(680687645);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state181 = agent.new say();
							state181.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 63)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 622
							CheckAgain_CN state182 = new CheckAgain_CN();
							flowThread.gotoState(state182, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 622, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryRoom_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 628
			try {
				EXECUTION: {
					int count = getCount(354264869) + 1;
					incrCount(354264869);
					iristk.situated.SystemAgentFlow.prompt state183 = agent.new prompt();
					StringCreator string184 = new StringCreator();
					string184.append("您在找哪个房间？");
					state183.setText(string184.toString());
					if (!flowThread.callState(state183, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 628, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 628, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 631
			try {
				count = getCount(787773195) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(787773195);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state185 = agent.new say();
							StringCreator string186 = new StringCreator();
							string186.append("它在一楼。");
							state185.setText(string186.toString());
							if (!flowThread.callState(state185, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 631, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 633
							CheckAgain_CN state187 = new CheckAgain_CN();
							flowThread.gotoState(state187, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 633, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 631, 70));
			}
			// Line: 635
			try {
				count = getCount(1221673980) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1221673980);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 636
						String ss = event.get("text").toString();
						// Line: 637
						if (eq("Sorry",info.findroom_CN(ss))) {
							iristk.situated.SystemAgentFlow.say state188 = agent.new say();
							StringCreator string189 = new StringCreator();
							string189.append("抱歉，我没有理解您说的话。");
							state188.setText(string189.toString());
							if (!flowThread.callState(state188, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 639
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 639, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 640
						} else {
							iristk.situated.SystemAgentFlow.say state190 = agent.new say();
							state190.setText(info.findroom_CN(ss));
							if (!flowThread.callState(state190, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 642
							CheckAgain_CN state191 = new CheckAgain_CN();
							flowThread.gotoState(state191, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 642, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 635, 42));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryWeather_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 649
			try {
				EXECUTION: {
					int count = getCount(996776963) + 1;
					incrCount(996776963);
					iristk.situated.SystemAgentFlow.say state192 = agent.new say();
					state192.setText(weather.getweather_CN());
					if (!flowThread.callState(state192, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 649, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 651
					CheckAgain_CN state193 = new CheckAgain_CN();
					flowThread.gotoState(state193, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 651, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 649, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class MorningCall_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 656
			try {
				EXECUTION: {
					int count = getCount(1628447508) + 1;
					incrCount(1628447508);
					// Line: 657
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state194 = agent.new prompt();
					StringCreator string195 = new StringCreator();
					string195.append("您需要几点叫您？");
					state194.setText(string195.toString());
					if (!flowThread.callState(state194, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 656, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 656, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 661
			try {
				count = getCount(760947560) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") || event.has("sem:number")) {
						incrCount(760947560);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 662
							call.putIfNotNull("minute", 0);
							// Line: 663
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 664
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state196 = agent.new say();
								StringCreator string197 = new StringCreator();
								string197.append("对不起这是无效的时间。");
								state196.setText(string197.toString());
								if (!flowThread.callState(state196, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 664, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 666
							} else if (num > 12) {
								// Line: 667
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 669
							} else {
								// Line: 670
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 671
								if (event.has("sem:apm")) {
									// Line: 672
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 675
							if (event.has("sem:date")) {
								// Line: 676
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 678
							checkcall_CN state198 = new checkcall_CN();
							flowThread.gotoState(state198, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 678, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 661, 81));
			}
			// Line: 681
			try {
				count = getCount(11902991) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(11902991);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 682
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 683
							call.putIfNotNull("minute", 30);
							// Line: 684
							if (event.has("sem:past")) {
								// Line: 685
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state199 = agent.new say();
									StringCreator string200 = new StringCreator();
									string200.append("对不起这是无效的时间。");
									state199.setText(string200.toString());
									if (!flowThread.callState(state199, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 685, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 687
								} else if (num > 11) {
									// Line: 688
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 689
								} else {
									// Line: 690
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 691
									if (event.has("sem:apm")) {
										// Line: 692
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 695
								if (event.has("sem:date")) {
									// Line: 696
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 698
								checkcall_CN state201 = new checkcall_CN();
								flowThread.gotoState(state201, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 698, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 701
							if (event.has("sem:to")) {
								// Line: 702
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state202 = agent.new say();
									StringCreator string203 = new StringCreator();
									string203.append("对不起这是无效的时间。");
									state202.setText(string203.toString());
									if (!flowThread.callState(state202, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 702, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 704
								} else if (num > 12) {
									// Line: 705
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 706
								} else {
									// Line: 707
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 708
									if (event.has("sem:apm")) {
										// Line: 709
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 712
								if (event.has("sem:date")) {
									// Line: 713
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 715
								checkcall_CN state204 = new checkcall_CN();
								flowThread.gotoState(state204, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 715, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 681, 81));
			}
			// Line: 719
			try {
				count = getCount(861484176) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(861484176);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 720
							CheckAgain_CN state205 = new CheckAgain_CN();
							flowThread.gotoState(state205, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 720, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 719, 57));
			}
			// Line: 723
			try {
				count = getCount(956711303) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(956711303);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 724
							checkcall_CN state206 = new checkcall_CN();
							flowThread.gotoState(state206, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 724, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 723, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class checkcall_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 730
			try {
				EXECUTION: {
					int count = getCount(1462522213) + 1;
					incrCount(1462522213);
					// Line: 731
					if (!call.has("hour")) {
						// Line: 732
						askhour_CN state207 = new askhour_CN();
						flowThread.gotoState(state207, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 732, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 733
					} else if (!call.has("minute")) {
						// Line: 734
						askminute_CN state208 = new askminute_CN();
						flowThread.gotoState(state208, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 734, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 735
					} else if (!call.has("apm")) {
						// Line: 736
						askapm_CN state209 = new askapm_CN();
						flowThread.gotoState(state209, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 736, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 737
					} else if (!call.has("date")) {
						// Line: 738
						askdate_CN state210 = new askdate_CN();
						flowThread.gotoState(state210, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 738, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 739
					} else {
						// Line: 740
						calldone_CN state211 = new calldone_CN();
						flowThread.gotoState(state211, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 740, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 730, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askhour_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 746
			try {
				EXECUTION: {
					int count = getCount(1601316903) + 1;
					incrCount(1601316903);
					iristk.situated.SystemAgentFlow.prompt state212 = agent.new prompt();
					StringCreator string213 = new StringCreator();
					string213.append("请设置小时数。");
					state212.setText(string213.toString());
					if (!flowThread.callState(state212, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 746, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 746, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 749
			try {
				count = getCount(731319378) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(731319378);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 750
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 751
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state214 = agent.new say();
								StringCreator string215 = new StringCreator();
								string215.append("对不起这是无效的时间。");
								state214.setText(string215.toString());
								if (!flowThread.callState(state214, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 751, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 753
							} else if ( num > 11 ) {
								// Line: 754
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 755
							} else {
								// Line: 756
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 758
							checkcall_CN state216 = new checkcall_CN();
							flowThread.gotoState(state216, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 758, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 749, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askminute_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 763
			try {
				EXECUTION: {
					int count = getCount(206516958) + 1;
					incrCount(206516958);
					iristk.situated.SystemAgentFlow.prompt state217 = agent.new prompt();
					StringCreator string218 = new StringCreator();
					string218.append("请设置分钟数。");
					state217.setText(string218.toString());
					if (!flowThread.callState(state217, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 763, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 763, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 766
			try {
				count = getCount(1642922196) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1642922196);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 767
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 768
							checkcall_CN state219 = new checkcall_CN();
							flowThread.gotoState(state219, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 768, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 766, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askapm_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 773
			try {
				EXECUTION: {
					int count = getCount(2044472568) + 1;
					incrCount(2044472568);
					iristk.situated.SystemAgentFlow.prompt state220 = agent.new prompt();
					StringCreator string221 = new StringCreator();
					string221.append("请问是上午还是下午?");
					state220.setText(string221.toString());
					if (!flowThread.callState(state220, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 773, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 773, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 776
			try {
				count = getCount(7444151) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(7444151);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 777
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 778
							checkcall_CN state222 = new checkcall_CN();
							flowThread.gotoState(state222, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 778, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 776, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askdate_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 783
			try {
				EXECUTION: {
					int count = getCount(25042985) + 1;
					incrCount(25042985);
					iristk.situated.SystemAgentFlow.prompt state223 = agent.new prompt();
					StringCreator string224 = new StringCreator();
					string224.append("请问是今天还是明天？");
					state223.setText(string224.toString());
					if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 783, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 783, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 786
			try {
				count = getCount(827380143) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(827380143);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 787
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 788
							checkcall_CN state225 = new checkcall_CN();
							flowThread.gotoState(state225, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 788, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 786, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class calldone_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 793
			try {
				EXECUTION: {
					int count = getCount(1949913089) + 1;
					incrCount(1949913089);
					// Line: 794
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state226 = agent.new prompt();
					state226.setText(info.timeconfirm_CN(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 793, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 793, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 798
			try {
				count = getCount(1666763449) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1666763449);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 799
							callroom_CN state227 = new callroom_CN();
							flowThread.gotoState(state227, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 799, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 798, 58));
			}
			// Line: 801
			try {
				count = getCount(129352836) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(129352836);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 802
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 803
							MorningCall_CN state228 = new MorningCall_CN();
							flowThread.gotoState(state228, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 803, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 801, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class callroom_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 808
			try {
				EXECUTION: {
					int count = getCount(1966647134) + 1;
					incrCount(1966647134);
					iristk.situated.SystemAgentFlow.prompt state229 = agent.new prompt();
					StringCreator string230 = new StringCreator();
					string230.append("请问您的房间号是多少？");
					state229.setText(string230.toString());
					if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 808, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 808, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 811
			try {
				count = getCount(143220829) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(143220829);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 812
						String sss = event.get("text").toString();
						// Line: 813
						if (eq("Sorry",info.callroom_CN(sss))) {
							iristk.situated.SystemAgentFlow.say state231 = agent.new say();
							StringCreator string232 = new StringCreator();
							string232.append("抱歉，我没有理解您说的话。");
							state231.setText(string232.toString());
							if (!flowThread.callState(state231, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 813, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 815
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 815, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 816
						} else {
							iristk.situated.SystemAgentFlow.say state233 = agent.new say();
							state233.setText(info.callroom_CN(sss));
							if (!flowThread.callState(state233, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 813, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 818
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 819
							roomconfirm_CN state234 = new roomconfirm_CN();
							flowThread.gotoState(state234, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 819, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 811, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class roomconfirm_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 825
			try {
				EXECUTION: {
					int count = getCount(1532570214) + 1;
					incrCount(1532570214);
					iristk.situated.SystemAgentFlow.listen state235 = agent.new listen();
					if (!flowThread.callState(state235, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 825, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 825, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 828
			try {
				count = getCount(1105170880) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1105170880);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 829
							call.remove("room");
							// Line: 830
							callroom_CN state236 = new callroom_CN();
							flowThread.gotoState(state236, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 830, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 828, 57));
			}
			// Line: 832
			try {
				count = getCount(353299945) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(353299945);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 833
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 836
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 837
							CheckAgain_CN state237 = new CheckAgain_CN();
							flowThread.gotoState(state237, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 837, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 832, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 846
			try {
				EXECUTION: {
					int count = getCount(910244307) + 1;
					incrCount(910244307);
					iristk.situated.SystemAgentFlow.prompt state238 = agent.new prompt();
					StringCreator string239 = new StringCreator();
					string239.append("您还需要其他帮助吗？");
					state238.setText(string239.toString());
					if (!flowThread.callState(state238, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 846, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 846, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 849
			try {
				count = getCount(178812210) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(178812210);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state240 = agent.new say();
							StringCreator string241 = new StringCreator();
							string241.append("好的");
							state240.setText(string241.toString());
							if (!flowThread.callState(state240, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 849, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 851
							Start_CN state242 = new Start_CN();
							flowThread.gotoState(state242, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 851, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 849, 58));
			}
			// Line: 853
			try {
				count = getCount(1981316279) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1981316279);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state243 = agent.new say();
							StringCreator string244 = new StringCreator();
							string244.append("好的");
							state243.setText(string244.toString());
							if (!flowThread.callState(state243, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 853, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 855
							Goodbye_CN state245 = new Goodbye_CN();
							flowThread.gotoState(state245, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 855, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 853, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 860
			try {
				count = getCount(69934810) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(69934810);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state246 = agent.new gesture();
							state246.setName("smile");
							if (!flowThread.callState(state246, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 860, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 860, 102));
			}
			// Line: 863
			try {
				count = getCount(828581676) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(828581676);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state247 = agent.new say();
						StringCreator string248 = new StringCreator();
						string248.append("抱歉，我没有理解您说的话。");
						state247.setText(string248.toString());
						if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 863, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 865
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 865, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 863, 36));
			}
			// Line: 867
			try {
				count = getCount(1070267611) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1070267611);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state249 = agent.new attendOther();
						state249.setMode("eyes");
						if (!flowThread.callState(state249, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 867, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state250 = agent.new say();
						StringCreator string251 = new StringCreator();
						string251.append("对不起，我现在没有问您。");
						state250.setText(string251.toString());
						if (!flowThread.callState(state250, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 867, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state252 = agent.new attendOther();
						state252.setMode("eyes");
						if (!flowThread.callState(state252, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 867, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 871
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 871, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 867, 41));
			}
			// Line: 873
			try {
				count = getCount(1270479156) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1270479156);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state253 = agent.new say();
						StringCreator string254 = new StringCreator();
						string254.append("请不要同时说话。");
						state253.setText(string254.toString());
						if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 873, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 875
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 875, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 873, 42));
			}
			// Line: 877
			try {
				count = getCount(499693746) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(499693746);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state255 = agent.new say();
						StringCreator string256 = new StringCreator();
						string256.append("抱歉，我没有听到任何话。");
						state255.setText(string256.toString());
						if (!flowThread.callState(state255, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 877, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 879
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 879, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 877, 38));
			}
			// Line: 881
			try {
				count = getCount(621429799) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(621429799);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state257 = agent.new say();
							StringCreator string258 = new StringCreator();
							string258.append("再见。");
							state257.setText(string258.toString());
							if (!flowThread.callState(state257, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 881, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 883
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state259 = agent.new attendRandom();
								if (!flowThread.callState(state259, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 883, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 885
								Start_CN state260 = new Start_CN();
								flowThread.gotoState(state260, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 885, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 886
							} else {
								// Line: 887
								Idle state261 = new Idle();
								flowThread.gotoState(state261, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 887, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 881, 69));
			}
			// Line: 890
			try {
				count = getCount(1987964737) + 1;
				if (event.triggers("repeat")) {
					incrCount(1987964737);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 891
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 891, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 890, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
