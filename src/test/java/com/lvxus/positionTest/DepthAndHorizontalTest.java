package com.lvxus.positionTest;

import com.google.common.collect.Lists;
import com.lvxus.postion.SubmarinePostion;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DepthAndHorizontalTest {

    @Test
    public void should_return_forwardResult_0_when_given_forward_0(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("forward",0);
        assertThat(submarinePostion.getTotalHorizontal(),is(0));
    }
    @Test
    public void should_return_total_horizontal_5_when_given_forward_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("forward",5);
        assertThat(submarinePostion.getTotalHorizontal(),is(5));
    }
    @Test
    public void should_return_total_horizontal_10_when_given_forward_5_and_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("forward",5);
        submarinePostion.setMoveResult("forward",5);
        assertThat(submarinePostion.getTotalHorizontal(),is(10));
    }
    @Test
    public void should_return_total_depth_0_when_given_down_0(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("down",0);
        assertThat(submarinePostion.getTotalDepth(),is(0));
    }
    @Test
    public void should_return_total_depth_5_when_given_down_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("down",5);
        assertThat(submarinePostion.getTotalDepth(),is(5));
    }
    @Test
    public void should_return_total_depth_10_when_given_down_5_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("down",5);
        submarinePostion.setMoveResult("down",5);
        assertThat(submarinePostion.getTotalDepth(),is(10));
    }
    @Test
    public void should_return_total_depth_2_when_given_down_5_up_3(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("down",5);
        submarinePostion.setMoveResult("up",3);
        assertThat(submarinePostion.getTotalDepth(),is(2));
    }
    @Test
    public void should_return_total_depth_2_total_horizontal_5_when_given_down_5_and_up_3_forward_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setMoveResult("down",5);
        submarinePostion.setMoveResult("up",3);
        submarinePostion.setMoveResult("forward",5);
        assertThat(submarinePostion.getTotalDepth(),is(2));
        assertThat(submarinePostion.getTotalHorizontal(),is(5));
    }
    @Test
    public void should_return_total_depth_2_total_horizontal_5_when_given_move_list(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        List<String> diveDistances = Lists.newArrayList();
        diveDistances.add("forward 6");
        diveDistances.add("down 6");
        diveDistances.add("up 3");
        submarinePostion.setDiveDistances(diveDistances);
        assertThat(submarinePostion.getTotalDepth(),is(3));
        assertThat(submarinePostion.getTotalHorizontal(),is(6));
    }
}
