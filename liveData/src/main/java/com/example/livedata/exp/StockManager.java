package com.example.livedata.exp;

import java.math.BigDecimal;

public class StockManager {
    private String symbol;

    public StockManager(String symbol) {
        this.symbol = symbol;
    }

    public void requestPriceUpdates(SimplePriceListener listener) {
        // 请求数据
        BigDecimal number = new BigDecimal(10000);
        listener.onPriceChanged(number);
    }

    public void removeUpdates(SimplePriceListener listener) {
        // 移除监听和请求数据

    }
}
