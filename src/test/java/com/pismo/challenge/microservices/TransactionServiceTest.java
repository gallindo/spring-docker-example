package com.pismo.challenge.microservices;

import com.pismo.challenge.microservices.dao.AccountDao;
import com.pismo.challenge.microservices.dto.TransactionDto;
import com.pismo.challenge.microservices.dto.TransactionResultDto;
import com.pismo.challenge.microservices.exception.NegativeTransactionValueException;
import com.pismo.challenge.microservices.exception.TransactionAmountLimitException;
import com.pismo.challenge.microservices.model.Account;
import com.pismo.challenge.microservices.service.TransactionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class TransactionServiceTest {

    public static final BigDecimal AVAILABLE_CREDIT = BigDecimal.valueOf(100);
    public static final int OPERATION_TYPE_ID = 3;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountDao accountDao;

    private Account newAccount;

    @BeforeEach
    void createAccount() {

        Account account = new Account();

        account.setAvailableCreditLimit(AVAILABLE_CREDIT);
        account.setDocumentNumber("2345");

        accountDao.save(account);

        newAccount = account;
    }

    @AfterEach
    void removeAccount(){

        accountDao.delete(newAccount);
    }

    @Test
    void should_allow_debit_transction_with_value_lower_than_available_credit() {

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setAccountId(newAccount.getId());
        transactionDto.setAmount(AVAILABLE_CREDIT.min(BigDecimal.TEN));
        transactionDto.setOperationTypeId(OPERATION_TYPE_ID);

        TransactionResultDto transactionResultDto = transactionService.create(transactionDto);

        assertNotNull(transactionResultDto.getId());
    }

    @Test
    void should_not_allow_debit_transction_with_value_greater_than_available_credit() {

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setAccountId(newAccount.getId());
        transactionDto.setAmount(AVAILABLE_CREDIT.add(BigDecimal.TEN));
        transactionDto.setOperationTypeId(OPERATION_TYPE_ID);

        assertThrows(TransactionAmountLimitException.class, () -> transactionService.create(transactionDto));
    }

    @Test
    void should_not_allow_debit_transction_with_negative_value() {

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setAccountId(newAccount.getId());
        transactionDto.setAmount(BigDecimal.valueOf(-1));
        transactionDto.setOperationTypeId(OPERATION_TYPE_ID);

        assertThrows(NegativeTransactionValueException.class, () -> transactionService.create(transactionDto));
    }
}
