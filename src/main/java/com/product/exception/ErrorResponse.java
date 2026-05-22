package com.product.exception;

public class ErrorResponse {
    private String messaggioErrore;
    private int status;

    public ErrorResponse(String messaggioErrore, int status) {
        this.messaggioErrore = messaggioErrore;
        this.status = status;
    }

    public String getMessaggioErrore() {
        return messaggioErrore;
    }

    public void setMessaggioErrore(String messaggioErrore) {
        this.messaggioErrore = messaggioErrore;
    }

    public int getStatus() {
        return status;
    }

    public void setStatusHttp(int status) {
        this.status = status;
    }

}
