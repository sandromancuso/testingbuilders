package org.craftedsw.testingbuilders;

import static org.craftedsw.testingbuilders.TradeBuilder.aTrade;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeBuilderTest {

	private static final String TRADE_XML_MESSAGE = "<message />";
	
	@Mock
	private ReportabilityDecision reportabilityDecision;

	@Test public void
	should_create_a_trade_with_inbound_message() {
		Trade trade = aTrade()
							.withInboundMessage(TRADE_XML_MESSAGE)
							.build();
		
		assertThat(trade.getInboundMessage(), is(TRADE_XML_MESSAGE));
	}
	
	@Test public void
	should_create_a_trade_with_a_reportability_decision() {
		Trade trade = aTrade()
							.withInboundMessage(TRADE_XML_MESSAGE)
							.withReportabilityDecision(reportabilityDecision)
							.build();
		
		trade.isReportable();
		
		verify(reportabilityDecision).isReportable(TRADE_XML_MESSAGE);
	}
	
}
