package com.livejournal.uitests.tests.unified_scheme.gui.header;

import java.util.Map;
import net.thucydides.core.Thucydides;
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


    public BaseStepsListener() {
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
      //
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
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@stepStarted");
        Thucydides.takeScreenshot();
        //
    }

    @Override
    public void skippedStepStarted(ExecutedStepDescription description) {
//   
    }

    @Override
    public void stepFailed(StepFailure failure) {
     System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@stepFailed");
        Thucydides.takeScreenshot();
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
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@stepFinished");
        Thucydides.takeScreenshot();
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
