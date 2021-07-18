package com.bkav.isoonline.Session;

public class Golobal {
    public static int idUser;
    public static String nameUser;
    public static String Reason;
    public static String Solution;
    public static String Status;

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Golobal.idUser = idUser;
    }


    public static String getNameUser() {
        return nameUser;
    }

    public static void setNameUser(String nameUser) {
        Golobal.nameUser = nameUser;
    }

    public static String getReason() {
        return Reason;
    }

    public static void setReason(String reason) {
        Reason = reason;
    }

    public static String getSolution() {
        return Solution;
    }

    public static void setSolution(String solution) {
        Solution = solution;
    }

    public static String getStatus() {
        return Status;
    }

    public static void setStatus(String status) {
        Status = status;
    }
}
