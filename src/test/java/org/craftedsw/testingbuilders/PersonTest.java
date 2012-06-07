package org.craftedsw.testingbuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person person;
	
	@Before
	public void initialise() {
		this.person = new Person();
	}

	@Test public void 
	should_have_a_mutable_first_name() {
		person.setFirstName("Sandro");
		
		assertThat(person.getFirstName(), is("Sandro"));
	}
	
	@Test public void
	shoudl_have_a_mutable_last_name() {
		person.setLastName("Mancuso");
		
		assertThat(person.getLastName(), is("Mancuso"));
	}
	
}
