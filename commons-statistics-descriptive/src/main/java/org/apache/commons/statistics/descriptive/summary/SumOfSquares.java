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
 * Returns the sum of the squares of the available values.
 * <p>
 * If there are no values in the dataset, then 0 is returned.
 * If any of the values are
 * <code>NaN</code>, then <code>NaN</code> is returned.</p>
 */
public class SumOfSquares {

    /** Total number of values.*/
    private long n;

    /**
     * The currently running Sum of Squares.
     */
    private double sumSq;

    /**
     * Create a SumOfSquares instance.
     */
    public SumOfSquares() {
        n = 0;
        sumSq = 0;
    }

    /**
     * @param value stream of values.
     */
    public void accept(double value) {
        sumSq += value * value;
        n++;
    }

    /**
     * Combines the one object of SumOfSquares class to the another object of the same class.
     * @param sos2 object of SumOfSquares class.
     */
    public void combine(SumOfSquares sos2) {
        sumSq += sos2.getSumSq();
    }

    /**
     * @return sumSq of Values
     */
    public double getSumSq() {
        return sumSq;
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
        sumSq = 0;
        n = 0;
    }

}
