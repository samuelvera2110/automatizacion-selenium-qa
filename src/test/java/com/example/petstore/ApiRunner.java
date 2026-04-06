package com.example.petstore;

import com.intuit.karate.junit5.Karate;

public class ApiRunner {

    @Karate.Test
    Karate testAll(){
        return Karate.run("petstore").relativeTo(getClass());
    }

}
