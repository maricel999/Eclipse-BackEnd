package com.ccsw.tutorial.loan;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.exceptions.DateReservedException;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

public interface LoanService {

    Page<Loan> findPage(LoanSearchDto dto, Long gameId, Long clientId, Date date);

    void save(LoanDto data) throws DateReservedException;

    void delete(Long id);
}