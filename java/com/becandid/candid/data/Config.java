package com.becandid.candid.data;

import java.util.Map;

public class Config {
    public Map<String, Object> experimentConfig;

    public void setExperimentConfig(Map<String, Object> config) {
        this.experimentConfig = config;
    }

    public boolean has(String name) {
        return this.experimentConfig != null && this.experimentConfig.containsKey(name);
    }

    public boolean getBoolean(String name) {
        return getBoolean(name, false);
    }

    public boolean getBoolean(String name, boolean defVal) {
        return (this.experimentConfig != null && this.experimentConfig.containsKey(name)) ? DataUtil.toBoolean(this.experimentConfig.get(name), defVal) : defVal;
    }

    public int getInt(String name, int defVal) {
        return (this.experimentConfig != null && this.experimentConfig.containsKey(name)) ? DataUtil.toInt(this.experimentConfig.get(name), defVal) : defVal;
    }

    public float getFloat(String name, float defVal) {
        return (this.experimentConfig != null && this.experimentConfig.containsKey(name)) ? DataUtil.toFloat(this.experimentConfig.get(name), defVal) : defVal;
    }

    public String getString(String name) {
        return getString(name, "");
    }

    public String getString(String name, String defVal) {
        if (this.experimentConfig == null || !this.experimentConfig.containsKey(name)) {
            return defVal;
        }
        Object val = this.experimentConfig.get(name);
        if (val instanceof String) {
            return (String) val;
        }
        return defVal;
    }
}
