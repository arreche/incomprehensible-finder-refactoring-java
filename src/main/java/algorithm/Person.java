package algorithm;

import java.util.Date;

public class Person {
	private String name;
	private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public boolean isOlderThan(Person p2) {
        return this.birthDate.getTime() < p2.birthDate.getTime();
    }

    public long calculateAgeDifference(Person p2) {
        return Math.abs(birthDate.getTime() - p2.birthDate.getTime());
    }
}

