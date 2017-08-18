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
	private Object attrnamepassobject;
	private String attrnamepassstring;

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

	public Object getAttrnamepassobject() {
		return this.attrnamepassobject;
	}

	public void setAttrnamepassobject(Object value) {
		this.attrnamepassobject = value;
	}

	public String getAttrnamepassstring() {
		return this.attrnamepassstring;
	}

	public void setAttrnamepassstring(String value) {
		this.attrnamepassstring = value;
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
		if (name.equals("attrnamepassobject")) return this.attrnamepassobject;
		if (name.equals("attrnamepassstring")) return this.attrnamepassstring;
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
			// Line: 25
			try {
				EXECUTION: {
					int count = getCount(173875158) + 1;
					incrCount(173875158);
					// Line: 26
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 26, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 28
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 28, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 29
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 26, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 25, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 33
			try {
				count = getCount(662601284) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(662601284);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 33, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 35
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 35, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 33, 36));
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
			// Line: 40
			try {
				EXECUTION: {
					int count = getCount(1662054433) + 1;
					incrCount(1662054433);
					// Line: 41
					Event sendEvent5 = new Event("action.voice");
					sendEvent5.putIfNotNull("name", "David");
					flowRunner.sendEvent(sendEvent5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 41, 49)));
					iristk.situated.SystemAgentFlow.prompt state6 = agent.new prompt();
					StringCreator string7 = new StringCreator();
					string7.append("Hi there, Do you want me to speak English or Chinese?");
					state6.setText(string7.toString());
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 43
					Start state8 = new Start();
					flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 43, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 45
			try {
				count = getCount(400382825) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:english")) {
						incrCount(400382825);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 46
							lang = "en";
							// Line: 47
							Event sendEvent9 = new Event("action.context.default");
							sendEvent9.putIfNotNull("context", "English");
							flowRunner.sendEvent(sendEvent9, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 47, 65)));
							// Line: 48
							Event sendEvent10 = new Event("action.voice");
							sendEvent10.putIfNotNull("name", "David");
							flowRunner.sendEvent(sendEvent10, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 48, 51)));
							// Line: 49
							Start state11 = new Start();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 49, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 45, 62));
			}
			// Line: 51
			try {
				count = getCount(415082188) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(415082188);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 52
						String s = event.get("text").toString(); int value=mandarin.language(s);
						// Line: 53
						if (value==2) {
							// Line: 54
							lang = "zh";
							// Line: 55
							Event sendEvent12 = new Event("action.context.default");
							sendEvent12.putIfNotNull("context", "Chinese");
							flowRunner.sendEvent(sendEvent12, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 55, 66)));
							// Line: 56
							Event sendEvent13 = new Event("action.voice");
							sendEvent13.putIfNotNull("name", "HuiHui");
							flowRunner.sendEvent(sendEvent13, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 56, 51)));
							// Line: 57
							Start_CN state14 = new Start_CN();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 57, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 58
						} else {
							iristk.situated.SystemAgentFlow.say state15 = agent.new say();
							StringCreator string16 = new StringCreator();
							string16.append("Sorry, I didn't get that.");
							state15.setText(string16.toString());
							if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 53, 24)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 60
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 60, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 51, 36));
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
			// Line: 66
			try {
				EXECUTION: {
					int count = getCount(202174161) + 1;
					incrCount(202174161);
					iristk.situated.SystemAgentFlow.prompt state17 = agent.new prompt();
					StringCreator string18 = new StringCreator();
					string18.append("What can I do for you?");
					state17.setText(string18.toString());
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 66, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 66, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 74
			try {
				count = getCount(1822864896) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(1822864896);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 76
							if (event.has("sem:natural")) {
								// Line: 77
								Nature state19 = new Nature();
								flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 77, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 78
							} else if (event.has("sem:historical")) {
								// Line: 79
								History state20 = new History();
								flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 79, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 80
							} else if (event.has("sem:popular")) {
								// Line: 81
								Popular state21 = new Popular();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 81, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 82
							} else {
								// Line: 83
								QueryAttr state22 = new QueryAttr();
								flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 83, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 74, 68));
			}
			// Line: 87
			try {
				count = getCount(935483256) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(935483256);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 88
							if (event.has("sem:attrname")) {
								iristk.situated.SystemAgentFlow.say state23 = agent.new say();
								state23.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
								if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 88, 35)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 90
								CheckAgain state24 = new CheckAgain();
								flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 90, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 91
							} else {
								// Line: 92
								QueryTrans state25 = new QueryTrans();
								flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 92, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 87, 71));
			}
			// Line: 96
			try {
				count = getCount(1782985011) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(1782985011);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 98
							QueryRoom state26 = new QueryRoom();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 98, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 96, 62));
			}
			// Line: 101
			try {
				count = getCount(2006536821) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(2006536821);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 102
							QueryWeather state27 = new QueryWeather();
							flowThread.gotoState(state27, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 102, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 101, 62));
			}
			// Line: 105
			try {
				count = getCount(750812820) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(750812820);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 106
							MorningCall state28 = new MorningCall();
							flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 106, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 105, 59));
			}
			// Line: 109
			try {
				count = getCount(1271491837) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(1271491837);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state29 = agent.new say();
							StringCreator string30 = new StringCreator();
							string30.append("Okay");
							state29.setText(string30.toString());
							if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 109, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 111
							Goodbye state31 = new Goodbye();
							flowThread.gotoState(state31, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 111, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 109, 59));
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
			// Line: 119
			try {
				EXECUTION: {
					int count = getCount(831508152) + 1;
					incrCount(831508152);
					iristk.situated.SystemAgentFlow.say state32 = agent.new say();
					StringCreator string33 = new StringCreator();
					string33.append("Goodbye.");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 119, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state34 = agent.new say();
					StringCreator string35 = new StringCreator();
					string35.append("Please leave the detection area");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 119, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 122
					iristk.flow.DialogFlow.wait waitState36 = new iristk.flow.DialogFlow.wait();
					waitState36.setMsec(2000);
					if (!flowThread.callState(waitState36, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 122, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 123
					Idle state37 = new Idle();
					flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 123, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 119, 12));
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
			// Line: 130
			try {
				EXECUTION: {
					int count = getCount(809091335) + 1;
					incrCount(809091335);
					iristk.situated.SystemAgentFlow.prompt state38 = agent.new prompt();
					StringCreator string39 = new StringCreator();
					string39.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state38.setText(string39.toString());
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 130, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 130, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 135
			try {
				count = getCount(676768537) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(676768537);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 136
							Nature state40 = new Nature();
							flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 136, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 135, 68));
			}
			// Line: 138
			try {
				count = getCount(1214757511) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(1214757511);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 139
							History state41 = new History();
							flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 139, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 138, 71));
			}
			// Line: 141
			try {
				count = getCount(733675738) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(733675738);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 142
							Popular state42 = new Popular();
							flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 142, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 141, 66));
			}
			// Line: 144
			try {
				count = getCount(20230332) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(20230332);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 145
							CheckAgain state43 = new CheckAgain();
							flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 145, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 144, 61));
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
			// Line: 150
			try {
				EXECUTION: {
					int count = getCount(1729581023) + 1;
					incrCount(1729581023);
					iristk.situated.SystemAgentFlow.say state44 = agent.new say();
					state44.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 150, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 152
					Attrdetial state45 = new Attrdetial();
					flowThread.gotoState(state45, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 152, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 150, 16));
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
			// Line: 157
			try {
				EXECUTION: {
					int count = getCount(1129344852) + 1;
					incrCount(1129344852);
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					state46.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 157, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 159
					Attrdetial state47 = new Attrdetial();
					flowThread.gotoState(state47, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 159, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 157, 16));
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
			// Line: 164
			try {
				EXECUTION: {
					int count = getCount(1152680601) + 1;
					incrCount(1152680601);
					iristk.situated.SystemAgentFlow.say state48 = agent.new say();
					state48.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 164, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 166
					Attrdetial state49 = new Attrdetial();
					flowThread.gotoState(state49, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 166, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 164, 16));
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
			// Line: 171
			try {
				EXECUTION: {
					int count = getCount(603108465) + 1;
					incrCount(603108465);
					iristk.situated.SystemAgentFlow.prompt state50 = agent.new prompt();
					StringCreator string51 = new StringCreator();
					string51.append("If you want more details for attractions,please say the name.");
					state50.setText(string51.toString());
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 171, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 171, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 174
			try {
				count = getCount(1420250436) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1420250436);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 175
							attrnamepassobject=event.get("sem:attrname");
							iristk.situated.SystemAgentFlow.say state52 = agent.new say();
							state52.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 174, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 177
							iristk.flow.DialogFlow.wait waitState53 = new iristk.flow.DialogFlow.wait();
							waitState53.setMsec(800);
							if (!flowThread.callState(waitState53, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 177, 28)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 178
							Attrtrans state54 = new Attrtrans();
							flowThread.gotoState(state54, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 178, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 174, 69));
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
			// Line: 184
			try {
				EXECUTION: {
					int count = getCount(1121319418) + 1;
					incrCount(1121319418);
					iristk.situated.SystemAgentFlow.say state55 = agent.new say();
					StringCreator string56 = new StringCreator();
					string56.append("Do you want to know how to get there?");
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state57 = agent.new listen();
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 188
			try {
				count = getCount(2081061702) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(2081061702);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state58 = agent.new say();
							state58.setText(info.transdetail(info.readtrans(),attrnamepassobject));
							if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 188, 62)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 190
							CheckAgain state59 = new CheckAgain();
							flowThread.gotoState(state59, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 190, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 188, 62));
			}
			// Line: 192
			try {
				count = getCount(1566906301) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1566906301);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 193
							CheckAgain state60 = new CheckAgain();
							flowThread.gotoState(state60, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 193, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 61));
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
			// Line: 199
			try {
				EXECUTION: {
					int count = getCount(1380702397) + 1;
					incrCount(1380702397);
					iristk.situated.SystemAgentFlow.prompt state61 = agent.new prompt();
					StringCreator string62 = new StringCreator();
					string62.append("Where do you want to go?");
					state61.setText(string62.toString());
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 199, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 199, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 202
			try {
				count = getCount(661058998) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(661058998);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state63 = agent.new say();
							state63.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 202, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 204
							CheckAgain state64 = new CheckAgain();
							flowThread.gotoState(state64, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 204, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 202, 65));
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
			// Line: 210
			try {
				EXECUTION: {
					int count = getCount(638566090) + 1;
					incrCount(638566090);
					iristk.situated.SystemAgentFlow.prompt state65 = agent.new prompt();
					StringCreator string66 = new StringCreator();
					string66.append("Which room do you want to find?");
					state65.setText(string66.toString());
					if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 210, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 210, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 213
			try {
				count = getCount(911488248) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(911488248);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state67 = agent.new say();
							StringCreator string68 = new StringCreator();
							string68.append("It is on the first floor");
							state67.setText(string68.toString());
							if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 213, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 215
							CheckAgain state69 = new CheckAgain();
							flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 215, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 213, 70));
			}
			// Line: 217
			try {
				count = getCount(1684036044) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1684036044);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 218
						String ss = event.get("text").toString();
						// Line: 219
						if (eq("Sorry",info.findroom(ss))) {
							iristk.situated.SystemAgentFlow.say state70 = agent.new say();
							StringCreator string71 = new StringCreator();
							string71.append("Sorry, I didn't get that.");
							state70.setText(string71.toString());
							if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 219, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 221
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 221, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 222
						} else {
							iristk.situated.SystemAgentFlow.say state72 = agent.new say();
							state72.setText(info.findroom(ss));
							if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 219, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 224
							CheckAgain state73 = new CheckAgain();
							flowThread.gotoState(state73, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 224, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 217, 42));
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
			// Line: 231
			try {
				EXECUTION: {
					int count = getCount(1432891333) + 1;
					incrCount(1432891333);
					iristk.situated.SystemAgentFlow.say state74 = agent.new say();
					state74.setText(weather.getweather());
					if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 231, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 233
					CheckAgain state75 = new CheckAgain();
					flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 233, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 231, 12));
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
			// Line: 239
			try {
				EXECUTION: {
					int count = getCount(438674158) + 1;
					incrCount(438674158);
					// Line: 240
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state76 = agent.new prompt();
					StringCreator string77 = new StringCreator();
					string77.append("When do you want to awake?");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 239, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 239, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 244
			try {
				count = getCount(641610647) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") && event.has("sem:number")) {
						incrCount(641610647);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 245
							call.putIfNotNull("minute", 0);
							// Line: 246
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 247
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state78 = agent.new say();
								StringCreator string79 = new StringCreator();
								string79.append("Sorry the time is invalid.");
								state78.setText(string79.toString());
								if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 247, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 249
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 249, 15)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 250
							} else if (num > 12) {
								// Line: 251
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 253
							} else {
								// Line: 254
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 255
								if (event.has("sem:apm")) {
									// Line: 256
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 259
							if (event.has("sem:date")) {
								// Line: 260
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 262
							checkcall state80 = new checkcall();
							flowThread.gotoState(state80, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 262, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 244, 82));
			}
			// Line: 265
			try {
				count = getCount(1116731630) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(1116731630);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 266
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 267
							call.putIfNotNull("minute", 30);
							// Line: 268
							if (event.has("sem:past")) {
								// Line: 269
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state81 = agent.new say();
									StringCreator string82 = new StringCreator();
									string82.append("Sorry the time is invalid.");
									state81.setText(string82.toString());
									if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 269, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 271
									flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 271, 16)));
									eventResult = EVENT_ABORTED;
									break EXECUTION;
									// Line: 272
								} else if (num > 11) {
									// Line: 273
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "a.m.");
									// Line: 274
								} else {
									// Line: 275
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 276
									if (event.has("sem:apm")) {
										// Line: 277
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 280
								if (event.has("sem:date")) {
									// Line: 281
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 283
								checkcall state83 = new checkcall();
								flowThread.gotoState(state83, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 283, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 286
							if (event.has("sem:to")) {
								// Line: 287
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state84 = agent.new say();
									StringCreator string85 = new StringCreator();
									string85.append("Sorry the time is invalid.");
									state84.setText(string85.toString());
									if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 287, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 289
									flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 289, 16)));
									eventResult = EVENT_ABORTED;
									break EXECUTION;
									// Line: 290
								} else if (num > 12) {
									// Line: 291
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "a.m.");
									// Line: 292
								} else {
									// Line: 293
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 294
									if (event.has("sem:apm")) {
										// Line: 295
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 298
								if (event.has("sem:date")) {
									// Line: 299
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 301
								checkcall state86 = new checkcall();
								flowThread.gotoState(state86, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 301, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 265, 81));
			}
			// Line: 305
			try {
				count = getCount(638343515) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(638343515);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 306
							CheckAgain state87 = new CheckAgain();
							flowThread.gotoState(state87, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 306, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 305, 57));
			}
			// Line: 309
			try {
				count = getCount(1612020313) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1612020313);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 310
							checkcall state88 = new checkcall();
							flowThread.gotoState(state88, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 310, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 309, 61));
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
			// Line: 315
			try {
				EXECUTION: {
					int count = getCount(1259831402) + 1;
					incrCount(1259831402);
					// Line: 316
					if (!call.has("hour")) {
						// Line: 317
						askhour state89 = new askhour();
						flowThread.gotoState(state89, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 317, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 318
					} else if (!call.has("minute")) {
						// Line: 319
						askminute state90 = new askminute();
						flowThread.gotoState(state90, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 319, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 320
					} else if (!call.has("apm")) {
						// Line: 321
						askapm state91 = new askapm();
						flowThread.gotoState(state91, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 321, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 322
					} else if (!call.has("date")) {
						// Line: 323
						askdate state92 = new askdate();
						flowThread.gotoState(state92, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 323, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 324
					} else {
						// Line: 325
						calldone state93 = new calldone();
						flowThread.gotoState(state93, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 325, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 315, 12));
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
			// Line: 331
			try {
				EXECUTION: {
					int count = getCount(662733242) + 1;
					incrCount(662733242);
					iristk.situated.SystemAgentFlow.prompt state94 = agent.new prompt();
					StringCreator string95 = new StringCreator();
					string95.append("Please say the hour of the morning call.");
					state94.setText(string95.toString());
					if (!flowThread.callState(state94, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 331, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 331, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 334
			try {
				count = getCount(1615239747) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1615239747);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 335
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 336
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state96 = agent.new say();
								StringCreator string97 = new StringCreator();
								string97.append("Sorry the time is invalid.");
								state96.setText(string97.toString());
								if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 336, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 338
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 338, 15)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 339
							} else if ( num > 12 ) {
								// Line: 340
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "a.m.");
								// Line: 341
							} else {
								// Line: 342
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 344
							checkcall state98 = new checkcall();
							flowThread.gotoState(state98, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 344, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 334, 61));
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
			// Line: 349
			try {
				EXECUTION: {
					int count = getCount(909064868) + 1;
					incrCount(909064868);
					iristk.situated.SystemAgentFlow.prompt state99 = agent.new prompt();
					StringCreator string100 = new StringCreator();
					string100.append("Please say the minute of the morning call.");
					state99.setText(string100.toString());
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 349, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 349, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 352
			try {
				count = getCount(706053828) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(706053828);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 353
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 354
							checkcall state101 = new checkcall();
							flowThread.gotoState(state101, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 354, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 352, 61));
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
			// Line: 359
			try {
				EXECUTION: {
					int count = getCount(288812155) + 1;
					incrCount(288812155);
					iristk.situated.SystemAgentFlow.prompt state102 = agent.new prompt();
					StringCreator string103 = new StringCreator();
					string103.append("Is it a.m. or p.m.?");
					state102.setText(string103.toString());
					if (!flowThread.callState(state102, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 359, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 362
			try {
				count = getCount(871247429) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(871247429);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 363
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 364
							checkcall state104 = new checkcall();
							flowThread.gotoState(state104, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 364, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 362, 58));
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
			// Line: 369
			try {
				EXECUTION: {
					int count = getCount(936058639) + 1;
					incrCount(936058639);
					iristk.situated.SystemAgentFlow.prompt state105 = agent.new prompt();
					StringCreator string106 = new StringCreator();
					string106.append("Do we need to call you at today or tomorrow?");
					state105.setText(string106.toString());
					if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 369, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 369, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 372
			try {
				count = getCount(1554093195) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1554093195);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 373
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 374
							checkcall state107 = new checkcall();
							flowThread.gotoState(state107, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 374, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 372, 59));
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
			// Line: 379
			try {
				EXECUTION: {
					int count = getCount(1581203743) + 1;
					incrCount(1581203743);
					// Line: 380
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state108 = agent.new prompt();
					state108.setText(info.timeconfirm(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 379, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 379, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 384
			try {
				count = getCount(517787201) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(517787201);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 385
							callroom state109 = new callroom();
							flowThread.gotoState(state109, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 385, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 384, 58));
			}
			// Line: 387
			try {
				count = getCount(1613974684) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1613974684);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 388
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 389
							MorningCall state110 = new MorningCall();
							flowThread.gotoState(state110, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 389, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 387, 57));
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
			// Line: 394
			try {
				EXECUTION: {
					int count = getCount(1924091592) + 1;
					incrCount(1924091592);
					iristk.situated.SystemAgentFlow.prompt state111 = agent.new prompt();
					StringCreator string112 = new StringCreator();
					string112.append("Which room do you live in?");
					state111.setText(string112.toString());
					if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 394, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 394, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 397
			try {
				count = getCount(1543852136) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1543852136);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 398
						String sss = event.get("text").toString();
						// Line: 399
						if (eq("Sorry",info.callroom(sss))) {
							iristk.situated.SystemAgentFlow.say state113 = agent.new say();
							StringCreator string114 = new StringCreator();
							string114.append("Sorry, I didn't get that.");
							state113.setText(string114.toString());
							if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 399, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 401
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 401, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 402
						} else {
							iristk.situated.SystemAgentFlow.say state115 = agent.new say();
							state115.setText(info.callroom(sss));
							if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 399, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 404
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 405
							roomconfirm state116 = new roomconfirm();
							flowThread.gotoState(state116, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 405, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 397, 36));
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
			// Line: 411
			try {
				EXECUTION: {
					int count = getCount(1939255063) + 1;
					incrCount(1939255063);
					iristk.situated.SystemAgentFlow.listen state117 = agent.new listen();
					if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 411, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 411, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 414
			try {
				count = getCount(2076704485) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2076704485);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 415
							call.remove("room");
							// Line: 416
							callroom state118 = new callroom();
							flowThread.gotoState(state118, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 416, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 414, 57));
			}
			// Line: 418
			try {
				count = getCount(26241706) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(26241706);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 419
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 422
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 423
							CheckAgain state119 = new CheckAgain();
							flowThread.gotoState(state119, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 423, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 418, 58));
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
			// Line: 431
			try {
				EXECUTION: {
					int count = getCount(1977786067) + 1;
					incrCount(1977786067);
					iristk.situated.SystemAgentFlow.prompt state120 = agent.new prompt();
					StringCreator string121 = new StringCreator();
					string121.append("Do you need other help?");
					state120.setText(string121.toString());
					if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 431, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 431, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 434
			try {
				count = getCount(1095588950) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1095588950);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state122 = agent.new say();
							StringCreator string123 = new StringCreator();
							string123.append("Okay");
							state122.setText(string123.toString());
							if (!flowThread.callState(state122, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 434, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 436
							Start state124 = new Start();
							flowThread.gotoState(state124, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 436, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 434, 58));
			}
			// Line: 438
			try {
				count = getCount(2094877528) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2094877528);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state125 = agent.new say();
							StringCreator string126 = new StringCreator();
							string126.append("Okay");
							state125.setText(string126.toString());
							if (!flowThread.callState(state125, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 438, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 440
							Goodbye state127 = new Goodbye();
							flowThread.gotoState(state127, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 440, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 438, 57));
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
			// Line: 445
			try {
				count = getCount(1308061341) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1308061341);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state128 = agent.new gesture();
							state128.setName("smile");
							if (!flowThread.callState(state128, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 445, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 445, 102));
			}
			// Line: 448
			try {
				count = getCount(1533438960) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1533438960);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state129 = agent.new say();
						StringCreator string130 = new StringCreator();
						string130.append("Sorry, I didn't get that.");
						state129.setText(string130.toString());
						if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 448, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 450
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 450, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 448, 36));
			}
			// Line: 452
			try {
				count = getCount(1391156415) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:exit")) {
						incrCount(1391156415);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 453
							Greeting state131 = new Greeting();
							flowThread.gotoState(state131, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 453, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 452, 59));
			}
			// Line: 455
			try {
				count = getCount(1288672625) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1288672625);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state132 = agent.new say();
						StringCreator string133 = new StringCreator();
						string133.append("Sorry, I didn't hear anything.");
						state132.setText(string133.toString());
						if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 455, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 457
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 457, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 455, 38));
			}
			// Line: 459
			try {
				count = getCount(1284702835) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1284702835);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state134 = agent.new say();
							StringCreator string135 = new StringCreator();
							string135.append("Goodbye");
							state134.setText(string135.toString());
							if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 459, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 465
							Idle state136 = new Idle();
							flowThread.gotoState(state136, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 465, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 459, 69));
			}
			// Line: 468
			try {
				count = getCount(705751991) + 1;
				if (event.triggers("repeat")) {
					incrCount(705751991);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 469
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 469, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 468, 26));
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
			// Line: 481
			try {
				EXECUTION: {
					int count = getCount(701095174) + 1;
					incrCount(701095174);
					iristk.situated.SystemAgentFlow.prompt state137 = agent.new prompt();
					StringCreator string138 = new StringCreator();
					string138.append("请问有什么可以帮到您的？");
					state137.setText(string138.toString());
					if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 481, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 481, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 489
			try {
				count = getCount(69850843) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(69850843);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 490
						String s = event.get("text").toString();
						// Line: 491
						int value2=mandarin.attraction(s);
						// Line: 492
						int value3=mandarin.nature(s);
						// Line: 493
						int value4=mandarin.history(s);
						// Line: 494
						int value5=mandarin.popular(s);
						// Line: 495
						int value6 = mandarin.transportation(s);
						// Line: 496
						int value7 = mandarin.room(s);
						// Line: 497
						int value8 = mandarin.weather(s);
						// Line: 498
						int value9 = mandarin.morningcall(s);
						// Line: 499
						int value10 = mandarin.no(s);
						// Line: 501
						if (value3==3) {
							// Line: 502
							Nature_CN state139 = new Nature_CN();
							flowThread.gotoState(state139, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 502, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 503
						} else if (value4==4) {
							// Line: 504
							History_CN state140 = new History_CN();
							flowThread.gotoState(state140, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 504, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 505
						} else if (value5==5) {
							// Line: 506
							Popular_CN state141 = new Popular_CN();
							flowThread.gotoState(state141, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 506, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 507
						} else if (value2==2) {
							// Line: 508
							QueryAttr_CN state142 = new QueryAttr_CN();
							flowThread.gotoState(state142, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 508, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 509
						} else if (value6==2) {
							// Line: 510
							String attrname = mandarin.attrname(s);
							// Line: 511
							if (!attrname.equals("a")) {
								iristk.situated.SystemAgentFlow.say state143 = agent.new say();
								state143.setText(info.transdetail_CN(info.readtrans(),attrname));
								if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 511, 38)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 513
								CheckAgain_CN state144 = new CheckAgain_CN();
								flowThread.gotoState(state144, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 513, 37)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 514
							} else {
								// Line: 515
								QueryTrans_CN state145 = new QueryTrans_CN();
								flowThread.gotoState(state145, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 515, 37)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 517
						} else if (value7==2) {
							// Line: 518
							QueryRoom_CN state146 = new QueryRoom_CN();
							flowThread.gotoState(state146, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 518, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 519
						} else if (value8==2) {
							// Line: 520
							QueryWeather_CN state147 = new QueryWeather_CN();
							flowThread.gotoState(state147, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 520, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 521
						} else if (value9==2) {
							// Line: 522
							MorningCall_CN state148 = new MorningCall_CN();
							flowThread.gotoState(state148, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 522, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 523
						} else if (value10==88) {
							iristk.situated.SystemAgentFlow.say state149 = agent.new say();
							StringCreator string150 = new StringCreator();
							string150.append("好的");
							state149.setText(string150.toString());
							if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 501, 25)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 525
							Goodbye_CN state151 = new Goodbye_CN();
							flowThread.gotoState(state151, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 525, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 526
						} else {
							iristk.situated.SystemAgentFlow.say state152 = agent.new say();
							StringCreator string153 = new StringCreator();
							string153.append("抱歉，我没有理解您说的话。");
							state152.setText(string153.toString());
							if (!flowThread.callState(state152, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 501, 25)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 528
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 528, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 489, 36));
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
			// Line: 535
			try {
				EXECUTION: {
					int count = getCount(343631014) + 1;
					incrCount(343631014);
					iristk.situated.SystemAgentFlow.say state154 = agent.new say();
					StringCreator string155 = new StringCreator();
					string155.append("再见。");
					state154.setText(string155.toString());
					if (!flowThread.callState(state154, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 535, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state156 = agent.new say();
					StringCreator string157 = new StringCreator();
					string157.append("请离开感应区域");
					state156.setText(string157.toString());
					if (!flowThread.callState(state156, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 535, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 538
					iristk.flow.DialogFlow.wait waitState158 = new iristk.flow.DialogFlow.wait();
					waitState158.setMsec(2000);
					if (!flowThread.callState(waitState158, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 538, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 539
					Idle state159 = new Idle();
					flowThread.gotoState(state159, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 539, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 535, 12));
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
			// Line: 546
			try {
				EXECUTION: {
					int count = getCount(1467815318) + 1;
					incrCount(1467815318);
					iristk.situated.SystemAgentFlow.prompt state160 = agent.new prompt();
					StringCreator string161 = new StringCreator();
					string161.append("您想参观哪种景点？自然景点，历史景点还是热门景点？");
					state160.setText(string161.toString());
					if (!flowThread.callState(state160, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 546, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 546, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 551
			try {
				count = getCount(172072745) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(172072745);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 552
						String s = event.get("text").toString();
						// Line: 554
						int value3=mandarin.nature(s);
						// Line: 555
						int value4=mandarin.history(s);
						// Line: 556
						int value5=mandarin.popular(s);
						// Line: 557
						if (value3==3) {
							// Line: 558
							Nature_CN state162 = new Nature_CN();
							flowThread.gotoState(state162, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 558, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 559
						} else if (value4==4) {
							// Line: 560
							History_CN state163 = new History_CN();
							flowThread.gotoState(state163, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 560, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 561
						} else if (value5==5) {
							// Line: 562
							Popular_CN state164 = new Popular_CN();
							flowThread.gotoState(state164, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 562, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 563
						} else {
							iristk.situated.SystemAgentFlow.say state165 = agent.new say();
							StringCreator string166 = new StringCreator();
							string166.append("抱歉，我没有理解您说的话。");
							state165.setText(string166.toString());
							if (!flowThread.callState(state165, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 557, 25)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 565
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 565, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 551, 38));
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
			// Line: 571
			try {
				EXECUTION: {
					int count = getCount(1161387961) + 1;
					incrCount(1161387961);
					iristk.situated.SystemAgentFlow.say state167 = agent.new say();
					state167.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state167, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 571, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 573
					Attrdetial_CN state168 = new Attrdetial_CN();
					flowThread.gotoState(state168, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 573, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 571, 16));
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
			// Line: 578
			try {
				EXECUTION: {
					int count = getCount(1184655500) + 1;
					incrCount(1184655500);
					iristk.situated.SystemAgentFlow.say state169 = agent.new say();
					state169.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state169, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 578, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 580
					Attrdetial_CN state170 = new Attrdetial_CN();
					flowThread.gotoState(state170, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 580, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 578, 16));
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
			// Line: 585
			try {
				EXECUTION: {
					int count = getCount(136077699) + 1;
					incrCount(136077699);
					iristk.situated.SystemAgentFlow.say state171 = agent.new say();
					state171.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state171, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 585, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 587
					Attrdetial_CN state172 = new Attrdetial_CN();
					flowThread.gotoState(state172, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 587, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 585, 16));
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
			// Line: 592
			try {
				EXECUTION: {
					int count = getCount(433276939) + 1;
					incrCount(433276939);
					iristk.situated.SystemAgentFlow.prompt state173 = agent.new prompt();
					StringCreator string174 = new StringCreator();
					string174.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state173.setText(string174.toString());
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 592, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 592, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 595
			try {
				count = getCount(1915237067) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1915237067);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 596
						String s = event.get("text").toString();
						// Line: 597
						String attrname = mandarin.attrname(s); attrnamepassstring = attrname;
						// Line: 598
						if (!attrname.equals("a")) {
							iristk.situated.SystemAgentFlow.say state175 = agent.new say();
							state175.setText(info.detail_CN(info.readattr(),attrname));
							if (!flowThread.callState(state175, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 598, 41)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 600
							Attrtrans_CN state176 = new Attrtrans_CN();
							flowThread.gotoState(state176, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 600, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 601
						} else {
							iristk.situated.SystemAgentFlow.say state177 = agent.new say();
							StringCreator string178 = new StringCreator();
							string178.append("抱歉，我没有理解您说的话。");
							state177.setText(string178.toString());
							if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 598, 41)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 603
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 603, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 595, 42));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Attrtrans_CN extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 609
			try {
				EXECUTION: {
					int count = getCount(1469036946) + 1;
					incrCount(1469036946);
					iristk.situated.SystemAgentFlow.say state179 = agent.new say();
					StringCreator string180 = new StringCreator();
					string180.append("您想知道怎么去那里吗?");
					state179.setText(string180.toString());
					if (!flowThread.callState(state179, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 609, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state181 = agent.new listen();
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 609, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 609, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 613
			try {
				count = getCount(445031848) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(445031848);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 614
						String s = event.get("text").toString();
						// Line: 615
						int value = mandarin.yesno(s);
						// Line: 616
						if (value==66) {
							iristk.situated.SystemAgentFlow.say state182 = agent.new say();
							state182.setText(info.transdetail_CN(info.readtrans(),attrnamepassstring));
							if (!flowThread.callState(state182, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 616, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 618
							CheckAgain_CN state183 = new CheckAgain_CN();
							flowThread.gotoState(state183, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 618, 40)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 619
						} else if (value==88) {
							iristk.situated.SystemAgentFlow.say state184 = agent.new say();
							StringCreator string185 = new StringCreator();
							string185.append("好的");
							state184.setText(string185.toString());
							if (!flowThread.callState(state184, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 616, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 621
							CheckAgain_CN state186 = new CheckAgain_CN();
							flowThread.gotoState(state186, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 621, 40)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 622
						} else {
							iristk.situated.SystemAgentFlow.say state187 = agent.new say();
							StringCreator string188 = new StringCreator();
							string188.append("抱歉，我没有理解您说的话。");
							state187.setText(string188.toString());
							if (!flowThread.callState(state187, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 616, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 624
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 624, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 613, 40));
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
			// Line: 631
			try {
				EXECUTION: {
					int count = getCount(1254102106) + 1;
					incrCount(1254102106);
					iristk.situated.SystemAgentFlow.prompt state189 = agent.new prompt();
					StringCreator string190 = new StringCreator();
					string190.append("您打算去哪里？");
					state189.setText(string190.toString());
					if (!flowThread.callState(state189, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 631, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 631, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 634
			try {
				count = getCount(2105787061) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(2105787061);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 635
						String s = event.get("text").toString();
						// Line: 636
						String attrname = mandarin.attrname(s);
						// Line: 637
						if (!attrname.equals("a")) {
							iristk.situated.SystemAgentFlow.say state191 = agent.new say();
							state191.setText(info.transdetail_CN(info.readtrans(),attrname));
							if (!flowThread.callState(state191, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 37)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 639
							CheckAgain_CN state192 = new CheckAgain_CN();
							flowThread.gotoState(state192, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 639, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 640
						} else {
							iristk.situated.SystemAgentFlow.say state193 = agent.new say();
							StringCreator string194 = new StringCreator();
							string194.append("抱歉，我没有理解您说的话。");
							state193.setText(string194.toString());
							if (!flowThread.callState(state193, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 37)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 642
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 642, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 634, 36));
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
			// Line: 649
			try {
				EXECUTION: {
					int count = getCount(1537593713) + 1;
					incrCount(1537593713);
					iristk.situated.SystemAgentFlow.prompt state195 = agent.new prompt();
					StringCreator string196 = new StringCreator();
					string196.append("您在找哪个房间？");
					state195.setText(string196.toString());
					if (!flowThread.callState(state195, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 649, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 649, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 652
			try {
				count = getCount(1558822524) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1558822524);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 653
						String ss = event.get("text").toString();
						// Line: 654
						if (eq("Sorry",info.findroom_CN(ss))) {
							iristk.situated.SystemAgentFlow.say state197 = agent.new say();
							StringCreator string198 = new StringCreator();
							string198.append("抱歉，我没有理解您说的话。");
							state197.setText(string198.toString());
							if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 654, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 656
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 656, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 657
						} else {
							iristk.situated.SystemAgentFlow.say state199 = agent.new say();
							state199.setText(info.findroom_CN(ss));
							if (!flowThread.callState(state199, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 654, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 659
							CheckAgain_CN state200 = new CheckAgain_CN();
							flowThread.gotoState(state200, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 659, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 652, 42));
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
			// Line: 666
			try {
				EXECUTION: {
					int count = getCount(948143013) + 1;
					incrCount(948143013);
					iristk.situated.SystemAgentFlow.say state201 = agent.new say();
					state201.setText(weather.getweather_CN());
					if (!flowThread.callState(state201, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 666, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 668
					CheckAgain_CN state202 = new CheckAgain_CN();
					flowThread.gotoState(state202, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 668, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 666, 12));
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
			// Line: 673
			try {
				EXECUTION: {
					int count = getCount(1034861337) + 1;
					incrCount(1034861337);
					// Line: 674
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state203 = agent.new prompt();
					StringCreator string204 = new StringCreator();
					string204.append("您需要几点叫您？");
					state203.setText(string204.toString());
					if (!flowThread.callState(state203, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 673, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 673, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 677
			try {
				count = getCount(1966858904) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1966858904);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 678
						String s = event.get("text").toString();
						// Line: 679
						int hour = mandarin.number(s);
						// Line: 680
						int value2 = mandarin.clock(s);
						// Line: 681
						int value3 = mandarin.half(s);
						// Line: 682
						String apm = mandarin.apm(s);
						// Line: 683
						String date = mandarin.calldate(s);
						// Line: 686
						if (100 > hour && value2==2) {
							// Line: 687
							call.putIfNotNull("minute", 0);
							// Line: 688
							if ( hour > 24 ) {
								iristk.situated.SystemAgentFlow.say state205 = agent.new say();
								StringCreator string206 = new StringCreator();
								string206.append("对不起这是无效的时间。");
								state205.setText(string206.toString());
								if (!flowThread.callState(state205, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 688, 31)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 690
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 690, 16)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 691
							} else if (hour > 12) {
								// Line: 692
								call.putIfNotNull("hour", hour);call.putIfNotNull("apm", "a.m.");
								// Line: 693
							} else {
								// Line: 694
								call.putIfNotNull("hour", hour);
								// Line: 695
								if (!apm.equals("b")) {
									// Line: 696
									call.putIfNotNull("apm", apm);
								}
							}
							// Line: 699
							if (!date.equals("c")) {
								// Line: 700
								call.putIfNotNull("date", date);
							}
							// Line: 702
							checkcall_CN state207 = new checkcall_CN();
							flowThread.gotoState(state207, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 702, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 705
						if (100 > hour && value3==2) {
							// Line: 706
							call.putIfNotNull("minute", 30);
							// Line: 707
							if ( hour > 23 ) {
								iristk.situated.SystemAgentFlow.say state208 = agent.new say();
								StringCreator string209 = new StringCreator();
								string209.append("对不起这是无效的时间。");
								state208.setText(string209.toString());
								if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 707, 31)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 709
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 709, 16)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 710
							} else if (hour > 12) {
								// Line: 711
								call.putIfNotNull("hour", hour);call.putIfNotNull("apm", "a.m.");
								// Line: 712
							} else {
								// Line: 713
								call.putIfNotNull("hour", hour);
								// Line: 714
								if (!apm.equals("b")) {
									// Line: 715
									call.putIfNotNull("apm", apm);
								}
							}
							// Line: 718
							if (!date.equals("c")) {
								// Line: 719
								call.putIfNotNull("date", date);
							}
							// Line: 721
							checkcall_CN state210 = new checkcall_CN();
							flowThread.gotoState(state210, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 721, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 724
						if (hour != 111) {
							// Line: 725
							checkcall_CN state211 = new checkcall_CN();
							flowThread.gotoState(state211, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 725, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 726
						} else {
							iristk.situated.SystemAgentFlow.say state212 = agent.new say();
							StringCreator string213 = new StringCreator();
							string213.append("抱歉，我没有理解您说的话。");
							state212.setText(string213.toString());
							if (!flowThread.callState(state212, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 724, 27)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 728
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 728, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 677, 36));
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
			// Line: 734
			try {
				EXECUTION: {
					int count = getCount(1138507954) + 1;
					incrCount(1138507954);
					// Line: 735
					if (!call.has("hour")) {
						// Line: 736
						askhour_CN state214 = new askhour_CN();
						flowThread.gotoState(state214, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 736, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 737
					} else if (!call.has("minute")) {
						// Line: 738
						askminute_CN state215 = new askminute_CN();
						flowThread.gotoState(state215, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 738, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 739
					} else if (!call.has("apm")) {
						// Line: 740
						askapm_CN state216 = new askapm_CN();
						flowThread.gotoState(state216, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 740, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 741
					} else if (!call.has("date")) {
						// Line: 742
						askdate_CN state217 = new askdate_CN();
						flowThread.gotoState(state217, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 742, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 743
					} else {
						// Line: 744
						calldone_CN state218 = new calldone_CN();
						flowThread.gotoState(state218, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 744, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 734, 12));
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
			// Line: 750
			try {
				EXECUTION: {
					int count = getCount(924188019) + 1;
					incrCount(924188019);
					iristk.situated.SystemAgentFlow.prompt state219 = agent.new prompt();
					StringCreator string220 = new StringCreator();
					string220.append("请设置小时数。");
					state219.setText(string220.toString());
					if (!flowThread.callState(state219, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 750, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 750, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 753
			try {
				count = getCount(2060511023) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(2060511023);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 754
						String s = event.get("text").toString();
						// Line: 755
						int hour = mandarin.number(s);
						// Line: 756
						if (hour == 111) {
							iristk.situated.SystemAgentFlow.say state221 = agent.new say();
							StringCreator string222 = new StringCreator();
							string222.append("抱歉，我没有理解您说的话。");
							state221.setText(string222.toString());
							if (!flowThread.callState(state221, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 756, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 758
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 758, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 760
						if ( hour > 24 ) {
							iristk.situated.SystemAgentFlow.say state223 = agent.new say();
							StringCreator string224 = new StringCreator();
							string224.append("对不起这是无效的时间。");
							state223.setText(string224.toString());
							if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 760, 30)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 762
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 762, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 763
						} else if ( hour > 12 ) {
							// Line: 764
							call.putIfNotNull("hour", hour); call.putIfNotNull("apm", "a.m.");
							// Line: 765
							checkcall_CN state225 = new checkcall_CN();
							flowThread.gotoState(state225, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 765, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 766
						} else {
							// Line: 767
							call.putIfNotNull("hour", hour);
							// Line: 768
							checkcall_CN state226 = new checkcall_CN();
							flowThread.gotoState(state226, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 768, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 753, 36));
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
			// Line: 775
			try {
				EXECUTION: {
					int count = getCount(637648478) + 1;
					incrCount(637648478);
					iristk.situated.SystemAgentFlow.prompt state227 = agent.new prompt();
					StringCreator string228 = new StringCreator();
					string228.append("请设置分钟数。");
					state227.setText(string228.toString());
					if (!flowThread.callState(state227, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 775, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 775, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 778
			try {
				count = getCount(1058906172) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1058906172);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 779
						String s = event.get("text").toString();
						// Line: 780
						int min = mandarin.number(s);
						// Line: 781
						if (min == 111) {
							iristk.situated.SystemAgentFlow.say state229 = agent.new say();
							StringCreator string230 = new StringCreator();
							string230.append("抱歉，我没有理解您说的话。");
							state229.setText(string230.toString());
							if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 781, 26)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 783
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 783, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 784
						} else if (min==99) {
							iristk.situated.SystemAgentFlow.say state231 = agent.new say();
							StringCreator string232 = new StringCreator();
							string232.append("对不起这是无效的时间。");
							state231.setText(string232.toString());
							if (!flowThread.callState(state231, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 781, 26)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 786
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 786, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 787
						} else {
							// Line: 788
							call.putIfNotNull("minute", min);
							// Line: 789
							checkcall_CN state233 = new checkcall_CN();
							flowThread.gotoState(state233, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 789, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 778, 36));
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
			// Line: 795
			try {
				EXECUTION: {
					int count = getCount(1463743499) + 1;
					incrCount(1463743499);
					iristk.situated.SystemAgentFlow.prompt state234 = agent.new prompt();
					StringCreator string235 = new StringCreator();
					string235.append("请问是上午还是下午?");
					state234.setText(string235.toString());
					if (!flowThread.callState(state234, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 795, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 795, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 798
			try {
				count = getCount(309461326) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(309461326);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 799
						String s = event.get("text").toString();
						// Line: 800
						String apm = mandarin.apm(s);
						// Line: 801
						if (apm.equals("b")) {
							iristk.situated.SystemAgentFlow.say state236 = agent.new say();
							StringCreator string237 = new StringCreator();
							string237.append("抱歉，我没有理解您说的话。");
							state236.setText(string237.toString());
							if (!flowThread.callState(state236, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 801, 31)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 803
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 803, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 804
						} else {
							// Line: 805
							call.putIfNotNull("apm", apm);
							// Line: 806
							checkcall_CN state238 = new checkcall_CN();
							flowThread.gotoState(state238, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 806, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 798, 36));
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
			// Line: 812
			try {
				EXECUTION: {
					int count = getCount(238043176) + 1;
					incrCount(238043176);
					iristk.situated.SystemAgentFlow.prompt state239 = agent.new prompt();
					StringCreator string240 = new StringCreator();
					string240.append("请问是今天还是明天？");
					state239.setText(string240.toString());
					if (!flowThread.callState(state239, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 812, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 812, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 815
			try {
				count = getCount(954211785) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(954211785);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 816
						String s = event.get("text").toString();
						// Line: 817
						String date = mandarin.calldate(s);
						// Line: 818
						if (date.equals("c")) {
							iristk.situated.SystemAgentFlow.say state241 = agent.new say();
							StringCreator string242 = new StringCreator();
							string242.append("抱歉，我没有理解您说的话。");
							state241.setText(string242.toString());
							if (!flowThread.callState(state241, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 818, 32)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 820
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 820, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 821
						} else {
							// Line: 822
							call.putIfNotNull("date", date);
							// Line: 823
							checkcall_CN state243 = new checkcall_CN();
							flowThread.gotoState(state243, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 823, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 815, 37));
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
			// Line: 829
			try {
				EXECUTION: {
					int count = getCount(1407703235) + 1;
					incrCount(1407703235);
					// Line: 830
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state244 = agent.new prompt();
					state244.setText(info.timeconfirm_CN(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state244, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 829, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 829, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 834
			try {
				count = getCount(1006265013) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1006265013);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 835
						String s = event.get("text").toString();
						// Line: 836
						int value = mandarin.yesno(s);
						// Line: 837
						if (value==66) {
							// Line: 838
							callroom_CN state245 = new callroom_CN();
							flowThread.gotoState(state245, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 838, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 839
						} else if (value==88) {
							// Line: 840
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 841
							MorningCall_CN state246 = new MorningCall_CN();
							flowThread.gotoState(state246, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 841, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 842
						} else {
							iristk.situated.SystemAgentFlow.say state247 = agent.new say();
							StringCreator string248 = new StringCreator();
							string248.append("抱歉，我没有理解您说的话。");
							state247.setText(string248.toString());
							if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 837, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 844
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 844, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 834, 36));
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
			// Line: 851
			try {
				EXECUTION: {
					int count = getCount(1488150447) + 1;
					incrCount(1488150447);
					iristk.situated.SystemAgentFlow.prompt state249 = agent.new prompt();
					StringCreator string250 = new StringCreator();
					string250.append("请问您的房间号是多少？");
					state249.setText(string250.toString());
					if (!flowThread.callState(state249, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 851, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 851, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 854
			try {
				count = getCount(1783305789) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1783305789);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 855
						String sss = event.get("text").toString();
						// Line: 856
						if (eq("Sorry",info.callroom_CN(sss))) {
							iristk.situated.SystemAgentFlow.say state251 = agent.new say();
							StringCreator string252 = new StringCreator();
							string252.append("抱歉，我没有理解您说的话。");
							state251.setText(string252.toString());
							if (!flowThread.callState(state251, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 856, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 858
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 858, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 859
						} else {
							iristk.situated.SystemAgentFlow.say state253 = agent.new say();
							state253.setText(info.callroom_CN(sss));
							if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 856, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 861
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 862
							roomconfirm_CN state254 = new roomconfirm_CN();
							flowThread.gotoState(state254, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 862, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 854, 36));
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
			// Line: 868
			try {
				EXECUTION: {
					int count = getCount(162295599) + 1;
					incrCount(162295599);
					iristk.situated.SystemAgentFlow.listen state255 = agent.new listen();
					if (!flowThread.callState(state255, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 868, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 868, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 871
			try {
				count = getCount(1818910787) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1818910787);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 872
						String s = event.get("text").toString();
						// Line: 873
						int value = mandarin.yesno(s);
						// Line: 874
						if (value==66) {
							// Line: 875
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 878
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 879
							CheckAgain_CN state256 = new CheckAgain_CN();
							flowThread.gotoState(state256, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 879, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 880
						} else if (value==88) {
							// Line: 881
							call.remove("room");
							// Line: 882
							callroom_CN state257 = new callroom_CN();
							flowThread.gotoState(state257, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 882, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 883
						} else {
							iristk.situated.SystemAgentFlow.say state258 = agent.new say();
							StringCreator string259 = new StringCreator();
							string259.append("抱歉，我没有理解您说的话。");
							state258.setText(string259.toString());
							if (!flowThread.callState(state258, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 874, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 885
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 885, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 871, 36));
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
			// Line: 895
			try {
				EXECUTION: {
					int count = getCount(585814796) + 1;
					incrCount(585814796);
					iristk.situated.SystemAgentFlow.prompt state260 = agent.new prompt();
					StringCreator string261 = new StringCreator();
					string261.append("您还需要其他帮助吗？");
					state260.setText(string261.toString());
					if (!flowThread.callState(state260, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 895, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 895, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 898
			try {
				count = getCount(218140514) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(218140514);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 899
						String s = event.get("text").toString();
						// Line: 900
						int value = mandarin.yesno(s);
						// Line: 901
						if (value==66) {
							iristk.situated.SystemAgentFlow.say state262 = agent.new say();
							StringCreator string263 = new StringCreator();
							string263.append("好的");
							state262.setText(string263.toString());
							if (!flowThread.callState(state262, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 901, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 903
							Start_CN state264 = new Start_CN();
							flowThread.gotoState(state264, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 903, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 904
						} else if (value==88) {
							iristk.situated.SystemAgentFlow.say state265 = agent.new say();
							StringCreator string266 = new StringCreator();
							string266.append("好的");
							state265.setText(string266.toString());
							if (!flowThread.callState(state265, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 901, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 906
							Goodbye_CN state267 = new Goodbye_CN();
							flowThread.gotoState(state267, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 906, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 907
						} else {
							iristk.situated.SystemAgentFlow.say state268 = agent.new say();
							StringCreator string269 = new StringCreator();
							string269.append("抱歉，我没有理解您说的话。");
							state268.setText(string269.toString());
							if (!flowThread.callState(state268, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 901, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 909
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 909, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 898, 36));
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
			// Line: 915
			try {
				count = getCount(1952270955) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1952270955);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state270 = agent.new gesture();
							state270.setName("smile");
							if (!flowThread.callState(state270, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 915, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 915, 102));
			}
			// Line: 918
			try {
				count = getCount(999676709) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(999676709);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state271 = agent.new say();
						StringCreator string272 = new StringCreator();
						string272.append("抱歉，我没有理解您说的话。");
						state271.setText(string272.toString());
						if (!flowThread.callState(state271, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 918, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 920
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 920, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 918, 36));
			}
			// Line: 922
			try {
				count = getCount(74767529) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(74767529);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state273 = agent.new attendOther();
						state273.setMode("eyes");
						if (!flowThread.callState(state273, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 922, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state274 = agent.new say();
						StringCreator string275 = new StringCreator();
						string275.append("对不起，我现在没有问您。");
						state274.setText(string275.toString());
						if (!flowThread.callState(state274, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 922, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state276 = agent.new attendOther();
						state276.setMode("eyes");
						if (!flowThread.callState(state276, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 922, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 926
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 926, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 922, 41));
			}
			// Line: 928
			try {
				count = getCount(255687876) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(255687876);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state277 = agent.new say();
						StringCreator string278 = new StringCreator();
						string278.append("请不要同时说话。");
						state277.setText(string278.toString());
						if (!flowThread.callState(state277, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 928, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 930
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 930, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 928, 42));
			}
			// Line: 932
			try {
				count = getCount(1872158653) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1872158653);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state279 = agent.new say();
						StringCreator string280 = new StringCreator();
						string280.append("抱歉，我没有听到任何话。");
						state279.setText(string280.toString());
						if (!flowThread.callState(state279, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 932, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 934
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 934, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 932, 38));
			}
			// Line: 936
			try {
				count = getCount(930318800) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(930318800);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state281 = agent.new say();
							StringCreator string282 = new StringCreator();
							string282.append("再见。");
							state281.setText(string282.toString());
							if (!flowThread.callState(state281, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 936, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 938
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state283 = agent.new attendRandom();
								if (!flowThread.callState(state283, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 938, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 940
								Start_CN state284 = new Start_CN();
								flowThread.gotoState(state284, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 940, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 941
							} else {
								// Line: 942
								Idle state285 = new Idle();
								flowThread.gotoState(state285, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 942, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 936, 69));
			}
			// Line: 945
			try {
				count = getCount(659547186) + 1;
				if (event.triggers("repeat")) {
					incrCount(659547186);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 946
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 946, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 945, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
