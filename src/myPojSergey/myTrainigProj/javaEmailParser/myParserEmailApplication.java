package myPojSergey.myTrainigProj.javaEmailParser;
//import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import myPojSergey.myTrainigProj.javaEmailParser.ParserSwingWorker.Mode;
//import sun.net.www.content.text.plain;

import javax.swing.JList;
import javax.swing.JScrollPane;
//import javax.swing.SwingWorker;
//import javax.swing.SwingWorker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
//import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
//import java.util.Collection;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.List;
//import java.util.Iterator;
//import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.ScrollPaneConstants;
//import java.awt.event.ItemListener;
//import java.awt.event.ItemEvent;
//import myPojSergey.myTrainigProj.javaEmailParser.Parser;
//import myPojSergey.myTrainigProj.javaEmailParser.Parser.InBetweenSwingWorkerFather;
//import myPojSergey.myTrainigProj.javaEmailParser.HTMLLinkExtractor;
//import myPojSergey.myTrainigProj.javaEmailParser.ParserWithinSite;
//import myPojSergey.myTrainigProj.javaEmailParser.ParserSwingWorker;
import javax.swing.JTextArea;
//import javax.swing.JInternalFrame;
//import javax.swing.JToolBar;
//import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;
//import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRootPane;
import javax.swing.JCheckBox;
//import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ItemListener;
//import java.beans.PropertyVetoException;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStreamWriter;
//import java.io.PrintStream;
import java.io.PrintWriter;
import java.awt.event.ItemEvent;
//import java.awt.FlowLayout;
//import java.awt.Image;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
//import javax.swing.JPanel;
//import javax.swing.JTabbedPane;;
//import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;




public class myParserEmailApplication implements ActionListener {	
	
	
	//private JFrame f = new JFrame("Colors");
    //private static final String ITEMS[] = {" black ", " blue ", " green ",
    //    " orange ", " purple ", " red ", " white ", " yellow "};
	final static private int MIN_DEPTH = 0;
	private  final String URL_VALIDATION_PATTERN = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private Mode mode = Mode.NORMAL;
	private int depthValue =  MIN_DEPTH ;
	private boolean flagWithinSite = false;
	boolean flagMode;
	private static boolean finish = false;	
	private ExecutorService threads;
	
	private JButton buttonStart;
	private JLabel valueCounter;
	private JProgressBar progressBar;
	//SwingWorker threadStop;
	private JTextArea textAreaInfoWork;
	//private ParserSwingWorker parserThred;
	//InBetween mediator;
	private JFrame frmEmailParserBy;
	private JTextField textField;
	private	JMenu		menuFile;
	private	JMenuItem	menuFileSave;
	private	JMenuItem	menuFileExit;
	private JMenuItem  menuAboutApp;
	JList<String> jListOfEmails;
	
	@SuppressWarnings("rawtypes")
	private List<Future> tasks;
	private List <ExecutorService> listToStopExecutes;
	//private JFileChooser fileChooser;
	//private String fileName = "JEditorPane.txt";
	private DefaultListModel<String> listModelOfEmails ;

