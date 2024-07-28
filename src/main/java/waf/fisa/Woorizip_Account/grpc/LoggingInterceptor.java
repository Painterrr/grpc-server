package waf.fisa.Woorizip_Account.grpc;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        log.info("** Call method: {}", call.getMethodDescriptor().getFullMethodName());
        log.info("** Headers: {}", headers);
        return next.startCall(new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
            @Override
            public void sendMessage(RespT message) {
                log.info("** Response: {}", message);
                super.sendMessage(message);
            }
        }, headers);
    }
}
