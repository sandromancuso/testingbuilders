package org.craftedsw.testingbuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeTest {
	
	private static final String INBOUND_XML_MESSAGE = "<message />";
	private static final boolean REPORTABILITY_RESULT = true;
	private Trade trade;
	
	@Mock private ReportabilityDecision reportabilityDecision;

	@Before
	public void initialise() {
		trade = new Trade();
		when(reportabilityDecision.isReportable(anyString()))
				.thenReturn(REPORTABILITY_RESULT);
	}
	
	@Test public void
	should_contain_the_inbound_xml_message() {
		trade.setInboundMessage(INBOUND_XML_MESSAGE);
		
		assertThat(trade.getInboundMessage(), is(INBOUND_XML_MESSAGE));
	}
	
	@Test public void
	should_tell_if_it_is_reportable() {
		trade.setInboundMessage(INBOUND_XML_MESSAGE);
		trade.setReportabilityDecision(reportabilityDecision);
		
		boolean reportable = trade.isReportable();
		
		verify(reportabilityDecision).isReportable(INBOUND_XML_MESSAGE);
		assertThat(reportable, is(REPORTABILITY_RESULT));
	}

}
