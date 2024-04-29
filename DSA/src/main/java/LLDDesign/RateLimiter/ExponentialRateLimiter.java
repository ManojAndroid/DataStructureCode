package LLDDesign.RateLimiter;

import java.util.concurrent.TimeUnit;

public class ExponentialRateLimiter {
    private int maxTokens; // Maximum number of tokens in the bucket
    private double refillRate; // Initial rate of token refill
    private double refillFactor; // Factor by which refill rate increases
    private double tokens; // Current number of tokens in the bucket
    private long lastRefillTime; // Time of the last token refill

    public ExponentialRateLimiter(int maxTokens, double initialRate, double refillFactor, TimeUnit timeUnit) {
        this.maxTokens = maxTokens;
        this.refillRate = initialRate;
        this.refillFactor = refillFactor;
        this.tokens = maxTokens;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refillTokens();

        if (tokens >= 1.0) {
            tokens -= 1.0;
            return true;
        }

        return false;
    }

    private void refillTokens() {
        long currentTime = System.nanoTime();
        double elapsedTimeInSeconds = (currentTime - lastRefillTime) / 1e9;

        double tokensToAdd = elapsedTimeInSeconds * refillRate;
        tokens = Math.min(tokens + tokensToAdd, maxTokens);

        refillRate *= refillFactor; // Increase refill rate exponentially
        lastRefillTime = currentTime;
    }
}
