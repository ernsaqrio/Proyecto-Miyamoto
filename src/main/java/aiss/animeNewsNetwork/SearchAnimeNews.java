
package aiss.animeNewsNetwork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchAnimeNews {

    private Ann ann;

    public Ann getAnn() {
        return ann;
    }

    public void setAnn(Ann ann) {
        this.ann = ann;
    }
    
//    public String toString() {
//    	return "Ann: " + ann;
//    }

}