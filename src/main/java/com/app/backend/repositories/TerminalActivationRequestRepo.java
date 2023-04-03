package com.app.backend.repositories;

import java.util.ArrayList;
import java.util.List;

import lib.etickets.terminal.activationrequests.TerminalActivationRequest;

public class TerminalActivationRequestRepo {
    List<TerminalActivationRequest> terminalActivationRequestDb = new ArrayList<>();

    public List<TerminalActivationRequest> getTerminalActivationRequestDb() {
        return terminalActivationRequestDb;
    }

    public void setTerminalActivationRequestDb(List<TerminalActivationRequest> terminalActivationRequestDb) {
        this.terminalActivationRequestDb = terminalActivationRequestDb;
    }
}
