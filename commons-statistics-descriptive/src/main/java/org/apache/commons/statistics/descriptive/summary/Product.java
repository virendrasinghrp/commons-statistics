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
 * Returns the product of the available values.
 * <p>
 * If there are no values in the dataset, then 1 is returned.
 *  If any of the values are
 * <code>NaN</code>, then <code>NaN</code> is returned.</p>
 */
public class Product {

    /** Total number of values.*/
    private long n;

    /**
     * The currently running product.
     */
    private double product;

    /**
     * Create a Product instance.
     */
    public Product() {
        n = 0;
        product = 0;
    }

    /**
     * @param value stream of values.
     */
    public void accept(double value) {
        n++;
        if(n==1) {
            product = value;
        }
        else {
            product *= value;
        }
    }

    /**
     * Combines the one object of Product class to the another object of the same class.
     * @param prod2 object of Product class.
     */
    public void combine(Product prod2) {
      product *= prod2.getproduct();
    }

    /**
     * @return Product of Values
     */
    public double getproduct() {
        return product;
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
      product = 0;
        n = 0;
    }

}

