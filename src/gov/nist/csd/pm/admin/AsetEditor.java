/*
 * AttrSetEditor.java
 *
 * Created June 3, 2005.
 * Revised Aug 30, 2005.
 *
 * Serban I. Gavrila
 * For KT Consulting, Inc.
 *
 */

package gov.nist.csd.pm.admin;

import gov.nist.csd.pm.common.application.SSLSocketClient;
import gov.nist.csd.pm.common.net.Packet;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;



/**
 * @author gavrila@nist.gov
 * @version $Revision: 1.4 $, $Date: 2008/07/16 19:11:55 $
 * @since 1.5
 */
public class AsetEditor extends JDialog implements ActionListener, ListSelectionListener {

	// test 3
  /**
 * @uml.property  name="tool"
 * @uml.associationEnd  
 */
private PmAdmin tool;
  /**
 * @uml.property  name="sslClient"
 * @uml.associationEnd  
 */
private SSLSocketClient sslClient;

  /**
 * @uml.property  name="asetField"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JTextField asetField;                // The new op set name.

  /**
 * @uml.property  name="attrListModel"
 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
 */
private DefaultListModel attrListModel;      // Model and list of operations
  /**
 * @uml.property  name="attrList"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JList attrList;                      // to add.
  /**
 * @uml.property  name="attrVector"
 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
 */
private List<String> attrVector;
  
  /**
 * @uml.property  name="addButton"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JButton addButton;                    // The add opset button.
  
  /**
 * @uml.property  name="asetListModel"
 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
 */
private DefaultListModel asetListModel;      // Model and list of existing attrsets.
  /**
 * @uml.property  name="asetList"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JList asetList;
  /**
 * @uml.property  name="asetVector"
 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
 */
private List<String> asetVector;
  
  /**
 * @uml.property  name="attr2ListModel"
 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
 */
private DefaultListModel attr2ListModel;     // Model and list of the selected
  /**
 * @uml.property  name="attr2List"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JList attr2List;                     // attrset's attributes.
  /**
 * @uml.property  name="attr2Vector"
 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
 */
private List<String> attr2Vector;
  
  /**
 * @uml.property  name="deleteButton"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JButton deleteButton;                // The delete opset/operation button.
  /**
 * @uml.property  name="computeButton"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JButton computeButton;                // The delete opset/operation button.
  /**
 * @uml.property  name="closeButton"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
private JButton closeButton;                 // The close button.

  /**
 * @uml.property  name="constraints"
 */
private GridBagConstraints constraints = new GridBagConstraints();

