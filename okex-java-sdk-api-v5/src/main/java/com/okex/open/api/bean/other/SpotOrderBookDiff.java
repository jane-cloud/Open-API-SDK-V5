package com.okex.open.api.bean.other;

import lombok.Data;

import java.util.List;

@Data
//深度合并之后的类，可以通过toString方法合成深度合并之后的字符串
public class SpotOrderBookDiff {

    private final List<SpotOrderBookItem> asks;
    private final List<SpotOrderBookItem> bids;
    private final String  ts;
    private final int checksum;

    public SpotOrderBookDiff( List<SpotOrderBookItem> asks, List<SpotOrderBookItem> bids, String  ts, int checksum) {

        this.asks = asks;
        this.bids = bids;
        this. ts =  ts;
        this.checksum = checksum;
    }

    public boolean isEmpty() {
        return this.bids.isEmpty() && this.asks.isEmpty();
    }



    public List<SpotOrderBookItem> getAsks() {
        return asks;
    }

    public List<SpotOrderBookItem> getBids() {
        return bids;
    }

    public String getTs() {
        return ts;
    }

    public int getChecksum() {
        return checksum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        sb.append("\"asks\":[");
        for (int i = 0; i < asks.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(asks.get(i).toString());
        }
        sb.append("],\"bids\":[");
        for (int i = 0; i < bids.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(bids.get(i).toString());
        }
        sb.append("],\"ts\":\"");
        sb.append(ts);
        sb.append("\",\"ts\":");
        sb.append(this.checksum);
        sb.append("}");
        return sb.toString();
    }
}
