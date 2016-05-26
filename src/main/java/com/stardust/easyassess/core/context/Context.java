package com.stardust.easyassess.core.context;


import java.math.BigDecimal;
import java.util.Date;

public interface Context {

    Object get(String index, Object defaultVal);
    Object get(String index);
    Integer getInt(String paramName);
    Integer getInt(String paramName, int defaultValue);
    String getString(String paramName);
    String getString(String paramName, String defaultValue);
    Long getLong(String paramName);
    Long getLong(String paramName, long defaultValue);
    boolean getBoolean(String paramName);
    boolean getBoolean(String paramName, boolean defaultValue);
    Date getDate(String paramName);
    Date getDate(String paramName, Date defaultValue);
    BigDecimal getDecimal(String paramName);
    BigDecimal getDecimal(String paramName, BigDecimal defaultValue);
    Double getDouble(String paramName);
    Double getDouble(String paramName, double defaultValue);
    Float getFloat(String index, float defaultVal);
    Float getFloat(String index);
    void put(String index, Object value);
    void clear();
    void remove(String index);
}
