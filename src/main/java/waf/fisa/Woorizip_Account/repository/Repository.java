package waf.fisa.Woorizip_Account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import waf.fisa.Woorizip_Account.entity.Account;

public interface Repository extends JpaRepository<Account, String> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.nickname = :nickname")
    Boolean existedByNickname(String nickname);

    @Query("SELECT a.phone FROM Account a WHERE a.id = :accountId")
    String findByAccountId(String accountId);
}
