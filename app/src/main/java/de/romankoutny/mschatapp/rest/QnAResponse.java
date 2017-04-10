package de.romankoutny.mschatapp.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by XHU6032 on 09.04.2017.
 */

public class QnAResponse
{
    @SerializedName("answer")
    private String answer;
    @SerializedName("score")
    private double score;

    public double getScore()
    {
        return score;
    }

    public String getAnswer()
    {
        return answer;
    }
}
