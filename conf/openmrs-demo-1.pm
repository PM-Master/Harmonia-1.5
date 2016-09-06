add|p|IBAC|c|PM
add|prop|IBAC|p|IBAC
add|p|RBAC|c|PM
add|prop|RBAC|p|RBAC
add|a|301_dave|p|IBAC
add|prop|301_dave|a|301_dave
add|a|300_bob|p|IBAC
add|prop|bob|a|300_bob
add|a|201_katie|p|IBAC
add|prop|katie|a|201_katie
add|a|200_joe|p|IBAC
add|prop|joe|a|200_joe
add|a|101_charlie|p|IBAC
add|prop|charlie|a|101_charlie
add|a|100_alice|p|IBAC
add|prop|alice|a|100_alice
add|b|dave patient records|p|IBAC
add|prop|doctor=dave|b|dave patient records
add|b|bob patient records|p|IBAC
add|prop|doctor=bob|b|bob patient records
add|a|Patient|p|RBAC
add|prop|Patient|a|Patient
add|a|Doctor|p|RBAC
add|prop|Doctor|a|Doctor
add|a|HR|p|RBAC
add|prop|HR|a|HR
add|b|Demograhphic Info|p|RBAC
add|prop|Demograhpic Info|b|Demograhphic Info
add|b|Medical Records|p|RBAC
add|prop|Medical Records|b|Medical Records
add|u|dave|fn|David|a|301_dave
add|s|B4602CCE|oc|Ignored|a|301_dave
add|op|File write|s|B4602CCE
add|op|File read|s|B4602CCE
add|u|bob|fn|Robert|a|300_bob
add|s|9799D5AB|oc|Ignored|a|300_bob
add|op|File write|s|9799D5AB
add|op|File read|s|9799D5AB
add|u|katie|fn|Katie|a|201_katie
add|u|joe|fn|Joseph|a|200_joe
add|u|charlie|fn|Charles|a|101_charlie
add|s|2A52A07E|oc|Ignored|a|101_charlie
add|op|File read|s|2A52A07E
add|op|File write|s|2A52A07E
add|u|alice|fn|Alicia|a|100_alice
add|s|E4136269|oc|Ignored|a|100_alice
add|op|File read|s|E4136269
add|op|File write|s|E4136269
add|b|100_record|b|dave patient records
add|prop|patient=101_charlie|b|100_record
asg|s|B4602CCE|b|dave patient records
add|b|101_record|b|bob patient records
add|prop|patient=100_alice|b|101_record
asg|s|9799D5AB|b|bob patient records
asg|u|alice|a|Patient
asg|u|charlie|a|Patient
asg|u|bob|a|Doctor
asg|u|dave|a|Doctor
add|s|114DCA57|oc|Ignored|a|Doctor
add|op|File read|s|114DCA57
asg|u|joe|a|HR
asg|u|katie|a|HR
add|s|1C7BC543|oc|Ignored|a|HR
add|op|File read|s|1C7BC543
asg|a|HR|s|114DCA57
add|b|Sensitive|b|Demograhphic Info
add|prop|Sensitive|b|Sensitive
add|b|Public|b|Demograhphic Info
add|prop|Public|b|Public
asg|s|E4136269|b|100_record
asg|s|2A52A07E|b|101_record
add|b|SSN|b|Sensitive
add|prop|SSN|b|SSN
asg|s|1C7BC543|b|Sensitive
asg|s|114DCA57|b|Public

add|a|Exporter|p|IBAC
add|prop|Exporter|a|Exporter
add|u|exporter|fn|Exporter|a|Exporter

add|a|Schema Builders|P|RBAC
asg|u|bob|a|Schema Builders

add|b|value_group_id|b|Medical Records
add|b|value_boolean|b|Medical Records
add|b|value_datetime|b|Medical Records
add|b|value_numeric|b|Medical Records
add|b|value_modifier|b|Medical Records
add|b|value_text|b|Medical Records
add|b|value_complex|b|Medical Records

add|b|gender|b|Public
add|b|birthdate|b|PUblic

add|b|address1|b|Sensitive
add|b|address2|b|Sensitive
add|b|city_village|b|Sensitive
add|b|state_province|b|Sensitive
add|b|postal_code|b|Sensitive
add|b|country|b|Sensitive

add|b|given_name|b|Public
add|b|middle_name|b|Public
add|b|family_name|b|Public

