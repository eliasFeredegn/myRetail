package com.myretail.myRetail.exception;

public class ProductException extends Exception {
    private static final long serialVersionUID = 1L;

    private String errCode;
    private Exception errException;
    private String errMsg;

    public ProductException(String errCode, Exception e) {
        super(e);
        this.errCode = errCode;
        this.errException = e;
    }

    public ProductException(String errorCd, String msg) {
        super();
        this.errCode = errorCd;
        this.errMsg = msg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * @return the errException
     */
    public Exception getErrException() {
        return errException;
    }

    /**
     * @param errException
     *            the errException to set
     */
    public void setErrException(Exception errException) {
        this.errException = errException;
    }

    /**
     * @return the errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * @param errMsg
     *            the errMsg to set
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}