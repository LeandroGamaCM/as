package br.edu.ifba.as.inicializacao;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class inicializador implements SystemEventListener{
    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PostConstructApplicationEvent){
            System.out.println("\n\tpost initialize application\n");
        } else if (event instanceof PreDestroyApplicationEvent){
            System.out.println("\n\tpre destroy application\n");
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return source instanceof Application;
    }    
}
