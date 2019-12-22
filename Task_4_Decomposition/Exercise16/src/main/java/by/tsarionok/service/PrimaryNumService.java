package by.tsarionok.service;

import by.tsarionok.entity.TwinsNum;

import java.util.ArrayList;

public class PrimaryNumService {

    public ArrayList<Integer> allPrimaries(final int from, final int until) {
        ArrayList<Integer> primaries = new ArrayList<>();
        for (int i = from; i <= until; i++) {
            if (isPrimary(i)) {
                primaries.add(i);
            }
        }
        return primaries;
    }

    public ArrayList<TwinsNum> allTwins(final int from, final int until) {
        ArrayList<Integer> primaries = allPrimaries(from, until);
        ArrayList<TwinsNum> twins = new ArrayList<>();
        for (int i = 0; i < primaries.size() - 1; i++) {
            if (primaries.get(i + 1) - primaries.get(i) == 2) {
                twins.add(new TwinsNum(primaries.get(i), primaries.get(i + 1)));
            }
        }
        return twins;
    }

    public boolean isPrimary(int number) {
        final int NUM_SQRT = (int) Math.sqrt(number);
        for (int i = 2; i <= NUM_SQRT; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
