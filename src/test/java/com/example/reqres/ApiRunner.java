package com.example.reqres;

import com.intuit.karate.junit5.Karate;

public class ApiRunner {

    @Karate.Test
    Karate testAll(){
        return Karate.run("usuarios").relativeTo(getClass());
    }

}
