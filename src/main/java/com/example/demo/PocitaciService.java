package com.example.demo;


import org.springframework.stereotype.Service;

@Service
public class PocitaciService implements IPocitadloService{

    private Integer pocitadlo = 0;

    @Override
    public void add(){
        this.pocitadlo++;
    }
    @Override
    public Integer getPocitac() {
        return pocitadlo;
    }
}
