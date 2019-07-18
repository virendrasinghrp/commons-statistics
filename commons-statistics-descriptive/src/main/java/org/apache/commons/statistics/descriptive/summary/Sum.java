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
 * Returns the sum of the available values.
* <p>
* If there are no values in the dataset, then 0 is returned.
* If any of the values are
* <code>NaN</code>, then <code>NaN</code> is returned.</p>
*/
public class Sum {

    /** Total number of values.*/
    private long n;

    /**
     * The currently running sum.
     */
    private double sum;

    /**
     * Create a Sum instance.
     */
    public Sum() {
        n = 0;
        sum = 0;
    }

    /**
     * @param value stream of values.
     */
    public void accept(double value) {
      sum += value;
        n++;
    }

    /**
     * Combines the one object of Sum class to the another object of the same class.
     * @param sum2 object of Sum class.
     */
    public void combine(Sum sum2) {
      sum += sum2.getsum();
    }

    /**
     * @return Sum of Values
     */
    public double getsum() {
        return sum;
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
      sum = 0;
        n = 0;
    }

}
