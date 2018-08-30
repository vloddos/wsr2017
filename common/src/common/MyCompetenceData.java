package common;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyCompetenceData implements Serializable {

    public ArrayList<String[]> competitor = new ArrayList<>();
    public ArrayList<String[]> expert = new ArrayList<>();
    //building plan
    //infrastructure
    //smp

    public MyCompetenceData(ResultSet competitorResultSet, ResultSet expertResultSet) {
        try {
            while (competitorResultSet.next()) {
                competitor.add(
                        new String[]{
                                competitorResultSet.getString(1),
                                competitorResultSet.getString(2),
                                competitorResultSet.getString(3),
                        }
                );
            }

            while (expertResultSet.next()) {
                expert.add(
                        new String[]{
                                expertResultSet.getString(1),
                                expertResultSet.getString(2),
                                expertResultSet.getString(3),
                        }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
