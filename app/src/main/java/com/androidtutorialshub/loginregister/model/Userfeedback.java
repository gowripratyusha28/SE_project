package com.androidtutorialshub.loginregister.model;

public class Userfeedback {

    private int id;
    private String name;
    private String placename;
    private String placefeedback;
    private String generalfeedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getPlacefeedback() {
        return placefeedback;
    }

    public void setPlacefeedback(String placefeedback) {
        this.placefeedback = placefeedback;
    }

    public String getGeneralfeedback(){
        return generalfeedback;
    }

    public void setGeneralfeedback(String generalfeedback){
        this.generalfeedback = generalfeedback;
    }

}
