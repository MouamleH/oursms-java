package me.mouamle.oursms.retrofit.model.reqeust;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class OneMessageRequest extends SMSRequest {

    @Expose
    @SerializedName("Message")
    private String message;

    public OneMessageRequest(String key, Long userId, String phoneNumber, String message) {
        super(key, userId, phoneNumber);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OneMessageRequest that = (OneMessageRequest) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }

    @Override
    public String toString() {
        return "OneMessageRequest{" +
                "message='" + message + '\'' +
                "} " + super.toString();
    }

}
