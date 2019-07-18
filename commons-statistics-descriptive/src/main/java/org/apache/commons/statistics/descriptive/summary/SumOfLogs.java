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
package org.apache.commons.statistics.descriptive.summary;

/**
 * Returns the sum of the natural logs for this collection of values.
 * <p>
 * Uses {@link org.apache.commons.math4.util.FastMath#log(double)} to compute the logs.
 * Therefore,
 * <ul>
 * <li>If any of values are &lt; 0, the result is <code>NaN.</code></li>
 * <li>If all values are non-negative and less than
 * <code>Double.POSITIVE_INFINITY</code>,  but at least one value is 0, the
 * result is <code>Double.NEGATIVE_INFINITY.</code></li>
 * <li>If both <code>Double.POSITIVE_INFINITY</code> and
 * <code>Double.NEGATIVE_INFINITY</code> are among the values, the result is
 * <code>NaN.</code></li>
 * </ul>
 */
public class SumOfLogs {

    /** Total number of values.*/
    private long n;

    /**
     * The currently running sumOfLogs.
     */
    private double sumOfLogs;

    /**
     * Create a SumOfLogs instance.
     */
    public SumOfLogs() {
        n = 0;
        sumOfLogs = 0d;
    }

    /**
     * @param value stream of values.
     */
    public void accept(double value) {
      sumOfLogs += Math.log(value);
        n++;
    }

    /**
     * Combines the one object of SumOfLogs class to the another object of the same class.
     * @param sol2 object of SumOfLogs class.
     */
    public void combine(SumOfLogs sol2) {
      sumOfLogs += sol2.getSumOfLogs();
    }

    /**
     * @return SumOfLogs of Values
     */
    public double getSumOfLogs() {
        return sumOfLogs;
    }

    /**
     * @return Total count of values.
     */
    public long getN() {
        return n;
    }

    /**
     * Clears the instance variables.
     */
    public void clear() {
      sumOfLogs = 0d;
        n = 0;
    }

}
