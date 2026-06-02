class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                int landStart = landStartTime[i];
                int landEnd = landStart + landDuration[i];
                int waterStartAfterLand = Math.max(waterStartTime[j], landEnd);
                int totalTime1 = waterStartAfterLand + waterDuration[j];
                minTime = Math.min(minTime, totalTime1);

                int waterStart = waterStartTime[j];
                int waterEnd = waterStart + waterDuration[j];
                int landStartAfterWater = Math.max(landStartTime[i], waterEnd);
                int totalTime2 = landStartAfterWater + landDuration[i];
                minTime = Math.min(minTime, totalTime2);
            }
        }

        return minTime;
    }
}
