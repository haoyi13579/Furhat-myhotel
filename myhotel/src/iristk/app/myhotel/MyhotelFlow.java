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

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("number")) return this.number;
		if (name.equals("agent")) return this.agent;
		if (name.equals("info")) return this.info;
		return null;
	}


	public MyhotelFlow(iristk.situated.SystemAgentFlow agent, Information info) {
		this.agent = agent;
		this.info = info;
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
			// Line: 18
			try {
				EXECUTION: {
					int count = getCount(1212899836) + 1;
					incrCount(1212899836);
					// Line: 19
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 19, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 21
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 21, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 22
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 19, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 18, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 26
			try {
				count = getCount(1811075214) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(1811075214);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 26, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 28
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 28, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 26, 36));
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
			// Line: 33
			try {
				EXECUTION: {
					int count = getCount(1940447180) + 1;
					incrCount(1940447180);
					iristk.situated.SystemAgentFlow.say state5 = agent.new say();
					StringCreator string6 = new StringCreator();
					string6.append("Hi there");
					state5.setText(string6.toString());
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 33, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 35
					Start state7 = new Start();
					flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 35, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 33, 12));
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
			// Line: 40
			try {
				EXECUTION: {
					int count = getCount(1066376662) + 1;
					incrCount(1066376662);
					iristk.situated.SystemAgentFlow.say state8 = agent.new say();
					StringCreator string9 = new StringCreator();
					string9.append("What can I do for you?");
					state8.setText(string9.toString());
					if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state10 = agent.new listen();
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 40, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 49
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(183264084);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 51
							if (event.has("sem:natural")) {
								// Line: 52
								Nature state11 = new Nature();
								flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 52, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 53
							} else if (event.has("sem:historical")) {
								// Line: 54
								History state12 = new History();
								flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 54, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 55
							} else if (event.has("sem:popular")) {
								// Line: 56
								Popular state13 = new Popular();
								flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 56, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 57
							} else {
								// Line: 58
								QueryAttr state14 = new QueryAttr();
								flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 58, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 49, 68));
			}
			// Line: 62
			try {
				count = getCount(914424520) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(914424520);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 63
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state15 = agent.new say();
								StringCreator string16 = new StringCreator();
								string16.append("The trans detail part");
								state15.setText(string16.toString());
								if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 63, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								iristk.situated.SystemAgentFlow.say state17 = agent.new say();
								state17.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 63, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 66
								CheckAgain state18 = new CheckAgain();
								flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 66, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 67
							} else {
								iristk.situated.SystemAgentFlow.say state19 = agent.new say();
								StringCreator string20 = new StringCreator();
								string20.append("The trans second part");
								state19.setText(string20.toString());
								if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 63, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 69
								QueryTrans state21 = new QueryTrans();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 69, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 62, 71));
			}
			// Line: 73
			try {
				count = getCount(204349222) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(204349222);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 75
							QueryRoom state22 = new QueryRoom();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 75, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 73, 62));
			}
			// Line: 78
			try {
				count = getCount(2110121908) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(2110121908);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state23 = agent.new say();
							StringCreator string24 = new StringCreator();
							string24.append("Okay");
							state23.setText(string24.toString());
							if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 78, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 80
							Goodbye state25 = new Goodbye();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 80, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 78, 59));
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
			// Line: 86
			try {
				EXECUTION: {
					int count = getCount(1023487453) + 1;
					incrCount(1023487453);
					iristk.situated.SystemAgentFlow.say state26 = agent.new say();
					StringCreator string27 = new StringCreator();
					string27.append("Goodbye.");
					state26.setText(string27.toString());
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state28 = agent.new say();
					StringCreator string29 = new StringCreator();
					string29.append("Please leave the detection area");
					state28.setText(string29.toString());
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 89
					iristk.flow.DialogFlow.wait waitState30 = new iristk.flow.DialogFlow.wait();
					waitState30.setMsec(2000);
					if (!flowThread.callState(waitState30, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 89, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 90
					Idle state31 = new Idle();
					flowThread.gotoState(state31, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 90, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 86, 12));
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
			// Line: 97
			try {
				EXECUTION: {
					int count = getCount(1365202186) + 1;
					incrCount(1365202186);
					iristk.situated.SystemAgentFlow.prompt state32 = agent.new prompt();
					StringCreator string33 = new StringCreator();
					string33.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 97, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state34 = agent.new listen();
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 97, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 97, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 103
			try {
				count = getCount(1651191114) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(1651191114);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 104
							Nature state35 = new Nature();
							flowThread.gotoState(state35, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 104, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 103, 68));
			}
			// Line: 106
			try {
				count = getCount(474675244) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(474675244);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 107
							History state36 = new History();
							flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 107, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 106, 71));
			}
			// Line: 109
			try {
				count = getCount(212628335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(212628335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 110
							Popular state37 = new Popular();
							flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 110, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 109, 66));
			}
			// Line: 112
			try {
				count = getCount(359023572) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(359023572);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 113
							CheckAgain state38 = new CheckAgain();
							flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 113, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 112, 61));
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
			// Line: 118
			try {
				EXECUTION: {
					int count = getCount(917142466) + 1;
					incrCount(917142466);
					iristk.situated.SystemAgentFlow.say state39 = agent.new say();
					state39.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 118, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 120
					Attrdetial state40 = new Attrdetial();
					flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 120, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 118, 16));
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
			// Line: 125
			try {
				EXECUTION: {
					int count = getCount(1130478920) + 1;
					incrCount(1130478920);
					iristk.situated.SystemAgentFlow.say state41 = agent.new say();
					state41.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 125, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 127
					Attrdetial state42 = new Attrdetial();
					flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 127, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 125, 16));
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
			// Line: 132
			try {
				EXECUTION: {
					int count = getCount(1227229563) + 1;
					incrCount(1227229563);
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					state43.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 132, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 134
					Attrdetial state44 = new Attrdetial();
					flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 134, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 132, 16));
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
			// Line: 139
			try {
				EXECUTION: {
					int count = getCount(1101288798) + 1;
					incrCount(1101288798);
					iristk.situated.SystemAgentFlow.say state45 = agent.new say();
					StringCreator string46 = new StringCreator();
					string46.append("If you want more details for attractions,please say the name.");
					state45.setText(string46.toString());
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 139, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state47 = agent.new listen();
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 139, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 139, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 143
			try {
				count = getCount(942731712) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attra")) {
						incrCount(942731712);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state48 = agent.new say();
							state48.setText(info.detail(info.readattr(),event.get("sem:attra")));
							if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 143, 66)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 145
							CheckAgain state49 = new CheckAgain();
							flowThread.gotoState(state49, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 145, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 143, 66));
			}
			// Line: 147
			try {
				count = getCount(1910163204) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1910163204);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 148
							CheckAgain state50 = new CheckAgain();
							flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 148, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 147, 61));
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
			// Line: 153
			try {
				EXECUTION: {
					int count = getCount(2104457164) + 1;
					incrCount(2104457164);
					iristk.situated.SystemAgentFlow.say state51 = agent.new say();
					StringCreator string52 = new StringCreator();
					string52.append("Where do you want to go?");
					state51.setText(string52.toString());
					if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 153, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state53 = agent.new listen();
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 153, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 153, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 157
			try {
				count = getCount(1521118594) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attra")) {
						incrCount(1521118594);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state54 = agent.new say();
							state54.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
							if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 157, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 159
							CheckAgain state55 = new CheckAgain();
							flowThread.gotoState(state55, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 159, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 157, 60));
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
			// Line: 164
			try {
				EXECUTION: {
					int count = getCount(1763847188) + 1;
					incrCount(1763847188);
					iristk.situated.SystemAgentFlow.say state56 = agent.new say();
					StringCreator string57 = new StringCreator();
					string57.append("Which room do you want to find?");
					state56.setText(string57.toString());
					if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 164, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state58 = agent.new listen();
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 164, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 164, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 168
			try {
				count = getCount(1617791695) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(1617791695);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state59 = agent.new say();
							StringCreator string60 = new StringCreator();
							string60.append("It is on the first floor");
							state59.setText(string60.toString());
							if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 168, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 170
							CheckAgain state61 = new CheckAgain();
							flowThread.gotoState(state61, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 170, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 168, 70));
			}
			// Line: 172
			try {
				count = getCount(1192108080) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1192108080);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 173
						String ss = event.get("text").toString();
						iristk.situated.SystemAgentFlow.say state62 = agent.new say();
						state62.setText(info.findroom(ss));
						if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 172, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 175
						CheckAgain state63 = new CheckAgain();
						flowThread.gotoState(state63, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 175, 34)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 172, 42));
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
			// Line: 184
			try {
				EXECUTION: {
					int count = getCount(380894366) + 1;
					incrCount(380894366);
					iristk.situated.SystemAgentFlow.say state64 = agent.new say();
					StringCreator string65 = new StringCreator();
					string65.append("Do you need other help?");
					state64.setText(string65.toString());
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state66 = agent.new listen();
					if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 184, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 188
			try {
				count = getCount(237852351) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(237852351);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state67 = agent.new say();
							StringCreator string68 = new StringCreator();
							string68.append("Okay");
							state67.setText(string68.toString());
							if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 188, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 190
							Start state69 = new Start();
							flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 190, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 188, 58));
			}
			// Line: 192
			try {
				count = getCount(1608446010) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1608446010);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state70 = agent.new say();
							StringCreator string71 = new StringCreator();
							string71.append("Okay");
							state70.setText(string71.toString());
							if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 194
							Goodbye state72 = new Goodbye();
							flowThread.gotoState(state72, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 194, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 192, 57));
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
			// Line: 199
			try {
				count = getCount(1297685781) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1297685781);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state73 = agent.new gesture();
							state73.setName("smile");
							if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 199, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 199, 102));
			}
			// Line: 202
			try {
				count = getCount(1705929636) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1705929636);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state74 = agent.new say();
						StringCreator string75 = new StringCreator();
						string75.append("Sorry, I didn't get that.");
						state74.setText(string75.toString());
						if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 202, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 204
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 204, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 202, 36));
			}
			// Line: 206
			try {
				count = getCount(1509514333) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1509514333);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state76 = agent.new attendOther();
						state76.setMode("eyes");
						if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 206, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state77 = agent.new say();
						StringCreator string78 = new StringCreator();
						string78.append("I didn't ask you.");
						state77.setText(string78.toString());
						if (!flowThread.callState(state77, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 206, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state79 = agent.new attendOther();
						state79.setMode("eyes");
						if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 206, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 210
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 210, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 206, 41));
			}
			// Line: 212
			try {
				count = getCount(1252585652) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1252585652);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state80 = agent.new say();
						StringCreator string81 = new StringCreator();
						string81.append("Don't speak at the same time.");
						state80.setText(string81.toString());
						if (!flowThread.callState(state80, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 212, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 214
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 214, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 212, 42));
			}
			// Line: 216
			try {
				count = getCount(1785210046) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1785210046);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state82 = agent.new say();
						StringCreator string83 = new StringCreator();
						string83.append("Sorry, I didn't hear anything.");
						state82.setText(string83.toString());
						if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 216, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 218
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 218, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 216, 38));
			}
			// Line: 220
			try {
				count = getCount(1361960727) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1361960727);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state84 = agent.new say();
							StringCreator string85 = new StringCreator();
							string85.append("Goodbye");
							state84.setText(string85.toString());
							if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 220, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 222
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state86 = agent.new attendRandom();
								if (!flowThread.callState(state86, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 222, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 224
								Start state87 = new Start();
								flowThread.gotoState(state87, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 224, 27)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 225
							} else {
								// Line: 226
								Idle state88 = new Idle();
								flowThread.gotoState(state88, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 226, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 220, 69));
			}
			// Line: 229
			try {
				count = getCount(991505714) + 1;
				if (event.triggers("repeat")) {
					incrCount(991505714);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 230
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 230, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\IrisTK\\app\\myhotel\\src\\iristk\\app\\myhotel\\MyhotelFlow.xml"), 229, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
