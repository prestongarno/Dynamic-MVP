package edu.gvsu.prestongarno.example;

import edu.gvsu.preston.annotations.MVPEvent;

/**
 * ========================================================================
 * $(PROJECT_NAME) - by Preston Garno on 3/6/17
 * =========================================================================
 */
@MVPEvent
public class runner {
    public static void main(String[] args) {
        System.out.println("Secret generated string is :: " + runnerGenerated.getHackedString());
    }
}
