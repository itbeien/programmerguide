package com.beien.service;

public interface IBeienTokenService {
        public String createToken(String userId);
        public Boolean validateToken(String token, String userId);
}
