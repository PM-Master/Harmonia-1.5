
add|b|Forms|p|RBAC

add|ob|Rejected Forms rep|Object attribute|no|Rejected Forms|A7ADA5717555D189EAEDC13368EF9068|p|DAC
add|ob|Completed Forms rep|Object attribute|no|Completed Forms|1D417040F4386F420FEBEC3CB8C6DA42|p|DAC
add|ob|Populated Forms rep|Object attribute|no|Populated Forms|2A2DD5E22D62003A16B108CA80D0F93A|p|DAC


#For Workflow - Well-known locations for completed, rejected, blank, and populated forms
add|b|Completed Forms|p|DAC
add|prop|homeof=Completed Forms|b|Completed Forms
add|b|Rejected Forms|p|DAC
add|prop|homeof=Rejected Forms|b|Rejected Forms
add|b|Blank Forms|p|DAC
add|prop|homeof=Blank Forms|b|Blank Forms
add|b|Populated Forms|p|DAC
add|prop|homeof=Populated Forms|b|Populated Forms

#For Workflow - access rights on well-known locations for Workflow documents.
    #Populated Forms
add|s|A1F3F938|oc|Ignored|a|DAC uattrs
add|op|File write|s|A1F3F938
asg|s|A1F3F938|b|Populated Forms

add|s|D31DD406|oc|Ignored|a|DAC uattrs
add|op|Object attribute create object|s|D31DD406
asg|s|D31DD406|b|Populated Forms rep

    #Blank Forms

    #Completed Forms

    #Rejected Forms

    #Test pdf for intialization of a workflow



add|s|D7048A1C|oc|Ignored|a|Secretary
add|op|File write|s|D7048A1C
add|op|File read|s|D7048A1C
asg|s|D7048A1C|b|Forms



asg|u|alice|a|Accts Rcv
add|s|B3FD2394|oc|Ignored|a|Accts Rcv
add|op|File write|s|B3FD2394
add|op|File read|s|B3FD2394
asg|s|B3FD2394|b|Accts Rcv witems

asg|u|bob|a|Contracting
add|s|18E9B035|oc|Ignored|a|Contracting
add|op|File write|s|18E9B035
add|op|File read|s|18E9B035
asg|s|18E9B035|b|Contracting witems

add|s|16A11DA2|oc|Ignored|a|Accts Pbl
add|op|File write|s|16A11DA2
add|op|File read|s|16A11DA2
asg|s|16A11DA2|b|Accts Pbl witems

asg|s|D6F23181|b|Approved Orders

add|s|CDC47E6F|oc|Ignored|a|DAC uattrs
add|op|Object attribute assign|s|CDC47E6F
asg|s|CDC47E6F|b|Rejected Forms rep

add|s|0DE78668|oc|Ignored|a|DAC uattrs
add|op|Object attribute delete assign|s|0DE78668
add|op|Object attribute assign to|s|0DE78668
add|op|Object attribute delete assign to|s|0DE78668
asg|s|0DE78668|b|Completed Forms rep

add|s|48A4EB15|oc|Ignored|a|DAC uattrs
add|op|Dir read|s|48A4EB15
add|op|File read|s|48A4EB15
asg|s|48A4EB15|b|Blank Forms

add|ob|Purchase Order Form n114|File|no|pmvm|C:\PMWork\Forms\n114poWsign.pdf|b|Blank Forms

add|b|alice witems|b|witems
add|prop|witemsof=alice|b|alice witems
add|b|bob witems|b|witems
add|prop|witemsof=bob|b|bob witems
add|b|charlie witems|b|witems
add|prop|witemsof=charlie|b|charlie witems
add|b|katie witems|b|witems
add|prop|witemsof=katie|b|katie witems

asg|s|1FAC2FCC|b|alice witems
asg|s|FE4A7080|b|bob witems
asg|s|E2327C18|b|charlie witems
asg|s|39D1BFC8|b|katie witems








