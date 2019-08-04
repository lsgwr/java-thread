package com.xdclass.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class HikaricpDataSource extends UnpooledDataSourceFactory {
    public HikaricpDataSource() {
        this.dataSource = new HikariDataSource();
    }
}
