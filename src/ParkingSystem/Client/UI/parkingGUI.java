package ParkingSystem.Client.UI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import ParkingSystem.Common.IparkingSytemManager;
import ParkingSystem.Entities.EntryGate;
import ParkingSystem.Entities.GateStatus;
import ParkingSystem.Entities.ParkingStatus;
import ParkingSystem.Entities.ReportType;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Entities.TicketStatus;
import ParkingSystem.controller.ParkingSystemManager;

public class parkingGUI extends JFrame {

	javax.swing.JButton btnReport;
	java.awt.Choice choiseReport;

	public javax.swing.JButton buttonPrintTicket;
	javax.swing.JButton buttonPayment;
	javax.swing.JButton buttonExit;
	javax.swing.JButton buttonOpenGate;
	javax.swing.JButton buttonClosegate;
	javax.swing.JButton buttonFarecalc;
	javax.swing.JLabel jLabel1;
	javax.swing.JTextField jTextField1;
	javax.swing.JTextField jTextField2;
	public javax.swing.JTextField jTextField3;
	javax.swing.JLabel jLabel3;
	javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel4;
	javax.swing.JLabel jLabel5;
	javax.swing.JLabel jLabel6;
	javax.swing.JLabel jLabel7;
	javax.swing.JLabel jLabel8;
	javax.swing.JLabel jLabel9;
	javax.swing.JLabel jLabel10;
	javax.swing.JLabel jLabel11;
	javax.swing.JLabel jLabel12;
	javax.swing.JLabel jLabel14;
	javax.swing.JLabel jLabel15;
	public javax.swing.JTextField jTextField4;
	public javax.swing.JTextField jTextField5;
	public javax.swing.JTextField jTextField6;
	public javax.swing.JTextField jTextField7;
	javax.swing.JLabel jLabel13;
	javax.swing.JTextField jTextField8;
	javax.swing.JTextField jTextField9;
	public javax.swing.JTextField jTextField10;
	public javax.swing.JTextField jTextField11;
	public javax.swing.JTextField jTextField12;
	java.awt.Label label1;
	java.awt.Label label2;
	java.awt.Label label3;
	java.awt.Label label4;
	public java.awt.Label label5;
	java.awt.Label label6;
	javax.swing.JButton buttonGate1;

	javax.swing.JButton buttonGate2;
	javax.swing.JButton buttonGate3;

	public java.awt.Choice choice1;

	ParkingSystemManager parkingManager  = null;// new ParkingSystemManager();

