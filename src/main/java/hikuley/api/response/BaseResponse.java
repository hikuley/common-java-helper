package hikuley.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

@ApiModel
public class BaseResponse {

    public static final class Builder {

        private String id;
        private Long timestamp;
        private boolean success = true;
        private String responseCode;
        private String responseMessage;
        private ResponseErrorDetail error;

        public BaseResponse build() {
            BaseResponse response = new BaseResponse();

            response.id = this.id;
            response.timestamp = this.timestamp;
            response.success = this.success;
            response.responseCode = this.responseCode;
            response.responseMessage = this.responseMessage;
            return response;
        }

        public Builder withError(ResponseErrorDetail error) {
            this.success = false;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withResponseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Builder withResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }

        public Builder withSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public Builder withTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }
    }

    @ApiModelProperty(required = true, notes = "Unique identifier of this response, should be the same if there is a related input request")
    @NotEmpty
    private String id;

    @NotNull
    @ApiModelProperty(required = true, notes = "When this response is generated in epoch milliseconds")
    private Long timestamp;

    private boolean success = true;

    @ApiModelProperty(required = true, notes = "Response code defining the business case or error of this response")
    private String responseCode;

    @ApiModelProperty(notes = "Default description for the response code")
    private String responseMessage;

    @ApiModelProperty(notes = "Optional detail of the error if the response is not success")
    private ResponseErrorDetail error;

    public BaseResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public BaseResponse(String id, boolean success) {
        this.id = id;
        this.success = success;
        this.timestamp = System.currentTimeMillis();
    }

    public BaseResponse(String id, boolean success, String responseCode) {
        this.id = id;
        this.success = success;
        this.responseCode = responseCode;
        this.timestamp = System.currentTimeMillis();
    }

    public BaseResponse(String id, boolean success, String responseCode, String responseMessage) {
        this.id = id;
        this.success = success;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseErrorDetail getError() {
        return error;
    }

    public String getId() {
        return id;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setError(ResponseErrorDetail error) {
        this.error = error;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseResponse.class.getSimpleName() + "[", "]").add("id='" + id + "'")
                .add("success=" + success).add("responseCode='" + responseCode + "'")
                .add("responseMessage='" + responseMessage + "'").toString();
    }

}
