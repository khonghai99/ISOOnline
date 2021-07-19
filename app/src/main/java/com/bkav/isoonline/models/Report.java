package com.bkav.isoonline.models;

public class Report {
    private int ID;
    private int ProblemEventID;
    private String Name;
    private String Content;
    private String From;
    private String To;
    private int ReporterID;
    private String ReporterName;
    private String ReportDate;
    private String Status;
    private String Percent;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProblemEventID() {
        return ProblemEventID;
    }

    public void setProblemEventID(int problemEventID) {
        ProblemEventID = problemEventID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public int getReporterID() {
        return ReporterID;
    }

    public void setReporterID(int reporterID) {
        ReporterID = reporterID;
    }

    public String getReporterName() {
        return ReporterName;
    }

    public void setReporterName(String reporterName) {
        ReporterName = reporterName;
    }


    public String getReportDate() {
        return ReportDate;
    }

    public void setReportDate(String reportDate) {
        ReportDate = reportDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPercent() {
        return Percent;
    }

    public void setPercent(String percent) {
        Percent = percent;
    }

    public Report() {
    }

    public Report(int ID, int problemEventID, String name, String content, String from, String to, int reporterID, String reporterName, String reportDate, String status, String percent) {
        this.ID = ID;
        ProblemEventID = problemEventID;
        Name = name;
        Content = content;
        From = from;
        To = to;
        ReporterID = reporterID;
        ReporterName = reporterName;
        ReportDate = reportDate;
        Status = status;
        Percent = percent;
    }
}
