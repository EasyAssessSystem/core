package com.stardust.easyassess.core.context;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public abstract class AbstractContext implements Context {

    protected abstract Object getter(String index);

    protected abstract void setter(String index, Object val);

    public Object get(String index, Object defaultVal) {
        Object result = getter(index);

        if (result == null) {
            result = defaultVal;
        }

        return result;
    }

    public Object get(String index) {
        return get(index, null);
    }

    public Integer getInt(String index, int defaultVal) {
        Object value = getter(index);
        int results = defaultVal;
        try {
            String [] values =  (String [])value;
            results = Integer.parseInt(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public Integer getInt(String index) {
        return getInt(index, 0);
    }

    public String getString(String index, String defaultVal) {
        Object value = getter(index);
        String results = defaultVal;
        try {
            String [] values =  (String [])value;
            results = values[0];
        } catch (Exception e) {
        }
        return results;
    }

    public String getString(String index) {
        return getString(index, "");
    }


    public boolean getBoolean(String index) {
        return getBoolean(index, false);
    }

    public Date getDate(String index, Date defaultVal) {
        Object value = getter(index);
        Date results = defaultVal;
        try {
            String [] values =  (String [])value;
            results = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public BigDecimal getDecimal(String index) {
        return getDecimal(index, new BigDecimal(0));
    }

    public BigDecimal getDecimal(String index, BigDecimal defaultVal) {
        Object value = getter(index);
        BigDecimal results = defaultVal;
        try {
            String [] values =  (String [])value;
            results = new BigDecimal(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public Date getDate(String index) {
        return getDate(index, null);
    }

    public boolean getBoolean(String index, boolean defaultValue) {
        Object value = getter(index);
        boolean results = defaultValue;
        try {
            String [] values =  (String [])value;
            results = Boolean.parseBoolean(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public Float getFloat(String index, float defaultVal) {
        Object value = getter(index);
        float results = defaultVal;
        try {
            String [] values =  (String [])value;
            results = Float.parseFloat(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public Float getFloat(String index) {
        return getFloat(index, 0);
    }

    public Double getDouble(String index) {
        return getDouble(index, 0);
    }

    public Double getDouble(String index, double defaultValue) {
        Object value = getter(index);
        double results = defaultValue;
        try {
            String [] values =  (String [])value;
            results = Double.parseDouble(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public Long getLong(String index) {
        return getLong(index, 0);
    }

    public Long getLong(String index, long defaultVal) {
        Object value = getter(index);
        long results = defaultVal;
        try {
            String [] values =  (String [])value;
            results = Long.parseLong(values[0]);
        } catch (Exception e) {
        }
        return results;
    }

    public void put(String index, Object value) {
        setter(index, value);
    }
}