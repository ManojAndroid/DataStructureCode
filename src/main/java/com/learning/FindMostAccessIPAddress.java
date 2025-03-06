package com.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMostAccessIPAddress {
    public static String maximumAccessIp(String[] lines) {
        Map<String, Integer> ipCountMap = new HashMap<>();
        for (String line : lines) {
            String ip = line.split(" ")[0];
            ipCountMap.put(ip, ipCountMap.getOrDefault(ip, 0) + 1);
        }
        // Step 2: Find the maximum frequency of access
        int maxCount = 0;
        for (int count : ipCountMap.values()) {
            maxCount = Math.max(maxCount, count);
        }

        // Step 3: Collect all IPs that have the maximum frequency
        List<String> topIps = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                topIps.add(entry.getKey());
            }
        }

        // Step 4: Return the result as a comma-separated string
        return String.join(",", topIps);

    }

    public static void main(String[] args) {
        String lines[] = {
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
        System.out.println("result:"+maximumAccessIp(lines));
        System.out.println("second test cases");
        String lines1[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234"};
        System.out.println("REesult"+ maximumAccessIp(lines1));

    }
}
