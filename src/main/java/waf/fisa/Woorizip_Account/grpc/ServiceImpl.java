package waf.fisa.Woorizip_Account.grpc;

import com.example.grpcinterface.lib.AccountIdReq;
import com.example.grpcinterface.lib.PhoneResp;
import com.example.grpcinterface.lib.RequirementAccountServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import waf.fisa.Woorizip_Account.repository.Repository;

@GrpcService
@Slf4j
public class ServiceImpl extends RequirementAccountServiceGrpc.RequirementAccountServiceImplBase {

    private Repository repository;

    @Autowired
    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    /**
     * @param req: AccountId
     * @param responseObserver: phone
     */
    @Override
    public void getPhone(AccountIdReq req, StreamObserver<PhoneResp> responseObserver) {
        String phone = repository.findByAccountId(req.getAccountId());

        log.info("[in GrpcService, AccountId: {}, phone: {}", req.getAccountId(), phone);

        responseObserver.onNext(
                PhoneResp.newBuilder()
                .setPhone(phone)
                .build()
        );

        responseObserver.onCompleted();
    }

}
