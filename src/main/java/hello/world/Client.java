package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.clients.InfiniticClient;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class Client {
    public static void main(String[] args) throws IOException {
        try(InfiniticClient client = InfiniticClient.fromYamlResource("/infinitic.yml")) {
            // create a stub from HelloWorld interface
            HelloWorld helloWorld = client.newWorkflow(HelloWorld.class);

            int i = 0;
            CompletableFuture<?>[] futures = new CompletableFuture<?>[10];
            while (i < 10) {
                // asynchronous dispatch of a workflow
                String strI = String.valueOf(i);
                futures[i] = client.dispatchAsync(helloWorld::greet, strI)
                        .thenApply( (deferred) ->  {
                            System.out.println("Workflow " + deferred.getId() + " (" + strI + ") dispatched!");

                            return null;
                        })
                        .exceptionally( (error) -> {
                            System.err.println("Failed to dispatch (" + strI + "): "  + error.toString());

                            return null;
                        });
                i++;
            }
            CompletableFuture.allOf(futures).join();
        }
    }
}