  public AsetEditor(PmAdmin tool, SSLSocketClient sslClient) {
    super(tool, false);  // non-modal

    this.tool = tool;
    this.sslClient = sslClient;

    setTitle("Attribute Sets");

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        close();
      }
    });

    // Start building the GUI.
    JPanel asetPane = new JPanel();
    asetPane.setLayout(new GridBagLayout());

    JLabel asetLabel = new JLabel("Attribute Set:");
    asetField = new JTextField(20);

    JLabel attrLabel = new JLabel("Attributes To Add:");
    attrListModel = new DefaultListModel();
    attrList = new JList(attrListModel);
    JScrollPane attrListScrollPane = new JScrollPane(attrList);
    attrListScrollPane.setPreferredSize(new Dimension(240,100));

    constraints.insets = new Insets(0, 0, 5, 0);
    
    addComp(asetPane, asetLabel, 0, 0, 1, 1);
    addComp(asetPane, asetField, 0, 1, 4, 1);
    
    constraints.insets = new Insets(0, 10, 5, 0);
    addComp(asetPane, attrLabel, 4, 0, 1, 1);
    addComp(asetPane, attrListScrollPane, 4, 1, 4, 4);

    JPanel upperPane = new JPanel();
    upperPane.setLayout(new BorderLayout());
    upperPane.add(asetPane, BorderLayout.CENTER);
    upperPane.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createEmptyBorder(10, 0, 0, 0),
      BorderFactory.createTitledBorder("New Attribute Set")));

    // The lists pane
    JPanel listPane = new JPanel();
    listPane.setLayout(new GridBagLayout());

    JLabel asetsLabel = new JLabel("Attribute Sets:");
    asetListModel = new DefaultListModel();
    asetList = new JList(asetListModel);
    asetList.addListSelectionListener(this);
    JScrollPane asetListScrollPane = new JScrollPane(asetList);
    asetListScrollPane.setPreferredSize(new Dimension(240, 160));

    JLabel attr2Label = new JLabel("Attributes:");
    attr2ListModel = new DefaultListModel();
    attr2List = new JList(attr2ListModel);
    JScrollPane attr2ListScrollPane = new JScrollPane(attr2List);
    attr2ListScrollPane.setPreferredSize(new Dimension(240,160));

    constraints.insets = new Insets(0, 0, 5, 0);
    addComp(listPane, asetsLabel, 0, 0, 1, 1);
    addComp(listPane, asetListScrollPane, 0, 1, 4, 4);

    constraints.insets = new Insets(0, 10, 5, 0);
    addComp(listPane, attr2Label, 4, 0, 1, 1);
    addComp(listPane, attr2ListScrollPane, 4, 1, 4, 4);

    JPanel middlePane = new JPanel();
    middlePane.setLayout(new BorderLayout());
    middlePane.add(listPane, BorderLayout.CENTER);
    middlePane.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createEmptyBorder(10, 0, 10, 0),
      BorderFactory.createTitledBorder("Existing Attribute Sets")));

    addButton = new JButton("Add");
    addButton.setActionCommand("add");
    addButton.addActionListener(this);

    deleteButton = new JButton("Delete");
    deleteButton.setActionCommand("delete");
    deleteButton.addActionListener(this);

    computeButton = new JButton("Test SAC");
    computeButton.setActionCommand("compute");
    computeButton.addActionListener(this);

    closeButton = new JButton("Close");
    closeButton.setActionCommand("close");
    closeButton.addActionListener(this);

    JPanel lowerPane = new JPanel();
    lowerPane.add(addButton); 
    lowerPane.add(deleteButton); 
    lowerPane.add(computeButton); 
    lowerPane.add(closeButton); 

    JPanel contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(upperPane, BorderLayout.NORTH);
    contentPane.add(middlePane, BorderLayout.CENTER);
    contentPane.add(lowerPane, BorderLayout.SOUTH);

    setContentPane(contentPane);
    getRootPane().setDefaultButton(addButton);
  }

  private void addComp(Container container, Component component, int x, int y, int w, int h) {
    constraints.gridx = x;
    constraints.gridy = y;
    constraints.gridwidth = w;
    constraints.gridheight = h;
    container.add(component, constraints);
  }

  // Returns <name>:<id> for each attribute set.
  private Packet getAsets() {
    try {
      Packet cmd = tool.makeCmd("getAsets");
      Packet res = sslClient.sendReceive(cmd, null);
      if (res.hasError()) {
        JOptionPane.showMessageDialog(this, "Error in getAsets: " + res.getErrorMessage());
        return null;
      }
      return res;
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Exception in getAsets: " + e.getMessage());
      return null;
    }
  }
  
  // This method must be called before making visible this frame.
  // Parameters:
  // sId, sType: if this method is called in order to add an opset to a user
  // attribute or object attribute (called "base node" for the new opset),
  // then sId and sType contain the id and type of the base node. Otherwise
  // (for example if the method is called when you select the "Operation sets..."
  // menu) they are null.
  // sIdToDisplay, sNameToDisplay: the id and name of an opset this method
  // is called on to display. Otherwise null.
  public void prepare() {
    //ArrayList result;

    asetField.setText("");
    asetField.requestFocus();

    attr2ListModel.clear();
    if (attr2Vector == null) attr2Vector = new ArrayList<String>();
    else attr2Vector.clear();
    
    // Get all the attributes.
    Packet res = null;
    try {
      Packet cmd = tool.makeCmd("getUserAttributes");
      res = sslClient.sendReceive(cmd, null);
      if (res.hasError()) {
        JOptionPane.showMessageDialog(tool, "Error in getUserAattributes: " + res.getErrorMessage());
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Exception in getUserAttributes: " + e.getMessage());
      return;
    }
    attrListModel.clear();
    if (attrVector == null) attrVector = new ArrayList<String>();
    else attrVector.clear();

    if (res != null) for (int i = 0; i < res.size(); i++) {
      String sLine = res.getStringValue(i);
      String[] pieces = sLine.split(PmAdmin.PM_FIELD_DELIM);
      int index = PmAdmin.getIndex(attrListModel, pieces[0]);
      attrListModel.add(index, pieces[0]);
      attrVector.add(index, pieces[1]);
    }
    
    // Get the attribute sets.
    asetListModel.clear();
    if (asetVector == null) asetVector = new ArrayList<String>();
    else asetVector.clear();

    res = (Packet)getAsets();
    if (res == null) return;
    for (int i = 0; i < res.size(); i++) {
      String sLine = res.getStringValue(i);
      String[] pieces = sLine.split(PmAdmin.PM_FIELD_DELIM);
      int index = PmAdmin.getIndex(asetListModel, pieces[0]);
      asetListModel.add(index, pieces[0]);
      asetVector.add(index, pieces[1]);
    }
  }
  
  private void close() {
    this.setVisible(false);
  }

  // Test getMaximalSubsets.
  private void compute() {
    int index = asetList.getSelectedIndex();
    if (index < 0) {
      JOptionPane.showMessageDialog(this,
        "Please select an attribute set!");
      return;
    }
    String sAsetId = (String)asetVector.get(index);
    
    // Send the command and let the server test the other conditions.
    Packet res = null;
    try {
      Packet cmd = tool.makeCmd("getMaximalSubsets", sAsetId);
      res = sslClient.sendReceive(cmd, null);
      if (res.hasError()) {
        JOptionPane.showMessageDialog(this, "GetMaximalSubsets: " + res.getErrorMessage());
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(this, "Exception in getMaximalSubsets: " + e.getMessage());
      return;
    }
  }
  
  // Delete an attr from an attr set or an entire attr set.
  // What we delete depends on what is selected.
  // If the attr set and one of its attrs are selected, only the attr is deleted from
  // that attr set.
  // If only the attr set is selected, the attr set will be deleted.
  private void delete() {
    int asetIndex = asetList.getSelectedIndex();
    if (asetIndex < 0) {
      JOptionPane.showMessageDialog(this,
        "Please select an attribute set and optionally an attribute to delete!");
      return;
    }
    String sAsetId = (String)asetVector.get(asetIndex);

    String sAttrName = null;
    String sAttrId = null;
    int attrIndex = attr2List.getSelectedIndex();
    if (attrIndex >= 0) {
      sAttrName = (String)attr2ListModel.get(attrIndex);
      sAttrId = (String)attr2Vector.get(attrIndex);
    }
    
    // Send the command and let the server test the other conditions.
    try {
      Packet cmd = tool.makeCmd("deleteAsetAndAttr", sAsetId,
        (sAttrId == null)? "" : sAttrId,
        (sAttrName == null)? "" : sAttrName);
      Packet res = sslClient.sendReceive(cmd, null);
      if (res.hasError()) {
        JOptionPane.showMessageDialog(this, "Error in deleteAsetAndAttr: " + res.getErrorMessage());
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(this, "Exception in deleteAsetAndAttr: " + e.getMessage());
      return;
    }

    if (attrIndex < 0) {
      asetListModel.removeElementAt(asetIndex);
      asetVector.remove(asetIndex);
      asetList.clearSelection();
      attr2ListModel.clear();
      if (attr2Vector == null) attr2Vector = new ArrayList<String>();
      else attr2Vector.clear();
    } else {
      attr2ListModel.removeElementAt(attrIndex);
      attr2Vector.remove(attrIndex);
      attr2List.clearSelection();
    }
  }

  // Add 1) an attr to an attr set, or 2) add an attr set, or
  // 3) add an attr set and an attr.
  // If the attr set already exists, an attribute must be selected to be added.
  // If the attr set does not exist, you may or may not select an attribute to be
  // added. The attr set will be added together with the selected attribute,
  // if any.
  // Note that the value selected in the attribute list that identifies the
  // attribute to be added has the format: <id>:<name>. Send both of them to
  // the engine.
  private void addAttribute() {
    String sAset = asetField.getText().trim();
    if (sAset.length() == 0) {
      JOptionPane.showMessageDialog(tool, "Please enter an attribute set name!");
      asetField.requestFocus();
      return;
    }

    int index = attrList.getSelectedIndex();
    String sId = null;
    String sName = null;
    if (index >= 0) {
      sName = (String)attrListModel.get(index);
      sId = (String)attrVector.get(index);
      attrList.setSelectedIndex(-1);
    }
    asetField.requestFocus();

    // Send the command and let the server test the other conditions.
    Packet res = null;
    try {
      Packet cmd = tool.makeCmd("addAsetAndAttr", sAset,
        (sId == null)? "" : sId,
        (sName == null)? "" : sName);
      res = sslClient.sendReceive(cmd, null);
      if (res.hasError()) {
        JOptionPane.showMessageDialog(this, "Error in addAsetAndAttr: " + res.getErrorMessage());
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(this, "Exception in addAsetAndAttr: " + e.getMessage());
      return;
    }

    
    // If the add operation is successful, the result contains <name>:<id> of
    // the attrset.
    String sNew = res.getStringValue(0);
    String[] pieces = sNew.split(PmAdmin.PM_FIELD_DELIM);
    
    // Find the attribute set place in the list.
    // Note that a valueChanged event is triggered when you add a new entry
    // to the attr set list. If an entry were selected in that list, then
    // all sort of strange things would happen. That's why we first clear the
    // selection (valueChanged() returns if nothing is selected).
    asetList.clearSelection();
    index = PmAdmin.getIndex(asetListModel, pieces[0]);
    if (!asetListModel.contains(pieces[0])) {
      asetListModel.add(index, pieces[0]);
      asetVector.add(index, pieces[1]);
      asetList.ensureIndexIsVisible(index);
      //asetList.setSelectedIndex(index);
    }
    selectAset(pieces[1]);
  }

  // Select the attr set, but first unselect it to trigger a valueChanged() call.
  // NOTE that clearSelection() also triggers a valueChanged() with a
  // null selection. Thus, we have to test whether the selection is null
  // in valueChanged().
  // Note that the argument sAset contains the <name>:<id>.
  private void selectAset(String sAsetId) {
    int index = asetVector.indexOf(sAsetId);
    if (index < 0) {
      JOptionPane.showMessageDialog(tool, "No such aset to display!");
      return;
    }
    asetList.clearSelection();
    asetList.setSelectedIndex(index);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equalsIgnoreCase("add")) {
      addAttribute();
    } else if (e.getActionCommand().equalsIgnoreCase("refresh")) {
      prepare();
    } else if (e.getActionCommand().equalsIgnoreCase("delete")) {
      delete();
    } else if (e.getActionCommand().equalsIgnoreCase("compute")) {
      compute();
    } else if (e.getActionCommand().equalsIgnoreCase("close")) {
      close();
    }
  }

  // The attr set selected in the attr set list has changed (change is forced even
  // when the attr set already was there but we added some attribute to it).
  // Display all information about it.
  public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting()) return;
    
    // Get the selected value, which can be null.
    int index = asetList.getSelectedIndex();
    if (index < 0) return;
    String sAsetName = (String)asetListModel.get(index);
    String sAsetId = (String)asetVector.get(index);
    asetField.setText(sAsetName);

    // Get all information about this attrset: id, name, attributes
    // in this order.
    Packet res = null;
    try {
      Packet cmd = tool.makeCmd("getAsetInfo", sAsetId);
      res = sslClient.sendReceive(cmd, null);
      if (res.hasError()) {
        JOptionPane.showMessageDialog(this, "Error in getAsetInfo: " + res.getErrorMessage());
        return;
      }
    } catch (Exception exc) {
      exc.printStackTrace();
      JOptionPane.showMessageDialog(this, "Exception in getAsetInfo: " + exc.getMessage());
      return;
    }
    
    attr2ListModel.clear();
    if (attr2Vector == null) attr2Vector = new ArrayList<String>();
    else attr2Vector.clear();
    
    if (res != null) for (int i = 2; i < res.size(); i++) {
      String sLine = res.getStringValue(i);
      String[] pieces = sLine.split(PmAdmin.PM_FIELD_DELIM);
      index = PmAdmin.getIndex(attr2ListModel, pieces[0]);
      attr2ListModel.add(index, pieces[0]);
      attr2Vector.add(index, pieces[1]);
    }
  }
}