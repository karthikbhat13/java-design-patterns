package com.iluwatar.fanout.fanin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FanOutFanInTest {

  @Test
  public void fanOutFanInTest() {
    final List<Long> numbers = Arrays.asList(1L, 3L, 4L, 7L, 8L);

    final List<SquareNumberRequest> requests =
        numbers.stream().map(SquareNumberRequest::new).collect(Collectors.toList());

    final Consumer consumer = new Consumer(0L);

    final Long sumOfSquaredNumbers = FanOutFanIn.fanOutFanIn(requests, consumer);

    Assertions.assertEquals(139, sumOfSquaredNumbers);
  }
}
