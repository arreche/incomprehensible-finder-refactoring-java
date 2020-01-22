package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import algorithm.PairFinder;
import org.junit.Before;
import org.junit.Test;

import algorithm.Pair;
import algorithm.SearchCriteria;
import algorithm.Person;

public class PairFinderTests {

	Person sue = new Person("Sue",new Date(50, 0, 1));
	Person greg = new Person("Greg",new Date(52, 5, 1));
	Person sarah = new Person("Sarah",new Date(82, 0, 1));
	Person mike = new Person("Mike",new Date(79, 0, 1));

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> people = new ArrayList<Person>();
		PairFinder pairFinder = new PairFinder(people);

		Pair result = pairFinder.find(SearchCriteria.Closest);

		assertNotNull(result);
		assertEquals(null, result.getOldest());
		assertEquals(null, result.getYoungest());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);

		PairFinder pairFinder = new PairFinder(people);

		Pair result = pairFinder.find(SearchCriteria.Closest);

		assertEquals(null, result.getOldest());
		assertEquals(null, result.getYoungest());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() { // f([A,B],One) -> {A,B}
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(greg);
		PairFinder pairFinder = new PairFinder(people);

		Pair result = pairFinder.find(SearchCriteria.Closest);

		assertEquals(sue, result.getOldest());
		assertEquals(greg, result.getYoungest());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() { // f([A,B],Two) -> {B,A}
		List<Person> people = new ArrayList<Person>();
		people.add(mike);
		people.add(greg);

		PairFinder pairFinder = new PairFinder(people);

		Pair result = pairFinder.find(SearchCriteria.Furthrest);

		assertEquals(greg, result.getOldest());
		assertEquals(mike, result.getYoungest());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(sarah);
		people.add(mike);
		people.add(greg);
		PairFinder pairFinder = new PairFinder(people);

		Pair result = pairFinder.find(SearchCriteria.Furthrest);

		assertEquals(sue, result.getOldest());
		assertEquals(sarah, result.getYoungest());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> people = new ArrayList<Person>();
		people.add(sue);
		people.add(sarah);
		people.add(mike);
		people.add(greg);

		PairFinder pairFinder = new PairFinder(people);

		Pair result = pairFinder.find(SearchCriteria.Closest);

		assertEquals(sue, result.getOldest());
		assertEquals(greg, result.getYoungest());
	}

}
