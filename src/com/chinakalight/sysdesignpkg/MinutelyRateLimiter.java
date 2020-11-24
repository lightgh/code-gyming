package com.chinakalight.sysdesignpkg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 15/10/2020
 */
public class MinutelyRateLimiter {

    Map<String, Integer> loginRecords = new HashMap<>();
    final int REQUEST_LIMIT = 10;

    // budget is a map of each principal and how many requests they can make in the last 1miniute
    MinutelyRateLimiter(Map<String, Integer> budget) {
        //
    }

    // epochTimestamp is guaranteed to be monotonically increasing
    public boolean markAndIfShouldDeny(String identifier, int epochTimestamp) {
        //identify who is passed in here
         int countLoginRequest = this.loginRecords.getOrDefault(identifier, 0);

         if(countLoginRequest < REQUEST_LIMIT){
             storeLoginRequest(identifier, epochTimestamp); //Mark
         }

        return this.loginRecords.get(identifier) < REQUEST_LIMIT;
    }

    void storeLoginRequest(String username, int time){
        loginRecords.merge(username, 1, Integer::sum);
    }

    void test() {
        markAndIfShouldDeny("light", 0);
        markAndIfShouldDeny("light", 0);
        markAndIfShouldDeny("light", 0);
        markAndIfShouldDeny("light", 0);
        //...
    }
}
