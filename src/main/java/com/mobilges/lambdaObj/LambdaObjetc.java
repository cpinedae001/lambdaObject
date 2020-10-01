/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilges.lambdaObj;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobilges.kiosko.lib.comm.MgCommRv;
import com.mobilges.kiosko.lib.comm.MgCommTx;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author christianpineda
 */
public class LambdaObjetc implements RequestStreamHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        try {
            String res = "";
            MgCommTx tx = mapper.readValue(input, MgCommTx.class);
            MgCommRv rx = new MgCommRv();
            rx.setData((Object) "NO tiene nada");
            rx.setMensaje("Hola");
            rx.setStatus(tx.getOperacion());
            mapper.writeValue(output, rx);

        } catch (Exception e) {
        }
    }

//    @Override
//    public String handleRequest(String input, Context context) {
//
//        String res = "";
//        try {
//            System.out.println(input + " desde lambda");
//            MgCommRv rx = new MgCommRv();
//            rx.setData((Object) "NO tiene nada");
//            rx.setMensaje(input);
//            rx.setStatus(1);
//            ObjectMapper mapper = new ObjectMapper();
//
//            res = mapper.writeValueAsString(rx);
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(LambdaObjetc.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return res;
//    }
}
