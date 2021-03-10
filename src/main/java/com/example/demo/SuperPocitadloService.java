package com.example.demo;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SuperPocitadloService implements IPocitadloService {
    private Integer pocitadlo = 1;

    @Override
    public void add() {
        this.pocitadlo = this.pocitadlo * 2;
    }

    @Override
    public Integer getPocitac() {
        return pocitadlo;
    }
}
