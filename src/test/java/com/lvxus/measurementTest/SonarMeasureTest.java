package com.lvxus.measurementTest;

import com.google.common.collect.Lists;
import com.lvxus.measurement.MeasureMent;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SonarMeasureTest {


    private ArrayList<Integer> measurements = Lists.newArrayList();

    @Test
    public void should_give_true_when_front_largerThat_end(){
        MeasureMent measureMent = new MeasureMent();
        assertTrue(measureMent.isEndLargerFront(168,190));
    }

    @Test
    public void should_give_false_when_end_largerThat_front(){
        MeasureMent measureMent = new MeasureMent();
        assertFalse(measureMent.isEndLargerFront(190,168));
    }
    @Test
    public void should_give_false_when_front_is_not_exist(){
        MeasureMent measureMent = new MeasureMent();
        assertFalse(measureMent.isEndLargerFront(null,190));
    }

    @Test
    public void should_give_0_when_measurements_is_0(){
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        assertThat(measureMent.getLargerTimes(),is(0));
    }

    @Test
    public void should_give_0_when_measurements_is_1(){
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        assertThat(measureMent.getLargerTimes(),is(0));
    }

    @Test
    public void should_give_1_when_measurements_is_2_when_end_largerThat_front(){
        this.measurements.add(168);
        this.measurements.add(190);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        assertThat(measureMent.getLargerTimes(),is(1));
    }
    @Test
    public void should_give_0_when_measurements_is_2_when_front_largerThat_end(){
        this.measurements.add(190);
        this.measurements.add(168);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        assertThat(measureMent.getLargerTimes(),is(0));
    }
    @Test
    public void should_give_0_when_measurements_is_3_when_first_largerThat_second_and_second_largerThat_third(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        assertThat(measureMent.getLargerTimes(),is(0));
    }
    @Test
    public void should_give_1_when_measurements_is_4_when_first_largerThat_second_and_second_largerThat_third_and_third_lessThat_forth(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        this.measurements.add(170);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",this.measurements);
        assertThat(measureMent.getLargerTimes(),is(1));
    }
    @Test
    public void should_return_sum_when_given_sliding_window(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",this.measurements);
        assertThat(measureMent.getLargerTimes(),is(0));
    }
    @Test
    public void should_return_0_when_given_first_largerThat_forth(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        this.measurements.add(170);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",this.measurements);
        assertThat(measureMent.getLargerTimes(),is(0));
    }
    @Test
    public void should_return_1_when_given_forth_largerThat_first(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        this.measurements.add(200);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",this.measurements);
        assertThat(measureMent.getLargerTimes(),is(1));
    }
    @Test
    public void should_return_2_when_given_forth_largerThat_first_and_fifth_largerThat_second(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        this.measurements.add(200);
        this.measurements.add(201);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",this.measurements);
        assertThat(measureMent.getLargerTimes(),is(2));
    }
    @Test
    public void should_return_1_when_given_forth_largerThat_first_and_second_largerThat_fifth(){
        this.measurements.add(190);
        this.measurements.add(168);
        this.measurements.add(166);
        this.measurements.add(200);
        this.measurements.add(163);
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",this.measurements);
        assertThat(measureMent.getLargerTimes(),is(1));
    }

}