##############  Client Configuration Commands ##############
add|app|Admin|C:\PM\dist\pm-admin-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.admin.PmAdmin|Admin >> |645799-01
add|app|Rich Text Editor|C:\PM\dist\pm-app-rtf-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.rtf.RTFEditor|RTF Editor >> |645799-01
add|app|Workflow Editor|C:\PM\dist\pm-app-wkf-pdf-1.5.jar;C:\PM\dist\pm-app-pdf-view-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.workflow.WorkflowPDF|Workflow Editor >>|645799-01
add|app|PDF Viewer|C:\PM\dist\pm-app-pdf-view-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.pdfviewer.PDFViewer|PDF Viewer >> |645799-01
add|app|e-grant|C:\PM\dist\pm-app-grant-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.grantor.Grantor|e-grant >> |645799-01
add|app|Exporter|C:\PM\dist\pm-exporter-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.exporter.Exporter|Exporter >> |645799-01
add|app|Open Office|C:\PM\dist\pm-app-openoffice-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar;C:\Program Files (x86)\OpenOffice.org 3\Basis\program\classes\unoil.jar;C:\Program Files (x86)\OpenOffice.org 3\URE\java\juh.jar;C:\Program Files (x86)\OpenOffice.org 3\URE\java\jurt.jar;C:\Program Files (x86)\OpenOffice.org 3\URE\java\ridl.jar;C:\Program Files (x86)\OpenOffice.org 3\program|gov.nist.csd.pm.application.openoffice.OfficeLauncher|Open Office >>|645799-01
add|app|Microsoft Office Launcher|C:\PM\dist\pm-app-msoffice-1.5.jar|gov.nist.csd.pm.application.office.MSOfficeLauncher|MS Office >>|645799-01
add|app|Med-Rec|C:\PM\dist\pm-app-medrec-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.medrec.MREditor|Med-Rec >>|645799-01
add|app|Acct-Rec|C:\PM\dist\pm-app-acctrec-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.acctrec.AcctEditor|Acct-Rec >>|645799-01
add|app|Workflow Old|C:\PM\dist\pm-app-wkf-old-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.oldworkflow.Wkflow|Workflow Old >>|645799-01
add|app|Schema Builder|C:\PM\dist\pm-app-schemabuilder-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.schema.builder.SchemaBuilder3|SB>>|645799-01
add|app|Employee Record|C:\PM\dist\pm-app-emprec-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.appeditor.EmployeeRecord|ER>>|645799-01
add|app|Table Editor|C:\PM\dist\pm-app-tableeditor-1.5.jar;C:\PM\dist\pm-commons-1.5.jar;C:\PM\lib\activation-1.1.jar;C:\PM\lib\aopalliance-1.0.jar;C:\PM\lib\asm-3.1.jar;C:\PM\lib\bcmail-jdk15-1.44.jar;C:\PM\lib\bcprov-jdk15-1.44.jar;C:\PM\lib\cglib-2.2.1-v20090111.jar;C:\PM\lib\colorchooser-1.0.jar;C:\PM\lib\commons-logging-1.1.1.jar;C:\PM\lib\fontbox-1.6.0.jar;C:\PM\lib\guava-r09.jar;C:\PM\lib\guice-3.0.jar;C:\PM\lib\icu4j-3.8.jar;C:\PM\lib\jarjar-1.0.jar;C:\PM\lib\javax.inject-1.jar;C:\PM\lib\javax.mail-1.4.4.jar;C:\PM\lib\jempbox-1.6.0.jar;C:\PM\lib\jfontchooser-1.0.5-pm.jar;C:\PM\lib\jna-3.2.7-pm-platform.jar;C:\PM\lib\jna-3.2.7-pm.jar;C:\PM\lib\jsr305-1.3.7.jar;C:\PM\lib\miglayout-3.7.3.1-swing.jar;C:\PM\lib\pdfbox-1.6.0.jar;C:\PM\lib\wrapper-3.2.3.jar;C:\PM\lib\wrapper.jar|gov.nist.csd.pm.application.schema.tableeditor.TableEditor|TE>>|645799-01

add|ks|C:\PM\keystores\superKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|super

add|ks|C:\PM\keystores\aliceKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|alice

add|ks|C:\PM\keystores\katieKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|katie

add|ks|C:\PM\keystores\daveKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|dave

add|ks|C:\PM\keystores\bobKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|bob

add|ks|C:\PM\keystores\charlieKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|charlie

add|ks|C:\PM\keystores\exporterKeystore|C:\PM\keystores\clientTruststore|h|645799-01|u|exporter


