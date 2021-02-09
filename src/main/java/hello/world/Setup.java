package hello.world;

import io.infinitic.pulsar.InfiniticAdmin;
import org.apache.pulsar.client.admin.PulsarAdmin;
import org.apache.pulsar.client.api.PulsarClientException;

public class Setup {
    public static void main(String[] args) throws PulsarClientException {
        PulsarAdmin pulsarAdmin = PulsarAdmin
                .builder()
                .serviceHttpUrl("http://localhost:8080")
                .build();

        InfiniticAdmin infiniticAdmin = new InfiniticAdmin(
                pulsarAdmin,
                "infinitic",
                "dev",
                null
        );
        infiniticAdmin.setupPulsar();
        infiniticAdmin.close();
    }
}
