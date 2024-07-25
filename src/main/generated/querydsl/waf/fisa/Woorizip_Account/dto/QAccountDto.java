package waf.fisa.Woorizip_Account.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * waf.fisa.Woorizip_Account.dto.QAccountDto is a Querydsl Projection type for AccountDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAccountDto extends ConstructorExpression<AccountDto> {

    private static final long serialVersionUID = 1415403651L;

    public QAccountDto(com.querydsl.core.types.Expression<String> id, com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<String> phone, com.querydsl.core.types.Expression<String> role, com.querydsl.core.types.Expression<String> licenseId, com.querydsl.core.types.Expression<java.time.LocalDate> premiumDate) {
        super(AccountDto.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, java.time.LocalDate.class}, id, nickname, phone, role, licenseId, premiumDate);
    }

}

