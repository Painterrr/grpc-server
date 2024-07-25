package waf.fisa.Woorizip_Account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 1552465796L;

    public static final QAccount account = new QAccount("account");

    public final StringPath id = createString("id");

    public final StringPath licenseId = createString("licenseId");

    public final StringPath nickname = createString("nickname");

    public final StringPath phone = createString("phone");

    public final DatePath<java.time.LocalDate> premiumDate = createDate("premiumDate", java.time.LocalDate.class);

    public final StringPath role = createString("role");

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

