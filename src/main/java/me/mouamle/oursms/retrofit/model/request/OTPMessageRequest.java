package me.mouamle.oursms.retrofit.model.request;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class OTPMessageRequest extends SMSRequest {

    @Expose
    private String otp;

    public OTPMessageRequest(String key, Long userId, String phoneNumber, String otp) {
        super(key, userId, phoneNumber);
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OTPMessageRequest that = (OTPMessageRequest) o;
        return Objects.equals(otp, that.otp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), otp);
    }

    @Override
    public String toString() {
        return "OTPMessageRequest{" +
                "otp='" + otp + '\'' +
                "} " + super.toString();
    }

}
