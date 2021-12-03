package com.lvxus.postion;

import java.util.Iterator;
import java.util.List;

public class SubmarinePostion {
    private Integer totalHorizontal = 0;
    private Integer totalDepth = 0;


    public Integer getTotalHorizontal() {
        return this.totalHorizontal;
    }

    public void setMoveResult(String moveType, int distance) {
        if ("forward".equals(moveType))
            this.totalHorizontal += distance;
        if ("down".equals(moveType)) {
            this.totalDepth += distance;
        }if ("up".equals(moveType)){
            this.totalDepth -= distance;
        }
    }

    public Integer getTotalDepth() {
        return this.totalDepth;
    }

    public void setDiveDistances(List<String> diveDistances) {
        Iterator<String> iterator = diveDistances.iterator();
        while (iterator.hasNext()){
            String diveAction = iterator.next();
            setMoveResult(diveAction.split(" ")[0],Integer.parseInt(diveAction.split(" ")[1]));
        }
    }
}
