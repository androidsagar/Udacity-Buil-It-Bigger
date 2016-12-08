package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

//@RunWith(AndroidJUnit4.class)
//public class EchoAndroidTest {
//
//
//    @Test
//    public void testVerifyEchoResponse() {
//        assertEquals("hello", Echo.echo("hello"));
//    }
//
//    @Test
//    public void testVerifyLoggingEchoResponse() {
//        assertEquals("hello", Echo.echo("hello", true));
//
//    }
//
//}
public class EchoAndroidTest extends ApplicationTestCase<Application> {
    public EchoAndroidTest() {
        super(Application.class);
    }
}
