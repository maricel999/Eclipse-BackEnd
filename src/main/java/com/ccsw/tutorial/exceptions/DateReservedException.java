package com.ccsw.tutorial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Presatamo en ese intervalo de fechas no disponible")
public class DateReservedException extends Exception {

    public DateReservedException(String message) {
        super(message);
    }
}