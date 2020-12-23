package com.okex.open.api.bean.funding.param;

import com.okex.open.api.enums.FuturesTransactionTypeEnum;


public class OrdersItem {

    /**
     * You setting order id. (optional)
     */
    private String order_type;
    private String price;

    private String client_oid;
    /**
     * The execution type {@link FuturesTransactionTypeEnum}
     */
    private String type;
    /**
     * The order price: Maximum 1 million
     */

    /**
     * The order amount: Maximum 1 million
     */
    private String size;
    /**
     * Match best counter party price (BBO)? 0: No 1: Yes   If yes, the 'price' field is ignored
     */
    private String match_price;
    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMatch_price() {
        return match_price;
    }

    public void setMatch_price(String match_price) {
        this.match_price = match_price;
    }



    public String getClient_oid() {
        return client_oid;
    }

    public void setClient_oid(String client_oid) {
        this.client_oid = client_oid;
    }

}
