package org.craftedsw.testingbuilders;

public class TradeBuilder {

	private String inboundMessage;
	private ReportabilityDecision reportabilityDecision;
	
	public static TradeBuilder aTrade() {
		return new TradeBuilder();
	}

	public TradeBuilder withInboundMessage(String inboundMessage) {
		this.inboundMessage = inboundMessage;
		return this;
	}

	public TradeBuilder withReportabilityDecision(ReportabilityDecision reportabilityDecision) {
		this.reportabilityDecision = reportabilityDecision;
		return this;
	}
	
	public Trade build() {
		Trade trade = createTrade();
		trade.setInboundMessage(inboundMessage);
		trade.setReportabilityDecision(reportabilityDecision);
		return trade;
	}

	Trade createTrade() {
		return new Trade();
	}

}
