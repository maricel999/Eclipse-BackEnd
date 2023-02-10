package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.loan.model.Loan;

/**
 * @author ccsw
 */
public interface LoanRepository extends CrudRepository<Loan, Long> {

    /**
     * Método para recuperar un listado paginado con o sin filtros de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param page
     * @return
     */
    @Query("select l from Loan l where (:gameId is null or l.game.id = :gameId) and (:clientId is null or l.client.id = :clientId) and (:date is null or :date between l.dateStart and l.dateEnd)")
    Page<Loan> findAll(Pageable pageable, @Param("gameId") Long gameId, @Param("clientId") Long clientId,
            @Param("date") Date date);

    @Query("select l from Loan l where (l.game.id = :gameId) and ((:dateStart between l.dateStart and l.dateEnd) or (:dateEnd between l.dateStart and l.dateEnd))")
    List<Loan> gameReserved(@Param("gameId") Long gameId, @Param("dateStart") Date dateStart,
            @Param("dateEnd") Date dateEnd);

    @Query("select l from Loan l where (l.client.id = :clientId) and ((:dateStart between l.dateStart and l.dateEnd) or (:dateEnd between l.dateStart and l.dateEnd))")
    List<Loan> clientReserved(@Param("clientId") Long clientId, @Param("dateStart") Date dateStart,
            @Param("dateEnd") Date dateEnd);
}