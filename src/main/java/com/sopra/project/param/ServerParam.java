package com.sopra.project.param;

/**
 * @author Meriem Aboudi
 */
public class ServerParam {

    private String text;
    private String value;

    public ServerParam() {
    }

    public ServerParam(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
