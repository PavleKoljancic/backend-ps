package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.terminal.activationrequests.TerminalActivationRequest;

public class TerminalActivationRequestRepo {
    List<TerminalActivationRequest> terminalActivationRequestDb = new ArrayList<>();

    public List<TerminalActivationRequest> getTerminalActivationRequests() {
        return terminalActivationRequestDb;
    }

    public boolean addTerminalActivationRequestDb(TerminalActivationRequest request) {
        return terminalActivationRequestDb.add(request);
    }

    
    public void updateTerminalActivationRequest(TerminalActivationRequest request) {
        for(TerminalActivationRequest temp : terminalActivationRequestDb) 
        {

            if(temp.getTerminalSerialNumber().equals(request.getTerminalSerialNumber())) 
            {
                terminalActivationRequestDb.remove(temp);
                terminalActivationRequestDb.add(request);

            }

        }
    }
}
