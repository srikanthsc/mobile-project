package com.srikanthsc.myapplication;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTestunits {

    @Rule
    public ActivityTestRuleUnits<MainActivity> mActivityTestRule = new ActivityTestRuleUnits<MainActivity>(MainActivity.class);
    private Class<? extends ActivityTestRuleUnits> mActivity = null;
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testlaunch(){
        Class<?> view;
        view = mActivity.getDeclaringClass();
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        mActivity = null;
    }
}