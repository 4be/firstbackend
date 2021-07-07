package com.example.firstbackend.dto;

import java.util.ArrayList;
import java.util.List;
// Object encapsulasi data yang akan dikirm server ke client
public class ResponseData<T> { // jadi generic
    private boolean status;
    private List<String> messages = new ArrayList<>();     //penampung message error
    private T payload;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}

