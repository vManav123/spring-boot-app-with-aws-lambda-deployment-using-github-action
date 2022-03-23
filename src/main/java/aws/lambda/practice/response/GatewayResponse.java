package aws.lambda.practice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GatewayResponse {
    private String body;
    private Integer statusCode;
    private Map<String,String> headers;
    private boolean isBase64Encoded;
}
