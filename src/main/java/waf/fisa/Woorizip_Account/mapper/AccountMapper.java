package waf.fisa.Woorizip_Account.mapper;

import org.springframework.stereotype.Component;
import waf.fisa.Woorizip_Account.dto.AccountDto;
import waf.fisa.Woorizip_Account.dto.AccountReqDto;
import waf.fisa.Woorizip_Account.dto.AccountRespDto;
import waf.fisa.Woorizip_Account.entity.Account;

import java.util.UUID;

@Component
public class AccountMapper {

    /**
     * AccountReqDto에서 Account 엔티티로 변환
     * @param dto AccountReqDto
     * @return Account 엔티티
     */
    public Account fromReqDtoToEntity(AccountReqDto dto) {
        return Account.builder()
                .id(UUID.randomUUID().toString())
                .nickname(dto.getNickname())
                .phone(dto.getPhone())
                .role(dto.getRole())
                .licenseId(dto.getLicenseId())
                .premiumDate(dto.getPremiumDate())
                .build();
    }

    /**
     * Account 엔티티에서 AccountRespDto로 변환
     * @param account Account 엔티티
     * @return AccountRespDto
     */
    public AccountRespDto fromEntitytoRespDto(Account account) {
        return AccountRespDto.builder()
                .id(account.getId())
                .nickname(account.getNickname())
                .phone(account.getPhone())
                .role(account.getRole())
                .licenseId(account.getLicenseId())
                .premiumDate(account.getPremiumDate())
                .build();
    }

    /**
     * AccountReqDto에서 AccountRespDto로 변환
     * @param dto AccountReqDto
     * @return AccountRespDto
     */
    public AccountRespDto fromReqDtoToRespDto(AccountReqDto dto) {
        Account account = fromReqDtoToEntity(dto);
        return fromEntitytoRespDto(account);
    }

    /**
     * AccountDto에서 AccountRespDto로 변환
     * @param dto AccountDto
     * @return AccountRespDto
     */
    public AccountRespDto fromDtoToRespDto(AccountDto dto) {
        return AccountRespDto.builder()
                .id(dto.getId())
                .nickname(dto.getNickname())
                .phone(dto.getPhone())
                .role(dto.getRole())
                .licenseId(dto.getLicenseId())
                .premiumDate(dto.getPremiumDate())
                .build();
    }
}
