package com.ccsw.tutorial.loan;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.exceptions.DateReservedException;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author ccsw
 */
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    BeanMapper beanMapper;

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<LoanDto> findPage(@RequestBody LoanSearchDto dto,
            @RequestParam(value = "gameId", required = false) Long gameId,
            @RequestParam(value = "clientId", required = false) Long clientId,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        Page<Loan> page = this.loanService.findPage(dto, gameId, clientId, date);

        return this.beanMapper.mapPage(page, LoanDto.class);
    }

    /**
     * Método para crear un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param data datos de la entidad
     */
    @RequestMapping(path = { "" }, method = RequestMethod.PUT)
    public void save(@RequestBody LoanDto data) {

        try {
            this.loanService.save(data);
        } catch (DateReservedException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    /**
     * Método para eliminar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id PK de la entidad
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.loanService.delete(id);
    }
}