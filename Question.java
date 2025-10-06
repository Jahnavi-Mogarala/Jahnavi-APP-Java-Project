package com.jpquizbot.model;

import java.util.List;

public class Question {
    private String id;
    private String q;
    private List<String> choices;
    private int answer;
    private String explanation;
    private String code; // optional

    public Question() {}

    public Question(String id, String q, List<String> choices, int answer, String explanation) {
        this.id = id;
        this.q = q;
        this.choices = choices;
        this.answer = answer;
        this.explanation = explanation;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getQ() { return q; }
    public void setQ(String q) { this.q = q; }
    public List<String> getChoices() { return choices; }
    public void setChoices(List<String> choices) { this.choices = choices; }
    public int getAnswer() { return answer; }
    public void setAnswer(int answer) { this.answer = answer; }
    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
