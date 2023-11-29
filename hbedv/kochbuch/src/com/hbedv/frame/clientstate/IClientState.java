package com.hbedv.frame.clientstate;

/**
 *  Enumerationpattern fuer Clientstates, interface.<BR>
 *  Vorteile, siehe: Buch java 2, performance and idiom guide.
 *
 *@Source      $Source: /repository/alice/src/com/poi/fux/frame/clientstate/IClientState.java,v
 *      $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:45 $
 *@created     orn; 30. Juni 2003
 */
public interface IClientState {
  ClientState UNDEFINED = new ClientState();
  ClientState DONE = new ClientState();
  ClientState NEXT_CMD_IN_COMMANDTODO = new ClientState();
  ClientState NEXT_CMD_IN_REQUEST_ATTRIBUTE_CMD = new ClientState();
  ClientState LOG_HIM_OUT = new ClientState();
  ClientState RESPONSE_ALREADY_DONE = new ClientState();
}
