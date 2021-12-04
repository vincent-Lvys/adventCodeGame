package com.lvxus.postion;

import java.util.Iterator;
import java.util.List;

public class SubmarinePostion {
    private Integer totalHorizontal = 0;
    private Integer totalDepth = 0;
    private Integer aim = 0;


    public Integer getTotalHorizontal() {
        return this.totalHorizontal;
    }

    public void setDiveAction(String moveType, String distance) {
        if ("forward".equals(moveType)) {
            this.totalHorizontal += Integer.parseInt(distance);
            this.totalDepth += this.aim*Integer.parseInt(distance);
        }
        if ("down".equals(moveType)) {
            this.aim += Integer.parseInt(distance);
        }if ("up".equals(moveType)){
            this.aim -= Integer.parseInt(distance);
        }
    }

    public Integer getAim() {
        return this.aim;
    }

    public void setDiveActions(List<String> diveActions) {
        Iterator<String> iterator = diveActions.iterator();
        while (iterator.hasNext()){
            String diveAction = iterator.next();
            setDiveAction(diveAction.split(" ")[0],diveAction.split(" ")[1]);
        }
    }

    public Integer getTotalDepth() {
        return totalDepth;
    }
}
