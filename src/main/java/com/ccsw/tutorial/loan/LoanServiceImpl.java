package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.ClientService;
import com.ccsw.tutorial.exceptions.DateReservedException;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    GameService gameService;

    @Autowired
    ClientService clientService;

    @Override
    public Page<Loan> findPage(LoanSearchDto dto, Long gameId, Long clientId, Date date) {

        return this.loanRepository.findAll(dto.getPageable(), gameId, clientId, date);

    }

    @Override
    public void save(LoanDto data) throws DateReservedException {

        Long gameId = data.getGame().getId();
        Long clientId = data.getClient().getId();
        Date dateStart = data.getDateStart();
        Date dateEnd = data.getDateEnd();

        List<Loan> gameReserved = this.loanRepository.gameReserved(gameId, dateStart, dateEnd);
        List<Loan> clientReserved = this.loanRepository.clientReserved(clientId, dateStart, dateEnd);

        if (gameReserved.size() > 0) {

            throw new DateReservedException(
                    "El mismo juego no puede estar prestado a dos clientes distintos en un mismo día");

        } else if (clientReserved.size() >= 2) {

            throw new DateReservedException(
                    "Un mismo cliente no puede tener prestados más de 2 juegos en un mismo día");
        } else {
            Loan loan = new Loan();

            BeanUtils.copyProperties(data, loan, "id", "game", "client");

            loan.setGame(gameService.get(data.getGame().getId()));
            loan.setClient(clientService.get(data.getClient().getId()));

            this.loanRepository.save(loan);
        }

    }

    @Override
    public void delete(Long id) {

        this.loanRepository.deleteById(id);

    }

}