/* 
 * Copyright (C) 2001 Cooperative Software Systems, Inc.  <info@coopsoft.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You received a copy of the GNU General Public License
 * along with this software. For more information on GNU, see
 * http://www.gnu.org or write to: the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
 
/**
 * This class was generated by a SmartGuide.
 * 
 */
class FrameWorkThreads extends java.awt.Frame implements java.awt.event.ActionListener, java.awt.event.ItemListener, java.awt.event.WindowListener {
  private java.awt.Button ivjButton1 = null;
  private java.awt.Button ivjButton2 = null;
  private java.awt.Button ivjButton3 = null;
  private java.awt.Label ivjLabel1 = null;
  private java.awt.Label ivjLabel2 = null;
  private java.awt.Label ivjLabel3 = null;
  private java.awt.Label ivjLabel4 = null;
  private java.awt.List ivjList1 = null;
  private java.awt.TextField ivjTextField1 = null;
  private FrameWorkThreads2 ivjFrameWorkThreads2 = null;

/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public FrameWorkThreads() {
  super();
  initialize();
}
/**
 * constructor comment.
 * @param title java.lang.String
 */
public FrameWorkThreads(String title) {
  super(title);
}
/**
 * Method to handle events for the ActionListener interface.
 * @param e java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void actionPerformed(java.awt.event.ActionEvent e) {
  // user code begin {1}
  // user code end
  
  if ((e.getSource() == getButton1()) ) {
    conn5(e);
  }
    
  // user code begin {2}
  // user code end
}
/**
 * conn0:  (window.windowClosing(java.awt.event.WindowEvent) --> dispose())
 * @param arg1 java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void conn0(java.awt.event.WindowEvent arg1) {
  try {
    // user code begin {1}
    // user code end
    this.dispose();
    System.exit(0);
    // user code begin {2}
    // user code end
  } catch (java.lang.Throwable ivjExc) {
    // user code begin {3}
    // user code end
    handleException(ivjExc);
  }
}

/**
 * conn5:  (Button1.action.actionPerformed(java.awt.event.ActionEvent) --> refreshButton(java.awt.TextField, java.awt.List))
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void conn5(java.awt.event.ActionEvent arg1) {
  try {
    // user code begin {1}
        
    ivjLabel4.setText("Processing ...");
    
    // user code end
    getFrameWorkThreads2().refreshButton(getTextField1(), getList1());
    // user code begin {2} 
    
    // the result of this:
    switch (getFrameWorkThreads2().getRefResult()) {
                  
        case 0: ivjLabel4.setText("Connection failure");
                  break;         
        
        case 2: ivjLabel4.setText("Invalid Queue Name");
                  break;                    
        
        case 3: ivjLabel4.setText("Select Thread"); 
                  break;
                  
    } // end-switch         
    
    // user code end
  } catch (java.lang.Throwable ivjExc) {
    // user code begin {3}
    // user code end
    handleException(ivjExc);
  }
}

/**
 * Return the Button1 property value.
 * @return java.awt.Button
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.Button getButton1() {
  if (ivjButton1 == null) {
    try {
      ivjButton1 = new java.awt.Button();
      ivjButton1.setName("Button1");
      ivjButton1.setBounds(370, 57, 111, 30);
      ivjButton1.setLabel("Refresh");
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjButton1;
}

/**
 * Return the Label1 property value.
 * @return java.awt.Label
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.Label getLabel1() {
  if (ivjLabel1 == null) {
    try {
      ivjLabel1 = new java.awt.Label();
      ivjLabel1.setName("Label1");
      ivjLabel1.setText("Queue Name");
      ivjLabel1.setBounds(39, 92, 90, 18);
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjLabel1;
}
/**
 * Return the Label2 property value.
 * @return java.awt.Label
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.Label getLabel2() {
  if (ivjLabel2 == null) {
    try {
      ivjLabel2 = new java.awt.Label();
      ivjLabel2.setName("Label2");
      ivjLabel2.setText("Id, (#_Proc'd) - Status");
      ivjLabel2.setBounds(43, 140, 193, 25);
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjLabel2;
}
/**
 * Return the Label3 property value.
 * @return java.awt.Label
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.Label getLabel3() {
  if (ivjLabel3 == null) {
    try {
      ivjLabel3 = new java.awt.Label();
      ivjLabel3.setName("Label3");
      ivjLabel3.setText("Msg:");
      ivjLabel3.setBounds(10, 317, 30, 32);
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjLabel3;
}
/**
 * Return the Label4 property value.
 * @return java.awt.Label
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.Label getLabel4() {
  if (ivjLabel4 == null) {
    try {
      ivjLabel4 = new java.awt.Label();
      ivjLabel4.setName("Label4");
      ivjLabel4.setText("Enter Queue Name");
      ivjLabel4.setBounds(48, 317, 360, 31);
      ivjLabel4.setForeground(java.awt.SystemColor.textHighlight);
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjLabel4;
}
/**
 * Return the List1 property value.
 * @return java.awt.List
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.List getList1() {
  if (ivjList1 == null) {
    try {
      ivjList1 = new java.awt.List();
      ivjList1.setName("List1");
      ivjList1.setBounds(39, 166, 310, 123);
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjList1;
}
/**
 * Return the TextField1 property value.
 * @return java.awt.TextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.TextField getTextField1() {
  if (ivjTextField1 == null) {
    try {
      ivjTextField1 = new java.awt.TextField();
      ivjTextField1.setName("TextField1");
      ivjTextField1.setFont(new java.awt.Font("dialog", 0, 14));
      ivjTextField1.setBounds(39, 60, 125, 30);
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjTextField1;
}
/**
 * Return the FrameWorkThreads2 property value.
 * @return TyQueThdBean
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private FrameWorkThreads2 getFrameWorkThreads2() {
  if (ivjFrameWorkThreads2 == null) {
    try {
      ivjFrameWorkThreads2 = new FrameWorkThreads2();
      // user code begin {1}
      // user code end
    } catch (java.lang.Throwable ivjExc) {
      // user code begin {2}
      // user code end
      handleException(ivjExc);
    }
  };
  return ivjFrameWorkThreads2;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(Throwable exception) {

  /* Uncomment the following lines to print uncaught exceptions to stdout */
   System.out.println("--------- UNCAUGHT EXCEPTION ---------");
   exception.printStackTrace(System.out);
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() {
  // user code begin {1}
  // user code end
  this.addWindowListener(this);
  getList1().addItemListener(this); 
  getButton1().addActionListener(this); 
}
/**
 * Initialize class
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
  // user code begin {1}
  // user code end
  setName("FrameWorkThreads");
  setLayout(null);
  setSize(519, 372);
  setTitle("Queue Threads Data");
  add(getTextField1(), getTextField1().getName());
  add(getList1(), getList1().getName());
  add(getLabel1(), getLabel1().getName());
  add(getLabel2(), getLabel2().getName());
  add(getLabel3(), getLabel3().getName());
  add(getLabel4(), getLabel4().getName());
  add(getButton1(), getButton1().getName());
  initConnections();
  // user code begin {2}
  // user code end
}

/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
  try {
    FrameWorkThreads aFrameWorkThreads = new FrameWorkThreads();
    aFrameWorkThreads.setVisible(true);
  } catch (Throwable exception) {
    System.err.println("Exception occurred in main() of java.awt.Frame");
  }
}
/**
 * Method to handle events for the ItemListener interface.
 * @param e java.awt.event.ItemEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void itemStateChanged(java.awt.event.ItemEvent e) {
  // user code begin {1}
  // user code end  
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowActivated(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowClosed(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowClosing(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  if ((e.getSource() == this) ) {
    conn0(e);
  }
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowDeactivated(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowDeiconified(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowIconified(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  // user code begin {2}
  // user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowOpened(java.awt.event.WindowEvent e) {
  // user code begin {1}
  // user code end
  // user code begin {2}
  // user code end
}
} // end-class
