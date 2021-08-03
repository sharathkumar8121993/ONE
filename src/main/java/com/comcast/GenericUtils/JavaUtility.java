package com.comcast.GenericUtils;

import java.util.Random;

/**
 * generic methods related to java
 *
 * @author sharath
 */
public class JavaUtility {

    /**
     * generic methods related to java
     * return
     * @return
     */
    public int randomNumber() {
        Random random = new Random();
        int ran = random.nextInt(1000);
        return ran;
    }


}


