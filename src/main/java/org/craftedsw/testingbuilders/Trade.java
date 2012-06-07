package org.craftedsw.testingbuilders;

public class Trade {

	private String inboundMessage;
	private ReportabilityDecision reportabilityDecision;

	public String getInboundMessage() {
		return this.inboundMessage;
	}
	
	public void setInboundMessage(String inboundXmlMessage) {
		this.inboundMessage = inboundXmlMessage;
	}

	public boolean isReportable() {
		return reportabilityDecision.isReportable(inboundMessage);
	}
	
	public void setReportabilityDecision(ReportabilityDecision reportabilityDecision) {
		this.reportabilityDecision = reportabilityDecision;
	}

}
