package waf.fisa.Woorizip_Account.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import waf.fisa.Woorizip_Account.dto.AccountDto;
import waf.fisa.Woorizip_Account.dto.QAccountDto;
import waf.fisa.Woorizip_Account.entity.Account;
import waf.fisa.Woorizip_Account.entity.QAccount;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;
import static waf.fisa.Woorizip_Account.entity.QAccount.account;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<AccountDto> findByBuilder(Account input) {
        BooleanBuilder builder = new BooleanBuilder();

        log.info("[in RepositoryCustom]");

        if (input.getNickname() != null && !input.getNickname().isEmpty()) {
            builder.and(account.nickname.eq(input.getNickname()));
        }

        if (input.getPhone() != null && !input.getPhone().isEmpty()) {
            builder.and(account.phone.eq(input.getPhone()));
        }

        if (input.getRole() != null && !input.getRole().isEmpty()) {
            builder.and(account.role.eq(input.getRole()));
        }

        if (input.getLicenseId() != null && !input.getLicenseId().isEmpty()) {
            builder.and(account.licenseId.eq(input.getLicenseId()));
        }

        if (input.getPremiumDate() != null) {
            builder.and(account.premiumDate.eq(input.getPremiumDate()));
        }

        log.info("** in RepositoryCustom, builder: {}", builder);

        return queryFactory
                .select(new QAccountDto(
                        account.id,
                        account.nickname,
                        account.phone,
                        account.role,
                        account.licenseId,
                        account.premiumDate
                ))
                .from(account)
                .where(builder)
                .fetch();
    }
}
