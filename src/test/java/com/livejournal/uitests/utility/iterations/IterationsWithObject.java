package com.livejournal.uitests.utility.iterations;

/**
 *
 * @author m.prytkova
 */
public abstract class IterationsWithObject {

    private final int counter;
    protected final Object object;
    private int currentIteration;

    public IterationsWithObject(Object object, int counter) {
        this.counter = counter;
        this.object = object;
    }

    protected abstract void toRun();

    public void run() {
        while(currentIteration < counter) {
            toRun();
            currentIteration++;
        }
    }
    
    protected int getCurrentIteration() {
        return currentIteration;
    }

}
