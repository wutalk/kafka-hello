/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        if (args.length < 1) {
            showUsage();
            System.exit(0);
        }
        if (args[0].equalsIgnoreCase("producer")) {
            System.out.println("starting producer...");
            boolean isAsync = args.length == 1 || !args[1].trim().equalsIgnoreCase("sync");
            Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync);
            producerThread.start();
        } else if (args[0].equalsIgnoreCase("consumer")) {
            System.out.println("starting producer...");
            Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
            consumerThread.start();
        } else {
            showUsage();
        }
    }

    private static void showUsage() {
        System.out.println("Usage: java -jar kafka-hello-1.0-SNAPSHOT-jar-with-dependencies.jar [producer|consumer] " +
                "sync");
    }
}
