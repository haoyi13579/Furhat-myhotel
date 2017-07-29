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
					int count = getCount(300752315) + 1;
					incrCount(300752315);
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
				count = getCount(522727844) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(522727844);
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
					int count = getCount(1164970172) + 1;
					incrCount(1164970172);
					// Line: 38
					lang = "en";
					// Line: 39
					Event sendEvent5 = new Event("action.context.default");
					sendEvent5.putIfNotNull("context", "default");
					flowRunner.sendEvent(sendEvent5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 39, 65)));
					// Line: 40
					Event sendEvent6 = new Event("action.voice");
					sendEvent6.putIfNotNull("name", "David");
					flowRunner.sendEvent(sendEvent6, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 49)));
					// Line: 41
					Start state7 = new Start();
					flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 41, 25)));
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
					int count = getCount(774983595) + 1;
					incrCount(774983595);
					iristk.situated.SystemAgentFlow.say state8 = agent.new say();
					StringCreator string9 = new StringCreator();
					string9.append("What can I do for you?");
					state8.setText(string9.toString());
					if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 66, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state10 = agent.new listen();
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 66, 12)))) {
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
			// Line: 75
			try {
				count = getCount(20791829) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(20791829);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 77
							if (event.has("sem:natural")) {
								// Line: 78
								Nature state11 = new Nature();
								flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 78, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 79
							} else if (event.has("sem:historical")) {
								// Line: 80
								History state12 = new History();
								flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 80, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 81
							} else if (event.has("sem:popular")) {
								// Line: 82
								Popular state13 = new Popular();
								flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 82, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 83
							} else {
								// Line: 84
								QueryAttr state14 = new QueryAttr();
								flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 84, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 75, 68));
			}
			// Line: 88
			try {
				count = getCount(1122700124) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1122700124);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 89
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state15 = agent.new say();
								StringCreator string16 = new StringCreator();
								string16.append("The trans detail part");
								state15.setText(string16.toString());
								if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 89, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								iristk.situated.SystemAgentFlow.say state17 = agent.new say();
								state17.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 89, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 92
								CheckAgain state18 = new CheckAgain();
								flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 92, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 93
							} else {
								iristk.situated.SystemAgentFlow.say state19 = agent.new say();
								StringCreator string20 = new StringCreator();
								string20.append("The trans second part");
								state19.setText(string20.toString());
								if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 89, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 95
								QueryTrans state21 = new QueryTrans();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 95, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 88, 71));
			}
			// Line: 99
			try {
				count = getCount(832868350) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(832868350);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 101
							QueryRoom state22 = new QueryRoom();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 101, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 99, 62));
			}
			// Line: 104
			try {
				count = getCount(9716036) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(9716036);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 105
							QueryWeather state23 = new QueryWeather();
							flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 105, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 104, 62));
			}
			// Line: 108
			try {
				count = getCount(32703797) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(32703797);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 109
							MorningCall state24 = new MorningCall();
							flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 109, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 108, 59));
			}
			// Line: 112
			try {
				count = getCount(1013692623) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(1013692623);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state25 = agent.new say();
							StringCreator string26 = new StringCreator();
							string26.append("Okay");
							state25.setText(string26.toString());
							if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 112, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 114
							Goodbye state27 = new Goodbye();
							flowThread.gotoState(state27, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 114, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 112, 59));
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
			// Line: 122
			try {
				EXECUTION: {
					int count = getCount(2024273422) + 1;
					incrCount(2024273422);
					iristk.situated.SystemAgentFlow.say state28 = agent.new say();
					StringCreator string29 = new StringCreator();
					string29.append("Goodbye.");
					state28.setText(string29.toString());
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 122, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state30 = agent.new say();
					StringCreator string31 = new StringCreator();
					string31.append("Please leave the detection area");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 122, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 125
					iristk.flow.DialogFlow.wait waitState32 = new iristk.flow.DialogFlow.wait();
					waitState32.setMsec(2000);
					if (!flowThread.callState(waitState32, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 125, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 126
					Idle state33 = new Idle();
					flowThread.gotoState(state33, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 126, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 122, 12));
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
			// Line: 133
			try {
				EXECUTION: {
					int count = getCount(1552104910) + 1;
					incrCount(1552104910);
					iristk.situated.SystemAgentFlow.say state34 = agent.new say();
					StringCreator string35 = new StringCreator();
					string35.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 133, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state36 = agent.new listen();
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 133, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 133, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 139
			try {
				count = getCount(420299111) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(420299111);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 140
							Nature state37 = new Nature();
							flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 140, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 139, 68));
			}
			// Line: 142
			try {
				count = getCount(145056289) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(145056289);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 143
							History state38 = new History();
							flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 143, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 142, 71));
			}
			// Line: 145
			try {
				count = getCount(1048061193) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(1048061193);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 146
							Popular state39 = new Popular();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 146, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 145, 66));
			}
			// Line: 148
			try {
				count = getCount(1595167888) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1595167888);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 149
							CheckAgain state40 = new CheckAgain();
							flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 149, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 148, 61));
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
			// Line: 154
			try {
				EXECUTION: {
					int count = getCount(1732602544) + 1;
					incrCount(1732602544);
					iristk.situated.SystemAgentFlow.say state41 = agent.new say();
					state41.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 154, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 156
					Attrdetial state42 = new Attrdetial();
					flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 156, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 154, 16));
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
			// Line: 161
			try {
				EXECUTION: {
					int count = getCount(481427706) + 1;
					incrCount(481427706);
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					state43.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 161, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 163
					Attrdetial state44 = new Attrdetial();
					flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 163, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 161, 16));
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
			// Line: 168
			try {
				EXECUTION: {
					int count = getCount(731758537) + 1;
					incrCount(731758537);
					iristk.situated.SystemAgentFlow.say state45 = agent.new say();
					state45.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 168, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 170
					Attrdetial state46 = new Attrdetial();
					flowThread.gotoState(state46, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 170, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 168, 16));
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
			// Line: 175
			try {
				EXECUTION: {
					int count = getCount(1856534251) + 1;
					incrCount(1856534251);
					iristk.situated.SystemAgentFlow.say state47 = agent.new say();
					StringCreator string48 = new StringCreator();
					string48.append("If you want more details for attractions,please say the name.");
					state47.setText(string48.toString());
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 175, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state49 = agent.new listen();
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 175, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 175, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 179
			try {
				count = getCount(672001792) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(672001792);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 180
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state50 = agent.new say();
							state50.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 179, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 182
							CheckAgain state51 = new CheckAgain();
							flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 182, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 179, 69));
			}
			// Line: 184
			try {
				count = getCount(625715672) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(625715672);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 185
							CheckAgain state52 = new CheckAgain();
							flowThread.gotoState(state52, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 185, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 61));
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
			// Line: 191
			try {
				EXECUTION: {
					int count = getCount(750565632) + 1;
					incrCount(750565632);
					iristk.situated.SystemAgentFlow.say state53 = agent.new say();
					StringCreator string54 = new StringCreator();
					string54.append("Where do you want to go?");
					state53.setText(string54.toString());
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 191, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state55 = agent.new listen();
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 191, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 191, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 195
			try {
				count = getCount(1421987878) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attra")) {
						incrCount(1421987878);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state56 = agent.new say();
							state56.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
							if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 195, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 197
							CheckAgain state57 = new CheckAgain();
							flowThread.gotoState(state57, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 197, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 195, 60));
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
			// Line: 203
			try {
				EXECUTION: {
					int count = getCount(379298881) + 1;
					incrCount(379298881);
					iristk.situated.SystemAgentFlow.say state58 = agent.new say();
					StringCreator string59 = new StringCreator();
					string59.append("Which room do you want to find?");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 203, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state60 = agent.new listen();
					if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 203, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 203, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 207
			try {
				count = getCount(1283524180) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(1283524180);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state61 = agent.new say();
							StringCreator string62 = new StringCreator();
							string62.append("It is on the first floor");
							state61.setText(string62.toString());
							if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 207, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 209
							CheckAgain state63 = new CheckAgain();
							flowThread.gotoState(state63, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 209, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 207, 70));
			}
			// Line: 211
			try {
				count = getCount(632695536) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(632695536);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 212
						String ss = event.get("text").toString();
						// Line: 213
						if (eq("Sorry",info.findroom(ss))) {
							iristk.situated.SystemAgentFlow.say state64 = agent.new say();
							StringCreator string65 = new StringCreator();
							string65.append("Sorry, I didn't get that.");
							state64.setText(string65.toString());
							if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 213, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 215
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 215, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 216
						} else {
							iristk.situated.SystemAgentFlow.say state66 = agent.new say();
							state66.setText(info.findroom(ss));
							if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 213, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 218
							CheckAgain state67 = new CheckAgain();
							flowThread.gotoState(state67, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 211, 42));
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
			// Line: 225
			try {
				EXECUTION: {
					int count = getCount(262654434) + 1;
					incrCount(262654434);
					iristk.situated.SystemAgentFlow.say state68 = agent.new say();
					state68.setText(weather.getweather());
					if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 225, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 227
					CheckAgain state69 = new CheckAgain();
					flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 227, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 225, 12));
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
			// Line: 233
			try {
				EXECUTION: {
					int count = getCount(39285407) + 1;
					incrCount(39285407);
					// Line: 234
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
					iristk.situated.SystemAgentFlow.say state70 = agent.new say();
					StringCreator string71 = new StringCreator();
					string71.append("When do you want to awake?");
					state70.setText(string71.toString());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 233, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state72 = agent.new listen();
					if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 233, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 233, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 239
			try {
				count = getCount(1865798325) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:clock") && event.has("sem:number")) {
						incrCount(1865798325);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 240
							call.putIfNotNull("minute", 0);
							// Line: 241
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 242
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state73 = agent.new say();
								StringCreator string74 = new StringCreator();
								string74.append("Sorry the time is invalid.");
								state73.setText(string74.toString());
								if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 242, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 244
							} else if (num > 12) {
								// Line: 245
								call.putIfNotNull("hour", event.get("sem:number"));Object apm="pm";call.putIfNotNull("apm", apm);
								// Line: 247
							} else {
								// Line: 248
								call.putIfNotNull("hour", event.get("sem:number"));
								// Line: 249
								if (event.has("sem:apm")) {
									// Line: 250
									call.putIfNotNull("apm", event.get("sem:apm"));
								}
							}
							// Line: 253
							if (event.has("sem:date")) {
								// Line: 254
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 256
							checkcall state75 = new checkcall();
							flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 256, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 239, 82));
			}
			// Line: 259
			try {
				count = getCount(1284040449) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:half") && event.has("sem:number")) {
						incrCount(1284040449);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 260
							Object temp=event.get("sem:number"); String temps=temp.toString(); int num=Integer.parseInt(temps);
							// Line: 261
							call.putIfNotNull("minute", 30);
							// Line: 262
							if (event.has("sem:past")) {
								// Line: 263
								if ( num > 23 ) {
									iristk.situated.SystemAgentFlow.say state76 = agent.new say();
									StringCreator string77 = new StringCreator();
									string77.append("Sorry the time is invalid.");
									state76.setText(string77.toString());
									if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 263, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 265
								} else if (num > 11) {
									// Line: 266
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 267
								} else {
									// Line: 268
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 269
									if (event.has("sem:apm")) {
										// Line: 270
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 273
								if (event.has("sem:date")) {
									// Line: 274
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 276
								checkcall state78 = new checkcall();
								flowThread.gotoState(state78, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 276, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 279
							if (event.has("sem:to")) {
								// Line: 280
								if ( num > 24 ) {
									iristk.situated.SystemAgentFlow.say state79 = agent.new say();
									StringCreator string80 = new StringCreator();
									string80.append("Sorry the time is invalid.");
									state79.setText(string80.toString());
									if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 280, 30)))) {
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									// Line: 282
								} else if (num > 12) {
									// Line: 283
									call.putIfNotNull("hour", event.get("sem:number"));call.putIfNotNull("apm", "pm");
									// Line: 284
								} else {
									// Line: 285
									call.putIfNotNull("hour", event.get("sem:number"));
									// Line: 286
									if (event.has("sem:apm")) {
										// Line: 287
										call.putIfNotNull("amp", event.get("sem:apm"));
									}
								}
								// Line: 290
								if (event.has("sem:date")) {
									// Line: 291
									call.putIfNotNull("date", event.get("sem:date"));
								}
								// Line: 293
								checkcall state81 = new checkcall();
								flowThread.gotoState(state81, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 293, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 259, 81));
			}
			// Line: 297
			try {
				count = getCount(1044107448) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:noon")) {
						incrCount(1044107448);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 298
							call.putIfNotNull("hour", 12); call.putIfNotNull("minute", 0); call.putIfNotNull("apm", "am");
							// Line: 299
							if (event.has("sem:date")) {
								// Line: 300
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 302
							checkcall state82 = new checkcall();
							flowThread.gotoState(state82, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 302, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 297, 59));
			}
			// Line: 305
			try {
				count = getCount(1777629324) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:midnight")) {
						incrCount(1777629324);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 306
							call.putIfNotNull("hour", 0); call.putIfNotNull("minute", 0); call.putIfNotNull("apm", "am");
							// Line: 307
							if (event.has("sem:date")) {
								// Line: 308
								call.putIfNotNull("date", event.get("sem:date"));
							}
							// Line: 310
							checkcall state83 = new checkcall();
							flowThread.gotoState(state83, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 310, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 305, 63));
			}
			// Line: 313
			try {
				count = getCount(946009200) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(946009200);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 314
							CheckAgain state84 = new CheckAgain();
							flowThread.gotoState(state84, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 314, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 313, 57));
			}
			// Line: 317
			try {
				count = getCount(831558982) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(831558982);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 318
							checkcall state85 = new checkcall();
							flowThread.gotoState(state85, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 318, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 317, 61));
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
			// Line: 324
			try {
				EXECUTION: {
					int count = getCount(113079996) + 1;
					incrCount(113079996);
					// Line: 325
					if (!call.has("hour")) {
						// Line: 326
						askhour state86 = new askhour();
						flowThread.gotoState(state86, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 326, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 327
					} else if (!call.has("minute")) {
						// Line: 328
						askminute state87 = new askminute();
						flowThread.gotoState(state87, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 328, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 329
					} else if (!call.has("apm")) {
						// Line: 330
						askapm state88 = new askapm();
						flowThread.gotoState(state88, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 330, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 331
					} else if (!call.has("date")) {
						// Line: 332
						askdate state89 = new askdate();
						flowThread.gotoState(state89, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 332, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 333
					} else {
						// Line: 334
						calldone state90 = new calldone();
						flowThread.gotoState(state90, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 334, 29)));
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
			// Line: 340
			try {
				EXECUTION: {
					int count = getCount(1359847840) + 1;
					incrCount(1359847840);
					iristk.situated.SystemAgentFlow.say state91 = agent.new say();
					StringCreator string92 = new StringCreator();
					string92.append("Please say the hour of the morning call.");
					state91.setText(string92.toString());
					if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 340, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state93 = agent.new listen();
					if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 340, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 340, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 344
			try {
				count = getCount(211025602) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(211025602);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 345
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 346
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state94 = agent.new say();
								StringCreator string95 = new StringCreator();
								string95.append("Sorry the time is invalid.");
								state94.setText(string95.toString());
								if (!flowThread.callState(state94, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 346, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 348
							} else if ( num > 11 ) {
								// Line: 349
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 350
							} else {
								// Line: 351
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 353
							checkcall state96 = new checkcall();
							flowThread.gotoState(state96, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 353, 29)));
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
			// Line: 358
			try {
				EXECUTION: {
					int count = getCount(80439906) + 1;
					incrCount(80439906);
					iristk.situated.SystemAgentFlow.say state97 = agent.new say();
					StringCreator string98 = new StringCreator();
					string98.append("Please say the minute of the morning call.");
					state97.setText(string98.toString());
					if (!flowThread.callState(state97, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 358, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state99 = agent.new listen();
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 358, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 358, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 362
			try {
				count = getCount(1616366154) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1616366154);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 363
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 364
							checkcall state100 = new checkcall();
							flowThread.gotoState(state100, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 364, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 362, 61));
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
			// Line: 369
			try {
				EXECUTION: {
					int count = getCount(238509090) + 1;
					incrCount(238509090);
					iristk.situated.SystemAgentFlow.say state101 = agent.new say();
					StringCreator string102 = new StringCreator();
					string102.append("Is it a.m. or p.m.?");
					state101.setText(string102.toString());
					if (!flowThread.callState(state101, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 369, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state103 = agent.new listen();
					if (!flowThread.callState(state103, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 369, 12)))) {
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
			// Line: 373
			try {
				count = getCount(965323270) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(965323270);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 374
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 375
							checkcall state104 = new checkcall();
							flowThread.gotoState(state104, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 375, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 373, 58));
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
			// Line: 380
			try {
				EXECUTION: {
					int count = getCount(427699275) + 1;
					incrCount(427699275);
					iristk.situated.SystemAgentFlow.say state105 = agent.new say();
					StringCreator string106 = new StringCreator();
					string106.append("Do we need to call you at today or tomorrow?");
					state105.setText(string106.toString());
					if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 380, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state107 = agent.new listen();
					if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 380, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 380, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 384
			try {
				count = getCount(1442217983) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1442217983);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 385
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 386
							checkcall state108 = new checkcall();
							flowThread.gotoState(state108, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 386, 29)));
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
					int count = getCount(2066069472) + 1;
					incrCount(2066069472);
					// Line: 392
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.say state109 = agent.new say();
					state109.setText(info.timeconfirm(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state109, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 391, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state110 = agent.new listen();
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
			// Line: 397
			try {
				count = getCount(1065825123) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1065825123);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 398
							callroom state111 = new callroom();
							flowThread.gotoState(state111, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 398, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 397, 58));
			}
			// Line: 400
			try {
				count = getCount(622640701) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(622640701);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 401
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 402
							MorningCall state112 = new MorningCall();
							flowThread.gotoState(state112, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 402, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 400, 57));
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
			// Line: 407
			try {
				EXECUTION: {
					int count = getCount(1929790224) + 1;
					incrCount(1929790224);
					iristk.situated.SystemAgentFlow.say state113 = agent.new say();
					StringCreator string114 = new StringCreator();
					string114.append("Which room do you live in?");
					state113.setText(string114.toString());
					if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 407, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state115 = agent.new listen();
					if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 407, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 407, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 411
			try {
				count = getCount(1110048708) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1110048708);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 412
						String sss = event.get("text").toString();
						// Line: 413
						if (eq("Sorry",info.callroom(sss))) {
							iristk.situated.SystemAgentFlow.say state116 = agent.new say();
							StringCreator string117 = new StringCreator();
							string117.append("Sorry, I didn't get that.");
							state116.setText(string117.toString());
							if (!flowThread.callState(state116, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 413, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 415
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 415, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 416
						} else {
							iristk.situated.SystemAgentFlow.say state118 = agent.new say();
							state118.setText(info.callroom(sss));
							if (!flowThread.callState(state118, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 413, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 418
							roomconfirm state119 = new roomconfirm();
							flowThread.gotoState(state119, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 418, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 411, 36));
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
			// Line: 424
			try {
				EXECUTION: {
					int count = getCount(113782286) + 1;
					incrCount(113782286);
					iristk.situated.SystemAgentFlow.listen state120 = agent.new listen();
					if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 424, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 424, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 427
			try {
				count = getCount(262300091) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(262300091);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 428
							callroom state121 = new callroom();
							flowThread.gotoState(state121, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 428, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 427, 57));
			}
			// Line: 430
			try {
				count = getCount(1929879105) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1929879105);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 431
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							// Line: 433
							CheckAgain state122 = new CheckAgain();
							flowThread.gotoState(state122, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 433, 30)));
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
			// Line: 441
			try {
				EXECUTION: {
					int count = getCount(342500563) + 1;
					incrCount(342500563);
					iristk.situated.SystemAgentFlow.say state123 = agent.new say();
					StringCreator string124 = new StringCreator();
					string124.append("Do you need other help?");
					state123.setText(string124.toString());
					if (!flowThread.callState(state123, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 441, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state125 = agent.new listen();
					if (!flowThread.callState(state125, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 441, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 441, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 445
			try {
				count = getCount(1675002817) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1675002817);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state126 = agent.new say();
							StringCreator string127 = new StringCreator();
							string127.append("Okay");
							state126.setText(string127.toString());
							if (!flowThread.callState(state126, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 445, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 447
							Start state128 = new Start();
							flowThread.gotoState(state128, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 447, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 445, 58));
			}
			// Line: 449
			try {
				count = getCount(1228105864) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1228105864);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state129 = agent.new say();
							StringCreator string130 = new StringCreator();
							string130.append("Okay");
							state129.setText(string130.toString());
							if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 449, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 451
							Goodbye state131 = new Goodbye();
							flowThread.gotoState(state131, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 451, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 449, 57));
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
			// Line: 456
			try {
				count = getCount(68014804) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(68014804);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state132 = agent.new gesture();
							state132.setName("smile");
							if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 456, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 456, 102));
			}
			// Line: 459
			try {
				count = getCount(1453891061) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1453891061);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state133 = agent.new say();
						StringCreator string134 = new StringCreator();
						string134.append("Sorry, I didn't get that.");
						state133.setText(string134.toString());
						if (!flowThread.callState(state133, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 459, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 461
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 461, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 459, 36));
			}
			// Line: 463
			try {
				count = getCount(2072782111) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(2072782111);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state135 = agent.new attendOther();
						state135.setMode("eyes");
						if (!flowThread.callState(state135, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 463, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state136 = agent.new say();
						StringCreator string137 = new StringCreator();
						string137.append("I didn't ask you.");
						state136.setText(string137.toString());
						if (!flowThread.callState(state136, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 463, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state138 = agent.new attendOther();
						state138.setMode("eyes");
						if (!flowThread.callState(state138, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 463, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 467
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 467, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 463, 41));
			}
			// Line: 469
			try {
				count = getCount(61383479) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(61383479);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state139 = agent.new say();
						StringCreator string140 = new StringCreator();
						string140.append("Don't speak at the same time.");
						state139.setText(string140.toString());
						if (!flowThread.callState(state139, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 469, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 471
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 471, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 469, 42));
			}
			// Line: 473
			try {
				count = getCount(841654912) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(841654912);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state141 = agent.new say();
						StringCreator string142 = new StringCreator();
						string142.append("Sorry, I didn't hear anything.");
						state141.setText(string142.toString());
						if (!flowThread.callState(state141, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 473, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 475
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 475, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 473, 38));
			}
			// Line: 477
			try {
				count = getCount(188868356) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(188868356);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state143 = agent.new say();
							StringCreator string144 = new StringCreator();
							string144.append("Goodbye");
							state143.setText(string144.toString());
							if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 477, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 479
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state145 = agent.new attendRandom();
								if (!flowThread.callState(state145, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 479, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 481
								Start state146 = new Start();
								flowThread.gotoState(state146, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 481, 27)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 482
							} else {
								// Line: 483
								Idle state147 = new Idle();
								flowThread.gotoState(state147, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 483, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 477, 69));
			}
			// Line: 486
			try {
				count = getCount(1458652897) + 1;
				if (event.triggers("repeat")) {
					incrCount(1458652897);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 487
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 487, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 486, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start_CN extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 499
			try {
				EXECUTION: {
					int count = getCount(1535733944) + 1;
					incrCount(1535733944);
					iristk.situated.SystemAgentFlow.say state148 = agent.new say();
					StringCreator string149 = new StringCreator();
					string149.append("请问有什么可以帮到您的？");
					state148.setText(string149.toString());
					if (!flowThread.callState(state148, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 499, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state150 = agent.new listen();
					if (!flowThread.callState(state150, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 499, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 499, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 508
			try {
				count = getCount(118743910) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(118743910);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 510
							if (event.has("sem:natural")) {
								// Line: 511
								Nature_CN state151 = new Nature_CN();
								flowThread.gotoState(state151, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 511, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 512
							} else if (event.has("sem:historical")) {
								// Line: 513
								History_CN state152 = new History_CN();
								flowThread.gotoState(state152, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 513, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 514
							} else if (event.has("sem:popular")) {
								// Line: 515
								Popular_CN state153 = new Popular_CN();
								flowThread.gotoState(state153, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 515, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 516
							} else {
								// Line: 517
								QueryAttr_CN state154 = new QueryAttr_CN();
								flowThread.gotoState(state154, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 517, 35)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 508, 68));
			}
			// Line: 521
			try {
				count = getCount(1269685460) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1269685460);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 522
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state155 = agent.new say();
								state155.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state155, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 522, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 524
								CheckAgain_CN state156 = new CheckAgain_CN();
								flowThread.gotoState(state156, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 524, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 525
							} else {
								// Line: 526
								QueryTrans_CN state157 = new QueryTrans_CN();
								flowThread.gotoState(state157, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 526, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 521, 71));
			}
			// Line: 530
			try {
				count = getCount(2024180344) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(2024180344);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 531
							QueryRoom_CN state158 = new QueryRoom_CN();
							flowThread.gotoState(state158, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 531, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 530, 62));
			}
			// Line: 534
			try {
				count = getCount(409442493) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(409442493);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 535
							QueryWeather_CN state159 = new QueryWeather_CN();
							flowThread.gotoState(state159, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 535, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 534, 62));
			}
			// Line: 538
			try {
				count = getCount(1209101682) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(1209101682);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 539
							MorningCall_CN state160 = new MorningCall_CN();
							flowThread.gotoState(state160, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 539, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 538, 59));
			}
			// Line: 542
			try {
				count = getCount(355139252) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(355139252);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state161 = agent.new say();
							StringCreator string162 = new StringCreator();
							string162.append("好的");
							state161.setText(string162.toString());
							if (!flowThread.callState(state161, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 542, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 544
							Goodbye_CN state163 = new Goodbye_CN();
							flowThread.gotoState(state163, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 544, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 542, 59));
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
			// Line: 551
			try {
				EXECUTION: {
					int count = getCount(1145115472) + 1;
					incrCount(1145115472);
					iristk.situated.SystemAgentFlow.say state164 = agent.new say();
					StringCreator string165 = new StringCreator();
					string165.append("再见。");
					state164.setText(string165.toString());
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 551, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state166 = agent.new say();
					StringCreator string167 = new StringCreator();
					string167.append("请离开感应区域");
					state166.setText(string167.toString());
					if (!flowThread.callState(state166, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 551, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 554
					iristk.flow.DialogFlow.wait waitState168 = new iristk.flow.DialogFlow.wait();
					waitState168.setMsec(2000);
					if (!flowThread.callState(waitState168, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 554, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 555
					Idle state169 = new Idle();
					flowThread.gotoState(state169, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 555, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 551, 12));
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


	private class QueryAttr_CN extends Dialog {

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
					int count = getCount(1167468623) + 1;
					incrCount(1167468623);
					iristk.situated.SystemAgentFlow.say state170 = agent.new say();
					StringCreator string171 = new StringCreator();
					string171.append("您想参观那种景点？自然景点，历史景点还是热门景点？");
					state170.setText(string171.toString());
					if (!flowThread.callState(state170, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 562, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state172 = agent.new listen();
					if (!flowThread.callState(state172, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 562, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 562, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 568
			try {
				count = getCount(662251477) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(662251477);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 569
							Nature_CN state173 = new Nature_CN();
							flowThread.gotoState(state173, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 569, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 568, 68));
			}
			// Line: 571
			try {
				count = getCount(796398491) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(796398491);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 572
							History_CN state174 = new History_CN();
							flowThread.gotoState(state174, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 572, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 571, 71));
			}
			// Line: 574
			try {
				count = getCount(896618826) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(896618826);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 575
							Popular_CN state175 = new Popular_CN();
							flowThread.gotoState(state175, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 575, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 574, 66));
			}
			// Line: 577
			try {
				count = getCount(1195972735) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1195972735);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 578
							CheckAgain_CN state176 = new CheckAgain_CN();
							flowThread.gotoState(state176, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 578, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 577, 61));
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
			// Line: 583
			try {
				EXECUTION: {
					int count = getCount(1588802873) + 1;
					incrCount(1588802873);
					iristk.situated.SystemAgentFlow.say state177 = agent.new say();
					state177.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 583, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 585
					Attrdetial_CN state178 = new Attrdetial_CN();
					flowThread.gotoState(state178, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 585, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 583, 16));
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
			// Line: 590
			try {
				EXECUTION: {
					int count = getCount(1231072541) + 1;
					incrCount(1231072541);
					iristk.situated.SystemAgentFlow.say state179 = agent.new say();
					state179.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state179, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 590, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 592
					Attrdetial_CN state180 = new Attrdetial_CN();
					flowThread.gotoState(state180, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 592, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 590, 16));
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
			// Line: 597
			try {
				EXECUTION: {
					int count = getCount(456500692) + 1;
					incrCount(456500692);
					iristk.situated.SystemAgentFlow.say state181 = agent.new say();
					state181.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 597, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 599
					Attrdetial_CN state182 = new Attrdetial_CN();
					flowThread.gotoState(state182, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 599, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 597, 16));
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


	private class Attrdetial_CN extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 604
			try {
				EXECUTION: {
					int count = getCount(38885961) + 1;
					incrCount(38885961);
					iristk.situated.SystemAgentFlow.say state183 = agent.new say();
					StringCreator string184 = new StringCreator();
					string184.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state183.setText(string184.toString());
					if (!flowThread.callState(state183, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 604, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state185 = agent.new listen();
					if (!flowThread.callState(state185, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 604, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 604, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 608
			try {
				count = getCount(880559314) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(880559314);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 609
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state186 = agent.new say();
							state186.setText(info.detail_CN(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state186, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 608, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 611
							CheckAgain_CN state187 = new CheckAgain_CN();
							flowThread.gotoState(state187, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 611, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 608, 69));
			}
			// Line: 613
			try {
				count = getCount(1862060266) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1862060266);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 614
							CheckAgain_CN state188 = new CheckAgain_CN();
							flowThread.gotoState(state188, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 614, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 613, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryTrans_CN extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 620
			try {
				EXECUTION: {
					int count = getCount(1518123019) + 1;
					incrCount(1518123019);
					iristk.situated.SystemAgentFlow.say state189 = agent.new say();
					StringCreator string190 = new StringCreator();
					string190.append("您打算去哪里？");
					state189.setText(string190.toString());
					if (!flowThread.callState(state189, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state191 = agent.new listen();
					if (!flowThread.callState(state191, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 620, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 624
			try {
				count = getCount(1380941878) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attra")) {
						incrCount(1380941878);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state192 = agent.new say();
							state192.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attra")));
							if (!flowThread.callState(state192, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 624, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 626
							CheckAgain_CN state193 = new CheckAgain_CN();
							flowThread.gotoState(state193, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 626, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 624, 60));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryRoom_CN extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 632
			try {
				EXECUTION: {
					int count = getCount(856418577) + 1;
					incrCount(856418577);
					iristk.situated.SystemAgentFlow.say state194 = agent.new say();
					StringCreator string195 = new StringCreator();
					string195.append("您在找哪个房间？");
					state194.setText(string195.toString());
					if (!flowThread.callState(state194, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 632, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state196 = agent.new listen();
					if (!flowThread.callState(state196, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 632, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 632, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 636
			try {
				count = getCount(493588854) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(493588854);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state197 = agent.new say();
							StringCreator string198 = new StringCreator();
							string198.append("它在一楼。");
							state197.setText(string198.toString());
							if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 636, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 638
							CheckAgain_CN state199 = new CheckAgain_CN();
							flowThread.gotoState(state199, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 638, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 636, 70));
			}
			// Line: 640
			try {
				count = getCount(1599739788) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1599739788);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 641
						String ss = event.get("text").toString();
						iristk.situated.SystemAgentFlow.say state200 = agent.new say();
						state200.setText(info.findroom_CN(ss));
						if (!flowThread.callState(state200, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 640, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 643
						CheckAgain_CN state201 = new CheckAgain_CN();
						flowThread.gotoState(state201, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 643, 37)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 640, 42));
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
					int count = getCount(759426740) + 1;
					incrCount(759426740);
					iristk.situated.SystemAgentFlow.say state202 = agent.new say();
					state202.setText(weather.getweather_CN());
					if (!flowThread.callState(state202, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 649, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 651
					CheckAgain_CN state203 = new CheckAgain_CN();
					flowThread.gotoState(state203, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 651, 33)));
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


	private class MorningCall_CN extends State {

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
					int count = getCount(320323378) + 1;
					incrCount(320323378);
					iristk.situated.SystemAgentFlow.say state204 = agent.new say();
					StringCreator string205 = new StringCreator();
					string205.append("s");
					state204.setText(string205.toString());
					if (!flowThread.callState(state204, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 656, 12)))) {
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
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain_CN extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 665
			try {
				EXECUTION: {
					int count = getCount(1977567621) + 1;
					incrCount(1977567621);
					iristk.situated.SystemAgentFlow.say state206 = agent.new say();
					StringCreator string207 = new StringCreator();
					string207.append("您还需要其他帮助吗？");
					state206.setText(string207.toString());
					if (!flowThread.callState(state206, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 665, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state208 = agent.new listen();
					if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 665, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 665, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 669
			try {
				count = getCount(819492749) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(819492749);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state209 = agent.new say();
							StringCreator string210 = new StringCreator();
							string210.append("好的");
							state209.setText(string210.toString());
							if (!flowThread.callState(state209, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 669, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 671
							Start_CN state211 = new Start_CN();
							flowThread.gotoState(state211, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 671, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 669, 58));
			}
			// Line: 673
			try {
				count = getCount(555321447) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(555321447);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state212 = agent.new say();
							StringCreator string213 = new StringCreator();
							string213.append("好的");
							state212.setText(string213.toString());
							if (!flowThread.callState(state212, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 673, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 675
							Goodbye_CN state214 = new Goodbye_CN();
							flowThread.gotoState(state214, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 675, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 673, 57));
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
			// Line: 680
			try {
				count = getCount(114650915) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(114650915);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state215 = agent.new gesture();
							state215.setName("smile");
							if (!flowThread.callState(state215, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 680, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 680, 102));
			}
			// Line: 683
			try {
				count = getCount(1801622830) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1801622830);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state216 = agent.new say();
						StringCreator string217 = new StringCreator();
						string217.append("抱歉，我没有理解您说的话。");
						state216.setText(string217.toString());
						if (!flowThread.callState(state216, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 683, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 685
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 685, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 683, 36));
			}
			// Line: 687
			try {
				count = getCount(592387756) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(592387756);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state218 = agent.new attendOther();
						state218.setMode("eyes");
						if (!flowThread.callState(state218, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 687, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state219 = agent.new say();
						StringCreator string220 = new StringCreator();
						string220.append("对不起，我现在没有问您。");
						state219.setText(string220.toString());
						if (!flowThread.callState(state219, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 687, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state221 = agent.new attendOther();
						state221.setMode("eyes");
						if (!flowThread.callState(state221, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 687, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 691
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 691, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 687, 41));
			}
			// Line: 693
			try {
				count = getCount(1903881859) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1903881859);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state222 = agent.new say();
						StringCreator string223 = new StringCreator();
						string223.append("请不要同时说话。");
						state222.setText(string223.toString());
						if (!flowThread.callState(state222, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 693, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 695
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 695, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 693, 42));
			}
			// Line: 697
			try {
				count = getCount(2020271605) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2020271605);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state224 = agent.new say();
						StringCreator string225 = new StringCreator();
						string225.append("抱歉，我没有听到任何话。");
						state224.setText(string225.toString());
						if (!flowThread.callState(state224, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 697, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 699
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 699, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 697, 38));
			}
			// Line: 701
			try {
				count = getCount(653793631) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(653793631);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state226 = agent.new say();
							StringCreator string227 = new StringCreator();
							string227.append("再见。");
							state226.setText(string227.toString());
							if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 701, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 703
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state228 = agent.new attendRandom();
								if (!flowThread.callState(state228, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 703, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 705
								Start_CN state229 = new Start_CN();
								flowThread.gotoState(state229, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 705, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 706
							} else {
								// Line: 707
								Idle state230 = new Idle();
								flowThread.gotoState(state230, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 707, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 701, 69));
			}
			// Line: 710
			try {
				count = getCount(1466638273) + 1;
				if (event.triggers("repeat")) {
					incrCount(1466638273);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 711
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 711, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 710, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
