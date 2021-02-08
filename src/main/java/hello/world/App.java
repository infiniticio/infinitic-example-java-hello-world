package hello.world;

import io.infinitic.pulsar.InfiniticWorker;

public class App {
    public static void main(String[] args) {
        InfiniticWorker.fromConfigFile("infinitic.yml").start();
    }
}
