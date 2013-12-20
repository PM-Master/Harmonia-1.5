package gov.nist.csd.pm.common.browser;

import gov.nist.csd.pm.common.info.PMCommand;

/**
 * Created by IntelliJ IDEA. User: R McHugh Date: 7/18/11 Time: 1:02 PM To change this template use File | Settings | File Templates.
 */
public enum PmGraphDirection  {
    /**
	 * @uml.property  name="uP"
	 * @uml.associationEnd  
	 */
    UP(PMCommand.GET_MEMBERS_OF), /**
	 * @uml.property  name="dOWN"
	 * @uml.associationEnd  
	 */
    DOWN(PMCommand.GET_CONTAINERS_OF), /**
	 * @uml.property  name="uSER"
	 * @uml.associationEnd  
	 */
    USER(PMCommand.GET_POS_MEMBERS_OF);

    /**
	 * @uml.property  name="_command"
	 * @uml.associationEnd  
	 */
    PMCommand _command;
    PmGraphDirection(PMCommand command){
        _command = command;
    }

    public PmGraphDirection inverse(){
        switch(this){
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case USER:
                return USER;
        }
        return UP;
    }

    public PMCommand getSysCallerCommand(){
        return _command;
    }

}

