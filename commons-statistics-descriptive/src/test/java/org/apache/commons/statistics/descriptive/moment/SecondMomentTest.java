/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.statistics.descriptive.moment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SecondMomentTest {
    protected double mean = 12.404545454545455d;
    protected double tolerance = 10E-12;
    protected double secondmoment = 210.0495454545454;
    protected double[] testArray =
    {12.5, 12.0, 11.8, 14.2, 14.9, 14.5, 21.0,  8.2, 10.3, 11.3,
        14.1,  9.9, 12.2, 12.0, 12.1, 11.0, 19.8, 11.0, 10.0,  8.8,
        9.0, 12.3 };

    /**Returns SecondMoment instance.*/
    public SecondMoment getSecondMomentInst() {
        return new SecondMoment();
    }

    /**Expected SecondMoment value for testArray. */
    public double expectedValue()  {
        return this.secondmoment;
    }

    /**Getter for tolerance value.*/
    public double getTolerance() {
        return this.tolerance;
    }

    /**Getter for mean value of testArray.*/
    public double  getMean() {
        return this.mean;
    }

    /** Verifies that accept(), getm2(),getN(), getMean() works properly. */
    @Test
    public void testSecondMoment() {
        SecondMoment sm1 = getSecondMomentInst();
        // Add testArray one value at a time and check result
        for (int i = 0; i < testArray.length; i++) {
            sm1.accept(testArray[i]);
        }
        assertEquals(expectedValue(), sm1.getm2(), getTolerance());
        assertEquals(testArray.length, sm1.getN());
        assertEquals(getMean(), sm1.getMean(), getTolerance());
    }

    /** Make sure Double.NaN is returned iff n = 0. */
    @Test
    public void testNaN() {
        SecondMoment sm2 = getSecondMomentInst();
        assertTrue(Double.isNaN(sm2.getm2()));
        sm2.accept(1d);
        assertEquals(0, sm2.getm2(), 1E-14);
    }

}
