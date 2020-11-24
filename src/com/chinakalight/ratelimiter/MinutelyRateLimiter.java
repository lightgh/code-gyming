package com.chinakalight.ratelimiter;

import java.util.*;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 15/10/2020
 */
public class MinutelyRateLimiter { //TenSecondlyRateLimiter

    private final Map<String, Integer> budget;
    private final Map<String, List<Long>> timestampsByUser;

    // budget is a map of each principal and how many requests they can make in the last 1miniute
    MinutelyRateLimiter(Map<String, Integer> budget) {
        this.budget = Collections.unmodifiableMap(new HashMap<>(budget));
        this.timestampsByUser = new HashMap<>();
        // Assume budget.get("light") == 5
    }

    // epochTimestamp is guaranteed to be monotonically increasing

    void purgeOlderTimestampsFrom(List<Long> timestamps, long currentEpochTimestamp) {
        Iterator<Long> iterator = timestamps.iterator();
        while(iterator.hasNext()) {
            long timestamp = iterator.next();
            if (currentEpochTimestamp - timestamp >= 10) {
                iterator.remove();
            } else {
                break;
            }
        }
    }


    // budget = { "light" : 5 }
    // timestampsByUser = { "light" => [0] }
    // identifier="light", epochTimestamp = 0
    public boolean markAndIfShouldDeny(String identifier, long currentEpochTimestampInSeconds) {
        final int identifierLimit = budget.getOrDefault(identifier, 0);
        if (identifierLimit < 1) {
            return true;
        }
        List<Long> timestamps = timestampsByUser.computeIfAbsent(identifier, k -> new ArrayList<>());
        if (timestamps.isEmpty()) {
            timestamps.add(currentEpochTimestampInSeconds);
            return false;
        }
        if (timestamps.size() == identifierLimit) {
            if (currentEpochTimestampInSeconds - timestamps.get(0) < 10) {
                //^^current           //^^first item in list
                return true;
            }
        }
        purgeOlderTimestampsFrom(timestamps, currentEpochTimestampInSeconds);
        timestamps.add(currentEpochTimestampInSeconds);
        return false;

        //[0, 0, 0, 0]

        // epechTimestamp = any of [1, 1, 1, 1, 1, 1, 1, 1, 1]
        // epechTimestamp = any of [1, 1, 1, 1, 1, 1, 1, 1, 2]
        // epechTimestamp = any of [1, 1, 1, 1, 1, 2, 2, 2, 2]
        // epechTimestamp = any of [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // epechTimestamp = any of [1, 2343, 3434, 4000, 50000, 60000, 70000, 80000, 900000000]

        /**
         *    |
         *    |
         *    |  L
         *    |----------------------------------------------------------------------------------- > (t)
         *      1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  21  22  23
         */
    }

    void test() {
        if (markAndIfShouldDeny("light", System.currentTimeMillis())) {
            throw new IllegalStateException("");
        }
    }
}
