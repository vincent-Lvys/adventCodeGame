package com.lvxus.powercomsumptionTest;

import com.google.common.collect.Lists;
import com.lvxus.powercomsumption.PowerComsumption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PowerComsumptionTest {


    @Test
    public void should_return_gamma_1_when_given_1() {
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("1");
        assertThat(powerComsumption.getGammaRate(report),is("1"));
    }

    @Test
    public void should_return_gamma_1_when_given_1_0(){
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("1", "0");
        assertThat(powerComsumption.getGammaRate(report),is("1"));
    }

    @Test
    public void should_return_gamma_10_when_given_10_10(){
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("10", "10");
        assertThat(powerComsumption.getGammaRate(report),is("10"));
    }
    @Test
    public void should_return_gamma_101_when_given_101_101(){
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("101", "101");
        assertThat(powerComsumption.getGammaRate(report),is("101"));
    }
    @Test
    public void should_return_epsilon_1_when_given_1(){
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("1");
        assertThat(powerComsumption.getEpsilonRate(report),is("1"));
    }
    @Test
    public void should_return_epsilon_01_when_given_10_10_01(){
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("10","10","01");
        assertThat(powerComsumption.getEpsilonRate(report),is("01"));
    }
    @Test
    public void should_return_epsilon_010_when_given_101_101_010(){
        PowerComsumption powerComsumption = new PowerComsumption();
        List<String> report = Lists.newArrayList("101","101","010");
        assertThat(powerComsumption.getEpsilonRate(report),is("010"));
    }

    @Test
    public void should_return_20_when_given_101_010(){
        PowerComsumption powerComsumption = new PowerComsumption();
        assertThat(powerComsumption.getComsumption("101","010"),is(20));
    }

}
