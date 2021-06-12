package com.iluwatar.fanout.fanin;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;



/**
 * Consumer or callback class that will be called everytime a request is complete This will
 * aggregate individual result to form a final result.
 */
@Getter
public class Consumer {

  private final AtomicLong sumOfSquaredNumbers;

  Consumer(Long init) {
    sumOfSquaredNumbers = new AtomicLong(init);
  }

  public Long add(final Long num) {
    return sumOfSquaredNumbers.addAndGet(num);
  }
}
