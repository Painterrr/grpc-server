package waf.fisa.Woorizip_Account.grpc;

import io.grpc.*;

public class LoggingInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        System.out.println("** Call method: " + call.getMethodDescriptor().getFullMethodName());
        System.out.println("** Headers: " + headers);
        return next.startCall(new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
            @Override
            public void sendMessage(RespT message) {
                System.out.println("** Response: " + message);
                super.sendMessage(message);
            }
        }, headers);
    }
}
