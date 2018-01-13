package br.edu.ifba.as.inicializacao;

import br.edu.ifba.as.rn.analise.SaudeRN;
import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PostConstructViewMapEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class inicializador implements SystemEventListener{
    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PostConstructApplicationEvent){
            System.out.println("\n\tAplicação iniciada\n");
            
        } else if (event instanceof PreDestroyApplicationEvent){
            System.out.println("\n\tAplicação fechada\n");
        }
//        else if(event instanceof PostConstructViewMapEvent){
//            System.out.println("\n\tConstruct VIew Map");
//        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return source instanceof Application;
    }    
    
    public void inicializarValoresAnalise(){
        SaudeRN saudeRN = new SaudeRN();
        saudeRN.definirPadroes();
    }
}
//Colocar em faces-config
//<faces-config xmlns="http://xmlns.jcp.org/xml/ns/javaee"
//              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//              xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
//                                  http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd" version="2.2">
//
//    <application>
//        <system-event-listener>
//            <system-event-listener-class>br.edu.ifba.as.inicializacao.inicializador</system-event-listener-class>
//            <system-event-class>javax.faces.event.PostConstructApplicationEvent</system-event-class>
//        </system-event-listener>
//<!--        <system-event-listener>
//            <system-event-listener-class>br.edu.ifba.as.inicializacao.inicializador</system-event-listener-class>
//            <system-event-class>javax.faces.event.PostConstructViewMapEvent</system-event-class>
//        </system-event-listener>-->
//        <system-event-listener>
//            <system-event-listener-class>br.edu.ifba.as.inicializacao.inicializador</system-event-listener-class>
//            <system-event-class>javax.faces.event.PreDestroyApplicationEvent</system-event-class>
//        </system-event-listener>
//    </application>
//
//</faces-config>