package mtg.myCardCollection.domain;

/**
 * Created by jbo on 21.06.2016.
 */
class Price {

    private long low;
    private long median;
    private long high;

    public long getLow() {
        return low;
    }

    public void setLow(long low) {
        this.low = low;
    }

    public long getMedian() {
        return median;
    }

    public void setMedian(long median) {
        this.median = median;
    }

    public long getHigh() {
        return high;
    }

    public void setHigh(long high) {
        this.high = high;
    }

}
