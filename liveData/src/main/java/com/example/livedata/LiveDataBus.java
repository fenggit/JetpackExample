package com.example.livedata;

import androidx.lifecycle.MutableLiveData;

import java.util.Hashtable;
import java.util.Map;

public class LiveDataBus {

    private final Map<String, MutableLiveData<Object>> bus;

    static volatile LiveDataBus defaultInstance;

    private LiveDataBus() {
        bus = new Hashtable<>();
    }

    public static LiveDataBus getDefault() {
        LiveDataBus instance = defaultInstance;
        if (instance == null) {
            synchronized (LiveDataBus.class) {
                instance = LiveDataBus.defaultInstance;
                if (instance == null) {
                    instance = LiveDataBus.defaultInstance = new LiveDataBus();
                }
            }
        }
        return instance;
    }

    public <T> MutableLiveData<T> with(String key, Class<T> type) {
        if (!bus.containsKey(key)) {
            bus.put(key, new MutableLiveData<Object>());
        }

        return (MutableLiveData<T>) bus.get(key);
    }

    public MutableLiveData<Object> with(String target) {
        return with(target, Object.class);
    }

    public void remove(String key) {
        // TODO 传入Context，判断Activity销毁，自动remove
        if (bus.containsKey(key)) {
            bus.remove(key);
        }
    }
}
