package com.group.project;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultsDB implements Serializable {
    @SerializedName("results")
    private List<ResultModel> allResults = null;
    private static ResultsDB resultsDB = null;


    public static List<ResultModel> getAllResults() {
        return ResultsDB.getInstance().allResults;

    }

    public static ResultsDB getInstance() {
        if (resultsDB == null) {
            resultsDB = new ResultsDB();
        }
        return resultsDB;
    }

    public static void setInstance(ResultsDB rs) {
        if (rs != null) {
            resultsDB = rs;
        }
    }

    public static Boolean deleteResult(int resultId) {

        for (ResultModel rs : ResultsDB.getAllResults()) {

            if (rs.getId() == resultId) {
                ResultsDB.getAllResults().remove(rs);
                return true;
            }
        }
        return false;
    }

    public void addResult(ResultModel r) {
        if (allResults == null) {
            allResults = new ArrayList<ResultModel>();
        }
        allResults.add(r);
    }

    public static Integer getID() {
        if (ResultsDB.getInstance().allResults == null) {
            return 1;
        } else
            return ResultsDB.getInstance().allResults.get(ResultsDB.getInstance().allResults.size() - 1).getId() + 1;
    }

}
