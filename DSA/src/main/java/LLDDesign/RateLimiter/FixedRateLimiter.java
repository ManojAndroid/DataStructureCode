package LLDDesign.RateLimiter;

import java.util.concurrent.TimeUnit;

public class FixedRateLimiter {
    private int limit;//max no of request allowed
    private long windowInMillis;// time window in milliseconds
    private long lastRequestTime;// time of the last request
    private int requestCount;// no of request made within the window

    public FixedRateLimiter(int limit, long windowInMillis, TimeUnit timeUnit){
        this.limit=limit;
        this.windowInMillis=timeUnit.toMillis(windowInMillis);
        this.lastRequestTime=System.currentTimeMillis();
        this.requestCount=0;
    }
    private synchronized boolean allowRequest(){
        long currentTime=System.currentTimeMillis();
        if(currentTime-lastRequestTime>windowInMillis){
            //reset request count if the window has elapsed
            requestCount=0;
            lastRequestTime=currentTime;
        }
        if(requestCount<limit){
            requestCount++;//increment request count and allow request
            return true;
        }
        return false;//limit exceeded
    }
}
