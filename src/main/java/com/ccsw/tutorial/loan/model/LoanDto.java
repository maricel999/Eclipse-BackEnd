package com.ccsw.tutorial.loan.model;

import java.util.Date;

import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.game.model.GameDto;

public class LoanDto {

    private Long id;

    private GameDto game;

    private ClientDto client;

    private Date dateStart;

    private Date dateEnd;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id new value of {@link #getid}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return game
     */
    public GameDto getGame() {
        return game;
    }

    /**
     * @param game new value of {@link #getGame}.
     */
    public void setGame(GameDto game) {
        this.game = game;
    }

    /**
     * @return client
     */
    public ClientDto getClient() {
        return client;
    }

    /**
     * @param client new value of {@link #getClient}.
     */
    public void setClient(ClientDto client) {
        this.client = client;
    }

    /**
     * @return dateStart
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart new value of {@link #getDateStart}.
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return dateEnd
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd new value of {@link #getDateEnd}.
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}