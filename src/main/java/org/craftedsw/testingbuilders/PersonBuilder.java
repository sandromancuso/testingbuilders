package org.craftedsw.testingbuilders;

public class PersonBuilder {

	private String firstName;
	private String lastName;

	public static PersonBuilder aPerson() {
		return new PersonBuilder();
	}

	public PersonBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Person build() {
		Person person = createPerson();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		return person;
	}

	protected Person createPerson() {
		return new Person();
	}

}
