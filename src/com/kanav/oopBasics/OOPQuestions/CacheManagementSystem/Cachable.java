package com.kanav.oopBasics.OOPQuestions.CacheManagementSystem;

import java.util.HashMap;

public interface Cachable {

    public String read(String key);

    public boolean write(String key, String value);

}
