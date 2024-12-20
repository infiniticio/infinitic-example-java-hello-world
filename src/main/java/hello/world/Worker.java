package hello.world;

import io.infinitic.workers.InfiniticWorker;

public class Worker {
    public static void main(String[] args) {
        try(InfiniticWorker worker = InfiniticWorker.fromYamlResource("/infinitic.yml")) {
            worker.start();
        }
    }
}
