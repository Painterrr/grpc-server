package waf.fisa.Woorizip_Account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waf.fisa.Woorizip_Account.dto.AccountReqDto;
import waf.fisa.Woorizip_Account.dto.AccountRespDto;
import waf.fisa.Woorizip_Account.service.Service;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    /**
     * 계정 등록
     * @param accountReqDto
     * @return ResponseEntity<AccountRespDto>
     */
    @PostMapping("/save")
    public ResponseEntity<AccountRespDto> createAccount(@RequestBody AccountReqDto accountReqDto) {
        AccountRespDto response = service.save(accountReqDto);
        return ResponseEntity.ok(response);
    }

    /**
     * 내 계정 보기
     * @param id
     * @return ResponseEntity<AccountRespDto>
     */
    @GetMapping("/mine")
    public ResponseEntity<AccountRespDto> getMyAccount(@RequestParam String id) {
        AccountRespDto response = service.readMine(id);
        return ResponseEntity.ok(response);
    }

    /**
     * 관리자: 계정 전체 조회
     * @return ResponseEntity<List<AccountRespDto>>
     */
    @GetMapping("/all")
    public ResponseEntity<List<AccountRespDto>> getAllAccounts() {
        List<AccountRespDto> response = service.readAll(new AccountReqDto());
        return ResponseEntity.ok(response);
    }

    /**
     * 관리자: 계정 필터 검색
     * @param accountReqDto
     * @return ResponseEntity<List<AccountRespDto>>
     */
    @PostMapping("/filter")
    public ResponseEntity<List<AccountRespDto>> readFilter(@RequestBody AccountReqDto accountReqDto) {
        List<AccountRespDto> response = service.readFilter(accountReqDto);
        return ResponseEntity.ok(response);
    }

    /**
     * 계정 수정
     * @param accountReqDto
     * @return ResponseEntity<AccountRespDto>
     */
    @PostMapping("/update")
    public ResponseEntity<AccountRespDto> update(@RequestBody AccountReqDto accountReqDto) {
        AccountRespDto response = service.update(accountReqDto);
        return ResponseEntity.ok(response);
    }

    /**
     * 계정 삭제
     * @param accountId
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") String accountId) {
        service.delete(accountId);
        return ResponseEntity.noContent().build();
    }
}
