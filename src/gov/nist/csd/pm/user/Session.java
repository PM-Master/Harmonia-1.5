/*
 * Session.java
 *
 * Created on May 2, 2005, 10:09 AM
 *
 * Serban I. Gavrila
 * VDG Inc.
 *
 */
package gov.nist.csd.pm.user;

import gov.nist.csd.pm.common.application.SSLSocketClient;
import gov.nist.csd.pm.common.browser.*;
import gov.nist.csd.pm.common.graphics.GraphicsUtil;
import gov.nist.csd.pm.common.net.ItemType;
import gov.nist.csd.pm.common.net.Packet;
import gov.nist.csd.pm.common.util.CommandUtil;
import gov.nist.csd.pm.common.util.lang.Strings;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeModelEvent;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static gov.nist.csd.pm.common.info.PMCommand.GET_MEMBERS_OF;
import static gov.nist.csd.pm.common.net.LocalHostInfo.getLocalHost;
import static gov.nist.csd.pm.common.util.CommandUtil.makeCmd;

/**
 * @author gavrila@nist.gov
 * @version $Revision: 1.1 $, $Date: 2008/07/16 17:03:00 $
 * @since 1.5
 */
@SuppressWarnings("CallToThreadDumpStack")
public class Session extends JDialog implements ActionListener {

    public static final String PM_ALT_DELIM_PATTERN = "\\|";
    public static final String PM_CONNECTOR_ID = "1";
    public static final String PM_CONNECTOR_NAME = "PM";
    public static final String PM_NODE_USER = "u";
    public static final String PM_NODE_USERA = "U";
    public static final String PM_NODE_UATTR = "a";
    public static final String PM_NODE_UATTRA = "A";
    public static final String PM_NODE_POL = "p";
    public static final String PM_NODE_POLA = "P";
    public static final String PM_NODE_OATTR = "b";
    public static final String PM_NODE_OATTRA = "B";
    public static final String PM_NODE_ASSOC = "o";
    public static final String PM_NODE_ASSOCA = "O";
    public static final String PM_NODE_OPSET = "s";
    public static final String PM_NODE_OPSETA = "S";
    public static final String PM_NODE_CONN = "c";
    public static final String PM_NODE_CONNA = "C";
    public static final String PM_OBJ = "ob";
    public static final String PM_ARC = "r";
    public static final String PM_CLASS_FILE_NAME = "File";
    public static final String PM_CLASS_DIR_NAME = "Directory";
    public static final String PM_CLASS_SGRAPH_NAME = "Subgraph";
    public static final String PM_CLASS_USER_NAME = "User";
    public static final String PM_CLASS_UATTR_NAME = "User attribute";
    public static final String PM_CLASS_OBJ_NAME = "Object";
    public static final String PM_CLASS_OATTR_NAME = "Object attribute";
    public static final String PM_CLASS_CONN_NAME = "Connector";
    public static final String PM_CLASS_POL_NAME = "Policy class";
    public static final String PM_CLASS_OPSET_NAME = "Operation set";
    public static final String PM_CLASS_RECORD_NAME = "Record";
    public static final String PM_OFFICE = "OpenOffice";
    public static final String PM_RTF = "PM RTF Editor";
    public static final String PM_WKF_OLD = "PM WORKFLOWOLD";
    public static final String PM_DUMMY = "Dummy";
    public static final String PM_EMAIL = "PM Email";
    public static final String PM_OBJTYPE_RTF = "rtf";
    public static final String PM_OBJTYPE_EML = "eml";
    public static final String PM_OBJTYPE_WKF = "wkf";
    public static final String PM_OBJTYPE_DOC = "doc";
    public static final String PM_OBJTYPE_PPT = "ppt";
    public static final String PM_OBJTYPE_XLS = "xls";
    public static final String WORD_EDITOR = "MS Word Editor";
    public static final String ADMIN_TOOL = "PM Admin Tool";
    public static final String PM_VOS_PRES_ADMIN = "admin";
    public static final String PM_VOS_PRES_USER = "user";
    public static final String PM_DIRECTION_UP = "up";
    public static final String PM_DIRECTION_DOWN = "down";
    /**
	 * @uml.property  name="manager"
	 * @uml.associationEnd  
	 */
    private SessionManager manager;
    /**
	 * @uml.property  name="simClient"
	 * @uml.associationEnd  
	 */
    private SSLSocketClient simClient;
    /**
	 * @uml.property  name="cmdEditor"
	 * @uml.associationEnd  
	 */
    private CommandEditor cmdEditor;
    /**
	 * @uml.property  name="configEditor"
	 * @uml.associationEnd  
	 */
    private SessConfigEditor configEditor;
    /**
	 * @uml.property  name="pcEditor"
	 * @uml.associationEnd  
	 */
    private PcEditor pcEditor;
    /**
	 * @uml.property  name="userEditor"
	 * @uml.associationEnd  
	 */
    private UserEditor userEditor;
    /**
	 * @uml.property  name="uattrEditor"
	 * @uml.associationEnd  
	 */
    private UattrEditor uattrEditor;
    /**
	 * @uml.property  name="oattrEditor"
	 * @uml.associationEnd  
	 */
    private OattrEditor oattrEditor;
    /**
	 * @uml.property  name="permEditor"
	 * @uml.associationEnd  
	 */
    private PermEditor permEditor;
    /**
	 * @uml.property  name="exporterClient"
	 * @uml.associationEnd  
	 */
    private SSLSocketClient exporterClient;
    /**
	 * @uml.property  name="sKsPath"
	 */
    private String sKsPath = null;
    /**
	 * @uml.property  name="sTsPath"
	 */
    private String sTsPath = null;
    /**
	 * @uml.property  name="sSessionName"
	 */
    private String sSessionName = null;
    /**
	 * @uml.property  name="sSessionId"
	 */
    private String sSessionId = null;
    /**
	 * @uml.property  name="sSessionUser"
	 */
    private String sSessionUser = null;
    /**
	 * @uml.property  name="sSessionUserId"
	 */
    private String sSessionUserId = null;
    /**
	 * @uml.property  name="sSessionHost"
	 */
    private String sSessionHost = null;
    /**
	 * @uml.property  name="sVosPresType"
	 */
    private String sVosPresType = PM_VOS_PRES_USER;// The default presentation.
    /**
	 * @uml.property  name="tree"
	 * @uml.associationEnd  
	 */
    private PmGraph tree;
    /**
	 * @uml.property  name="connectorNode"
	 * @uml.associationEnd  
	 */
    private PmNode connectorNode;
    /**
	 * @uml.property  name="direction"
	 */
    private String direction = PM_DIRECTION_UP;
    /**
	 * @uml.property  name="mouseListener"
	 */
    private MouseListener mouseListener;
    /**
	 * @uml.property  name="startupVector"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
    private List<String> startupVector;
    /**
	 * @uml.property  name="rightClickedNode"
	 * @uml.associationEnd  
	 */
    private PmNode rightClickedNode;
    /**
	 * @uml.property  name="leftSelectedNode"
	 * @uml.associationEnd  
	 */
    private PmNode leftSelectedNode;
    /**
	 * @uml.property  name="markedNode"
	 * @uml.associationEnd  
	 */
    private PmNode markedNode;
    /**
	 * @uml.property  name="viewLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JLabel viewLabel;
    /**
	 * @uml.property  name="clientLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JLabel clientLabel;
    // Two pop-up menus, for the user presentation and the admin presentation.
    /**
	 * @uml.property  name="pmUserPopup"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JPopupMenu pmUserPopup = null;
    /**
	 * @uml.property  name="pmAdminPopup"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JPopupMenu pmAdminPopup = null;
    /**
	 * @uml.property  name="pmPopup"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JPopupMenu pmPopup = null;
    /**
	 * @uml.property  name="grantMenuItem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JMenuItem grantMenuItem;
    /**
	 * @uml.property  name="openMenuItem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private JMenuItem openMenuItem;
    private static final Cursor SESS_DEFAULT_CURSOR = Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR);
    private static final Cursor SESS_WAIT_CURSOR = Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR);
    private static final Cursor SESS_HAND_CURSOR = Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR);
    /**
	 * @uml.property  name="threadSet"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="gov.nist.csd.pm.user.LauncherThread"
	 */
    private HashSet threadSet;
    /**
	 * @uml.property  name="refreshTimer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Timer refreshTimer;
    /**
	 * @uml.property  name="sLastUpdateTimestamp"
	 */
    private String sLastUpdateTimestamp;
    /**
	 * @uml.property  name="userImageIcon"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private ImageIcon userImageIcon = null;
    /**
	 * @uml.property  name="expanedNodes"
	 */
    private List<TreePath> expanedNodes = new ArrayList<TreePath>();
    public static final String PM_SESSION_PROPERTY = "pmSession";

