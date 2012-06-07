package org.craftedsw.testingbuilders;

import static org.craftedsw.testingbuilders.PersonBuilder.aPerson;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class PersonBuilderTest {

	@Test public void
	should_create_a_person_with_all_attributes() {
		Person person = aPerson()
							.withFirstName("Sandro")
							.withLastName("Mancuso")
							.build();
		
		assertThat(person.getFirstName(), is("Sandro"));
		assertThat(person.getLastName(), is("Mancuso"));
	}
	 
	@Test public void
	should_create_a_person_setting_all_its_attributes() {
		Person person = mock(Person.class);
		PersonBuilder builder = spy(new PersonBuilder()
										.withFirstName("Sandro")
										.withLastName("Mancuso"));
		when(builder.createPerson()).thenReturn(person);
		
		builder.build();
		
		verify(person).setFirstName("Sandro");
		verify(person).setLastName("Mancuso");
	}

}
