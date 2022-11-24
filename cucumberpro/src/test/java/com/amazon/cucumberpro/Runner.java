package com.amazon.cucumberpro;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features"},glue = {"com.amazon.cucumberpro"} 
,publish = true)
public class Runner {

}
