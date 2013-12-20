package gov.nist.csd.pm.common.browser;

import com.google.common.base.Throwables;
import gov.nist.csd.pm.common.application.PolicyMachineClient;
import gov.nist.csd.pm.common.application.SysCaller;
import gov.nist.csd.pm.common.info.PMCommand;
import gov.nist.csd.pm.common.net.Packet;

import java.util.*;

import static gov.nist.csd.pm.common.util.CommandUtil.makeCmd;

/**
 * Created by IntelliJ IDEA. User: R McHugh Date: 7/18/11 Time: 1:13 PM To change this template use File | Settings | File Templates.
 */
public enum PmGraphType {


    /**
	 * @uml.property  name="uSER"
	 * @uml.associationEnd  
	 */
    USER(SysCaller.PM_VOS_PRES_USER,"User Mode"),
    /**
	 * @uml.property  name="aDMIN"
	 * @uml.associationEnd  
	 */
    ADMIN(SysCaller.PM_VOS_PRES_ADMIN, "Administrator Mode"),
    /**
	 * @uml.property  name="uSER_ATTRIBUTES"
	 * @uml.associationEnd  
	 */
    USER_ATTRIBUTES(PmGraphTypes.PM_GRAPH_UATTR, "User attributes"),
    /**
	 * @uml.property  name="aCCESS_CONTROL_ENTRIES"
	 * @uml.associationEnd  
	 */
    ACCESS_CONTROL_ENTRIES(PmGraphTypes.PM_GRAPH_ACES,"Objects/Attributes with ACE's"),
    /**
	 * @uml.property  name="cAPABILITIES"
	 * @uml.associationEnd  
	 */
    CAPABILITIES(PmGraphTypes.PM_GRAPH_CAPS,  "Users/Attributes with Capabilities"),
    /**
	 * @uml.property  name="oBJECT_ATTRIBUTES"
	 * @uml.associationEnd  
	 */
    OBJECT_ATTRIBUTES(PmGraphTypes.PM_GRAPH_OATTR, "Object attributes"),
    /**
	 * @uml.property  name="pERMISSIONS"
	 * @uml.associationEnd  
	 */
    PERMISSIONS(PmGraphTypes.PM_GRAPH_PERMS, "Permissions");



    PmGraphType(String typeCode, String name){
        _typeCode = typeCode;
        _readableName = name;
    }

    public static Map<PmGraphType, EnumSet<PmGraphDirection>> VALID_DIRECTIONS_FOR_TYPE = new HashMap(){{
        put(USER, EnumSet.of(PmGraphDirection.USER));
        put(ADMIN, EnumSet.of(PmGraphDirection.USER));
        put(USER_ATTRIBUTES, EnumSet.of(PmGraphDirection.UP, PmGraphDirection.DOWN));
        put(ACCESS_CONTROL_ENTRIES, EnumSet.of(PmGraphDirection.UP, PmGraphDirection.DOWN));
        put(CAPABILITIES, EnumSet.of(PmGraphDirection.UP, PmGraphDirection.DOWN));
        put(OBJECT_ATTRIBUTES, EnumSet.of(PmGraphDirection.UP, PmGraphDirection.DOWN));
        put(PERMISSIONS, EnumSet.of(PmGraphDirection.UP, PmGraphDirection.DOWN));

    }};
    /**
	 * @uml.property  name="_typeCode"
	 */
    private String _typeCode;
    /**
	 * @uml.property  name="_readableName"
	 */
    private String _readableName;
    public String typeCode(){
        return _typeCode;
    }

    public String readableName(){
        return _readableName;
    }
    public String toString(){
        return _typeCode;
    }

    public List<PmNode> getChildrenOf(PmNode node, PmGraphDirection dir, PolicyMachineClient client, String sessionId){
        if(VALID_DIRECTIONS_FOR_TYPE.get(this).contains(dir)){
            return PmNode.createAll(
                    getResultsOfNodeCommand(dir.getSysCallerCommand(), node, client, sessionId),
                    node.getChildProvidingDelegate());
        }
        else{
            return null;
        }
    }

    public List<String[]> getResultsOfNodeCommand(PMCommand command, PmNode node, PolicyMachineClient client, String sessionId){
        try{
            Packet res = null;
            Packet cmd = makeCmd(command, sessionId, node.getName(), node.getId(), node.getType(), typeCode());
            res = client.sendReceive(cmd, null);
            List<String[]> results = new ArrayList();
            for(String part : res.toStringIterable()){
                results.add(Arrays.copyOf(part.split(SysCaller.PM_FIELD_DELIM), 3));
            }
            return results;
        }catch(Exception e){
            Throwables.propagate(e);
        }
        return null;
    }
}


interface PmGraphTypes{
    public static final String PM_GRAPH_UATTR = "ua";
    public static final String PM_GRAPH_CAPS = "ca";
    public static final String PM_GRAPH_OATTR = "oa";
    public static final String PM_GRAPH_ACES = "ac";
    public static final String PM_GRAPH_PERMS = "pe";
}
