package io.github.MatheusFSantos.Kernel.KNUsers.model.exception;

import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UsersException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> messages;

    private String description;

    private Integer status;

    private LocalDateTime date;

    public UsersException(List<String> messages, String  description, Integer status, LocalDateTime date) {
        this.messages = messages;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public UsersException(String messages, String  description, Integer status, LocalDateTime date) {
        this.messages = Collections.singletonList(messages);
        this.description = description;
        this.status = status;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersException that = (UsersException) o;
        return Objects.equals(messages, that.messages) && Objects.equals(description, that.description) && Objects.equals(status, that.status) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages, description, status, date);
    }

    @Override
    public String toString() {
        return "UsersException{" +
                "messages=" + messages +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
