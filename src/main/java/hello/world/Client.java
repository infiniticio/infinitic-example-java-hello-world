package hello.world;

import hello.world.tasks.HelloWorldService;
import hello.world.workflows.HelloWorld;
import io.infinitic.pulsar.InfiniticClient;
import javax.annotation.Nullable;

public class Client {
    public static void main(String[] args) {
        InfiniticClient client = InfiniticClient.fromFile("infinitic.yml");
        @Nullable String name = args.length>0 ? args[0] : null;

        // create a stub from HelloWorld interface
        HelloWorld helloWorld = client.workflow(HelloWorld.class);
        // dispatch a workflow
        client.async(helloWorld, w -> w.greet(name));

        client.close();
    }
}
