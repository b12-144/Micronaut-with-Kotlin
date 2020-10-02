package com.jdeers.codes

import java.lang.Exception

object Logger {

    @JvmStatic
    fun logError(msg:String){
        print(msg);
    }

    open fun logError(ex:Exception){
        print(ex.toString());
    }

    open fun logDebug(msg:String){
        print(msg);
    }
}
