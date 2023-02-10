package com.ccsw.tutorial.loan.model;

import org.springframework.data.domain.Pageable;

/**
 * @author ccsw
 */
public class LoanSearchDto {

    private Pageable pageable;

    /**
     * @return pageable
     */
    public Pageable getPageable() {
        return pageable;
    }

    /**
     * @param pageable new value of {@link #getPageable}.
     */
    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

}