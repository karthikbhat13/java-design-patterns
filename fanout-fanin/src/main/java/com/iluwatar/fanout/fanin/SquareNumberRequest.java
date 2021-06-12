package com.iluwatar.fanout.fanin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Squares the number with a little timeout to give impression of long running process that return
 * at different times.
 */
@Slf4j
@AllArgsConstructor
public class SquareNumberRequest {

  private final Long number;

  /**
   * Squares the number with a little timeout to give impression of long running process that return
   * at different times.
   * @param consumer callback class that takes the result after the delay.
   * */
  public void delayedSquaring(final Consumer consumer) {
    long maxTimeOut = 7000L;
    long minTimeOut = 5000L;

    try {
      // this will make the thread sleep from 5-7s.
      Thread.sleep((long) (Math.random() * (maxTimeOut - minTimeOut) + minTimeOut));
    } catch (InterruptedException e) {
      LOGGER.error("Exception while sleep ", e);
    } finally {
      consumer.add(number * number);
    }
  }
}
