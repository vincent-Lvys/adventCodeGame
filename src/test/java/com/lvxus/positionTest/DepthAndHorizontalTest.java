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
        submarinePostion.setDiveAction("forward","0");
        assertThat(submarinePostion.getTotalHorizontal(),is(0));
    }
    @Test
    public void should_return_total_horizontal_5_when_given_forward_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("forward","5");
        assertThat(submarinePostion.getTotalHorizontal(),is(5));
    }
    @Test
    public void should_return_total_horizontal_10_when_given_forward_5_and_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("forward","5");
        submarinePostion.setDiveAction("forward","5");
        assertThat(submarinePostion.getTotalHorizontal(),is(10));
    }
    @Test
    public void should_return_total_aim_0_when_given_down_0(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("down","0");
        assertThat(submarinePostion.getAim(),is(0));
    }
    @Test
    public void should_return_total_aim_5_when_given_down_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("down","5");
        assertThat(submarinePostion.getAim(),is(5));
    }
    @Test
    public void should_return_total_aim_10_when_given_down_5_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("down","5");
        submarinePostion.setDiveAction("down","5");
        assertThat(submarinePostion.getAim(),is(10));
    }
    @Test
    public void should_return_total_aim_2_when_given_down_5_up_3(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("down","5");
        submarinePostion.setDiveAction("up","3");
        assertThat(submarinePostion.getAim(),is(2));
    }
    @Test
    public void should_return_total_aim_2_total_horizontal_5_when_given_down_5_and_up_3_forward_5(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveAction("down","5");
        submarinePostion.setDiveAction("up","3");
        submarinePostion.setDiveAction("forward","5");
        assertThat(submarinePostion.getAim(),is(2));
        assertThat(submarinePostion.getTotalHorizontal(),is(5));
    }
    @Test
    public void should_return_total_aim_2_total_horizontal_5_when_given_move_list(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        List<String> diveActions = Lists.newArrayList("forward 6","down 6","up 3");
        submarinePostion.setDiveActions(diveActions);
        assertThat(submarinePostion.getAim(),is(3));
        assertThat(submarinePostion.getTotalHorizontal(),is(6));
    }
    
    @Test
    public void should_return_depth_0_when_down_0_forward_0(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        List<String> diveActions = Lists.newArrayList("forward 0", "down 0");
        Integer totalDepth = submarinePostion.getTotalDepth();
        assertThat(totalDepth,is(0));

    }
    @Test
    public void should_return_20_when_down_2_forward_10(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        List<String> diveActions = Lists.newArrayList("forward 10", "down 2");
        submarinePostion.setDiveActions(diveActions);
        Integer totalDepth = submarinePostion.getTotalDepth();
        assertThat(totalDepth,is(20));
    }
    @Test
    public void should_return_30_when_down_5_up_2_forward_10(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        List<String> diveActions = Lists.newArrayList("down 5","up 2", "forward 10");
        submarinePostion.setDiveActions(diveActions);
        Integer totalDepth = submarinePostion.getTotalDepth();
        assertThat(totalDepth,is(30));
    }
    @Test
    public void should_return_result_300_when_down_5_up_2_forward_10(){
        SubmarinePostion submarinePostion = new SubmarinePostion();
        List<String> diveActions = Lists.newArrayList("down 5","up 2", "forward 10");
        submarinePostion.setDiveActions(diveActions);
        Integer totalDepth = submarinePostion.getTotalDepth();
        Integer totalHorizontal = submarinePostion.getTotalHorizontal();
        assertThat(totalDepth*totalHorizontal,is(300));
    }
}
