package com.job.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class JpaApplicationTests {

    @Test
    public void contextLoads() {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);

        if (optional.isPresent()){
            System.out.println("Yes");
        }

        System.out.println(optional.orElseThrow(() -> new RuntimeException("value is null")));
    }

}

