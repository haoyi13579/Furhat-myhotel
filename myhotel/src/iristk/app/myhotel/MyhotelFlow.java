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
	private Record call;
	private iristk.situated.SystemAgent system;
	private Integer number;
	private String lang;

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

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	public Information getInfo() {
		return this.info;
	}

	public Weather getWeather() {
		return this.weather;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("call")) return this.call;
		if (name.equals("system")) return this.system;
		if (name.equals("number")) return this.number;
		if (name.equals("lang")) return this.lang;
		if (name.equals("agent")) return this.agent;
		if (name.equals("info")) return this.info;
		if (name.equals("weather")) return this.weather;
		return null;
	}


	public MyhotelFlow(iristk.situated.SystemAgentFlow agent, Information info, Weather weather) {
		this.agent = agent;
		this.info = info;
		this.weather = weather;
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
			// Line: 22
			try {
				EXECUTION: {
					int count = getCount(2019526923) + 1;
					incrCount(2019526923);
					// Line: 23
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 23, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 25
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 25, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 26
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 23, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 22, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 30
			try {
				count = getCount(1802537758) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(1802537758);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 30, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 32
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 32, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 30, 36));
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
			// Line: 37
			try {
				EXECUTION: {
					int count = getCount(600943760) + 1;
					incrCount(600943760);
					// Line: 38
					Event sendEvent5 = new Event("action.voice");
					sendEvent5.putIfNotNull("name", "David");
					flowRunner.sendEvent(sendEvent5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 38, 49)));
					iristk.situated.SystemAgentFlow.prompt state6 = agent.new prompt();
					StringCreator string7 = new StringCreator();
					string7.append("Hi there, Do you want me to speak English or Chinese?");
					state6.setText(string7.toString());
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 37, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 40
					Start state8 = new Start();
					flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 37, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 42
			try {
				count = getCount(1454923721) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:chinese")) {
						incrCount(1454923721);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 43
							lang = "zh";
							// Line: 44
							Event sendEvent9 = new Event("action.context.default");
							sendEvent9.putIfNotNull("context", "Chinese");
							flowRunner.sendEvent(sendEvent9, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 44, 66)));
							// Line: 45
							Event sendEvent10 = new Event("action.voice");
							sendEvent10.putIfNotNull("name", "HuiHui");
							flowRunner.sendEvent(sendEvent10, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 45, 52)));
							// Line: 46
							Start_CN state11 = new Start_CN();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 46, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 42, 62));
			}
			// Line: 48
			try {
				count = getCount(892209444) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:english")) {
						incrCount(892209444);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 49
							lang = "en";
							// Line: 50
							Event sendEvent12 = new Event("action.context.default");
							sendEvent12.putIfNotNull("context", "English");
							flowRunner.sendEvent(sendEvent12, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 50, 65)));
							// Line: 51
							Event sendEvent13 = new Event("action.voice");
							sendEvent13.putIfNotNull("name", "David");
							flowRunner.sendEvent(sendEvent13, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 51, 51)));
							// Line: 52
							Start state14 = new Start();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 52, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 48, 62));
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
			// Line: 57
			try {
				EXECUTION: {
					int count = getCount(856760994) + 1;
					incrCount(856760994);
					iristk.situated.SystemAgentFlow.prompt state15 = agent.new prompt();
					StringCreator string16 = new StringCreator();
					string16.append("What can I do for you?");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 57, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 57, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 65
			try {
				count = getCount(931688376) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(931688376);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 67
							if (event.has("sem:natural")) {
								// Line: 68
								Nature state17 = new Nature();
								flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 68, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 69
							} else if (event.has("sem:historical")) {
								// Line: 70
								History state18 = new History();
								flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 70, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 71
							} else if (event.has("sem:popular")) {
								// Line: 72
								Popular state19 = new Popular();
								flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 72, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 73
							} else {
								// Line: 74
								QueryAttr state20 = new QueryAttr();
								flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 74, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 65, 68));
			}
			// Line: 78
			try {
				count = getCount(290922746) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(290922746);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 79
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state21 = agent.new say();
								state21.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 79, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 81
								CheckAgain state22 = new CheckAgain();
								flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 81, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 82
							} else {
								// Line: 83
								QueryTrans state23 = new QueryTrans();
								flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 83, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 78, 71));
			}
			// Line: 87
			try {
				count = getCount(1145937453) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(1145937453);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 89
							QueryRoom state24 = new QueryRoom();
							flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 89, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 87, 62));
			}
			// Line: 92
			try {
				count = getCount(1032616868) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(1032616868);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 93
							QueryWeather state25 = new QueryWeather();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 93, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 92, 62));
			}
			// Line: 96
			try {
				count = getCount(433533432) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(433533432);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 97
							MorningCall state26 = new MorningCall();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 97, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 96, 59));
			}
			// Line: 100
			try {
				count = getCount(1173090147) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(1173090147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state27 = agent.new say();
							StringCreator string28 = new StringCreator();
							string28.append("Okay");
							state27.setText(string28.toString());
							if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 100, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 102
							Goodbye state29 = new Goodbye();
							flowThread.gotoState(state29, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 102, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 100, 59));
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
			// Line: 110
			try {
				EXECUTION: {
					int count = getCount(1945985504) + 1;
					incrCount(1945985504);
					iristk.situated.SystemAgentFlow.say state30 = agent.new say();
					StringCreator string31 = new StringCreator();
					string31.append("Goodbye.");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 110, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state32 = agent.new say();
					StringCreator string33 = new StringCreator();
					string33.append("Please leave the detection area");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 110, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 113
					iristk.flow.DialogFlow.wait waitState34 = new iristk.flow.DialogFlow.wait();
					waitState34.setMsec(2000);
					if (!flowThread.callState(waitState34, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 113, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 114
					Idle state35 = new Idle();
					flowThread.gotoState(state35, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 114, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 110, 12));
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
			// Line: 121
			try {
				EXECUTION: {
					int count = getCount(338155120) + 1;
					incrCount(338155120);
					iristk.situated.SystemAgentFlow.prompt state36 = agent.new prompt();
					StringCreator string37 = new StringCreator();
					string37.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state36.setText(string37.toString());
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 121, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 121, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 126
			try {
				count = getCount(1170285503) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(1170285503);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 127
							Nature state38 = new Nature();
							flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 127, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 126, 68));
			}
			// Line: 129
			try {
				count = getCount(541718322) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(541718322);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 130
							History state39 = new History();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 130, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 129, 71));
			}
			// Line: 132
			try {
				count = getCount(1181169447) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(1181169447);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 133
							Popular state40 = new Popular();
							flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 133, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 132, 66));
			}
			// Line: 135
			try {
				count = getCount(1734041861) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1734041861);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 136
							CheckAgain state41 = new CheckAgain();
							flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 136, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 135, 61));
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
			// Line: 141
			try {
				EXECUTION: {
					int count = getCount(73878681) + 1;
					incrCount(73878681);
					iristk.situated.SystemAgentFlow.say state42 = agent.new say();
					state42.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 141, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 143
					Attrdetial state43 = new Attrdetial();
					flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 143, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 141, 16));
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
			// Line: 148
			try {
				EXECUTION: {
					int count = getCount(1233468460) + 1;
					incrCount(1233468460);
					iristk.situated.SystemAgentFlow.say state44 = agent.new say();
					state44.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 148, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 150
					Attrdetial state45 = new Attrdetial();
					flowThread.gotoState(state45, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 150, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 148, 16));
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
			// Line: 155
			try {
				EXECUTION: {
					int count = getCount(467782315) + 1;
					incrCount(467782315);
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					state46.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 155, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 157
					Attrdetial state47 = new Attrdetial();
					flowThread.gotoState(state47, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 157, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 155, 16));
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
			// Line: 162
			try {
				EXECUTION: {
					int count = getCount(1002622) + 1;
					incrCount(1002622);
					iristk.situated.SystemAgentFlow.prompt state48 = agent.new prompt();
					StringCreator string49 = new StringCreator();
					string49.append("If you want more details for attractions,please say the name.");
					state48.setText(string49.toString());
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 162, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 162, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 165
			try {
				count = getCount(355363398) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(355363398);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 166
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state50 = agent.new say();
							state50.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 165, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 168
							CheckAgain state51 = new CheckAgain();
							flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 168, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 165, 69));
			}
			// Line: 170
			try {
				count = getCount(221150998) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(221150998);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 171
							CheckAgain state52 = new CheckAgain();
							flowThread.gotoState(state52, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 171, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 170, 61));
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
			// Line: 177
			try {
				EXECUTION: {
					int count = getCount(238953976) + 1;
					incrCount(238953976);
					iristk.situated.SystemAgentFlow.prompt state53 = agent.new prompt();
					StringCreator string54 = new StringCreator();
					string54.append("Where do you want to go?");
					state53.setText(string54.toString());
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 177, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 177, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 180
			try {
				count = getCount(1888894438) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1888894438);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state55 = agent.new say();
							state55.setText(event.get("sem:attrname"));
							if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 180, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state56 = agent.new say();
							state56.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 180, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 183
							CheckAgain state57 = new CheckAgain();
							flowThread.gotoState(state57, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 183, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 180, 65));
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
			// Line: 189
			try {
				EXECUTION: {
					int count = getCount(326885558) + 1;
					incrCount(326885558);
					iristk.situated.SystemAgentFlow.prompt state58 = agent.new prompt();
					StringCreator string59 = new StringCreator();
					string59.append("Which room do you want to find?");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 189, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 189, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 192
			try {
				count = getCount(1388545586) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(1388545586);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state60 = agent.new say();
							StringCreator string61 = new StringCreator();
							string61.append("It is on the first floor");
							state60.setText(string61.toString());
							if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 194
							CheckAgain state62 = new CheckAgain();
							flowThread.gotoState(state62, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 194, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 70));
			}
			// Line: 196
			try {
				count = getCount(1554777413) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1554777413);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 197
						String ss = event.get("text").toString();
						// Line: 198
						if (eq("Sorry",info.findroom(ss))) {
							iristk.situated.SystemAgentFlow.say state63 = agent.new say();
							StringCreator string64 = new StringCreator();
							string64.append("Sorry, I didn't get that.");
							state63.setText(string64.toString());
							if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 198, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 200
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 200, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 201
						} else {
							iristk.situated.SystemAgentFlow.say state65 = agent.new say();
							state65.setText(info.findroom(ss));
							if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 198, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 203
							CheckAgain state66 = new CheckAgain();
							flowThread.gotoState(state66, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 203, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 196, 42));
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
			// Line: 210
			try {
				EXECUTION: {
					int count = getCount(779797506) + 1;
					incrCount(779797506);
					iristk.situated.SystemAgentFlow.say state67 = agent.new say();
					state67.setText(weather.getweather());
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 210, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 212
					CheckAgain state68 = new CheckAgain();
					flowThread.gotoState(state68, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 212, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 210, 12));
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
			// Line: 218
			try {
				EXECUTION: {
					int count = getCount(10355794) + 1;
					incrCount(10355794);
					// Line: 219
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state69 = agent.new prompt();
					StringCreator string70 = new StringCreator();
					string70.append("When do you want to awake?");
					state69.setText(string70.toString());
					if (!flowThread.callState(state69, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 223
			try {
				count = getCount(2059137070) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") && event.has("sem:number")) {
						incrCount(2059137070);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 224
							call.putIfNotNull("minute", 0);
							// Line: 225
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 226
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state71 = agent.new say();
								StringCreator string72 = new StringCreator();
								string72.append("Sorry the time is invalid.");
								state71.setText(string72.toString());
								if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 226, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 228
							} else if (num > 12) {
								// Line: 229
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 231
							} else {
								// Line: 232
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 233
								if (event.has("sem:apm")) {
									// Line: 234
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 237
							if (event.has("sem:date")) {
								// Line: 238
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 240
							checkcall state73 = new checkcall();
							flowThread.gotoState(state73, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 240, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 223, 82));
			}
			// Line: 243
			try {
				count = getCount(1014222525) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(1014222525);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 244
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 245
							call.putIfNotNull("minute", 30);
							// Line: 246
							if (event.has("sem:past")) {
								// Line: 247
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state74 = agent.new say();
									StringCreator string75 = new StringCreator();
									string75.append("Sorry the time is invalid.");
									state74.setText(string75.toString());
									if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 247, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 249
								} else if (num > 11) {
									// Line: 250
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 251
								} else {
									// Line: 252
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 253
									if (event.has("sem:apm")) {
										// Line: 254
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 257
								if (event.has("sem:date")) {
									// Line: 258
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 260
								checkcall state76 = new checkcall();
								flowThread.gotoState(state76, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 260, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 263
							if (event.has("sem:to")) {
								// Line: 264
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state77 = agent.new say();
									StringCreator string78 = new StringCreator();
									string78.append("Sorry the time is invalid.");
									state77.setText(string78.toString());
									if (!flowThread.callState(state77, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 264, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 266
								} else if (num > 12) {
									// Line: 267
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 268
								} else {
									// Line: 269
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 270
									if (event.has("sem:apm")) {
										// Line: 271
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 274
								if (event.has("sem:date")) {
									// Line: 275
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 277
								checkcall state79 = new checkcall();
								flowThread.gotoState(state79, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 277, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 243, 81));
			}
			// Line: 281
			try {
				count = getCount(2011239116) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:noon")) {
						incrCount(2011239116);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 282
							call.putIfNotNull("hour", 12); call.putIfNotNull("minute", 0); call.putIfNotNull("apm", "am");
							// Line: 283
							if (event.has("sem:date")) {
								// Line: 284
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 286
							checkcall state80 = new checkcall();
							flowThread.gotoState(state80, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 286, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 281, 59));
			}
			// Line: 289
			try {
				count = getCount(1111976791) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:midnight")) {
						incrCount(1111976791);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 290
							call.putIfNotNull("hour", 0); call.putIfNotNull("minute", 0); call.putIfNotNull("apm", "am");
							// Line: 291
							if (event.has("sem:date")) {
								// Line: 292
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 294
							checkcall state81 = new checkcall();
							flowThread.gotoState(state81, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 294, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 289, 63));
			}
			// Line: 297
			try {
				count = getCount(905988145) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(905988145);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 298
							CheckAgain state82 = new CheckAgain();
							flowThread.gotoState(state82, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 298, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 297, 57));
			}
			// Line: 301
			try {
				count = getCount(248637428) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(248637428);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 302
							checkcall state83 = new checkcall();
							flowThread.gotoState(state83, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 302, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 301, 61));
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
			// Line: 308
			try {
				EXECUTION: {
					int count = getCount(1038882473) + 1;
					incrCount(1038882473);
					// Line: 309
					if (!call.has("hour")) {
						// Line: 310
						askhour state84 = new askhour();
						flowThread.gotoState(state84, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 310, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 311
					} else if (!call.has("minute")) {
						// Line: 312
						askminute state85 = new askminute();
						flowThread.gotoState(state85, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 312, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 313
					} else if (!call.has("apm")) {
						// Line: 314
						askapm state86 = new askapm();
						flowThread.gotoState(state86, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 314, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 315
					} else if (!call.has("date")) {
						// Line: 316
						askdate state87 = new askdate();
						flowThread.gotoState(state87, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 316, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 317
					} else {
						// Line: 318
						calldone state88 = new calldone();
						flowThread.gotoState(state88, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 318, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 308, 12));
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
			// Line: 324
			try {
				EXECUTION: {
					int count = getCount(243664576) + 1;
					incrCount(243664576);
					iristk.situated.SystemAgentFlow.prompt state89 = agent.new prompt();
					StringCreator string90 = new StringCreator();
					string90.append("Please say the hour of the morning call.");
					state89.setText(string90.toString());
					if (!flowThread.callState(state89, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 324, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 324, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 327
			try {
				count = getCount(1909475381) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1909475381);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 328
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 329
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state91 = agent.new say();
								StringCreator string92 = new StringCreator();
								string92.append("Sorry the time is invalid.");
								state91.setText(string92.toString());
								if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 329, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 331
							} else if ( num > 11 ) {
								// Line: 332
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 333
							} else {
								// Line: 334
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 336
							checkcall state93 = new checkcall();
							flowThread.gotoState(state93, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 336, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 327, 61));
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
			// Line: 341
			try {
				EXECUTION: {
					int count = getCount(1373827077) + 1;
					incrCount(1373827077);
					iristk.situated.SystemAgentFlow.prompt state94 = agent.new prompt();
					StringCreator string95 = new StringCreator();
					string95.append("Please say the minute of the morning call.");
					state94.setText(string95.toString());
					if (!flowThread.callState(state94, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 341, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 341, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 344
			try {
				count = getCount(1212235970) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1212235970);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 345
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 346
							checkcall state96 = new checkcall();
							flowThread.gotoState(state96, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 346, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 344, 61));
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
			// Line: 351
			try {
				EXECUTION: {
					int count = getCount(832064390) + 1;
					incrCount(832064390);
					iristk.situated.SystemAgentFlow.prompt state97 = agent.new prompt();
					StringCreator string98 = new StringCreator();
					string98.append("Is it a.m. or p.m.?");
					state97.setText(string98.toString());
					if (!flowThread.callState(state97, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 351, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 351, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 354
			try {
				count = getCount(1292287155) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1292287155);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 355
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 356
							checkcall state99 = new checkcall();
							flowThread.gotoState(state99, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 356, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 354, 58));
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
			// Line: 361
			try {
				EXECUTION: {
					int count = getCount(621739647) + 1;
					incrCount(621739647);
					iristk.situated.SystemAgentFlow.prompt state100 = agent.new prompt();
					StringCreator string101 = new StringCreator();
					string101.append("Do we need to call you at today or tomorrow?");
					state100.setText(string101.toString());
					if (!flowThread.callState(state100, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 361, 12)))) {
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
				count = getCount(1039377900) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1039377900);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 365
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 366
							checkcall state102 = new checkcall();
							flowThread.gotoState(state102, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 366, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 364, 59));
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
			// Line: 371
			try {
				EXECUTION: {
					int count = getCount(25743097) + 1;
					incrCount(25743097);
					// Line: 372
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state103 = agent.new prompt();
					state103.setText(info.timeconfirm(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state103, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 371, 12)))) {
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
			// Line: 376
			try {
				count = getCount(1857946135) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1857946135);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 377
							callroom state104 = new callroom();
							flowThread.gotoState(state104, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 377, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 376, 58));
			}
			// Line: 379
			try {
				count = getCount(778707800) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(778707800);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 380
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 381
							MorningCall state105 = new MorningCall();
							flowThread.gotoState(state105, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 381, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 379, 57));
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
			// Line: 386
			try {
				EXECUTION: {
					int count = getCount(901292963) + 1;
					incrCount(901292963);
					iristk.situated.SystemAgentFlow.prompt state106 = agent.new prompt();
					StringCreator string107 = new StringCreator();
					string107.append("Which room do you live in?");
					state106.setText(string107.toString());
					if (!flowThread.callState(state106, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 386, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 386, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 389
			try {
				count = getCount(701107412) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(701107412);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 390
						String sss = event.get("text").toString();
						// Line: 391
						if (eq("Sorry",info.callroom(sss))) {
							iristk.situated.SystemAgentFlow.say state108 = agent.new say();
							StringCreator string109 = new StringCreator();
							string109.append("Sorry, I didn't get that.");
							state108.setText(string109.toString());
							if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 391, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 393
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 393, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 394
						} else {
							iristk.situated.SystemAgentFlow.say state110 = agent.new say();
							state110.setText(info.callroom(sss));
							if (!flowThread.callState(state110, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 391, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 396
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 397
							roomconfirm state111 = new roomconfirm();
							flowThread.gotoState(state111, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 397, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 389, 36));
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
			// Line: 403
			try {
				EXECUTION: {
					int count = getCount(37659217) + 1;
					incrCount(37659217);
					iristk.situated.SystemAgentFlow.listen state112 = agent.new listen();
					if (!flowThread.callState(state112, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 403, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 403, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 406
			try {
				count = getCount(1303854942) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1303854942);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 407
							call.remove("room");
							// Line: 408
							callroom state113 = new callroom();
							flowThread.gotoState(state113, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 408, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 406, 57));
			}
			// Line: 410
			try {
				count = getCount(1563054056) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1563054056);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 411
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 414
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 415
							CheckAgain state114 = new CheckAgain();
							flowThread.gotoState(state114, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 415, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 410, 58));
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
			// Line: 423
			try {
				EXECUTION: {
					int count = getCount(128366835) + 1;
					incrCount(128366835);
					iristk.situated.SystemAgentFlow.prompt state115 = agent.new prompt();
					StringCreator string116 = new StringCreator();
					string116.append("Do you need other help?");
					state115.setText(string116.toString());
					if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 423, 12)))) {
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
				count = getCount(1378490872) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1378490872);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state117 = agent.new say();
							StringCreator string118 = new StringCreator();
							string118.append("Okay");
							state117.setText(string118.toString());
							if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 426, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 428
							Start state119 = new Start();
							flowThread.gotoState(state119, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 428, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 426, 58));
			}
			// Line: 430
			try {
				count = getCount(264580987) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(264580987);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state120 = agent.new say();
							StringCreator string121 = new StringCreator();
							string121.append("Okay");
							state120.setText(string121.toString());
							if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 430, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 432
							Goodbye state122 = new Goodbye();
							flowThread.gotoState(state122, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 432, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 430, 57));
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
			// Line: 437
			try {
				count = getCount(1152205288) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1152205288);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state123 = agent.new gesture();
							state123.setName("smile");
							if (!flowThread.callState(state123, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 437, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 437, 102));
			}
			// Line: 440
			try {
				count = getCount(1647640817) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1647640817);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state124 = agent.new say();
						StringCreator string125 = new StringCreator();
						string125.append("Sorry, I didn't get that.");
						state124.setText(string125.toString());
						if (!flowThread.callState(state124, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 440, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 442
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 442, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 440, 36));
			}
			// Line: 444
			try {
				count = getCount(1505069453) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1505069453);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state126 = agent.new attendOther();
						state126.setMode("eyes");
						if (!flowThread.callState(state126, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 444, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state127 = agent.new say();
						StringCreator string128 = new StringCreator();
						string128.append("I didn't ask you.");
						state127.setText(string128.toString());
						if (!flowThread.callState(state127, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 444, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state129 = agent.new attendOther();
						state129.setMode("eyes");
						if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 444, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 448
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 448, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 444, 41));
			}
			// Line: 450
			try {
				count = getCount(1036096972) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1036096972);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state130 = agent.new say();
						StringCreator string131 = new StringCreator();
						string131.append("Don't speak at the same time.");
						state130.setText(string131.toString());
						if (!flowThread.callState(state130, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 450, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 452
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 452, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 450, 42));
			}
			// Line: 454
			try {
				count = getCount(405960568) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(405960568);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state132 = agent.new say();
						StringCreator string133 = new StringCreator();
						string133.append("Sorry, I didn't hear anything.");
						state132.setText(string133.toString());
						if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 454, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 456
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 456, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 454, 38));
			}
			// Line: 458
			try {
				count = getCount(392263795) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(392263795);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state134 = agent.new say();
							StringCreator string135 = new StringCreator();
							string135.append("Goodbye");
							state134.setText(string135.toString());
							if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 458, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 464
							Idle state136 = new Idle();
							flowThread.gotoState(state136, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 464, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 458, 69));
			}
			// Line: 467
			try {
				count = getCount(39224355) + 1;
				if (event.triggers("repeat")) {
					incrCount(39224355);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 468
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 468, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 467, 26));
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
			// Line: 480
			try {
				EXECUTION: {
					int count = getCount(1805406515) + 1;
					incrCount(1805406515);
					iristk.situated.SystemAgentFlow.prompt state137 = agent.new prompt();
					StringCreator string138 = new StringCreator();
					string138.append("请问有什么可以帮到您的？");
					state137.setText(string138.toString());
					if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 480, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 480, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 488
			try {
				count = getCount(1566418943) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(1566418943);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 490
							if (event.has("sem:natural")) {
								// Line: 491
								Nature_CN state139 = new Nature_CN();
								flowThread.gotoState(state139, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 491, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 492
							} else if (event.has("sem:historical")) {
								// Line: 493
								History_CN state140 = new History_CN();
								flowThread.gotoState(state140, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 493, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 494
							} else if (event.has("sem:popular")) {
								// Line: 495
								Popular_CN state141 = new Popular_CN();
								flowThread.gotoState(state141, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 495, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 496
							} else {
								// Line: 497
								QueryAttr_CN state142 = new QueryAttr_CN();
								flowThread.gotoState(state142, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 497, 35)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 488, 68));
			}
			// Line: 501
			try {
				count = getCount(2037853507) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(2037853507);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 502
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state143 = agent.new say();
								state143.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 502, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 504
								CheckAgain_CN state144 = new CheckAgain_CN();
								flowThread.gotoState(state144, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 504, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 505
							} else {
								// Line: 506
								QueryTrans_CN state145 = new QueryTrans_CN();
								flowThread.gotoState(state145, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 506, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 501, 71));
			}
			// Line: 510
			try {
				count = getCount(647234992) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(647234992);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 511
							QueryRoom_CN state146 = new QueryRoom_CN();
							flowThread.gotoState(state146, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 511, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 510, 62));
			}
			// Line: 514
			try {
				count = getCount(99223893) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(99223893);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 515
							QueryWeather_CN state147 = new QueryWeather_CN();
							flowThread.gotoState(state147, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 515, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 514, 62));
			}
			// Line: 518
			try {
				count = getCount(1525656424) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(1525656424);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 519
							MorningCall_CN state148 = new MorningCall_CN();
							flowThread.gotoState(state148, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 519, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 518, 59));
			}
			// Line: 522
			try {
				count = getCount(1146462602) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(1146462602);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state149 = agent.new say();
							StringCreator string150 = new StringCreator();
							string150.append("好的");
							state149.setText(string150.toString());
							if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 522, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 524
							Goodbye_CN state151 = new Goodbye_CN();
							flowThread.gotoState(state151, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 524, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 522, 59));
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
			// Line: 531
			try {
				EXECUTION: {
					int count = getCount(789454906) + 1;
					incrCount(789454906);
					iristk.situated.SystemAgentFlow.say state152 = agent.new say();
					StringCreator string153 = new StringCreator();
					string153.append("再见。");
					state152.setText(string153.toString());
					if (!flowThread.callState(state152, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 531, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state154 = agent.new say();
					StringCreator string155 = new StringCreator();
					string155.append("请离开感应区域");
					state154.setText(string155.toString());
					if (!flowThread.callState(state154, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 531, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 534
					iristk.flow.DialogFlow.wait waitState156 = new iristk.flow.DialogFlow.wait();
					waitState156.setMsec(2000);
					if (!flowThread.callState(waitState156, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 534, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 535
					Idle state157 = new Idle();
					flowThread.gotoState(state157, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 535, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 531, 12));
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
			// Line: 542
			try {
				EXECUTION: {
					int count = getCount(622979784) + 1;
					incrCount(622979784);
					iristk.situated.SystemAgentFlow.prompt state158 = agent.new prompt();
					StringCreator string159 = new StringCreator();
					string159.append("您想参观哪种景点？自然景点，历史景点还是热门景点？");
					state158.setText(string159.toString());
					if (!flowThread.callState(state158, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 542, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 542, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 547
			try {
				count = getCount(398467153) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(398467153);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 548
							Nature_CN state160 = new Nature_CN();
							flowThread.gotoState(state160, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 548, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 547, 68));
			}
			// Line: 550
			try {
				count = getCount(292229796) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(292229796);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 551
							History_CN state161 = new History_CN();
							flowThread.gotoState(state161, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 551, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 550, 71));
			}
			// Line: 553
			try {
				count = getCount(761438324) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(761438324);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 554
							Popular_CN state162 = new Popular_CN();
							flowThread.gotoState(state162, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 554, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 553, 66));
			}
			// Line: 556
			try {
				count = getCount(337970414) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(337970414);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 557
							CheckAgain_CN state163 = new CheckAgain_CN();
							flowThread.gotoState(state163, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 557, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 556, 61));
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
			// Line: 562
			try {
				EXECUTION: {
					int count = getCount(1785701154) + 1;
					incrCount(1785701154);
					iristk.situated.SystemAgentFlow.say state164 = agent.new say();
					state164.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 562, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 564
					Attrdetial_CN state165 = new Attrdetial_CN();
					flowThread.gotoState(state165, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 564, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 562, 16));
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
			// Line: 569
			try {
				EXECUTION: {
					int count = getCount(627680107) + 1;
					incrCount(627680107);
					iristk.situated.SystemAgentFlow.say state166 = agent.new say();
					state166.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state166, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 569, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 571
					Attrdetial_CN state167 = new Attrdetial_CN();
					flowThread.gotoState(state167, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 571, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 569, 16));
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
			// Line: 576
			try {
				EXECUTION: {
					int count = getCount(319959963) + 1;
					incrCount(319959963);
					iristk.situated.SystemAgentFlow.say state168 = agent.new say();
					state168.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state168, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 576, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 578
					Attrdetial_CN state169 = new Attrdetial_CN();
					flowThread.gotoState(state169, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 578, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 576, 16));
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
			// Line: 583
			try {
				EXECUTION: {
					int count = getCount(1349205712) + 1;
					incrCount(1349205712);
					iristk.situated.SystemAgentFlow.prompt state170 = agent.new prompt();
					StringCreator string171 = new StringCreator();
					string171.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state170.setText(string171.toString());
					if (!flowThread.callState(state170, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 583, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 583, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 586
			try {
				count = getCount(1390891437) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1390891437);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 587
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state172 = agent.new say();
							state172.setText(info.detail_CN(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state172, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 586, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 589
							CheckAgain_CN state173 = new CheckAgain_CN();
							flowThread.gotoState(state173, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 589, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 586, 69));
			}
			// Line: 591
			try {
				count = getCount(1959285221) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1959285221);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 592
							CheckAgain_CN state174 = new CheckAgain_CN();
							flowThread.gotoState(state174, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 592, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 591, 61));
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
			// Line: 598
			try {
				EXECUTION: {
					int count = getCount(2106587792) + 1;
					incrCount(2106587792);
					iristk.situated.SystemAgentFlow.prompt state175 = agent.new prompt();
					StringCreator string176 = new StringCreator();
					string176.append("您打算去哪里？");
					state175.setText(string176.toString());
					if (!flowThread.callState(state175, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 598, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 598, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 601
			try {
				count = getCount(1274989501) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attrname")) {
						incrCount(1274989501);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state177 = agent.new say();
							state177.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 601, 63)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 603
							CheckAgain_CN state178 = new CheckAgain_CN();
							flowThread.gotoState(state178, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 603, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 601, 63));
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
			// Line: 609
			try {
				EXECUTION: {
					int count = getCount(1196764561) + 1;
					incrCount(1196764561);
					iristk.situated.SystemAgentFlow.prompt state179 = agent.new prompt();
					StringCreator string180 = new StringCreator();
					string180.append("您在找哪个房间？");
					state179.setText(string180.toString());
					if (!flowThread.callState(state179, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 609, 16)))) {
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
			// Line: 612
			try {
				count = getCount(2051782117) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(2051782117);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state181 = agent.new say();
							StringCreator string182 = new StringCreator();
							string182.append("它在一楼。");
							state181.setText(string182.toString());
							if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 612, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 614
							CheckAgain_CN state183 = new CheckAgain_CN();
							flowThread.gotoState(state183, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 614, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 612, 70));
			}
			// Line: 616
			try {
				count = getCount(566154065) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(566154065);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 617
						String ss = event.get("text").toString();
						// Line: 618
						if (eq("Sorry",info.findroom_CN(ss))) {
							iristk.situated.SystemAgentFlow.say state184 = agent.new say();
							StringCreator string185 = new StringCreator();
							string185.append("抱歉，我没有理解您说的话。");
							state184.setText(string185.toString());
							if (!flowThread.callState(state184, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 618, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 620
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 621
						} else {
							iristk.situated.SystemAgentFlow.say state186 = agent.new say();
							state186.setText(info.findroom_CN(ss));
							if (!flowThread.callState(state186, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 618, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 623
							CheckAgain_CN state187 = new CheckAgain_CN();
							flowThread.gotoState(state187, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 623, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 616, 42));
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
			// Line: 630
			try {
				EXECUTION: {
					int count = getCount(258904812) + 1;
					incrCount(258904812);
					iristk.situated.SystemAgentFlow.say state188 = agent.new say();
					state188.setText(weather.getweather_CN());
					if (!flowThread.callState(state188, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 630, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 632
					CheckAgain_CN state189 = new CheckAgain_CN();
					flowThread.gotoState(state189, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 632, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 630, 12));
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
			// Line: 637
			try {
				EXECUTION: {
					int count = getCount(348451806) + 1;
					incrCount(348451806);
					// Line: 638
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					iristk.situated.SystemAgentFlow.prompt state190 = agent.new prompt();
					StringCreator string191 = new StringCreator();
					string191.append("您需要几点叫您？");
					state190.setText(string191.toString());
					if (!flowThread.callState(state190, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 637, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 642
			try {
				count = getCount(994772836) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") || event.has("sem:number")) {
						incrCount(994772836);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 643
							call.putIfNotNull("minute", 0);
							// Line: 644
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 645
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state192 = agent.new say();
								StringCreator string193 = new StringCreator();
								string193.append("对不起这是无效的时间。");
								state192.setText(string193.toString());
								if (!flowThread.callState(state192, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 645, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 647
							} else if (num > 12) {
								// Line: 648
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 650
							} else {
								// Line: 651
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 652
								if (event.has("sem:apm")) {
									// Line: 653
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 656
							if (event.has("sem:date")) {
								// Line: 657
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 659
							checkcall_CN state194 = new checkcall_CN();
							flowThread.gotoState(state194, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 659, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 642, 81));
			}
			// Line: 662
			try {
				count = getCount(642612204) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(642612204);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 663
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 664
							call.putIfNotNull("minute", 30);
							// Line: 665
							if (event.has("sem:past")) {
								// Line: 666
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state195 = agent.new say();
									StringCreator string196 = new StringCreator();
									string196.append("对不起这是无效的时间。");
									state195.setText(string196.toString());
									if (!flowThread.callState(state195, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 666, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 668
								} else if (num > 11) {
									// Line: 669
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 670
								} else {
									// Line: 671
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 672
									if (event.has("sem:apm")) {
										// Line: 673
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 676
								if (event.has("sem:date")) {
									// Line: 677
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 679
								checkcall_CN state197 = new checkcall_CN();
								flowThread.gotoState(state197, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 679, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 682
							if (event.has("sem:to")) {
								// Line: 683
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state198 = agent.new say();
									StringCreator string199 = new StringCreator();
									string199.append("对不起这是无效的时间。");
									state198.setText(string199.toString());
									if (!flowThread.callState(state198, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 683, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 685
								} else if (num > 12) {
									// Line: 686
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 687
								} else {
									// Line: 688
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 689
									if (event.has("sem:apm")) {
										// Line: 690
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 693
								if (event.has("sem:date")) {
									// Line: 694
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 696
								checkcall_CN state200 = new checkcall_CN();
								flowThread.gotoState(state200, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 696, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 662, 81));
			}
			// Line: 700
			try {
				count = getCount(1367010166) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1367010166);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 701
							CheckAgain_CN state201 = new CheckAgain_CN();
							flowThread.gotoState(state201, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 701, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 700, 57));
			}
			// Line: 704
			try {
				count = getCount(1544921635) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1544921635);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 705
							checkcall_CN state202 = new checkcall_CN();
							flowThread.gotoState(state202, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 705, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 704, 61));
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
			// Line: 711
			try {
				EXECUTION: {
					int count = getCount(1189588052) + 1;
					incrCount(1189588052);
					// Line: 712
					if (!call.has("hour")) {
						// Line: 713
						askhour_CN state203 = new askhour_CN();
						flowThread.gotoState(state203, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 713, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 714
					} else if (!call.has("minute")) {
						// Line: 715
						askminute_CN state204 = new askminute_CN();
						flowThread.gotoState(state204, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 715, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 716
					} else if (!call.has("apm")) {
						// Line: 717
						askapm_CN state205 = new askapm_CN();
						flowThread.gotoState(state205, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 717, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 718
					} else if (!call.has("date")) {
						// Line: 719
						askdate_CN state206 = new askdate_CN();
						flowThread.gotoState(state206, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 719, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 720
					} else {
						// Line: 721
						calldone_CN state207 = new calldone_CN();
						flowThread.gotoState(state207, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 721, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 711, 12));
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
			// Line: 727
			try {
				EXECUTION: {
					int count = getCount(382168493) + 1;
					incrCount(382168493);
					iristk.situated.SystemAgentFlow.prompt state208 = agent.new prompt();
					StringCreator string209 = new StringCreator();
					string209.append("请设置小时数。");
					state208.setText(string209.toString());
					if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 727, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 727, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 730
			try {
				count = getCount(154096414) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(154096414);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 731
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 732
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state210 = agent.new say();
								StringCreator string211 = new StringCreator();
								string211.append("对不起这是无效的时间。");
								state210.setText(string211.toString());
								if (!flowThread.callState(state210, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 732, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 734
							} else if ( num > 11 ) {
								// Line: 735
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 736
							} else {
								// Line: 737
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 739
							checkcall_CN state212 = new checkcall_CN();
							flowThread.gotoState(state212, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 739, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 730, 61));
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
			// Line: 744
			try {
				EXECUTION: {
					int count = getCount(2009751991) + 1;
					incrCount(2009751991);
					iristk.situated.SystemAgentFlow.prompt state213 = agent.new prompt();
					StringCreator string214 = new StringCreator();
					string214.append("请设置分钟数。");
					state213.setText(string214.toString());
					if (!flowThread.callState(state213, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 744, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 744, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 747
			try {
				count = getCount(519498791) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(519498791);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 748
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 749
							checkcall_CN state215 = new checkcall_CN();
							flowThread.gotoState(state215, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 749, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 747, 61));
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
			// Line: 754
			try {
				EXECUTION: {
					int count = getCount(2015634456) + 1;
					incrCount(2015634456);
					iristk.situated.SystemAgentFlow.prompt state216 = agent.new prompt();
					StringCreator string217 = new StringCreator();
					string217.append("请问是上午还是下午?");
					state216.setText(string217.toString());
					if (!flowThread.callState(state216, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 754, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 754, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 757
			try {
				count = getCount(208773145) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(208773145);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 758
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 759
							checkcall_CN state218 = new checkcall_CN();
							flowThread.gotoState(state218, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 759, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 757, 58));
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
			// Line: 764
			try {
				EXECUTION: {
					int count = getCount(1745168547) + 1;
					incrCount(1745168547);
					iristk.situated.SystemAgentFlow.prompt state219 = agent.new prompt();
					StringCreator string220 = new StringCreator();
					string220.append("请问是今天还是明天？");
					state219.setText(string220.toString());
					if (!flowThread.callState(state219, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 764, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 764, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 767
			try {
				count = getCount(774904645) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(774904645);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 768
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 769
							checkcall_CN state221 = new checkcall_CN();
							flowThread.gotoState(state221, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 769, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 767, 59));
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
			// Line: 774
			try {
				EXECUTION: {
					int count = getCount(2007621638) + 1;
					incrCount(2007621638);
					// Line: 775
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state222 = agent.new prompt();
					state222.setText(info.timeconfirm_CN(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state222, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 774, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 774, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 779
			try {
				count = getCount(553935706) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(553935706);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 780
							callroom_CN state223 = new callroom_CN();
							flowThread.gotoState(state223, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 780, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 779, 58));
			}
			// Line: 782
			try {
				count = getCount(693778706) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(693778706);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 783
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 784
							MorningCall_CN state224 = new MorningCall_CN();
							flowThread.gotoState(state224, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 784, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 782, 57));
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
			// Line: 789
			try {
				EXECUTION: {
					int count = getCount(629381562) + 1;
					incrCount(629381562);
					iristk.situated.SystemAgentFlow.prompt state225 = agent.new prompt();
					StringCreator string226 = new StringCreator();
					string226.append("请问您的房间号是多少？");
					state225.setText(string226.toString());
					if (!flowThread.callState(state225, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 789, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 789, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 792
			try {
				count = getCount(644880161) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(644880161);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 793
						String sss = event.get("text").toString();
						// Line: 794
						if (eq("Sorry",info.callroom_CN(sss))) {
							iristk.situated.SystemAgentFlow.say state227 = agent.new say();
							StringCreator string228 = new StringCreator();
							string228.append("抱歉，我没有理解您说的话。");
							state227.setText(string228.toString());
							if (!flowThread.callState(state227, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 794, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 796
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 796, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 797
						} else {
							iristk.situated.SystemAgentFlow.say state229 = agent.new say();
							state229.setText(info.callroom_CN(sss));
							if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 794, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 799
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 800
							roomconfirm_CN state230 = new roomconfirm_CN();
							flowThread.gotoState(state230, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 800, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 792, 36));
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
			// Line: 806
			try {
				EXECUTION: {
					int count = getCount(585679603) + 1;
					incrCount(585679603);
					iristk.situated.SystemAgentFlow.listen state231 = agent.new listen();
					if (!flowThread.callState(state231, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 806, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 806, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 809
			try {
				count = getCount(1954769796) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1954769796);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 810
							call.remove("room");
							// Line: 811
							callroom_CN state232 = new callroom_CN();
							flowThread.gotoState(state232, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 811, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 809, 57));
			}
			// Line: 813
			try {
				count = getCount(1216100086) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1216100086);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 814
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 817
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 818
							CheckAgain_CN state233 = new CheckAgain_CN();
							flowThread.gotoState(state233, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 818, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 813, 58));
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
			// Line: 827
			try {
				EXECUTION: {
					int count = getCount(929644875) + 1;
					incrCount(929644875);
					iristk.situated.SystemAgentFlow.prompt state234 = agent.new prompt();
					StringCreator string235 = new StringCreator();
					string235.append("您还需要其他帮助吗？");
					state234.setText(string235.toString());
					if (!flowThread.callState(state234, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 827, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 827, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 830
			try {
				count = getCount(291090483) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(291090483);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state236 = agent.new say();
							StringCreator string237 = new StringCreator();
							string237.append("好的");
							state236.setText(string237.toString());
							if (!flowThread.callState(state236, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 830, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 832
							Start_CN state238 = new Start_CN();
							flowThread.gotoState(state238, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 832, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 830, 58));
			}
			// Line: 834
			try {
				count = getCount(716696669) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(716696669);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state239 = agent.new say();
							StringCreator string240 = new StringCreator();
							string240.append("好的");
							state239.setText(string240.toString());
							if (!flowThread.callState(state239, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 834, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 836
							Goodbye_CN state241 = new Goodbye_CN();
							flowThread.gotoState(state241, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 836, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 834, 57));
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
			// Line: 841
			try {
				count = getCount(638015263) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(638015263);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state242 = agent.new gesture();
							state242.setName("smile");
							if (!flowThread.callState(state242, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 841, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 841, 102));
			}
			// Line: 844
			try {
				count = getCount(868717190) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(868717190);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state243 = agent.new say();
						StringCreator string244 = new StringCreator();
						string244.append("抱歉，我没有理解您说的话。");
						state243.setText(string244.toString());
						if (!flowThread.callState(state243, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 844, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 846
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 846, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 844, 36));
			}
			// Line: 848
			try {
				count = getCount(1215252631) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1215252631);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state245 = agent.new attendOther();
						state245.setMode("eyes");
						if (!flowThread.callState(state245, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 848, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state246 = agent.new say();
						StringCreator string247 = new StringCreator();
						string247.append("对不起，我现在没有问您。");
						state246.setText(string247.toString());
						if (!flowThread.callState(state246, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 848, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state248 = agent.new attendOther();
						state248.setMode("eyes");
						if (!flowThread.callState(state248, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 848, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 852
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 852, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 848, 41));
			}
			// Line: 854
			try {
				count = getCount(1536211591) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1536211591);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state249 = agent.new say();
						StringCreator string250 = new StringCreator();
						string250.append("请不要同时说话。");
						state249.setText(string250.toString());
						if (!flowThread.callState(state249, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 854, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 856
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 856, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 854, 42));
			}
			// Line: 858
			try {
				count = getCount(986873723) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(986873723);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state251 = agent.new say();
						StringCreator string252 = new StringCreator();
						string252.append("抱歉，我没有听到任何话。");
						state251.setText(string252.toString());
						if (!flowThread.callState(state251, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 858, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 860
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 860, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 858, 38));
			}
			// Line: 862
			try {
				count = getCount(1379625883) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1379625883);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state253 = agent.new say();
							StringCreator string254 = new StringCreator();
							string254.append("再见。");
							state253.setText(string254.toString());
							if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 862, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 864
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state255 = agent.new attendRandom();
								if (!flowThread.callState(state255, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 864, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 866
								Start_CN state256 = new Start_CN();
								flowThread.gotoState(state256, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 866, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 867
							} else {
								// Line: 868
								Idle state257 = new Idle();
								flowThread.gotoState(state257, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 868, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 862, 69));
			}
			// Line: 871
			try {
				count = getCount(1237034160) + 1;
				if (event.triggers("repeat")) {
					incrCount(1237034160);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 872
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 872, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 871, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
