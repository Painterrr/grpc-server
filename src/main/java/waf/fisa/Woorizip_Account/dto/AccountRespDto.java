package waf.fisa.Woorizip_Account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRespDto {
    private String id;

    private String nickname;

    private String phone;

    private String role;

    private String licenseId;

    private LocalDate premiumDate;
}
