package waf.fisa.Woorizip_Account.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import waf.fisa.Woorizip_Account.dto.AccountDto;
import waf.fisa.Woorizip_Account.dto.AccountReqDto;
import waf.fisa.Woorizip_Account.dto.AccountRespDto;
import waf.fisa.Woorizip_Account.entity.Account;
import waf.fisa.Woorizip_Account.mapper.AccountMapper;
import waf.fisa.Woorizip_Account.repository.Repository;
import waf.fisa.Woorizip_Account.repository.RepositoryCustom;

import java.util.List;

@Slf4j
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private Repository repository;

    private RepositoryCustom repositoryCustom;

    private AccountMapper mapper;

    @Autowired
    public Service(Repository repository, RepositoryCustom repositoryCustom, AccountMapper mapper) {
        this.repository = repository;
        this.repositoryCustom = repositoryCustom;
        this.mapper = mapper;
    }

    public Boolean isRegistered (String nickname) {
        log.info("[in service]: {}", nickname);

        boolean isRegistered = repository.existedByNickname(nickname);

        return isRegistered;
    }

    /**
     * 계정 등록
     * @param accountReqDto
     * @return
     */
    public AccountRespDto save(AccountReqDto accountReqDto) {
        log.info("[in service]: {}", accountReqDto.toString());

        Account account = repository.save(mapper.fromReqDtoToEntity(accountReqDto));

        return mapper.fromEntitytoRespDto(account);
    }

    /**
     * 내 계정 보기
     * @param id
     * @return
     */
    public AccountRespDto readMine(String id) {
        log.info("[in service]: {}", id);

        Account account = repository.findById(id).orElseThrow(EntityExistsException::new);

        return mapper.fromEntitytoRespDto(account);
    }

    /**
     * 관리자: 계정 전체 조회
     * @param accountReqDto
     * @return
     */
    public List<AccountRespDto> readAll(AccountReqDto accountReqDto) {
        log.info("[in service]: {}", accountReqDto.toString());

        List<Account> list = repository.findAll();

        return convertListFromEntityToResp(list);
    }

    public List<AccountRespDto> convertListFromEntityToResp(List<Account> list) {
        return list.stream().map(account -> mapper.fromEntitytoRespDto(account)).toList();
    }

    /**
     * 관리자: 계정 필터검색
     * @param accountReqDto
     * @return
     */
    public List<AccountRespDto> readFilter(AccountReqDto accountReqDto) {
        log.info("[in service]: {}", accountReqDto.toString());

        List<AccountDto> list = repositoryCustom.findByBuilder(mapper.fromReqDtoToEntity(accountReqDto));

        return convertListFromDtoToResp(list);
    }

    public List<AccountRespDto> convertListFromDtoToResp(List<AccountDto> list) {
        return list.stream().map(accountDto -> mapper.fromDtoToRespDto(accountDto)).toList();
    }

    /**
     * 계정 수정
     * @param accountReqDto
     * @return
     */
    @Transactional
    public AccountRespDto update(AccountReqDto accountReqDto) {
        log.info("[in service]: {}", accountReqDto.toString());

        Account target = repository.findById(accountReqDto.getId()).orElseThrow(EntityNotFoundException::new);

        target.update(
                accountReqDto.getNickname(),
                accountReqDto.getPhone(),
                accountReqDto.getRole(),
                accountReqDto.getLicenseId(),
                accountReqDto.getPremiumDate()
        );

        Account updated = repository.save(target);

        return mapper.fromEntitytoRespDto(updated);
    }

    /**
     * 계정 삭제
     * @param accountId
     */
    @Transactional
    public void delete(String accountId) {
        log.info("[in service]: Deleting account with ID: {}", accountId);
        Account account = repository.findById(accountId).orElseThrow(EntityNotFoundException::new);
        repository.delete(account);
    }
}
