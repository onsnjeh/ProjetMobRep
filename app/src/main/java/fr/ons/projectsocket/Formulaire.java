package fr.ons.projectsocket;


public class Formulaire {


    private String Q1;
    private String Q2;
    private String Q3;
    private String Q4;
    private String Q5;
    private String Q6;
    private String Q7;
    private static String id;
    public Formulaire(String id,String Q1,String Q2,String Q3,String Q4,String Q5,String Q6,String Q7) {
        this.id = id;
        this.Q1 = Q1;
        this.Q2 = Q2;
        this.Q3 = Q3;
        this.Q4 = Q4;
        this.Q5 = Q5;
        this.Q6 = Q6;
        this.Q7 = Q7;

    }


    public String getQ1() {
        return Q1;
    }

    public void setQ1(String Q1) {Q1 = Q1;
    }
    public String getQ2() {
        return Q2;
    }

    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }
    public String getQ3() {
        return Q3;
    }

    public void setQ3(String Q3) {
        this.Q3 = Q3;
    }
    public String getQ4() {
        return Q4;
    }

    public void setQ4(String Q4) {
        this.Q4 = Q4;
    }
    public String getQ5() {
        return Q5;
    }

    public void setQ5(String Q5) {
        this.Q5 = Q5;
    }
    public String getQ6() {
        return Q6;
    }

    public void setQ6(String Q6) {
        this.Q6 = Q6;
    }
    public String getQ7() {
        return Q7;
    }

    public void setQ7(String Q7) {
        this.Q7= Q7;
    }


    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




}
