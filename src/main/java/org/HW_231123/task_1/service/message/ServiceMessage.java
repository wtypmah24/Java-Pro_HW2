package org.HW_231123.task_1.service.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServiceMessage {
    private String serviceName;
    private int code;
    private String userMessage;
    private boolean error;
    private List<SupportContact> supportContacts;
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class SupportContact{
        private int id;
        private String phone;
        private String email;
    }
}