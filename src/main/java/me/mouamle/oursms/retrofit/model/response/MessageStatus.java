
package me.mouamle.oursms.retrofit.model.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.util.Objects;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MessageStatus {

    @Expose
    private String doneDate;
    @Expose
    private String mobileNumber;
    @Expose
    private String senderId;
    @Expose
    private String status;
    @Expose
    private String submitDate;

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageStatus that = (MessageStatus) o;
        return Objects.equals(doneDate, that.doneDate) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(senderId, that.senderId) && Objects.equals(status, that.status) && Objects.equals(submitDate, that.submitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doneDate, mobileNumber, senderId, status, submitDate);
    }

    @Override
    public String toString() {
        return "MessageStatus{" +
                "doneDate='" + doneDate + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", senderId='" + senderId + '\'' +
                ", status='" + status + '\'' +
                ", submitDate='" + submitDate + '\'' +
                '}';
    }

}
