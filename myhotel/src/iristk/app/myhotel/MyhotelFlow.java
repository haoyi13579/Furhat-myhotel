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
					int count = getCount(550337732) + 1;
					incrCount(550337732);
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
				count = getCount(336738016) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(336738016);
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
					int count = getCount(700900704) + 1;
					incrCount(700900704);
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
				count = getCount(1922281053) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:english")) {
						incrCount(1922281053);
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
				count = getCount(1880549408) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1880549408);
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
					int count = getCount(1404035790) + 1;
					incrCount(1404035790);
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
				count = getCount(815665406) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(815665406);
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
				count = getCount(1051902726) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1051902726);
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
				count = getCount(1267497340) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(1267497340);
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
				count = getCount(423935999) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(423935999);
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
				count = getCount(973152050) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(973152050);
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
				count = getCount(229971894) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(229971894);
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
					int count = getCount(2106876024) + 1;
					incrCount(2106876024);
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
					int count = getCount(1729053261) + 1;
					incrCount(1729053261);
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
				count = getCount(1898375535) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(1898375535);
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
				count = getCount(1383936445) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(1383936445);
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
				count = getCount(165083524) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(165083524);
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
				count = getCount(1297806469) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1297806469);
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
					int count = getCount(749786990) + 1;
					incrCount(749786990);
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
					int count = getCount(773356387) + 1;
					incrCount(773356387);
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
					int count = getCount(719850766) + 1;
					incrCount(719850766);
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
					int count = getCount(1398564360) + 1;
					incrCount(1398564360);
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
				count = getCount(959873296) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(959873296);
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
					int count = getCount(28241320) + 1;
					incrCount(28241320);
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
				count = getCount(959626847) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(959626847);
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
				count = getCount(757826023) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(757826023);
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
					int count = getCount(535850524) + 1;
					incrCount(535850524);
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
				count = getCount(1847980220) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1847980220);
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
					int count = getCount(980821448) + 1;
					incrCount(980821448);
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
				count = getCount(2065142314) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(2065142314);
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
				count = getCount(1707429754) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1707429754);
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
					int count = getCount(1563930429) + 1;
					incrCount(1563930429);
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
					int count = getCount(386470009) + 1;
					incrCount(386470009);
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
				count = getCount(12862009) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") && event.has("sem:number")) {
						incrCount(12862009);
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
				count = getCount(1854273179) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(1854273179);
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
				count = getCount(937928782) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:noon")) {
						incrCount(937928782);
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
				count = getCount(1765276954) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:midnight")) {
						incrCount(1765276954);
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
				count = getCount(1939637186) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1939637186);
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
				count = getCount(1103220874) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1103220874);
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
					int count = getCount(1138778462) + 1;
					incrCount(1138778462);
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
					int count = getCount(1711276889) + 1;
					incrCount(1711276889);
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
				count = getCount(2135100117) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(2135100117);
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
					int count = getCount(1162230640) + 1;
					incrCount(1162230640);
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
				count = getCount(642752269) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(642752269);
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
					int count = getCount(1959711682) + 1;
					incrCount(1959711682);
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
				count = getCount(383734626) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(383734626);
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
					int count = getCount(1167978180) + 1;
					incrCount(1167978180);
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
				count = getCount(1343590544) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1343590544);
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
					int count = getCount(273591381) + 1;
					incrCount(273591381);
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
				count = getCount(994687208) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(994687208);
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
				count = getCount(735320042) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(735320042);
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
					int count = getCount(340178238) + 1;
					incrCount(340178238);
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
				count = getCount(1664560010) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1664560010);
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
					int count = getCount(2055427142) + 1;
					incrCount(2055427142);
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
				count = getCount(1332835233) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1332835233);
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
				count = getCount(500707282) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(500707282);
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
					int count = getCount(1085990947) + 1;
					incrCount(1085990947);
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
				count = getCount(335023601) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(335023601);
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
				count = getCount(520432680) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(520432680);
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
				count = getCount(619963740) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(619963740);
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
				count = getCount(312605062) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(312605062);
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
				count = getCount(1628304645) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:exit")) {
						incrCount(1628304645);
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
				count = getCount(1193249391) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1193249391);
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
				count = getCount(1358290764) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1358290764);
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
				count = getCount(1223027725) + 1;
				if (event.triggers("repeat")) {
					incrCount(1223027725);
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
					int count = getCount(2090277769) + 1;
					incrCount(2090277769);
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
				count = getCount(469042578) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(469042578);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 502
						String s = event.get("text").toString();
						// Line: 503
						int value2=mandarin.attraction(s);
						// Line: 504
						int value3=mandarin.nature(s);
						// Line: 505
						int value4=mandarin.history(s);
						// Line: 506
						int value5=mandarin.popular(s);
						// Line: 507
						int value6 = mandarin.transportation(s);
						// Line: 508
						int value7 = mandarin.room(s);
						// Line: 509
						int value8 = mandarin.weather(s);
						// Line: 510
						int value9 = mandarin.morningcall(s);
						// Line: 511
						int value10 = mandarin.no(s);
						// Line: 513
						if (value2==2) {
							// Line: 514
							QueryAttr_CN state141 = new QueryAttr_CN();
							flowThread.gotoState(state141, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 514, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 515
						} else if (value3==3) {
							// Line: 516
							Nature_CN state142 = new Nature_CN();
							flowThread.gotoState(state142, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 516, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 517
						} else if (value4==4) {
							// Line: 518
							History_CN state143 = new History_CN();
							flowThread.gotoState(state143, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 518, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 519
						} else if (value5==5) {
							// Line: 520
							Popular_CN state144 = new Popular_CN();
							flowThread.gotoState(state144, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 520, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 521
						} else if (value6==2) {
							// Line: 522
							String attrname = mandarin.attrname(s);
							// Line: 523
							if (!attrname.equals("a")) {
								iristk.situated.SystemAgentFlow.say state145 = agent.new say();
								state145.setText(info.transdetail_CN(info.readtrans(),attrname));
								if (!flowThread.callState(state145, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 523, 38)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 525
								CheckAgain_CN state146 = new CheckAgain_CN();
								flowThread.gotoState(state146, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 525, 37)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 526
							} else {
								// Line: 527
								QueryTrans_CN state147 = new QueryTrans_CN();
								flowThread.gotoState(state147, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 527, 37)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 529
						} else if (value7==2) {
							// Line: 530
							QueryRoom_CN state148 = new QueryRoom_CN();
							flowThread.gotoState(state148, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 530, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 531
						} else if (value8==2) {
							// Line: 532
							QueryWeather_CN state149 = new QueryWeather_CN();
							flowThread.gotoState(state149, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 532, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 533
						} else if (value9==2) {
							// Line: 534
							MorningCall_CN state150 = new MorningCall_CN();
							flowThread.gotoState(state150, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 534, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 535
						} else if (value10==88) {
							iristk.situated.SystemAgentFlow.say state151 = agent.new say();
							StringCreator string152 = new StringCreator();
							string152.append("好的");
							state151.setText(string152.toString());
							if (!flowThread.callState(state151, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 513, 25)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 537
							Goodbye_CN state153 = new Goodbye_CN();
							flowThread.gotoState(state153, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 537, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 538
						} else {
							iristk.situated.SystemAgentFlow.say state154 = agent.new say();
							StringCreator string155 = new StringCreator();
							string155.append("抱歉，我没有理解您说的话。");
							state154.setText(string155.toString());
							if (!flowThread.callState(state154, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 513, 25)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 540
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 540, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 501, 36));
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
			// Line: 595
			try {
				EXECUTION: {
					int count = getCount(1383235283) + 1;
					incrCount(1383235283);
					iristk.situated.SystemAgentFlow.say state156 = agent.new say();
					StringCreator string157 = new StringCreator();
					string157.append("再见。");
					state156.setText(string157.toString());
					if (!flowThread.callState(state156, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 595, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state158 = agent.new say();
					StringCreator string159 = new StringCreator();
					string159.append("请离开感应区域");
					state158.setText(string159.toString());
					if (!flowThread.callState(state158, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 595, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 598
					iristk.flow.DialogFlow.wait waitState160 = new iristk.flow.DialogFlow.wait();
					waitState160.setMsec(2000);
					if (!flowThread.callState(waitState160, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 598, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 599
					Idle state161 = new Idle();
					flowThread.gotoState(state161, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 599, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 595, 12));
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
			// Line: 606
			try {
				EXECUTION: {
					int count = getCount(910304655) + 1;
					incrCount(910304655);
					iristk.situated.SystemAgentFlow.prompt state162 = agent.new prompt();
					StringCreator string163 = new StringCreator();
					string163.append("您想参观哪种景点？自然景点，历史景点还是热门景点？");
					state162.setText(string163.toString());
					if (!flowThread.callState(state162, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 606, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 606, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 611
			try {
				count = getCount(1469751670) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1469751670);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 612
						String s = event.get("text").toString();
						// Line: 614
						int value3=mandarin.nature(s);
						// Line: 615
						int value4=mandarin.history(s);
						// Line: 616
						int value5=mandarin.popular(s);
						// Line: 617
						if (value3==3) {
							// Line: 618
							Nature_CN state164 = new Nature_CN();
							flowThread.gotoState(state164, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 618, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 619
						} else if (value4==4) {
							// Line: 620
							History_CN state165 = new History_CN();
							flowThread.gotoState(state165, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 621
						} else if (value5==5) {
							// Line: 622
							Popular_CN state166 = new Popular_CN();
							flowThread.gotoState(state166, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 622, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 623
						} else {
							iristk.situated.SystemAgentFlow.say state167 = agent.new say();
							StringCreator string168 = new StringCreator();
							string168.append("抱歉，我没有理解您说的话。");
							state167.setText(string168.toString());
							if (!flowThread.callState(state167, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 617, 25)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 611, 38));
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
			// Line: 630
			try {
				EXECUTION: {
					int count = getCount(1726295245) + 1;
					incrCount(1726295245);
					iristk.situated.SystemAgentFlow.say state169 = agent.new say();
					state169.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state169, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 630, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 632
					Attrdetial_CN state170 = new Attrdetial_CN();
					flowThread.gotoState(state170, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 632, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 630, 16));
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
			// Line: 637
			try {
				EXECUTION: {
					int count = getCount(2129193388) + 1;
					incrCount(2129193388);
					iristk.situated.SystemAgentFlow.say state171 = agent.new say();
					state171.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state171, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 639
					Attrdetial_CN state172 = new Attrdetial_CN();
					flowThread.gotoState(state172, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 639, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 16));
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
			// Line: 644
			try {
				EXECUTION: {
					int count = getCount(1337738067) + 1;
					incrCount(1337738067);
					iristk.situated.SystemAgentFlow.say state173 = agent.new say();
					state173.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 644, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 646
					Attrdetial_CN state174 = new Attrdetial_CN();
					flowThread.gotoState(state174, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 646, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 644, 16));
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
			// Line: 651
			try {
				EXECUTION: {
					int count = getCount(1705424885) + 1;
					incrCount(1705424885);
					iristk.situated.SystemAgentFlow.prompt state175 = agent.new prompt();
					StringCreator string176 = new StringCreator();
					string176.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state175.setText(string176.toString());
					if (!flowThread.callState(state175, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 651, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 651, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 654
			try {
				count = getCount(1210963657) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1210963657);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 655
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state177 = agent.new say();
							state177.setText(info.detail_CN(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 654, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 657
							CheckAgain_CN state178 = new CheckAgain_CN();
							flowThread.gotoState(state178, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 657, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 654, 69));
			}
			// Line: 659
			try {
				count = getCount(1379135409) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1379135409);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 660
							CheckAgain_CN state179 = new CheckAgain_CN();
							flowThread.gotoState(state179, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 660, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 659, 61));
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
			// Line: 666
			try {
				EXECUTION: {
					int count = getCount(2043955300) + 1;
					incrCount(2043955300);
					iristk.situated.SystemAgentFlow.prompt state180 = agent.new prompt();
					StringCreator string181 = new StringCreator();
					string181.append("您打算去哪里？");
					state180.setText(string181.toString());
					if (!flowThread.callState(state180, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 666, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 666, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 669
			try {
				count = getCount(878145160) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(878145160);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 670
						String s = event.get("text").toString();
						// Line: 671
						String attrname = mandarin.attrname(s);
						iristk.situated.SystemAgentFlow.say state182 = agent.new say();
						state182.setText(info.transdetail_CN(info.readtrans(),attrname));
						if (!flowThread.callState(state182, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 669, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 673
						CheckAgain_CN state183 = new CheckAgain_CN();
						flowThread.gotoState(state183, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 673, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 669, 36));
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
			// Line: 679
			try {
				EXECUTION: {
					int count = getCount(419621915) + 1;
					incrCount(419621915);
					iristk.situated.SystemAgentFlow.prompt state184 = agent.new prompt();
					StringCreator string185 = new StringCreator();
					string185.append("您在找哪个房间？");
					state184.setText(string185.toString());
					if (!flowThread.callState(state184, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 679, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 679, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 682
			try {
				count = getCount(2034553082) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(2034553082);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state186 = agent.new say();
							StringCreator string187 = new StringCreator();
							string187.append("它在一楼。");
							state186.setText(string187.toString());
							if (!flowThread.callState(state186, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 682, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 684
							CheckAgain_CN state188 = new CheckAgain_CN();
							flowThread.gotoState(state188, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 684, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 682, 70));
			}
			// Line: 686
			try {
				count = getCount(372724199) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(372724199);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 687
						String ss = event.get("text").toString();
						// Line: 688
						if (eq("Sorry",info.findroom_CN(ss))) {
							iristk.situated.SystemAgentFlow.say state189 = agent.new say();
							StringCreator string190 = new StringCreator();
							string190.append("抱歉，我没有理解您说的话。");
							state189.setText(string190.toString());
							if (!flowThread.callState(state189, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 688, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 690
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 690, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 691
						} else {
							iristk.situated.SystemAgentFlow.say state191 = agent.new say();
							state191.setText(info.findroom_CN(ss));
							if (!flowThread.callState(state191, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 688, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 693
							CheckAgain_CN state192 = new CheckAgain_CN();
							flowThread.gotoState(state192, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 693, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 686, 42));
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
			// Line: 700
			try {
				EXECUTION: {
					int count = getCount(571461518) + 1;
					incrCount(571461518);
					iristk.situated.SystemAgentFlow.say state193 = agent.new say();
					state193.setText(weather.getweather_CN());
					if (!flowThread.callState(state193, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 700, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 702
					CheckAgain_CN state194 = new CheckAgain_CN();
					flowThread.gotoState(state194, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 702, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 700, 12));
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
			// Line: 707
			try {
				EXECUTION: {
					int count = getCount(1797715879) + 1;
					incrCount(1797715879);
					// Line: 708
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state195 = agent.new prompt();
					StringCreator string196 = new StringCreator();
					string196.append("您需要几点叫您？");
					state195.setText(string196.toString());
					if (!flowThread.callState(state195, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 707, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 707, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 712
			try {
				count = getCount(2346594) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") || event.has("sem:number")) {
						incrCount(2346594);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 713
							call.putIfNotNull("minute", 0);
							// Line: 714
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 715
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state197 = agent.new say();
								StringCreator string198 = new StringCreator();
								string198.append("对不起这是无效的时间。");
								state197.setText(string198.toString());
								if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 715, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 717
							} else if (num > 12) {
								// Line: 718
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 720
							} else {
								// Line: 721
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 722
								if (event.has("sem:apm")) {
									// Line: 723
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 726
							if (event.has("sem:date")) {
								// Line: 727
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 729
							checkcall_CN state199 = new checkcall_CN();
							flowThread.gotoState(state199, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 729, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 712, 81));
			}
			// Line: 732
			try {
				count = getCount(844492896) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(844492896);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 733
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 734
							call.putIfNotNull("minute", 30);
							// Line: 735
							if (event.has("sem:past")) {
								// Line: 736
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state200 = agent.new say();
									StringCreator string201 = new StringCreator();
									string201.append("对不起这是无效的时间。");
									state200.setText(string201.toString());
									if (!flowThread.callState(state200, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 736, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 738
								} else if (num > 11) {
									// Line: 739
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 740
								} else {
									// Line: 741
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 742
									if (event.has("sem:apm")) {
										// Line: 743
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 746
								if (event.has("sem:date")) {
									// Line: 747
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 749
								checkcall_CN state202 = new checkcall_CN();
								flowThread.gotoState(state202, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 749, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 752
							if (event.has("sem:to")) {
								// Line: 753
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state203 = agent.new say();
									StringCreator string204 = new StringCreator();
									string204.append("对不起这是无效的时间。");
									state203.setText(string204.toString());
									if (!flowThread.callState(state203, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 753, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 755
								} else if (num > 12) {
									// Line: 756
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 757
								} else {
									// Line: 758
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 759
									if (event.has("sem:apm")) {
										// Line: 760
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 763
								if (event.has("sem:date")) {
									// Line: 764
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 766
								checkcall_CN state205 = new checkcall_CN();
								flowThread.gotoState(state205, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 766, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 732, 81));
			}
			// Line: 770
			try {
				count = getCount(986550348) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(986550348);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 771
							CheckAgain_CN state206 = new CheckAgain_CN();
							flowThread.gotoState(state206, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 771, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 770, 57));
			}
			// Line: 774
			try {
				count = getCount(946432040) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(946432040);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 775
							checkcall_CN state207 = new checkcall_CN();
							flowThread.gotoState(state207, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 775, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 774, 61));
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
			// Line: 781
			try {
				EXECUTION: {
					int count = getCount(1959787625) + 1;
					incrCount(1959787625);
					// Line: 782
					if (!call.has("hour")) {
						// Line: 783
						askhour_CN state208 = new askhour_CN();
						flowThread.gotoState(state208, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 783, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 784
					} else if (!call.has("minute")) {
						// Line: 785
						askminute_CN state209 = new askminute_CN();
						flowThread.gotoState(state209, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 785, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 786
					} else if (!call.has("apm")) {
						// Line: 787
						askapm_CN state210 = new askapm_CN();
						flowThread.gotoState(state210, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 787, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 788
					} else if (!call.has("date")) {
						// Line: 789
						askdate_CN state211 = new askdate_CN();
						flowThread.gotoState(state211, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 789, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 790
					} else {
						// Line: 791
						calldone_CN state212 = new calldone_CN();
						flowThread.gotoState(state212, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 791, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 781, 12));
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
			// Line: 797
			try {
				EXECUTION: {
					int count = getCount(1007260470) + 1;
					incrCount(1007260470);
					iristk.situated.SystemAgentFlow.prompt state213 = agent.new prompt();
					StringCreator string214 = new StringCreator();
					string214.append("请设置小时数。");
					state213.setText(string214.toString());
					if (!flowThread.callState(state213, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 797, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 797, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 800
			try {
				count = getCount(1451152187) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1451152187);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 801
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 802
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state215 = agent.new say();
								StringCreator string216 = new StringCreator();
								string216.append("对不起这是无效的时间。");
								state215.setText(string216.toString());
								if (!flowThread.callState(state215, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 802, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 804
							} else if ( num > 11 ) {
								// Line: 805
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 806
							} else {
								// Line: 807
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 809
							checkcall_CN state217 = new checkcall_CN();
							flowThread.gotoState(state217, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 809, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 800, 61));
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
			// Line: 814
			try {
				EXECUTION: {
					int count = getCount(1652919960) + 1;
					incrCount(1652919960);
					iristk.situated.SystemAgentFlow.prompt state218 = agent.new prompt();
					StringCreator string219 = new StringCreator();
					string219.append("请设置分钟数。");
					state218.setText(string219.toString());
					if (!flowThread.callState(state218, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 814, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 814, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 817
			try {
				count = getCount(384801485) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(384801485);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 818
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 819
							checkcall_CN state220 = new checkcall_CN();
							flowThread.gotoState(state220, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 819, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 817, 61));
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
			// Line: 824
			try {
				EXECUTION: {
					int count = getCount(1954949533) + 1;
					incrCount(1954949533);
					iristk.situated.SystemAgentFlow.prompt state221 = agent.new prompt();
					StringCreator string222 = new StringCreator();
					string222.append("请问是上午还是下午?");
					state221.setText(string222.toString());
					if (!flowThread.callState(state221, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 824, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 824, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 827
			try {
				count = getCount(1885384506) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1885384506);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 828
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 829
							checkcall_CN state223 = new checkcall_CN();
							flowThread.gotoState(state223, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 829, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 827, 58));
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
			// Line: 834
			try {
				EXECUTION: {
					int count = getCount(1931556461) + 1;
					incrCount(1931556461);
					iristk.situated.SystemAgentFlow.prompt state224 = agent.new prompt();
					StringCreator string225 = new StringCreator();
					string225.append("请问是今天还是明天？");
					state224.setText(string225.toString());
					if (!flowThread.callState(state224, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 834, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 834, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 837
			try {
				count = getCount(1753578922) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1753578922);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 838
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 839
							checkcall_CN state226 = new checkcall_CN();
							flowThread.gotoState(state226, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 839, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 837, 59));
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
			// Line: 844
			try {
				EXECUTION: {
					int count = getCount(1827488869) + 1;
					incrCount(1827488869);
					// Line: 845
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state227 = agent.new prompt();
					state227.setText(info.timeconfirm_CN(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state227, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 844, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 844, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 849
			try {
				count = getCount(884970577) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(884970577);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 850
							callroom_CN state228 = new callroom_CN();
							flowThread.gotoState(state228, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 850, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 849, 58));
			}
			// Line: 852
			try {
				count = getCount(764282729) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(764282729);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 853
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 854
							MorningCall_CN state229 = new MorningCall_CN();
							flowThread.gotoState(state229, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 854, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 852, 57));
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
			// Line: 859
			try {
				EXECUTION: {
					int count = getCount(18798850) + 1;
					incrCount(18798850);
					iristk.situated.SystemAgentFlow.prompt state230 = agent.new prompt();
					StringCreator string231 = new StringCreator();
					string231.append("请问您的房间号是多少？");
					state230.setText(string231.toString());
					if (!flowThread.callState(state230, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 859, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 859, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 862
			try {
				count = getCount(1468214410) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1468214410);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 863
						String sss = event.get("text").toString();
						// Line: 864
						if (eq("Sorry",info.callroom_CN(sss))) {
							iristk.situated.SystemAgentFlow.say state232 = agent.new say();
							StringCreator string233 = new StringCreator();
							string233.append("抱歉，我没有理解您说的话。");
							state232.setText(string233.toString());
							if (!flowThread.callState(state232, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 864, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 866
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 866, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 867
						} else {
							iristk.situated.SystemAgentFlow.say state234 = agent.new say();
							state234.setText(info.callroom_CN(sss));
							if (!flowThread.callState(state234, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 864, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 869
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 870
							roomconfirm_CN state235 = new roomconfirm_CN();
							flowThread.gotoState(state235, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 870, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 862, 36));
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
			// Line: 876
			try {
				EXECUTION: {
					int count = getCount(747381895) + 1;
					incrCount(747381895);
					iristk.situated.SystemAgentFlow.listen state236 = agent.new listen();
					if (!flowThread.callState(state236, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 876, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 876, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 879
			try {
				count = getCount(1852288703) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1852288703);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 880
							call.remove("room");
							// Line: 881
							callroom_CN state237 = new callroom_CN();
							flowThread.gotoState(state237, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 881, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 879, 57));
			}
			// Line: 883
			try {
				count = getCount(1297217693) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1297217693);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 884
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 887
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 888
							CheckAgain_CN state238 = new CheckAgain_CN();
							flowThread.gotoState(state238, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 888, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 883, 58));
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
			// Line: 897
			try {
				EXECUTION: {
					int count = getCount(762961671) + 1;
					incrCount(762961671);
					iristk.situated.SystemAgentFlow.prompt state239 = agent.new prompt();
					StringCreator string240 = new StringCreator();
					string240.append("您还需要其他帮助吗？");
					state239.setText(string240.toString());
					if (!flowThread.callState(state239, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 897, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 897, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 900
			try {
				count = getCount(316774027) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(316774027);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state241 = agent.new say();
							StringCreator string242 = new StringCreator();
							string242.append("好的");
							state241.setText(string242.toString());
							if (!flowThread.callState(state241, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 900, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 902
							Start_CN state243 = new Start_CN();
							flowThread.gotoState(state243, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 902, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 900, 58));
			}
			// Line: 904
			try {
				count = getCount(1813051345) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1813051345);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state244 = agent.new say();
							StringCreator string245 = new StringCreator();
							string245.append("好的");
							state244.setText(string245.toString());
							if (!flowThread.callState(state244, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 904, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 906
							Goodbye_CN state246 = new Goodbye_CN();
							flowThread.gotoState(state246, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 906, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 904, 57));
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
			// Line: 911
			try {
				count = getCount(1128621710) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1128621710);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state247 = agent.new gesture();
							state247.setName("smile");
							if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 911, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 911, 102));
			}
			// Line: 914
			try {
				count = getCount(679522120) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(679522120);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state248 = agent.new say();
						StringCreator string249 = new StringCreator();
						string249.append("抱歉，我没有理解您说的话。");
						state248.setText(string249.toString());
						if (!flowThread.callState(state248, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 914, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 916
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 916, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 914, 36));
			}
			// Line: 918
			try {
				count = getCount(1784438864) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1784438864);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state250 = agent.new attendOther();
						state250.setMode("eyes");
						if (!flowThread.callState(state250, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 918, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state251 = agent.new say();
						StringCreator string252 = new StringCreator();
						string252.append("对不起，我现在没有问您。");
						state251.setText(string252.toString());
						if (!flowThread.callState(state251, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 918, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state253 = agent.new attendOther();
						state253.setMode("eyes");
						if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 918, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 922
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 922, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 918, 41));
			}
			// Line: 924
			try {
				count = getCount(798101372) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(798101372);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state254 = agent.new say();
						StringCreator string255 = new StringCreator();
						string255.append("请不要同时说话。");
						state254.setText(string255.toString());
						if (!flowThread.callState(state254, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 924, 42)))) {
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
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 924, 42));
			}
			// Line: 928
			try {
				count = getCount(1892694432) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1892694432);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state256 = agent.new say();
						StringCreator string257 = new StringCreator();
						string257.append("抱歉，我没有听到任何话。");
						state256.setText(string257.toString());
						if (!flowThread.callState(state256, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 928, 38)))) {
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
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 928, 38));
			}
			// Line: 932
			try {
				count = getCount(1706928613) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1706928613);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state258 = agent.new say();
							StringCreator string259 = new StringCreator();
							string259.append("再见。");
							state258.setText(string259.toString());
							if (!flowThread.callState(state258, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 932, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 934
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state260 = agent.new attendRandom();
								if (!flowThread.callState(state260, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 934, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 936
								Start_CN state261 = new Start_CN();
								flowThread.gotoState(state261, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 936, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 937
							} else {
								// Line: 938
								Idle state262 = new Idle();
								flowThread.gotoState(state262, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 938, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 932, 69));
			}
			// Line: 941
			try {
				count = getCount(165108659) + 1;
				if (event.triggers("repeat")) {
					incrCount(165108659);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 942
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 942, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 941, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
