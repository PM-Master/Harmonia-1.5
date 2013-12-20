add|p|Confine|c|PM
add|prop|type=confinement|p|Confine
add|p|RBAC|c|PM
add|prop|type=rbac|p|RBAC
add|p|DAC|c|PM
add|prop|type=discretionary|p|DAC
add|p|MLS|c|PM
add|prop|type=mls|p|MLS
add|prop|levels=Secret,Top secret|p|MLS
add|a|MR users|p|Confine
add|a|OU users|p|Confine
add|ob|OU messages rep|Object attribute|yes|OU messages|452FD6777E780DFA464D20A3B7FDA4CF|p|Confine
add|b|Med Records|p|Confine
add|b|OU messages|p|Confine
add|a|Intern|p|RBAC
add|a|Secretary|p|RBAC
add|a|Acquisition|p|RBAC
add|a|Accts Rcv|p|RBAC
add|a|Contracting|p|RBAC
add|a|Accts Pbl|p|RBAC
add|a|Adm Clerk|p|RBAC
add|a|Nurse|p|RBAC
add|a|Acct Mgr|p|RBAC
add|a|Acct Repr|p|RBAC
add|ob|CMR Columns rep|Object attribute|yes|CMR Columns|2512B2769F1CFA084A85666D642A76CC|p|RBAC
add|ob|Acct Columns rep|Object attribute|yes|Acct Columns|1FE6A71D69E6B86799530E2908AEFD6A|p|RBAC
asg|b|Med Records|p|RBAC
add|b|Forms|p|RBAC
add|b|Approved Orders|p|RBAC
add|b|Accts Rcv witems|p|RBAC
add|b|Contracting witems|p|RBAC
add|b|Accts Pbl witems|p|RBAC
add|b|CMR Columns|p|RBAC
add|b|Acct Columns|p|RBAC
add|a|DAC uattrs|p|DAC
add|prop|usersof=discretionary|a|DAC uattrs
asg|a|Adm Clerk|p|DAC
asg|a|Nurse|p|DAC
asg|a|Acct Repr|p|DAC
asg|a|Acct Mgr|p|DAC
add|ob|CMRecs rep|Object attribute|yes|CMRecs|072B5B1ADE5A9ED8A5CCDCE85788C138|p|DAC
add|ob|alice home rep|Object attribute|yes|alice home|9C2A0DCAB450FC2C64E6B416FFDDB9CC|p|DAC
add|ob|bob home rep|Object attribute|yes|bob home|D959E8F465783BB5A4EB65D079460A66|p|DAC
add|ob|charlie home rep|Object attribute|yes|charlie home|273D33FE50A7ADAA7D578D21DBE083A6|p|DAC
add|ob|inboxes rep|Object attribute|yes|inboxes|FA705B70EBB494CFF469996DC2CE7E0C|p|DAC
add|ob|katie home rep|Object attribute|yes|katie home|2CDF41FC2090056F2B64D4FFC1DD8D12|p|DAC
add|ob|Populated Forms rep|Object attribute|no|Populated Forms|F4C1D607AB40A69621DBBCD2C14CFC8B|p|DAC
add|ob|gavrila home rep|Object attribute|yes|gavrila home|EDB38AC0A4519A71E857F16C6F2A9AF3|p|DAC
add|ob|Bob Med Records rep|Object attribute|yes|Bob Med Records|343BA0BE847DC5A35EB33DDFC80654CE|p|DAC
add|ob|Alice Med Records rep|Object attribute|yes|Alice Med Records|A6996DB7CEB7BF1648FEAC2BF7441F5E|p|DAC
add|ob|Acct Recs rep|Object attribute|yes|Acct Recs|16CEBA879182944C01577E6D7B1C1485|p|DAC
add|b|CMRecs|p|DAC
add|b|outboxes|p|DAC
add|prop|containerof=outboxes|b|outboxes
add|ob|DAC uattrs rep|User attribute|yes|DAC uattrs|C55F73F043BC75755B2E29BBFCD671C5|p|DAC
add|b|alice home|p|DAC
add|prop|homeof=alice|b|alice home
add|b|bob home|p|DAC
add|prop|homeof=bob|b|bob home
add|b|charlie home|p|DAC
add|prop|homeof=charlie|b|charlie home
add|b|inboxes|p|DAC
add|prop|containerof=inboxes|b|inboxes
add|b|katie home|p|DAC
add|prop|homeof=katie|b|katie home
add|b|witems|p|DAC
add|b|Populated Forms|p|DAC
add|b|gavrila home|p|DAC
add|prop|homeof=gavrila|b|gavrila home
add|b|Today|p|DAC
add|b|Acct Recs|p|DAC
add|a|Secret|p|MLS
add|prop|correspondsto=S|a|Secret
add|ob|S rep|Object attribute|no|S|BF8BC487B356260E4794877434CAD533|p|MLS
add|ob|TS rep|Object attribute|no|TS|5E2D638770168E54F20FF9AEBCB5DC45|p|MLS
add|b|S_TS|p|MLS
add|u|alice|fn|Alicia|a|MR users
add|eml|Alicia|alice@nist.gov|email.nist.gov|email.nist.gov|nist|alice|u|alice
add|u|bob|fn|Robert|a|MR users
add|eml|Robert|bob@nist.gov|email.nist.gov|email.nist.gov|nist|bob|u|bob
add|s|79758045|oc|Ignored|a|MR users
add|op|File read|s|79758045
add|op|File write|s|79758045
asg|u|bob|a|OU users
add|u|charlie|fn|Charles|a|OU users
add|eml|Charles|charlie@nist.gov|email.nist.gov|email.nist.gov|nist|charlie|u|charlie
asg|u|alice|a|OU users
add|s|EBBE3FE1|oc|Ignored|a|OU users
add|op|File write|s|EBBE3FE1
add|op|File read|s|EBBE3FE1
add|s|359268CA|oc|Ignored|a|OU users
add|op|Object attribute create object|s|359268CA
add|op|Object attribute assign to|s|359268CA
add|op|Object attribute assign|s|359268CA
asg|s|359268CA|b|OU messages rep
add|ob|mrec5|File|no|pmengine|E:\Work\mrec5.rtf|b|Med Records
add|ob|mrec4|File|no|pmengine|E:\Work\mrec4.doc|b|Med Records
add|ob|mrec1|File|no|pmengine|E:\Work\mrec1.doc|b|Med Records
add|ob|mrec2|File|no|pmengine|E:\Work\mrec2.doc|b|Med Records
add|ob|mrec3|File|no|pmengine|E:\Work\mrec3.doc|b|Med Records
add|ob|mrec11|File|no|pmengine|E:\Work\mrec11.rtf|b|Med Records
add|ob|mrec22|File|no|pmengine|E:\Work\mrec22.rtf|b|Med Records
add|ob|mrec33|File|no|pmengine|E:\Work\mrec33.rtf|b|Med Records
asg|s|79758045|b|Med Records
add|s|5C59BE03|oc|Ignored|b|Med Records
add|op|File write|s|5C59BE03
add|s|945358F8|oc|Ignored|b|Med Records
add|op|File read|s|945358F8
asg|s|EBBE3FE1|b|OU messages
add|a|Doctor|a|Intern
asg|a|Intern|s|945358F8
add|u|katie|fn|Katherine|a|Secretary
add|eml|Katherine|katherine.macfarland@nist.gov|email.nist.gov|email.nist.gov|nist|katie|u|katie
add|s|D7048A1C|oc|Ignored|a|Secretary
add|op|File write|s|D7048A1C
add|op|File read|s|D7048A1C
add|u|dave|fn|David|a|Acquisition
add|s|D6F23181|oc|Ignored|a|Acquisition
add|op|File read|s|D6F23181
asg|u|alice|a|Accts Rcv
add|s|B3FD2394|oc|Ignored|a|Accts Rcv
add|op|File write|s|B3FD2394
add|op|File read|s|B3FD2394
asg|u|bob|a|Contracting
add|s|18E9B035|oc|Ignored|a|Contracting
add|op|File write|s|18E9B035
add|op|File read|s|18E9B035
asg|u|alice|a|Accts Pbl
asg|u|charlie|a|Accts Pbl
add|s|16A11DA2|oc|Ignored|a|Accts Pbl
add|op|File write|s|16A11DA2
add|op|File read|s|16A11DA2
asg|u|katie|a|Adm Clerk
add|s|AD27716D|oc|Ignored|a|Adm Clerk
add|op|Object attribute create object|s|AD27716D
add|op|Object attribute create object attribute|s|AD27716D
add|op|Object attribute assign to|s|AD27716D
add|s|233650FB|oc|Ignored|a|Adm Clerk
add|op|File write|s|233650FB
add|op|File read|s|233650FB
add|s|0BC643D6|oc|Ignored|a|Adm Clerk
add|op|File write|s|0BC643D6
add|op|File read|s|0BC643D6
add|s|9CD521EB|oc|Ignored|a|Adm Clerk
add|op|File write|s|9CD521EB
add|s|C5F57D1C|oc|Ignored|a|Adm Clerk
add|op|Object attribute create object|s|C5F57D1C
add|op|Object attribute assign|s|C5F57D1C
add|s|1DDA9933|oc|Ignored|a|Adm Clerk
add|op|File write|s|1DDA9933
add|op|File read|s|1DDA9933
add|u|gavrila|fn|Serilie|a|Nurse
add|eml|Serban Gavrila|gavrila@nist.gov|email.nist.gov|email.nist.gov|nist|gavrila|u|gavrila
add|s|4E95A4D5|oc|Ignored|a|Nurse
add|op|File write|s|4E95A4D5
add|op|File read|s|4E95A4D5
add|s|7F91A035|oc|Ignored|a|Nurse
add|op|File read|s|7F91A035
add|s|C29A03C7|oc|Ignored|a|Nurse
add|op|File write|s|C29A03C7
add|op|File read|s|C29A03C7
add|s|D36773F1|oc|Ignored|a|Nurse
add|op|File read|s|D36773F1
add|s|6523425D|oc|Ignored|a|Nurse
add|op|File read|s|6523425D
add|s|0B29B5B1|oc|Ignored|a|Nurse
add|op|File read|s|0B29B5B1
add|s|4D72BCE2|oc|Ignored|a|Nurse
add|op|File write|s|4D72BCE2
add|op|File read|s|4D72BCE2
asg|u|katie|a|Acct Mgr
add|s|581A03EB|oc|Ignored|a|Acct Mgr
add|op|File write|s|581A03EB
add|op|File read|s|581A03EB
add|s|F6CCB92B|oc|Ignored|a|Acct Mgr
add|op|File write|s|F6CCB92B
add|op|File read|s|F6CCB92B
add|s|3E5AF6F1|oc|Ignored|a|Acct Mgr
add|op|File write|s|3E5AF6F1
add|op|File read|s|3E5AF6F1
add|s|8B31D32C|oc|Ignored|a|Acct Mgr
add|op|File write|s|8B31D32C
add|op|File read|s|8B31D32C
add|s|47CE9638|oc|Ignored|a|Acct Mgr
add|op|Object attribute create object|s|47CE9638
add|op|Object attribute assign|s|47CE9638
add|s|0F404D67|oc|Ignored|a|Acct Mgr
add|op|File write|s|0F404D67
add|op|File read|s|0F404D67
add|s|5791E4F9|oc|Ignored|a|Acct Mgr
add|op|Object attribute create object attribute|s|5791E4F9
add|op|Object attribute create object|s|5791E4F9
add|op|Object attribute assign to|s|5791E4F9
asg|u|alice|a|Acct Repr
add|s|AD179DE1|oc|Ignored|a|Acct Repr
add|op|File write|s|AD179DE1
add|op|File read|s|AD179DE1
add|s|EA3DBB84|oc|Ignored|a|Acct Repr
add|op|File write|s|EA3DBB84
add|op|File read|s|EA3DBB84
add|s|0AA431B8|oc|Ignored|a|Acct Repr
add|op|File write|s|0AA431B8
add|op|File read|s|0AA431B8
add|s|CAF1CC9C|oc|Ignored|a|Acct Repr
add|op|File write|s|CAF1CC9C
add|op|File read|s|CAF1CC9C
add|s|20B9C61C|oc|Ignored|a|Acct Repr
add|op|File write|s|20B9C61C
add|op|File read|s|20B9C61C
asg|s|C5F57D1C|b|CMR Columns rep
asg|s|47CE9638|b|Acct Columns rep
add|ob|poForm|File|no|pmengine|E:\Work\Forms\poForm.wkf|b|Forms
asg|s|D7048A1C|b|Forms
asg|s|D6F23181|b|Approved Orders
asg|s|B3FD2394|b|Accts Rcv witems
asg|s|18E9B035|b|Contracting witems
asg|s|16A11DA2|b|Accts Pbl witems
add|b|PatId|b|CMR Columns
add|b|PatBio|b|CMR Columns
add|b|PatHistory|b|CMR Columns
add|b|PatAllergies|b|CMR Columns
add|b|PatSymptoms|b|CMR Columns
add|b|PatDiag|b|CMR Columns
add|b|PatTreatment|b|CMR Columns
add|b|AcctNum|b|Acct Columns
add|b|AcctName|b|Acct Columns
add|b|AcctSsn|b|Acct Columns
add|b|AcctAddr|b|Acct Columns
add|a|Exporter|a|DAC uattrs
add|prop|nameof=exporter|a|Exporter
add|a|Alicia|a|DAC uattrs
add|prop|nameof=alice|a|Alicia
add|a|Robert|a|DAC uattrs
add|prop|nameof=bob|a|Robert
add|a|Charles|a|DAC uattrs
add|prop|nameof=charlie|a|Charles
add|a|Katherine|a|DAC uattrs
add|prop|nameof=katie|a|Katherine
add|a|Serilie|a|DAC uattrs
add|prop|nameof=gavrila|a|Serilie
add|a|David|a|DAC uattrs
add|prop|nameof=dave|a|David
add|s|E963428D|oc|Ignored|a|DAC uattrs
add|op|Object attribute assign to|s|E963428D
add|s|A1F3F938|oc|Ignored|a|DAC uattrs
add|op|File write|s|A1F3F938
add|s|D31DD406|oc|Ignored|a|DAC uattrs
add|op|Object attribute create object|s|D31DD406
asg|s|AD27716D|b|CMRecs rep
add|s|94C9DF0B|oc|Ignored|b|alice home rep
add|op|Operation set assign|s|94C9DF0B
add|op|Object attribute assign to|s|94C9DF0B
add|op|Operation set assign to|s|94C9DF0B
add|op|Object attribute assign|s|94C9DF0B
add|op|Object attribute create object attribute|s|94C9DF0B
add|op|Object attribute create object|s|94C9DF0B
add|op|Object attribute create operation set|s|94C9DF0B
add|op|Entity represent|s|94C9DF0B
add|s|A0BD0694|oc|Ignored|b|bob home rep
add|op|Operation set assign|s|A0BD0694
add|op|Entity represent|s|A0BD0694
add|op|Object attribute create object|s|A0BD0694
add|op|Object attribute assign|s|A0BD0694
add|op|Operation set assign to|s|A0BD0694
add|op|Object attribute create object attribute|s|A0BD0694
add|op|Object attribute assign to|s|A0BD0694
add|op|Object attribute create operation set|s|A0BD0694
add|s|ACD130E8|oc|Ignored|b|charlie home rep
add|op|Object attribute create operation set|s|ACD130E8
add|op|Object attribute assign to|s|ACD130E8
add|op|Operation set assign|s|ACD130E8
add|op|Object attribute create object|s|ACD130E8
add|op|Object attribute assign|s|ACD130E8
add|op|Object attribute create object attribute|s|ACD130E8
add|op|Operation set assign to|s|ACD130E8
add|op|Entity represent|s|ACD130E8
asg|s|E963428D|b|inboxes rep
add|s|0B4407A1|oc|Ignored|b|katie home rep
add|op|Object attribute create object attribute|s|0B4407A1
add|op|Object attribute create object|s|0B4407A1
add|op|Object attribute assign to|s|0B4407A1
add|op|Object attribute create operation set|s|0B4407A1
add|op|Object attribute assign|s|0B4407A1
add|op|Entity represent|s|0B4407A1
add|op|Operation set assign|s|0B4407A1
add|op|Operation set assign to|s|0B4407A1
asg|s|D31DD406|b|Populated Forms rep
add|s|7273EFCE|oc|Ignored|b|gavrila home rep
add|op|Object attribute create object attribute|s|7273EFCE
add|op|Operation set assign to|s|7273EFCE
add|op|Operation set assign|s|7273EFCE
add|op|Object attribute create object|s|7273EFCE
add|op|Object attribute assign to|s|7273EFCE
add|op|Entity represent|s|7273EFCE
add|op|Object attribute create operation set|s|7273EFCE
add|op|Object attribute assign|s|7273EFCE
asg|s|5791E4F9|b|Acct Recs rep
add|b|Bob Med Records|b|CMRecs
add|prop|patientsof=bob|b|Bob Med Records
add|b|Alice Med Records|b|CMRecs
add|prop|patientsof=alice|b|Alice Med Records
asg|s|1DDA9933|b|CMRecs
asg|s|4D72BCE2|b|CMRecs
add|ob|katie OUTBOX rep|Object attribute|yes|katie OUTBOX|6CE73DE06005E3E84F8E1C1946F7AB51|b|outboxes
add|b|katie OUTBOX|b|outboxes
add|prop|outboxof=katie|b|katie OUTBOX
add|b|OU outboxes|b|outboxes
add|s|60507C01|oc|Ignored|b|DAC uattrs rep
add|op|User assign|s|60507C01
add|op|User attribute assign to operation set|s|60507C01
add|s|EE568F88|oc|Ignored|b|DAC uattrs rep
add|op|User assign|s|EE568F88
add|op|User attribute assign to operation set|s|EE568F88
add|s|15E69BE1|oc|Ignored|b|DAC uattrs rep
add|op|User attribute assign to operation set|s|15E69BE1
add|op|User assign|s|15E69BE1
add|s|12345678|oc|Ignored|b|DAC uattrs rep
add|op|User attribute assign to operation set|s|12345678
add|op|User assign|s|12345678
asg|b|Alice Med Records|b|alice home
add|b|Proposals|b|alice home
add|b|SharedContainer|b|alice home
add|s|B254FA19|oc|Ignored|b|alice home
add|op|File write|s|B254FA19
add|op|File read|s|B254FA19
asg|b|SharedContainer|b|bob home
asg|b|Bob Med Records|b|bob home
add|s|9F00F0A0|oc|Ignored|b|bob home
add|op|File write|s|9F00F0A0
add|op|File read|s|9F00F0A0
asg|b|SharedContainer|b|charlie home
add|s|663A07F7|oc|Ignored|b|charlie home
add|op|File read|s|663A07F7
add|op|File write|s|663A07F7
add|b|OU inboxes|b|inboxes
add|b|katie INBOX|b|inboxes
add|prop|inboxof=katie|b|katie INBOX
add|s|73F33EBB|oc|Ignored|b|katie home
add|op|File write|s|73F33EBB
add|op|File read|s|73F33EBB
add|b|alice witems|b|witems
add|b|bob witems|b|witems
add|b|charlie witems|b|witems
add|b|katie witems|b|witems
asg|s|A1F3F938|b|Populated Forms
add|s|3F390F75|oc|Ignored|b|gavrila home
add|op|File write|s|3F390F75
add|op|File read|s|3F390F75
add|b|12345678|b|Acct Recs
asg|s|0F404D67|b|Acct Recs
asg|s|20B9C61C|b|Acct Recs
asg|u|bob|a|Secret
add|a|Top secret|a|Secret
add|prop|correspondsto=TS|a|Top secret
add|s|20DE6FEB|oc|Ignored|a|Secret
add|op|File write|s|20DE6FEB
add|s|C2CF01CD|oc|Ignored|a|Secret
add|op|File read|s|C2CF01CD
add|s|033A0D1C|oc|Ignored|a|Secret
add|op|Object attribute create object|s|033A0D1C
add|op|Object attribute assign to|s|033A0D1C
asg|s|033A0D1C|b|S rep
add|s|650F246B|oc|Ignored|b|TS rep
add|op|Object attribute create object|s|650F246B
add|op|Object attribute assign to|s|650F246B
add|b|TS|b|S_TS
add|b|S|b|S_TS
add|s|78E5ABCE|oc|Ignored|b|S_TS
add|op|File read|s|78E5ABCE
asg|s|20DE6FEB|b|S_TS
asg|u|bob|a|Doctor
asg|u|alice|a|Doctor
add|s|AD72CEA8|oc|Ignored|a|Doctor
add|op|File read|s|AD72CEA8
add|s|09B8AA6A|oc|Ignored|a|Doctor
add|op|File read|s|09B8AA6A
add|op|File write|s|09B8AA6A
add|s|4D87458D|oc|Ignored|a|Doctor
add|op|File read|s|4D87458D
add|op|File write|s|4D87458D
asg|a|Doctor|s|5C59BE03
add|s|53811547|oc|Ignored|a|Doctor
add|op|File read|s|53811547
add|op|File write|s|53811547
add|s|ADFA7E54|oc|Ignored|a|Doctor
add|op|File read|s|ADFA7E54
add|op|File write|s|ADFA7E54
add|s|6DB75F58|oc|Ignored|a|Doctor
add|op|File read|s|6DB75F58
add|op|File write|s|6DB75F58
add|ob|9435D63E|File|no|pmengine|E:\Work\9435D63E.pid|b|PatId
add|ob|58423CA7|File|no|pmengine|E:\Work\58423CA7.pid|b|PatId
asg|s|AD72CEA8|b|PatId
asg|s|233650FB|b|PatId
asg|s|0B29B5B1|b|PatId
add|ob|4902BD22|File|no|pmengine|E:\Work\4902BD22.bio|b|PatBio
add|ob|39FA5BA8|File|no|pmengine|E:\Work\39FA5BA8.bio|b|PatBio
asg|s|0BC643D6|b|PatBio
add|ob|FE2CA75B|File|no|pmengine|E:\Work\FE2CA75B.doc|b|PatHistory
add|ob|6411940B|File|no|pmengine|E:\Work\6411940B.doc|b|PatHistory
asg|s|7F91A035|b|PatHistory
asg|s|53811547|b|PatHistory
add|ob|7002DA15|File|no|pmengine|E:\Work\7002DA15.rtf|b|PatAllergies
add|ob|E9663596|File|no|pmengine|E:\Work\E9663596.rtf|b|PatAllergies
asg|s|09B8AA6A|b|PatAllergies
asg|s|9CD521EB|b|PatAllergies
asg|s|4E95A4D5|b|PatAllergies
add|ob|FB40D908|File|no|pmengine|E:\Work\FB40D908.rtf|b|PatSymptoms
add|ob|33EAA2DF|File|no|pmengine|E:\Work\33EAA2DF.rtf|b|PatSymptoms
asg|s|4D87458D|b|PatSymptoms
asg|s|C29A03C7|b|PatSymptoms
add|ob|D9971E4A|File|no|pmengine|E:\Work\D9971E4A.rtf|b|PatDiag
add|ob|53C1525D|File|no|pmengine|E:\Work\53C1525D.rtf|b|PatDiag
asg|s|D36773F1|b|PatDiag
asg|s|ADFA7E54|b|PatDiag
add|ob|E294203A|File|no|pmengine|E:\Work\E294203A.rtf|b|PatTreatment
add|ob|E4B48FB1|File|no|pmengine|E:\Work\E4B48FB1.rtf|b|PatTreatment
asg|s|6523425D|b|PatTreatment
asg|s|6DB75F58|b|PatTreatment
add|ob|FC15B612|File|no|pmengine|E:\Work\FC15B612.txt|b|AcctNum
asg|s|581A03EB|b|AcctNum
asg|s|AD179DE1|b|AcctNum
add|ob|C9CFE6DE|File|no|pmengine|E:\Work\C9CFE6DE.txt|b|AcctName
asg|s|F6CCB92B|b|AcctName
asg|s|EA3DBB84|b|AcctName
add|ob|30A44CB5|File|no|pmengine|E:\Work\30A44CB5.txt|b|AcctSsn
asg|s|3E5AF6F1|b|AcctSsn
asg|s|0AA431B8|b|AcctSsn
add|ob|237D8FA7|File|no|pmengine|E:\Work\237D8FA7.txt|b|AcctAddr
asg|s|8B31D32C|b|AcctAddr
asg|s|CAF1CC9C|b|AcctAddr
add|u|exporter|fn|Exporter|a|Exporter
asg|u|alice|a|Alicia
asg|a|Alicia|s|94C9DF0B
add|s|BDB987A8|oc|Ignored|a|Alicia
add|op|File read|s|BDB987A8
add|s|1698910F|oc|Ignored|a|Alicia
add|op|File read|s|1698910F
asg|a|Alicia|s|B254FA19
asg|a|Alicia|s|60507C01
add|s|87499089|oc|Ignored|a|Alicia
add|op|Object attribute assign to|s|87499089
add|op|Object attribute assign|s|87499089
add|s|1FAC2FCC|oc|Ignored|a|Alicia
add|op|File write|s|1FAC2FCC
add|op|File read|s|1FAC2FCC
add|s|15068202|oc|Ignored|a|Alicia
add|op|File write|s|15068202
asg|u|bob|a|Robert
asg|a|Robert|s|A0BD0694
add|s|F7D14F3F|oc|Ignored|a|Robert
add|op|File read|s|F7D14F3F
asg|a|Robert|s|9F00F0A0
asg|a|Robert|s|EE568F88
add|s|19C91A87|oc|Ignored|a|Robert
add|op|File read|s|19C91A87
add|s|504C2DFC|oc|Ignored|a|Robert
add|op|Object attribute assign to|s|504C2DFC
add|op|Object attribute assign|s|504C2DFC
add|s|FE4A7080|oc|Ignored|a|Robert
add|op|File write|s|FE4A7080
add|op|File read|s|FE4A7080
add|s|B12DFFDD|oc|Ignored|a|Robert
add|op|File write|s|B12DFFDD
asg|u|charlie|a|Charles
asg|a|Charles|s|ACD130E8
add|s|94E4DFD4|oc|Ignored|a|Charles
add|op|File read|s|94E4DFD4
asg|a|Charles|s|663A07F7
asg|a|Charles|s|15E69BE1
add|s|BCDE77D3|oc|Ignored|a|Charles
add|op|File read|s|BCDE77D3
add|s|B270223E|oc|Ignored|a|Charles
add|op|Object attribute assign to|s|B270223E
add|op|Object attribute assign|s|B270223E
add|s|E2327C18|oc|Ignored|a|Charles
add|op|File write|s|E2327C18
add|op|File read|s|E2327C18
add|s|D041A88C|oc|Ignored|a|Charles
add|op|File write|s|D041A88C
asg|u|katie|a|Katherine
asg|a|Katherine|s|0B4407A1
asg|a|Katherine|s|73F33EBB
add|s|708FA799|oc|Ignored|a|Katherine
add|op|Object attribute assign to|s|708FA799
add|op|Object attribute assign|s|708FA799
asg|a|Katherine|s|12345678
add|s|39D1BFC8|oc|Ignored|a|Katherine
add|op|File write|s|39D1BFC8
add|op|File read|s|39D1BFC8
add|s|11AE564E|oc|Ignored|a|Katherine
add|op|File read|s|11AE564E
add|s|7F85FF96|oc|Ignored|a|Katherine
add|op|File read|s|7F85FF96
add|s|61538005|oc|Ignored|a|Katherine
add|op|File write|s|61538005
asg|u|gavrila|a|Serilie
asg|a|Serilie|s|7273EFCE
add|s|E6DEFB16|oc|Ignored|a|Serilie
add|op|File read|s|E6DEFB16
add|s|1BC8B462|oc|Ignored|a|Serilie
add|op|Object attribute assign to|s|1BC8B462
add|op|Object attribute assign|s|1BC8B462
asg|a|Serilie|s|3F390F75
add|s|5F522594|oc|Ignored|a|Serilie
add|op|File read|s|5F522594
add|s|9069CE55|oc|Ignored|a|Serilie
add|op|File write|s|9069CE55
asg|u|dave|a|David
add|b|8E094FF2|b|Bob Med Records
asg|b|mrec5|b|Bob Med Records
asg|b|mrec4|b|Bob Med Records
add|b|8B54E24B|b|Alice Med Records
asg|b|mrec3|b|Alice Med Records
asg|b|mrec2|b|Alice Med Records
asg|b|mrec1|b|Alice Med Records
asg|b|mrec33|b|Alice Med Records
asg|b|mrec22|b|Alice Med Records
asg|b|mrec11|b|Alice Med Records
asg|s|708FA799|b|katie OUTBOX rep
asg|s|11AE564E|b|katie OUTBOX
add|ob|alice OUTBOX rep|Object attribute|yes|alice OUTBOX|C2BBDFD54D8647A15074110247E07F3C|b|OU outboxes
add|ob|bob OUTBOX rep|Object attribute|yes|bob OUTBOX|6DC5C9DDA85A9ADE6F11345A1120D984|b|OU outboxes
add|ob|charlie OUTBOX rep|Object attribute|yes|charlie OUTBOX|7E24ACF15C822B584FF4718399A3EA31|b|OU outboxes
add|ob|gavrila OUTBOX rep|Object attribute|yes|gavrila OUTBOX|D1D8419BA45DA5DC10C149871A959B5E|b|OU outboxes
add|b|alice OUTBOX|b|OU outboxes
add|prop|outboxof=alice|b|alice OUTBOX
add|b|bob OUTBOX|b|OU outboxes
add|prop|outboxof=bob|b|bob OUTBOX
add|b|charlie OUTBOX|b|OU outboxes
add|prop|outboxof=charlie|b|charlie OUTBOX
add|b|gavrila OUTBOX|b|OU outboxes
add|prop|outboxof=gavrila|b|gavrila OUTBOX
add|ob|prop1|File|no|pmengine|E:\Work\prop1.rtf|b|Proposals
add|b|Charlie recipes|b|SharedContainer
add|b|bob INBOX|b|OU inboxes
add|prop|inboxof=bob|b|bob INBOX
add|b|charlie INBOX|b|OU inboxes
add|prop|inboxof=charlie|b|charlie INBOX
add|b|gavrila INBOX|b|OU inboxes
add|prop|inboxof=gavrila|b|gavrila INBOX
add|b|alice INBOX|b|OU inboxes
add|prop|inboxof=alice|b|alice INBOX
add|b|katie wINBOX|b|katie INBOX
add|prop|winboxof=katie|b|katie wINBOX
asg|s|7F85FF96|b|katie INBOX
asg|s|1FAC2FCC|b|alice witems
asg|s|FE4A7080|b|bob witems
asg|s|E2327C18|b|charlie witems
asg|s|39D1BFC8|b|katie witems
asg|b|237D8FA7|b|12345678
asg|b|30A44CB5|b|12345678
asg|b|C9CFE6DE|b|12345678
asg|b|FC15B612|b|12345678
asg|u|alice|a|Top secret
asg|a|Top secret|s|650F246B
asg|a|Top secret|s|78E5ABCE
add|s|61FAF91D|oc|Ignored|a|Top secret
add|op|File write|s|61FAF91D
asg|b|mrec1|b|TS
asg|b|mrec11|b|TS
asg|s|61FAF91D|b|TS
asg|b|mrec4|b|S
asg|b|mrec2|b|S
asg|b|mrec22|b|S
asg|s|C2CF01CD|b|S
asg|b|E294203A|b|8E094FF2
asg|b|D9971E4A|b|8E094FF2
asg|b|FB40D908|b|8E094FF2
asg|b|FE2CA75B|b|8E094FF2
asg|b|7002DA15|b|8E094FF2
asg|b|4902BD22|b|8E094FF2
asg|b|9435D63E|b|8E094FF2
asg|b|E4B48FB1|b|8B54E24B
asg|b|53C1525D|b|8B54E24B
asg|b|33EAA2DF|b|8B54E24B
asg|b|6411940B|b|8B54E24B
asg|b|E9663596|b|8B54E24B
asg|b|39FA5BA8|b|8B54E24B
asg|b|58423CA7|b|8B54E24B
asg|s|87499089|b|alice OUTBOX rep
asg|s|504C2DFC|b|bob OUTBOX rep
asg|s|B270223E|b|charlie OUTBOX rep
asg|s|1BC8B462|b|gavrila OUTBOX rep
asg|s|BDB987A8|b|alice OUTBOX
asg|s|19C91A87|b|bob OUTBOX
asg|s|BCDE77D3|b|charlie OUTBOX
asg|s|E6DEFB16|b|gavrila OUTBOX
add|ob|Chili recipes|File|no|pmengine|E:\Work\Chili recipes.rtf|b|Charlie recipes
add|ob|Italian recipes|File|no|pmengine|E:\Work\Italian recipes.rtf|b|Charlie recipes
add|b|bob wINBOX|b|bob INBOX
add|prop|winboxof=bob|b|bob wINBOX
asg|s|F7D14F3F|b|bob INBOX
add|b|charlie wINBOX|b|charlie INBOX
add|prop|winboxof=charlie|b|charlie wINBOX
asg|s|94E4DFD4|b|charlie INBOX
add|b|gavrila wINBOX|b|gavrila INBOX
add|prop|winboxof=gavrila|b|gavrila wINBOX
asg|s|5F522594|b|gavrila INBOX
add|b|alice wINBOX|b|alice INBOX
add|prop|winboxof=alice|b|alice wINBOX
asg|s|1698910F|b|alice INBOX
asg|s|61538005|b|katie wINBOX
asg|s|B12DFFDD|b|bob wINBOX
asg|s|D041A88C|b|charlie wINBOX
asg|s|9069CE55|b|gavrila wINBOX
asg|s|15068202|b|alice wINBOX
add|app|C:\PM\1.4\dist\pm-admin-1.4.jar|C:\PM\1.4\dist\pm-app-rtf-1.4.jar|C:\PM\1.4\dist\pm-app-wkf-1.4.jar|C:\PM\1.4\dist\pm-app-grant-1.4.jar|C:\PM\1.4\dist\pm-exporter-1.4.jar|C:\Program Files\OpenOffice.org 2.2\program\classes\juh.jar;C:\Program Files\OpenOffice.org 2.2\program\classes\jurt.jar;C:\Program Files\OpenOffice.org 2.2\program\classes\ridl.jar;C:\Program Files\OpenOffice.org 2.2\program\classes\unoil.jar;C:\PM\1.4\dist\pm-app-openoffice-1.4.jar|C:\PM\1.4\dist\pm-app-medrec-1.4.jar|C:\PM\1.4\dist\pm-app-acctrec-1.4.jar|h|xpvm1
add|app|E:\Workspace\pm1.4\dist\pm-admin-1.4.jar|E:\Workspace\pm1.4\dist\pm-app-rtf-1.4.jar|E:\Workspace\pm1.4\dist\pm-app-wkf-1.4.jar|E:\Workspace\pm1.4\dist\pm-app-grant-1.4.jar|E:\Workspace\pm1.4\dist\pm-exporter-1.4.jar|E:\Program Files\OpenOffice.org 2.2\program\classes\juh.jar;E:\Program Files\OpenOffice.org 2.2\program\classes\jurt.jar;E:\Program Files\OpenOffice.org 2.2\program\classes\ridl.jar;E:\Program Files\OpenOffice.org 2.2\program\classes\unoil.jar;E:\Workspace\pm1.4\dist\pm-app-openoffice-1.4.jar|E:\Workspace\pm1.4\dist\pm-app-medrec-1.4.jar|E:\Workspace\pm1.4\dist\pm-app-acctrec-1.4.jar|h|pmengine
add|app|C:\PM\pm1.4\dist\pm-admin-1.4.jar|C:\PM\pm1.4\dist\pm-app-rtf-1.4.jar|C:\PM\pm1.4\dist\pm-app-wkf-1.4.jar|C:\PM\pm1.4\dist\pm-app-grant-1.4.jar|C:\PM\pm1.4\dist\pm-exporter-1.4.jar|C:\Program Files\OpenOffice.org 2.2\program\classes\juh.jar;C:\Program Files\OpenOffice.org 2.2\program\classes\jurt.jar;C:\Program Files\OpenOffice.org 2.2\program\classes\ridl.jar;C:\Program Files\OpenOffice.org 2.2\program\classes\unoil.jar;C:\PM\pm1.4\dist\pm-app-openoffice-1.4.jar|C:\PM\pm1.4\dist\pm-app-medrec-1.4.jar|C:\PM\pm1.4\dist\pm-app-acctrec-1.4.jar|h|pmvm
add|ks|C:\PM\pm1.4\keystores\charlieKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|charlie
add|ks|C:\PM\keystores\superKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|super
add|ks|E:\Workspace\pm1.4\keystores\aliceKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|alice
add|ks|E:\Workspace\pm1.4\keystores\daveKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|dave
add|ks|C:\PM\pm1.4\keystores\gavrilaKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|gavrila
add|ks|C:\PM\pm1.4\keystores\bobKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|bob
add|ks|E:\Workspace\pm1.4\keystores\bobKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|bob
add|ks|E:\Workspace\pm1.4\keystores\katieKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|katie
add|ks|E:\Workspace\pm1.4\keystores\superKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|super
add|ks|E:\Workspace\pm1.4\keystores\charlieKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|charlie
add|ks|C:\PM\keystores\exporterKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|exporter
add|ks|C:\PM\keystores\gavrilaKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|gavrila
add|ks|E:\Workspace\pm1.4\keystores\exporterKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|exporter
add|ks|C:\PM\keystores\bobKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|bob
add|ks|C:\PM\pm1.4\keystores\daveKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|dave
add|ks|C:\PM\keystores\aliceKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|alice
add|ks|C:\PM\pm1.4\keystores\aliceKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|alice
add|ks|C:\PM\pm1.4\keystores\superKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|super
add|ks|C:\PM\keystores\daveKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|dave
add|ks|C:\PM\keystores\katieKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|katie
add|ks|E:\Workspace\pm1.4\keystores\gavrilaKeystore|E:\Workspace\pm1.4\keystores\clientTruststore|h|pmengine|u|gavrila
add|ks|C:\PM\pm1.4\keystores\exporterKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|exporter
add|ks|C:\PM\keystores\charlieKeystore|C:\PM\keystores\clientTruststore|h|xpvm1|u|charlie
add|ks|C:\PM\pm1.4\keystores\katieKeystore|C:\PM\pm1.4\keystores\clientTruststore|h|pmvm|u|katie
add|tpl|acctTpl|conts|AcctNum:AcctName:AcctSsn:AcctAddr
add|key|acctnum|tpl|acctTpl
add|tpl|mrecTpl|conts|PatId:PatBio:PatAllergies:PatHistory:PatSymptoms:PatDiag:PatTreatment
add|key|mrn|tpl|mrecTpl
add|key|ssn|tpl|mrecTpl
add|key|home phone|tpl|mrecTpl
add|key|last name|tpl|mrecTpl
add|tpl|mrecTpl|b|8E094FF2
add|comps|9435D63E:4902BD22:7002DA15:FE2CA75B:FB40D908:D9971E4A:E294203A|b|8E094FF2
add|key|mrn=0DAB52862379|b|8E094FF2
add|key|ssn=124456789|b|8E094FF2
add|key|last name=Roberts|b|8E094FF2
add|key|home phone=5678|b|8E094FF2
add|tpl|acctTpl|b|12345678
add|comps|FC15B612:C9CFE6DE:30A44CB5:237D8FA7|b|12345678
add|key|acctnum=12345678|b|12345678
add|tpl|mrecTpl|b|8B54E24B
add|comps|58423CA7:39FA5BA8:E9663596:6411940B:33EAA2DF:53C1525D:E4B48FB1|b|8B54E24B
add|key|mrn=8C1AA3D245A9|b|8B54E24B
add|key|ssn=123456789|b|8B54E24B
add|key|last name=Johnson|b|8B54E24B
add|key|home phone=4321|b|8B54E24B
add|prop|alice.signature.file|v|E:\PolicyMachine\PmServer\Signatures\alice.jpg
add|prop|bob.signature.file|v|E:\PolicyMachine\PmServer\Signatures\bob.jpg
add|prop|charlie.signature.file|v|E:\PolicyMachine\PmServer\Signatures\charlie.jpg
add|prop|dave.signature.file|v|E:\PolicyMachine\PmServer\Signatures\dave.jpg
add|prop|gavrila.signature.file|v|E:\PolicyMachine\PmServer\Signatures\gavrila.jpg
add|prop|katie.signature.file|v|E:\PolicyMachine\PmServer\Signatures\katie.jpg
