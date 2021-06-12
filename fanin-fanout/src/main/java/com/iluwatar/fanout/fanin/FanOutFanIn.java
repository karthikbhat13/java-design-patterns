package com.iluwatar.fanout.fanin;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * FanOutFanIn class processes long running requests, when any of the processes gets over, result is
 * passed over to the consumer or the callback function. Consumer will aggregate the results as they
 * keep on completing.
 */
public class FanOutFanIn {

  /**
   * the main fanOutFanIn function or orchestrator function.
   * @param requests List of numbers that need to be squared and summed up
   * @param consumer Takes in the squared number from {@link SquareNumberRequest} and sums it up
   * @return Aggregated sum of all squared numbers.
   */
  public static Long fanOutFanIn(
      final List<SquareNumberRequest> requests, final Consumer consumer) {

    ExecutorService service = Executors.newFixedThreadPool(requests.size());

    List<CompletableFuture<Void>> futures =
        requests.stream()
            .map(
                request ->
                    CompletableFuture.runAsync(() -> request.delayedSquaring(consumer), service))
            .collect(Collectors.toList());

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    return consumer.getSumOfSquaredNumbers().get();
  }
}
