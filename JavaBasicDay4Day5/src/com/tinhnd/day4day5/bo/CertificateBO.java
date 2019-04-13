package com.tinhnd.day4day5.bo;

import java.util.Date;

import com.tinhnd.day4day5.dao.CertificateDAO;

public class CertificateBO {
    CertificateDAO certificateDAO = new CertificateDAO();
    public boolean addCertificate(String certificatedID, String certificateName,String certificateRank,Date certificatedDate, String CandidateID) {
        return certificateDAO.addCertificate(certificatedID, certificateName, certificateRank, certificatedDate, CandidateID);
    }
}
