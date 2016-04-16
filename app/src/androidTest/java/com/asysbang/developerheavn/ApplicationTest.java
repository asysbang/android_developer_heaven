package com.asysbang.developerheavn;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.view.Gravity;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testXccc() {
        int top = Gravity.CENTER_VERTICAL;
        System.out.println("======="+top);
        System.out.println("======="+Integer.toHexString(top));

    }
}