package com.tinhnd.day6.bean;

import java.util.Date;

/**
 * Certificate
 * 
 * Version 1.0
 * 
 * Date 16-1-2018
 * 
 * Copyright
 * 
 * Modification logs
 * DATE             AUTHOR              DESCRIPTION
 * ------------------------------------------------
 * 16-1-2018        TỉnhND               Create
 *
 */
public class CertificateBEAN extends CandidateBEAN{
    private String certificatedID;
    private String certificateName;
    private String certificateRank;
    private Date certificatedDate;
    public CertificateBEAN(String certificatedID, String certificateName,
            String certificateRank, Date certificatedDate) {
        super();
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }
    public String getCertificatedID() {
        return certificatedID;
    }
    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }
    public String getCertificateName() {
        return certificateName;
    }
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
    public String getCertificateRank() {
        return certificateRank;
    }
    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }
    public Date getCertificatedDate() {
        return certificatedDate;
    }
    public void setCertificatedDate(Date certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    @Override
    public int getCandidate_type() {
        // TODO Auto-generated method stub
        return 0;
    }
}
