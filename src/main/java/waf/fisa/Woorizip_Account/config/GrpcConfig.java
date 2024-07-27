package waf.fisa.Woorizip_Account.config;

import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import waf.fisa.Woorizip_Account.grpc.LoggingInterceptor;

@Configuration
public class GrpcConfig {

    @Bean
    @GrpcGlobalServerInterceptor
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}