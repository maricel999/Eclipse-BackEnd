package com.ccsw.tutorial.loan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.game.model.Game;

/**
 * @author ccsw
 */
@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "dateStart", nullable = false)
    private Date dateStart;

    @Column(name = "dateEnd", nullable = false)
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
    public Game getGame() {
        return game;
    }

    /**
     * @param game new value of {@link #getGame}.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client new value of {@link #getClient}.
     */
    public void setClient(Client client) {
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