	private void openGateActionPerformed(java.awt.event.ActionEvent evt) {

		try {

			if (parkingManager.ticket.getTicektStatus() == TicketStatus.Active) {
				parkingManager.getGatemanagement().gate = parkingManager.getGatemanagement()
						.OpenEntryGate(parkingManager.getGatemanagement().gate.GateId);

				// added for fraud prevention check
				parkingManager.getFraudManager().ticketgatecollection.put(parkingManager.ticket,
						parkingManager.getGatemanagement().gate);

				jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());

				if (parkingManager.getGatemanagement().gate.gateStatus == GateStatus.Open) {
					// objticketmanager.getGatemanagement().gate =
					// objticketmanager.getGatemanagement().closeEntryGate(objticketmanager.getGatemanagement().gate.GateId);
					parkingManager.getGatemanagement().closeEntryGate(
							parkingManager.getGatemanagement().gate.GateId);
				}
				jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());

			} else {
				jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
			}
		} catch (Exception ex) {

		}

	}

	private void closeGateActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			parkingManager.getGatemanagement().closeEntryGate(
					parkingManager.getGatemanagement().gate.GateId);
		} catch (Exception ex) {

		}
	}

	private void entrygateClosingActionPerformed(java.awt.event.ActionEvent evt) {

		try {

			if (parkingManager.getGatemanagement().gate.gateStatus == GateStatus.Open) {
				parkingManager.getGatemanagement().closeEntryGate(
						parkingManager.getGatemanagement().gate.GateId);

				// ticket with gate movement is added in collection to check
				// fraud
				// activity

				parkingManager.getFraudManager().ticketgatecollection.put(parkingManager.ticket,
						parkingManager.getGatemanagement().gate);

				jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
			}
		} catch (Exception ex) {

		}
	}

	private void exitActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			UUID ticketID = null;

			try {
				ticketID = UUID.fromString(choice1.getSelectedItem());
			} catch (Exception ex) {

			}

			Status exitStatus = parkingManager.processExitFor(ticketID);
			JOptionPane.showMessageDialog(null, exitStatus.getMessage());

			if (exitStatus.getStatus()) {
				jTextField10.setText(parkingManager.ticket.getTicketID().toString());
				jTextField11.setText(parkingManager.ticket.getTicektStatus().toString());
				jTextField12.setText(parkingManager.ticket.getEntryTime().toString());
			}

			parkingManager.getFraudManager().checkentryExitOperation();

			label5.setText(String.valueOf(parkingManager.getOccupancy().currentParkingOccupancy));
			// Gate g=objticketmanager.gatemanagement.ExitGate(1);

			if (parkingManager.getOccupancy().isParkingfull()) {
				buttonPrintTicket.setVisible(false);
			} else {

				buttonPrintTicket.setVisible(true);
				jTextField2.setText(ParkingStatus.Open.toString());

			}
		} catch (Exception ex) {

		}

	}

	public void paymentActionPerformed(ActionEvent evt) {
		try {
			ArrayList<String> error = new ArrayList<String>();

			String regex = "\\d+";
			Boolean validentry = false;

			if (jTextField4.getText().length() > 0)

			{
				if (jTextField4.getText().length() > 16 || jTextField4.getText().length() < 16) {
					JOptionPane.showMessageDialog(null, "Please enter valid card number");
					error.add("Please enter valid card number");
				}

				boolean validate = jTextField4.getText().matches("[0-9]+");
				;

				if (!validate) {
					JOptionPane.showMessageDialog(null, "Please enter Numeric values only.");
					error.add("Please enter Numeric values only.");
					validentry = false;

				} else

				{
					validentry = true;

				}

			}

			else {
				JOptionPane.showMessageDialog(null, "Credit number is required");
				error.add("Credit number is required");
				validentry = false;
			}
			// JOptionPane.showMessageDialog(null,
			// "My Goodness, this is a pay");

			if (jTextField7.toString().length() > 0) {
				boolean validate = jTextField7.getText().matches("[0-9]+");
				;

				if (!validate) {
					error.add("Please enter Numeric values only.");
					JOptionPane.showMessageDialog(null, "Please enter Numeric values only.");

				} else {
					if (jTextField7.getText().length() > 3 || (jTextField7.getText().length() < 3)) {
						error.add("Entered cvv is incorrect.");
						JOptionPane.showMessageDialog(null, "Entered cvv is incorrect.");
						validentry = false;
					} else
						validentry = true;
				}

			}

			else {
				validentry = false;
				error.add("Entered cvv is incorrect.");
				JOptionPane.showMessageDialog(null, "Please enter cvv.");
			}

			if (jTextField6.toString().length() > 0) {
				Calendar cal = Calendar.getInstance();

				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);

				String entermonth[] = new String[2];

				try {
					String string = jTextField6.getText().toString();
					String[] parts = string.split("/");

					if (entermonth.length > 0) {
						int entedmonth = Integer.parseInt(parts[0]);
						int entedyear = Integer.parseInt(parts[1]);

						if (entedyear < year) {
							validentry = false;
							error.add("Please enter valid month/year.");
							JOptionPane.showMessageDialog(null, "Please enter valid month/year.");
						} else {
							validentry = true;
						}
					} else {
						validentry = false;
						error.add("Please enter the date  in mm/YYYY format.");
						JOptionPane.showMessageDialog(null, "Please enter the date  in mm/YYYY format.");
					}
				} catch (Exception e)

				{
					validentry = false;
					error.add("Please enter valid month/year.");
					JOptionPane.showMessageDialog(null, "Please enter valid month/year.");
				}
			}

			if (validentry && error.size() < 1) {

				parkingManager.getPaymanager().getCreditCard().setCCNumner(jTextField4.getText());
				parkingManager.getPaymanager().getCreditCard().setExpiryDate(jTextField6.getText());
				parkingManager.getPaymanager().getCreditCard()
						.setCvvNumber(Integer.parseInt(jTextField7.getText()));

				double amount = parkingManager.processPayment(parkingManager.ticket, parkingManager
						.getPaymanager().getCreditCard());

				String strAmount = String.valueOf(amount);

				jTextField5.setText(strAmount);
			}
		} catch (Exception ex) {

		}

	}

	public void printTicketActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			if (parkingManager.getOccupancy().isParkingfull()) {
				parkingManager.getGatemanagement().gate.GateId = 0;

				buttonPrintTicket.setVisible(false);
			} else {

				buttonPrintTicket.setVisible(true);

			}

			if ((parkingManager.getGatemanagement().gate.GateId == 1
					|| parkingManager.getGatemanagement().gate.GateId == 2 || parkingManager
					.getGatemanagement().gate.GateId == 3)
					&& (!parkingManager.getOccupancy().isParkingfull())) {
				jLabel4.setText("Printing Ticket...Please Wait");

				parkingManager.printTicketOperation();

				ParkingStatus parkingStatus = parkingManager.getOccupancy().currentparkingStatus();
				jTextField2.setText(parkingStatus.toString());

				jTextField10.setText(parkingManager.ticket.getTicketID().toString());
				jTextField11.setText(parkingManager.ticket.getTicektStatus().toString());
				jTextField12.setText(parkingManager.ticket.getEntryTime().toString());
				jLabel4.setText("Success..Collect the ticket");

				String currentCount = Integer
						.toString(parkingManager.getOccupancy().currentParkingOccupancy);

				label5.setText(currentCount);

				if (parkingManager.ticket.getTicektStatus() == TicketStatus.Active) {
					parkingManager.getGatemanagement().gate = parkingManager.getGatemanagement()
							.OpenEntryGate(parkingManager.getGatemanagement().gate.GateId);

					// added for fraud prevention check
					parkingManager.getFraudManager().ticketgatecollection.put(parkingManager.ticket,
							parkingManager.getGatemanagement().gate);

					JOptionPane.showMessageDialog(null, "Gate is Opened");
					JOptionPane.showMessageDialog(null, "Succesful Entry");

					jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());

					if (parkingManager.getGatemanagement().gate.gateStatus == GateStatus.Open) {

						parkingManager.getGatemanagement().closeEntryGate(
								parkingManager.getGatemanagement().gate.GateId);
						JOptionPane.showMessageDialog(null, "Gate closed");

						parkingManager.getGatemanagement().gate.GateId = 0;
					}

					if (parkingManager.ticket != null
							&& parkingManager.ticket.getTicektStatus() == TicketStatus.Active) {

						choice1.add(parkingManager.ticket.getTicketID().toString());
					}

					else {
						jLabel4.setText("Error...Please Retry");
					}

					jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());

				} else {
					jTextField3.setText(parkingManager.getGatemanagement().gate.gateStatus.toString());
				}
			} else

			{
				JOptionPane.showMessageDialog(null, "please select the entry gate");
			}
		} catch (Exception ex) {

		}

	}

	private void gate1selectionActionPerformed(java.awt.event.ActionEvent evt) {

		parkingManager.getGatemanagement().gate = new EntryGate(1);
		JOptionPane.showMessageDialog(null, "Entry gate 1 is Selected, Please print ticket now");

	}

	private void gate2selectionActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		parkingManager.getGatemanagement().gate = new EntryGate(2);
		JOptionPane.showMessageDialog(null, "Entry gate 2 is Selected, Please print ticket now");

	}

	private void gate3SelectionActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		parkingManager.getGatemanagement().gate = new EntryGate(3);
		JOptionPane.showMessageDialog(null, "Entry gate 3 is Selected, Please print ticket now");

	}

	public void constructTable() {

	}

	private void ReportActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// Report type enum need to be used for replacing integer arg
		try {
			ReportType reportType = null;

			System.out.print(choiseReport.getSelectedItem());

			String choiceSelection = choiseReport.getSelectedItem();

			if (choiceSelection == "Hourly")
				reportType = ReportType.Hourly;
			else if (choiceSelection == "Daily")
				reportType = ReportType.Daily;
			else if (choiceSelection == "Weely")
				reportType = ReportType.Weekly;

			List<Ticket> reportData = parkingManager.getReportManagement().generateReport(reportType);

			String[] columnNames = { "TicketID", "Entry Time ", "Exit Time", "Amount" };

			Object[][] data = new Object[reportData.size()][4];

			for (int i = 0; i < reportData.size(); i++) {
				data[i][0] = reportData.get(i).getTicektID();
				data[i][1] = reportData.get(i).getEntryTime();
				data[i][2] = reportData.get(i).getExitTime();
				data[i][3] = reportData.get(i).getTicketAmount();

			}

			JDialog dialog = new JDialog();
			dialog.setBounds(500, 500, 800, 700);
			dialog.setLayout(new GridLayout());
			dialog.setEnabled(true);
			dialog.setModal(true);

			dialog.getContentPane().add(new JTable(data, columnNames));

			dialog.setVisible(true);

			dialog.show();
		} catch (Exception ex) {

		}
	}

	private void calculatefareActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			if (choice1.getSelectedItem().length() > 25) {
				
				String ticketID=choice1.getSelectedItem();
		        Ticket  ticket=null; 
				for (Ticket t : parkingManager.getTicketmager().getTicketcollection()) {
					if (t.getTicektID().compareTo(UUID.fromString(ticketID)) == 0) {
						ticket = t;
					}
				}
				
				parkingManager.ticket=ticket;
				parkingManager.calculateFare(parkingManager.ticket);

				jTextField5.setText(Double.toString(parkingManager.ticket.getTicketAmount()));
			}
		}
			catch (Exception ex) {

		}
	}

	private void IntiliazeWindows() {

		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField10 = new javax.swing.JTextField();
		jTextField11 = new javax.swing.JTextField();
		jTextField12 = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		buttonPrintTicket = new javax.swing.JButton();
		buttonPayment = new javax.swing.JButton();
		buttonExit = new javax.swing.JButton();
		buttonFarecalc = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		buttonOpenGate = new javax.swing.JButton();
		buttonClosegate = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();

		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		btnReport = new javax.swing.JButton();
		label1 = new java.awt.Label();
		label2 = new java.awt.Label();
		label3 = new java.awt.Label();
		label4 = new java.awt.Label();
		label5 = new java.awt.Label();
		jLabel15 = new javax.swing.JLabel();
		label6 = new java.awt.Label();
		buttonGate1 = new javax.swing.JButton();
		buttonGate2 = new javax.swing.JButton();
		buttonGate3 = new javax.swing.JButton();
		jLabel14 = new javax.swing.JLabel();
		choiseReport = new java.awt.Choice();

		choiseReport.add("Hourly");
		choiseReport.add("Daily");
		choiseReport.add("Weekley");
		choiseReport.add("Monthly");

		choice1 = new java.awt.Choice();

		choice1.add("Select the ticket");

		buttonClosegate.setText("Close Gate");

		buttonClosegate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				entrygateClosingActionPerformed(evt);

			}
		});

		jTextField9.setVisible(false);
		buttonExit.setText("Exit");
		jLabel4.setText("Ticket :");

		jLabel5.setText("Ticket ID");
		jLabel6.setText(" Ticket Status");
		jLabel7.setText("Entry time");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("PlateID");
		jLabel1.setVisible(false);

		jTextField1.setText("jtextnamepalte");
		jTextField1.setToolTipText("");
		jTextField1.setVisible(false);

		jLabel2.setText("Parking Status");

		buttonPrintTicket.setText("Print Ticket");
		buttonPrintTicket.setToolTipText("Print Ticket");

		buttonPrintTicket.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				printTicketActionPerformed(evt);
			}
		});

		buttonPayment.setText("Payment");
		buttonPayment.setToolTipText("");
		buttonPayment.setActionCommand("Pay");
		buttonPayment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				paymentActionPerformed(evt);
			}

		});

		buttonExit.setText("Exit");
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});

		jLabel4.setText("Ticket: ");
		buttonOpenGate.setText("Open Gate");
		buttonOpenGate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openGateActionPerformed(evt);
			}
		});

		buttonClosegate.setText("Close Gate");
		buttonClosegate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// objticketmanager.gateCloseOpeation(this, evt);
				closeGateActionPerformed(evt);
			}
		});

		jLabel8.setText("Gate Status");

		jLabel9.setText("Credit Card Number");

		jLabel10.setText("Amount");
		jLabel10.setToolTipText("");

		jLabel11.setText("Enter Expiry Date (MM/yyyy)");

		jLabel12.setText("CVV");

		jLabel13.setText("Payment Status");

		label1.setText("Status");
		label1.setVisible(false);

		jLabel8.setText("Gate Status");

		label1.setText("Status");

		buttonFarecalc.setText("Calculate Fare");
		buttonFarecalc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calculatefareActionPerformed(evt);
			}
		});

		jTextField10.setText("");

		jTextField11.setText("");

		jTextField12.setText("");

		label2.setText("Exiting ");

		label3.setText("Select TicketID");
		label3.setVisible(false);

		label4.setText("Select TicketID");

		label6.setName(""); // NOI18N
		label6.setText("Parking Count");
		label5.setText("0");
		label5.setFont(new Font("Serif", Font.BOLD, 25));

		label6.setText("Parking Count");

		buttonGate1.setText("Gate1");
		buttonGate1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gate1selectionActionPerformed(evt);
			}
		});

		buttonGate2.setText("Gate2");
		buttonGate2.setToolTipText("");
		buttonGate2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gate2selectionActionPerformed(evt);
			}
		});

		buttonGate3.setText("Gate3");
		buttonGate3.setToolTipText("");
		buttonGate3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gate3SelectionActionPerformed(evt);
			}
		});

		jLabel14.setText("Select gate");
		jLabel14.setToolTipText("");

		jLabel15.setText("Reports");

		btnReport.setText("view Report");
		btnReport.setToolTipText("");
		btnReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ReportActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel10,
														javax.swing.GroupLayout.PREFERRED_SIZE, 107,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel12)
												.addComponent(jLabel13)
												.addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel9)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		label3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		0, Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		label4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		131,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(9, 9, 9)))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						buttonExit,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						103,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						buttonPayment,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						117,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField8,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						226,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						choice1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						293,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						buttonFarecalc,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField9,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField5,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField6,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField7,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						147, Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(jLabel15).addGap(82, 82, 82))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jTextField4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		147,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(btnReport).addGap(47, 47, 47))))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup().addGap(126, 126, 126)
																.addComponent(jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(81, 81, 81)
																.addComponent(
																		jLabel14,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		92,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup().addComponent(jLabel3)
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										buttonOpenGate,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										144,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										buttonClosegate,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										147,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						label2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						230,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField10,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						266,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						237,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																								.addComponent(
																										buttonPrintTicket,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										133,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jTextField1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										125,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(3, 3,
																										3)
																								.addComponent(
																										buttonGate1)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										buttonGate2)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										buttonGate3)))
																.addGap(58, 58, 58)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														jTextField3,
																														javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														javax.swing.GroupLayout.Alignment.LEADING,
																														layout.createSequentialGroup()
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.TRAILING)
																																				.addComponent(
																																						label6,
																																						javax.swing.GroupLayout.Alignment.LEADING,
																																						javax.swing.GroupLayout.PREFERRED_SIZE,
																																						javax.swing.GroupLayout.DEFAULT_SIZE,
																																						javax.swing.GroupLayout.PREFERRED_SIZE)
																																				.addComponent(
																																						jLabel8,
																																						javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(
																																						label5,
																																						javax.swing.GroupLayout.Alignment.LEADING,
																																						javax.swing.GroupLayout.PREFERRED_SIZE,
																																						71,
																																						javax.swing.GroupLayout.PREFERRED_SIZE))
																																.addGap(0,
																																		0,
																																		Short.MAX_VALUE)))
																								.addGap(55,
																										55,
																										55))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel2)
																												.addComponent(
																														jTextField2,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														105,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														choiseReport,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														125,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addContainerGap(
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))))))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(60, 60, 60)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jLabel5,
														javax.swing.GroupLayout.PREFERRED_SIZE, 319,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel6)
																				.addComponent(
																						jLabel7,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						103,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField11,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						186,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField12,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						186,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(15, 15, 15)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						buttonGate1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						30,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						buttonGate2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						30,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						buttonGate3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						30,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel14,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						30,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(buttonPrintTicket)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jLabel4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		16,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(jLabel2)
																.addGap(18, 18, 18)
																.addComponent(
																		jTextField2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
								.addComponent(jLabel3)
								.addGap(5, 5, 5)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel5)
																				.addComponent(
																						jTextField10,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														jLabel6)
																												.addComponent(
																														jTextField11,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														jLabel7)
																												.addComponent(
																														jTextField12,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														buttonOpenGate)
																												.addComponent(
																														buttonClosegate))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										label2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										label5,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addGap(26,
																										26,
																										26)
																								.addComponent(
																										jLabel8)
																								.addGap(28,
																										28,
																										28)
																								.addComponent(
																										jTextField3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		label6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(164, 164, 164)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(choice1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(buttonFarecalc)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						label1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField9,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18, 18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel9)
																				.addComponent(
																						jTextField4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18, 18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel10)
																				.addComponent(
																						jTextField5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18, 18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel11)
																				.addComponent(
																						jTextField6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						20,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel12)
																				.addComponent(
																						jTextField7,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(25, 25, 25)
																.addComponent(buttonPayment)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jTextField8,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel13))
																.addGap(18, 18, 18).addComponent(buttonExit))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(2, 2, 2)
																.addComponent(jLabel15)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		choiseReport,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(19, 19, 19).addComponent(btnReport)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel3.getAccessibleContext().setAccessibleName("lblprintTicket");
		jLabel4.getAccessibleContext().setAccessibleName("lblticketid");
		jLabel5.getAccessibleContext().setAccessibleName("lblticketID");
		jLabel6.getAccessibleContext().setAccessibleName("lblticketInTime");
		jLabel7.getAccessibleContext().setAccessibleName("lblticketStatus");
		

		
