/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.loganalysis.heuristic;

import com.android.loganalysis.item.AnrItem;
import com.android.loganalysis.item.LogcatItem;

import junit.framework.TestCase;

/**
 * Unit test for {@link AnrHeuristic}.
 */
public class AnrHeuristicTest extends TestCase {

    /**
     * Test that {@link AnrHeuristic#failed()} returns true in the presence of ANRs.
     */
    public void testCheckHeuristic_anr() {
        AnrHeuristic heuristic = new AnrHeuristic();
        LogcatItem logcat = new LogcatItem();
        logcat.addEvent(new AnrItem());
        heuristic.addLogcat(logcat, null, null);

        assertTrue(heuristic.failed());
    }

    /**
     * Test that {@link AnrHeuristic#failed()} returns false in the absence of ANRs.
     */
    public void testCheckHeuristic_no_anr() {
        AnrHeuristic heuristic = new AnrHeuristic();
        LogcatItem logcat = new LogcatItem();
        heuristic.addLogcat(logcat, null, null);

        assertFalse(heuristic.failed());
    }
}
