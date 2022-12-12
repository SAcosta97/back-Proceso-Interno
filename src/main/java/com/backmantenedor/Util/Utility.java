package com.backmantenedor.Util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Utility {

    public Date obtenergetdateNow(){
        return new Date();
    }

}
