package de.romankoutny.mschatapp.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by XHU6032 on 09.04.2017.
 */

public class QnA
{
    @SerializedName("answer")
    private String answer;
    @SerializedName("score")
    private double score;


    public QnA(String answer, double score)
    {
        this.answer = answer;
        this.score = score;
    }

}
