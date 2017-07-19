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
	private iristk.situated.SystemAgent system;
	private Integer number;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
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
		if (name.equals("system")) return this.system;
		if (name.equals("number")) return this.number;
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
			// Line: 19
			try {
				EXECUTION: {
					int count = getCount(507354637) + 1;
					incrCount(507354637);
					// Line: 20
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 20, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 22
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 22, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 23
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 20, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 19, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 27
			try {
				count = getCount(1166860622) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(1166860622);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 27, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 29
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 29, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 27, 36));
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
			// Line: 34
			try {
				EXECUTION: {
					int count = getCount(989051203) + 1;
					incrCount(989051203);
					iristk.situated.SystemAgentFlow.say state5 = agent.new say();
					StringCreator string6 = new StringCreator();
					string6.append("Hi there");
					state5.setText(string6.toString());
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 34, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 36
					Start state7 = new Start();
					flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 36, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 34, 12));
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
			// Line: 41
			try {
				EXECUTION: {
					int count = getCount(1069160879) + 1;
					incrCount(1069160879);
					iristk.situated.SystemAgentFlow.say state8 = agent.new say();
					StringCreator string9 = new StringCreator();
					string9.append("What can I do for you?");
					state8.setText(string9.toString());
					if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 41, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state10 = agent.new listen();
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 41, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 41, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 50
			try {
				count = getCount(413439674) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(413439674);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 52
							if (event.has("sem:natural")) {
								// Line: 53
								Nature state11 = new Nature();
								flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 53, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 54
							} else if (event.has("sem:historical")) {
								// Line: 55
								History state12 = new History();
								flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 55, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 56
							} else if (event.has("sem:popular")) {
								// Line: 57
								Popular state13 = new Popular();
								flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 57, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 58
							} else {
								// Line: 59
								QueryAttr state14 = new QueryAttr();
								flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 59, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 50, 68));
			}
			// Line: 63
			try {
				count = getCount(1866154330) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1866154330);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 64
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state15 = agent.new say();
								StringCreator string16 = new StringCreator();
								string16.append("The trans detail part");
								state15.setText(string16.toString());
								if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 64, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								iristk.situated.SystemAgentFlow.say state17 = agent.new say();
								state17.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 64, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 67
								CheckAgain state18 = new CheckAgain();
								flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 67, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 68
							} else {
								iristk.situated.SystemAgentFlow.say state19 = agent.new say();
								StringCreator string20 = new StringCreator();
								string20.append("The trans second part");
								state19.setText(string20.toString());
								if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 64, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 70
								QueryTrans state21 = new QueryTrans();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 70, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 63, 71));
			}
			// Line: 74
			try {
				count = getCount(526524417) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(526524417);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 76
							QueryRoom state22 = new QueryRoom();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 76, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 74, 62));
			}
			// Line: 79
			try {
				count = getCount(1840970918) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(1840970918);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 80
							QueryWeather state23 = new QueryWeather();
							flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 80, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 79, 62));
			}
			// Line: 83
			try {
				count = getCount(1088945290) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(1088945290);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state24 = agent.new say();
							StringCreator string25 = new StringCreator();
							string25.append("Okay");
							state24.setText(string25.toString());
							if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 83, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 85
							Goodbye state26 = new Goodbye();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 85, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 83, 59));
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
			// Line: 92
			try {
				EXECUTION: {
					int count = getCount(636760907) + 1;
					incrCount(636760907);
					iristk.situated.SystemAgentFlow.say state27 = agent.new say();
					StringCreator string28 = new StringCreator();
					string28.append("Goodbye.");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 92, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state29 = agent.new say();
					StringCreator string30 = new StringCreator();
					string30.append("Please leave the detection area");
					state29.setText(string30.toString());
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 92, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 95
					iristk.flow.DialogFlow.wait waitState31 = new iristk.flow.DialogFlow.wait();
					waitState31.setMsec(2000);
					if (!flowThread.callState(waitState31, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 95, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 96
					Idle state32 = new Idle();
					flowThread.gotoState(state32, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 96, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 92, 12));
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
			// Line: 103
			try {
				EXECUTION: {
					int count = getCount(1216792541) + 1;
					incrCount(1216792541);
					iristk.situated.SystemAgentFlow.prompt state33 = agent.new prompt();
					StringCreator string34 = new StringCreator();
					string34.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state33.setText(string34.toString());
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 103, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state35 = agent.new listen();
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 103, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 103, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 109
			try {
				count = getCount(293069974) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(293069974);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 110
							Nature state36 = new Nature();
							flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 110, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 109, 68));
			}
			// Line: 112
			try {
				count = getCount(1168935564) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(1168935564);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 113
							History state37 = new History();
							flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 113, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 112, 71));
			}
			// Line: 115
			try {
				count = getCount(232863734) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(232863734);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 116
							Popular state38 = new Popular();
							flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 116, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 115, 66));
			}
			// Line: 118
			try {
				count = getCount(85277261) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(85277261);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 119
							CheckAgain state39 = new CheckAgain();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 119, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 118, 61));
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
			// Line: 124
			try {
				EXECUTION: {
					int count = getCount(1753927028) + 1;
					incrCount(1753927028);
					iristk.situated.SystemAgentFlow.say state40 = agent.new say();
					state40.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 124, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 126
					Attrdetial state41 = new Attrdetial();
					flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 126, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 124, 16));
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
			// Line: 131
			try {
				EXECUTION: {
					int count = getCount(111602623) + 1;
					incrCount(111602623);
					iristk.situated.SystemAgentFlow.say state42 = agent.new say();
					state42.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 131, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 133
					Attrdetial state43 = new Attrdetial();
					flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 133, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 131, 16));
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
			// Line: 138
			try {
				EXECUTION: {
					int count = getCount(491433567) + 1;
					incrCount(491433567);
					iristk.situated.SystemAgentFlow.say state44 = agent.new say();
					state44.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 138, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 140
					Attrdetial state45 = new Attrdetial();
					flowThread.gotoState(state45, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 140, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 138, 16));
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
			// Line: 145
			try {
				EXECUTION: {
					int count = getCount(1540678917) + 1;
					incrCount(1540678917);
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					StringCreator string47 = new StringCreator();
					string47.append("If you want more details for attractions,please say the name.");
					state46.setText(string47.toString());
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 145, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state48 = agent.new listen();
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 145, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 145, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 149
			try {
				count = getCount(329551990) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(329551990);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 150
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state49 = agent.new say();
							state49.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 149, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 152
							CheckAgain state50 = new CheckAgain();
							flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 152, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 149, 69));
			}
			// Line: 154
			try {
				count = getCount(627776147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(627776147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 155
							CheckAgain state51 = new CheckAgain();
							flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 155, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 154, 61));
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
			// Line: 161
			try {
				EXECUTION: {
					int count = getCount(1721381068) + 1;
					incrCount(1721381068);
					iristk.situated.SystemAgentFlow.say state52 = agent.new say();
					StringCreator string53 = new StringCreator();
					string53.append("Where do you want to go?");
					state52.setText(string53.toString());
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 161, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state54 = agent.new listen();
					if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 161, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 161, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 165
			try {
				count = getCount(458752270) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attra")) {
						incrCount(458752270);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state55 = agent.new say();
							state55.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
							if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 165, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 167
							CheckAgain state56 = new CheckAgain();
							flowThread.gotoState(state56, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 167, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 165, 60));
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
			// Line: 173
			try {
				EXECUTION: {
					int count = getCount(371723468) + 1;
					incrCount(371723468);
					iristk.situated.SystemAgentFlow.say state57 = agent.new say();
					StringCreator string58 = new StringCreator();
					string58.append("Which room do you want to find?");
					state57.setText(string58.toString());
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 173, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state59 = agent.new listen();
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 173, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 173, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 177
			try {
				count = getCount(1302540150) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(1302540150);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state60 = agent.new say();
							StringCreator string61 = new StringCreator();
							string61.append("It is on the first floor");
							state60.setText(string61.toString());
							if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 177, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 179
							CheckAgain state62 = new CheckAgain();
							flowThread.gotoState(state62, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 179, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 177, 70));
			}
			// Line: 181
			try {
				count = getCount(872603802) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(872603802);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 182
						String ss = event.get("text").toString();
						iristk.situated.SystemAgentFlow.say state63 = agent.new say();
						state63.setText(info.findroom(ss));
						if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 181, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 184
						CheckAgain state64 = new CheckAgain();
						flowThread.gotoState(state64, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 34)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 181, 42));
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
			// Line: 190
			try {
				EXECUTION: {
					int count = getCount(1455648756) + 1;
					incrCount(1455648756);
					iristk.situated.SystemAgentFlow.say state65 = agent.new say();
					state65.setText(weather.getweather());
					if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 190, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 192
					CheckAgain state66 = new CheckAgain();
					flowThread.gotoState(state66, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 190, 12));
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
			// Line: 200
			try {
				EXECUTION: {
					int count = getCount(658157925) + 1;
					incrCount(658157925);
					iristk.situated.SystemAgentFlow.say state67 = agent.new say();
					StringCreator string68 = new StringCreator();
					string68.append("Do you need other help?");
					state67.setText(string68.toString());
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 200, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state69 = agent.new listen();
					if (!flowThread.callState(state69, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 200, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 200, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 204
			try {
				count = getCount(1255614780) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1255614780);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state70 = agent.new say();
							StringCreator string71 = new StringCreator();
							string71.append("Okay");
							state70.setText(string71.toString());
							if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 204, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 206
							Start state72 = new Start();
							flowThread.gotoState(state72, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 206, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 204, 58));
			}
			// Line: 208
			try {
				count = getCount(2045714616) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2045714616);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state73 = agent.new say();
							StringCreator string74 = new StringCreator();
							string74.append("Okay");
							state73.setText(string74.toString());
							if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 208, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 210
							Goodbye state75 = new Goodbye();
							flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 210, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 208, 57));
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
			// Line: 215
			try {
				count = getCount(1430708890) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1430708890);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state76 = agent.new gesture();
							state76.setName("smile");
							if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 215, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 215, 102));
			}
			// Line: 218
			try {
				count = getCount(1437397610) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1437397610);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state77 = agent.new say();
						StringCreator string78 = new StringCreator();
						string78.append("Sorry, I didn't get that.");
						state77.setText(string78.toString());
						if (!flowThread.callState(state77, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 220
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 220, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 36));
			}
			// Line: 222
			try {
				count = getCount(1286256522) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1286256522);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state79 = agent.new attendOther();
						state79.setMode("eyes");
						if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 222, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state80 = agent.new say();
						StringCreator string81 = new StringCreator();
						string81.append("I didn't ask you.");
						state80.setText(string81.toString());
						if (!flowThread.callState(state80, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 222, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state82 = agent.new attendOther();
						state82.setMode("eyes");
						if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 222, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 226
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 226, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 222, 41));
			}
			// Line: 228
			try {
				count = getCount(479680188) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(479680188);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state83 = agent.new say();
						StringCreator string84 = new StringCreator();
						string84.append("Don't speak at the same time.");
						state83.setText(string84.toString());
						if (!flowThread.callState(state83, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 228, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 230
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 230, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 228, 42));
			}
			// Line: 232
			try {
				count = getCount(679416628) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(679416628);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state85 = agent.new say();
						StringCreator string86 = new StringCreator();
						string86.append("Sorry, I didn't hear anything.");
						state85.setText(string86.toString());
						if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 232, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 234
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 234, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 232, 38));
			}
			// Line: 236
			try {
				count = getCount(1986789885) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1986789885);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state87 = agent.new say();
							StringCreator string88 = new StringCreator();
							string88.append("Goodbye");
							state87.setText(string88.toString());
							if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 236, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 238
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state89 = agent.new attendRandom();
								if (!flowThread.callState(state89, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 238, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 240
								Start state90 = new Start();
								flowThread.gotoState(state90, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 240, 27)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 241
							} else {
								// Line: 242
								Idle state91 = new Idle();
								flowThread.gotoState(state91, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 242, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 236, 69));
			}
			// Line: 245
			try {
				count = getCount(440983206) + 1;
				if (event.triggers("repeat")) {
					incrCount(440983206);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 246
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 246, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 245, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
