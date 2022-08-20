package com.scisk.sciskbackend.service;

public interface CounterService {
    public long getNextSequence(String collectionName);
}