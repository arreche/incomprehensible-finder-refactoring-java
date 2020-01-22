package algorithm;
public class Pair {
	private Person oldest;
	private Person youngest;
    private long ageDifference;

	public Pair() {

    }

    public Pair(Person p1, Person p2) {
        if (p1.isOlderThan(p2)) {
            this.oldest = p1;
            this.youngest = p2;
        } else {
            this.oldest = p2;
            this.youngest = p1;
        }

        this.ageDifference = p1.calculateAgeDifference(p2);
    }

    public boolean isClosest(Pair pair) {
        return this.ageDifference < pair.ageDifference;
    }

    public boolean isFurthest(Pair pair) {
        return !isClosest(pair);
    }

    public Person getOldest() {
        return oldest;
    }

    public Person getYoungest() {
	    return youngest;
    }

}
