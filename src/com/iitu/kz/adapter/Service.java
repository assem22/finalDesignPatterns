package com.iitu.kz.adapter;

import com.iitu.kz.adapter.Translator;

public class Service {
    public String changeLanguage(Translator translator){
        return translator.translateToRus();
    }
}
