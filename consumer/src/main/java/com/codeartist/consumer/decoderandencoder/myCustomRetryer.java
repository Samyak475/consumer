package com.codeartist.consumer.decoderandencoder;

import feign.RetryableException;
import feign.Retryer;

// type 1
//public class myCustomRetryer extends Retryer.Default{
//
//    public myCustomRetryer(){
//        super(100,1000,5);
//    }
//}

public  class myCustomRetryer implements  Retryer
{
    @Override
    public void continueOrPropagate(RetryableException re){
    // RETRY LOGIC , HAVE A RETRY , MAXRETRY , MAXATTEMPT
    }
    @Override
    public Retryer clone(){
        return new myCustomRetryer();
    }
}