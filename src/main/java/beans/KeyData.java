/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author vasil
 */
public class KeyData implements Serializable {

    private String data;
    private final HashMap<Integer, Object> dataMap = new HashMap<>();

    public KeyData() {
        for (int i = 0; i < 100; i++) {
            this.dataMap.put(i, "test_" + i);
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HashMap<Integer, Object> getDataMap() {
        return dataMap;
    }

    @Override
    public String toString() {
        return "KeyData{" + "data=" + data + ", dataMap=" + dataMap + '}';
    }

}
