package waf.fisa.Woorizip_Account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import waf.fisa.Woorizip_Account.dto.AccountReqDto;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Table(name = "Account")
public class Account {

    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 닉네임
     */
    @Column(nullable = false)
    private String nickname;

    /**
     * 휴대폰 번호
     */
    @Column(nullable = false)
    private String phone;

    /**
     * 계정 역할 구분
     * admin: 1
     * client: 2
     * relator: 3
     * guest: 4
     */
    @Column(nullable = false)
    private String role;

    /**
     * relator(중개사) 자격증.
     */
    private String licenseId;

    /**
     * 구독 날짜
     */
    private LocalDate premiumDate;

    @Builder
    public Account(String id, String nickname, String phone, String role, String licenseId, LocalDate premiumDate) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.role = role;
        this.licenseId = licenseId;
        this.premiumDate = premiumDate;
    }

    public void update(String nickname, String phone, String role, String licenseId, LocalDate premiumDate) {
        this.nickname = nickname;
        this.phone = phone;
        this.role = role;
        this.licenseId = licenseId;
        this.premiumDate = premiumDate;
    }
}
