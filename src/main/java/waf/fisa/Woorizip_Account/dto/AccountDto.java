package waf.fisa.Woorizip_Account.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AccountDto {
    private String id;

    private String nickname;

    private String phone;

    private String role;

    private String licenseId;

    private LocalDate premiumDate;

    @QueryProjection
    public AccountDto(String id, String nickname, String phone, String role,
                          String licenseId, LocalDate premiumDate) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.role = role;
        this.licenseId = licenseId;
        this.premiumDate = premiumDate;
    }
}
