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

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(call, headers)) {
            @Override
            public void onMessage(ReqT message) {
                log.info("** Received message: {}", message);
                super.onMessage(message);
            }

            @Override
            public void onComplete() {
                log.info("** Call completed");
                super.onComplete();
            }
        };
    }
}
