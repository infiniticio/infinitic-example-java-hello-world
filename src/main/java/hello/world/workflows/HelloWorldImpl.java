package hello.world.workflows;

import hello.world.tasks.HelloWorldService;
import io.infinitic.workflows.Deferred;
import io.infinitic.workflows.Workflow;

import static io.infinitic.workflows.DeferredKt.and;

public class HelloWorldImpl extends Workflow implements HelloWorld {
    private final HelloWorldService helloWorldService = newTask(HelloWorldService.class);

    @Override
    public String greet(String name) {
        String str = helloWorldService.sayHello(name);

        String greeting =  helloWorldService.addEnthusiasm(str);

        inline(() -> { System.out.println(greeting); return null; });

        return greeting;
    }
}
