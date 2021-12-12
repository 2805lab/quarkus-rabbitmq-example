package org.acme.rabbitmq.processor;

import io.smallrye.common.annotation.Blocking;
import org.acme.rabbitmq.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class QuoteProcessor {

    private Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    public Quote process(String quoteRequest) throws InterruptedException{
        Thread.sleep(100);
        return new Quote(quoteRequest, random.nextInt(100));
    }
}
