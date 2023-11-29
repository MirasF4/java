package com.hbedv.frame;


public abstract class MenueCommand extends Command implements ICommandDispatcher {
    
    private boolean stateOK;
    
    public MenueCommand(String newNext) {
        super (newNext);
    }


    protected void setManager() { }

    public void setStateOK(boolean bool) {
        stateOK = bool;
    }
    
    public boolean isStateOK() {
		return stateOK;
	}
}
