
package me.mouamle.oursms.retrofit.model.request;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class SMSRequest {

    @Expose
    private String key;
    @Expose
    private Long userId;
    @Expose
    private String phoneNumber;

    protected SMSRequest(String key, Long userId, String phoneNumber) {
        this.key = key;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SMSRequest that = (SMSRequest) o;
        return Objects.equals(key, that.key) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, phoneNumber, userId);
    }

    @Override
    public String toString() {
        return "SMSRequest{" +
                "key='" + key + '\'' +
                ", userId=" + userId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
