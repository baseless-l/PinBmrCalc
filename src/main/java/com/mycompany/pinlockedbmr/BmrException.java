/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.pinlockedbmr;

/**
 *
 * @author Kian Frawley
 */
public class BmrException extends Exception{

    /**
     * Creates a new instance of <code>BmrException</code> without detail
     * message.
     */
    public BmrException() {
        this("BMR field is empty! Must calculate BMR!");
    }

    /**
     * Constructs an instance of <code>BmrException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BmrException(String msg) {
        super(msg);
    }
}
