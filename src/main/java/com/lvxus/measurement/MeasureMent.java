package com.lvxus.measurement;

import java.util.List;

public class MeasureMent {
    private List<Integer> measurements;
    private Integer front = null;
    private Integer end = null;
    private String sliding = "";

    public Integer getLargerTimes() {
        int largerTimes = 0;

        for (int i = 0; i < measurements.size(); i++) {
            if ("sliding".equals(this.sliding)) {
                if (measurements.size() < i + 4) break;
                front = measurements.get(i);
                end = measurements.get(i + 3);
            } else {
                front = end;
                end = measurements.get(i);
            }
            if (isEndLargerFront(front, end)) largerTimes++;
        }
        return largerTimes;
    }


    public boolean isEndLargerFront(Integer front, Integer end) {
        boolean isLarger = false;
        if (front != null) isLarger = end > front;
        return isLarger;
    }

    public void setMeasureMentsAndSliding(String sliding, List<Integer> measurements) {
        this.measurements = measurements;
        this.sliding = sliding;
    }
}
