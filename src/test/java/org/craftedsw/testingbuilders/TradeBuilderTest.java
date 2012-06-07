package org.craftedsw.testingbuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeBuilderTest {

	private static final String TRADE_XML_MESSAGE = "<message />";
	
	@Mock private ReportabilityDecision reportabilityDecision;
	@Mock private Trade trade;
	
	@Spy @InjectMocks TradeBuilder tradeBuilder;
	
	@Test public void
	should_create_a_trade_with_all_specified_attributes() {
		when(tradeBuilder.createTrade()).thenReturn(trade);
		
		tradeBuilder
				.withInboundMessage(TRADE_XML_MESSAGE)
				.withReportabilityDecision(reportabilityDecision)
				.build();
		
		verify(trade).setInboundMessage(TRADE_XML_MESSAGE);
		verify(trade).setReportabilityDecision(reportabilityDecision);
	}

}
