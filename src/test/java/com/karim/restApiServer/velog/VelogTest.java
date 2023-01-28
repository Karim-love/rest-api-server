package com.karim.restApiServer.velog;

import org.junit.jupiter.api.*;

class VelogTest {

    @BeforeAll
    static void BeforeAll(){
        System.out.println( "BeforeAll method" );
    }

    @AfterAll
    static void AfterAll(){
        System.out.println( "AfterAll method" );
    }

    @BeforeEach
    public void BeforeEach(){
        System.out.println( "BeforeEach method" );
    }

    @AfterEach
    public void AfterEach(){
        System.out.println( "AfterEach method" );
    }

    @Test
    public void Test0(){
        System.out.println( "Test0 method" );
    }

    @Test
    public void Test1(){
        System.out.println( "Test1 method" );
    }

    @Test
    public void Test2(){
        System.out.println( "Test2 method" );
    }
}
