package org.HW_191223.task_2.client;

import org.HW_191223.task_2.id.generator.UniqueIdGenerator;

public class Client {
    private  int clientId;

    public Client() {
        this.clientId = UniqueIdGenerator.generateUniqueId();
    }

    public int getClientId() {
        return clientId;
    }
}
