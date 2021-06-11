package me.mouamle.oursms;

import me.mouamle.oursms.retrofit.OursmsApi;
import me.mouamle.oursms.retrofit.model.request.OTPMessageRequest;
import me.mouamle.oursms.retrofit.model.request.OneMessageRequest;
import me.mouamle.oursms.retrofit.model.response.MessageStatus;
import me.mouamle.oursms.retrofit.model.response.SMSResponse;
import me.mouamle.oursms.retrofit.model.response.SentMessageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OursmsClient {
    private static final Logger logger = LoggerFactory.getLogger(OursmsClient.class);

    private final long userId;
    private final String key;
    private final OursmsApi oursmsApi;

    /**
     * @param userId the user id obtained from your profile page
     * @param key    the key obtained from your profile page
     */
    public OursmsClient(long userId, String key) {
        this.userId = userId;
        this.key = Objects.requireNonNull(key);
        this.oursmsApi = OursmsApi.getInstance();
    }

    /**
     * @param mobile  destination mobile number
     * @param message message text
     * @return the sent message data
     * @throws IOException in case the request could not be sent due to an IO Error
     */
    public Optional<SentMessageData> sendOneMessage(String mobile, String message) throws IOException {
        final OneMessageRequest request = new OneMessageRequest(key, userId, mobile, message);
        final Call<SMSResponse<SentMessageData>> call = oursmsApi.sendOneSms(request);
        return executeMessageCall(call);
    }

    /**
     * @param mobile destination mobile number
     * @param otp    the otp to send, automatically added to a message body
     * @return the sent message data
     * @throws IOException in case the request could not be sent due to an IO Error
     */
    public Optional<SentMessageData> sendOTP(String mobile, int otp) throws IOException {
        final OTPMessageRequest request = new OTPMessageRequest(key, userId, mobile, String.valueOf(otp));
        final Call<SMSResponse<SentMessageData>> call = oursmsApi.sendOTP(request);
        return executeMessageCall(call);
    }

    /**
     * @param messageId the message id obtained from {@link SentMessageData#getMessageId()}
     * @return a list typically with one element, containing the message status info
     * @throws IOException in case the request could not be sent due to an IO Error
     */
    public List<MessageStatus> getMessageStatus(String messageId) throws IOException {
        final Call<SMSResponse<List<MessageStatus>>> call = oursmsApi.getMessageStatus(messageId);

        final Response<SMSResponse<List<MessageStatus>>> response = call.execute();
        if (!response.isSuccessful()) {
            logger.error("unsuccessful request {}", response.code());
            return Collections.emptyList();
        }

        final SMSResponse<List<MessageStatus>> body = response.body();
        if (body == null) {
            logger.error("fired a successful request but got an empty body, http status {}", response.code());
            return Collections.emptyList();
        }

        if (!body.getStatus()) {
            logger.error("got message from api {}", body.getMessage());
            return Collections.emptyList();
        }

        return body.getData();
    }

    private Optional<SentMessageData> executeMessageCall(Call<SMSResponse<SentMessageData>> call) throws IOException {
        final Response<SMSResponse<SentMessageData>> response = call.execute();
        if (!response.isSuccessful()) {
            logger.error("unsuccessful request {}", response.code());
            return Optional.empty();
        }

        final SMSResponse<SentMessageData> body = response.body();
        if (body == null) {
            logger.error("fired a successful request but got an empty body, http status {}", response.code());
            return Optional.empty();
        }

        if (!body.getStatus()) {
            logger.error("got message from api {}", body.getMessage());
            return Optional.empty();
        }

        return Optional.ofNullable(body.getData());
    }

}
