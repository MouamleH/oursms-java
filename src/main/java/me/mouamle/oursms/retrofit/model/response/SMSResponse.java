
package me.mouamle.oursms.retrofit.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.Objects;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SMSResponse<T> {

    @Expose
    private Long code;
    @Expose
    @SerializedName("data")
    private T sentMessageData;
    @Expose
    private String message;
    @Expose
    private Boolean status;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public T getData() {
        return sentMessageData;
    }

    public void setData(T sentMessageData) {
        this.sentMessageData = sentMessageData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SMSResponse that = (SMSResponse) o;
        return Objects.equals(code, that.code) && Objects.equals(sentMessageData, that.sentMessageData) && Objects.equals(message, that.message) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, sentMessageData, message, status);
    }

    @Override
    public String toString() {
        return "SMSResponse{" +
                "code=" + code +
                ", sentMessageData=" + sentMessageData +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

}
