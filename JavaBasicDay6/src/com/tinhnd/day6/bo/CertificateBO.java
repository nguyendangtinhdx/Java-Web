package com.tinhnd.day6.bo;

import java.util.Date;

import com.tinhnd.day6.dao.CertificateDAO;

public class CertificateBO {
    CertificateDAO certificateDAO = new CertificateDAO();
    public boolean addCertificate(String certificatedID, String certificateName,String certificateRank,Date certificatedDate, String CandidateID) {
        return certificateDAO.addCertificate(certificatedID, certificateName, certificateRank, certificatedDate, CandidateID);
    }
}
