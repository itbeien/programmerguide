package com.beien.service;

public interface IUserService {
    //转账
    public void transfer(String inName, String outName, double money) throws Exception;
    public void transfer1(String inName, String outName, double money) throws Exception;
}
