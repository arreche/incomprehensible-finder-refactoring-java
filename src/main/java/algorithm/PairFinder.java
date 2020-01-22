package algorithm;
import java.util.ArrayList;
import java.util.List;

public class PairFinder {
    private final List<Person> people;

    public PairFinder(List<Person> people) {
        this.people = people;
    }

    public Pair find(SearchCriteria searchCriteria) {
        if (people.size() < 2) return new Pair();

        List<Pair> pairs = buildPairs();

        switch (searchCriteria) {
            case Closest:
                return findClosest(pairs);
            case Furthrest:
                return findFurthest(pairs);
            default:
                return findClosest(pairs);
        }
    }

    private List<Pair> buildPairs() {
        List<Pair> pairs = new ArrayList<Pair>();

        // TODO: Find a method to zip/combine values
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                Pair pair = new Pair(people.get(i), people.get(j));

                pairs.add(pair);
            }
        }

        return pairs;
    }

    private Pair findClosest(List<Pair> pairs) {
        Pair closest = pairs.get(0);
        for (Pair pair : pairs) {
            if (pair.isClosest(closest)) {
                closest = pair;
            }
        }

        return closest;
    }

    private Pair findFurthest(List<Pair> pairs) {
        Pair furthest = pairs.get(0);
        for (Pair pair : pairs) {
            if (pair.isFurthest(furthest)) {
                furthest = pair;
            }
        }

        return furthest;
    }
}
