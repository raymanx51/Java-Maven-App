package org.example;

public final class SingletonData {

    private Entry entry;
    private final static SingletonData INSTANCE = new SingletonData();

    private SingletonData() {}

    public static SingletonData getInstance() {
        return INSTANCE;
    }

    public void setEntry(Entry e) {

        this.entry = e;
    }

    public Entry getEntry() {

        return this.entry;
    }

}
