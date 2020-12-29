package jcr.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String args[]) {
        CricketMatch cricketMatch = new CricketMatch();
        cricketMatch.addObserver(new ScoreUpdate());

        cricketMatch.updateRuns(1);
        cricketMatch.updateRuns(10);
    }

    private static interface Subject {
        void addObserver(ObserverInterface observerInterface);

        void removeObserver(ObserverInterface observerInterface);

        void notifyObservers();
    }

    private static interface ObserverInterface {
        void update(int runs);
    }

    private static class ScoreUpdate implements ObserverInterface {
        public void update(int runs) {
            System.out.println("Updated score : " + runs);
        }
    }

    private static class CricketMatch {
        int totalRuns = 0;
        List<ObserverInterface> observers = new ArrayList<ObserverInterface>();

        public void addObserver(ObserverInterface observerInterface) {
            this.observers.add(observerInterface);
        }

        public void removeObserver(ObserverInterface observerInterface) {
            this.observers.remove(observerInterface);
        }

        public void notifyObservers() {
            observers.forEach(x -> x.update(totalRuns));
        }

        public void updateRuns(int runs) {
            totalRuns += runs;
            notifyObservers();
        }
    }
}
