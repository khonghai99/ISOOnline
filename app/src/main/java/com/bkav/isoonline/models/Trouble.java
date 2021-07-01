package com.bkav.isoonline.models;

import java.util.Date;

public class Trouble {
    private int ID;
    private String Code;
    private String Name;
    private int EmergencyTypeID;
    private String ProblemEmergencyName;
    private int ProblemTypeID;
    private String ProblemTypeName;
    private int CriticalLevelID;
    private String CriticalLevelName;
    private int ProblemGroupID;
    private String ProblemGroupName;
    private String OccuredDate;
    private String ResolvedDate;
    private String Description;
    private String Reason;
    private String Propose;
    private String Solution;
    private String Result;
    private int StatusID;
    private String ProblemStatusName;
    private String CreatedAt;
    private int CreatedBy;
    private String UpdatedAt;
    private int UpdatedBy;
    private boolean IsProblemOrEvent;
    private boolean IsDelete;
    private int Reporter;
    private String ContactNumber;
    private String ReporterEmail;
    private String ReporterDepartment;
    private String Receiver;
    private boolean IsTemplate;
    private boolean RequestDepID;
    private String RequestDepName;
    private int ResidentAgencyID;
    private String ResidentAgencyName;
    private int ResidentAgencyGroupID;
    private String ResidentAgencyGroupName;
    private String YourselfFix;
    private String OnDuty;
    private int ReceiverDepID;
    private String lng;
    private String lat;
    private String mNameTrouble;
    private String mLevel;
    private String mDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEmergencyTypeID() {
        return EmergencyTypeID;
    }

    public void setEmergencyTypeID(int emergencyTypeID) {
        EmergencyTypeID = emergencyTypeID;
    }

    public String getProblemEmergencyName() {
        return ProblemEmergencyName;
    }

    public void setProblemEmergencyName(String problemEmergencyName) {
        ProblemEmergencyName = problemEmergencyName;
    }

    public int getProblemTypeID() {
        return ProblemTypeID;
    }

    public void setProblemTypeID(int problemTypeID) {
        ProblemTypeID = problemTypeID;
    }

    public String getProblemTypeName() {
        return ProblemTypeName;
    }

    public void setProblemTypeName(String problemTypeName) {
        ProblemTypeName = problemTypeName;
    }

    public int getCriticalLevelID() {
        return CriticalLevelID;
    }

    public void setCriticalLevelID(int criticalLevelID) {
        CriticalLevelID = criticalLevelID;
    }

    public String getCriticalLevelName() {
        return CriticalLevelName;
    }

    public void setCriticalLevelName(String criticalLevelName) {
        CriticalLevelName = criticalLevelName;
    }

    public int getProblemGroupID() {
        return ProblemGroupID;
    }

    public void setProblemGroupID(int problemGroupID) {
        ProblemGroupID = problemGroupID;
    }

    public String getProblemGroupName() {
        return ProblemGroupName;
    }

    public void setProblemGroupName(String problemGroupName) {
        ProblemGroupName = problemGroupName;
    }

    public String getOccuredDate() {
        return OccuredDate;
    }

    public void setOccuredDate(String occuredDate) {
        OccuredDate = occuredDate;
    }

    public String getResolvedDate() {
        return ResolvedDate;
    }

    public void setResolvedDate(String resolvedDate) {
        ResolvedDate = resolvedDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getPropose() {
        return Propose;
    }

    public void setPropose(String propose) {
        Propose = propose;
    }

    public String getSolution() {
        return Solution;
    }

    public void setSolution(String solution) {
        Solution = solution;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int statusID) {
        StatusID = statusID;
    }

    public String getProblemStatusName() {
        return ProblemStatusName;
    }

    public void setProblemStatusName(String problemStatusName) {
        ProblemStatusName = problemStatusName;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(int createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public boolean isProblemOrEvent() {
        return IsProblemOrEvent;
    }

    public void setProblemOrEvent(boolean problemOrEvent) {
        IsProblemOrEvent = problemOrEvent;
    }

    public boolean isDelete() {
        return IsDelete;
    }

    public void setDelete(boolean delete) {
        IsDelete = delete;
    }

    public int getReporter() {
        return Reporter;
    }

    public void setReporter(int reporter) {
        Reporter = reporter;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getReporterEmail() {
        return ReporterEmail;
    }

    public void setReporterEmail(String reporterEmail) {
        ReporterEmail = reporterEmail;
    }

    public String getReporterDepartment() {
        return ReporterDepartment;
    }

    public void setReporterDepartment(String reporterDepartment) {
        ReporterDepartment = reporterDepartment;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public boolean isTemplate() {
        return IsTemplate;
    }

    public void setTemplate(boolean template) {
        IsTemplate = template;
    }

    public boolean isRequestDepID() {
        return RequestDepID;
    }

    public void setRequestDepID(boolean requestDepID) {
        RequestDepID = requestDepID;
    }

    public String getRequestDepName() {
        return RequestDepName;
    }

    public void setRequestDepName(String requestDepName) {
        RequestDepName = requestDepName;
    }

    public int getResidentAgencyID() {
        return ResidentAgencyID;
    }

    public void setResidentAgencyID(int residentAgencyID) {
        ResidentAgencyID = residentAgencyID;
    }

    public String getResidentAgencyName() {
        return ResidentAgencyName;
    }

    public void setResidentAgencyName(String residentAgencyName) {
        ResidentAgencyName = residentAgencyName;
    }

    public int getResidentAgencyGroupID() {
        return ResidentAgencyGroupID;
    }

    public void setResidentAgencyGroupID(int residentAgencyGroupID) {
        ResidentAgencyGroupID = residentAgencyGroupID;
    }

    public String getResidentAgencyGroupName() {
        return ResidentAgencyGroupName;
    }

    public void setResidentAgencyGroupName(String residentAgencyGroupName) {
        ResidentAgencyGroupName = residentAgencyGroupName;
    }

    public String getYourselfFix() {
        return YourselfFix;
    }

    public void setYourselfFix(String yourselfFix) {
        YourselfFix = yourselfFix;
    }

    public String getOnDuty() {
        return OnDuty;
    }

    public void setOnDuty(String onDuty) {
        OnDuty = onDuty;
    }

    public int getReceiverDepID() {
        return ReceiverDepID;
    }

    public void setReceiverDepID(int receiverDepID) {
        ReceiverDepID = receiverDepID;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getmNameTrouble() {
        return mNameTrouble;
    }

    public void setmNameTrouble(String mNameTrouble) {
        this.mNameTrouble = mNameTrouble;
    }

    public String getmLevel() {
        return mLevel;
    }

    public void setmLevel(String mLevel) {
        this.mLevel = mLevel;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public Trouble() {
    }

    public Trouble(String name, String problemEmergencyName, String createdAt) {
        Name = name;
        ProblemEmergencyName = problemEmergencyName;
        CreatedAt = createdAt;
    }


}
