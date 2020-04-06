package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){

        //System.getProperties() --> get all properties
        System.out.println(System.getProperty("user.dir"));
        //user.dir --> returns directory, so it will be always different in each computers
        ///Users/kabardeyo/IdeaProjects/Fall2019Selenium --> this will be different
        //that is why i use System.getProperty("user.dir") to see what directory this computer has
        //and i add /pom.xml at the end
        //System.getProperty("user.dir") + "/pom.xml" --> this is how its supposed to be
        ///Users/kabardeyo/IdeaProjects/Fall2019Selenium/pom.xml --> NOT THIS!!!!!!! ALWAYS DIFFERENT
        System.out.println(System.getProperty("os.name"));

        //System.getProperty("user.home")+"/Downloads" --> this is how i need to use
        //it is flexible and works for every computer
        System.out.println(System.getProperty("user.home"));

        String pathToDownloads = System.getProperty("user.home")+"/Downloads";

        System.out.println(pathToDownloads);

        System.out.println(System.getProperty("os.arch"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

        System.out.println(System.getProperty("user.name"));

    }

}
