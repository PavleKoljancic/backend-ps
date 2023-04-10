package com.app.backend.services;

import org.springframework.stereotype.Service;

import com.app.backend.repositories.TerminalActivationRequestRepo;

import lib.etickets.terminal.activationrequests.TerminalActivationRequest;

@Service
public class TerminalActivationRequestService {
    TerminalActivationRequestRepo terminalActivationRequestRepo = new TerminalActivationRequestRepo();

    public boolean addTerminalActivationRequest(TerminalActivationRequest terminalActivationRequest){
        return terminalActivationRequestRepo.addTerminalActivationRequestDb(terminalActivationRequest);

    }
}
