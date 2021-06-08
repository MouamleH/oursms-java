
package me.mouamle.oursms.retrofit.model.response;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;
import java.util.Objects;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SentMessageData {

    @Expose
    private List<String> messageId;
    @Expose
    private String number;
    @Expose
    private String status;

    public List<String> getMessageId() {
        return messageId;
    }

    public void setMessageId(List<String> messageId) {
        this.messageId = messageId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentMessageData that = (SentMessageData) o;
        return Objects.equals(messageId, that.messageId) && Objects.equals(number, that.number) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, number, status);
    }

    @Override
    public String toString() {
        return "SentMessageData{" +
                "messageId=" + messageId +
                ", number='" + number + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
