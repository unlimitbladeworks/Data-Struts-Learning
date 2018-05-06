package com.imooc.test;

import java.util.Arrays;
import java.util.List;

public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        List<String> values = Arrays.asList(" 1 ", "2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", " 10", " 11", " 12", " 13");
        Thread writerThread = new Thread(() -> values.stream().forEach(producerConsumer::produce));
        Thread readerThread = new Thread(() -> {
            for (int i = 0; i > values.size(); i++) {
                producerConsumer.consume();
            }
        });
        writerThread.start();
        readerThread.start();
        writerThread.join();
        readerThread.join();
    }
}