    /**
	 * @uml.property  name="sLastError"
	 */
    private String sLastError;
    /**
	 * @uml.property  name="crtDefaultCursor"
	 */
    private Cursor crtDefaultCursor;
    /**
	 * @uml.property  name="crtHandCursor"
	 */
    private Cursor crtHandCursor;
    
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Session(SessionManager manager, SSLSocketClient simClient,
            String sSessName, String sSessId, String sUserName, String sUserId,
            String sHostName) {
        this(manager, simClient, sSessName, sSessId, sUserName, sUserId, sHostName, false);
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public Session(SessionManager manager, SSLSocketClient simClient,
            String sSessName, String sSessId, String sUserName, String sUserId,
            String sHostName, boolean noGUI) {
        super(manager, ModalityType.MODELESS);
        setTitle(sSessName);
        setLocation(200, 200);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                doClose(true);// ask
            }
        });

        threadSet = new HashSet();

        this.manager = manager;
        this.simClient = simClient;
        this.sSessionName = sSessName;
        this.sSessionId = sSessId;
        this.sSessionUser = sUserName;
        this.sSessionUserId = sUserId;
        this.sSessionHost = sHostName;

        // (steveq) Get the user image

        try {
            userImageIcon = GraphicsUtil.getImageIcon("/images/common/users/"
                    + sUserName + ".gif", getClass());
        } catch (Exception e) {
            userImageIcon = GraphicsUtil.getImageIcon(
                    "/images/common/users/unknown-person.gif", getClass());
        }

        // Tell the engine to prepare the VOS graph for the user of this
            // session.
            // At this time there is no session yet (we are in the constructor).
            Packet res = null;
            try {
                Packet cmd = CommandUtil.makeCmd("computeVos", sSessionId,
                        sVosPresType, sSessionUserId, sSessionId);
                res = simClient.sendReceive(cmd, null);
                if (res.hasError()) {
                    JOptionPane.showMessageDialog(this, "Error in computeVos: "
                            + res.getErrorMessage());
                    doClose(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Exception in computeVos: " + e.getMessage());
                doClose(false);
            }
            sLastUpdateTimestamp = res.getStringValue(0);


        if (noGUI == false) {
            pcEditor = new PcEditor(this, simClient);
            pcEditor.pack();
            userEditor = new UserEditor(this, simClient);
            userEditor.pack();
            uattrEditor = new UattrEditor(this, simClient);
            uattrEditor.pack();
            oattrEditor = new OattrEditor(this, simClient);
            oattrEditor.pack();
            permEditor = new PermEditor(this, simClient);
            permEditor.pack();
            
            if (manager.getExporterSession() != null) {
                int exporterPort = manager.getExporterPort();
                System.out.println("Trying to create the exporter client socket with port "
                        + exporterPort);
                try {
                    exporterClient = new SSLSocketClient("localhost", exporterPort,
                            true, "c,Sess");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Unable to create SSL socket for Exporter on the local host.");
                    e.printStackTrace();
                    doClose(false);// don't ask
                }
            }

           
            crtDefaultCursor = SESS_DEFAULT_CURSOR;
            crtHandCursor = SESS_HAND_CURSOR;
            // Select the connector node as root node and ask the engine
            // for the tree data.

            connectorNode = new PmNode(PM_NODE_CONN, PM_CONNECTOR_ID,
                    PM_CONNECTOR_NAME, new PmNodeChildDelegate(simClient, nullToEmpty(sSessId) , PmGraphDirection.USER, PmGraphType.USER));
            getTwoLevels(connectorNode); // Added by Gopi
            tree = new PmGraph(connectorNode);

            mouseListener = new PmMouseListener();
            tree.addMouseListener(mouseListener);
            ToolTipManager.sharedInstance().registerComponent(tree);
            
            // Build the GUI.
            JToolBar toolBar = new JToolBar(null);
            toolBar.setFloatable(false);
            addButtons(toolBar);

            // steveq
            JPanel toolBarPanel = new JPanel();
            toolBarPanel.setLayout(new BorderLayout());

            JLabel userImageLabel = new JLabel(userImageIcon);
            userImageLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
            int maxButtonSize = 30;
            userImageLabel.setPreferredSize(new Dimension(maxButtonSize,
                    maxButtonSize));
            userImageLabel.setMaximumSize(new Dimension(maxButtonSize,
                    maxButtonSize));
            toolBarPanel.add(toolBar, BorderLayout.WEST);
            toolBarPanel.add(userImageLabel, BorderLayout.EAST);

            JScrollPane treeScrollPane = new JScrollPane(tree);
            treeScrollPane.setPreferredSize(new Dimension(400, 500));

            viewLabel = new JLabel("Now viewing: " + sSessionUser + " POS");
            clientLabel = new JLabel("Running as: " + sSessionUser);
            JPanel labelPane = new JPanel();
            labelPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
            labelPane.setLayout(new BorderLayout());
            labelPane.add(viewLabel, BorderLayout.WEST);
            labelPane.add(clientLabel, BorderLayout.EAST);

            JPanel labelAndScrollPane = new JPanel();
            labelAndScrollPane.setLayout(new BorderLayout());
            labelAndScrollPane.add(labelPane, BorderLayout.NORTH);
            labelAndScrollPane.add(treeScrollPane, BorderLayout.CENTER);
            // labelAndScrollPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

            JPanel contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(toolBarPanel, BorderLayout.NORTH);
            contentPane.add(labelAndScrollPane, BorderLayout.CENTER);

            // The Menu bar.
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            // The File menu.
            JMenu fileMenu = new JMenu("File");
            menuBar.add(fileMenu);

            JMenuItem menuItem = new JMenuItem("New");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            fileMenu.addSeparator();

            openMenuItem = new JMenuItem("Open");
            openMenuItem.addActionListener(this);
            fileMenu.add(openMenuItem);

            menuItem = new JMenuItem("Print");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            fileMenu.addSeparator();

            grantMenuItem = new JMenuItem("Grant To...");
            grantMenuItem.addActionListener(this);
            fileMenu.add(grantMenuItem);

            menuItem = new JMenuItem("Send To...");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            menuItem = new JMenuItem("Export To");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            fileMenu.addSeparator();

            menuItem = new JMenuItem("Delete");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            menuItem = new JMenuItem("Rename");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            menuItem = new JMenuItem("Properties");
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            fileMenu.addSeparator();

            menuItem = new JMenuItem("Exit", KeyEvent.VK_Q);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                    ActionEvent.CTRL_MASK));
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);

            // The Edit menu.
            JMenu editMenu = new JMenu("Edit");
            menuBar.add(editMenu);

            menuItem = new JMenuItem("Cut");
            menuItem.addActionListener(this);
            editMenu.add(menuItem);

            menuItem = new JMenuItem("Copy");
            menuItem.addActionListener(this);
            editMenu.add(menuItem);

            menuItem = new JMenuItem("Paste");
            menuItem.addActionListener(this);
            editMenu.add(menuItem);

            // The View menu.
            JMenu viewMenu = new JMenu("View");
            menuBar.add(viewMenu);

            menuItem = new JMenuItem("More tiers");
            menuItem.addActionListener(this);
            viewMenu.add(menuItem);

            menuItem = new JMenuItem("Fewer tiers");
            menuItem.addActionListener(this);
            viewMenu.add(menuItem);

            viewMenu.addSeparator();

            menuItem = new JMenuItem("Admin view");
            menuItem.addActionListener(this);
            viewMenu.add(menuItem);

            menuItem = new JMenuItem("User view");
            menuItem.addActionListener(this);
            viewMenu.add(menuItem);

            viewMenu.addSeparator();

            menuItem = new JMenuItem("Refresh");
            menuItem.addActionListener(this);
            viewMenu.add(menuItem);

            // The Tools menu.
            JMenu toolsMenu = new JMenu("Tools");
            menuBar.add(toolsMenu);

            menuItem = new JMenuItem("Change password...");
            menuItem.addActionListener(this);
            toolsMenu.add(menuItem);

            menuItem = new JMenuItem("Run command...");
            menuItem.addActionListener(this);
            toolsMenu.add(menuItem);

            /* (steveq) deleted */
            // menuItem = new JMenuItem("Composer");
            // menuItem.addActionListener(this);
            // toolsMenu.add(menuItem);
            //
            // menuItem = new JMenuItem("Composite Viewer");
            // menuItem.addActionListener(this);
            // toolsMenu.add(menuItem);

            menuItem = new JMenuItem("RTF Editor");
            menuItem.addActionListener(this);
            toolsMenu.add(menuItem);

            menuItem = new JMenuItem("Admin Tool");
            menuItem.addActionListener(this);
            toolsMenu.add(menuItem);

            menuItem = new JMenuItem("Word");
            menuItem.addActionListener(this);
            toolsMenu.add(menuItem);

            toolsMenu.addSeparator();

            JMenu configureMenu = new JMenu("Configure");

            menuItem = new JMenuItem("Key stores...");
            menuItem.addActionListener(this);
            configureMenu.add(menuItem);

            // menuItem = new JMenuItem("Add startups");
            // menuItem.addActionListener(this);
            // configureMenu.add(menuItem);

            menuItem = new JMenuItem("Set startups");
            menuItem.addActionListener(this);
            configureMenu.add(menuItem);

            toolsMenu.add(configureMenu);

            // The user popup menu.
            pmUserPopup = new JPopupMenu();

            menuItem = new JMenuItem("Test connect");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Test read file");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Test request permissions...");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            pmUserPopup.addSeparator();

            menuItem = new JMenuItem("New");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            pmUserPopup.addSeparator();

            menuItem = new JMenuItem("Open");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Open With TH");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            pmUserPopup.addSeparator();

            menuItem = new JMenuItem("Grant To...");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Send To...");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Export To...");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            pmUserPopup.addSeparator();

            menuItem = new JMenuItem("Cut");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Copy");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Delete");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            menuItem = new JMenuItem("Rename");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            pmUserPopup.addSeparator();

            menuItem = new JMenuItem("Select as startup");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            pmUserPopup.addSeparator();

            menuItem = new JMenuItem("Properties");
            menuItem.addActionListener(this);
            pmUserPopup.add(menuItem);

            // The admin popup menu.
            pmAdminPopup = new JPopupMenu();

            menuItem = new JMenuItem("Edit");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            pmAdminPopup.addSeparator();

            menuItem = new JMenuItem("Add policy class...");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            pmAdminPopup.addSeparator();

            menuItem = new JMenuItem("Add user attribute...");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            menuItem = new JMenuItem("Add user...");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            pmAdminPopup.addSeparator();

            menuItem = new JMenuItem("Add object attribute...");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            menuItem = new JMenuItem("Add object...");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            pmAdminPopup.addSeparator();

            menuItem = new JMenuItem("Mark node");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            menuItem = new JMenuItem("Assign marked node");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            menuItem = new JMenuItem("Delete assignment");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            pmAdminPopup.addSeparator();

            menuItem = new JMenuItem("Delete node");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            pmAdminPopup.addSeparator();

            menuItem = new JMenuItem("Set permissions on...");
            menuItem.addActionListener(this);
            pmAdminPopup.add(menuItem);

            // Set the user popup as default.
            pmPopup = pmUserPopup;

            // contentPane.setBackground(Color.cyan);
            // menuBar.setBackground(Color.cyan);
            // fileMenu.setBackground(Color.cyan);
            // editMenu.setBackground(Color.cyan);
            // viewMenu.setBackground(Color.cyan);
            // toolsMenu.setBackground(Color.cyan);
            // //viewLabel.setBackground(Color.cyan);
            // //clientLabel.setBackground(Color.cyan);
            // labelPane.setBackground(Color.cyan);



            cmdEditor = new CommandEditor(manager, this, simClient);
            cmdEditor.pack();
        }
        configEditor = new SessConfigEditor(this);
        configEditor.pack();
        refreshTimer = new Timer(7000, this);
        if (!checkKeyStores()) {
            JOptionPane.showMessageDialog(this,
                    "No keystores found or set for " + sUserName + " and host "
                    + sHostName + "!");
            doClose(false); // don't ask
        }
       // refreshTimer.start();
    }


    public PmGraph getVosGraph(){
        return tree;
    }
    // Try to obtain the keystores paths from the engine,
    // or else from the user.
    private boolean checkKeyStores() {
        if (sKsPath != null && sKsPath.length() > 0 && sTsPath != null
                && sTsPath.length() > 0) {
            return true;
        }

        // Try to get the paths from the engine.
        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("getKStorePaths", sSessionId);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in getKStorePaths: "
                        + res.getErrorMessage());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Exception in getKStorePaths: "
                    + e.getMessage());
            return false;
        }

        // If the keystores paths are stored in the engine, then the answer
        // contains:
        // item 0: absolute path of the user keystore or the empty string;
        // item 1: absolute path of the user truststore or the empty string.
        if (res.size() >= 2) {
            sKsPath = res.getStringValue(0);
            sTsPath = res.getStringValue(1);
        }

        // Even now, a path may be empty. Give the user a chance to set it.
        if (sKsPath != null && sKsPath.length() > 0 && sTsPath != null
                && sTsPath.length() > 0) {
            return true;
        }

        // Otherwise ask the user to configure.
        doKeyStores();

        if (sKsPath != null && sKsPath.length() > 0 && sTsPath != null
                && sTsPath.length() > 0) {
            return true;
        }

        return false;
    }

    public void setKStorePaths(String sKsPath, String sTsPath) {
        this.sKsPath = sKsPath;
        this.sTsPath = sTsPath;

        // Store the paths in the engine for later.
        String sHost = getLocalHost();
        if (sHost == null) {
            JOptionPane.showMessageDialog(this,
                    "Failed to obtain the local host name!");
            return;
        }

        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("setKStorePaths", sSessionUserId,
                    sHost, sKsPath, sTsPath);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in setKStorePaths: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Exception in setKStorePaths: "
                    + e.getMessage());
            return;
        }
    }

    private void addButtons(JToolBar toolBar) {
        JButton button = new JButton();
        int maxButtonSize = 30;
        button.setPreferredSize(new Dimension(maxButtonSize, maxButtonSize));
        button.setMaximumSize(new Dimension(maxButtonSize, maxButtonSize));
        button.setActionCommand("Change direction");
        button.addActionListener(this);
        button.setToolTipText("Change navigation direction");
        button.setIcon(GraphicsUtil.getImageIcon("/images/changeDir.gif",
                getClass()));
        toolBar.add(button);

        button = new JButton();
        button.setPreferredSize(new Dimension(maxButtonSize, maxButtonSize));
        button.setMaximumSize(new Dimension(maxButtonSize, maxButtonSize));
        button.setActionCommand("Refresh");
        button.addActionListener(this);
        button.setToolTipText("Restart");
        /* (steveq) Can't find start.gif */
        // button.setText("Refresh");
        button.setIcon(GraphicsUtil.getImageIcon("/images/reload.gif",
                getClass()));
        toolBar.add(button);

    }
    //TreeModelEvent ;
    // Rebuild the tree starting with the specified root node,
    // and using the current direction and the current graph type.
    public void resetTree(PmNode rootNodeInfo) {
        if (rootNodeInfo == null) {
            if (leftSelectedNode == null) 
            	rootNodeInfo = connectorNode;
            else 
            	rootNodeInfo = leftSelectedNode;
        }
        rootNodeInfo.invalidate(); //children.clear(); // Added by Gopi
        getTwoLevels(rootNodeInfo); // Uncommented by Gopi
        //tree.setModel(new PmGraphModel(rootNodeInfo)); // Added by Gopi
        mouseListener = new PmMouseListener();
        manager.getSession(sSessionId).tree.setModel(new PmGraphModel(rootNodeInfo));
        manager.getSession(sSessionId).tree.addMouseListener(mouseListener);
    }
    
    // Get two levels of descendants or ancestors and hook them up the
    // argument node.
    public void getTwoLevels(PmNode node) {
    	if (! node.getChildren().isEmpty()) {
    		      System.out.println("children exist - bad");
    		      PmNode childNode = null;
    		      for (int i = 0; i < node.getChildren().size(); i++) {
    		        childNode = (PmNode)node.getChildren().get(i);
    		        if (childNode.getChildren().isEmpty()) {

    		          // Now get level2 children data from this node
    		        	
    		        	List<String[]> level2ChildrenData = new ArrayList<String[]>();
    		          if (direction.equalsIgnoreCase(PM_DIRECTION_UP)) {
    		            level2ChildrenData = getPosMembersOf(childNode.getName(), childNode.getId(), childNode.getType());
    		          } else {
    		            level2ChildrenData = getPosContainersOf(childNode.getName(), childNode.getId(), childNode.getType());
    		          }

    		          if (level2ChildrenData != null) {
    		            String[] grandChildData = null;
    		            for (int j = 0; j < level2ChildrenData.size(); j++) {
    		              grandChildData = (String[])level2ChildrenData.get(j);
    		              PmNode grandChildNode = new PmNode(grandChildData);
    		              PmNode.linkNodes(childNode, grandChildNode);

    		            }
    		          }
    		        }
    		      }
    		    
    		    } else if (node.getChildren().isEmpty()) {
    		      System.out.println("children empty - good");
    		      // Get level1 children data
    		      List<String[]> level1ChildrenData= new ArrayList<String[]>();
    		      if (direction.equalsIgnoreCase(PM_DIRECTION_UP)) {
    		        level1ChildrenData = getPosMembersOf(node.getName(), node.getId(), node.getType());
    		      } else {
    		        level1ChildrenData = getPosContainersOf(node.getName(), node.getId(), node.getType());
    		      }

    		      if (level1ChildrenData != null) {
    		        // Create level1 children nodes
    		        String[] childData = null;
    			for (int i = 0; i < level1ChildrenData.size(); i++) {
    		          childData = (String[])level1ChildrenData.get(i);
    		          PmNode childNode = new PmNode(childData);
    		          PmNode.linkNodes(node, childNode);

    		          // Now get level2 children data from this node
    		          List<String[]> level2ChildrenData = new ArrayList<String[]>();
    		          if (direction.equalsIgnoreCase(PM_DIRECTION_UP)) {
    		            level2ChildrenData = getPosMembersOf(childNode.getName(), childNode.getId(), childNode.getType());
    		          } else {
    		            level2ChildrenData = getPosContainersOf(childNode.getName(), childNode.getId(), childNode.getType());
    		          }

    		          if (level2ChildrenData != null) {
    		            String[] grandChildData = null;  
    		            for (int j = 0; j < level2ChildrenData.size(); j++) {
    		              grandChildData = (String[])level2ChildrenData.get(j);
    		              PmNode grandChildNode = new PmNode(grandChildData);
    		              PmNode.linkNodes(childNode, grandChildNode);
    		            }
    		          }
    		        }
    		      }
    		    }
    }
    private List<String[]> getPosMembersOf(String sLabel, String sId, String sType) {
        sLastError = null;
        try {
            Packet cmd = makeCmd("getPosMembersOf", sSessionId, sLabel, sId, sType,
            		sVosPresType);
            Packet res = simClient.sendReceive(cmd, null);
            if (res == null) {
                sLastError = "Null result from getMembersOf()!";
                return null;
            }
            if (res.hasError()) {
                sLastError = res.getErrorMessage();
                return null;
            }
            List<String[]> v = new ArrayList<String[]>();
            for (int i = 0; i < res.size(); i++) {
                String sLine = res.getStringValue(i);
                String[] pieces = sLine.split(SessionManager.PM_FIELD_DELIM);
                v.add(new String[]{pieces[0], pieces[1], pieces[2]});
            }
            return v;
        } catch (Exception e) {
            sLastError = e.getMessage();
            e.printStackTrace();
            return null;
        }
    	/* *System.out.println("GetPosMembersOf(label=" + sLabel + ", id=" + sId + ", type=" + sType);

        Packet res = null;
        try {
          Packet cmd = CommandUtil.makeCmd("getPosMembersOf", sSessionId, sLabel, sId, sType, sVosPresType);
          res = simClient.sendReceive(cmd, null);
          if (res.hasError()) {
            JOptionPane.showMessageDialog(this, "Error in getPosMembersOf: " + res.getErrorMessage());
            return null;
          }
        } catch (Exception e) {
          e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Exception in getPosMembersOf: " + e.getMessage());
          return null;
        }
        List<String[]> v = new ArrayList<String[]>();
        for (int i = 0; i < res.size(); i++) {
          String sLine = res.getStringValue(i);
          String[] pieces = sLine.split(SessionManager.PM_FIELD_DELIM);
          v.add(new String[] {pieces[0], pieces[1], pieces[2]});
        }
        return v;*/
      }
    // Returns a vector of string arrays. Each string array has 3 elements,
    // the type, id, and label/name of a container that contains the clicked node.
    // The containment is defined by the assignment relation: we say that
    // x contains y if there is an assignment y ---> x, regardless
    // of the types of x, y.
    private List<String[]> getPosContainersOf(String sLabel, String sId, String sType) {
      Packet res = null;
      try {
        Packet cmd = CommandUtil.makeCmd("getPosContainersOf", sSessionId, sLabel, sId, sType, 
        		sVosPresType);
        res = simClient.sendReceive(cmd, null);
        if (res.hasError()) {
          JOptionPane.showMessageDialog(this, "Error in getPosContainersOf: " + res.getErrorMessage());
          return null;
        }
      } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Exception in getPosContainersOf: " + e.getMessage());
        return null;
      }

      List<String[]> v = new ArrayList<String[]>();
      for (int i = 0; i < res.size(); i++) {
        String sLine = res.getStringValue(i);
        String[] pieces = sLine.split(SessionManager.PM_FIELD_DELIM);
        v.add(new String[] {pieces[0], pieces[1], pieces[2]});
      }
      return v;
    }


     
    private void doChangeDirection() {
        TreePath selPath = tree.getSelectionPath();
        if (direction.equalsIgnoreCase(PM_DIRECTION_DOWN)) {
            direction = PM_DIRECTION_UP;
        } else {
            direction = PM_DIRECTION_DOWN;
        }
        if (selPath == null) {
            resetTree(connectorNode);
        } else {
            resetTree((PmNode) selPath.getLastPathComponent());
        }
    }







    class PmMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int selRow = tree.getRowForLocation(e.getX(), e.getY());
            TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
            System.out.println("********************************\nClicked\n****************************");
            if (selRow != -1) {
                PmNode node = (PmNode) selPath.getLastPathComponent();
                if (SwingUtilities.isRightMouseButton(e)) {
                    // Handle right-click events. Remember the node and display
                    // the pop up menu.
                    rightClickedNode = node;
                    pmPopup.show(e.getComponent(), e.getX(), e.getY());
                } else if (e.getClickCount() == 2) {

                    // A double click typically means we want to open
                    // the selected node. This is where code for the policy
                    // machine to retrieve nodes (or open the file) should
                    // be inserted.
                    System.out.println("Double click on "
                            + leftSelectedNode.getType() + ", "
                            + leftSelectedNode.getId() + ", "
                            + leftSelectedNode.getName());
                    // Here, we should really check if the node that we
                    // clicked on should be opened as a directory or as a file.
                    // Instead, we just open it as a directory (i.e., we
                    // acquire nodes using createNodes()).
                } else {
                    leftSelectedNode = node;
                    System.out.println("Single click on "
                            + leftSelectedNode.getType() + ", "
                            + leftSelectedNode.getId() + ", "
                            + leftSelectedNode.getName());
                    //getTwoLevels(node);
                }
            }
        }
    }


    private void processRefreshTimerEvent() {
        // crtDefaultCursor = SESS_WAIT_CURSOR;
        // crtHandCursor = SESS_WAIT_CURSOR;
        // picture.setCursor(SESS_WAIT_CURSOR);

        conditionalRefresh();
    }

    private void conditionalRefresh() {
        final SwingWorker worker = new SwingWorker() {

            @Override
            public Object construct() {
                Packet res = null;
                try {
                    Packet cmd = CommandUtil.makeCmd("isTimeToRefresh",
                            sSessionId, sLastUpdateTimestamp);
                    res = simClient.sendReceive(cmd, null);
                    if (res.hasError()) {
                        JOptionPane.showMessageDialog(
                                Session.this,
                                "Error in isTimeToRefresh: "
                                + res.getErrorMessage());
                        return null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(Session.this,
                            "Exception in isTimeToRefresh: " + e.getMessage());
                    return null;
                }

                if (!(res.getStringValue(0)).equals("yes")) {
                    return null; // No need to refresh.
                }
                try {
                    Packet cmd = CommandUtil.makeCmd("computeVos", sSessionId,
                            sVosPresType, sSessionUserId, sSessionId);
                    res = simClient.sendReceive(cmd, null);
                    if (res.hasError()) {
                        JOptionPane.showMessageDialog(
                                Session.this,
                                "Error in computeVos: "
                                + res.getErrorMessage());
                        return null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(Session.this,
                            "Exception in computeVos: " + e.getMessage());
                    return null;
                }
                sLastUpdateTimestamp = res.getStringValue(0);

                resetTree(connectorNode);
                return SessionManager.success();
            }

            @Override
            public void finished() {
                if(viewLabel != null){
                    if (sVosPresType.equalsIgnoreCase(PM_VOS_PRES_USER)) {
                        viewLabel.setText("Now viewing: user POS");
                    } else {
                        viewLabel.setText("Now viewing: admin POS");
                    }
                }
            }
        };
        //worker.start();
    }

    @Override
    public String getName() {
        return sSessionName;
    }

    public String getId() {
        return sSessionId;
    }

    public String getUser() {
        return sSessionUser;
    }

    public String getUserId() {
        return sSessionUserId;
    }

    public String getHost() {
        return sSessionHost;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src.equals(refreshTimer)) {
            processRefreshTimerEvent();
            return;
        }

        String sCommand = null;
        if (src instanceof JButton) {
            sCommand = ((JButton) src).getActionCommand();
        } else {
            sCommand = ((JMenuItem) src).getText();
        }

        if (sCommand.equals("Exit")) {
            doClose(true);
        } else if (sCommand.equalsIgnoreCase("Change direction")) {
            doChangeDirection();
        } else if (sCommand.equalsIgnoreCase("Admin view")) {
            doAdminView();
        } else if (sCommand.equalsIgnoreCase("User view")) {
            doUserView();
        } else if (sCommand.equalsIgnoreCase("Refresh")) {
            doRefresh();

        } else if (sCommand.equalsIgnoreCase("Grant to...")) {
            // This event could come from the user right-clicking an object
            // and selecting "Grant to..." popup menu, or from the user
            // selecting the menu "File/Grant to...".
            if (src == grantMenuItem) {
                doGrantOnSelObj();
            } else {
                doGrantOnRcObj();
            }
        } else if (sCommand.equalsIgnoreCase("Send to...")) {
            doEmail();
        } else if (sCommand.equalsIgnoreCase("Export to...")) {
            doExport();
        } else if (sCommand.equalsIgnoreCase("Change password...")) {
            doChangePassword();
        } else if (sCommand.equals("Run command...")) {
            doCommand();
        } else if (sCommand.equals("E-grant")) {
            doLaunchGrantor(null, true);// true doesn't matter.
        } else if (sCommand.equals("Medical Record Editor")) {
            doLaunchMREditor(null);
        } else if (sCommand.equals("Accounts Editor")) {
            doLaunchAcctEditor(null);
        } else if (sCommand.equals("Composer")) {
            System.err.println("Composer is not installed!");
            // /doLaunchComposer();
        } else if (sCommand.equals("Composite Viewer")) {
            System.err.println("Composite Viewer is not installed!");
            // /doLaunchCompositeViewer(null);
        } else if (sCommand.equals("RTF Editor")) {
            doLaunchRTFEditor(null);
        } else if(sCommand.equals("Dummy")){
        	doLaunchDummy(null);
        } else if (sCommand.equals("Admin Tool")) {
            doLaunchAdminTool(null, null);
        } else if (sCommand.equalsIgnoreCase("Workflow Old")){
        	doLaunchWorkFlowOld(null);
        } else if (sCommand.equals("Key stores...")) {
            doKeyStores();
            // } else if (sCommand.equals("Add startups")) {
            // doAddStartups();
        } else if (sCommand.equals("Set startups")) {
            doSetStartups();
        } else if (sCommand.equals("Select as startup")) {
            doSelectStartup();
        } else if (sCommand.equals("Test request permissions...")) {
            doTestRequestPerms();
            // } else if (sCommand.equals("Test read file")) {
            // doTestReadFile();
        } else if (sCommand.equals("Open")) {
            if (src == openMenuItem) {
                doOpenSelObj();
            } else {
                doOpenRcObj();
            }
        } else if (sCommand.equals("Open With TH")) {
            doOpenObjectWithTH();
        } else if (sCommand.equals("Properties")) {
            doProperties();
        } else if (sCommand.equals("Edit")) {
            doEdit();
        } else if (sCommand.equals("Add policy class...")) {
            doAddPolicyClass();
        } else if (sCommand.equals("Add user attribute...")) {
            doAddUattr();
        } else if (sCommand.equals("Add user...")) {
            doAddUser();
        } else if (sCommand.equals("Add object attribute...")) {
            doAddOattr();
        } else if (sCommand.equals("Add object...")) {
            doAddObject();
        } else if (sCommand.equals("Mark node")) {
            doMarkNode();
        } else if (sCommand.equals("Assign marked node")) {
            doAssignNode();
        } else if (sCommand.equals("Delete assignment")) {
            doDeleteAssignment();
        } else if (sCommand.equals("Delete node")) {
            doDeleteNode();
        } else if (sCommand.equals("Set permissions on...")) {
            doSetPerms();
        }
    }

    private void doEmail() {
    }

    // The user has clicked the File/Grant To... menu item. The object
    // is the (left click) selected one.
    private void doGrantOnSelObj() {
        if (leftSelectedNode == null) {
            JOptionPane.showMessageDialog(this, "You have to select an object!");
            return;
        }

        System.out.println("Granting access rights on: "
                + leftSelectedNode.getName() + " " + leftSelectedNode.getType());
        /*
         * if (!leftSelectedNode.getType().equalsIgnoreCase(PM_NODE_ASSOC)) {
         * JOptionPane.showMessageDialog(this,
         * "The entity you selected is not an object!"); return; }
         */
        doLaunchGrantor(leftSelectedNode.getName(), true);
    }

    // The user has right-clicked on an object and selected the Grant To...
    // menu item from the popup menu.
    private void doGrantOnRcObj() {
        System.out.println("Granting access rights on: "
                + rightClickedNode.getName() + " " + rightClickedNode.getType());
        /*
         * if (!rightClickedNode.getType().equalsIgnoreCase(PM_NODE_ASSOC)) {
         * JOptionPane.showMessageDialog(this,
         * "The entity you selected is not an object!"); return; }
         */
        doLaunchGrantor(rightClickedNode.getName(), true);
    }

    // Export the selected object to one of the mounted devices.
    // First ask the kernel to provide the list of mounted devices.
    // Let the user select one of the devices and a folder where to save
    // the object's underlying file.
    private void doExport() {
        System.out.println("Exporting the object " + rightClickedNode.getName()
                + " " + rightClickedNode.getType());
        if (exporterClient == null) {
            JOptionPane.showMessageDialog(this, "No exporter present!");
            return;
        }

        String sObjName = rightClickedNode.getName();

        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("getDevices", sSessionId);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in getDevices: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Exception in getDevices: " + e.getMessage());
            return;
        }

        if (res != null) {
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.getStringValue(i));
            }
        }

        // Display a list of mounted devices and let the user select one.
        JLabel devLabel = new JLabel("Mounted devices:");
        DefaultListModel devListModel = new DefaultListModel();
        JList devList = new JList(devListModel);
        JScrollPane devListScrollPane = new JScrollPane(devList);
        devListScrollPane.setPreferredSize(new Dimension(200, 200));

        if (res != null) {
            for (int i = 0; i < res.size(); i++) {
                devListModel.addElement(res.getStringValue(i));
            }
        }

        String message = "Please select a device:";
        int ret = JOptionPane.showOptionDialog(null, new Object[]{message,
                    devLabel, devListScrollPane}, "Select a device",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        if (ret == JOptionPane.CANCEL_OPTION
                || ret == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String sSelDev = (String) devList.getSelectedValue();

        // Grant the exporter read permission on the object.
        res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("setPerms", sSessionId,
                    "Exporter", "", "", "", "", "File read", sObjName,
                    PM_NODE_OATTR, "no");
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this,
                        "Error in setPerms: " + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Exception in setPerms: " + e.getMessage());
            return;
        }

        // Now send a message to the exporter asking it to read the object and
        // create a copy of its underlying file on the selected device.
        res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("exportObject", sSessionId,
                    sObjName, sSelDev);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in exportObject: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Exception in exportObject: "
                    + e.getMessage());
            return;
        }
    }

    private void pingExporter() {
        if (exporterClient == null) {
            JOptionPane.showMessageDialog(this, "No exporter present!");
            return;
        }
        try {
            Packet cmd = CommandUtil.makeCmd("ping", sSessionId);
            Packet res = exporterClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error while pinging the exporter: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Exception while pinging the exporter: " + e.getMessage());
            return;
        }
    }

    private void doSetPerms() {
        permEditor.prepare(rightClickedNode.getName(), rightClickedNode.getId(),
                rightClickedNode.getType());
        permEditor.setVisible(true);
    }

    private void doDeleteNode() {
        try {
            Packet cmd = CommandUtil.makeCmd("deleteNode", // commented by Gopi -- sSessionId,
                    sSessionId, rightClickedNode.getId(), rightClickedNode.getType(),
                    "yes"); 
            Packet res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in deleteNode: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Exception in deleteNode: " + e.getMessage());
            return;
        }
    }

    private void doEdit() {
        String sType = rightClickedNode.getType();
        if (sType.equalsIgnoreCase(PM_NODE_UATTR)) {
            uattrEditor.prepareForEdit(rightClickedNode.getId());
            uattrEditor.setVisible(true);
        } else if (sType.equalsIgnoreCase(PM_NODE_OATTR)
                || sType.equalsIgnoreCase(PM_NODE_ASSOC)) {
            oattrEditor.prepareForEdit(rightClickedNode.getId());
            oattrEditor.setVisible(true);
        } else if (sType.equalsIgnoreCase(PM_NODE_POL)) {
            pcEditor.prepareForEdit(rightClickedNode.getId());
            pcEditor.setVisible(true);
        }
    }

    private void doAddOattr() {
        System.out.println("You selected \"Add object attribute...\" clicking on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        // The clicked node must be the connector, a policy class, or an object
        // attribute.
        if (!rightClickedNode.getType().equalsIgnoreCase(PM_NODE_CONN)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_POL)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_OATTR)) {
            JOptionPane.showMessageDialog(this,
                    "You cannot add an object attribute to the selected node!");
            return;
        }

        oattrEditor.prepareForAdd(rightClickedNode.getId(), rightClickedNode.getType());
        oattrEditor.setVisible(true);
    }

    private void doAddObject() {
        System.out.println("You selected \"Add object...\" clicking on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        // The clicked node must be the connector, a policy class, or an object
        // attribute.
        if (!rightClickedNode.getType().equalsIgnoreCase(PM_NODE_OATTR)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_CONN)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_POL)) {
            JOptionPane.showMessageDialog(this,
                    "You cannot add an object to the selected node!");
            return;
        }
        JOptionPane.showMessageDialog(this,
                "Not yet implemented. Use an application to create objects!");
    }

    private void doDeleteAssignment() {
        if (markedNode == null) {
            JOptionPane.showMessageDialog(this,
                    "Please mark a node for de-assignment!");
            return;
        }
        try {
            Packet cmd = CommandUtil.makeCmd("deleteAssignment", sSessionId, null, //Added by Gopi
                    markedNode.getId(), markedNode.getType(), rightClickedNode.getId(),
                    rightClickedNode.getType(), "yes");
            Packet res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this,
                        "Error in deleteAssignment: " + res.getErrorMessage());
                return;
            }
            markedNode = null;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Exception in deleteAssignment: " + e.getMessage());
            return;
        }
    }

    private void doAssignNode() {
        if (markedNode == null) {
            JOptionPane.showMessageDialog(this,
                    "Please mark a node for assignment!");
            return;
        }
        try { 
            Packet cmd = CommandUtil.makeCmd("assign", sSessionId, null, // added null parameter by Gopi
                    markedNode.getId(), markedNode.getType(), rightClickedNode.getId(),
                    rightClickedNode.getType(), "yes");
            Packet res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this,
                        "Error in assign: " + res.getErrorMessage());
                return;
            }
            markedNode = null;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Exception in assign: " + e.getMessage());
            return;
        }
    }

    private void doMarkNode() {
        markedNode = new PmNode(rightClickedNode.getType(), rightClickedNode.getId(),
                rightClickedNode.getName());
    }

    private void doAddUattr() {
        System.out.println("You selected \"Add user attribute...\" clicking on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        // The clicked node must be the connector, a policy class, or a user
        // attribute.
        if (!rightClickedNode.getType().equalsIgnoreCase(PM_NODE_UATTR)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_CONN)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_POL)) {
            JOptionPane.showMessageDialog(this,
                    "You cannot add a user attribute to the selected node!");
            return;
        }

        uattrEditor.prepareForAdd(rightClickedNode.getId(), rightClickedNode.getType());
        uattrEditor.setVisible(true);
    }

    private void doAddUser() {
        System.out.println("You selected \"Add user...\" clicking on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        // The clicked node must be the connector or a user attribute.
        if (!rightClickedNode.getType().equalsIgnoreCase(PM_NODE_UATTR)
                && !rightClickedNode.getType().equalsIgnoreCase(PM_NODE_CONN)) {
            JOptionPane.showMessageDialog(this,
                    "You cannot add a user to the selected node!");
            return;
        }

        userEditor.prepare(rightClickedNode.getId(), rightClickedNode.getType());
        userEditor.setVisible(true);
    }

    private void doAddPolicyClass() {
        System.out.println("You selected \"Add policy class...\" clicking on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        // It's an error if the clicked node is not the connector node.
        if (!rightClickedNode.getType().equalsIgnoreCase(PM_NODE_CONN)) {
            JOptionPane.showMessageDialog(this,
                    "You cannot add a policy class to the selected node!");
            return;
        }
        pcEditor.prepareForAdd();
        pcEditor.setVisible(true);
    }

    private void doAddStartups() {
        // Empty or create an empty internal list of startups. An element of the
        // list
        // is <pos id>.
        JOptionPane.showMessageDialog(
                this,
                "Right-click desired node, click popup menu \"Select as startup\", repeat. When finished, select \"Tools/Configure/Set startups\"");
        if (startupVector == null) {
            startupVector = new ArrayList<String>();
        } else {
            startupVector.clear();
        }
    }

    // Sends a command to the engine to store the startups for the
    // user of this session to the acative directory. The command arguments are
    // the session id (from which the engine can find the user), and the
    // startups (these are POS ids for this session). The engine must
    // translate these POS ids to original ids before storing them
    // to the AD.
    private void doSetStartups() {

        if (startupVector == null) {
            startupVector = new ArrayList<String>();
        }

        System.out.println("doSetStartups()");
        for (int i = 0; i < startupVector.size(); i++) {
            System.out.println("  POS id=" + startupVector.get(i));
        }

        // Prepare and send the command.
        try {
            Packet cmd = CommandUtil.makeCmd("setStartups", sSessionId);
            for (int i = 0; i < startupVector.size(); i++) {
                cmd.addItem(ItemType.CMD_ARG, startupVector.get(i));
            }
            Packet res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in setStartups: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Exception in setStartups: "
                    + e.getMessage());
            return;
        }
        startupVector.clear();
    }

    private void doSelectStartup() {
        System.out.println("You selected the following node as a startup:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());
        if (startupVector == null) {
            startupVector = new ArrayList<String>();
        }
        if (startupVector.contains(rightClickedNode.getId())) {
            return;
        }
        startupVector.add(rightClickedNode.getId());
    }

    private void doKeyStores() {
        configEditor.setKStorePaths(sKsPath, sTsPath);
        configEditor.setVisible(true);
    }

    // Include here any action you want to take before closing the session.
    public void prepareToClose() {
        Iterator hsiter = threadSet.iterator();
        while (hsiter.hasNext()) {
            LauncherThread et = (LauncherThread) hsiter.next();
            // Process p = et.getProcess();
            // p.destroy();
            // et.destroy();
        }
        try {
            if (exporterClient != null) {
                exporterClient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (refreshTimer != null) {
            refreshTimer.stop();
        }
        setVisible(false);
    }

    // Close this session.
    private void doClose(boolean ask) {
        if (!mayIClose()) {
            JOptionPane.showMessageDialog(
                    this,
                    "You may not close the session. Either internal error or some process still running...");
            return;
        }

        if (ask) {
            int option = JOptionPane.showConfirmDialog(this,
                    "Do you really want to end this session?", "Close Session",
                    JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) {
                return;
            }
        }

        prepareToClose();
        manager.logonMenuItem.setEnabled(true);
        manager.closeSession(sSessionId);
    }

    private boolean mayIClose() {
        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("maySessionClose", sSessionId);
            res = simClient.sendReceive(cmd, null);
            if (res == null) {
                return false;
            }
            if (res.hasError()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Exception in maySessionClose: " + e.getMessage());
            return false;
        }
    }

    private void doCommand() {
        cmdEditor.prepare();
        cmdEditor.setVisible(true);
    }

    private void doProperties() {
        System.out.println("You selected Open on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("getObjEmailProps", sSessionId,
                    rightClickedNode.getName());
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this,
                        "Error in getObjEmailProps: " + res.getErrorMessage());
                return;
            }
            markedNode = null;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Exception in getObjEmailProps: " + e.getMessage());
            return;
        }
        if (res.size() <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Empty result from getObjEmailProps!");
            return;
        }
        // The result returned by the engine contains:
        // item 0: the sender
        // item 1: recipients
        // item 2: timestamp
        // item 3: subject
        // item 4,...: attached objects
        DefaultListModel propListModel = new DefaultListModel();
        final JList propList = new JList(propListModel);
        JScrollPane propListScrollPane = new JScrollPane(propList);
        propListModel.addElement("From: " + res.getStringValue(0));
        propListModel.addElement("To: " + res.getStringValue(1));
        propListModel.addElement("Sent: " + res.getStringValue(2));
        propListModel.addElement("Subject: " + res.getStringValue(3));
        for (int i = 4; i < res.size(); i++) {
            propListModel.addElement("Attached: " + res.getStringValue(i));
        }

        String message = "Properties of email message "
                + rightClickedNode.getName();
        JOptionPane.showOptionDialog(this, new Object[]{message,
                    propListScrollPane}, null, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }

    private void doOpenObjectWithTH() {
        System.out.println("You selected Open on:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        // Get the properties of the object represented by this VOS node.
        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("getVosIdProperties", sSessionId,
                    sVosPresType, rightClickedNode.getId());
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error in getVosIdProperties: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Exception in getVosIdProperties: " + e.getMessage());
            return;
        }
        if (res.size() <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Engine returned an empty result while getting VOS node properties");
            return;
        }

        // <name>|<id>|<class>|<inh>|<host or orig or tpl name>|<path or orig
        // id>
        String s = res.getStringValue(0);
        String[] pieces = s.split(PM_ALT_DELIM_PATTERN);
        String sClass = pieces[2];
        String sNameOrHost = null;
        if (pieces.length >= 5) {
            sNameOrHost = pieces[4];
        }
        String sIdOrPath = null;
        if (pieces.length >= 6) {
            sIdOrPath = pieces[5];
        }

        if (!sClass.equalsIgnoreCase(PM_CLASS_FILE_NAME)) {
            JOptionPane.showMessageDialog(this, "Object not of File class!");
            return;
        }
        if (!sIdOrPath.toLowerCase().endsWith(".rtf")) {
            JOptionPane.showMessageDialog(this, "Object content is not RTF!");
            return;
        }
        invokeRtfEditor(rightClickedNode.getName(), true);
    }

    // Invoked when the user right-clicks on a VOS node and selects "Open" from
    // the
    // popup menu.
    private void doOpenRcObj() {
        doOpenObject(rightClickedNode.getId(), rightClickedNode.getName(),
                rightClickedNode.getType());
    }

    // Called when the user selects the object, then selects "Open" from the
    // main menu.
    private void doOpenSelObj() {
        if (leftSelectedNode == null) {
            JOptionPane.showMessageDialog(this, "You have to select an object!");
            return;
        }

        doOpenObject(leftSelectedNode.getId(), leftSelectedNode.getName(),
                leftSelectedNode.getType());
    }

    private void doOpenObject(String sSelectedId, String sSelectedLabel,
            String sSelectedType) {
        System.out.println("You selected Open on:");
        System.out.println("              id =  " + sSelectedId);
        System.out.println("           label =  " + sSelectedLabel);
        System.out.println("            type =  " + sSelectedType);

        // Get the properties of the object represented by this VOS node.
        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("getVosIdProperties", sSessionId,
                    sVosPresType, sSelectedId);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error in getVosIdProperties: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Exception in getVosIdProperties: " + e.getMessage());
            return;
        }
        if (res.size() <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Engine returned an empty result while getting VOS node properties");
            return;
        }
        // The result returned by the engine contains a single item:
        // <name>|<id>|<class>|<inh>|<host or orig or tpl name>|<path or orig
        // id>
        // where the name, id, class, host and path are those of the object
        // of class File,
        // and the orig name and id are those of the PM entity represented by
        // the virtual object. The name, id, class, and inh are always present
        // in the result. The others may be omitted.
        // If the class is Record, only the name, id, class, inh ("no"),
        // and <host or orig or tpl name> are present.

        // Invoke the application that corresponds to the file object type.
        String s = res.getStringValue(0);
        String[] pieces = s.split(PM_ALT_DELIM_PATTERN);
        String sClass = pieces[2];
        String sNameOrHost = null;
        if (pieces.length >= 5) {
            sNameOrHost = pieces[4];
        }
        String sIdOrPath = null;
        if (pieces.length >= 6) {
            sIdOrPath = pieces[5];
        }


        if (sClass.equalsIgnoreCase(PM_CLASS_FILE_NAME)) {

            String sName = rightClickedNode.getName();
            sIdOrPath = sIdOrPath.toLowerCase();
            //TODO: invoke the work flow if ext is .wkf.

            //get workflow path from session manager.
            if (sIdOrPath.endsWith(".rtf")) {
                invokeRtfEditor(sSelectedLabel, false);

            } else if (sIdOrPath.endsWith(".pdf")){
                manager.getApplicationManager().launchClientApp(ApplicationManager.PDF_VIEWER_APP_NAME, sSessionId, sName);
            } else if (sIdOrPath.endsWith(".config")) {
                manager.getApplicationManager().launchClientApp(ApplicationManager.WORKFLOW_EDITOR_APP_NAME, sSessionId, sName);
            } else if (sIdOrPath.endsWith(".doc")
                    || sIdOrPath.endsWith(".ppt")
                    || sIdOrPath.endsWith(".xls")) {
                String sObjType = Strings.getFileExtensionOfPath(sIdOrPath);
                invokeOffice(sObjType, sSelectedLabel);

            } else if (sIdOrPath.endsWith(".eml")) {
                invokeEmailer(sName);

            } else if(sIdOrPath.endsWith(".wkf")){
            	manager.getApplicationManager().launchClientApp(ApplicationManager.WORKFLOW_OLD, sSessionId, sSelectedLabel);
            	//invokeWorkFlowOld(sSelectedLabel);
            }else {
                JOptionPane.showMessageDialog(this,
                        "Unknown content type for \"" + sIdOrPath.toLowerCase()
                        + "\"!");
                return;
            }

        } else if (sClass.equalsIgnoreCase(PM_CLASS_USER_NAME)
                || sClass.equalsIgnoreCase(PM_CLASS_UATTR_NAME)
                || sClass.equalsIgnoreCase(PM_CLASS_OATTR_NAME)
                || sClass.equalsIgnoreCase(PM_CLASS_OBJ_NAME)
                || sClass.equalsIgnoreCase(PM_CLASS_POL_NAME)
                || sClass.equalsIgnoreCase(PM_CLASS_CONN_NAME)
                || sClass.equalsIgnoreCase(PM_CLASS_OPSET_NAME)) {
            invokeAdminTool(sNameOrHost, sClass);

            // Change this asap! The account template is hard-coded!!!
        } else if (sClass.equalsIgnoreCase(PM_CLASS_RECORD_NAME)) {
            // sNameOrHost should contain the template name.
            System.out.println("*****************************" + sNameOrHost);

            if (sNameOrHost.equals("acctTpl")) {
                invokeAcctEditor(sSelectedLabel);
            } else {
                invokeMREditor(sSelectedLabel);
            }
        }
    }

    private String entityClassToType(String sClass) {
        if (sClass.equalsIgnoreCase(PM_CLASS_USER_NAME)) {
            return PM_NODE_USER;
        } else if (sClass.equalsIgnoreCase(PM_CLASS_UATTR_NAME)) {
            return PM_NODE_UATTR;
        } else if (sClass.equalsIgnoreCase(PM_CLASS_OBJ_NAME)) {
            return PM_OBJ;
        } else if (sClass.equalsIgnoreCase(PM_CLASS_OATTR_NAME)) {
            return PM_NODE_OATTR;
        } else if (sClass.equalsIgnoreCase(PM_CLASS_POL_NAME)) {
            return PM_NODE_POL;
        } else if (sClass.equalsIgnoreCase(PM_CLASS_OPSET_NAME)) {
            return PM_NODE_OPSET;
        } else if (sClass.equalsIgnoreCase(PM_CLASS_CONN_NAME)) {
            return PM_NODE_CONN;
        } else {
            return null;
        }
    }

    // Displays a table of object properties and returns the index
    // of the object selected by the user.
    private int selectObject(ArrayList list) {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int n = list.size();
        String[][] tableData = new String[n][5];
        for (int i = 0; i < n; i++) {
            String s = ((String) list.get(i)).substring(4);
            String[] pieces = s.split(PM_ALT_DELIM_PATTERN);
            String sClass = pieces[2];
            String sNameOrHost = pieces[4];
            String sIdOrPath = pieces[5];
            String sYesNo = pieces[3];
            tableData[i][0] = sClass;
            tableData[i][4] = sYesNo;
            if (sClass.equalsIgnoreCase(PM_CLASS_FILE_NAME)
                    || sClass.equalsIgnoreCase(PM_CLASS_DIR_NAME)) {
                tableData[i][1] = sNameOrHost;
                tableData[i][2] = sIdOrPath;
                tableData[i][3] = "";
            } else {
                tableData[i][1] = "";
                tableData[i][2] = "";
                tableData[i][3] = sNameOrHost;
            }
        }
        String[] columnNames = {"Class", "Host", "Path", "Name",
            "With ascendants"};
        JTable objTable = new JTable(tableData, columnNames);
        JScrollPane objScrollPane = new JScrollPane(objTable);
        objTable.setPreferredScrollableViewportSize(new Dimension(500, 150));
        String message = "Select the object you want to open:";
        int res = JOptionPane.showOptionDialog(this, new Object[]{message,
                    objScrollPane}, "Objects", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (res != JOptionPane.OK_OPTION) {
            return -1;
        }
        return objTable.getSelectedRow();
    }

    private void invokeWordEditor(String sVobjName) {
        JOptionPane.showMessageDialog(this, "Not yet implemented!");
    }

    private void invokeAdminTool(String sEntityName, String sEntityClass) {
        doLaunchAdminTool(sEntityName, entityClassToType(sEntityClass));
    }

    private void invokeCompositeViewer(String sVobjName) {
        System.out.println("Method Session.invokeCompositeViewer() is not implemented");
        // /doLaunchCompositeViewer(sVobjName);
    }

    // Called when the user right-clicks on an .EML object to read a
    // saved message.
    private void invokeEmailer(String sVobjName) {
        doLaunchGrantor(sVobjName, false);// to open a msg, not to grant.
    }

    // Invoke the OpenOffice application.
    private void invokeOffice(String sVobjType, String sVobjName) {
        doLaunchOffice(sVobjType, sVobjName);
    }

    // Invoke the MS Office application.
    private void invokeMSOffice(String sVobjType, String sVobjName) {
//		doLaunchMSOffice(sVobjType, sVobjName);
    }

    private void invokeAcctEditor(String sRecName) {
        doLaunchAcctEditor(sRecName);
    }

    private void invokeMREditor(String sRecName) {
        // Before invoking the editor, ask the engine for permissions.
        String sReqPerms = "File read,File write";
        // ...

        doLaunchMREditor(sRecName);
    }

    // The RTFEditor application may be invoked from the current session
    // or from the spawned one.
    private void invokeRtfEditor(String sVobjName, boolean bTH) {
        if (bTH) {
            doLaunchTHEditor(sVobjName);
        } else {
            doLaunchRTFEditor(sVobjName);
        }
    }
    // The Old Work Flow 
    private void invokeWorkFlowOld(String sVobjName){
    	doLaunchWorkFlowOld(sVobjName);
    }
    
    private void invokeDummy(String sVobjName){
    	doLaunchDummy(sVobjName);
    }
    // See whether a new session would lead to at least "File read" permission.
    // The application to launch can be PM_OFFICE or PM_RTF.
    private boolean createNewSession(String sVobjType, String sVobjName) {
        // Create the engine part of a new session from the current session:
        // same
        // host and user, but empty active attributes.
        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("spawnSession", sSessionId);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in spawnSession: "
                        + res.getErrorMessage());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Exception in spawnSession: "
                    + e.getMessage());
            return false;
        }

        // The engine answer contains:
        // item 0: <sess name>
        // item 1: <sess id>
        // item 2: <user id>
        // Build the new session object.
        String sSessName = res.getStringValue(0);
        String sSessId = res.getStringValue(0);
        // JOptionPane.showMessageDialog(this, "A new session " + sSessName +
        // " was created");

        String sReqPerms = "File read,File write";

        // NOTE: it is essential to use the new session's id in the following
        // command:
        try {
            Packet cmd = CommandUtil.makeCmd("requestPerms", sSessId,
                    rightClickedNode.getName(), sReqPerms);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in requestPerms: "
                        + res.getErrorMessage());
                return deleteSession(sSessId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Exception in requestPerms: "
                    + e.getMessage());
            return deleteSession(sSessId);
        }

        HashSet perms = SessionManager.packetToSet(res);
        if (!perms.contains("File read")) {
            JOptionPane.showMessageDialog(this,
                    "Not enough permissions to open the selected object!");
            return deleteSession(sSessId);
        }
        if (!perms.contains("File write")) {
            JOptionPane.showMessageDialog(this,
                    "This object will be opened in read-only mode!");
        }

        // Construct the Session object. Note that the PM session already
        // exists,
        // and has the active attributes.
        Session session = new Session(manager, simClient, sSessName, sSessId,
                sSessionUser, sSessionUserId, sSessionHost);
        session.pack();
        session.setVisible(true);
        manager.registerSession(session);
        if (sVobjType.equalsIgnoreCase(PM_OBJTYPE_RTF)) {
            session.doLaunchRTFEditor(sVobjName);
        } else if (sVobjType.equalsIgnoreCase(PM_OBJTYPE_DOC)
                || sVobjType.equalsIgnoreCase(PM_OBJTYPE_PPT)
                || sVobjType.equalsIgnoreCase(PM_OBJTYPE_XLS)) {
            session.doLaunchOffice(sVobjType, sVobjName);
        } else if (sVobjType.equalsIgnoreCase(PM_OBJTYPE_EML)) {
            // session.doLaunchEmailer(sVobjName);
            session.doLaunchGrantor(sVobjName, false);// to open a msg, not to
            // grant
        } else if (sVobjType.equalsIgnoreCase(PM_OBJTYPE_WKF)){
        	session.doLaunchWorkFlowOld(sVobjName);
        }
        return true;
    }

    // Get the Office Launcher path, the keystores for SSL, etc., and launch
    // Office component.
    private void doLaunchOffice(String sVobjType, String sVobjName) {
        manager.getApplicationManager().launchClientApp(ApplicationManager.OPEN_OFFICE_APP_NAME, sSessionId, "-objtype", sVobjType, sVobjName);
        
    }

    // Get the editor path, the keystores for SSL, etc., and launch the editor.
    private void doLaunchTHEditor(String sVobjName) {
        manager.getApplicationManager().launchClientApp(ApplicationManager.TH_EDITOR_APP_NAME, sSessionId, sVobjName);

    }

    // Get the editor path, the keystores for SSL, etc., and launch the editor.
    private void doLaunchRTFEditor(String sVobjName) {
        manager.getApplicationManager().launchClientApp(ApplicationManager.RTF_EDITOR_APP_NAME, sSessionId, sVobjName);

    }
    //
    private void doLaunchDummy(String sVobjName){
    	manager.getApplicationManager().launchClientApp(ApplicationManager.DUMMY_APP, sSessionId, sVobjName);
    }
    // Get the Work Flow to work Old PM_WKF_OLD
    private void doLaunchWorkFlowOld(String sVobjName){
    	manager.getApplicationManager().launchClientApp(ApplicationManager.WORKFLOW_OLD, sSessionId, sVobjName);
    }
    // The exporter is launched automatically by the session manager, within a
    // session w/o GUI, by calling this method.
    // The exporter's path can be set by using the Configure...
    // menu of the session manager.
    // The keystores for the user "exporter" can be set in the exporter's
    // session.
    /**
	 * @uml.property  name="exporterProcess"
	 */
    Process exporterProcess = null;

    public boolean doLaunchExporter() {
        ApplicationManager appMan = manager.getApplicationManager();
        appMan.addApplicationManagerListener(new ApplicationManagerListener() {

            @Override
            public void applicationStarted(String applicationName, String processId, NativeProcessWrapper procWrapper) {
                if(applicationName.equals(ApplicationManager.EXPORTER_APP_NAME)){
                    exporterProcess = procWrapper.getProcess();
                    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){

                        @Override
                        public void run() {
                            if(exporterProcess != null){
                                exporterProcess.destroy();
                            }
                        }
                    }));
                }
            }

            @Override
            public void applicationTerminated(String processId) {
                //Don't care
            }
        });
        appMan.launchClientApp(ApplicationManager.EXPORTER_APP_NAME, sSessionId, "-exporter", "8082");
        return true;
    }

    public void destroyExporter(){
        if(exporterProcess != null){
            exporterProcess.destroy();
        }
    }

    // (steveq) No such component.
    // private void doLaunchCompositeViewer(String sObjName) {
    // //String sCompoViewerPath = manager.getCompoViewerPath();
    // String sViewerPath = "E:\\PolicyMachine\\PmCompositeViewer\\viewer.jar";
    // if (sViewerPath == null || sViewerPath.length() == 0) {
    // JOptionPane.showMessageDialog(this,
    // "Composite viewer path is not set. Please configure the Session Manager and try again!");
    // return;
    // }
    // if (sKsPath == null || sKsPath.length() == 0 || sTsPath == null ||
    // sTsPath.length() == 0) {
    // JOptionPane.showMessageDialog(this,
    // "At least one certificate store path is not set. Please configure the session and try again!");
    // return;
    // }
    //
    // StringBuffer sb = new StringBuffer();
    // sb.append("javaw -cp ");
    // sb.append("\"" + sViewerPath + "\"");
    // sb.append(" -Djavax.net.ssl.keyStore=");
    // sb.append("\"" + sKsPath + "\"");
    // sb.append(" -Djavax.net.ssl.keyStorePassword=aaaaaa ");
    // sb.append(" -Djavax.net.ssl.trustStore=");
    // sb.append("\"" + sTsPath + "\"");
    // sb.append(" viewer.CompositeSelector");
    // sb.append(" -session " + sSessionId);
    // if (sObjName != null)
    // sb.append(" \"" + sObjName + "\"");
    //
    // System.out.println("Viewer cmd line: " + sb.toString());
    //
    // LauncherThread et = new LauncherThread(sb.toString(), "VIEWER-");
    // threadSet.add(et);
    // et.start();
    // }
    private void doLaunchAcctEditor(String sRecName) {
        manager.getApplicationManager().launchClientApp(ApplicationManager.ACCOUNT_EDITOR_APP_NAME, sSessionId, sRecName);
    }

    private void doLaunchMREditor(String sRecName) {
        manager.getApplicationManager().launchClientApp(ApplicationManager.MEDICAL_RECORD_EDITOR_APP_NAME, sSessionId, sRecName);
    }

    /* (steveq) No such component. */
    // private void doLaunchComposer() {
    // //String sComposerPath = manager.getComposerPath();
    // String sComposerPath = "E:\\PolicyMachine\\PmComposer\\composer.jar";
    // if (sComposerPath == null || sComposerPath.length() == 0) {
    // JOptionPane.showMessageDialog(this,
    // "Composer path is not set. Please configure the Session Manager and try again!");
    // return;
    // }
    // if (sKsPath == null || sKsPath.length() == 0 || sTsPath == null ||
    // sTsPath.length() == 0) {
    // JOptionPane.showMessageDialog(this,
    // "At least one certificate store path is not set. Please configure the session and try again!");
    // return;
    // }
    //
    // StringBuffer sb = new StringBuffer();
    // sb.append("javaw -cp ");
    // sb.append("\"" + sComposerPath + "\"");
    // sb.append(" -Djavax.net.ssl.keyStore=");
    // sb.append("\"" + sKsPath + "\"");
    // sb.append(" -Djavax.net.ssl.keyStorePassword=aaaaaa ");
    // sb.append(" -Djavax.net.ssl.trustStore=");
    // sb.append("\"" + sTsPath + "\"");
    // sb.append(" composer.CompositeEditor");
    // sb.append(" -session " + sSessionId);
    //
    // System.out.println("Composer cmd line: " + sb.toString());
    //
    // LauncherThread et = new LauncherThread(sb.toString(), "COMP-");
    // threadSet.add(et);
    // et.start();
    // }
    // Launch the Grantor tool to open or grant/send a given object.
    // If the object is null, no object was yet selected for grant/send.
    // If bGrant is true, read or read/write access to the object will
    // be granted. Otherwise, the object must be a message (.eml) and
    // will be open.
    // When bGrant is true, the first argument may also be a record.
    // Add the checks later.
    private void doLaunchGrantor(String sVobjName, boolean bGrant) {
        ApplicationManager applicationManager = manager.getApplicationManager();
        List<String> args = newArrayList();
        if(sVobjName != null){
            args.add(sVobjName);
        }
        if(bGrant){
            args.add("-grant");
        }
        applicationManager.launchClientApp(ApplicationManager.EGRANT_APP_NAME, sSessionId, args.toArray(new String[0]));
    }

    /*
    private void doLaunchEmailer(String sVobjName) {
    // String sEmailPath = manager.getEmailPath();
    String sEmailPath = "E:\\PolicyMachine\\PmEmailer\\email.jar";
    if (sEmailPath == null || sEmailPath.length() == 0) {
    JOptionPane
    .showMessageDialog(
    this,
    "Email client path is not set. Please configure the Session Manager and try again!");
    return;
    }
    if (sKsPath == null || sKsPath.length() == 0 || sTsPath == null
    || sTsPath.length() == 0) {
    JOptionPane
    .showMessageDialog(
    this,
    "At least one certificate store path is not set. Please configure the session and try again!");
    return;
    }

    StringBuffer sb = new StringBuffer();
    sb.append("javaw -cp ");
    sb.append("\"" + sEmailPath + "\"");
    sb.append(" -Djavax.net.ssl.keyStore=");
    sb.append("\"" + sKsPath + "\"");
    sb.append(" -Djavax.net.ssl.keyStorePassword=aaaaaa ");
    sb.append(" -Djavax.net.ssl.trustStore=");
    sb.append("\"" + sTsPath + "\"");
    sb.append(" gov.nist.csd.pm.application.emailer.Emailer");
    sb.append(" -session " + sSessionId);
    if (sVobjName != null)
    sb.append(" \"" + sVobjName + "\"");

    System.out.println("EML cmd line: " + sb.toString());

    //	LauncherThread et = new LauncherThread(sb.toString(), "EML-");
    //	threadSet.add(et);
    //	et.start();
    }
     */
    private void doLaunchAdminTool(String sEntityName, String sEntityType) {
        
        String engineHost = manager.getEngineHost();
        int enginePort = manager.getEnginePort();

        List<String> argList = newArrayList("-engine", engineHost, "-engineport", Integer.toString(enginePort));


        if (sEntityName != null) {
            argList.addAll(newArrayList("-entity", sEntityName));
        }
        if (sEntityType != null) {
            argList.addAll(newArrayList("-type", sEntityType));
        }

        System.out.println("-=-=-=-=-");
        System.out.println(argList);
        System.out.println("-=-=-=-=-");

        manager.getApplicationManager().launchPeerApp(sSessionName, sSessionId, argList.toArray(new String[argList.size()]));
      
    }

    private boolean deleteSession(String sId) {
        try {
            Packet cmd = CommandUtil.makeCmd("deleteSession", null, sId);
            Packet res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in deleteSession: "
                        + res.getErrorMessage());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Exception in deleteSession: "
                    + e.getMessage());
            return false;
        }
        return true;
    }

    // Ask the kernel to create a process in order to run an
    // application in it. This function returns the process id,
    // which will be passed to the application on the command
    // line like the session id is now.
    public String createProcess() {
        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("createProcess", sSessionId);
            res = simClient.sendReceive(cmd, null);
            if (res == null) {
                JOptionPane.showMessageDialog(this,
                        "createProcess(in create process) returned null!");
                return null;
            }
            if (res.size() < 1) {
                JOptionPane.showMessageDialog(this,
                        "no process id returned in createProcess()!");
                return null;
            }
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this,
                        "Error in createProcess(): " + res.getErrorMessage());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Exception in createProcess(): " + e.getMessage());
            return null;
        }
        return res.getStringValue(0);
    }

    private static String setToString(HashSet set) {
        if (set == null || set.isEmpty()) {
            return "";
        }

        Iterator hsiter = set.iterator();
        boolean firstTime = true;
        StringBuilder sb = new StringBuilder();

        while (hsiter.hasNext()) {
            String sId = (String) hsiter.next();
            if (firstTime) {
                sb.append(sId);
                firstTime = false;
            } else {
                sb.append(",").append(sId);
            }
        }
        return sb.toString();
    }

    private HashSet stringToSet(String sArg) {
        HashSet set = new HashSet();
        if (sArg != null) {
            String[] pieces = sArg.split(",");
            for (int i = 0; i < pieces.length; i++) {
                String t = pieces[i].trim();
                if (t.length() > 0) {
                    set.add(t);
                }
            }
        }
        return set;
    }

    private void doAdminView() {
        sVosPresType = PM_VOS_PRES_ADMIN;
        pmPopup = pmAdminPopup;
        doRefresh();
    }

    private void doUserView() {
        sVosPresType = PM_VOS_PRES_USER;
        pmPopup = pmUserPopup;
        doRefresh();
    }

    private void doRefresh() {
        crtDefaultCursor = SESS_WAIT_CURSOR;
        crtHandCursor = SESS_WAIT_CURSOR;  
        //sVosPresType = PM_VOS_PRES_USER; // Commented by Gopi
        refreshInternal();
    	//conditionalRefresh();
    }

    private void refreshInternal() {
    	//JOptionPane.showMessageDialog(this, "this is the one");
     /*   Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("computeVos", sSessionId,
                    sVosPresType, sSessionUserId, sSessionId);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in computeVos: "
                        + res.getErrorMessage());
                doClose(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Exception in computeVos: " + e.getMessage());
            doClose(false);
        }
        sLastUpdateTimestamp = res.getStringValue(0);
        connectorNode = new PmNode(PM_NODE_CONN, PM_CONNECTOR_ID,
                PM_CONNECTOR_NAME, new PmNodeChildDelegate(simClient, nullToEmpty(this.sSessionId) , PmGraphDirection.USER, PmGraphType.USER));
        resetTree(connectorNode);
        this.configEditor.repaint();*/
	       //Session s = manager.getSession(sSessionId);

	       //s.update(getGraphics());
    	  final SwingWorker worker = new SwingWorker() {

   	       
    	      public Object construct() {
    	        Packet res = null;
    	        try {
    	          Packet cmd = CommandUtil.makeCmd("computeVos", sSessionId,
    	        		  sVosPresType, sSessionUserId, sSessionId);

    	          res = simClient.sendReceive(cmd, null);
    	          if (res.hasError()) {
    	            JOptionPane.showMessageDialog(Session.this, "Error in computeVos: " + res.getErrorMessage());
    	            return null;
    	          }
    	        } catch (Exception e) {
    	          e.printStackTrace();
    	          JOptionPane.showMessageDialog(Session.this, "Exception in computeVos: " + e.getMessage());
    	          return null;
    	        }
    	        if (sVosPresType == PM_VOS_PRES_USER) {
    	        connectorNode = new PmNode(PM_NODE_CONN, PM_CONNECTOR_ID,
    	                PM_CONNECTOR_NAME, new PmNodeChildDelegate(simClient, nullToEmpty(sSessionId) , PmGraphDirection.USER, PmGraphType.USER));
    	        } else {
    	        connectorNode = new PmNode(PM_NODE_CONN, PM_CONNECTOR_ID,
    	                PM_CONNECTOR_NAME, new PmNodeChildDelegate(simClient, nullToEmpty(sSessionId) , PmGraphDirection.USER, PmGraphType.ADMIN));
    	        }
    	        // connectorNode = new PmNode(PM_NODE_CONN, PM_CONNECTOR_ID,
                //        PM_CONNECTOR_NAME, new PmNodeChildDelegate(simClient, nullToEmpty(sSessId) , PmGraphDirection.USER, PmGraphType.USER));
                
    	        sLastUpdateTimestamp = res.getStringValue(0);

    	        resetTree(connectorNode);
    	        return SessionManager.success();
    	      }
    	      
    	      public void finished() {
    	        if (sVosPresType.equalsIgnoreCase(PM_VOS_PRES_USER))
    	          viewLabel.setText("Now viewing: user POS");
    	        else
    	          viewLabel.setText("Now viewing: admin POS");
    	        crtDefaultCursor = SESS_DEFAULT_CURSOR;
    	        crtHandCursor = SESS_HAND_CURSOR;
    	      }
    	    };
    	    worker.start();
    }

    private void doTestRequestPerms() {
        String sReqPerms = JOptionPane.showInputDialog(null,
                "Please enter requested permissions, separated by commas:");
        if (sReqPerms == null) {
            return;
        }
        System.out.println("Request perms {" + sReqPerms + "} for:");
        System.out.println("              id =  " + rightClickedNode.getId());
        System.out.println("           label =  " + rightClickedNode.getName());
        System.out.println("            type =  " + rightClickedNode.getType());

        Packet res = null;
        try {
            Packet cmd = CommandUtil.makeCmd("requestPerms", sSessionId,
                    rightClickedNode.getName(), sReqPerms);
            res = simClient.sendReceive(cmd, null);
            if (res.hasError()) {
                JOptionPane.showMessageDialog(this, "Error in requestPerms: "
                        + res.getErrorMessage());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Exception in requestPerms: "
                    + e.getMessage());
            return;
        }

        DefaultListModel permModel = new DefaultListModel();
        JList permList = new JList(permModel);
        JScrollPane permScrollPane = new JScrollPane(permList);
        permScrollPane.setPreferredSize(new Dimension(300, 150));

        for (int i = 0; i < res.size(); i++) {
            permModel.addElement(res.getStringValue(i));
        }

        String message = "List of granted permissions:";
        int ret = JOptionPane.showOptionDialog(this, new Object[]{message,
                    permScrollPane}, "Permissions", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }

    private void doChangePassword() {
        JPasswordField oldPassField = new JPasswordField();
        JPasswordField newPassField = new JPasswordField();
        JPasswordField conPassField = new JPasswordField();
        String msgOld = "Old password:";
        String msgNew = "New password:";
        String msgCon = "Confirm new password:";
        for (int j = 0; j < 3; j++) {
            int ret = JOptionPane.showOptionDialog(this, new Object[]{msgOld,
                        oldPassField, msgNew, newPassField, msgCon, conPassField},
                    "Change password", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (ret != JOptionPane.OK_OPTION) {
                return;
            }

            // Get old, new, and confirmation password.
            char[] cOldPass = oldPassField.getPassword();
            char[] cNewPass = newPassField.getPassword();
            char[] cConPass = conPassField.getPassword();

            try {
                Packet cmd = CommandUtil.makeCmd("changePassword", sSessionId,
                        sSessionUser, new String(cOldPass),
                        new String(cNewPass), new String(cConPass));
                for (int i = 0; i < cOldPass.length; i++) {
                    cOldPass[i] = 0;
                }
                for (int i = 0; i < cNewPass.length; i++) {
                    cNewPass[i] = 0;
                }
                for (int i = 0; i < cConPass.length; i++) {
                    cConPass[i] = 0;
                }

                Packet res = simClient.sendReceive(cmd, null);
                if (res.hasError()) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Error in changePassword: "
                            + res.getErrorMessage());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Exception in changePassword: " + e.getMessage());
                return;
            }

            // Success.
            JOptionPane.showMessageDialog(this,
                    "Password successfully changed.");
            return;
        }
    }

    // Recursively delete a directory.
    private boolean deleteFile(File f) {
        System.out.println("Deleting " + f.getName());
        if (f.isFile()) {
            return f.delete();
        }
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (!deleteFile(files[i])) {
                return false;
            }
        }
        return f.delete();
    }

    private byte[] getBytes(String filename) {
        try {
            File f = new File(filename);
            int bytesLeft = (int) f.length();
            byte[] buffer = new byte[bytesLeft];
            FileInputStream fis = new FileInputStream(f);
            int n;
            int index = 0;
            while ((bytesLeft > 0)
                    && (n = fis.read(buffer, index, bytesLeft)) != -1) {
                index += n;
                bytesLeft -= n;
            }
            fis.close();
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