	//private	JMenuItem	menuPropertySystem;
	//private	JMenuItem	menuPropertyEditor;
	//private	JMenuItem	menuPropertyDisplay;
	//private	JMenu		menuEdit;
	//private	JMenuItem	menuFileNew;
	//private	JMenuItem	menuFileOpen;
	//private	JMenuItem	menuFileSaveAs;
	//private final int	ITEM_PLAIN	=	0;	// Item types
	//private final int	ITEM_CHECK	=	1;
	//private final int	ITEM_RADIO	=	2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				System.setProperty(
			            "Quaqua.tabLayoutPolicy","wrap"
			         );
				try {
					UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
					
					} catch (Exception e) {
					}
				myParserEmailApplication MF = new myParserEmailApplication();
					//MF.frame.setSize(647, 410);
					MF.frmEmailParserBy.setLocationRelativeTo(null);
					MF.frmEmailParserBy.setVisible(true);
					MF.frmEmailParserBy.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
					MF.frmEmailParserBy.getRootPane().setFont(UIManager.getFont("SystemFont"));
					MF.frmEmailParserBy.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
					MF.frmEmailParserBy.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.FALSE);
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
				/*try {
					myParserEmailApplication window = new myParserEmailApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		});
	}
	
	
	
	
	/**
	 * Create the application.
	 */
	public myParserEmailApplication() {
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			
		frmEmailParserBy = new JFrame();
		frmEmailParserBy.setFont(new Font("Dialog", Font.PLAIN, 7));
		frmEmailParserBy.setTitle("Email Parser App by sergeyburlaka1988@gmail.com");
		frmEmailParserBy.setBounds(100, 100, 564, 407);
		frmEmailParserBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmailParserBy.getContentPane().setLayout(null);
		
		final JInternalFrame internalFrameAppInfo = new JInternalFrame("About app");
		internalFrameAppInfo.getContentPane().setBackground(Color.WHITE);
		internalFrameAppInfo.setVisible(false);
		internalFrameAppInfo.setEnabled(true);
		internalFrameAppInfo.setClosable(true);
		
		internalFrameAppInfo.setBounds(161, 50, 309, 191);
		frmEmailParserBy.getContentPane().add(internalFrameAppInfo);
		
		JLabel lblNewLabel_1 = new JLabel("Email Parser App");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("created by:");
		
		JLabel lblNewLabel_3 = new JLabel("Burlaka Sergey (sergeybyrlaka1988@gmail.com)");
		
		JLabel lblNewLabel_5 = new JLabel("in October - November 2015.");
		GroupLayout groupLayout = new GroupLayout(internalFrameAppInfo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3)))
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addGap(11)
					.addComponent(lblNewLabel_5)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		internalFrameAppInfo.getContentPane().setLayout(groupLayout);
		
		
		JLabel lblNewLabel = new JLabel("Put your target url");
		lblNewLabel.setBounds(10, 16, 122, 23);
		frmEmailParserBy.getContentPane().add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(127, 11, 405, 28);
		frmEmailParserBy.getContentPane().add(textField);
		textField.setColumns(10);
	
		
		buttonStart = new JButton("OK");
		buttonStart.setForeground(Color.BLUE);
		buttonStart.setBounds(345, 50, 82, 32);
		buttonStart.addActionListener(this);
		frmEmailParserBy.getContentPane().add(buttonStart);
		
		// "Within site" 
		
		JCheckBox rdbtnNewRadioButton = new JCheckBox("only within a site");
		rdbtnNewRadioButton.setBounds(185, 46, 141, 23);
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//JRadioButton button = (JRadioButton) e.getSource();
		        // Set enabled based on button text (you can use whatever text you prefer)
		        if (e.getStateChange() == ItemEvent.SELECTED){
		        	flagWithinSite = true;
		        }else if (e.getStateChange() == ItemEvent.DESELECTED) {
		        	flagWithinSite = false;  
		        }	
			}
		});
		frmEmailParserBy.getContentPane().add(rdbtnNewRadioButton);
		
		
		JComboBox<String> comboBoxSelectDepth = new JComboBox<String>( );
		comboBoxSelectDepth.setBounds(135, 50, 44, 23);
		comboBoxSelectDepth.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboBoxSelectDepth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				String currentQuantity = (String)combo.getSelectedItem();
				depthValue = Integer.valueOf(currentQuantity);
			}
		});
		frmEmailParserBy.getContentPane().add(comboBoxSelectDepth);
		
		// "set depth " 
		 
		JLabel lblSelectDepth = new JLabel("Select depth ");
		lblSelectDepth.setBounds(54, 49, 97, 23);
		lblSelectDepth.setVerticalAlignment(SwingConstants.BOTTOM);
		frmEmailParserBy.getContentPane().add(lblSelectDepth);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 93, 497, 70);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmEmailParserBy.getContentPane().add(scrollPane);
		textAreaInfoWork = new JTextArea();
		scrollPane.setViewportView(textAreaInfoWork);
		//listModelGetHost = new DefaultListModel();
		listModelOfEmails = new DefaultListModel<String>(); 
		
		 
		JButton buttonStop = new JButton("complete");
		buttonStop.setForeground(Color.RED);
		buttonStop.setBounds(435, 50, 97, 32);
		buttonStop.addActionListener(new ActionListener() {
			//@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
				//int count = 5;
				//threads.shutdownNow();
				JOptionPane.showMessageDialog(frmEmailParserBy, "Stopping Operation, Please Wait.");
				InnerParserSwingWorker.stop = true;
				buttonStart.setEnabled(true);
				textField.setText( "Don't Thank Me for My Service!");
				threads.shutdownNow();		
				if (mode.equals(Mode.RESOURCE_INTENSIVE)){
				/*while ( count >0){
				for (ExecutorService execute : listToStopExecutes)
					execute.shutdownNow();
				//buttonStart.setEnabled(true);
				count--;
				}*/
				} 
				/*try {
				    Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				    }*/
				//threadStop.cancel(true);
				//parserThred.cancel(true);
			/*	for (SwingWorker thread : InnerParserSwingWorker.listOfThreads)	{	
					ThreadInfo.append( thread.toString());
					ThreadInfo.append("\n");
					thread.cancel(true);
				} */
				//JOptionPane.showMessageDialog(frame, "The process stopped working!");
				
			/*	for(Thread thread : listOfThreads)
				{
				   if (thread.isAlive())
					thread.stop();
				}    
				JOptionPane.showMessageDialog(frame, "The process stopped working!");
				System.out.println("Обрыв потоков");  */
			}
			}
		);
		frmEmailParserBy.getContentPane().add(buttonStop);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(133, 209, 260, 111);
		frmEmailParserBy.getContentPane().add(scrollPane_1);
	
		   
		jListOfEmails = new JList<String>( listModelOfEmails);
		scrollPane_1.setViewportView(jListOfEmails);
	
		 
		progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.BLUE);
		progressBar.setBounds(92, 184, 335, 14);
		progressBar.setStringPainted(true);
		//  progressBar.setMinimum(0);
		//  progressBar.setMaximum(100);
		frmEmailParserBy.getContentPane().add(progressBar);
		
		
		JCheckBox chckbxSekect = new JCheckBox("resource-intensive mode");
		chckbxSekect.setBounds(185, 72, 167, 19);
		chckbxSekect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            //do something...
					JOptionPane.showMessageDialog(frmEmailParserBy, "Does not work successfully on an old low-powered PCs.");
					mode = Mode.RESOURCE_INTENSIVE;
		        } else {//checkbox has been deselected
		            //do something...
		        	mode = Mode.NORMAL;
		        };
			}
		});
		
		
		valueCounter = new JLabel("");
		valueCounter.setBounds(35, 164, 509, 23);
		frmEmailParserBy.getContentPane().add(valueCounter);
		frmEmailParserBy.getContentPane().add(chckbxSekect);
		
		JButton btnClear = new JButton("clear");
		btnClear.setForeground(Color.RED);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModelOfEmails.clear();
				textAreaInfoWork.setText("");
				textField.setText("");
			}
		});
		btnClear.setBounds(443, 209, 89, 32);
		frmEmailParserBy.getContentPane().add(btnClear);
		/*try {
			internalFrameAppInfo.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		JMenuBar menuBar = new JMenuBar();
		frmEmailParserBy.setJMenuBar(menuBar);
		
	//	JMenu menuProperty = new JMenu("Properties");
	//	menuBar.add(menuProperty);
		
	//	menuProperty.setMnemonic( 'P' );

	/*	// Create property items
		menuPropertySystem = CreateMenuItem( menuProperty, ITEM_PLAIN,
								"System...", null, 'S', null );
		menuPropertyEditor = CreateMenuItem( menuProperty, ITEM_PLAIN,
								"Editor...", null, 'E', null );
		menuPropertyDisplay = CreateMenuItem( menuProperty, ITEM_PLAIN,
								"Display...", null, 'D', null ); */
		
		
		
		
		
		menuFile = new JMenu( "File" );
		menuFile.setMnemonic( 'F' );
		menuBar.add( menuFile );
		// Create the file menu
		// Build a file menu items
	//	menuFileNew = CreateMenuItem( menuFile, ITEM_PLAIN,
	//							"New", null, 'N', null );
	//	menuFileOpen = CreateMenuItem( menuFile, ITEM_PLAIN, "Open...",
	//							new ImageIcon( "open.gif" ), 'O',
	//							"Open a new file" );
		
	
		
		menuFileSave = CreateMenuItem( menuFile, "Save emails",
				new ImageIcon(this.getClass().getResource( "/save.gif")), 'S',
								" Save as file.txt" );
		
		
		menuFileSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    JFileChooser chooser = new JFileChooser();
			    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
			    
	
			    
			    chooser.setCurrentDirectory(new File(".txt"));
			    //int returnVal = fc.showOpenDialog(frame);
			    try {
			    int code = chooser.showSaveDialog(frmEmailParserBy);
		        if (code == JFileChooser.CANCEL_OPTION)return;
		        	//Login.is.sendFile(chooser.getSelectedFile(), Login.username,label_1.getText());
		        	File selectedFile = chooser.getSelectedFile();
		          // fileName = selectedFile.getName();
		        	
		       
		        	
		         try{
		        	  //File fileTwo=new File("filetwo.txt");
		        	  FileOutputStream fos=new FileOutputStream(selectedFile);
		        	  PrintWriter pw=new PrintWriter(fos);
		        	     /*   for(Entry<URL, String> m :InnerParserSwingWorker.uniqEmailsURLsList.entrySet()){
		        	            //pw.println(m.getKey()+"="+m.getValue());
		        	        	pw.println("Extract e-mail: \""+m.getValue()+ "\" from ---> \"" +m.getKey()+"\"");
		        	        }*/
		        	   for (String name: InnerParserSwingWorker.uniqEmailsURLsList.keySet()){
		        		   String key =name.toString();
		        	       String value = InnerParserSwingWorker.uniqEmailsURLsList.get(name).toString();  
		        	       // System.out.println(key + " " + value);
		        	       pw.println("Extract e-mail: "+key+ " ---->" +value);
		        	} 
		        	        pw.flush();
		        	        pw.close();
		        	        fos.close();
		        		}catch(Exception e){}
		         /*  ObjectOutputStream s = new ObjectOutputStream(fos);
		          s.writeObject( InnerParserSwingWorker.listOfUniqueURL);
		          s.close(); */
		           //OutputStreamWriter out = 
		           //   new OutputStreamWriter(fos, Charset.forName("UTF-8"));
		          /* PrintStream outPrintStream = new PrintStream (fos); 
		           Iterator hashSetIterator =InnerParserSwingWorker.listOfUniqueURL.iterator();
		           while(hashSetIterator.hasNext()){
		        	   outPrintStream.println(hashSetIterator.next());
		        	}
		           fos.close();*/
		        
		        } catch (Exception f) {
		         	 f.printStackTrace();
		        }
				}
			});
		
		//menuFileSaveAs = CreateMenuItem( menuFile, ITEM_PLAIN,
		//						"Save As...", null, 'A',
		//						"Save this data to a new file" );
		// Add the property menu
		//menuFile.addSeparator();
		//menuFile.add( menuProperty );	
		
		
		menuFile.addSeparator();
		menuFileExit = CreateMenuItem( menuFile,
								"Exit", null, 'x',
								"Exit the program" );
		menuFileExit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        System.exit(0);
		    }
		});
		//fileChooser = new JFileChooser();
		
		
		
			JMenu menuHelp = new JMenu("Help");
			menuHelp.setMnemonic('H');
			menuBar.add(menuHelp);
			menuAboutApp = CreateMenuItem(menuHelp, "About app...", null, 'A', null);
			menuAboutApp.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		          
		    	internalFrameAppInfo.setVisible(true);
		    	 
					//"Email Parser was Created by Burlaka Sergey. My email: serge882biz@i.ua ") ;
		    	
		    }
		});
	}

	
	
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//GetElement getE;
		//mediator = new InBetween();	
		//Parser parseHTML;
		String myURL = textField.getText();	
	
		
		
		if (! Pattern.matches(URL_VALIDATION_PATTERN, myURL)){
			textField.setText(""); 		
			JOptionPane.showMessageDialog(frmEmailParserBy, "Invalid value. Please input the right URL.");
			return;}
		
		//if ( threadStop.isDone()){JOptionPane.showMessageDialog(frame, "It has not finished yet. Please, set stop"); return;}
		
		
		
		InnerParserSwingWorker.counter = 0;
		InnerParserSwingWorker.counterDone = 0;
		progressBar.setValue(0);	
		finish = false;
		InnerParserSwingWorker.uniqEmailsURLsList = new HashMap <>();
		
	
		
		if (!InnerParserSwingWorker.getListOfUniqueURL().isEmpty()) InnerParserSwingWorker.setListOfUniqueURL(new HashSet<String>()); 
		textField.setText(""); 
		buttonStart.setEnabled(false);
		threads = Executors.newFixedThreadPool(15); 
		//tasks = new ArrayList<Future>(); 
		tasks = new LinkedList<Future>(); 
		//ParserWithinSite.setUniqURL(new HashSet<URL>());
		// HTMLLinkExtractor.setUniqueListEmails(new HashMap< URL,String>());
		InnerParserSwingWorker.stop = false;
		listToStopExecutes = new LinkedList<>();
		
		
		
		if (flagWithinSite){
			textField.setText("I am parsing only within site.");
			ParserWithinSite.setOtherURLs(new HashSet<URL>());
			ParserWithinSite.setUniqURL( new HashSet<URL>());
			try {
				tasks.add(( threads).submit(new ParserWithinSite( this, new URL(myURL), depthValue,mode, threads,tasks)));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return;
		}
		
		
		 try {
			tasks.add(( threads).submit(new InnerParserSwingWorker(new URL(myURL), depthValue,mode)));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 textField.setText("I am parsing...");
		/*try {
			parserThred = new InnerParserSwingWorker(new URL(myURL), depthValue);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		parserThred.execute();*/   
		// mediator.execute();
		/*
		try {
				parseHTML =(!flagWithinSite)? new Parser(new URL(myURL), depthValue, listModel):new ParserWithinSite (new URL (myURL), depthValue,listModel);
				parseHTML.ParseEmail();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		 */	
	
	//textField.setEnabled(false);
	
	} 
	
	
		
	@SuppressWarnings("rawtypes")
	public boolean IsFinish () {
		/*try {
		    Thread.sleep(10);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}*/
		if (finish==true) return true;
		for (Future task : tasks ){
			if (!task.isDone()) return false;
		}
		//threads.shutdown();
		try {
		    System.out.println("attempt to shutdown executor");
		    threads.shutdown();
		    threads.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!threads.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    threads.shutdownNow();
		    System.out.println("shutdown finished");
		}
		finish=true;
		textField.setText( "Don't Thank Me for My Service!");
		buttonStart.setEnabled(true);
			JOptionPane.showMessageDialog(frmEmailParserBy, "I have finished.");
		return true;
	}
	
	
/*	menuFileSave = CreateMenuItem( menuFile, ITEM_PLAIN, "Save in file",
			new ImageIcon( "save.gif" ), 'S',
			" Save this file" );*/

/*	menuFileExit = CreateMenuItem( menuFile, ITEM_PLAIN,
			"Exit", null, 'x',
			"Exit the program" );*/
	
	
	
	public JMenuItem CreateMenuItem( JMenu menu, String sText,
			ImageIcon image, int acceleratorKey,
			String sToolTip )
	{
		// Create the item
		JMenuItem menuItem;

		/*switch( iType )
		{
		case ITEM_RADIO:
		menuItem = new JRadioButtonMenuItem();
		break;

		case ITEM_CHECK:
		menuItem = new JCheckBoxMenuItem();
		break;

		default:
		menuItem = new JMenuItem();
		break;
		} */
		menuItem = new JMenuItem();
		// Add the item test
		menuItem.setText( sText );

		// Add the optional icon
		if( image != null )
			menuItem.setIcon( image );

		// Add the accelerator key
		if( acceleratorKey > 0 )
			menuItem.setMnemonic( acceleratorKey );

		// Add the optional tool tip text
		if( sToolTip != null )
			menuItem.setToolTipText( sToolTip );

		// Add an action handler to this menu item
		menu.add( menuItem );

		return menuItem;
	}

	
	
	
	

	//Read more: http://mrbool.com/how-to-create-a-form-and-simple-frame-with-java-swing/25408#ixzz3qUEU32BX
	
	
	
	
	
	 class InnerParserSwingWorker  extends  ParserSwingWorker {
		ArrayList< String> getEmails;		 
		
		InnerParserSwingWorker(URL url, int depth, Mode mode) {
		super(url, depth, mode);
		// TODO Auto-generated constructor stub
	}

			
	@Override
	protected List<String> doInBackground() throws Exception {		
			
		if(stop) return getEmails; 
		//if (isCancelled())return getEmails;
		
		
		publish("Working with --->"+startUrl+".");
		HTMLLinkExtractor linkExtra = new HTMLLinkExtractor(ReadFromUrl(), startUrl);	
		getEmails = linkExtra.getGetNewEmails (); 
		URLsList = linkExtra.grabHTMLLinks();  
		uniqEmailsURLsList  = HTMLLinkExtractor.getUniqueListEmails();	
		if(stop) return getEmails; 
		
		
		
		for (String email : getEmails)
	    publish(
	    		"#---> Get next email: "+email+"\n"
	    		+"#---> From "+startUrl+"\n"
	    		+"#---> PLEASE DON'T THANK ME!"
	    		);
		
		linkInfo = startUrl.getHost();
		//publish(linkInfo);
		//if (depth == 0  ) return getEmails;
		if (depth == 0 | stop ) return getEmails;
		//counter+=URLsList.size();
		fillListURLs(); 
		counter += URLsFirstWebsite.size();
		getListOfUniqueURL().add(linkInfo); 	
		if(stop) return getEmails; 
		parseNextURLs();	
		return getEmails;
	}
	
	
	
	
	@Override
    protected void process(List<String> chunks) {
        for (String line : chunks) {
        	if(stop) break;
        	textAreaInfoWork.append(line);
        	textAreaInfoWork.append("\n");
        	// textArea.append("\n");  
        }
        //progressBar.setValue ();
      //  ui.setProgress(getProgress());
    }	
		
	
	
	
	@Override
    protected void done() {
      // ui.stopLoading();
		
        textAreaInfoWork.append( "Finished with -x-"+startUrl);
        textAreaInfoWork.append("\n");
       // textArea.append("\n");
       // textArea.append(" ");
        for (String email : getEmails){
    		//publish(" "+email+" ");
        	listModelOfEmails.addElement(email);
        }
        	counterDone++;
        	progressBar.setValue( (int) ((counterDone/counter)*100)); 
        	valueCounter.setText("Want to parse: " +Integer.toString((int) counter)+" pages. "
        						+Integer.toString((int)counterDone)+" pages have finished parsing. "
        						+"My current depth is "+depth+".");
        	//if (mode.equals(Mode.RESOURCE_INTENSIVE))threads.shutdown();
        	IsFinish();
	}
	
	
	
	
	public void parseNextURLs (){
		if(!URLsFirstWebsite.isEmpty()){				
		
		if (mode.equals(Mode.RESOURCE_INTENSIVE)){	
			threads.shutdown();
			threads = Executors.newFixedThreadPool(30);
			listToStopExecutes.add(threads);
		}
			//	tasks = new ArrayList<Future>(); 
			for (URL lnk : URLsFirstWebsite){
				if(stop) break;
				tasks.add(( threads).submit(new InnerParserSwingWorker(lnk, depth-1,mode)));
			/*	 nextParser = new InnerParserSwingWorker(lnk, depth-1);
				//threadStop = nextParser;
				//listOfThreads.add(parserThred);
				//swingThreads.add(nextParser);
				if(stop) break;
				nextParser.execute(); */ 
				//ParseMainLinks parseFirstSite = new ParseMainLinks(lnk, depth-1,listModel);
				//getThreads().add(parseFirstSite);
				//parseFirstSite.start();
			}
		}
	}
	//public enum GetElement {
	//	EMAIL, WORK_INFO;
		
	//}
	 } 
	}