package com.udacity.gradle.builditbigger;

import android.util.Log;

/**
 * Created by sagar on 6/12/16.
 */

    public class Echo {
        static <T> T echo(T o) {
            return echo(o, false);
        }

        static <T> T echo(T o, boolean log) {
            if (log) Log.i(Echo.class.getName(), o.toString());

            return o;
        }
    }

