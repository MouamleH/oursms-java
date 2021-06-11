package me.mouamle.oursms.retrofit;

import me.mouamle.oursms.retrofit.model.request.OTPMessageRequest;
import me.mouamle.oursms.retrofit.model.request.OneMessageRequest;
import me.mouamle.oursms.retrofit.model.response.MessageStatus;
import me.mouamle.oursms.retrofit.model.response.SMSResponse;
import me.mouamle.oursms.retrofit.model.response.SentMessageData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface OursmsApi {

    @POST("v1/SMS/Add/SendOneSms")
    Call<SMSResponse<SentMessageData>> sendOneSms(@Body OneMessageRequest request);

    @POST("v1/SMS/Add/SendOtpSms")
    Call<SMSResponse<SentMessageData>> sendOTP(@Body OTPMessageRequest request);

    @GET("v1/SMS/Get/GetStatus/{message_id}")
    Call<SMSResponse<List<MessageStatus>>> getMessageStatus(@Path("message_id") String messageId);

    static OursmsApi getInstance() {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OursmsApi.class);
    }

}
