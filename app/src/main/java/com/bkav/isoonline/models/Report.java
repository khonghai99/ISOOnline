package com.bkav.isoonline.models;

public class Report {
    private String mNameReport;
    private String mPeopleReport;
    private String mDateCreateReport;

    public String getmNameReport() {
        return mNameReport;
    }

    public void setmNameReport(String mNameReport) {
        this.mNameReport = mNameReport;
    }

    public String getmPeopleReport() {
        return mPeopleReport;
    }

    public void setmPeopleReport(String mPeopleReport) {
        this.mPeopleReport = mPeopleReport;
    }

    public String getmDateCreateReport() {
        return mDateCreateReport;
    }

    public void setmDateCreateReport(String mDateCreateReport) {
        this.mDateCreateReport = mDateCreateReport;
    }

    public Report(String mNameReport, String mPeopleReport, String mDateCreateReport) {
        this.mNameReport = mNameReport;
        this.mPeopleReport = mPeopleReport;
        this.mDateCreateReport = mDateCreateReport;
    }

}
