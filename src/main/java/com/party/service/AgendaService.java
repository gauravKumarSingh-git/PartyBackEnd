package com.party.service;

import java.util.List;

import com.party.dto.AgendaDTO;
import com.party.exception.PartyException;

public interface AgendaService {
	public String addAgenda(AgendaDTO agenda) throws PartyException;
	public String updateAgenda(AgendaDTO agenda) throws PartyException;
	public void deleteAgenda(int id) throws PartyException;
	public AgendaDTO getAgendaById(int id) throws PartyException;
	public List<AgendaDTO> getAgendas() throws PartyException;
}
