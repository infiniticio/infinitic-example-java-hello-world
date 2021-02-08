package hello.world;

import hello.world.tasks.HelloWorldService;
import hello.world.workflows.HelloWorld;
import io.infinitic.pulsar.InfiniticClient;

public class Client {
    public static void main(String[] args) {
        InfiniticClient client = InfiniticClient.fromConfigFile("infinitic.yml");
        String name = args.length>0 ? args[0] : "World";

        // create a stub from HelloWorld interface
        HelloWorld helloWorld = client.workflow(HelloWorld.class);

        // dispatch a workflow
        client.async(helloWorld, w -> w.greet("async " + name));

        // dispatch a workflow and get result
        String greetings = helloWorld.greet("sync " + name);

        System.out.println(greetings);

        client.close();
    }
}
