package com.livejournal.uisteps.thucydides;

import com.livejournal.uisteps.core.TestActions;
import java.util.Map;
import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepListener;

/**
 *
 * @author Asolyankin
 */
public class BaseStepsListener implements StepListener {

    private final TestActions testActions;

    public BaseStepsListener(TestActions testActions) {
        this.testActions = testActions;
    }

    @Override
    public void testSuiteStarted(Class<?> storyClass) {
        //
    }

    @Override
    public void testSuiteStarted(Story story) {
        //
    }

    @Override
    public void testSuiteFinished() {
        testActions.closeAllBrowsers();
    }

    @Override
    public void testStarted(String description) {
        //
    }

    @Override
    public void testFinished(TestOutcome result) {
        //
    }

    @Override
    public void testRetried() {
        //
    }

    @Override
    public void stepStarted(ExecutedStepDescription description) {
        //
    }

    @Override
    public void skippedStepStarted(ExecutedStepDescription description) {
//   
    }

    @Override
    public void stepFailed(StepFailure failure) {
//
    }

    @Override
    public void lastStepFailed(StepFailure failure) {
//
    }

    @Override
    public void stepIgnored() {
//
    }

    @Override
    public void stepPending() {
//
    }

    @Override
    public void stepPending(String message) {
//
    }

    @Override
    public void stepFinished() {
//
    }

    @Override
    public void testFailed(TestOutcome testOutcome, Throwable cause) {
//
    }

    @Override
    public void testIgnored() {
//
    }

    @Override
    public void notifyScreenChange() {
//
    }

    @Override
    public void useExamplesFrom(DataTable table) {
//
    }

    @Override
    public void exampleStarted(Map<String, String> data) {
//
    }

    @Override
    public void exampleFinished() {
//
    }

    @Override
    public void assumptionViolated(String message) {
//
    }

}
