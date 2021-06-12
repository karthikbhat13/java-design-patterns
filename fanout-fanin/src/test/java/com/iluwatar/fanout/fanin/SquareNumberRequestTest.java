package com.iluwatar.fanout.fanin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareNumberRequestTest {

  @Test
  public void delayedSquaringTest() {
    Consumer consumer = new Consumer(10L);

    SquareNumberRequest squareNumberRequest = new SquareNumberRequest(5L);

    squareNumberRequest.delayedSquaring(consumer);

    Assertions.assertEquals(35, consumer.getSumOfSquaredNumbers().get());
  }
}
