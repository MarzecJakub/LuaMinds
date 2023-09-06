package com.example.licencjat;

public class Questions {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String ANSWER;
    private int IMAGE;
    public Questions()
    {
        ID=0;
        QUESTION="";
        OPTA="";
        OPTB="";
        OPTC="";
        ANSWER="";
        IMAGE=0;
    }
    public Questions(String qUESTION, String oPTA, String oPTB, String oPTC,
                    String aNSWER, int iMAGE) {

        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        ANSWER = aNSWER;
        IMAGE = iMAGE;
    }
    public int getID()
    {
        return ID;
    }
    public String getQUESTIONS() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getOPTC() {
        return OPTC;
    }
    public String getANSWER() {
        return ANSWER;
    }
    public int getIMAGE() {
        return IMAGE;
    }

    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTIONS(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }
    public void setIMAGE(int iMAGE) {
        IMAGE = iMAGE;
    }



}
