package aws.lambda.practice.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

@SuppressWarnings(value = "deprecation")
public class MyRequestHandler extends SpringBootRequestHandler<String,Object> {
}