//		objticketmanager.getOccupancy().setParkingCapacity(10);
//
//		objticketmanager.getPaymanager().setHourlyRate(11);

		jTextField3.setText(GateStatus.Close.toString());

		ParkingStatus parkingStatus = parkingManager.getOccupancy().currentparkingStatus();
		jTextField2.setText(parkingStatus.toString());

	}
	
	private static int getIntValue(String input, int defaultValue) {
	
		int value = 0;
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			value = defaultValue;
		}
		return value;
	}

	public static void main(String[] args) throws InterruptedException {
		parkingGUI objgui = new parkingGUI();
		
		
		  try {
              try {
            	  
				ParkingSystemManager p = (ParkingSystemManager)
					   Naming.lookup("rmi://" + args[0] + ":" + args[1]  + "/ParkingService");
				objgui.parkingManager=p;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
              System.out.println("ParkingService  is running.....");
              
            
             
            } catch (RemoteException re) {
                System.out.println("RemoteException"); 
                System.out.println(re);
            } catch (NotBoundException nbe) {
                System.out.println("NotBoundException");
                System.out.println(nbe);
            } catch (java.lang.ArithmeticException ae) {
                 System.out.println("java.lang.ArithmeticException");
                 System.out.println(ae);
            }
		
		if(args.length == 2) {
			objgui.parkingManager.getOccupancy().setParkingCapacity(getIntValue(args[0], 10));

			objgui.parkingManager.getPaymanager().setHourlyRate(getIntValue(args[1], 11));
		}
		else
		{
			objgui.parkingManager.getOccupancy().setParkingCapacity(5);

			objgui.parkingManager.getPaymanager().setHourlyRate(11);
			
		}

		// Ensure the gatestatus

		objgui.IntiliazeWindows();

		objgui.setSize(800, 850);//

		objgui.show();
		
	
	}

}
