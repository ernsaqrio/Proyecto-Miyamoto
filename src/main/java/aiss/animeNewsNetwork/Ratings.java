
package aiss.animeNewsNetwork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ratings {

    private String nbVotes;
    private String weightedScore;
    private String bayesianScore;

    public String getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(String nbVotes) {
        this.nbVotes = nbVotes;
    }

    public String getWeightedScore() {
        return weightedScore;
    }

    public void setWeightedScore(String weightedScore) {
        this.weightedScore = weightedScore;
    }

    public String getBayesianScore() {
        return bayesianScore;
    }

    public void setBayesianScore(String bayesianScore) {
        this.bayesianScore = bayesianScore;
    }

}
